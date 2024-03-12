package ast.expressions;

import ast.definitions.VarDefinition;
import ast.errorhandler.ErrorHandler;
import ast.types.ErrorType;
import ast.visitor.Visitor;

import java.util.HashMap;
import java.util.Map;

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
