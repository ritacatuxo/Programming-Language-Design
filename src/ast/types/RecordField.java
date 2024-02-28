package ast.types;

import ast.ASTNode;

// Struct {
//     int field; <--
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
