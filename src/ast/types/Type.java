package ast.types;

import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;
import ast.definition.Definition;

public interface Type extends ASTNode {


	public Type(int line, int column) {
		super(line, column);
	}

}
