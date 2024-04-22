package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

public class Assignment extends AbstractStatement {

    // exp = exp
    private Expression left;
    private Expression right;


    public Assignment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }


    public Expression getLeft() {
        return left;
    }


    public Expression getRight() {
        return right;
    }


    @Override
    public String toString() {
        return "Assignment: " + left + "=" + right;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
