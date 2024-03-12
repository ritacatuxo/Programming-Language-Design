package ast.types;

import ast.definitions.VarDefinition;
import ast.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{

    private List<VarDefinition> parameters;
    private Type returnType;

    public FunctionType(int line, int column, List<VarDefinition> parameters, Type returnType) {
        super(line, column);
        this.parameters = new ArrayList<>(parameters);
        this.returnType =returnType;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "arguments=" + parameters +
                ", return type=" + returnType +
                '}';
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
