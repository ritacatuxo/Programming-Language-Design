package ast;

import java.util.ArrayList;
import java.util.List;

import ast.definitions.Definition;

public class Program extends AbstractASTNode {
	
	private List<Definition> body;

	public Program(int line, int column) {
		super(line, column);
		this.body = new ArrayList<>();
	}

	/**
	 * Method to set the definitios of the program (variable or function definitions)
	 */
	public void setDefinitions(List<Definition> definitions) {
		this.body.addAll(definitions);
	}

	public void addDefinition(Definition def){
		this.body.add(def);
	}


	@Override
	public String toString() {
		return "Program{" +
				"body=" + body +
				'}';
	}
}
