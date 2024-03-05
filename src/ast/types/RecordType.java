package ast.types;

import java.util.ArrayList;
import java.util.List;

// Struct
public class RecordType extends AbstractType {

    private List<RecordField> recordFields;
    public RecordType(int line, int column) { //}, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<>();
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
