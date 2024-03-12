package ast.expressions;


import ast.types.Type;
import ast.visitor.Visitor;

public class Cast extends AbstractExpression{

	private Type castTo; // (char)n -> char, the type we cast to
	private Expression expression; // (char)n -> n

	public Cast(int line, int column, Type castTo, Expression expression) {
		super(line, column);
		this.castTo = castTo;
		this.expression = expression;
	}


	public void setType(Type castTo) {
		this.castTo = castTo;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}



	@Override
	public String toString() {
		return "Cast = (" + castTo + ") " + expression;
	}

	@Override
	public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
