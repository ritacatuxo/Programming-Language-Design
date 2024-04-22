package ast.types;

import visitor.Visitor;

public class VoidType extends AbstractType{


    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return null;
    }
}
