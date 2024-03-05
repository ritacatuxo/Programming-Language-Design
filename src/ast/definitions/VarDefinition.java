package ast.definitions;

import ast.errorhandler.ErrorHandler;
import ast.types.ErrorType;
import ast.types.RecordField;
import ast.types.Type;

import java.util.HashMap;
import java.util.Map;

public class VarDefinition extends AbstractDefinition{

    private int offset;
    private Map<String, VarDefinition> st = new HashMap<>();
    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }


    public void checkDuplicatedVariables(){

        if(st.containsKey(this.getName())) {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), String.format("The variable %s has already been defined.", this.getName()));
            ErrorHandler.getInstance().addError(error);
        }
        else
            st.put(this.getName(), this);

    }


    @Override
    public String toString() {
        return "VarDefinition{" +
                "offset=" + offset +
                '}';
    }
}
