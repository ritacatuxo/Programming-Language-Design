package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.expressions.Expression;

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


    @Override
    public String toString() {
        return "IfElse{" +
                "condition=" + condition +
                ", ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                '}';
    }

}
