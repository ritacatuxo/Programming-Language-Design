package ast.expressions;

import ast.visitor.Visitor;

public class FieldAccess extends AbstractExpression{

	private String fieldName; // obj.fieldName
	private Expression expression;

	public FieldAccess(int line, int column, Expression expression, String fieldName)
	{
		super(line, column);
		this.expression = expression;
		this.fieldName = fieldName;
	}


	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "FieldAccess = " +
				fieldName + '.' +
				expression;
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
