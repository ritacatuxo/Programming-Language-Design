package ast.expressions;


import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    private List<Expression> parameters; // f(a, a+b, (char)n) ...
    private Variable var; // f() -> f

    public FunctionInvocation(int line, int column, List<Expression> parameters, Variable var){
        super(line, column);
        this.parameters = new ArrayList<>(parameters); // clone
        this.var = var;
    }

    @Override
    public String toString() {
        String toString = "FunctionInvocation = " + var + "parameters=";
        for (Expression exp : this.parameters) {
            toString += exp + " - ";
        }
        return toString;
    }

}

