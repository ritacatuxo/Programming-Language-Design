package ast.types;

public class CharType extends AbstractType{
    private char value;
    
    public CharType(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }


    // para que compile
    public CharType() {
        super(0, 0);
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
