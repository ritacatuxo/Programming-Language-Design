package ast.definitions;

import ast.types.Type;

public class VarDefinition extends AbstractDefinition{

    private int offset;
    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }


    @Override
    public String toString() {
        return "VarDefinition{" +
                "offset=" + offset +
                '}';
    }
}
