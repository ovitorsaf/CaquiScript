// Generated from c:\Users\gates\git\repository\CaquiScript_V1\CaquiScript.g4 by ANTLR 4.9.2
 
	import br.com.caquiscript.datastructures.CaquiSymbol;
	import br.com.caquiscript.datastructures.CaquiVariable;
	import br.com.caquiscript.datastructures.CaquiSymbolTable;
	import br.com.caquiscript.exceptions.CaquiSemanticException;
	import br.com.caquiscript.ast.AbstractCommand;
	import br.com.caquiscript.ast.CaquiProgram;
	import br.com.caquiscript.ast.CommandLeitura;
	import br.com.caquiscript.ast.CommandEscrita;
	import br.com.caquiscript.ast.CommandAtribuicao;
	import br.com.caquiscript.ast.CommandDecisao;

	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CaquiScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, AC=13, FC=14, OP=15, VI=16, OPREL=17, ATTR=18, ID=19, 
		NUMBER=20, INT=21, DOUBLE=22, STRING=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"AP", "FP", "SC", "AC", "FC", "OP", "VI", "OPREL", "ATTR", "ID", "NUMBER", 
			"INT", "DOUBLE", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'start'", "'end'", "'int'", "'double'", "'string'", "'read'", 
			"'write'", "'if'", "'else'", "'('", "')'", "';'", "'{'", "'}'", null, 
			"','", null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
			"SC", "AC", "FC", "OP", "VI", "OPREL", "ATTR", "ID", "NUMBER", "INT", 
			"DOUBLE", "STRING", "WS"
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

	 
		private int _tipo;
		private String _varName;
		private String _varValue;
		private CaquiSymbolTable symbolTable = new CaquiSymbolTable();
		private CaquiSymbol symbol;
		private CaquiProgram program = new CaquiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();	
		
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;

		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new CaquiSemanticException("Symbol  " + id + "  not declared");
			} 
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		


	public CaquiScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CaquiScript.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22{\n\22\3\23\3\23\3\24\3\24\7\24\u0081"+
		"\n\24\f\24\16\24\u0084\13\24\3\25\6\25\u0087\n\25\r\25\16\25\u0088\3\25"+
		"\3\25\6\25\u008d\n\25\r\25\16\25\u008e\5\25\u0091\n\25\3\26\6\26\u0094"+
		"\n\26\r\26\16\26\u0095\3\27\6\27\u0099\n\27\r\27\16\27\u009a\3\27\3\27"+
		"\6\27\u009f\n\27\r\27\16\27\u00a0\3\30\3\30\7\30\u00a5\n\30\f\30\16\30"+
		"\u00a8\13\30\3\30\3\30\3\31\3\31\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\3\2\b\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62;"+
		"\3\2$$\5\2\13\f\17\17\"\"\2\u00bb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\59\3\2\2"+
		"\2\7=\3\2\2\2\tA\3\2\2\2\13H\3\2\2\2\rO\3\2\2\2\17T\3\2\2\2\21Z\3\2\2"+
		"\2\23]\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31f\3\2\2\2\33h\3\2\2\2\35j\3\2"+
		"\2\2\37l\3\2\2\2!n\3\2\2\2#z\3\2\2\2%|\3\2\2\2\'~\3\2\2\2)\u0086\3\2\2"+
		"\2+\u0093\3\2\2\2-\u0098\3\2\2\2/\u00a2\3\2\2\2\61\u00ab\3\2\2\2\63\64"+
		"\7u\2\2\64\65\7v\2\2\65\66\7c\2\2\66\67\7t\2\2\678\7v\2\28\4\3\2\2\29"+
		":\7g\2\2:;\7p\2\2;<\7f\2\2<\6\3\2\2\2=>\7k\2\2>?\7p\2\2?@\7v\2\2@\b\3"+
		"\2\2\2AB\7f\2\2BC\7q\2\2CD\7w\2\2DE\7d\2\2EF\7n\2\2FG\7g\2\2G\n\3\2\2"+
		"\2HI\7u\2\2IJ\7v\2\2JK\7t\2\2KL\7k\2\2LM\7p\2\2MN\7i\2\2N\f\3\2\2\2OP"+
		"\7t\2\2PQ\7g\2\2QR\7c\2\2RS\7f\2\2S\16\3\2\2\2TU\7y\2\2UV\7t\2\2VW\7k"+
		"\2\2WX\7v\2\2XY\7g\2\2Y\20\3\2\2\2Z[\7k\2\2[\\\7h\2\2\\\22\3\2\2\2]^\7"+
		"g\2\2^_\7n\2\2_`\7u\2\2`a\7g\2\2a\24\3\2\2\2bc\7*\2\2c\26\3\2\2\2de\7"+
		"+\2\2e\30\3\2\2\2fg\7=\2\2g\32\3\2\2\2hi\7}\2\2i\34\3\2\2\2jk\7\177\2"+
		"\2k\36\3\2\2\2lm\t\2\2\2m \3\2\2\2no\7.\2\2o\"\3\2\2\2p{\7>\2\2qr\7>\2"+
		"\2r{\7?\2\2s{\7@\2\2tu\7@\2\2u{\7?\2\2vw\7?\2\2w{\7?\2\2xy\7#\2\2y{\7"+
		"?\2\2zp\3\2\2\2zq\3\2\2\2zs\3\2\2\2zt\3\2\2\2zv\3\2\2\2zx\3\2\2\2{$\3"+
		"\2\2\2|}\7?\2\2}&\3\2\2\2~\u0082\t\3\2\2\177\u0081\t\4\2\2\u0080\177\3"+
		"\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"(\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\t\5\2\2\u0086\u0085\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0090"+
		"\3\2\2\2\u008a\u008c\7\60\2\2\u008b\u008d\t\5\2\2\u008c\u008b\3\2\2\2"+
		"\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091"+
		"\3\2\2\2\u0090\u008a\3\2\2\2\u0090\u0091\3\2\2\2\u0091*\3\2\2\2\u0092"+
		"\u0094\t\5\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096,\3\2\2\2\u0097\u0099\t\5\2\2\u0098\u0097"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009e\7\60\2\2\u009d\u009f\t\5\2\2\u009e\u009d\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		".\3\2\2\2\u00a2\u00a6\7$\2\2\u00a3\u00a5\n\6\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7$\2\2\u00aa\60\3\2\2\2\u00ab\u00ac"+
		"\t\7\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\31\2\2\u00ae\62\3\2\2\2\r\2"+
		"z\u0080\u0082\u0088\u008e\u0090\u0095\u009a\u00a0\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}