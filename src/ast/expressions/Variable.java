package ast.expressions;

import ast.definitions.VarDefinition;
import ast.errorhandler.ErrorHandler;
import ast.types.ErrorType;

import java.util.HashMap;
import java.util.Map;

public class Variable extends AbstractExpression{

    private String name;
    private VarDefinition definition;
    private Map<String, VarDefinition> st = new HashMap<>();

    public Variable(int line, int column, String name){
        super(line, column);
        this.name = name;
    }

    public void linkToVarDefinitions(){
        if(st.containsKey(name)) {
            ErrorType error = new ErrorType(getLine(), getColumn(), String.format("The variable %s is not defined.", name));
            ErrorHandler.getInstance().addError(error);
        }
        else
            this.definition = st.get(name);
    }

    @Override
    public String toString() {
        return "Variable = " + name;
    }
}
