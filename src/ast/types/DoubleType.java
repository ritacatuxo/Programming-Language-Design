package ast.types;

public class DoubleType extends AbstractType{
    private double value;
    public DoubleType(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }
    public DoubleType() {
        super(0, 0);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
