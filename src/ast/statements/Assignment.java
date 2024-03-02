package ast.statements;

import ast.expressions.Expression;

public class Assignment extends AbstractStatement {

    // exp = exp
    private Expression left;
    private Expression right;

    public Assignment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "Assignment: " + left + "=" + right;
    }
}
