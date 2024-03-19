package ast.definitions;

import ast.statements.Statement;
import ast.types.FunctionType;
import ast.semantic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition{

    private List<Statement> statements;
    private List<VarDefinition> varDefinitions;


    public FuncDefinition(int line, int column, FunctionType functionType, String name, List<VarDefinition> varDefinitions, List<Statement> statements) {
        super(line, column, functionType, name);
        this.statements = new ArrayList<>(statements);
        this.varDefinitions = new ArrayList<>(varDefinitions);
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

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
