package ast.visitor;

import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.Assignment;

public class TypeCheckingVisitor implements Visitor<Void, Void> {


    @Override
    public Void visit(Program program, Void param) {
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {

        arithmetic.getLeft().accept(this, param);
        arithmetic.getRight().accept(this, param);
        arithmetic.setLvalue(false);
        return null;
    }

    // ((int) (a+B)) -> no tiene sentido
    // ((int) a) -> esto si que tiene sentido, asiqeu lo uqe casteas no cambia. siempre truw
    @Override
    public Void visit(Cast cast, Void param) {
        cast.setLvalue(true);
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
        comparison.getRight().accept(this, param);
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
        fieldAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        //functionInvocation.setLvalue();
        return null;
    }

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
        logical.getLeft().accept(this, param);
        logical.getRight().accept(this, param);
        //logical.setLvalue();
        return null;
    }

    @Override
    public Void visit(Modulus modulus, Void param) {
        modulus.setLvalue(false); // arithmetic
        return null;
    }

    @Override
    public Void visit(Negation negation, Void param) {
        negation.getExpression().accept(this, param);
        negation.setLvalue(negation.getExpression().getLvalue());
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExp().accept(this, param);
        unaryMinus.setLvalue(unaryMinus.getExp().getLvalue());
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        // post order - traverse the children
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);
        assignment.setLvalue(assignment.getLeft().getLvalue());
        return null;
    }
}
