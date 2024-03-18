package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.expressions.Expression;
import ast.semantic.Visitor;

public class While extends AbstractStatement {

	private List<Statement> body; // body
	private Expression expression; // condition

	public While(int line, int column, Expression expression, List<Statement> body) {
		super(line, column);
		this.body = new ArrayList<Statement>(body);
		this.expression = expression;
	}


	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<Statement> getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "While{" +
				"body=" + body +
				", expression=" + expression +
				'}';
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
