package codegeneration;

import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.IntType;
import ast.types.RecordType;

// only for l-values
public class AddressCGVisitor extends AbstractCGVisitor<Object, Void>{

    private CodeGenerator cg;
    private ValueCGVisitor valueCGVisitor;
    public AddressCGVisitor(CodeGenerator cg){
        this.cg = cg;
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }



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


    /**
     *
     * address[[FieldAccess: expression1 -> expression2 ID]] =
     *  	address[[expression2]]
     *  	<pushi > expression1.type.getField(ID).offset
     *  	<addi>
     *
     */
    @Override
    public Void visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpression().accept(this, param);
        RecordType record = (RecordType) fieldAccess.getExpression().getType();
        cg.pushi(record.getRecordField(fieldAccess.getFieldName()).getOffset());
        cg.add(IntType.getInstance());
        return null;
    }


    /**
     * address[[Indexing: expression1 -> expression2 expression3]] =
     *  	address[[expression2]] // address of v
     *  	value[[expression3]]
     *   	<pushi > expression1.type.numberOfBytes()
     *   	<muli>
     *  	<addi>
     */
    @Override
    public Void visit(Indexing indexing, Object param) {
        indexing.getLeft().accept(this, param);
        indexing.getRight().accept(valueCGVisitor, param);
        cg.pushi(indexing.getType().numberOfBytes());
        cg.mul(IntType.getInstance());
        cg.add(IntType.getInstance());

        return null;
    }
}
