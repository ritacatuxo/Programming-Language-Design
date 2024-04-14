package ast.definitions;

import ast.AbstractASTNode;
import ast.types.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {


	private Type type;
	private String name;
	private int scope;
	private int offset;
	
	public AbstractDefinition(int line, int column, Type type, String name)
	{
		super(line, column);
		this.type = type;
		this.name = name;
	}

	@Override
	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}
}
