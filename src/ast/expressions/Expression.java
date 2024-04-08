package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {

    boolean getLvalue();
    void setLvalue(boolean lvalue);

    // type to infer the type of each expression (TypeCheckingVisitor)
    Type getType();
    void setType(Type type);

}
