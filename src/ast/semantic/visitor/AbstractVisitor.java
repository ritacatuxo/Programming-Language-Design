package ast.semantic.visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

// abstract visitor must be generic
public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    // --- program (definitions)

    public TR visit(Program program, TP param) {
        //call accept against all the children (definitions)
        for(Definition def : program.getBody())
        {
            def.accept(this, param);
        }
        return null;
    }

    public TR visit(FuncDefinition funcDefinition, TP param) {
        funcDefinition.getType().accept(this, param);
        for(VarDefinition vd : funcDefinition.getVarDefinitions()){
            vd.accept(this, param);
        }
        for(Statement st : funcDefinition.getStatements())
        {
            st.accept(this, param);
        }

        return null;
    }

    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.getType().accept(this, param); // tengo que hacer accept al type?
        return null;
    }

    // --- expressions


    public TR visit(Arithmetic arithmetic, TP param) {

        arithmetic.getLeft().accept(this, param);
        arithmetic.getRight().accept(this, param);
        return null;
    }


    public TR visit(Cast cast, TP param) {
        cast.getExpression().accept(this, param);
        cast.getCastTo().accept(this, param);
        return null;
    }


    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }


    public TR visit(Comparison comparison, TP param) {
        comparison.getLeft().accept(this, param); // traverse first child
        comparison.getRight().accept(this, param); // traverse second child
        //comparison.accept(this, param);
        return null;
    }


    public TR visit(DoubleLiteral doubleLiteral, TP param) {
        return null;
    }


    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.getExpression().accept(this, param);
        return null;
    }


    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.getVar().accept(this, param);
        for(Expression exp : functionInvocation.getParameters()){
            exp.accept(this, param);
        }
        return null;
    }

    public TR visit(Indexing indexing, TP param) {
        indexing.getLeft().accept(this, param);
        indexing.getRight().accept(this, param);
        return null;
    }


    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }


    public TR visit(Logical logical, TP param) {
        logical.getLeft().accept(this, param);
        logical.getRight().accept(this, param);
        return null;
    }

    // a % 3 -> it is arithmetic -> false

    public TR visit(Modulus modulus, TP param) {
        modulus.getLeft().accept(this, param);
        modulus.getRight().accept(this, param);
        return null;
    }


    public TR visit(Negation negation, TP param) {
        negation.getExpression().accept(this, param);
        return null;
    }


    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getExp().accept(this, param);
        return null;
    }


    public TR visit(Variable variable, TP param) {
        return null;
    }




    // statements

    public TR visit(Assignment assignment, TP param) {
        // post order - traverse the children
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);

        return null;
    }


    public TR visit(IfElse ifElse, TP param) {
        ifElse.getCondition().accept(this, param);
        for(Statement st : ifElse.getIfBody()){
            st.accept(this, param);
        }
        for(Statement st : ifElse.getElseBody()){
            st.accept(this, param);
        }
        return null;
    }


    public TR visit(Read read, TP param) {
        read.getExpression().accept(this, param);

        return null;
    }

    public TR visit(Return ret, TP param) {
        ret.getRet().accept(this, param);
        return null;
    }


    public TR visit(While whileStmt, TP param) {
        whileStmt.getExpression().accept(this, param);
        for(Statement st : whileStmt.getBody()){
            st.accept(this, param);
        }
        return null;
    }


    public TR visit(Write write, TP param) {
        write.getExpression().accept(this, param);
        return null;
    }



    // --- types


    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getType().accept(this, param); // accep el type?
        return null;
    }


    public TR visit(CharType charType, TP param) {
        return null;
    }


    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }


    public TR visit(ErrorType errorType, TP param) {
        return null;
    }


    public TR visit(FunctionType functionType, TP param) {
        functionType.getReturnType().accept(this, param);
        for(VarDefinition vd : functionType.getParameters()){
            vd.accept(this, param);
        }
        return null;
    }


    public TR visit(IntType intType, TP param) {
        return null;
    }


    public TR visit(RecordType recordType, TP param) {
        for(RecordField rf : recordType.getRecordFields()){
            rf.accept(this, param);
        }
        return null;
    }


    public TR visit(VoidType voidType, TP param) {
        return null;
    }




}
