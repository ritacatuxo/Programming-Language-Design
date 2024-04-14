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
        if (t instanceof ErrorType)
            return t;
        if (t instanceof DoubleType)
            return this;
        return new ErrorType(line, column, String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                "An arithmetic cannot be performed for the types %s and %s.", t, this
        ));

    }

    @Override
    public Type toUnaryMinus(int line, int column){
        return new DoubleType(line, column);
    }

    @Override
    public Type comparison(int line, int column, Type t)  {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof DoubleType)
            return new IntType(line, column);
        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "A comparison operation cannot be performed for the types double and %s", t));

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
                    String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                            " A cast operation cannot be applied for %s and %s", this, castTo));
    }

    @Override
    public Type assignTo(int line, int column, Type t) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof DoubleType)
            return t;
        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "An assignment operation cannot be performed for the types %s and double", t));
    }


    @Override
    public void mustBeReadable(int line, int column){
    }

    @Override
    public void mustBeWritable(int line, int column){
    }
}
