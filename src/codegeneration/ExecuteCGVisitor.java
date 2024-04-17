package codegeneration;

public class ExecuteCGVisitor extends AbstractCGVisitor{

    //only for statements

    /**
     * execute[[Read: statement -> expression]] =
     * 		address[[expression]]
     * 		<in> expression.type.suffif()
     * 		<store> expression.type.suffix()
     */



    /**
     * execute[[Write: statement -> expression]] =
     * 		address[[expression]]
     * 		<out> expression.type.suffix()
     */


    /**
     * execute[[Assignment: statement -> expression1 expression2]] =
     * 		address[[expression1]]
     * 		value[[expression2]]
     * 		<store> expression1.type.suffix()
     */


    /**
     * execute[[VarDefinition: definition -> type ID]] =
     * 		<' * > type ID < (offset > definition.offset < )>
     */


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


    /**
     * execute[[Program: program -> definition*]] =
     * 		<call main>
     * 		<halt>
     * 		definition*.forEach(def -> execute[[def]])
     */
}
