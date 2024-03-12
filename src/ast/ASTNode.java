package ast;

import ast.visitor.Visitor;

public interface ASTNode {

	int getLine();
	int getColumn();

	public <TR, TP> TR accept(Visitor<TP,TR> visitor, TP param);
}
