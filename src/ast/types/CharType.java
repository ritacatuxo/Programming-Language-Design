package ast.types;

import ast.semantic.visitor.Visitor;

public class CharType extends AbstractType{

    
    public CharType(int line, int column) {
        super(line, column);
    }



    @Override
    public String toString() {
        return "char";
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(int line, int column, Type t){
        return new CharType(line, column);
    }

    @Override
    public Type toUnaryMinus(int line, int column){
        return new CharType(line, column);
    }
}
