package ast.expressions;

public class DoubleLiteral extends AbstractExpression{

    private double value;
    public DoubleLiteral(int line, int column, double value){
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleLiteral{" +
                "value=" + value +
                '}';
    }
}
