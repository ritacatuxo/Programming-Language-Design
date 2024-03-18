package ast.semantic;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public class TypeCheckingVisitor implements Visitor<Void, Void> {

    // set/annotate lvalue attribute for expression nodes to validate the assignments
    // lvalue es lo que puedes poner a la izquierda en un assignment?

    // --- program (definitions)
    @Override
    public Void visit(Program program, Void param) {
        //call accept against all the children (definitions)
        for(Definition def : program.getBody())
        {
            def.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {
        funcDefinition.getType().accept(this, param); // tengo que hacer accept al type?
        for(Statement st : funcDefinition.getStatements())
        {
            st.accept(this, param);
        }
        for(VarDefinition vd : funcDefinition.getVarDefinitions()){
            vd.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        varDefinition.getType().accept(this, param); // tengo que hacer accept al type?
        return null;
    }


    // --- expressions

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {

        arithmetic.getLeft().accept(this, param);
        arithmetic.getRight().accept(this, param);
        arithmetic.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getExpression().accept(this, param);
        cast.getCastTo().accept(this, param);
        cast.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        charLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getLeft().accept(this, param); // traverse first child
        comparison.getRight().accept(this, param); // traverse second child
        comparison.accept(this, param);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        doubleLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getExpression().accept(this, param);
        fieldAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        functionInvocation.getVar().accept(this, param);
        for(Expression exp : functionInvocation.getParameters()){
            exp.accept(this, param);
        }
        functionInvocation.setLvalue(false); // ??
        return null;
    }

    // v[3] -> v es una variable (lvalue=true) y 3 es IntLiteral (lvalue=false)
    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getLeft().accept(this, param);
        indexing.getRight().accept(this, param);
        indexing.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        intLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getLeft().accept(this, param);
        logical.getRight().accept(this, param);
        logical.setLvalue(false);
        return null;
    }

    // a % 3 -> it is arithmetic -> false
    @Override
    public Void visit(Modulus modulus, Void param) {
        modulus.getLeft().accept(this, param);
        modulus.getRight().accept(this, param);
        modulus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Negation negation, Void param) {
        negation.getExpression().accept(this, param);
        negation.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExp().accept(this, param);
        unaryMinus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        return null;
    }


    // statements

    @Override
    public Void visit(Assignment assignment, Void param) {
        // post order - traverse the children
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);

        // semantic error - if left lvalue = false
        if(!assignment.getLeft().getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "[SEMANTIC ERROR] [Line: " + assignment.getLine() +
                            " Columnn: " + assignment.getColumn() + "] - Invalid expression in the left hand side of the assignment. It must be lvalue");

        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void param) {
        ifElse.getCondition().accept(this, param);
        for(Statement st : ifElse.getIfBody()){
            st.accept(this, param);
        }
        for(Statement st : ifElse.getElseBody()){
            st.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
        read.getExpression().accept(this, param);



        return null;
    }

    @Override
    public Void visit(Return ret, Void param) {
        ret.getRet().accept(this, param);
        return null;
    }

    @Override
    public Void visit(While whileStmt, Void param) {
        whileStmt.getExpression().accept(this, param);
        for(Statement st : whileStmt.getBody()){
            st.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(Write write, Void param) {
        write.getExpression().accept(this, param);
        return null;
    }


    // --- types

    @Override
    public Void visit(ArrayType arrayType, Void param) {
        arrayType.getType().accept(this, param); // accep el type?
        return null;
    }

    @Override
    public Void visit(CharType charType, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleType doubleType, Void param) {
        return null;
    }

    @Override
    public Void visit(ErrorType errorType, Void param) {
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        functionType.getReturnType().accept(this, param);
        for(VarDefinition vd : functionType.getParameters()){
            vd.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(IntType intType, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordType recordType, Void param) {
        for(RecordField rf : recordType.getRecordFields()){
            rf.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(VoidType voidType, Void param) {
        return null;
    }





}
