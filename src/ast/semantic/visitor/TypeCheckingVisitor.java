package ast.semantic.visitor;

import ast.definitions.FuncDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    // set/annotate lvalue attribute for expression nodes to validate the assignments
    // lvalue es lo que puedes poner a la izquierda en un assignment



    // --- expressions

    @Override
    public Void visit(Arithmetic arith, Void param) {

        arith.setLvalue(false);

        // type checking
        arith.setType(arith.getLeft().getType()
                .arithmetic(arith.getLine(), arith.getColumn(), arith.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(Cast c, Void param) {
        c.setLvalue(false);

        // expression1.type = expression2.type.castTo(type)
        c.setType(c.getExpression().getType()
                .castTo(c.getLine(), c.getColumn(), c.getCastType()));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        charLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparison com, Void param) {
        com.setLvalue(false);

        // expression1.type = expression2.type.com(expression3.type)
        com.setType(com.getLeft().getType()
                .comparison(com.getLine(), com.getColumn(), com.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        doubleLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.setLvalue(true);

        // expression1.type = expression2.type.dot(ID)
        fieldAccess.setType(fieldAccess.getExpression().getType()
                .dot(fieldAccess.getLine(), fieldAccess.getColumn(), fieldAccess.getFieldName()));
        return null;
    }

    @Override
    public Void visit(FunctionInvocation fi, Void param) {
        fi.setLvalue(false);

        // expression1.type = expression2.type.parenthesis(
        //	expression*.stream().map(exp -> exp.type).toArray() )
        fi.setType(fi.getVar().getType()
                .parenthesis(fi.getLine(), fi.getColumn(), fi.getParameters()));

        return null;
    }

    // v[3] -> v es una variable (lvalue=true) y 3 es IntLiteral (lvalue=false)
    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.setLvalue(true);

        // expression1.type = expression2.type.squareBrackets(expression3.type)
        indexing.setType(indexing.getLeft().getType()
                        .squareBrackets(indexing.getLine(), indexing.getColumn(), indexing.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        intLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Logical log, Void param) {
        log.setLvalue(false);

        // expression1.type = expression2.type.log(expression3.type)
        log.setType(log.getLeft().getType()
                .logical(log.getLine(), log.getColumn(), log.getRight().getType()));

        return null;
    }

    // a % 3 -> it is arithmetic -> false
    @Override
    public Void visit(Modulus mod, Void param) {
        mod.setLvalue(false);

        // type checking
        //expression1.type = expression2.type.mod(expression3.type)
        mod.setType(mod.getLeft().getType()
                .modulus(mod.getLine(), mod.getColumn(), mod.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(UnaryNot negation, Void param) {
        negation.setLvalue(false);

        // expression1.type = expression2.type.toUnaryNot()
        negation.getType().toUnaryNot(negation.getLine(), negation.getColumn());
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.setLvalue(false);

        // expression1.type = expression2.type.toUnaryNot()
        unaryMinus.getType().toUnaryMinus(unaryMinus.getLine(), unaryMinus.getColumn());
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);

        // expression.type = expression.definition.type
        variable.setType(variable.getDefinition().getType());
        return null;
    }


    // --- statements

    public Void visit(Assignment assignment, Void param) {

        // semantic error - if left lvalue = false
        if(!assignment.getLeft().getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "[SEMANTIC ERROR] [Line: " + assignment.getLine() +
                    " Columnn: " + assignment.getColumn() + "] - Invalid expression in the left hand side of the assignment. It must be lvalue.");

        // expression2.type.assignTo(expression1.type)
        assignment.getRight().getType()
                .assignTo(assignment.getLine(), assignment.getColumn(), assignment.getLeft().getType());
        return null;
    }

    public Void visit(Read read, Void param) {

        if(!read.getExpression().getLvalue()){
            new ErrorType(read.getLine(), read.getColumn(), "[SEMANTIC ERROR] [Line: " + read.getLine() +
                    " Columnn: " + read.getColumn() + "] - The expression of Read must be lvalue.");

        }

        // expression.type.mustBeReadable()
        read.getExpression().getType().mustBeReadable(read.getLine(), read.getColumn());
        return null;
    }

    public Void visit(Write write, Void param) {

        // expression.type.mustBeWritable()
        write.getExpression().getType().mustBeWritable(write.getLine(), write.getColumn());
        return null;
    }

    public Void visit(While whileStmt, Void param){
        // expression.type.mustBeBoolean()
        whileStmt.getExpression().getType().mustBeBoolean(whileStmt.getLine(), whileStmt.getColumn());
        // pass the info down
        whileStmt.getBody().forEach(s -> s.setReturnType(whileStmt.getReturnType()));
        return null;
    }

    public Void visit(IfElse ifElse, Void param){
        // expression.type.mustBeBoolean()
        ifElse.getCondition().getType().mustBeBoolean(ifElse.getLine(), ifElse.getColumn());
        // pass the info down
        ifElse.getIfBody().forEach(s -> s.setReturnType(ifElse.getReturnType()));
        if (ifElse.getElseBody() != null)
            ifElse.getElseBody().forEach(s -> s.setReturnType(ifElse.getReturnType()));

        return null;
    }

    public Void visit(Return ret, Void param) {
        // expression.type.returnAs(statement.returnType)
            ret.getRet().getType().returnAs(ret.getLine(), ret.getColumn(), ret.getReturnType());
        return null;
    }

    // --- definitions
    public Void visit(FuncDefinition fd, Void param) {
        // statement*.forEach(stmt -> stmt.returnType = definition.type.returnType))
        Type returnType = ((FunctionType) fd.getType()).getReturnType();
        fd.getStatements().forEach(s -> s.setReturnType(returnType));
        return null;
    }




}
