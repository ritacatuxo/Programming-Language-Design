package ast.expressions;


public class Negation extends AbstractExpression {

	private String operator; // !
	private Expression expression;

	public Negation(int line, int column, String operator, Expression expression) {
		super(line, column);
		this.operator = operator;
		this.expression = expression;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
}
