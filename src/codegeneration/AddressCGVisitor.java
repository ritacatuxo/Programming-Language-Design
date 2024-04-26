package codegeneration;

import ast.expressions.Variable;
import ast.types.IntType;

public class AddressCGVisitor extends AbstractCGVisitor<Object, Void>{

    private CodeGenerator cg;
    public AddressCGVisitor(CodeGenerator cg){
        this.cg = cg;
    }


    // only for l-values


    /**
     * -- VARIABLE --
     * address[[Variable: expression -> type ID]] =
     * 		if(expression.deffinition.scope == 0)
     * 			<pusha > expression.definition.offset
     * 		else{
     * 			<push bp>
     * 			<pushi > expression.definition.offset
     * 			<addi>
     * 		}
     */
    @Override
    public Void visit(Variable variable, Object param) {
        if(variable.getDefinition().getScope() == 0)
            cg.pusha(variable.getDefinition().getOffset());
        else {
            // push bp, the offset and then add
            cg.pushBP();
            cg.pushi(variable.getDefinition().getOffset());
            cg.add(IntType.getInstance());
        }

        return null;
    }



}
