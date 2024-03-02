package ast.definitions;

import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.Type;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition{

    private List<Statement> statements;
    private List<VarDefinition> varDefinitions;


    public FuncDefinition(int line, int column, FunctionType functionType, String name, List<VarDefinition> varDefinitions, List<Statement> statements) {
        super(line, column, functionType, name);
        this.statements = new ArrayList<Statement>(statements);
        this.varDefinitions = new ArrayList<VarDefinition>(varDefinitions);
    }



    public List<Statement> getStatements() {
        return statements;
    }
    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    @Override
    public String toString() {
        return "FuncDefinition{" +
                "statements=" + statements +
                ", varDefinitions=" + varDefinitions +
                '}';
    }
}
