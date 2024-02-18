package ast.expressions;

public class UnaryMinus extends AbstractExpression{

	private String operator;
	private Expression exp;

	public UnaryMinus(int line, int column, String operator, Expression exp) {
		super(line, column);
		this.operator = operator;
		this.exp = exp;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}
}
