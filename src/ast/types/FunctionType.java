package ast.types;

import ast.definitions.VarDefinition;
import ast.expressions.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{

    private List<VarDefinition> parameters;
    private Type returnType;

    public FunctionType(int line, int column, List<VarDefinition> parameters, Type returnType) {
        super(line, column);
        this.parameters = new ArrayList<>(parameters);
        this.returnType =returnType;
    }

    public List<VarDefinition> getParameters() {
        return parameters;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "arguments=" + parameters +
                ", return type=" + returnType +
                '}';
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type parenthesis(int line, int column, List<Expression> paramsType ) {
        // check the number of arguments is the same as the number of parameters
        if (parameters.size() != paramsType.size()) {
            if (parameters.size() > paramsType.size()) // we need more params
                return new ErrorType(line, column, "[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "There are missing some parameters in the function invocation.");
            else
                return new ErrorType(line, column, "[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "There are too many parameters provided in the function invocation.");
        }
        // check the type of each argument is the same as the type each parameters
        else {
            for (int i = 0; i < paramsType.size(); i++) {

                if (!paramsType.get(i).getType().equals(parameters.get(i).getType()))
                    return new ErrorType(paramsType.get(i).getLine(), paramsType.get(i).getColumn(),
                            "[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "The arguments do not match with the parameters");
            }

            return this.returnType;
        }
    }

}
