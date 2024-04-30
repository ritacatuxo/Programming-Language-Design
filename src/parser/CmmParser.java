// Generated from D:/segundo cuatri/DLP/para borrar/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, ID=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, COMMENT=41, MULTILINE_COLUMN=42, WS=43;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_mainFunction = 2, RULE_expression = 3, 
		RULE_function_invocation = 4, RULE_funcInvParameters = 5, RULE_statement = 6, 
		RULE_elseBody = 7, RULE_block = 8, RULE_type = 9, RULE_primitive_type = 10, 
		RULE_struct = 11, RULE_fieldDefinition = 12, RULE_varDefinition = 13, 
		RULE_functionDefinition = 14, RULE_returnType = 15, RULE_parameters = 16, 
		RULE_varDefinitions = 17, RULE_statements = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definitions", "mainFunction", "expression", "function_invocation", 
			"funcInvParameters", "statement", "elseBody", "block", "type", "primitive_type", 
			"struct", "fieldDefinition", "varDefinition", "functionDefinition", "returnType", 
			"parameters", "varDefinitions", "statements"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'.'", 
			"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'<'", "'>='", "'<='", 
			"'!='", "'=='", "'&&'", "'||'", "','", "'while'", "'if'", "'read'", "';'", 
			"'write'", "'='", "'return'", "'else'", "'int'", "'double'", "'char'", 
			"'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "COMMENT", 
			"MULTILINE_COLUMN", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast = new Program(0, 0);
		public DefinitionsContext d;
		public MainFunctionContext mf;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public MainFunctionContext mainFunction() {
			return getRuleContext(MainFunctionContext.class,0);
		}
		public List<DefinitionsContext> definitions() {
			return getRuleContexts(DefinitionsContext.class);
		}
		public DefinitionsContext definitions(int i) {
			return getRuleContext(DefinitionsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					((ProgramContext)_localctx).d = definitions();
					_localctx.ast.setDefinitions(((ProgramContext)_localctx).d.ast);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(46);
			((ProgramContext)_localctx).mf = mainFunction();
			_localctx.ast.addDefinition(((ProgramContext)_localctx).mf.ast);
			setState(48);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public VarDefinitionContext vd;
		public FunctionDefinitionContext fd;
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				((DefinitionsContext)_localctx).vd = varDefinition();
				_localctx.ast.addAll(((DefinitionsContext)_localctx).vd.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				((DefinitionsContext)_localctx).fd = functionDefinition();
				_localctx.ast.add(((DefinitionsContext)_localctx).fd.ast);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainFunctionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Token main;
		public VarDefinitionsContext vd;
		public StatementsContext st;
		public VarDefinitionsContext varDefinitions() {
			return getRuleContext(VarDefinitionsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__0);
			setState(59);
			((MainFunctionContext)_localctx).main = match(T__1);
			setState(60);
			match(T__2);
			setState(61);
			match(T__3);
			setState(62);
			match(T__4);
			setState(63);
			((MainFunctionContext)_localctx).vd = varDefinitions();
			setState(64);
			((MainFunctionContext)_localctx).st = statements();
			setState(65);
			match(T__5);
			((MainFunctionContext)_localctx).ast =  new FuncDefinition(((MainFunctionContext)_localctx).main.getLine(), ((MainFunctionContext)_localctx).main.getCharPositionInLine()+1,
			                    new FunctionType(((MainFunctionContext)_localctx).main.getLine(), ((MainFunctionContext)_localctx).main.getCharPositionInLine()+1, new ArrayList<>(), new VoidType(((MainFunctionContext)_localctx).main.getLine(), ((MainFunctionContext)_localctx).main.getCharPositionInLine()+1)),
			                        (((MainFunctionContext)_localctx).main!=null?((MainFunctionContext)_localctx).main.getText():null), ((MainFunctionContext)_localctx).vd.ast, ((MainFunctionContext)_localctx).st.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public Primitive_typeContext pt;
		public Function_invocationContext fi;
		public Token ID;
		public Token IC;
		public Token CC;
		public Token RC;
		public Token OP;
		public ExpressionContext e2;
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(69);
				match(T__2);
				setState(70);
				((ExpressionContext)_localctx).pt = primitive_type();
				setState(71);
				match(T__3);
				setState(72);
				((ExpressionContext)_localctx).e1 = expression(13);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).pt.ast, ((ExpressionContext)_localctx).e1.ast);
				}
				break;
			case 2:
				{
				setState(75);
				match(T__9);
				setState(76);
				((ExpressionContext)_localctx).e1 = expression(12);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast);
				}
				break;
			case 3:
				{
				setState(79);
				match(T__10);
				setState(80);
				((ExpressionContext)_localctx).e1 = expression(11);
				((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast);
				}
				break;
			case 4:
				{
				setState(83);
				((ExpressionContext)_localctx).fi = function_invocation();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fi.ast;
				}
				break;
			case 5:
				{
				setState(86);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 6:
				{
				setState(88);
				((ExpressionContext)_localctx).IC = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null))); 
				}
				break;
			case 7:
				{
				setState(90);
				((ExpressionContext)_localctx).CC = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CC.getLine(), ((ExpressionContext)_localctx).CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CC!=null?((ExpressionContext)_localctx).CC.getText():null))); 
				}
				break;
			case 8:
				{
				setState(92);
				((ExpressionContext)_localctx).RC = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).RC.getLine(), ((ExpressionContext)_localctx).RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).RC!=null?((ExpressionContext)_localctx).RC.getText():null))); 
				}
				break;
			case 9:
				{
				setState(94);
				match(T__2);
				setState(95);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(96);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(102);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						((ExpressionContext)_localctx).e2 = expression(11);
						((ExpressionContext)_localctx).ast =  Arithmetic.arithmeticFactory((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(107);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__14) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						((ExpressionContext)_localctx).e2 = expression(10);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(112);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4128768L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(113);
						((ExpressionContext)_localctx).e2 = expression(9);
						((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(117);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						((ExpressionContext)_localctx).e2 = expression(8);
						((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(122);
						match(T__6);
						setState(123);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(124);
						match(T__7);
						((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(128);
						match(T__8);
						setState(129);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_invocationContext extends ParserRuleContext {
		public FunctionInvocation ast;
		public Token ID;
		public FuncInvParametersContext fip;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public FuncInvParametersContext funcInvParameters() {
			return getRuleContext(FuncInvParametersContext.class,0);
		}
		public Function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_invocation; }
	}

	public final Function_invocationContext function_invocation() throws RecognitionException {
		Function_invocationContext _localctx = new Function_invocationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((Function_invocationContext)_localctx).ID = match(ID);
			setState(137);
			match(T__2);
			setState(138);
			((Function_invocationContext)_localctx).fip = funcInvParameters();
			setState(139);
			match(T__3);
			((Function_invocationContext)_localctx).ast =  new FunctionInvocation(((Function_invocationContext)_localctx).ID.getLine(), ((Function_invocationContext)_localctx).ID.getCharPositionInLine()+1, ((Function_invocationContext)_localctx).fip.ast, new Variable(((Function_invocationContext)_localctx).ID.getLine(), ((Function_invocationContext)_localctx).ID.getCharPositionInLine()+1, ((Function_invocationContext)_localctx).ID.getText()));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncInvParametersContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e2;
		public ExpressionContext e3;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FuncInvParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcInvParameters; }
	}

	public final FuncInvParametersContext funcInvParameters() throws RecognitionException {
		FuncInvParametersContext _localctx = new FuncInvParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcInvParameters);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__9:
			case T__10:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((FuncInvParametersContext)_localctx).e2 = expression(0);
				_localctx.ast.add(((FuncInvParametersContext)_localctx).e2.ast);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(144);
					match(T__23);
					setState(145);
					((FuncInvParametersContext)_localctx).e3 = expression(0);
					_localctx.ast.add(((FuncInvParametersContext)_localctx).e3.ast);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e1;
		public BlockContext b1;
		public ElseBodyContext eb;
		public ExpressionContext e2;
		public Function_invocationContext fi;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseBodyContext elseBody() {
			return getRuleContext(ElseBodyContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(T__24);
				setState(157);
				match(T__2);
				setState(158);
				((StatementContext)_localctx).e1 = expression(0);
				setState(159);
				match(T__3);
				setState(160);
				((StatementContext)_localctx).b1 = block();
				_localctx.ast.add(new While(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b1.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(T__25);
				setState(164);
				match(T__2);
				setState(165);
				((StatementContext)_localctx).e1 = expression(0);
				setState(166);
				match(T__3);
				setState(167);
				((StatementContext)_localctx).b1 = block();
				setState(168);
				((StatementContext)_localctx).eb = elseBody();
				_localctx.ast.add(new IfElse(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b1.ast, ((StatementContext)_localctx).eb.ast));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(T__26);
				setState(172);
				((StatementContext)_localctx).e1 = expression(0);
				_localctx.ast.add(new Read(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast));
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(174);
					match(T__23);
					setState(175);
					((StatementContext)_localctx).e2 = expression(0);
					_localctx.ast.add(new Read(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast));
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(183);
				match(T__27);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(T__28);
				setState(186);
				((StatementContext)_localctx).e1 = expression(0);
				_localctx.ast.add(new Write(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast));
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(188);
					match(T__23);
					setState(189);
					((StatementContext)_localctx).e2 = expression(0);
					_localctx.ast.add(new Write(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast));
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(197);
				match(T__27);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(199);
				((StatementContext)_localctx).e1 = expression(0);
				setState(200);
				match(T__29);
				setState(201);
				((StatementContext)_localctx).e2 = expression(0);
				_localctx.ast.add(new Assignment(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast));
				setState(203);
				match(T__27);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				((StatementContext)_localctx).fi = function_invocation();
				_localctx.ast.add(((StatementContext)_localctx).fi.ast);
				setState(207);
				match(T__27);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(209);
				match(T__30);
				setState(210);
				((StatementContext)_localctx).e1 = expression(0);
				_localctx.ast.add(new Return(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast));
				setState(212);
				match(T__27);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseBodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public BlockContext b1;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBody; }
	}

	public final ElseBodyContext elseBody() throws RecognitionException {
		ElseBodyContext _localctx = new ElseBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elseBody);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(T__31);
				setState(217);
				((ElseBodyContext)_localctx).b1 = block();
				((ElseBodyContext)_localctx).ast =  ((ElseBodyContext)_localctx).b1.ast;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext s1;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__9:
			case T__10:
			case T__24:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				((BlockContext)_localctx).s1 = statement();
				((BlockContext)_localctx).ast =  ((BlockContext)_localctx).s1.ast;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(T__4);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064503540744L) != 0)) {
					{
					{
					setState(227);
					((BlockContext)_localctx).s1 = statement();
					_localctx.ast.addAll(((BlockContext)_localctx).s1.ast);
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t1;
		public Primitive_typeContext pm;
		public StructContext s;
		public Token IC;
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
				{
				setState(239);
				((TypeContext)_localctx).pm = primitive_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).pm.ast;
				}
				break;
			case T__35:
				{
				setState(242);
				((TypeContext)_localctx).s = struct();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).s.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(247);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(248);
					match(T__6);
					setState(249);
					((TypeContext)_localctx).IC = match(INT_CONSTANT);
					setState(250);
					match(T__7);
					 ((TypeContext)_localctx).ast =  ArrayType.createArray(Integer.parseInt((((TypeContext)_localctx).IC!=null?((TypeContext)_localctx).IC.getText():null)), ((TypeContext)_localctx).t1.ast); 
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primitive_typeContext extends ParserRuleContext {
		public Type ast;
		public Token i;
		public Token d;
		public Token c;
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primitive_type);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				((Primitive_typeContext)_localctx).i = match(T__32);
				((Primitive_typeContext)_localctx).ast =  new IntType(((Primitive_typeContext)_localctx).i.getLine(), ((Primitive_typeContext)_localctx).i.getCharPositionInLine()+1);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				((Primitive_typeContext)_localctx).d = match(T__33);
				((Primitive_typeContext)_localctx).ast =  new DoubleType(((Primitive_typeContext)_localctx).d.getLine(), ((Primitive_typeContext)_localctx).d.getCharPositionInLine()+1);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				((Primitive_typeContext)_localctx).c = match(T__34);
				((Primitive_typeContext)_localctx).ast =  new CharType(((Primitive_typeContext)_localctx).c.getLine(), ((Primitive_typeContext)_localctx).c.getCharPositionInLine()+1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructContext extends ParserRuleContext {
		public RecordType ast;
		public Token st;
		public FieldDefinitionContext fd;
		public List<FieldDefinitionContext> fieldDefinition() {
			return getRuleContexts(FieldDefinitionContext.class);
		}
		public FieldDefinitionContext fieldDefinition(int i) {
			return getRuleContext(FieldDefinitionContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			((StructContext)_localctx).st = match(T__35);
			((StructContext)_localctx).ast =  new RecordType(((StructContext)_localctx).st.getLine(), ((StructContext)_localctx).st.getCharPositionInLine()+1);
			setState(267);
			match(T__4);
			setState(271); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(268);
				((StructContext)_localctx).fd = fieldDefinition();
				((RecordType) _localctx.ast).addRecordFields(((StructContext)_localctx).fd.ast);
				}
				}
				setState(273); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0) );
			setState(275);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDefinitionContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public TypeContext t1;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefinition; }
	}

	public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
		FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fieldDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			((FieldDefinitionContext)_localctx).t1 = type(0);
			setState(278);
			((FieldDefinitionContext)_localctx).ID = match(ID);
			_localctx.ast.add(new RecordField(((FieldDefinitionContext)_localctx).t1.ast.getLine(), ((FieldDefinitionContext)_localctx).t1.ast.getColumn(), ((FieldDefinitionContext)_localctx).t1.ast, (((FieldDefinitionContext)_localctx).ID!=null?((FieldDefinitionContext)_localctx).ID.getText():null)));
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(280);
				match(T__23);
				setState(281);
				((FieldDefinitionContext)_localctx).ID = match(ID);
				_localctx.ast.add(new RecordField(((FieldDefinitionContext)_localctx).t1.ast.getLine(), ((FieldDefinitionContext)_localctx).t1.ast.getColumn(), ((FieldDefinitionContext)_localctx).t1.ast, (((FieldDefinitionContext)_localctx).ID!=null?((FieldDefinitionContext)_localctx).ID.getText():null)));
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(288);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t1;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			((VarDefinitionContext)_localctx).t1 = type(0);
			setState(291);
			((VarDefinitionContext)_localctx).ID = match(ID);
			_localctx.ast.add(new VarDefinition(((VarDefinitionContext)_localctx).t1.ast.getLine(), ((VarDefinitionContext)_localctx).t1.ast.getColumn(), ((VarDefinitionContext)_localctx).t1.ast, (((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null)));
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(293);
				match(T__23);
				setState(294);
				((VarDefinitionContext)_localctx).ID = match(ID);
				_localctx.ast.add(new VarDefinition(((VarDefinitionContext)_localctx).t1.ast.getLine(), ((VarDefinitionContext)_localctx).t1.ast.getColumn(), ((VarDefinitionContext)_localctx).t1.ast, (((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null)));
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(301);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public ReturnTypeContext rt;
		public Token ID;
		public ParametersContext p;
		public VarDefinitionsContext vd;
		public StatementsContext st;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public VarDefinitionsContext varDefinitions() {
			return getRuleContext(VarDefinitionsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			((FunctionDefinitionContext)_localctx).rt = returnType();
			setState(304);
			((FunctionDefinitionContext)_localctx).ID = match(ID);
			setState(305);
			match(T__2);
			setState(306);
			((FunctionDefinitionContext)_localctx).p = parameters();
			setState(307);
			match(T__3);
			setState(308);
			match(T__4);
			setState(309);
			((FunctionDefinitionContext)_localctx).vd = varDefinitions();
			setState(310);
			((FunctionDefinitionContext)_localctx).st = statements();
			setState(311);
			match(T__5);
			((FunctionDefinitionContext)_localctx).ast =  new FuncDefinition(((FunctionDefinitionContext)_localctx).ID.getLine(), ((FunctionDefinitionContext)_localctx).ID.getCharPositionInLine()+1,
			                            new FunctionType(((FunctionDefinitionContext)_localctx).ID.getLine(), ((FunctionDefinitionContext)_localctx).ID.getCharPositionInLine()+1, ((FunctionDefinitionContext)_localctx).p.ast, ((FunctionDefinitionContext)_localctx).rt.ast), (((FunctionDefinitionContext)_localctx).ID!=null?((FunctionDefinitionContext)_localctx).ID.getText():null), ((FunctionDefinitionContext)_localctx).vd.ast, ((FunctionDefinitionContext)_localctx).st.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends ParserRuleContext {
		public Type ast;
		public Primitive_typeContext pt;
		public Token v;
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnType);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				((ReturnTypeContext)_localctx).pt = primitive_type();
				((ReturnTypeContext)_localctx).ast =  ((ReturnTypeContext)_localctx).pt.ast;
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				((ReturnTypeContext)_localctx).v = match(T__0);
				((ReturnTypeContext)_localctx).ast =  new VoidType(((ReturnTypeContext)_localctx).v.getLine(), ((ReturnTypeContext)_localctx).v.getCharPositionInLine()+1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public Primitive_typeContext pt1;
		public Token id;
		public Primitive_typeContext pt2;
		public Token id2;
		public List<Primitive_typeContext> primitive_type() {
			return getRuleContexts(Primitive_typeContext.class);
		}
		public Primitive_typeContext primitive_type(int i) {
			return getRuleContext(Primitive_typeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_parameters);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				((ParametersContext)_localctx).pt1 = primitive_type();
				setState(322);
				((ParametersContext)_localctx).id = match(ID);
				_localctx.ast.add( new VarDefinition(((ParametersContext)_localctx).pt1.ast.getLine(), ((ParametersContext)_localctx).pt1.ast.getColumn(), ((ParametersContext)_localctx).pt1.ast, (((ParametersContext)_localctx).id!=null?((ParametersContext)_localctx).id.getText():null)));
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(324);
					match(T__23);
					setState(325);
					((ParametersContext)_localctx).pt2 = primitive_type();
					setState(326);
					((ParametersContext)_localctx).id2 = match(ID);
					_localctx.ast.add( new VarDefinition(((ParametersContext)_localctx).pt2.ast.getLine(), ((ParametersContext)_localctx).pt2.ast.getColumn(), ((ParametersContext)_localctx).pt2.ast, (((ParametersContext)_localctx).id2!=null?((ParametersContext)_localctx).id2.getText():null)));
					}
					}
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionsContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public VarDefinitionContext vd;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public VarDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinitions; }
	}

	public final VarDefinitionsContext varDefinitions() throws RecognitionException {
		VarDefinitionsContext _localctx = new VarDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) {
				{
				{
				setState(337);
				((VarDefinitionsContext)_localctx).vd = varDefinition();
				_localctx.ast.addAll(((VarDefinitionsContext)_localctx).vd.ast);
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext st;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064503540744L) != 0)) {
				{
				{
				setState(345);
				((StatementsContext)_localctx).st = statement();
				_localctx.ast.addAll(((StatementsContext)_localctx).st.ast);
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 9:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0162\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"9\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003d\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003\u0084\b\u0003\n\u0003\f\u0003\u0087"+
		"\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u0095\b\u0005\n\u0005\f\u0005\u0098\t\u0005\u0001\u0005"+
		"\u0003\u0005\u009b\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u00b3\b\u0006\n\u0006\f\u0006\u00b6\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00c1\b\u0006\n\u0006\f\u0006\u00c4\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00d7\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00de\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00e7\b\b\n\b\f\b\u00ea\t\b\u0001\b\u0003\b\u00ed\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00f6"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00fd\b\t\n\t\f\t"+
		"\u0100\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0108"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000b\u0110\b\u000b\u000b\u000b\f\u000b\u0111\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u011c"+
		"\b\f\n\f\f\f\u011f\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0005\r\u0129\b\r\n\r\f\r\u012c\t\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0140\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u014a\b\u0010\n\u0010\f\u0010\u014d\t\u0010"+
		"\u0001\u0010\u0003\u0010\u0150\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0155\b\u0011\n\u0011\f\u0011\u0158\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u015d\b\u0012\n\u0012\f\u0012\u0160\t\u0012"+
		"\u0001\u0012\u0000\u0002\u0006\u0012\u0013\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0004"+
		"\u0001\u0000\f\u000e\u0002\u0000\n\n\u000f\u000f\u0001\u0000\u0010\u0015"+
		"\u0001\u0000\u0016\u0017\u0177\u0000+\u0001\u0000\u0000\u0000\u00028\u0001"+
		"\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006c\u0001\u0000\u0000"+
		"\u0000\b\u0088\u0001\u0000\u0000\u0000\n\u009a\u0001\u0000\u0000\u0000"+
		"\f\u00d6\u0001\u0000\u0000\u0000\u000e\u00dd\u0001\u0000\u0000\u0000\u0010"+
		"\u00ec\u0001\u0000\u0000\u0000\u0012\u00f5\u0001\u0000\u0000\u0000\u0014"+
		"\u0107\u0001\u0000\u0000\u0000\u0016\u0109\u0001\u0000\u0000\u0000\u0018"+
		"\u0115\u0001\u0000\u0000\u0000\u001a\u0122\u0001\u0000\u0000\u0000\u001c"+
		"\u012f\u0001\u0000\u0000\u0000\u001e\u013f\u0001\u0000\u0000\u0000 \u014f"+
		"\u0001\u0000\u0000\u0000\"\u0156\u0001\u0000\u0000\u0000$\u015e\u0001"+
		"\u0000\u0000\u0000&\'\u0003\u0002\u0001\u0000\'(\u0006\u0000\uffff\uffff"+
		"\u0000(*\u0001\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000*-\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0003\u0004\u0002\u0000"+
		"/0\u0006\u0000\uffff\uffff\u000001\u0005\u0000\u0000\u00011\u0001\u0001"+
		"\u0000\u0000\u000023\u0003\u001a\r\u000034\u0006\u0001\uffff\uffff\u0000"+
		"49\u0001\u0000\u0000\u000056\u0003\u001c\u000e\u000067\u0006\u0001\uffff"+
		"\uffff\u000079\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u000085\u0001"+
		"\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000:;\u0005\u0001\u0000"+
		"\u0000;<\u0005\u0002\u0000\u0000<=\u0005\u0003\u0000\u0000=>\u0005\u0004"+
		"\u0000\u0000>?\u0005\u0005\u0000\u0000?@\u0003\"\u0011\u0000@A\u0003$"+
		"\u0012\u0000AB\u0005\u0006\u0000\u0000BC\u0006\u0002\uffff\uffff\u0000"+
		"C\u0005\u0001\u0000\u0000\u0000DE\u0006\u0003\uffff\uffff\u0000EF\u0005"+
		"\u0003\u0000\u0000FG\u0003\u0014\n\u0000GH\u0005\u0004\u0000\u0000HI\u0003"+
		"\u0006\u0003\rIJ\u0006\u0003\uffff\uffff\u0000Jd\u0001\u0000\u0000\u0000"+
		"KL\u0005\n\u0000\u0000LM\u0003\u0006\u0003\fMN\u0006\u0003\uffff\uffff"+
		"\u0000Nd\u0001\u0000\u0000\u0000OP\u0005\u000b\u0000\u0000PQ\u0003\u0006"+
		"\u0003\u000bQR\u0006\u0003\uffff\uffff\u0000Rd\u0001\u0000\u0000\u0000"+
		"ST\u0003\b\u0004\u0000TU\u0006\u0003\uffff\uffff\u0000Ud\u0001\u0000\u0000"+
		"\u0000VW\u0005%\u0000\u0000Wd\u0006\u0003\uffff\uffff\u0000XY\u0005&\u0000"+
		"\u0000Yd\u0006\u0003\uffff\uffff\u0000Z[\u0005(\u0000\u0000[d\u0006\u0003"+
		"\uffff\uffff\u0000\\]\u0005\'\u0000\u0000]d\u0006\u0003\uffff\uffff\u0000"+
		"^_\u0005\u0003\u0000\u0000_`\u0003\u0006\u0003\u0000`a\u0005\u0004\u0000"+
		"\u0000ab\u0006\u0003\uffff\uffff\u0000bd\u0001\u0000\u0000\u0000cD\u0001"+
		"\u0000\u0000\u0000cK\u0001\u0000\u0000\u0000cO\u0001\u0000\u0000\u0000"+
		"cS\u0001\u0000\u0000\u0000cV\u0001\u0000\u0000\u0000cX\u0001\u0000\u0000"+
		"\u0000cZ\u0001\u0000\u0000\u0000c\\\u0001\u0000\u0000\u0000c^\u0001\u0000"+
		"\u0000\u0000d\u0085\u0001\u0000\u0000\u0000ef\n\n\u0000\u0000fg\u0007"+
		"\u0000\u0000\u0000gh\u0003\u0006\u0003\u000bhi\u0006\u0003\uffff\uffff"+
		"\u0000i\u0084\u0001\u0000\u0000\u0000jk\n\t\u0000\u0000kl\u0007\u0001"+
		"\u0000\u0000lm\u0003\u0006\u0003\nmn\u0006\u0003\uffff\uffff\u0000n\u0084"+
		"\u0001\u0000\u0000\u0000op\n\b\u0000\u0000pq\u0007\u0002\u0000\u0000q"+
		"r\u0003\u0006\u0003\trs\u0006\u0003\uffff\uffff\u0000s\u0084\u0001\u0000"+
		"\u0000\u0000tu\n\u0007\u0000\u0000uv\u0007\u0003\u0000\u0000vw\u0003\u0006"+
		"\u0003\bwx\u0006\u0003\uffff\uffff\u0000x\u0084\u0001\u0000\u0000\u0000"+
		"yz\n\u000f\u0000\u0000z{\u0005\u0007\u0000\u0000{|\u0003\u0006\u0003\u0000"+
		"|}\u0005\b\u0000\u0000}~\u0006\u0003\uffff\uffff\u0000~\u0084\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\n\u000e\u0000\u0000\u0080\u0081\u0005\t\u0000"+
		"\u0000\u0081\u0082\u0005%\u0000\u0000\u0082\u0084\u0006\u0003\uffff\uffff"+
		"\u0000\u0083e\u0001\u0000\u0000\u0000\u0083j\u0001\u0000\u0000\u0000\u0083"+
		"o\u0001\u0000\u0000\u0000\u0083t\u0001\u0000\u0000\u0000\u0083y\u0001"+
		"\u0000\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0084\u0087\u0001"+
		"\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001"+
		"\u0000\u0000\u0000\u0086\u0007\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0005%\u0000\u0000\u0089\u008a\u0005\u0003"+
		"\u0000\u0000\u008a\u008b\u0003\n\u0005\u0000\u008b\u008c\u0005\u0004\u0000"+
		"\u0000\u008c\u008d\u0006\u0004\uffff\uffff\u0000\u008d\t\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0003\u0006\u0003\u0000\u008f\u0096\u0006\u0005\uffff"+
		"\uffff\u0000\u0090\u0091\u0005\u0018\u0000\u0000\u0091\u0092\u0003\u0006"+
		"\u0003\u0000\u0092\u0093\u0006\u0005\uffff\uffff\u0000\u0093\u0095\u0001"+
		"\u0000\u0000\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0095\u0098\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u009b\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u008e\u0001"+
		"\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u000b\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005\u0019\u0000\u0000\u009d\u009e\u0005"+
		"\u0003\u0000\u0000\u009e\u009f\u0003\u0006\u0003\u0000\u009f\u00a0\u0005"+
		"\u0004\u0000\u0000\u00a0\u00a1\u0003\u0010\b\u0000\u00a1\u00a2\u0006\u0006"+
		"\uffff\uffff\u0000\u00a2\u00d7\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005"+
		"\u001a\u0000\u0000\u00a4\u00a5\u0005\u0003\u0000\u0000\u00a5\u00a6\u0003"+
		"\u0006\u0003\u0000\u00a6\u00a7\u0005\u0004\u0000\u0000\u00a7\u00a8\u0003"+
		"\u0010\b\u0000\u00a8\u00a9\u0003\u000e\u0007\u0000\u00a9\u00aa\u0006\u0006"+
		"\uffff\uffff\u0000\u00aa\u00d7\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\u001b\u0000\u0000\u00ac\u00ad\u0003\u0006\u0003\u0000\u00ad\u00b4\u0006"+
		"\u0006\uffff\uffff\u0000\u00ae\u00af\u0005\u0018\u0000\u0000\u00af\u00b0"+
		"\u0003\u0006\u0003\u0000\u00b0\u00b1\u0006\u0006\uffff\uffff\u0000\u00b1"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u001c\u0000\u0000\u00b8"+
		"\u00d7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u001d\u0000\u0000\u00ba"+
		"\u00bb\u0003\u0006\u0003\u0000\u00bb\u00c2\u0006\u0006\uffff\uffff\u0000"+
		"\u00bc\u00bd\u0005\u0018\u0000\u0000\u00bd\u00be\u0003\u0006\u0003\u0000"+
		"\u00be\u00bf\u0006\u0006\uffff\uffff\u0000\u00bf\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005\u001c\u0000\u0000\u00c6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0003\u0006\u0003\u0000\u00c8\u00c9\u0005\u001e\u0000"+
		"\u0000\u00c9\u00ca\u0003\u0006\u0003\u0000\u00ca\u00cb\u0006\u0006\uffff"+
		"\uffff\u0000\u00cb\u00cc\u0005\u001c\u0000\u0000\u00cc\u00d7\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0003\b\u0004\u0000\u00ce\u00cf\u0006\u0006\uffff"+
		"\uffff\u0000\u00cf\u00d0\u0005\u001c\u0000\u0000\u00d0\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0005\u001f\u0000\u0000\u00d2\u00d3\u0003\u0006"+
		"\u0003\u0000\u00d3\u00d4\u0006\u0006\uffff\uffff\u0000\u00d4\u00d5\u0005"+
		"\u001c\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u009c\u0001"+
		"\u0000\u0000\u0000\u00d6\u00a3\u0001\u0000\u0000\u0000\u00d6\u00ab\u0001"+
		"\u0000\u0000\u0000\u00d6\u00b9\u0001\u0000\u0000\u0000\u00d6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00d6\u00cd\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d7\r\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005 "+
		"\u0000\u0000\u00d9\u00da\u0003\u0010\b\u0000\u00da\u00db\u0006\u0007\uffff"+
		"\uffff\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00de\u0001\u0000"+
		"\u0000\u0000\u00dd\u00d8\u0001\u0000\u0000\u0000\u00dd\u00dc\u0001\u0000"+
		"\u0000\u0000\u00de\u000f\u0001\u0000\u0000\u0000\u00df\u00e0\u0003\f\u0006"+
		"\u0000\u00e0\u00e1\u0006\b\uffff\uffff\u0000\u00e1\u00ed\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e8\u0005\u0005\u0000\u0000\u00e3\u00e4\u0003\f\u0006\u0000"+
		"\u00e4\u00e5\u0006\b\uffff\uffff\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e3\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ed\u0005\u0006\u0000\u0000\u00ec\u00df\u0001\u0000\u0000\u0000"+
		"\u00ec\u00e2\u0001\u0000\u0000\u0000\u00ed\u0011\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0006\t\uffff\uffff\u0000\u00ef\u00f0\u0003\u0014\n\u0000"+
		"\u00f0\u00f1\u0006\t\uffff\uffff\u0000\u00f1\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0003\u0016\u000b\u0000\u00f3\u00f4\u0006\t\uffff\uffff\u0000"+
		"\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f2\u0001\u0000\u0000\u0000\u00f6\u00fe\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\n\u0002\u0000\u0000\u00f8\u00f9\u0005\u0007\u0000\u0000\u00f9"+
		"\u00fa\u0005&\u0000\u0000\u00fa\u00fb\u0005\b\u0000\u0000\u00fb\u00fd"+
		"\u0006\t\uffff\uffff\u0000\u00fc\u00f7\u0001\u0000\u0000\u0000\u00fd\u0100"+
		"\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u0013\u0001\u0000\u0000\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0101\u0102\u0005!\u0000\u0000\u0102\u0108\u0006"+
		"\n\uffff\uffff\u0000\u0103\u0104\u0005\"\u0000\u0000\u0104\u0108\u0006"+
		"\n\uffff\uffff\u0000\u0105\u0106\u0005#\u0000\u0000\u0106\u0108\u0006"+
		"\n\uffff\uffff\u0000\u0107\u0101\u0001\u0000\u0000\u0000\u0107\u0103\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0015\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0005$\u0000\u0000\u010a\u010b\u0006\u000b"+
		"\uffff\uffff\u0000\u010b\u010f\u0005\u0005\u0000\u0000\u010c\u010d\u0003"+
		"\u0018\f\u0000\u010d\u010e\u0006\u000b\uffff\uffff\u0000\u010e\u0110\u0001"+
		"\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u0110\u0111\u0001"+
		"\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0005"+
		"\u0006\u0000\u0000\u0114\u0017\u0001\u0000\u0000\u0000\u0115\u0116\u0003"+
		"\u0012\t\u0000\u0116\u0117\u0005%\u0000\u0000\u0117\u011d\u0006\f\uffff"+
		"\uffff\u0000\u0118\u0119\u0005\u0018\u0000\u0000\u0119\u011a\u0005%\u0000"+
		"\u0000\u011a\u011c\u0006\f\uffff\uffff\u0000\u011b\u0118\u0001\u0000\u0000"+
		"\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u0120\u0001\u0000\u0000"+
		"\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u001c\u0000"+
		"\u0000\u0121\u0019\u0001\u0000\u0000\u0000\u0122\u0123\u0003\u0012\t\u0000"+
		"\u0123\u0124\u0005%\u0000\u0000\u0124\u012a\u0006\r\uffff\uffff\u0000"+
		"\u0125\u0126\u0005\u0018\u0000\u0000\u0126\u0127\u0005%\u0000\u0000\u0127"+
		"\u0129\u0006\r\uffff\uffff\u0000\u0128\u0125\u0001\u0000\u0000\u0000\u0129"+
		"\u012c\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0001\u0000\u0000\u0000\u012b\u012d\u0001\u0000\u0000\u0000\u012c"+
		"\u012a\u0001\u0000\u0000\u0000\u012d\u012e\u0005\u001c\u0000\u0000\u012e"+
		"\u001b\u0001\u0000\u0000\u0000\u012f\u0130\u0003\u001e\u000f\u0000\u0130"+
		"\u0131\u0005%\u0000\u0000\u0131\u0132\u0005\u0003\u0000\u0000\u0132\u0133"+
		"\u0003 \u0010\u0000\u0133\u0134\u0005\u0004\u0000\u0000\u0134\u0135\u0005"+
		"\u0005\u0000\u0000\u0135\u0136\u0003\"\u0011\u0000\u0136\u0137\u0003$"+
		"\u0012\u0000\u0137\u0138\u0005\u0006\u0000\u0000\u0138\u0139\u0006\u000e"+
		"\uffff\uffff\u0000\u0139\u001d\u0001\u0000\u0000\u0000\u013a\u013b\u0003"+
		"\u0014\n\u0000\u013b\u013c\u0006\u000f\uffff\uffff\u0000\u013c\u0140\u0001"+
		"\u0000\u0000\u0000\u013d\u013e\u0005\u0001\u0000\u0000\u013e\u0140\u0006"+
		"\u000f\uffff\uffff\u0000\u013f\u013a\u0001\u0000\u0000\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u0140\u001f\u0001\u0000\u0000\u0000\u0141\u0142"+
		"\u0003\u0014\n\u0000\u0142\u0143\u0005%\u0000\u0000\u0143\u014b\u0006"+
		"\u0010\uffff\uffff\u0000\u0144\u0145\u0005\u0018\u0000\u0000\u0145\u0146"+
		"\u0003\u0014\n\u0000\u0146\u0147\u0005%\u0000\u0000\u0147\u0148\u0006"+
		"\u0010\uffff\uffff\u0000\u0148\u014a\u0001\u0000\u0000\u0000\u0149\u0144"+
		"\u0001\u0000\u0000\u0000\u014a\u014d\u0001\u0000\u0000\u0000\u014b\u0149"+
		"\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u0150"+
		"\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014e\u0150"+
		"\u0001\u0000\u0000\u0000\u014f\u0141\u0001\u0000\u0000\u0000\u014f\u014e"+
		"\u0001\u0000\u0000\u0000\u0150!\u0001\u0000\u0000\u0000\u0151\u0152\u0003"+
		"\u001a\r\u0000\u0152\u0153\u0006\u0011\uffff\uffff\u0000\u0153\u0155\u0001"+
		"\u0000\u0000\u0000\u0154\u0151\u0001\u0000\u0000\u0000\u0155\u0158\u0001"+
		"\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001"+
		"\u0000\u0000\u0000\u0157#\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0003\f\u0006\u0000\u015a\u015b\u0006\u0012\uffff"+
		"\uffff\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u0159\u0001\u0000"+
		"\u0000\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000"+
		"\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f%\u0001\u0000\u0000"+
		"\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0018+8c\u0083\u0085\u0096"+
		"\u009a\u00b4\u00c2\u00d6\u00dd\u00e8\u00ec\u00f5\u00fe\u0107\u0111\u011d"+
		"\u012a\u013f\u014b\u014f\u0156\u015e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}