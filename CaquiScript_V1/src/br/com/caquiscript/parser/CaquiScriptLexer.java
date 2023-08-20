// Generated from .\CaquiScript.g4 by ANTLR 4.7.1
package br.com.caquiscript.parser;
 
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
	import br.com.caquiscript.ast.CommandWhile;
	import br.com.caquiscript.ast.CommandDeclVar;
	import br.com.caquiscript.ast.CommandFor;
	
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashSet;
	import java.util.Set;

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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, SC=12, SUM=13, SUB=14, MULT=15, DIV=16, AP=17, FP=18, 
		AC=19, FC=20, VI=21, OPREL=22, OPINC=23, TRUE=24, ATTR=25, ID=26, NUMBER=27, 
		INT=28, DOUBLE=29, STRING=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "SC", "SUM", "SUB", "MULT", "DIV", "AP", "FP", "AC", 
		"FC", "VI", "OPREL", "OPINC", "TRUE", "ATTR", "ID", "NUMBER", "INT", "DOUBLE", 
		"STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'start'", "'end'", "'int'", "'double'", "'string'", "'read'", "'write'", 
		"'if'", "'else'", "'while'", "'for'", "';'", "'+'", "'-'", "'*'", "'/'", 
		"'('", "')'", "'{'", "'}'", "','", null, null, "'true'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"SC", "SUM", "SUB", "MULT", "DIV", "AP", "FP", "AC", "FC", "VI", "OPREL", 
		"OPINC", "TRUE", "ATTR", "ID", "NUMBER", "INT", "DOUBLE", "STRING", "WS"
	};
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
		private String _exprString;
		private String _writeString;
		
		private String _declVarName;
		private Integer _declVarType;
		private String _declVarValue;
		
		private String _forInitialVar;
		private String _forCondition;
		private String _forIncrement;
		
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<AbstractCommand> commandsWhile;
		
		private ArrayList<AbstractCommand> commandsFor;

		 
		Set<String> declaredVariables = new HashSet<String>();
	    Set<String> usedVariables = new HashSet<String>();
		Set<String> referencedVariables = new HashSet<String>();


		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new CaquiSemanticException("Symbol  " + id + "  not declared");
			} 
		}
		
		public boolean verificaIdBool(String id){
			if (!symbolTable.exists(id)){
				throw new CaquiSemanticException("Symbol  " + id + "  not declared");
			} else {
				return true;
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
		
		public void setExprString(String str){
			_exprString = str;
		}
		
		
		public String getExprString(){
			return _exprString;
		}
		
		
		
		public void setDeclVarName(String str){
			_declVarName = str;
		}
		
		public String getDeclVarName(){
			return _declVarName;
		}
		
		
		public void setDeclVarValue(String value){
			_declVarValue = value;
		}
		
		public String getDeclVarValue(){
			return _declVarValue;
		}
		
		
		public void setDeclVarType(Integer number){
			_declVarType = number;
		}
		
		public String getDeclVarType(){
			
			if(_declVarType == 0){
				return "int";
			} else if(_declVarType == 1){
				return "double";
			}
			else {
				return "String";
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00d8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0099\n\27\3\30\3\30\3\30\3\30\5\30"+
		"\u009f\n\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\7\33\u00aa\n"+
		"\33\f\33\16\33\u00ad\13\33\3\34\6\34\u00b0\n\34\r\34\16\34\u00b1\3\34"+
		"\3\34\6\34\u00b6\n\34\r\34\16\34\u00b7\5\34\u00ba\n\34\3\35\6\35\u00bd"+
		"\n\35\r\35\16\35\u00be\3\36\6\36\u00c2\n\36\r\36\16\36\u00c3\3\36\3\36"+
		"\6\36\u00c8\n\36\r\36\16\36\u00c9\3\37\3\37\7\37\u00ce\n\37\f\37\16\37"+
		"\u00d1\13\37\3\37\3\37\3 \3 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\7\3\2c|\5\2\62;C\\c|"+
		"\3\2\62;\3\2$$\5\2\13\f\17\17\"\"\2\u00e5\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\3A\3\2\2\2\5G\3\2\2\2\7K\3\2\2\2\tO\3\2\2\2\13V\3\2\2\2\r]\3\2\2\2\17"+
		"b\3\2\2\2\21h\3\2\2\2\23k\3\2\2\2\25p\3\2\2\2\27v\3\2\2\2\31z\3\2\2\2"+
		"\33|\3\2\2\2\35~\3\2\2\2\37\u0080\3\2\2\2!\u0082\3\2\2\2#\u0084\3\2\2"+
		"\2%\u0086\3\2\2\2\'\u0088\3\2\2\2)\u008a\3\2\2\2+\u008c\3\2\2\2-\u0098"+
		"\3\2\2\2/\u009e\3\2\2\2\61\u00a0\3\2\2\2\63\u00a5\3\2\2\2\65\u00a7\3\2"+
		"\2\2\67\u00af\3\2\2\29\u00bc\3\2\2\2;\u00c1\3\2\2\2=\u00cb\3\2\2\2?\u00d4"+
		"\3\2\2\2AB\7u\2\2BC\7v\2\2CD\7c\2\2DE\7t\2\2EF\7v\2\2F\4\3\2\2\2GH\7g"+
		"\2\2HI\7p\2\2IJ\7f\2\2J\6\3\2\2\2KL\7k\2\2LM\7p\2\2MN\7v\2\2N\b\3\2\2"+
		"\2OP\7f\2\2PQ\7q\2\2QR\7w\2\2RS\7d\2\2ST\7n\2\2TU\7g\2\2U\n\3\2\2\2VW"+
		"\7u\2\2WX\7v\2\2XY\7t\2\2YZ\7k\2\2Z[\7p\2\2[\\\7i\2\2\\\f\3\2\2\2]^\7"+
		"t\2\2^_\7g\2\2_`\7c\2\2`a\7f\2\2a\16\3\2\2\2bc\7y\2\2cd\7t\2\2de\7k\2"+
		"\2ef\7v\2\2fg\7g\2\2g\20\3\2\2\2hi\7k\2\2ij\7h\2\2j\22\3\2\2\2kl\7g\2"+
		"\2lm\7n\2\2mn\7u\2\2no\7g\2\2o\24\3\2\2\2pq\7y\2\2qr\7j\2\2rs\7k\2\2s"+
		"t\7n\2\2tu\7g\2\2u\26\3\2\2\2vw\7h\2\2wx\7q\2\2xy\7t\2\2y\30\3\2\2\2z"+
		"{\7=\2\2{\32\3\2\2\2|}\7-\2\2}\34\3\2\2\2~\177\7/\2\2\177\36\3\2\2\2\u0080"+
		"\u0081\7,\2\2\u0081 \3\2\2\2\u0082\u0083\7\61\2\2\u0083\"\3\2\2\2\u0084"+
		"\u0085\7*\2\2\u0085$\3\2\2\2\u0086\u0087\7+\2\2\u0087&\3\2\2\2\u0088\u0089"+
		"\7}\2\2\u0089(\3\2\2\2\u008a\u008b\7\177\2\2\u008b*\3\2\2\2\u008c\u008d"+
		"\7.\2\2\u008d,\3\2\2\2\u008e\u0099\7>\2\2\u008f\u0090\7>\2\2\u0090\u0099"+
		"\7?\2\2\u0091\u0099\7@\2\2\u0092\u0093\7@\2\2\u0093\u0099\7?\2\2\u0094"+
		"\u0095\7?\2\2\u0095\u0099\7?\2\2\u0096\u0097\7#\2\2\u0097\u0099\7?\2\2"+
		"\u0098\u008e\3\2\2\2\u0098\u008f\3\2\2\2\u0098\u0091\3\2\2\2\u0098\u0092"+
		"\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0096\3\2\2\2\u0099.\3\2\2\2\u009a"+
		"\u009b\7-\2\2\u009b\u009f\7-\2\2\u009c\u009d\7/\2\2\u009d\u009f\7/\2\2"+
		"\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f\60\3\2\2\2\u00a0\u00a1"+
		"\7v\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7g\2\2\u00a4"+
		"\62\3\2\2\2\u00a5\u00a6\7?\2\2\u00a6\64\3\2\2\2\u00a7\u00ab\t\2\2\2\u00a8"+
		"\u00aa\t\3\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\66\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0"+
		"\t\4\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b9\3\2\2\2\u00b3\u00b5\7\60\2\2\u00b4\u00b6\t"+
		"\4\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba8\3\2\2\2\u00bb\u00bd\t\4\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf:\3\2\2\2\u00c0"+
		"\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\7\60\2\2\u00c6"+
		"\u00c8\t\4\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2"+
		"\2\2\u00c9\u00ca\3\2\2\2\u00ca<\3\2\2\2\u00cb\u00cf\7$\2\2\u00cc\u00ce"+
		"\n\5\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7$"+
		"\2\2\u00d3>\3\2\2\2\u00d4\u00d5\t\6\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7"+
		"\b \2\2\u00d7@\3\2\2\2\16\2\u0098\u009e\u00a9\u00ab\u00b1\u00b7\u00b9"+
		"\u00be\u00c3\u00c9\u00cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}