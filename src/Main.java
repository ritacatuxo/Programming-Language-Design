import ast.Program;
import ast.errorhandler.ErrorHandler;
import ast.semantic.visitor.IdentificationVisitor;
import ast.semantic.visitor.TypeCheckingVisitor;
import ast.semantic.visitor.Visitor;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import parser.*;

import org.antlr.v4.runtime.*;

public class Main {

	public static void main(String... args) throws Exception {

		// CODE FOR PARSER ------------------------

		if (args.length < 1) {
			System.err.println("Please, pass me the input file.");
			return;
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);
		Program ast = parser.program().ast;


		System.out.println();
		System.out.println("Running Identification Visitor...");
		Visitor identificationVisitor = new IdentificationVisitor();
		ast.accept(identificationVisitor, null);


		// LAB09 - TYPE CHECKING
		System.out.println();
		System.out.println("Running Type Checking Visitor...");
		//Visitor typeChecking = new TypeCheckingVisitor();
		//ast.accept(typeChecking, null);

		Visitor v = new TypeCheckingVisitor();
		v.visit(ast, null);


		if (ErrorHandler.getInstance().anyErrors()) {
			ErrorHandler.getInstance().showErrors(System.err);
			System.err.println("Cannot proceed with code generation until errors are solved. Stopping...");
			return;
		}


	}
}
