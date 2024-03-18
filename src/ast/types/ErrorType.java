package ast.types;

import ast.semantic.Visitor;

public class ErrorType extends AbstractType{

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
    }


    @Override
    public String toString() {
        return "ErrorType: " + message;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
