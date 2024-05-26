package codegeneration;

import ast.ASTNode;

public class CGManager {
    private ExecuteCGVisitor execute;
    private AddressCGVisitor address;
    private ValueCGVisitor value;

    private CodeGenerator cg;


    public CGManager(String inputFile, String outputFile) {

        cg = new CodeGenerator(inputFile, outputFile);


        address = new AddressCGVisitor(cg);
        value = new ValueCGVisitor(cg);
        execute = new ExecuteCGVisitor(cg, value, address);

        address.setValueCGVisitor(value);
        value.setAddressCGVisitor(address);
    }

    /**
     * Starts the code generation phase by running the ExecuteVisitor on the specified node
     */
    public void run(ASTNode node){
        node.accept(execute, null);
    }

}
