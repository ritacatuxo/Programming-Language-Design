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

    public int getSize() {
        return size;
    }
    public Type getType() {
        return type;
    }
}
