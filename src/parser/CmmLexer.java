// Generated from C:/Users/Rita Catucho/Desktop/segundo cuatri/DLP/laboratorios/compilador/DLP/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, MULTILINE_COLUMN=2, REAL_CONSTANT=3, MANTISSA=4, CHAR_CONSTANT_ASCII=5, CHAR_CONSTANT=6, INT_CONSTANT=7, ID=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "MULTILINE_COLUMN", "LETTER", "ID", "INT_CONSTANT", "REAL_CONSTANT", 
			"MANTISSA", "CHAR_CONSTANT_ASCII", "CHAR_CONSTANT", "INT_CONSTANT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "MULTILINE_COLUMN", "REAL_CONSTANT", "MANTISSA", "CHAR_CONSTANT_ASCII"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0005o\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u0016\b\u0000\n\u0000\f\u0000\u0019\t\u0000\u0001\u0000\u0003\u0000\u001c"+
		"\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\""+
		"\b\u0001\n\u0001\f\u0001%\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0004\u0003.\b\u0003"+
		"\u000b\u0003\f\u0003/\u0001\u0003\u0001\u0003\u0004\u00034\b\u0003\u000b"+
		"\u0003\f\u00035\u0003\u00038\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004"+
		"<\b\u0004\n\u0004\f\u0004?\t\u0004\u0001\u0004\u0003\u0004B\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0004\u0005F\b\u0005\u000b\u0005\f\u0005G\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005M\b\u0005\n\u0005\f\u0005P\t\u0005"+
		"\u0003\u0005R\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007n\b\u0007\u0002"+
		"\u0017#\u0000\b\u0001\u0001\u0003\u0002\u0005\u0000\u0007\u0000\t\u0000"+
		"\u000b\u0003\r\u0004\u000f\u0005\u0001\u0000\u0006\u0002\u0001\n\n\r\r"+
		"\u0002\u0000AZaz\u0001\u000019\u0001\u000009\u0002\u0000EEee\u0002\u0000"+
		"++--|\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0001\u0011\u0001\u0000\u0000\u0000"+
		"\u0003\u001d\u0001\u0000\u0000\u0000\u0005)\u0001\u0000\u0000\u0000\u0007"+
		"7\u0001\u0000\u0000\u0000\tA\u0001\u0000\u0000\u0000\u000bQ\u0001\u0000"+
		"\u0000\u0000\rU\u0001\u0000\u0000\u0000\u000fm\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0005/\u0000\u0000\u0012\u0013\u0005/\u0000\u0000\u0013\u0017"+
		"\u0001\u0000\u0000\u0000\u0014\u0016\t\u0000\u0000\u0000\u0015\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0018\u0001"+
		"\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u001b\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001c\u0007"+
		"\u0000\u0000\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u0002\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0005/\u0000\u0000\u001e\u001f\u0005*\u0000"+
		"\u0000\u001f#\u0001\u0000\u0000\u0000 \"\t\u0000\u0000\u0000! \u0001\u0000"+
		"\u0000\u0000\"%\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000#!\u0001"+
		"\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000"+
		"&\'\u0005*\u0000\u0000\'(\u0005/\u0000\u0000(\u0004\u0001\u0000\u0000"+
		"\u0000)*\u0007\u0001\u0000\u0000*\u0006\u0001\u0000\u0000\u0000+.\u0003"+
		"\u0005\u0002\u0000,.\u0005_\u0000\u0000-+\u0001\u0000\u0000\u0000-,\u0001"+
		"\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000008\u0001\u0000\u0000\u000014\u0003\u0005\u0002"+
		"\u000024\u0005_\u0000\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000"+
		"\u000045\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000068\u0001\u0000\u0000\u00007-\u0001\u0000\u0000\u000073\u0001"+
		"\u0000\u0000\u00008\b\u0001\u0000\u0000\u00009=\u0007\u0002\u0000\u0000"+
		":<\u0007\u0003\u0000\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>B\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000@B\u00050\u0000\u0000A9\u0001\u0000"+
		"\u0000\u0000A@\u0001\u0000\u0000\u0000B\n\u0001\u0000\u0000\u0000CE\u0005"+
		".\u0000\u0000DF\u0007\u0003\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"HR\u0001\u0000\u0000\u0000IJ\u0003\t\u0004\u0000JN\u0005.\u0000\u0000"+
		"KM\u0007\u0003\u0000\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OR\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QC\u0001\u0000\u0000\u0000QI\u0001"+
		"\u0000\u0000\u0000R\f\u0001\u0000\u0000\u0000SV\u0003\t\u0004\u0000TV"+
		"\u0003\u000b\u0005\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WY\u0007\u0004\u0000\u0000XZ\u0007\u0005"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[\\\u0003\t\u0004\u0000\\\u000e\u0001\u0000\u0000\u0000"+
		"]^\u0005\'\u0000\u0000^_\t\u0000\u0000\u0000_n\u0005\'\u0000\u0000`a\u0005"+
		"\'\u0000\u0000ab\u0005\\\u0000\u0000bc\u0003\t\u0004\u0000cd\u0005\'\u0000"+
		"\u0000dn\u0001\u0000\u0000\u0000ef\u0005\'\u0000\u0000fg\u0005\\\u0000"+
		"\u0000gh\u0005n\u0000\u0000hn\u0005\'\u0000\u0000ij\u0005\'\u0000\u0000"+
		"jk\u0005\\\u0000\u0000kl\u0005t\u0000\u0000ln\u0005\'\u0000\u0000m]\u0001"+
		"\u0000\u0000\u0000m`\u0001\u0000\u0000\u0000me\u0001\u0000\u0000\u0000"+
		"mi\u0001\u0000\u0000\u0000n\u0010\u0001\u0000\u0000\u0000\u0011\u0000"+
		"\u0017\u001b#-/357=AGNQUYm\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}