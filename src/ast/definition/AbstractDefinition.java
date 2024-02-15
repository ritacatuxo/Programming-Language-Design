package ast.definition;

public class AbstractDefinition extends AbstractASTNode implements Definition {


	private Type type;
	private String name;
	
	public AbstractDefinition(int line, int column, Type type, String name)
	{
		super(line, column);
		this.type = type;
		this.name = name;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

}
