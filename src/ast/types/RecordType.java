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
    private Map<String, RecordField> st = new HashMap<>();

    public RecordType(int line, int column) { //}, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<>();
    }


    public void checkDuplicatedFields(){

        for(RecordField field : recordFields)
        {
            if(st.containsKey(field.getFieldName())) {
                ErrorType error = new ErrorType(field.getLine(), field.getColumn(), String.format("The struct %s has already been defined.", field.getFieldName()));
                ErrorHandler.getInstance().addError(error);
            }
            else
                st.put(field.getFieldName(), field.getDefinition());
        }

    }

    public void addRecordFields(List<RecordField> recordFields) {
        this.recordFields.addAll(recordFields);
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "recordFields=" + recordFields + '}';
    }
}
