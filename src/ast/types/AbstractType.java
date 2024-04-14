package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;

import java.util.List;

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
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"An arithmetic operation cannot be performed against types %s and %s", this, t));


	}

	@Override
	public Type modulus(int line, int column, Type t)
	{
		if(t instanceof ErrorType)
			return t;
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A modulus operation cannot be performed against types %s and %s", this, t));
	}

	@Override
	public Type logical(int line, int column, Type t)
	{

		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A logical operation cannot be performed against types %s and %s", this, t));
	}

	@Override
	public Type toUnaryNot(int line, int column){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A negation (unary not) operation cannot be performed for the type %s", this));
	}

	@Override
	public Type toUnaryMinus(int line, int column){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A unary minus operation cannot be performed for the type %s", this));
	}

	 @Override
	public Type comparison(int line, int column, Type t){
		 return new ErrorType(line, column,
				 String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						 "A comparison operation cannot be performed against types  %s and %s", this, t));
	 }

	@Override
	public Type dot(int line, int column, String fieldName){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A field access operation cannot be performed for %s", fieldName));
	}

	@Override
	public Type castTo(int line, int column, Type castTo){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A cast operation cannot be applied for %s and %s", this, castTo));
	}

	@Override
	public Type squareBrackets(int line, int column, Type indexer){
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"An array indexer operation cannot be applied for %s ", indexer));
	}

	@Override
	public Type parenthesis(int line, int column, List<Expression> paramsType ) {
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						"A parenthesis operation cannot be applied for %s ", this));
	}

	@Override
	public Type assignTo(int line, int column, Type t) {
		//if (this instanceof ErrorType)
		//	return t;
		return new ErrorType(line, column,
				String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
						//"Cannot assign a " + t + " to " + this));
						"The two sides of the assigment must have the same built-in type"));
	}

	@Override
	public void mustBeReadable(int line, int column){
		if (!(this instanceof ErrorType))
			new ErrorType(line, column,
					String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
							"%s must be readable", this));
	}

	@Override
	public void mustBeWritable(int line, int column){
		if (!(this instanceof ErrorType))
			new ErrorType(line, column,
						String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
								"%s must be writable", this));
	}

	@Override
	public void mustBeBoolean(int line, int column){
		new ErrorType(line, column,
					String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
							"The type %s cannot be evaluated as boolean", this));
	}

	@Override
	public void returnAs(int line, int column, Type t){
		new ErrorType(line, column,
					String.format("[TYPE CHECKING] " + "[Line: " + line + " Column: " + column + "] " +
							"The return type %s must be equivalent to %s", t, this)); //MAL?
	}

}
