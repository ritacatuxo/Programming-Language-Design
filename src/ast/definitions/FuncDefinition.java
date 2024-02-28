package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition{

    List<Statement> statements;
    List<VarDefinition> varDefinitions;
    List<VarDefinition> parameters; // tiene sentido separarlo=?
    public FuncDefinition(int line, int column, Type type, String name, List<VarDefinition> parameters, List<VarDefinition> varDefinitions, List<Statement> statements) {
        super(line, column, type, name);
        this.parameters = parameters;
        this.statements = new ArrayList<Statement>(statements);
        this.varDefinitions = new ArrayList<VarDefinition>(varDefinitions);
    }

    public List<Statement> getStatements() {
        return statements;
    }
    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }
}
