package ast.semantic.visitor;

import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    // set/annotate lvalue attribute for expression nodes to validate the assignments
    // lvalue es lo que puedes poner a la izquierda en un assignment?


    // --- expressions

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {

        arithmetic.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
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
        comparison.setLvalue(false);
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
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        functionInvocation.setLvalue(false); // ??
        return null;
    }

    // v[3] -> v es una variable (lvalue=true) y 3 es IntLiteral (lvalue=false)
    @Override
    public Void visit(Indexing indexing, Void param) {
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
        logical.setLvalue(false);
        return null;
    }

    // a % 3 -> it is arithmetic -> false
    @Override
    public Void visit(Modulus modulus, Void param) {
        modulus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot negation, Void param) {
        negation.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        return null;
    }


    // statemetns
    public Void visit(Assignment assignment, Void param) {

        // semantic error - if left lvalue = false
        if(!assignment.getLeft().getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "[SEMANTIC ERROR] [Line: " + assignment.getLine() +
                    " Columnn: " + assignment.getColumn() + "] - Invalid expression in the left hand side of the assignment. It must be lvalue.");

        return null;
    }

    public Void visit(Read read, Void param) {

        if(!read.getExpression().getLvalue()){
            new ErrorType(read.getLine(), read.getColumn(), "[SEMANTIC ERROR] [Line: " + read.getLine() +
                    " Columnn: " + read.getColumn() + "] - The expression of Read must be lvalue.");

        }

        return null;
    }






}
