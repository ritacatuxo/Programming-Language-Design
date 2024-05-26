package semantic;

import ast.definitions.FuncDefinition;
import ast.errorhandler.ErrorHandler;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

/**
 * Set/annotate lvalue attribute for expression nodes to validate the assignments
 */
public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {


    // --- expressions

    /**
     * (P) Arithmetic: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.arithmetic(expression3.type)
     */
    @Override
    public Void visit(Arithmetic arith, Void param) {
        super.visit(arith,param);

        arith.setLvalue(false);

        // type checking
        arith.setType(arith.getLeft().getType()
                .arithmetic(arith.getLine(), arith.getColumn(), arith.getRight().getType()));

        return null;
    }

    /**
     * (P) Cast: expression1 -> type expression2
     * (R) expression1.type = expression2.type.castTo(type)
     */
    @Override
    public Void visit(Cast c, Void param) {
        super.visit(c,param);

        c.setLvalue(false);

        // expression1.type = expression2.type.castTo(type)
        c.setType(c.getExpression().getType().castTo(c.getLine(), c.getColumn(), c.getCastType()));
        return null;
    }

    /**
     * (P) CharLiteral: expression -> CHAR_CONSTANT
     * (R) expression.type = new CharType();
     */
    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        charLiteral.setLvalue(false);
        charLiteral.setType(new CharType(charLiteral.getLine(), charLiteral.getColumn()));
        return null;
    }

    /**
     * (P) Comparison: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.comparison(expression3.type)
     */
    @Override
    public Void visit(Comparison com, Void param) {
        super.visit(com,param);

        com.setLvalue(false);

        // expression1.type = expression2.type.com(expression3.type)
        com.setType(com.getLeft().getType()
                .comparison(com.getLine(), com.getColumn(), com.getRight().getType()));
        return null;
    }

    /**
     * (P) DoubleLiteral: expression -> REAL_CONSTANT
     * (R) expression.type = new RealType();
     */
    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        doubleLiteral.setLvalue(false);
        doubleLiteral.setType(new DoubleType(doubleLiteral.getLine(), doubleLiteral.getColumn()));
        return null;
    }

    /**
     * (P) FieldAccess: expression1 -> expression2 ID //WRONG -- corrected?
     * (R) expression1.type = expression2.type.dot(ID)
     */
    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        super.visit(fieldAccess,param);

        fieldAccess.setLvalue(true);

        // expression1.type = expression2.type.dot(ID)
        fieldAccess.setType(fieldAccess.getExpression().getType()
                .dot(fieldAccess.getLine(), fieldAccess.getColumn(), fieldAccess.getFieldName()));
        return null;
    }

    /**
     * (P) FuncInvocation: expression1 -> expression2 expression*
     * (R) expression1.type = expression2.type.parenthesis(
     * 	        expression*.stream().map(exp -> exp.type).toArray()
     *     )
     */
    @Override
    public Void visit(FunctionInvocation fi, Void param) {
        super.visit(fi,param);

        fi.setLvalue(false);

        // expression1.type = expression2.type.parenthesis(
        //	expression*.stream().map(exp -> exp.type).toArray() )
        fi.setType(fi.getVar().getType()
                .parenthesis(fi.getLine(), fi.getColumn(), fi.getParameters()));

        return null;
    }

    /**
     * (P) Indexing: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.squareBrackets(expression3.type)
     */
    @Override
    public Void visit(Indexing indexing, Void param) {
        super.visit(indexing,param);
        indexing.setLvalue(true);

        // expression1.type = expression2.type.squareBrackets(expression3.type)
        indexing.setType(indexing.getLeft().getType()
                        .squareBrackets(indexing.getLine(), indexing.getColumn(), indexing.getRight().getType()));
        return null;
    }


    /**
     * (P) IntLiteral: expression -> INT_CONSTANT
     * (R) expression.type = new IntType();
     */
    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        intLiteral.setLvalue(false);
        intLiteral.setType(new IntType(intLiteral.getLine(), intLiteral.getColumn()));
        return null;
    }

    /**
     * (P) Logical: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.logical(expression3.type)
     */
    @Override
    public Void visit(Logical log, Void param) {
        super.visit(log,param);

        log.setLvalue(false);

        // expression1.type = expression2.type.log(expression3.type)
        log.setType(log.getLeft().getType()
                .logical(log.getLine(), log.getColumn(), log.getRight().getType()));

        return null;
    }

    /**
     * (P) Modulus: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.modulus(expression3.type)
     */
    @Override
    public Void visit(Modulus mod, Void param) {
        super.visit(mod,param);

        mod.setLvalue(false);

        // type checking
        //expression1.type = expression2.type.mod(expression3.type)
        mod.setType(mod.getLeft().getType()
                .modulus(mod.getLine(), mod.getColumn(), mod.getRight().getType()));
        return null;
    }

    /**
     * (P) UnaryNot: expression1 -> expression2
     * (R) expression1.type = expression2.type.toUnaryNot()
     */
    @Override
    public Void visit(UnaryNot negation, Void param) {
        super.visit(negation,param);

        negation.setLvalue(false);

        // expression1.type = expression2.type.toUnaryNot()
        negation.setType(negation.getExpression().getType().toUnaryNot(negation.getLine(), negation.getColumn()));
        return null;
    }

    /**
     * (P) UnaryMinus: expression1 -> expression2
     * (R) expression1.type = expression2.type.toUnaryMinus()
     */
    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        super.visit(unaryMinus,param);

        unaryMinus.setLvalue(false);

        // expression1.type = expression2.type.toUnaryNot()
        unaryMinus.setType(unaryMinus.getExp().getType().toUnaryMinus(unaryMinus.getLine(), unaryMinus.getColumn()));
        return null;
    }

    /**
     * (P) Variable: expression -> ID
     * (R) expression.type = expression.definition.type
     */
    @Override
    public Void visit(Variable variable, Void param) {
        super.visit(variable,param);

        variable.setLvalue(true);

        // expression.type = expression.definition.type
        variable.setType(variable.getDefinition().getType());
        return null;
    }


    // --- statements

    /**
     * (P) Assigment: statement -> expression1 expression2
     * (R) expression2.type.assignTo(expression1.type)
     */
    public Void visit(Assignment assignment, Void param) {
        super.visit(assignment,param);

        // semantic error - if left lvalue = false
        if(!assignment.getLeft().getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "[SEMANTIC ERROR] [Line: " + assignment.getLine() +
                    " Columnn: " + assignment.getColumn() + "] - Invalid expression in the left hand side of the assignment. It must be lvalue.");

        // expression2.type.assignTo(expression1.type)
        assignment.getRight().getType()
                .assignTo(assignment.getLine(), assignment.getColumn(), assignment.getLeft().getType());
        return null;
    }

    /**
     * (P) Read: statement -> expression
     * (R) expression.type.mustBeReadable()
     */
    public Void visit(Read read, Void param) {
        super.visit(read,param);

        if(!read.getExpression().getLvalue()){
            new ErrorType(read.getLine(), read.getColumn(), "[SEMANTIC ERROR] [Line: " + read.getLine() +
                    " Columnn: " + read.getColumn() + "] - The expression of Read must be lvalue.");

        }

        // expression.type.mustBeReadable()
        read.getExpression().getType().mustBeReadable(read.getLine(), read.getColumn());
        return null;
    }

    /**
     * (P) Write statement -> expression
     * (R) expression.type.mustBeReadable()
     */
    public Void visit(Write write, Void param) {
        super.visit(write,param);

        // expression.type.mustBeWritable()
        write.getExpression().getType().mustBeWritable(write.getLine(), write.getColumn());
        return null;
    }

    /**
     * (P) WhileStmt: statement -> expression statement*
     * (R) expression.type.mustBeBoolean()
     */
    public Void visit(While whileStmt, Void param){
        super.visit(whileStmt,param);
        // expression.type.mustBeBoolean()
        whileStmt.getExpression().getType().mustBeBoolean(whileStmt.getExpression().getLine(), whileStmt.getExpression().getColumn());
        // pass the info down
        whileStmt.getBody().forEach(s -> s.setReturnType(whileStmt.getReturnType()));
        return null;
    }

    /**
     * (P) IfStmt: statement -> expression statement* statement*
     * (R) expression.type.mustBeBoolean()
     */
    public Void visit(IfElse ifElse, Void param){
        super.visit(ifElse,param);

        // expression.type.mustBeBoolean()
        ifElse.getCondition().getType().mustBeBoolean(ifElse.getLine(), ifElse.getColumn());
        // pass the info down
        ifElse.getIfBody().forEach(s -> s.setReturnType(ifElse.getReturnType()));
        if (ifElse.getElseBody() != null)
            ifElse.getElseBody().forEach(s -> s.setReturnType(ifElse.getReturnType()));

        return null;
    }

    /**
     * (P) Return: statement -> expression
     * (R) expression.type.returnAs(statement.returnType)
     */
    public Void visit(Return ret, Void param) {
        super.visit(ret,param);

        ret.getRet().getType().returnAs(ret.getLine(), ret.getColumn(), ret.getReturnType());
        return null;
    }

    // --- definitions

    /**
     * (P) FunctionDefinition: definition -> statement* vardefinition*
     * (R) statement*.forEach(stmt -> stmt.returnType = definition.type.returnType))
     */
    public Void visit(FuncDefinition fd, Void param) {
        // statement*.forEach(stmt -> stmt.returnType = definition.type.returnType))
        Type returnType = ((FunctionType) fd.getType()).getReturnType();
        fd.getStatements().forEach(s -> s.setReturnType(returnType));

        super.visit(fd,param);
        return null;
    }




}
