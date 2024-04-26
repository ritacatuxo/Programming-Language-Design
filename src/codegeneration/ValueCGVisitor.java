package codegeneration;

import ast.expressions.*;

public class ValueCGVisitor extends AbstractCGVisitor<Object, Void>{

    private final CodeGenerator cg;
    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg, AddressCGVisitor addressCGVisitor) {
        this.cg = cg;
        this.addressCGVisitor = addressCGVisitor;
    }
    // only for expressions

    /**
     * value[[IntLiteral: expression -> INT_CONSTANT]] =
     * 		<pushi> INT_CONSTANT
     */
    @Override
    public Void visit(IntLiteral intLiteral, Object param) {
        cg.pushi(intLiteral.getValue());
        return null;
    }

    /**
     * value[[CharLiteral: expression -> CHAR_CONSTANT]] =
     * 		<pushb> CHAR_CONSTANT
     */
    @Override
    public Void visit(CharLiteral charLiteral, Object param) {
        cg.pushb(charLiteral.getValue());
        return null;
    }

    /**
     * value[[RealConstant: expression -> REAL_CONSTANT]] =
     * 		<pushf> REAL_CONSTANT
     */
    @Override
    public Void visit(DoubleLiteral doubleLiteral, Object param) {
        cg.pushf(doubleLiteral.getValue());
        return null;
    }

    /**
     * value[[Variable: expression -> ID]] =
     * 		address[[expression]]
     * 		<load> expression.type.suffix()
     */
    @Override
    public Void visit(Variable variable, Object param) {
        variable.accept(addressCGVisitor, param);
        cg.load(variable.getType());
        return null;
    }

    /**
     * value[[Arithmetic: expression1 -> expression2 (+ || - || * || / || %) expression3]] =
     * 		value[[expression2]]
     * 		exp2.type.convertTo(exp1.type);
     * 		value[[expression3]]
     * 		exp3.type.convertTo(exp1.type);
     * 		switch(expression1.operator) {
     * 			case "+": <add> expression1.type.suffix()
     * 						break;
     * 			case "-": <sub> expression1.type.suffix()
     * 						break;
     * 			case "*": <mul> expression1.type.suffix()
     * 						break;
     * 			case "/": <div> expression1.type.suffix()
     * 						break;
     * 			case "%": <modi>
     * 						break;
     * 		}
     */
    @Override
    public Void visit(Arithmetic arithmetic, Object param) {
        arithmetic.getLeft().accept(this, param);
        cg.convertTo(arithmetic.getLeft().getType(), arithmetic.getType());

        arithmetic.getRight().accept(this, param);
        cg.convertTo(arithmetic.getRight().getType(), arithmetic.getType());

        switch (arithmetic.getOperator()){
            case "+": cg.add(arithmetic.getType()); break;
            case "-": cg.sub(arithmetic.getType()); break;
            case "*": cg.mul(arithmetic.getType()); break;
            case "/": cg.div(arithmetic.getType()); break;
        }

        return null;
    }

    public Void visit(Modulus modulus, Object param) {
        modulus.getLeft().accept(this, param);
        cg.convertTo(modulus.getLeft().getType(), modulus.getType());
        modulus.getRight().accept(this, param);
        cg.convertTo(modulus.getRight().getType(), modulus.getType());

        cg.mod(modulus.getType());
        return null;
    }

    @Override
    public Void visit(UnaryNot negation, Object param) {
        negation.getExpression().accept(this, param);
        cg.negation();
        return null;
    }

    /**
     * value[[Comparison: expression1 -> expression2 expression3]] =
     * 		Type superType = expression1.highestType(expression2.type);
     * 		value[[expression2]]
     * 		expression2.type.highestType(superType);
     * 		value[[expression3]]
     * 		expression3.type.convertTo(superType);
     *
     * 		switch(expression1.operator) {
     * 			case ">": <gt> expression1.type.suffix()
     * 						break;
     * 			case "<": <lt> expression1.type.suffix()
     * 						break;
     * 			case ">=": <ge> expression1.type.suffix()
     * 						break;
     * 			case "<=": <le> expression1.type.suffix()
     * 						break;
     * 			case "==": <eq> expression1.type.suffix()
     * 						break;
     * 			case "!=": <ne> expression1.type.suffix()
     * 						break;
     * 		        }
     */
    @Override
    public Void visit(Comparison comparison, Object param) {
        comparison.getLeft().accept(this, param);
        cg.convertTo(comparison.getLeft().getType(), comparison.getType());

        comparison.getRight().accept(this, param);
        cg.convertTo(comparison.getRight().getType(), comparison.getType());

        switch (comparison.getOperator()){
            case ">": cg.greaterThan(comparison.getType()); break;
            case "<": cg.lowerThan(comparison.getType()); break;
            case ">=": cg.greaterOrEqualTo(comparison.getType()); break;
            case "<=": cg.lowerOrEqualTo(comparison.getType()); break;
            case "==": cg.equalTo(comparison.getType()); break;
            case "!=": cg.notEqualTo(comparison.getType()); break;
        }

        return null;
    }

    /**
     * value[[Logical: expression1 -> expression2 (&& | ||) expression3]] =
     * 		value[[expression2]] // call accept logical.get(opp!).accept();
     * 		value[[expression3]]
     * 		switch(expression1.operator) {
     * 			case "&&": <and>
     * 						break;
     * 			case "||": <or>
     * 						break;
     * 			default: assert false;
     * 		        }
     */
    @Override
    public Void visit(Logical logical, Object param) {
        logical.getLeft().accept(this, param);
        logical.getRight().accept(this, param);

        switch (logical.getOperator()){
            case "&&": cg.and(); break;
            case "||": cg.or(); break;
        }
        return null;
    }

    /**
     * value[[Cast: expression1 -> type expression2]] =
     * 		value[[expression2]]
     * 		expression2.type.convertTo(type)
     */
    @Override
    public Void visit(Cast cast, Object param) {
        cast.getExpression().accept(this, param);
        cg.convertTo(cast.getExpression().getType(), cast.getCastType());
        return null;
    }

    public void setAddressCGVisitor(AddressCGVisitor address) {
        this.addressCGVisitor = address;
    }


}
