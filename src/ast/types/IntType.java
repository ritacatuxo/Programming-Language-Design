package ast.types;

import ast.semantic.visitor.Visitor;

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

    // type checking
    @Override
    public Type arithmetic(int line, int column, Type t){
        if (t instanceof ErrorType)
            return t;
        return new IntType(line, column);
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
        return new IntType(line, column);
    }

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

        if (t instanceof IntType) {
            return new IntType(line, column);
        } else {
            return new ErrorType(line, column,
                    String.format("[TYPE CHECKING] A comparison operation cannot be performed for the types integer and %s", t));
        }
    }




}
