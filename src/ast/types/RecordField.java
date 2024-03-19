package ast.types;

import ast.ASTNode;
import ast.semantic.visitor.Visitor;

// Struct {
//     int field; <-- NO SON VARDEFINITINS bc necesitan .field
// } structName;
public class RecordField implements ASTNode {

    private int line;
    private int column;
    private Type type;
    private String fieldName;

    public RecordField(int line, int column, Type type, String fieldName) {

        this.type = type;
        this.fieldName = fieldName;
        this.line = line;
        this.column = column;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return null;
    }

    public String getFieldName() {
        return fieldName;
    }


    @Override
    public String toString() {
        return "RecordField{" +
                " type=" + type +
                ", fieldName=" + fieldName +
                '}';
    }
}
