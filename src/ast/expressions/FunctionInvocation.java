package ast.expressions;


import ast.statements.Statement;
import visitor.Visitor;
import ast.types.Type;

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

    public List<Expression> getParameters() {
        return parameters;
    }

    public Variable getVar() {
        return var;
    }

    @Override
    public String toString() {
        String toString = "FunctionInvocation = " + var + "parameters=";
        for (Expression exp : this.parameters) {
            toString += exp + " - ";
        }
        return toString;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type getReturnType() {
        return null;
    }

    @Override
    public void setReturnType(Type t) {

    }
}

