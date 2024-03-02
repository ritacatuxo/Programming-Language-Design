package ast.expressions;

// -
public class UnaryMinus extends AbstractExpression{

	private Expression exp;

	public UnaryMinus(int line, int column, Expression exp) {
		super(line, column);
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "UnaryMinus = -" + exp;
	}
}
