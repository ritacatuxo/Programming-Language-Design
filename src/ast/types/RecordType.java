package ast.types;

import java.util.ArrayList;
import java.util.List;

// Struct
public class RecordType extends AbstractType {

    private List<RecordField> recordFields;
    public RecordType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<RecordField>(recordFields);
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "recordFields=" + recordFields + '}';
    }
}
