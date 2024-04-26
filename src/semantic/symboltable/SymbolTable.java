package semantic.symboltable;

import java.util.*;
import ast.definitions.Definition;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String, Definition>> table;
	public SymbolTable()  {
		this.table = new ArrayList<>();
		// insert global scope
		Map<String, Definition> scope0 = new HashMap<String, Definition>();
		this.table.add(scope0);
	}

	public List<Map<String, Definition>> getTable() {
		return table;
	}

	/**
	 * Create a map and insert it to the table when a new scope is opened
	 */
	public void set() {
		Map<String, Definition> lastScope = new HashMap<String, Definition>();
		this.table.add(lastScope);
		scope++;
	}

	/**
	 * Deleted a scope when it is closed
	 */
	public void reset() {
		table.remove(table.size()-1);
		scope--;
	}

	/**
	 * Adds a new entry in the most nested scope
	 */
	public boolean insert(Definition definition) {
		// check the same value is not in the last scope
		if(findInCurrentScope(definition.getName()) != null)
			return false;

		this.table.get(scope).put(definition.getName(), definition);
		definition.setScope(scope);
		return true;
	}

	/**
	 * Searches for a variable, considering the language scope rules (from the
	 * most nested scope outward)
	 */
	public Definition findInCurrentScope(String id) {
		return this.table.get(scope).get(id);
	}

	/**
	 * Find in the previous scopes in case it is not in the last one
	 */
	public Definition find(String id) {

		for(int i = scope; i >= 0 ;i--){
			Map<String, Definition> scopeToSearch = table.get(i);
			if(scopeToSearch.containsKey(id))
					return scopeToSearch.get(id);

		}

		return null; // no definition --> error
	}


}
