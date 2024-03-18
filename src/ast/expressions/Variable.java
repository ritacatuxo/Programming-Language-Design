package ast.expressions;

import ast.semantic.Visitor;

public class Variable extends AbstractExpression{

    private String name;

    public Variable(int line, int column, String name){
        super(line, column);
        this.name = name;
    }


    @Override
    public String toString() {
        return "Variable = " + name;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
