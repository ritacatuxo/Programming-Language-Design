package ast.types;

import ast.definitions.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{

    private List<VarDefinition> arguments;
    private Type returnType;

    public FunctionType(int line, int column, List<VarDefinition> varList, Type returnType) {
        super(line, column);
        this.arguments = new ArrayList<VarDefinition>(varList);
        this.returnType =returnType;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "arguments=" + arguments +
                ", return type=" + returnType +
                '}';
    }
}
