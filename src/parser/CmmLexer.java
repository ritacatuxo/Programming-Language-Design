// Generated from D:/segundo cuatri/DLP/DLP/src/parser/Cmm.g4 by ANTLR 4.13.1
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
		COMMENT=1, MULTILINE_COLUMN=2, ID=3, INT_CONSTANT=4, REAL_CONSTANT=5, 
		CHAR_CONSTANT=6, WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "MULTILINE_COLUMN", "LETTER", "DIGIT", "ID", "INT_CONSTANT", 
			"FLOAT", "MANTISSA", "REAL_CONSTANT", "CHAR_CONSTANT", "WS"
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
			null, "COMMENT", "MULTILINE_COLUMN", "ID", "INT_CONSTANT", "REAL_CONSTANT", 
			"CHAR_CONSTANT", "WS"
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
		"\u0004\u0000\u0007\u008c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001c\b\u0000\n"+
		"\u0000\f\u0000\u001f\t\u0000\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"*\b\u0001\n\u0001\f\u0001-\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004<\b\u0004"+
		"\n\u0004\f\u0004?\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004E\b\u0004\n\u0004\f\u0004H\t\u0004\u0003\u0004J\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0005\u0005N\b\u0005\n\u0005\f\u0005Q\t\u0005\u0001"+
		"\u0005\u0003\u0005T\b\u0005\u0001\u0006\u0001\u0006\u0004\u0006X\b\u0006"+
		"\u000b\u0006\f\u0006Y\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"_\b\u0006\n\u0006\f\u0006b\t\u0006\u0003\u0006d\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0003\u0007h\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007l\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\br\b\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0084\b\t\u0001\n\u0004"+
		"\n\u0087\b\n\u000b\n\f\n\u0088\u0001\n\u0001\n\u0002\u001d+\u0000\u000b"+
		"\u0001\u0001\u0003\u0002\u0005\u0000\u0007\u0000\t\u0003\u000b\u0004\r"+
		"\u0000\u000f\u0000\u0011\u0005\u0013\u0006\u0015\u0007\u0001\u0000\u0007"+
		"\u0002\u0001\n\n\r\r\u0002\u0000AZaz\u0001\u000009\u0001\u000019\u0002"+
		"\u0000EEee\u0002\u0000++--\u0003\u0000\t\n\r\r  \u009c\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000"+
		"\u0000\u00053\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t"+
		"I\u0001\u0000\u0000\u0000\u000bS\u0001\u0000\u0000\u0000\rc\u0001\u0000"+
		"\u0000\u0000\u000fg\u0001\u0000\u0000\u0000\u0011q\u0001\u0000\u0000\u0000"+
		"\u0013\u0083\u0001\u0000\u0000\u0000\u0015\u0086\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0005/\u0000\u0000\u0018\u0019\u0005/\u0000\u0000\u0019\u001d"+
		"\u0001\u0000\u0000\u0000\u001a\u001c\t\u0000\u0000\u0000\u001b\u001a\u0001"+
		"\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001e\u0001"+
		"\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e!\u0001\u0000"+
		"\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 \"\u0007\u0000\u0000"+
		"\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0006\u0000"+
		"\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005/\u0000\u0000&\'\u0005"+
		"*\u0000\u0000\'+\u0001\u0000\u0000\u0000(*\t\u0000\u0000\u0000)(\u0001"+
		"\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000./\u0005*\u0000\u0000/0\u0005/\u0000\u000001\u0001\u0000\u0000\u0000"+
		"12\u0006\u0001\u0000\u00002\u0004\u0001\u0000\u0000\u000034\u0007\u0001"+
		"\u0000\u00004\u0006\u0001\u0000\u0000\u000056\u0007\u0002\u0000\u0000"+
		"6\b\u0001\u0000\u0000\u00007=\u0003\u0005\u0002\u00008<\u0003\u0005\u0002"+
		"\u00009<\u0003\u0007\u0003\u0000:<\u0005_\u0000\u0000;8\u0001\u0000\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>J\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@F\u0005_\u0000\u0000AE\u0003"+
		"\u0005\u0002\u0000BE\u0003\u0007\u0003\u0000CE\u0005_\u0000\u0000DA\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000I7\u0001\u0000"+
		"\u0000\u0000I@\u0001\u0000\u0000\u0000J\n\u0001\u0000\u0000\u0000KO\u0007"+
		"\u0003\u0000\u0000LN\u0007\u0002\u0000\u0000ML\u0001\u0000\u0000\u0000"+
		"NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PT\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RT\u00050\u0000"+
		"\u0000SK\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000T\f\u0001\u0000"+
		"\u0000\u0000UW\u0005.\u0000\u0000VX\u0007\u0002\u0000\u0000WV\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Zd\u0001\u0000\u0000\u0000[\\\u0003\u000b\u0005\u0000"+
		"\\`\u0005.\u0000\u0000]_\u0007\u0002\u0000\u0000^]\u0001\u0000\u0000\u0000"+
		"_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cU\u0001\u0000"+
		"\u0000\u0000c[\u0001\u0000\u0000\u0000d\u000e\u0001\u0000\u0000\u0000"+
		"eh\u0003\u000b\u0005\u0000fh\u0003\r\u0006\u0000ge\u0001\u0000\u0000\u0000"+
		"gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0007\u0004\u0000"+
		"\u0000jl\u0007\u0005\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0003\u000b\u0005\u0000n\u0010"+
		"\u0001\u0000\u0000\u0000or\u0003\r\u0006\u0000pr\u0003\u000f\u0007\u0000"+
		"qo\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000r\u0012\u0001\u0000"+
		"\u0000\u0000st\u0005\'\u0000\u0000tu\t\u0000\u0000\u0000u\u0084\u0005"+
		"\'\u0000\u0000vw\u0005\'\u0000\u0000wx\u0005\\\u0000\u0000xy\u0003\u000b"+
		"\u0005\u0000yz\u0005\'\u0000\u0000z\u0084\u0001\u0000\u0000\u0000{|\u0005"+
		"\'\u0000\u0000|}\u0005\\\u0000\u0000}~\u0005n\u0000\u0000~\u0084\u0005"+
		"\'\u0000\u0000\u007f\u0080\u0005\'\u0000\u0000\u0080\u0081\u0005\\\u0000"+
		"\u0000\u0081\u0082\u0005t\u0000\u0000\u0082\u0084\u0005\'\u0000\u0000"+
		"\u0083s\u0001\u0000\u0000\u0000\u0083v\u0001\u0000\u0000\u0000\u0083{"+
		"\u0001\u0000\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0084\u0014"+
		"\u0001\u0000\u0000\u0000\u0085\u0087\u0007\u0006\u0000\u0000\u0086\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0006\n\u0000\u0000\u008b\u0016\u0001"+
		"\u0000\u0000\u0000\u0013\u0000\u001d!+;=DFIOSY`cgkq\u0083\u0088\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}