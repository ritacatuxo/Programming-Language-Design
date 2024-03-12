package ast.expressions;

import ast.visitor.Visitor;

// -
public class UnaryMinus extends AbstractExpression{

	private Expression exp;

	public UnaryMinus(int line, int column, Expression exp) {
		super(line, column);
		this.exp = exp;
	}

	public Expression getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return "UnaryMinus = -" + exp;
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
