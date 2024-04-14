package ast.types;

import ast.semantic.visitor.Visitor;

// int[13] --> size = 13 and type = IntType
public class ArrayType extends AbstractType{

    private int size;
    private Type type;
    public ArrayType(int line, int column, int size, Type type) {
        super(line, column);
        this.size = size;
        this.type = type;
    }


    /**
     * As the creation of the array is recursive, this method acts as a factory creating the array in the good way
     */
    public static ArrayType createArray(int size, Type previousType){

        //check if previous type is ArrayType, so we cannot use construcor
        if (previousType instanceof ArrayType) {
            ArrayType other = (ArrayType) previousType;
            other.setType(createArray(size, other.getType()));
            return other;
        }
        else return new ArrayType(previousType.getLine(), previousType.getColumn(), size, previousType);
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "size=" + size +
                ", type=" + type +
                '}';
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type squareBrackets(int line, int column, Type indexer) {
        if (indexer instanceof ErrorType)
            return indexer;
        if (indexer instanceof IntType)
            return this.type;
        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "An array cannot be indexed when the index is not an integer %s ", indexer));
    }
}
