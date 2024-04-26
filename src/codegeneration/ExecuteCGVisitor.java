package codegeneration;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Write;
import ast.types.FunctionType;
import ast.types.VoidType;

import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<Object, Void> {

    private final ValueCGVisitor valueCGVisitor;
    private final AddressCGVisitor addressCGVisitor;
    private final CodeGenerator cg;

    public ExecuteCGVisitor(ValueCGVisitor valueCGVisitor, AddressCGVisitor addressCGVisitor, CodeGenerator cg) {
        this.valueCGVisitor = valueCGVisitor;
        this.addressCGVisitor = addressCGVisitor;
        this.cg = cg;
    }

    //only for statements

    /**
     * execute[[Read: statement -> expression]] =
     * 		address[[expression]]
     * 		<in> expression.type.suffif()
     * 		<store> expression.type.suffix()
     */
    @Override
    public Void visit(Read read, Object param) {
        cg.line(read.getLine());
        cg.comment("\t' * Read\n");

        read.getExpression().accept(addressCGVisitor, param);

        cg.in(read.getExpression().getType());
        cg.store(read.getExpression().getType());

        return null;
    }


    /**
     * execute[[Write: statement -> expression]] =
     * 		address[[expression]]
     * 		<out> expression.type.suffix()
     */
    @Override
    public Void visit(Write write, Object param) {
        cg.line(write.getLine());
        cg.comment("\t' * Write \n");

        write.getExpression().accept(valueCGVisitor, param);

        cg.out(write.getExpression().getType());

        return null;
    }

    /**
     * execute[[Assignment: statement -> expression1 expression2]] =
     * 		address[[expression1]]
     * 		value[[expression2]]
     * 		<store> expression1.type.suffix()
     */
    @Override
    public Void visit(Assignment assignment, Object param) {
        cg.line(assignment.getLine());
        assignment.getLeft().accept(addressCGVisitor, param);
        assignment.getRight().accept(valueCGVisitor, param);
        cg.store(assignment.getLeft().getType());

        return null;
    }


    /**
     * execute[[VarDefinition: definition -> type ID]] =
     * 		<' * > type ID < (offset > definition.offset < )>
     */
    @Override
    public Void visit(VarDefinition varDefinition, Object param) {
        cg.comment("\t' * " + varDefinition.getType() + " " + varDefinition.getName() + " " +
                " (offset " + varDefinition.getOffset() + " )\n");
        return null;
    }


    /**
     *
     * 	-- FUNCTION DEFINITION --
     * 	execute[[FuncDefinition definition -> type ID definition* statement*]] =
     * 		ID <:>
     * 		<' * Parameters: >
     * 		execute[[type]]
     *
     * 		<' * Local variables: >
     * 		definition*.forEach(def -> execute[[def]]))
     *
     * 		int paramsBytes = 0;
     * 		for(VarDefinition param: type.getParameter){
     * 			paramsBytes += param.type.numberOfBytes();
     * 		        }
     * 		int localsBytes = definition*.isEmpty() ? 0 : -definition*.get(definition*.size()-1).offset
     * 		int returnBytes = type.returunType.numberOfBytes();
     *
     *
     * 		if(definition*.size() > 0)
     * 			<enter > -definition*.get(definition*.size()-1).offset
     *
     * 		// func body
     * 		statement*.forEach(stmt -> execute[[stmt]])
     *
     * 		if(type.returnType instanceof VoidType)
     * 			<ret > returnBytes <, > localsBytes <, > paramsBytes
     *
     */
    @Override
    public Void visit(FuncDefinition funcDefinition, Object param) {
        FunctionType funcType = (FunctionType) funcDefinition.getType();

        cg.line(funcDefinition.getLine());
        cg.comment("\t" + funcDefinition.getName() + ":\n");
        if(!funcType.getParameters().isEmpty())
            cg.comment("\t' * Parameters:");
        funcDefinition.getType().accept(this, param);

        if(!funcDefinition.getVarDefinitions().isEmpty())
            cg.comment("\t' * Local variables:");

        for(Definition localVariable : funcDefinition.getVarDefinitions()){
            localVariable.accept(this, param);
        }

        // BYTES FOR PARAMETERS, LOCAL VARIABLES AND RETURN
        int paramBytes = 0;

        for(VarDefinition parameter : funcType.getParameters()){
            paramBytes += parameter.getType().numberOfBytes();
        }

        List<VarDefinition> localVariables = funcDefinition.getVarDefinitions();
        int localBytes = funcDefinition.getVarDefinitions().isEmpty() ? 0 : localVariables.get(localVariables.size() - 1).getOffset();

        int returnBytes = funcType.numberOfBytes();

        if(localVariables.size() > 0)
            cg.comment("\tenter " + localBytes);

        funcDefinition.getStatements().forEach(stmt -> stmt.accept(this, param));

        if(funcType.getReturnType() instanceof VoidType)
            cg.comment("\tret " + returnBytes + ", " + localBytes + ", " + paramBytes);

        return null;
    }

    /**
     * execute[[Program: program -> definition*]] =
     * 		<call main>
     * 		<halt>
     * 		definition*.forEach(def -> execute[[def]])
     */
    @Override
    public Void visit(Program program, Object param) {
        cg.comment("' Invocation to the main function\n");
        cg.call("main");
        cg.halt();

        for(Definition def : program.getBody()){
            def.accept(this, param);
        }

        return null;
    }
}
