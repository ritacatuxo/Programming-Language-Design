package ast.expressions;

import ast.visitor.Visitor;

public class Logical extends AbstractExpression {

	private String operator; // (and-&&) / (or-||)
	private Expression left;
	private Expression right;

	public Logical(int line, int column, String operator, Expression left, Expression right) {
		super(line, column);
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Logical=" + left + operator + right;
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
