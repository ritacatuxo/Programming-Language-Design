package ast.expressions;


public class Indexing extends AbstractExpression {

    private Expression left; //v[a+b] -> v
    private Expression right; //v[a+b] -> a+b

    public Indexing(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }


    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
}
