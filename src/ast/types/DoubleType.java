package ast.types;

public class DoubleType extends AbstractType{

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "double";
    }

}
