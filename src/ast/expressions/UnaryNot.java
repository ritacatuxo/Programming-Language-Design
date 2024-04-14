package ast.expressions;

import semantic.visitor.Visitor;

// !
public class UnaryNot extends AbstractExpression {

	private Expression expression;

	public UnaryNot(int line, int column, Expression expression) {
		super(line, column);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "Negation = !" + expression;
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
