package codegeneration;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Expression;
import ast.expressions.FunctionInvocation;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<Object, Void> {

    private final ValueCGVisitor valueCGVisitor;
    private final AddressCGVisitor addressCGVisitor;
    private final CodeGenerator cg;

    public ExecuteCGVisitor(CodeGenerator cg, ValueCGVisitor valueCGVisitor, AddressCGVisitor addressCGVisitor) {
        this.cg = cg;
        this.valueCGVisitor = valueCGVisitor;
        this.addressCGVisitor = addressCGVisitor;
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
     * execute[[WhileStmt: statement -> expression statement*]] =
     * 	    String condLabel = cg.nexTLabel();
     * 	    String exitLabel = cg.nextLabel();
     * 	    condLabel<:>
     * 	    value[[expression]]
     * 	    <jz > exitLabel
     * 	    statement*.forEach(stmt -> execute[[stmt]]) // while body
     * 	    <jmp > condLabel
     * 	    exitLabel<:>
     */
    @Override
    public Void visit(While whileStmt, Object param) {
        String condLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();
        cg.line(whileStmt.getLine());

        cg.comment("\t' * While\n");
        cg.comment(condLabel + ":\n");

        whileStmt.getExpression().accept(valueCGVisitor, param);
        cg.jz(exitLabel);

        for(Statement stmt : whileStmt.getBody()){
            stmt.accept(this, param);
        }

        cg.jmp(condLabel);
        cg.comment(exitLabel + ":\n");

        return null;
    }


    /**
     * execute[[IfElse: statement -> expression statement2* statement3*]] =
     * 	    String elseLabel = cg.nextLabel();
     * 	    String exitLabel = cg.nextLabel();
     *  	value[[expression]]
     * 	    <jz > elseLabel
     *  	statement2*.forEach(stmt -> execute[[stmt]]) // if body
     *  	<jmp > exitLabel
     *   	elseLabel <:>
     *  	statement3*.forEach(stmt -> execute[[stmt]]) // else body
     *  	exitLabel <:>
     */
    @Override
    public Void visit(IfElse ifElse, Object param) {
        String elseLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();

        cg.line(ifElse.getLine());
        cg.comment("\t' * If statement\n");

        ifElse.getCondition().accept(valueCGVisitor, param);
        cg.jz(elseLabel);

        for(Statement stmt : ifElse.getIfBody()){ // if body
            stmt.accept(this, param);
        }

        cg.jmp(exitLabel);
        cg.comment(elseLabel + ":\n");

        for(Statement stmt : ifElse.getElseBody()){ // else body
            stmt.accept(this, param);
        }
        cg.comment(exitLabel + ":\n");
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
        cg.comment(funcDefinition.getName() + ":\n");

        if(!funcType.getParameters().isEmpty())
            cg.comment("\t' * Parameters: \n");
        funcDefinition.getType().accept(this, param);

        if(!funcDefinition.getVarDefinitions().isEmpty())
            cg.comment("\t' * Local variables: \n");

        for(Definition localVariable : funcDefinition.getVarDefinitions()){
            localVariable.accept(this, param);
        }

        // BYTES FOR PARAMETERS, LOCAL VARIABLES AND RETURN
        int paramBytes = 0;

        for(VarDefinition parameter : funcType.getParameters()){
            paramBytes += parameter.getType().numberOfBytes();
        }

        List<VarDefinition> localVariables = funcDefinition.getVarDefinitions();
        int localBytes = funcDefinition.getVarDefinitions().isEmpty() ? 0 : -localVariables.get(localVariables.size() - 1).getOffset();

        int returnBytes = funcType.numberOfBytes();

        if(localVariables.size() > 0)
            cg.comment("\tenter " + localBytes);

        int finalParamBytes = paramBytes;
        funcDefinition.getStatements().forEach(stmt -> stmt.accept(this, new ReturnDTO(returnBytes, localBytes, finalParamBytes)));

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

        cg.comment("\n\t' * Global variable(s)\n");
        for (Definition definition : program.getBody()){
            if (definition instanceof VarDefinition)
                definition.accept(this, param);
        }

        cg.comment("\n ' Invocation to the main function\n");
        cg.call("main");
        cg.halt();

        for (Definition definition : program.getBody()){
            if (definition instanceof FuncDefinition)
                definition.accept(this, param);
        }

        return null;
    }


    /**
     * execute[[Return: statement → exp]](int bytesReturn, int bytesLocals, int bytesArgs) =
     * 	    value[[exp]]
     * 	    <ret > bytesReturn <, > bytesLocals <, > bytesArgs
     */
    @Override
    public Void visit(Return ret, Object param) {

        ReturnDTO returnDTO = (ReturnDTO) param;

        ret.getRet().accept(this, param); // param or null?
        cg.comment("\tret " + returnDTO.bytesReturn() + ", " + returnDTO.bytesLocals() + ", " + returnDTO.bytesParams());

        return null;
    }


    /**
     * execute[[FuncInvocation: statement -> expression1 expression2*]] =
     * 	    expression2*.forEach(arg -> value[[arg]]) 					// push arguments
     * 	    <call > expression1.name									// call the function
     * 	    if(! expression1.type.returnType instanceof VoidType)
     * 		    <pop> expression1.type.returnType.suffix()		        // we pop when return type is different from void
     */
    @Override
    public Void visit(FunctionInvocation functionInvocation, Object param) {

        for(Expression arg : functionInvocation.getParameters()){
            arg.accept(valueCGVisitor, param);
        }

        cg.call(functionInvocation.getVar().getName());

        FunctionType funcType = (FunctionType) functionInvocation.getVar().getType();

        if(!(funcType.getReturnType() instanceof VoidType)){
            cg.pop(funcType.getReturnType());
        }

        return null;
    }
}
