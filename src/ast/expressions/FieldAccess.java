package ast.expressions;

public class FieldAccess extends AbstractExpression{

	private String fieldName; // obj.fieldName
	private Expression expression;

	public FieldAccess(int line, int column, String fieldName, Expression expression)
	{
		super(line, column);
		this.fieldName = fieldName;
		this.expression = expression;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
}
