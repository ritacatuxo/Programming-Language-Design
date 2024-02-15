package ast.expressions;

public class Variable extends AbstractExpression{

    private String name;

    public Variable(int line, int column, String value){
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
