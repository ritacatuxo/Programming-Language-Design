package ast.types;

import ast.semantic.visitor.Visitor;

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

    @Override
    public Type arithmetic(int line, int column, Type t){
        return new DoubleType(line, column);
    }

    @Override
    public Type toUnaryMinus(int line, int column){
        return new DoubleType(line, column);
    }
}
