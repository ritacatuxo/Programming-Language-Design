package ast.types;

import ast.definitions.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{

    private List<VarDefinition> arguments;
    private Type ret;

    public FunctionType(int line, int column, List<VarDefinition> varList, Type ret) {
        super(line, column);
        this.arguments = new ArrayList<VarDefinition>(varList);
        this.ret =ret;
    }
}
