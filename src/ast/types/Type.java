package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {



    Type arithmetic(Type other, ASTNode node);
    boolean isModulus();
    boolean isLogical();
    Type unaryNot(ASTNode node);
    Type unaryMinus(ASTNode node);
    Type comparison(Type other, ASTNode node);
    Type dot(String fieldName, ASTNode node); // fieldAccess
    Type canCastTo(Type castTo, ASTNode node);
    Type squareBrackets(Type indexer, ASTNode node);
    Type parenthesis(List<Type> paramsTypes, ASTNode node);

}
