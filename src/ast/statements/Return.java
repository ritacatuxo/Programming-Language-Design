package ast.statements;

import ast.expressions.Expression;
import ast.semantic.Visitor;

public class Return extends AbstractStatement {

    private Expression ret;

    public Return(int line, int column, Expression ret) {
        super(line, column);
        this.ret = ret;
    }

    public Expression getRet() {
        return ret;
    }

    @Override
    public String toString() {
        return "Return " + ret;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
