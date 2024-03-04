package ast.types;

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

    // TG FACTORY
    // la primera vez que lo llamamos type es un int type, the secind time
    public static ArrayType createArray(int line, int column, int size, Type previousType){

        //check if precious type is array type id so we cannot use construcor
        if (previousType instanceof ArrayType) {
            // take obj and insert

            //iteras sobr  la larga lista de AT y
        }
        //go to end and connect objs. Go

    }


*/






    /**
     * As the creation of the array is recursive, this method creates the array in the good way
     */
    public ArrayType buildArray(int size, Type type) {

        if (type instanceof ArrayType) {
            ArrayType other = (ArrayType) type;
            other.setType(buildArray(size, other.getType()));
            return other;
        }
        else return new ArrayType(type.getLine(), type.getColumn(), size, type);
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
}
