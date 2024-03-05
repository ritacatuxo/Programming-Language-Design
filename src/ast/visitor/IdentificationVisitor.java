package ast.visitor;

import ast.definitions.VarDefinition;

import java.util.HashMap;
import java.util.Map;

public class IdentificationVisitor implements Visitor<Void, Void>{

    private Map<String, VarDefinition> st = new HashMap<String, VarDefinition>();

}
