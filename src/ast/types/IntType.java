package ast.types;

import visitor.Visitor;

public class IntType extends AbstractType{


    public IntType(int line, int column) {
        super(line, column);
    }


    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }


    public static IntType getInstance(){
        return new IntType(0,0);
    }
    @Override
    public int numberOfBytes() {
        return 2;
    }
    @Override
    public String getSuffix() {
        return "i";
    }

    // type checking
    @Override
    public Type arithmetic(int line, int column, Type t){
        if (t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return new IntType(line, column);
        if (t instanceof CharType) // char + int = int ('a' = ASCII code)
            return new IntType(line, column);
        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "]" +
                        "An arithmetic operation cannot be performed for the types integer and %s", t));

    }

    @Override
    public Type modulus(int line, int column, Type t) {
        if (t instanceof ErrorType)
            return t;
        return new IntType(line, column);
    }

    @Override
    public Type logical(int line, int column, Type t) {
        if (t instanceof ErrorType)
            return t;
        if(t instanceof IntType)
            return new IntType(line, column);
        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "A logical operation cannot be performed for the types integer and %s", t));
    }

    // This is the only class that is a boolean
    public void mustBeBoolean(int line, int col) {    }

    @Override
    public Type toUnaryMinus(int line, int column){
        return new IntType(line, column);
    }
    @Override
    public Type toUnaryNot(int line, int column){
        return new IntType(line, column);
    }
    /*
    Comparison operators (>, <,	>=,	<=,	==	and	!=)	are	applicable to two chars,
    two	integers or	two doubles, and they always return	int
     */
    @Override
    public Type comparison(int line, int column, Type t)  {
        if(t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return new IntType(line, column);

        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "A comparison operation cannot be performed for the types integer and %s", t));
    }

    @Override
    public Type castTo(int line, int column, Type castTo){
        if (castTo instanceof IntType)
            return new IntType(line, column);
        else if (castTo instanceof DoubleType)
            return new DoubleType(line, column);
        else if (castTo instanceof CharType)
            return new CharType(line, column);
        else {
            return new ErrorType(line, column,
                    String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                            "A cast operation cannot be applied for %s and %s", this, castTo));
        }
    }

    @Override
    public Type assignTo(int line, int column, Type t) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return t;
        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "An assignment operation cannot be performed for the types int and %s", t));
    }

    @Override
    public void mustBeReadable(int line, int column){

    }

    @Override
    public void mustBeWritable(int line, int column){

    }

    public void returnAs(int line, int column, Type t){
        if (!(t instanceof IntType))
            new ErrorType(line, column, "[TYPECHECKING] Type " + t + " is not equivalent to Integer");
    }


}
