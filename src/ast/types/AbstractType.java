package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

public abstract class AbstractType extends AbstractASTNode implements Type {

	public AbstractType(int line, int column)
	{
		super(line, column);
	}

	// If a type rule is not enforced, a type error is produced

	@Override
	public Type arithmetic(int line, int column, Type t){
		if(t instanceof ErrorType)
			return t;
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] An arithmetic operation cannot be performed against types %s and %s", this, t));


	}

	@Override
	public Type modulus(int line, int column, Type t)
	{
		if(t instanceof ErrorType)
			return t;
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] A modulus operation cannot be performed against types %s and %s", this, t));
	}

	@Override
	public Type logical(int line, int column, Type t)
	{
		if(t instanceof ErrorType)
			return t;
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] A logical operation cannot be performed against types %s and %s", this, t));
	}

	@Override
	public Type toUnaryNot(int line, int column){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] A negation (unary not) operation cannot be performed for the type %s", this));
	}

	@Override
	public Type toUnaryMinus(int line, int column){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] A unary minus operation cannot be performed for the type %s", this));
	}

	 @Override
	public Type comparison(int line, int column, Type t){
		 return new ErrorType(line, column,
				 "[TYPE CHECKING] A comparison operation cannot be performed against types that are not chars, integer or doubles");
	 }



}
