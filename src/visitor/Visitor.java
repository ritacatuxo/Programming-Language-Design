package visitor;

import ast.Program;
import ast.expressions.*;
import ast.definitions.*;
import ast.statements.*;
import ast.types.*;

/**
 * Visitor Design Pattern
 * @param <TP> an instance of the concrete class
 * @param <TR> the return type
 */
public interface Visitor<TP, TR> {

    // program (definitions)
    public TR visit(Program program, TP param);
    public TR visit(FuncDefinition funcDefinition, TP param);
    public TR visit(VarDefinition varDefinition, TP param);


    // expressions
    public TR visit(Arithmetic arithmetic, TP param);
    public TR visit(Cast cast, TP param);
    public TR visit(CharLiteral charLiteral, TP param);
    public TR visit(Comparison comparison, TP param);
    public TR visit(DoubleLiteral doubleLiteral, TP param);
    public TR visit(FieldAccess FieldAccess, TP param);
    public TR visit(FunctionInvocation functionInvocation, TP param);
    public TR visit(Indexing indexing, TP param);
    public TR visit(IntLiteral intLiteral, TP param);
    public TR visit(Logical logical, TP param);
    public TR visit(Modulus modulus, TP param);
    public TR visit(UnaryNot negation, TP param);
    public TR visit(UnaryMinus unaryMinus, TP param);
    public TR visit(Variable variable, TP param);


    // statements
    public TR visit(Assignment assignment, TP param);
    public TR visit(IfElse ifElse, TP param);
    public TR visit(Read read, TP param);
    public TR visit(Return ret, TP param);
    public TR visit(While whileStmt, TP param);
    public TR visit(Write write, TP param);


    // types
    public TR visit(ArrayType arrayType, TP param);
    public TR visit(CharType charType, TP param);
    public TR visit(DoubleType doubleType, TP param);
    public TR visit(ErrorType errorType, TP param);
    public TR visit(FunctionType functionType, TP param);
    public TR visit(IntType intType, TP param);
    public TR visit(RecordType recordType, TP param);
    public TR visit(VoidType voidType, TP param);



}
