package ast.expressions;

public class Modulus extends AbstractExpression{

    private Expression left;
    private Expression right;


    public Modulus(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Modulus{" + left + "%" + right + '}';
    }
}
