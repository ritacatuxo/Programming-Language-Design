package ast.expressions;

import ast.definitions.Definition;
import visitor.Visitor;

public class Variable extends AbstractExpression{

    private String name;
    private Definition definition; // the variable definition

    public Variable(int line, int column, String name){
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Definition getDefinition() {
        return definition;
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
