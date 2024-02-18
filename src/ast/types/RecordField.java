package ast.types;

// Struct {
//     int field; <--
// } structName;
public class RecordField {

    private Type type;
    private String fieldName;

    public RecordField(Type type, String fieldName) {
        this.type = type;
        this.fieldName = fieldName;
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
}
