package codegeneration;

import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {
    @Override
    public TR visit(Program program, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(FieldAccess FieldAccess, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        return null;
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryNot negation, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        return null;
    }

    @Override
    public TR visit(Return ret, TP param) {
        return null;
    }

    @Override
    public TR visit(While whileStmt, TP param) {
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
