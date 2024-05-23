package ast.types;

import ast.ASTNode;
import ast.expressions.Expression;

import java.util.List;

public interface Type extends ASTNode {

    int numberOfBytes();

    // suffix that the type uses for instructions
    String getSuffix();


    // expressions

    Type arithmetic(int line, int column, Type other);
    Type modulus(int line, int column, Type t);
    Type logical(int line, int column, Type type);
    Type toUnaryNot(int line, int column);
    Type toUnaryMinus(int line, int column);
    Type comparison(int line, int column, Type other);
    Type dot(int line, int column, String fieldName); // fieldAccess
    Type castTo(int line, int column, Type castTo);
    Type squareBrackets(int line, int column, Type indexer);
    Type parenthesis(int line, int column, List<Expression> paramsType );

    // statements
    void assignTo(int line, int column, Type t);
    void mustBeReadable(int line, int column);
    void mustBeWritable(int line, int column);
    void mustBeBoolean(int line, int column);
    void returnAs(int line, int column, Type t);


}
