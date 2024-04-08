package ast.types;

import ast.errorhandler.ErrorHandler;
import ast.semantic.visitor.Visitor;

public class ErrorType extends AbstractType{

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }


    @Override
    public String toString() {
        return "Error: " + message;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }


    @Override
    public Type arithmetic(int line, int column, Type t){
        return this;
    }

    @Override
    public Type modulus(int line, int column, Type t){
        return this;
    }

    @Override
    public Type logical(int line, int column, Type t){
        return this;
    }
}
