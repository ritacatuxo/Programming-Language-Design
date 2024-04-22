package codegeneration;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Write;

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
        cg.comment("\t' * Read");

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
        cg.comment("\t' * Write");

        write.getExpression().accept(addressCGVisitor, param);

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
     * execute[[FuncDefinition definition -> type ID definition* statement*]] =
     * 		ID <:>
     * 		<' * Parameters: >
     * 		execute[[type]]
     *
     * 		<' * Local variables: >
     * 		definition*.forEach(def -> execute[[def]]))
     *
     * 		<enter > -definition*.get(definition*.size()-1).offset
     */
    @Override
    public Void visit(FuncDefinition funcDefinition, Object param) {
        cg.line(funcDefinition.getLine());
        cg.comment(funcDefinition.getName() + ":\n");
        cg.comment("\t' * Parameters:");
        funcDefinition.getType().accept(this, param);

        cg.comment("\t' * Local variables:");
        for(Definition localVariable : funcDefinition.getVarDefinitions()){
            localVariable.accept(this, param);
        }

        List<VarDefinition> locals = funcDefinition.getVarDefinitions();
        int totalLocalBytes = locals.get(locals.size() - 1).getOffset();
        cg.comment("\tenter " + totalLocalBytes);

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
