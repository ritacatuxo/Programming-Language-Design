package ast.types;

import ast.errorhandler.ErrorHandler;
import ast.semantic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

// Struct
public class RecordType extends AbstractType {

    private List<RecordField> recordFields;

    public RecordType(int line, int column) {
        super(line, column);
        this.recordFields = new ArrayList<>();
    }



    /**
     * Adss all the recordFields passed as parameter to the fields of the RecordType, by checking whether they repeated
     */
    public void addRecordFields(List<RecordField> recordFields) {

        for(RecordField field : recordFields)
        {
            if(repeatedFieldName(field)) {
                new ErrorType(field.getLine(), field.getColumn(),
                        String.format("The struct field \"%s\" has already been defined.", field.getFieldName()));
            }
            else {
                this.recordFields.add(field);
            }
        }

        //this.recordFields.addAll(fields);
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

    @Override
    public String toString() {
        return "RecordType{" +
                "recordFields=" + recordFields + '}';
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
