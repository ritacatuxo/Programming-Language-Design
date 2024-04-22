package ast.expressions;

import visitor.Visitor;

public class CharLiteral extends AbstractExpression{

    private char value;
    public CharLiteral(int line, int column, char value){
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CharLiteral = '" + value + "'";
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
