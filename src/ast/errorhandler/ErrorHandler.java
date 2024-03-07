package ast.errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private List<ErrorType> errors;
    private static ErrorHandler instance = new ErrorHandler();

    private ErrorHandler() {

        this.errors = new ArrayList<>();
    }

    public static ErrorHandler getInstance() {
        return instance;
    }

    public boolean anyErrors() {
        return !this.errors.isEmpty();
    }

    public void showErrors(PrintStream out){
        if(this.errors.isEmpty())
            out.println("No errors");
        else {
            for(ErrorType error: this.errors) {
                out.println(error.toString());
            }
        }
    }

    public void addError(ErrorType error){
        this.errors.add(error);
    }

}
