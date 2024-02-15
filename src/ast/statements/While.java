package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.Statement;
import ast.definition.Definition;
import ast.expressions.Expression;
import ast.statements.AbstractStatement;

public class While extends AbstractStatement {

	private List<Statement> body; // body
	private Expression expression; // condition

	public While(int line, int column, List<Statement> body, Expression expression) {
		super(line, column);
		this.body = new ArrayList<Statement>(body);
		this.expression = expression;
	}

	public List<Statement> getBody() {
		return body;
	}

	public void setBody(List<Statement> body) {
		this.body = body;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
}
