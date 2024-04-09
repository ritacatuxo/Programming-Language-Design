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

    @Override
    public Type comparison(int line, int column, Type t)  {

        if (t instanceof CharType) {
            return new IntType(line, column);
        } else {
            return new ErrorType(line, column,
                    String.format("[TYPE CHECKING] A comparison operation cannot be performed for the types char and %s", t));
        }
    }

    @Override
    public Type castTo(int line, int column, Type castTo){
        if (castTo instanceof IntType)
            return new IntType(line, column);
        else if (castTo instanceof DoubleType)
            return new DoubleType(line, column);
        else if (castTo instanceof CharType)
            return new CharType(line, column);
        else
            return new ErrorType(line, column,
                    String.format("[TYPE CHECKING] A cast operation cannot be applied for %s and %s", this, castTo));
    }
}
