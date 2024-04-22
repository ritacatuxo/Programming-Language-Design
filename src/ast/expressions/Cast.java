package ast.expressions;


import ast.types.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression{

	private Type castType; // (char)n -> char, the type we cast to
	private Expression expression; // (char)n -> n

	public Cast(int line, int column, Type castType, Expression expression) {
		super(line, column);
		this.castType = castType;
		this.expression = expression;
	}


	public Type getCastType() {
		return castType;
	}

	public void setType(Type castTo) {
		this.castType = castTo;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}



	@Override
	public String toString() {
		return "Cast = (" + castType + ") " + expression;
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
