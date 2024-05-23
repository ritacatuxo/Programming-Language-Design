import ast.Program;
import ast.errorhandler.ErrorHandler;
import codegeneration.CGManager;
import codegeneration.OffsetVisitor;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;
import visitor.Visitor;
import parser.*;

import org.antlr.v4.runtime.*;

public class Main {

	public static void main(String... args) throws Exception {




		// 1 arg
		/*
		if (args.length < 1) {
			System.err.println("Please, pass both the input and output files");
			return;
		}

		String inputFilepath = args[0];
		System.out.println("Processing '" + inputFilepath);
		*/


		// 2 args

		// CODE FOR PARSER ------------------------

		if (args.length < 2) {
			System.err.println("Please, pass both the input and output files");
			return;
		}

		String inputFilepath = args[0];
		String outputFilepath = args[1];
		System.out.println("Processing '" + inputFilepath + "' into '" + outputFilepath + "'...");



		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);
		Program ast = parser.program().ast;

		// visitors

		System.out.println();
		System.out.println("Running Identification Visitor...");
		Visitor identificationVisitor = new IdentificationVisitor();
		ast.accept(identificationVisitor, null);




		System.out.println();
		System.out.println("Running Type Checking Visitor...");
		Visitor v = new TypeCheckingVisitor();
		v.visit(ast, null);

		if (ErrorHandler.getInstance().anyErrors()) {
			ErrorHandler.getInstance().showErrors(System.err);
			return;
		} else {
			if (parser.getNumberOfSyntaxErrors() <= 0) {

				IntrospectorModel model = new IntrospectorModel(
						"Program", ast);
				new IntrospectorView("Introspector", model);
			}
		}

		System.out.println();
		System.out.println("Running Offset Visitor...");
		v = new OffsetVisitor();
		v.visit(ast, null);


		System.out.println();
		System.out.println("Running Code Generation Visitors...");
		CGManager cgm = new CGManager(inputFilepath, outputFilepath);
		cgm.run(ast);


	}
}
