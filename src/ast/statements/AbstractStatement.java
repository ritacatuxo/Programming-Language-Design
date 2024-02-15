package ast.statements;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ast.AbstractASTNode;
import ast.definition.Definition;

public abstract class AbstractStatement extends AbstractASTNode implements Statement {

	public AbstractStatement(int line, int column) {
		super(line, column);
	}

}
