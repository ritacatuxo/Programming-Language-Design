package ast.expressions;

import ast.AbstractASTNode;
import ast.types.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {

    private boolean lvalue;
    private Type type;
    public AbstractExpression(int line, int column)
    {
        super(line, column);
    }


    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    public boolean getLvalue() {
        return lvalue;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }
}
