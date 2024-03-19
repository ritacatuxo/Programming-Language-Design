package ast.semantic.visitor;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.semantic.symboltable.SymbolTable;
import ast.statements.Read;
import ast.statements.Statement;
import ast.types.ErrorType;

/**
 * t¡Visitor to link all Variable nodes to their Definition
 */
public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {

        if(symbolTable.findInCurrentScope(varDefinition.getName()) == null) {
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(), "[IDENTIFICATION ERROR] [Line: " + varDefinition.getLine() +
                    " Columnn: " + varDefinition.getColumn() + "] - The variable name "+ varDefinition.getName()+" has already been defined in the scope");

        }

        symbolTable.insert(varDefinition);
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {

        symbolTable.insert(funcDefinition); // insert the function to the global scope
        symbolTable.set(); // create the new scope
        for(VarDefinition parameter : funcDefinition.getVarDefinitions()) {
            symbolTable.insert(parameter);
        } // insert parameters
        for(Statement bodyStatement : funcDefinition.getStatements()) { // insert parameters

        } // traverse its child ?

        symbolTable.reset(); // delete the scope

        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {

        if(symbolTable.findInCurrentScope(variable.getName()) == null) {
            new ErrorType(variable.getLine(), variable.getColumn(), "[IDENTIFICATION ERROR] [Line: " + variable.getLine() +
                    " Columnn: " + variable.getColumn() + "] - The variable name "+ variable.getName()+" has not been defined");

        }

        variable.setDefinition(symbolTable.find(variable.getName()));
        return null;
    }

    @Override
    public Void visit(Read read, Void param) {

        return null;
    }



}
