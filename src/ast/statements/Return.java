package ast;

import java.util.ArrayList;
import java.util.List;

import ast.definition.Definition;
import ast.expressions.Expression;

public class Return extends ast.AbstractStatement {

    private Expression ret;

    public Return(int line, int column, Expression ret) {
        super(line, column);
        this.ret = ret;
    }

    public Expression getRet() {
        return ret;
    }

    public void setRet(Expression ret) {
        this.ret = ret;
    }
}
