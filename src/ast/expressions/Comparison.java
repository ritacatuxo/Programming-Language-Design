package ast.expressions;

import semantic.visitor.Visitor;

public class Comparison extends AbstractExpression{

	private String operator; // '>'|'<'|'>='|'<='|'!='|'=='
	private Expression left;
	private Expression right;

	public Comparison(int line, int column, String operator, Expression left, Expression right) {
		super(line, column);
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Comparison = " + left + operator + right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}

