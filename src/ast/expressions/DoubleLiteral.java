package ast.expressions;

import visitor.Visitor;

public class DoubleLiteral extends AbstractExpression{

    private double value;
    public DoubleLiteral(int line, int column, double value){
        super(line, column);
        this.value = value;
    }


    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DoubleLiteral{" +
                "value=" + value +
                '}';
    }


    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
