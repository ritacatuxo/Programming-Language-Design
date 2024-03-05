package ast.visitor;

import ast.expressions.Arithmetic;
import ast.expressions.Indexing;
import ast.expressions.IntLiteral;
import ast.expressions.Variable;
import ast.statements.Assignment;

/**
 * Visitor Design Pattern
 * @param <TP>
 * @param <TR>
 */
public interface Visitor<TP, TR> {
/*
    public TR visit(Arithmetic arithmetic, TP param);
    public TR visit(Variable variable, TP param);
    public TR visit(Assignment assignment, TP param);
    public TR visit(IntLiteral intLiteral, TP param);
    public TR visit(Indexing indexing, TP param);
 */
}
