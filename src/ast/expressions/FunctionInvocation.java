package ast.expressions;


import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    private List<Expression> parameters; // f(a, a+b, (char)n) ...
    private Variable var; // f()

    public FunctionInvocation(int line, int column, List<Expression> parameters, Variable var){
        super(line, column);
        this.parameters = new ArrayList<>(parameters); // clone
        this.var = var;
    }

    public List<Expression> getParameters() {
        return parameters;
    }


    public ast.expressions.Variable getVar() {
        return var;
    }

    public void setVar(ast.expressions.Variable var) {
        this.var = var;
    }
}

