package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {


    // expressions

    Type arithmetic(int line, int column, Type other);
    Type modulus(int line, int column, Type t);
    Type logical(int line, int column, Type type);
    Type toUnaryNot(int line, int column);
    Type toUnaryMinus(int line, int column);
    Type comparison(int line, int column, Type other);
    Type dot(int line, int column, String fieldName); // fieldAccess
    Type canCastTo(int line, int column, Type castTo);
    Type squareBrackets(int line, int column, Type indexer);
    Type parenthesis(int line, int column, List<Type> paramsType );

}
