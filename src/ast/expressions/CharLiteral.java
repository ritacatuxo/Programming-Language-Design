package ast.expressions;

import ast.semantic.Visitor;

public class CharLiteral extends AbstractExpression{

    private char value;
    public CharLiteral(int line, int column, char value){
        super(line, column);
        this.value = value;
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
