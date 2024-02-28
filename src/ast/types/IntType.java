package ast.types;

public class IntType extends AbstractType{
    private int value;

    public IntType(int line, int column) {
        super(line, column);
    }

    // para que compile
    public IntType() {
        super(0, 0);
    }

    private int getInt(){
        return value;
    }
}
