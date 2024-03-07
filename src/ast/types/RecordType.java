package ast.types;

import ast.definitions.VarDefinition;
import ast.errorhandler.ErrorHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Struct
public class RecordType extends AbstractType {

    private List<RecordField> recordFields;

    public RecordType(int line, int column) {
        super(line, column);
        this.recordFields = new ArrayList<>();
    }


    private void checkDuplicatedFields(List<RecordField> recordFields){

        List<String> fieldNames = new ArrayList<>();
        for(RecordField field : recordFields)
        {
            if(checkFieldName(field.getFieldName()) || fieldNames.contains(field.getFieldName())) {
                ErrorType error = new ErrorType(field.getLine(), field.getColumn(), String.format("The struct field \"%s\" has already been defined.", field.getFieldName()));
                ErrorHandler.getInstance().addError(error);
                System.out.println("aaaaa" + field.getFieldName());
            }
            else
                fieldNames.add(field.getFieldName());
        }

    }

    /**
     * Checks whether the recordFIelds attribute contains any attribute with the same fieldName as the one passed as paameter
     */
    private boolean checkFieldName(String fieldName){
        for(RecordField recordField : this.recordFields){
            if(recordField.getFieldName().equals(fieldName))
                return true;
        }
        return false;
    }

    public void addRecordFields(List<RecordField> recordFields) {

        checkDuplicatedFields(recordFields);
        this.recordFields.addAll(recordFields);
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "recordFields=" + recordFields + '}';
    }
}
