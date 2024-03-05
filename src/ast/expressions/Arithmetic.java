package ast.expressions;


public class Arithmetic extends AbstractExpression {

	private String operator; // + - * / %
	private Expression left;
	private Expression right;

	public Arithmetic(int line, int column, String operator, Expression left, Expression right) {
		super(line, column);
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	public static Expression arithmeticFactory(String operator, Expression left, Expression right)
	{
		if(operator.equals("%")) {
			return new Modulus(left.getLine(), left.getColumn(), left, right);
		}
		else {
			return new Arithmetic(left.getLine(), left.getColumn(), operator, left,right);
		}
	}


	@Override
	public String toString() {
		return "Arithmetic = " + left + operator + right;
	}
}
