package ast.expressions;


import ast.visitor.Visitor;

public class Indexing extends AbstractExpression {

    private Expression left; //v[a+b] -> v
    private Expression right; //v[a+b] -> a+b

    public Indexing(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Indexing = " +
                left + "[" +
                right + "]";
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
