package semantic.visitor;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.FunctionInvocation;
import ast.expressions.Variable;
import semantic.symboltable.SymbolTable;
import ast.types.ErrorType;

/**
 * t¡Visitor to link all Variable nodes to their Definition
 */
public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {

        if(!symbolTable.insert(varDefinition)) {
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(), "[IDENTIFICATION ERROR] [Line: " + varDefinition.getLine() +
                    " Columnn: " + varDefinition.getColumn() + "] - The variable \""+ varDefinition.getName()+"\" has already been defined in the scope");
        }
        else
            varDefinition.getType().accept(this, param);

        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {

        if(!symbolTable.insert(funcDefinition)) { // insert the function to the global scope
            new ErrorType(funcDefinition.getLine(), funcDefinition.getColumn(), "[IDENTIFICATION ERROR] [Line: " + funcDefinition.getLine() +
                    " Columnn: " + funcDefinition.getColumn() + "] - The function \"" + funcDefinition.getName() + "\" has already been defined in the scope");
        }
        else {
            symbolTable.set(); // create the new scope
            super.visit(funcDefinition, param);
            symbolTable.reset(); // delete the scope
        }

        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {

        if(symbolTable.find(variable.getName()) == null) {
            new ErrorType(variable.getLine(), variable.getColumn(), "[IDENTIFICATION ERROR] [Line: " + variable.getLine() +
                    " Columnn: " + variable.getColumn() + "] - The variable name \""+ variable.getName()+"\" is not defined");

        }
        else {
            variable.setDefinition(symbolTable.find(variable.getName()));
        }
        return null;
    }

    @Override
    public Void visit(FunctionInvocation fi, Void param) {

        if(symbolTable.find(fi.getVar().getName()) == null) {
            new ErrorType(fi.getLine(), fi.getColumn(), "[IDENTIFICATION ERROR] [Line: " + fi.getLine() +
                    " Columnn: " + fi.getColumn() + "] - The variable \""+ fi.getVar().getName()+"\" is not defined");

        }
        else {
            fi.getVar().setDefinition(symbolTable.find(fi.getVar().getName()));
            super.visit(fi, null);
        }
        return null;
    }



}
