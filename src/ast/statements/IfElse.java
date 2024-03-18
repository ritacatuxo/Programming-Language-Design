package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.expressions.Expression;
import ast.semantic.Visitor;

public class IfElse extends AbstractStatement {

    private Expression condition;
    private List<Statement> ifBody;
    private List<Statement> elseBody;

    public IfElse(int line, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        this.condition = condition;
        this.ifBody = new ArrayList<>(ifBody);
        this.elseBody = new ArrayList<>(elseBody);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public String toString() {
        return "IfElse{" +
                "condition=" + condition +
                ", ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                '}';
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
