package ast.definitions;

import ast.types.Type;
import visitor.Visitor;

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

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
