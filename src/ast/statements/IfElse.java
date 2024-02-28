package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.expressions.Expression;

public class IfElse extends AbstractStatement {

    private Expression condition;
    private List<Statement> ifBody;
    private List<Statement> elseBody;

    public IfElse(int line, int column, Expression condition, List<Statement> ifBody) {
        super(line, column);
        this.condition = condition;
        this.ifBody = new ArrayList<Statement>(ifBody);
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public void setIfBody(List<Statement> ifBody) {
        this.ifBody = ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    public void setElseBody(List<Statement> elseBody) {
        this.elseBody = elseBody;
    }
}
