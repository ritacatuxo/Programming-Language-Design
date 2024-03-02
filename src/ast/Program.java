package ast;

import java.util.ArrayList;
import java.util.List;

import ast.definitions.Definition;

public class Program extends AbstractASTNode {
	
	private List<Definition> body;

	public Program(int line, int column, List<Definition> defs) {
		super(line, column);
		this.body = new ArrayList<>(defs); //clone
	}

	@Override
	public String toString() {
		return "Program{" +
				"body=" + body +
				'}';
	}
}
