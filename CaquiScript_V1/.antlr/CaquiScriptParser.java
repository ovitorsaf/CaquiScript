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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CaquiScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, AC=13, FC=14, OP=15, VI=16, OPREL=17, ATTR=18, ID=19, 
		NUMBER=20, INT=21, DOUBLE=22, STRING=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_declaration = 1, RULE_declvar = 2, RULE_type = 3, 
		RULE_value = 4, RULE_bloco = 5, RULE_cmd = 6, RULE_cmdLeitura = 7, RULE_cmdEscrita = 8, 
		RULE_cmdAttr = 9, RULE_ifStatement = 10, RULE_expr = 11, RULE_termo = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declaration", "declvar", "type", "value", "bloco", "cmd", "cmdLeitura", 
			"cmdEscrita", "cmdAttr", "ifStatement", "expr", "termo"
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

	@Override
	public String getGrammarFileName() { return "CaquiScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	 
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
		

	public CaquiScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
				{
				setState(27);
				declaration();
				}
			}

			setState(30);
			bloco();
			setState(31);
			match(T__1);
			 
					  	program.setVarTable(symbolTable);
					  	program.setComandos(stack.pop()); 
					  
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

	public static class DeclarationContext extends ParserRuleContext {
		public List<DeclvarContext> declvar() {
			return getRuleContexts(DeclvarContext.class);
		}
		public DeclvarContext declvar(int i) {
			return getRuleContext(DeclvarContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declvar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
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

	public static class DeclvarContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CaquiScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CaquiScriptParser.ID, i);
		}
		public TerminalNode SC() { return getToken(CaquiScriptParser.SC, 0); }
		public List<TerminalNode> VI() { return getTokens(CaquiScriptParser.VI); }
		public TerminalNode VI(int i) {
			return getToken(CaquiScriptParser.VI, i);
		}
		public DeclvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declvar; }
	}

	public final DeclvarContext declvar() throws RecognitionException {
		DeclvarContext _localctx = new DeclvarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			type();
			setState(40);
			match(ID);

								_varName = _input.LT(-1).getText();
								_varValue = null;
								symbol = new CaquiVariable(_varName, _tipo, _varValue);
								if (!symbolTable.exists(_varName)){ 
									symbolTable.add(symbol);
									System.out.println("Simbolo adicionado -> " + symbol);
								}
								else {
									throw new CaquiSemanticException("Symbol  " + _varName + "  already declared");
								}
							
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VI) {
				{
				{
				setState(42);
				match(VI);
				setState(43);
				match(ID);

									_varName = _input.LT(-1).getText();
									_varValue = null;
									symbol = new CaquiVariable(_varName, _tipo, _varValue);
									if (!symbolTable.exists(_varName)){ 
										symbolTable.add(symbol);
										System.out.println("Simbolo adicionado -> " + symbol);
									}
									else {
										throw new CaquiSemanticException("Symbol  " + _varName + "  already declared");
									}
								
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(SC);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 _tipo = CaquiVariable.INT; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 _tipo = CaquiVariable.DOUBLE; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__4);
				 _tipo = CaquiVariable.STRING; 
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CaquiScriptParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(CaquiScriptParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(CaquiScriptParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
						stack.push(curThread);
					  
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				cmd();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
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

	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdAttrContext cmdAttr() {
			return getRuleContext(CmdAttrContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				cmdLeitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				cmdAttr();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				ifStatement();
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

	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(CaquiScriptParser.AP, 0); }
		public TerminalNode ID() { return getToken(CaquiScriptParser.ID, 0); }
		public TerminalNode FP() { return getToken(CaquiScriptParser.FP, 0); }
		public TerminalNode SC() { return getToken(CaquiScriptParser.SC, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__5);
			setState(75);
			match(AP);
			setState(76);
			match(ID);
			 
										verificaID(_input.LT(-1).getText()); 
										_readID = _input.LT(-1).getText();
										System.out.println("ID -> " + _readID);
									
			setState(78);
			match(FP);
			setState(79);
			match(SC);

									CaquiVariable var = (CaquiVariable)symbolTable.get(_readID);
									CommandLeitura cmd = new CommandLeitura(_readID, var);
									stack.peek().add(cmd);
								
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

	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(CaquiScriptParser.AP, 0); }
		public TerminalNode FP() { return getToken(CaquiScriptParser.FP, 0); }
		public TerminalNode SC() { return getToken(CaquiScriptParser.SC, 0); }
		public List<TerminalNode> ID() { return getTokens(CaquiScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CaquiScriptParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CaquiScriptParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CaquiScriptParser.NUMBER, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(CaquiScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(CaquiScriptParser.STRING, i);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdEscrita);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__6);
			setState(83);
			match(AP);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(84);
					match(ID);
					 
												verificaID(_input.LT(-1).getText()); 
												_writeID = _input.LT(-1).getText();
											
					}
					break;
				case 2:
					{
					setState(86);
					match(NUMBER);
					}
					break;
				case 3:
					{
					setState(87);
					expr();
					}
					break;
				case 4:
					{
					setState(88);
					match(STRING);
					}
					break;
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(FP);
			setState(95);
			match(SC);

									CommandEscrita cmd = new CommandEscrita(_writeID);
									stack.peek().add(cmd);
								
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

	public static class CmdAttrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CaquiScriptParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(CaquiScriptParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(CaquiScriptParser.SC, 0); }
		public CmdAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttr; }
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ID);
			 verificaID(_input.LT(-1).getText()); 
						   _exprID = _input.LT(-1).getText();
						 
			setState(100);
			match(ATTR);
			 _exprContent = ""; 
			setState(102);
			expr();
			setState(103);
			match(SC);

						CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
						stack.peek().add(cmd);
					
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(CaquiScriptParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(CaquiScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CaquiScriptParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(CaquiScriptParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(CaquiScriptParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(CaquiScriptParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(CaquiScriptParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(CaquiScriptParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(CaquiScriptParser.FC, i);
		}
		public TerminalNode NUMBER() { return getToken(CaquiScriptParser.NUMBER, 0); }
		public List<DeclvarContext> declvar() {
			return getRuleContexts(DeclvarContext.class);
		}
		public DeclvarContext declvar(int i) {
			return getRuleContext(DeclvarContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__7);
			setState(107);
			match(AP);
			setState(108);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(110);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(112);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprDecision += _input.LT(-1).getText(); 
			setState(114);
			match(FP);
			setState(115);
			match(AC);
			 
							   	curThread = new ArrayList<AbstractCommand>(); 
							   	stack.push(curThread);	
							   
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
				{
				setState(117);
				declvar();
				}
			}

			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				cmd();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
			setState(125);
			match(FC);

							   	listaTrue = stack.pop();
							   
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(127);
				match(T__8);
				setState(128);
				match(AC);

								   			curThread = new ArrayList<AbstractCommand>(); 
								   			stack.push(curThread);
								   		
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
					{
					setState(130);
					declvar();
					}
				}

				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(133);
					cmd();
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
				setState(138);
				match(FC);

											listaFalse = stack.pop();
											CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
											stack.peek().add(cmd);
										
				}
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(CaquiScriptParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(CaquiScriptParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			termo();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(144);
				match(OP);
				 
										_exprContent += _input.LT(-1).getText(); 
									 
				setState(146);
				termo();
				}
				}
				setState(151);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CaquiScriptParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(CaquiScriptParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(ID);
				 verificaID(_input.LT(-1).getText()); 
							 	_exprContent += _input.LT(-1).getText();
							 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(NUMBER);
				 _exprContent += _input.LT(-1).getText(); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u00a1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\5\2\37\n\2\3\2\3\2\3\2\3\2\3\3"+
		"\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\6\3\6\3\7\3\7\6\7C\n\7\r"+
		"\7\16\7D\3\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\fy\n\f\3\f\6\f|\n\f\r\f\16\f}\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u0086\n\f\3\f\6\f\u0089\n\f\r\f\16\f\u008a\3\f\3\f\3\f\5\f\u0090"+
		"\n\f\3\r\3\r\3\r\3\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\3\16\3\16\3\16"+
		"\3\16\5\16\u009f\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4"+
		"\3\2\27\31\3\2\25\26\2\u00a7\2\34\3\2\2\2\4%\3\2\2\2\6)\3\2\2\2\b<\3\2"+
		"\2\2\n>\3\2\2\2\f@\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2\22T\3\2\2\2\24d\3\2"+
		"\2\2\26l\3\2\2\2\30\u0091\3\2\2\2\32\u009e\3\2\2\2\34\36\7\3\2\2\35\37"+
		"\5\4\3\2\36\35\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\5\f\7\2!\"\7\4\2\2"+
		"\"#\b\2\1\2#\3\3\2\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(\5\3\2\2\2)*\5\b\5\2*+\7\25\2\2+\61\b\4\1\2,-\7\22\2\2-.\7\25\2"+
		"\2.\60\b\4\1\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64"+
		"\3\2\2\2\63\61\3\2\2\2\64\65\7\16\2\2\65\7\3\2\2\2\66\67\7\5\2\2\67=\b"+
		"\5\1\289\7\6\2\29=\b\5\1\2:;\7\7\2\2;=\b\5\1\2<\66\3\2\2\2<8\3\2\2\2<"+
		":\3\2\2\2=\t\3\2\2\2>?\t\2\2\2?\13\3\2\2\2@B\b\7\1\2AC\5\16\b\2BA\3\2"+
		"\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\r\3\2\2\2FK\5\20\t\2GK\5\22\n\2HK"+
		"\5\24\13\2IK\5\26\f\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\17\3\2"+
		"\2\2LM\7\b\2\2MN\7\f\2\2NO\7\25\2\2OP\b\t\1\2PQ\7\r\2\2QR\7\16\2\2RS\b"+
		"\t\1\2S\21\3\2\2\2TU\7\t\2\2U]\7\f\2\2VW\7\25\2\2W\\\b\n\1\2X\\\7\26\2"+
		"\2Y\\\5\30\r\2Z\\\7\31\2\2[V\3\2\2\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\_"+
		"\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\r\2\2ab\7\16\2\2"+
		"bc\b\n\1\2c\23\3\2\2\2de\7\25\2\2ef\b\13\1\2fg\7\24\2\2gh\b\13\1\2hi\5"+
		"\30\r\2ij\7\16\2\2jk\b\13\1\2k\25\3\2\2\2lm\7\n\2\2mn\7\f\2\2no\7\25\2"+
		"\2op\b\f\1\2pq\7\23\2\2qr\b\f\1\2rs\t\3\2\2st\b\f\1\2tu\7\r\2\2uv\7\17"+
		"\2\2vx\b\f\1\2wy\5\6\4\2xw\3\2\2\2xy\3\2\2\2y{\3\2\2\2z|\5\16\b\2{z\3"+
		"\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\20\2\2\u0080"+
		"\u008f\b\f\1\2\u0081\u0082\7\13\2\2\u0082\u0083\7\17\2\2\u0083\u0085\b"+
		"\f\1\2\u0084\u0086\5\6\4\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0088\3\2\2\2\u0087\u0089\5\16\b\2\u0088\u0087\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\7\20\2\2\u008d\u008e\b\f\1\2\u008e\u0090\3\2\2\2\u008f\u0081\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\27\3\2\2\2\u0091\u0097\5\32\16\2\u0092"+
		"\u0093\7\21\2\2\u0093\u0094\b\r\1\2\u0094\u0096\5\32\16\2\u0095\u0092"+
		"\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\31\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\25\2\2\u009b\u009f\b\16"+
		"\1\2\u009c\u009d\7\26\2\2\u009d\u009f\b\16\1\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\33\3\2\2\2\21\36\'\61<DJ[]x}\u0085\u008a\u008f\u0097"+
		"\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}