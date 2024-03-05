package ast.types;

import ast.ASTNode;

// Struct {
//     int field; <-- NO SON VARDEFINITINS bc necesitan .field
// } structName;
public class RecordField implements ASTNode {

    private int line;
    private int column;
    private Type type;
    private String fieldName;
    private RecordField definition; // esto esta bien? record field deberia tener una definition ya que es casi lo mismo que variable

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

    public String getFieldName() {
        return fieldName;
    }


    public String getDefinition() {
        return this.definition;
    }

    @Override
    public String toString() {
        return "RecordField{" +
                " type=" + type +
                ", fieldName=" + fieldName +
                '}';
    }
}
