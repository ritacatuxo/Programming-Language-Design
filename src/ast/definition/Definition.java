package ast.definition;

import ast.ASTNode;
import ast.Type;

public interface Definition extends ASTNode {
	
	Type getType();
	String getName();

}
