package ast.statements;

import ast.expressions.Expression;

public class Return extends AbstractStatement {

    private Expression ret;

    public Return(int line, int column, Expression ret) {
        super(line, column);
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "Return " + ret;
    }
}
