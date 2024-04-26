package codegeneration;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.RecordType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    private int globalsBytesSum = 0;

    /**
     * -- GLOBAL VARS --> &global = SUM(numberOfBytes(prev.globals not including ourself))
     *
     *         (P) VarDefinition: definition -> type ID
     *         (R) if(definition.scope == 0) {
     *                 definition.offset = globalsBytesSum;
     *                 globalsBytesSum += type.numberOfBytes();
     *             }
     */
    public Void visit(VarDefinition varDefinition, Void param) {
        if (varDefinition.getScope() == 0){ // global scope
           varDefinition.setOffset(globalsBytesSum);
           globalsBytesSum += varDefinition.getType().numberOfBytes();
        }

        return null;
    }



    /**
     *  -- LOCAL VARS --> &local = bp - SUM(numberOfBytes(types(prev.locals including itself))
     *
     *         (P) FuncDefinition: funcdefinition -> type ID definition* statement*
     *         (R)
     *             int localsBytesSum = 0;
     *             for(VarDefinition varDef : definition*){
     *                 localsBytesSum += varDef.type.numberOfBytes(); // include itself
     *                 varDef.offset = -localsBytesSum;
     *             }
     */
    public Void visit(FuncDefinition funcDefinition, Void param) {
        int localsBytesSum = 0;

        for (VarDefinition varDef : funcDefinition.getVarDefinitions()) {
            localsBytesSum += varDef.getType().numberOfBytes();
            varDef.setOffset(-localsBytesSum);
        }
        return null;
    }


    /**
     * -- PARAMETERS --> &param = bp + 4 + SUM(numberOfBytes(types(params on the right not including itself))
     *
     *      (P) FunctionType: type1 -> type2 definition*
     *      (R) int paramsBytesSum = 0;
     *      for(VarDefinition varDef : definition*){
     *      varDef.offset = paramsBytesSum + 4;	// params are locals pero "params ont he right not including itselF")
     *      paramsBytesSum += varDef.type.numberOfBytes();
     *      }
     */
    public Void visit(FunctionType functionType, Void param) {
        int paramsBytesSum = 0;

        for(VarDefinition varDef : functionType.getParameters()) {
            varDef.setOffset(paramsBytesSum + 4);
            paramsBytesSum += varDef.getType().numberOfBytes();
        }
        return null;
    }



    /**
     *  -- RECORD FIELDS --> &field = SUM(numberOfBytes(types(prev.fields not including itself)))
     *
     *         (P) RecordType: type -> field*
     *         (R) int fieldsBytesSum = 0;
     *             for(RecordField rf : field*){
     *                 rf.offset = fieldsBytesSum;
     *                 fieldsBytesSum += rf.type.numberOfBytes();
     *             }
     */
    public Void visit(RecordType recordType, Void param) {
        int fieldsBytesSum = 0;

        for(RecordField rf : recordType.getRecordFields()){
            rf.setOffset(fieldsBytesSum);
            fieldsBytesSum += rf.getType().numberOfBytes();
        }

        return null;
    }





















}
