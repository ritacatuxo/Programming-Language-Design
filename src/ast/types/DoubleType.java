package ast.types;

import ast.semantic.Visitor;

public class DoubleType extends AbstractType{

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
