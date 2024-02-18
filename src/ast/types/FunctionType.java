package ast.types;

import ast.definitions.VarDefinition;
import ast.expressions.Variable;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{

    List<VarDefinition> varList;


    public FunctionType(int line, int column, List<VarDefinition> varList) {
        super(line, column);
        this.varList = new ArrayList<VarDefinition>(varList);
    }
}
