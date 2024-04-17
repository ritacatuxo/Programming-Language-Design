package codegeneration;

public class ValueCGVisitor extends AbstractCGVisitor{

    // only for expressions

    /**
     * value[[IntLiteral: expression -> INT_CONSTANT]] =
     * 		<pushi> INT_CONSTANT
     */



    /**
     * value[[CharLiteral: expression -> CHAR_CONSTANT]] =
     * 		<pushb> CHAR_CONSTANT
     */



    /**
     * value[[RealConstant: expression -> REAL_CONSTANT]] =
     * 		<pushf> REAL_CONSTANT
     */



    /**
     * value[[Variable: expression -> ID]] =
     * 		address[[expression]]
     * 		<load> expression.type.suffix()
     */



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
     * 		        }
     */



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



    /**
     * value[[Cast: expression1 -> type expression2]] =
     * 		value[[expression2]]
     * 		expression2.type.convertTo(type)
     */

}
