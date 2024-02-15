package ast;

import java.util.ArrayList;
import java.util.List;

import ast.definition.Definition;

public class Program extends AbstractASTNode {
	
	private List<Definition> body;

	public Program(int line, int column, List<Definition> defs) {
		super(line, column);
		this.body = new ArrayList<>(defs); //clone
	}

	public List<Definition> getbody()
	{
		return body;
	}

}
