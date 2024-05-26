package ast.types;

import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

// Struct
public class RecordType extends AbstractType {

    private List<RecordField> recordFields;

    public RecordType(int line, int column) {
        super(line, column);
        this.recordFields = new ArrayList<>();
    }

    public int numberOfBytes() {
        return this.recordFields.stream().mapToInt(field -> field.getType().numberOfBytes()).sum();
    }


    /**
     * Adds all the recordFields passed as parameter to the fields of the RecordType, by checking whether they repeated
     */
    public void addRecordFields(List<RecordField> recordFields) {

        for(RecordField field : recordFields)
        {
            if(repeatedFieldName(field)) {
                new ErrorType(field.getLine(), field.getColumn(),
                        "[SEMANTIC ERROR] [Line: " + field.getLine() + " Column: " + field.getColumn() + "] " +
                                "The struct field " + field.getFieldName() + " has already been defined.");
            }
            else {
                this.recordFields.add(field);
            }
        }

    }

    private boolean repeatedFieldName(RecordField rf){
        for(RecordField recordFile : this.recordFields){
            if(recordFile.getFieldName().equals(rf.getFieldName()))
                return true;
        }
        return false;
    }


    public List<RecordField> getRecordFields() {
        return recordFields;
    }

    public RecordField getRecordField(String fieldName) {
        for (RecordField rf : this.recordFields) {
            if (rf.getFieldName().equals(fieldName))
                return rf;
        }

        throw new RuntimeException("There is no field with name '" + fieldName + "'");
    }


    @Override
    public String toString() {
        return "record(" + recordFields + ')';
    }

    @Override
    public <TR, TP> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }


    public Type dot(int line, int column, String fieldName) {
        for (RecordField field : this.recordFields) {
            if (field.getFieldName().toLowerCase().equals(fieldName.toLowerCase()))
                return field.getType();
        }

        return new ErrorType(line, column,
                String.format("[TYPE CHECKING] [Line: " + line + " Column: " + column + "] " +
                        "There is no field with the identifier %s", fieldName));

    }

}
