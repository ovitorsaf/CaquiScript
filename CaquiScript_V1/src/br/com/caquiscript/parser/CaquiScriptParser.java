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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, SC=12, SUM=13, SUB=14, MULT=15, DIV=16, AP=17, FP=18, 
		AC=19, FC=20, VI=21, OPREL=22, OPINC=23, TRUE=24, ATTR=25, ID=26, NUMBER=27, 
		INT=28, DOUBLE=29, STRING=30, WS=31;
	public static final int
		RULE_prog = 0, RULE_declaration = 1, RULE_declvar = 2, RULE_type = 3, 
		RULE_value = 4, RULE_bloco = 5, RULE_cmd = 6, RULE_cmdLeitura = 7, RULE_cmdEscrita = 8, 
		RULE_cmdAttr = 9, RULE_ifStatement = 10, RULE_whileLoop = 11, RULE_forLoop = 12, 
		RULE_outputArgs = 13, RULE_expr = 14, RULE_termo = 15, RULE_checkVars = 16;
	public static final String[] ruleNames = {
		"prog", "declaration", "declvar", "type", "value", "bloco", "cmd", "cmdLeitura", 
		"cmdEscrita", "cmdAttr", "ifStatement", "whileLoop", "forLoop", "outputArgs", 
		"expr", "termo", "checkVars"
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
		

	public CaquiScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public CheckVarsContext checkVars() {
			return getRuleContext(CheckVarsContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(35);
				declaration();
				}
				break;
			}
			setState(38);
			bloco();
			setState(39);
			checkVars();
			setState(40);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(43);
					declvar();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(46); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public List<TerminalNode> ATTR() { return getTokens(CaquiScriptParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(CaquiScriptParser.ATTR, i);
		}
		public List<TerminalNode> VI() { return getTokens(CaquiScriptParser.VI); }
		public TerminalNode VI(int i) {
			return getToken(CaquiScriptParser.VI, i);
		}
		public TerminalNode SC() { return getToken(CaquiScriptParser.SC, 0); }
		public List<TerminalNode> STRING() { return getTokens(CaquiScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(CaquiScriptParser.STRING, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CaquiScriptParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CaquiScriptParser.NUMBER, i);
		}
		public DeclvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterDeclvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitDeclvar(this);
		}
	}

	public final DeclvarContext declvar() throws RecognitionException {
		DeclvarContext _localctx = new DeclvarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			type();
			setState(49);
			match(ID);

									_varName = _input.LT(-1).getText();
									_varValue = null;
									symbol = new CaquiVariable(_varName, _tipo, _varValue);
									if (!symbolTable.exists(_varName)){ 
										symbolTable.add(symbol);
										System.out.println("Simbolo adicionado -> " + symbol);
										setDeclVarName(_varName);
										setDeclVarType(_tipo);
										
										//Adiciona variável para varíaveis declaradas
			            				declaredVariables.add(getDeclVarName());
										System.out.println("Declaração Adicionada -> " + getDeclVarType() + " " + getDeclVarName());
					
									}
									else {
										throw new CaquiSemanticException("Symbol  " + _varName + "  already declared");
									}
								
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(51);
				match(ATTR);
				setState(56);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(52);
					match(STRING);

													// Lógica para atualizar o valor se já tiver sido assinalado na hora da criação da variável		
													String str = _input.LT(-1).getText();
													System.out.println("->-> str: " + str);
													 
													 for(CaquiSymbol symbol: symbolTable.getAll()){
												 		//System.out.println("->-> Var: " + symbol.getName() + " valor = " + symbolTable.get(getDeclVarName()));
													
														if(symbol.getName().equals(symbolTable.get(getDeclVarName()).getName())){
															System.out.println("var = " + symbol.getName() + " | valor = " + symbolTable.get(getDeclVarName()).getValue());
															symbol.setValue(str);
															//setDeclVarName("joab manoel gome");
															setDeclVarValue(str);
															referencedVariables.add(symbol.getName());
															System.out.println("var = " + symbol.getName() + " | valor = " + getDeclVarValue());
														}
														
													 }
												
					}
					break;
				case NUMBER:
					{
					setState(54);
					match(NUMBER);

													// Lógica para atualizar o valor se já tiver sido assinalado na hora da criação da variável		
													String numberString = _input.LT(-1).getText();
													//System.out.println("->-> numberString: " + numberString);
													 
													 for(CaquiSymbol symbol: symbolTable.getAll()){
												 		//System.out.println("->-> Var: " + symbol.getName() + " valor = " + symbolTable.get(getDeclVarName()));
													
														if(symbol.getName().equals(symbolTable.get(getDeclVarName()).getName())){
															System.out.println(symbol.getName() + " = " + symbolTable.get(getDeclVarName()).getValue());
															symbol.setValue(numberString);
															//setDeclVarName(numberString);
															setDeclVarValue(numberString);
															referencedVariables.add(symbol.getName());
															System.out.println(symbol.getName() + " = " + getDeclVarValue());
														}
														
													 }
												
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VI) {
				{
				{
				setState(60);
				match(VI);
				setState(61);
				match(ID);

									_varName = _input.LT(-1).getText();
									_varValue = null;
									symbol = new CaquiVariable(_varName, _tipo, _varValue);
									if (!symbolTable.exists(_varName)){ 
										symbolTable.add(symbol);
										System.out.println("Simbolo adicionado -> " + symbol);
										setDeclVarName(_varName);
										setDeclVarType(_tipo);

										//Adiciona variável para varíaveis declaradas
										declaredVariables.add(getDeclVarName());
										System.out.println("Declaração Adicionada -> " + getDeclVarType() + " " + getDeclVarName());
										
									}
									else {
										throw new CaquiSemanticException("Symbol  " + _varName + "  already declared");
									}
								
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ATTR) {
					{
					setState(63);
					match(ATTR);
					setState(64);
					_la = _input.LA(1);
					if ( !(_la==NUMBER || _la==STRING) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(72);
				match(SC);
				}
				break;
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(T__2);
				 _tipo = CaquiVariable.INT; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__3);
				 _tipo = CaquiVariable.DOUBLE; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitBloco(this);
		}
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
					  
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				cmd();
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
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
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public DeclvarContext declvar() {
			return getRuleContext(DeclvarContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				cmdLeitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				cmdAttr();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				ifStatement();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				whileLoop();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				declvar();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 7);
				{
				setState(97);
				forLoop();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__5);
			setState(101);
			match(AP);
			setState(102);
			match(ID);
			 
									verificaID(_input.LT(-1).getText()); 
									_readID = _input.LT(-1).getText();
									System.out.println("ID -> " + _readID);
									
									//Add variavel no usedVariables		
									usedVariables.add(_input.LT(-1).getText());
								
			setState(104);
			match(FP);
			setState(105);
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
		public TerminalNode ID() { return getToken(CaquiScriptParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(CaquiScriptParser.NUMBER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutputArgsContext outputArgs() {
			return getRuleContext(OutputArgsContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__6);
			setState(109);
			match(AP);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(110);
				match(ID);
				 
										if(verificaIdBool(_input.LT(-1).getText()))
										{	
											_writeID = _input.LT(-1).getText();
											CommandEscrita cmd = new CommandEscrita(_writeID);
										  	System.out.println("writeln -> _writeID = " + _writeID);
											stack.peek().add(cmd);
										}
										
										//Add variavel no usedVariables		
										usedVariables.add(_input.LT(-1).getText());
									
				}
				break;
			case 2:
				{
				setState(112);
				match(NUMBER);

							  		_writeID = _input.LT(-1).getText();
									CommandEscrita cmd = new CommandEscrita(_writeID);
								  	System.out.println("writeln -> _writeID = " + _writeID);
									stack.peek().add(cmd);
							  	
				}
				break;
			case 3:
				{
				setState(114);
				expr();

									System.out.println("write -> exprString = " + _exprString);
									CommandEscrita cmd = new CommandEscrita(_exprString);
									stack.peek().add(cmd);
								
				}
				break;
			case 4:
				{
				setState(117);
				outputArgs();
				}
				break;
			}
			setState(120);
			match(FP);
			setState(121);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterCmdAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitCmdAttr(this);
		}
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(ID);
			 verificaID(_input.LT(-1).getText()); 
						   _exprID = _input.LT(-1).getText();
						   
						   //Add variavel no usedVariables
						   usedVariables.add(_input.LT(-1).getText());
						   
						   //Add variavel no referencedVariables	
						   referencedVariables.add(_input.LT(-1).getText());
						   System.out.println("Variável " + _input.LT(-1).getText() + " referenciada");
						 
			setState(125);
			match(ATTR);
			 _exprContent = ""; 
			setState(127);
			expr();
			setState(128);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__7);
			setState(132);
			match(AP);
			setState(133);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(135);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(137);
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
			setState(139);
			match(FP);
			setState(140);
			match(AC);
			 
							   	curThread = new ArrayList<AbstractCommand>(); 
							   	stack.push(curThread);	
							   
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(142);
				declvar();

								  			System.out.println("if -> Declaração = " + getDeclVarType() + " " + getDeclVarName());
								  			CommandDeclVar dclvar = new CommandDeclVar(getDeclVarType(), getDeclVarName());
								  			stack.peek().add(dclvar);
								  		
				}
				break;
			}
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(147);
				cmd();
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(152);
			match(FC);

							   	listaTrue = stack.pop();
							   
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(154);
				match(T__8);
				setState(155);
				match(AC);

								   			curThread = new ArrayList<AbstractCommand>(); 
								   			stack.push(curThread);
								   		
				setState(158);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(157);
					declvar();
					}
					break;
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160);
					cmd();
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
				setState(165);
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

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(CaquiScriptParser.AP, 0); }
		public TerminalNode FP() { return getToken(CaquiScriptParser.FP, 0); }
		public TerminalNode AC() { return getToken(CaquiScriptParser.AC, 0); }
		public TerminalNode FC() { return getToken(CaquiScriptParser.FC, 0); }
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(CaquiScriptParser.OPREL, 0); }
		public TerminalNode TRUE() { return getToken(CaquiScriptParser.TRUE, 0); }
		public DeclvarContext declvar() {
			return getRuleContext(DeclvarContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitWhileLoop(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__9);
			setState(171);
			match(AP);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBER:
			case STRING:
				{
				setState(172);
				termo();
				 
										  	System.out.println("while -> termo_1 = " + _input.LT(-1).getText()); 
										  	_exprDecision = _input.LT(-1).getText();
										  
				setState(174);
				match(OPREL);
				 
										  	System.out.println("while -> OPREL = " + _input.LT(-1).getText()); 
										  	_exprDecision += _input.LT(-1).getText();
										  
				setState(176);
				termo();
				 
										  	System.out.println("while -> termo_2 = " + _input.LT(-1).getText()); 
										  	_exprDecision += _input.LT(-1).getText();
										  
				}
				break;
			case TRUE:
				{
				setState(179);
				match(TRUE);
				 
										  	System.out.println("while -> TRUE = " + _input.LT(-1).getText()); 
										  	_exprDecision += _input.LT(-1).getText();
										  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183);
			match(FP);
			setState(184);
			match(AC);
			 
									   	curThread = new ArrayList<AbstractCommand>(); 
									   	stack.push(curThread);	
							   		
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(186);
				declvar();

									  			System.out.println("while -> Declaração = " + getDeclVarType() + " " + getDeclVarName());
									  			CommandDeclVar dclvar = new CommandDeclVar(getDeclVarType(), getDeclVarName());
									  			stack.peek().add(dclvar);
									  		
				}
				break;
			}
			setState(192); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(191);
				cmd();
				}
				}
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(196);
			match(FC);

							   		commandsWhile = stack.pop();
							   		System.out.println("while -> condition = " + _writeString); 
							   		CommandWhile cmd = new CommandWhile(_exprDecision, commandsWhile);
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

	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(CaquiScriptParser.AP, 0); }
		public List<TerminalNode> SC() { return getTokens(CaquiScriptParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(CaquiScriptParser.SC, i);
		}
		public TerminalNode FP() { return getToken(CaquiScriptParser.FP, 0); }
		public TerminalNode AC() { return getToken(CaquiScriptParser.AC, 0); }
		public TerminalNode FC() { return getToken(CaquiScriptParser.FC, 0); }
		public List<DeclvarContext> declvar() {
			return getRuleContexts(DeclvarContext.class);
		}
		public DeclvarContext declvar(int i) {
			return getRuleContext(DeclvarContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CaquiScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CaquiScriptParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(CaquiScriptParser.OPREL, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode OPINC() { return getToken(CaquiScriptParser.OPINC, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitForLoop(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__10);
			setState(200);
			match(AP);
			{
			setState(201);
			declvar();
			}

					  		System.out.println("for -> Declaração = " + getDeclVarType() + " " + getDeclVarName() + " = " + getDeclVarValue());
				  			_forInitialVar = getDeclVarType() + " " + getDeclVarName() + " = " + getDeclVarValue();
					  	
			setState(203);
			match(SC);
			{
			setState(204);
			match(ID);

					  		_exprDecision = _input.LT(-1).getText();
					  	
			setState(206);
			match(OPREL);

					  		System.out.println("for -> OP_REL = " + _input.LT(-1).getText());
					  		_exprDecision += _input.LT(-1).getText();
					  	
			setState(208);
			termo();

					  		System.out.println("for -> Termo_2 = " + _input.LT(-1).getText());
					  		_exprDecision += _input.LT(-1).getText();
					  	
			}
			setState(211);
			match(SC);
			{
			setState(212);
			match(ID);

					  		_forIncrement = _input.LT(-1).getText();
					  	
			setState(214);
			match(OPINC);

					  		System.out.println("for -> OP_INCR = " + _input.LT(-1).getText());
					  		_forIncrement += _input.LT(-1).getText();
					  	
			}
			setState(217);
			match(FP);
			setState(218);
			match(AC);
			 
						   	curThread = new ArrayList<AbstractCommand>(); 
						   	stack.push(curThread);	
					   	
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(220);
				declvar();
				}
				break;
			}

							//System.out.println("for -> Declaração = " + getDeclVarType() + " " + getDeclVarName());
							//CommandDeclVar dclvar = new CommandDeclVar(getDeclVarType(), getDeclVarName());
							//stack.peek().add(dclvar);
						
			setState(225); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(224);
				cmd();
				}
				}
				setState(227); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(229);
			match(FC);

					   	commandsFor = stack.pop();
					   	CommandFor cmd = new CommandFor(_forInitialVar, _exprDecision, _forIncrement, commandsFor);
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

	public static class OutputArgsContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CaquiScriptParser.STRING, 0); }
		public TerminalNode VI() { return getToken(CaquiScriptParser.VI, 0); }
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public OutputArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterOutputArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitOutputArgs(this);
		}
	}

	public final OutputArgsContext outputArgs() throws RecognitionException {
		OutputArgsContext _localctx = new OutputArgsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_outputArgs);
		int _la;
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(STRING);

							  	_writeString = _input.LT(-1).getText();
							  	System.out.println("_writeString = " + _writeString);
							  	CommandEscrita cmd = new CommandEscrita(_writeString);
								stack.peek().add(cmd);
							  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(STRING);

							  	_writeString = _input.LT(-1).getText();
							  	System.out.println("_writeString = " + _writeString);
							  
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VI) {
					{
					setState(236);
					match(VI);

								  	_writeString += ", ";
								  	System.out.println("_writeString = " + _writeString);
								  
					setState(238);
					termo();

								  	System.out.println("writeln -> termo = " + _input.LT(-1).getText());
								  	_writeString += _input.LT(-1).getText();
								  
					}
				}

				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUM) {
					{
					setState(243);
					match(SUM);

								  	_writeString += " + ";
								  	System.out.println("_writeString = " + _writeString);
								  
					setState(245);
					termo();

								  	System.out.println("writeln -> termo = " + _input.LT(-1).getText());
								  	_writeString += _input.LT(-1).getText();
								  
					}
				}


							  	System.out.println("writeln -> _writeString final = " + _writeString);
							  	CommandEscrita cmd = new CommandEscrita(_writeString);
								stack.peek().add(cmd);
							  
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public TerminalNode SUM() { return getToken(CaquiScriptParser.SUM, 0); }
		public TerminalNode SUB() { return getToken(CaquiScriptParser.SUB, 0); }
		public TerminalNode MULT() { return getToken(CaquiScriptParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CaquiScriptParser.DIV, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			termo();

					  	_writeString = _input.LT(-1).getText();
					  	System.out.println("expr -> termo_1 -> _writeString = " + _writeString);
					  	
					  	//Add variavel no usedVariables		
						usedVariables.add(_input.LT(-1).getText());
					  
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUM) | (1L << SUB) | (1L << MULT) | (1L << DIV))) != 0)) {
				{
				setState(255);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUM) | (1L << SUB) | (1L << MULT) | (1L << DIV))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 
							 	_writeString += _input.LT(-1).getText(); 
							 	System.out.println("expr -> termo_2 -> OP -> _writeString = " + _writeString);
							 	_exprContent += _input.LT(-1).getText(); 
							 
				setState(257);
				termo();

					     	 	_writeString += _input.LT(-1).getText();
					     	 	System.out.println("expr -> termo_3 -> _writeString = " + _writeString);
					     	 	
					     	 	//Add variavel no usedVariables		
								usedVariables.add(_input.LT(-1).getText());
					     	 
				}
			}

			 setExprString(_writeString); 
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
		public TerminalNode STRING() { return getToken(CaquiScriptParser.STRING, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termo);
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(ID);
				 
									verificaID(_input.LT(-1).getText()); 
									_exprContent += _input.LT(-1).getText();

									// Em qualquer referência a uma variável, adicione-a ao conjunto de variáveis usadas
									//usedVariables.add(_input.LT(-1).getText());
							 	
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(NUMBER);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				match(STRING);
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

	public static class CheckVarsContext extends ParserRuleContext {
		public CheckVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).enterCheckVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CaquiScriptListener ) ((CaquiScriptListener)listener).exitCheckVars(this);
		}
	}

	public final CheckVarsContext checkVars() throws RecognitionException {
		CheckVarsContext _localctx = new CheckVarsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_checkVars);
		try {
			enterOuterAlt(_localctx, 1);
			{

							System.out.println("EXECUTANDO CHECKVARS");
							
							/*
							for(String var : declaredVariables){
								System.out.println("Variável declarada -> " + var);
							}
							
							for(String var : referencedVariables){
								System.out.println("Variável referenciada -> " + var);
							}
							
							for(String var : usedVariables){
								System.out.println("Variável usada -> " + var);
							}
							*/
							
							
							// Crie um iterador para percorrer a lista de usedVariables
			        		Iterator<String> iterator = usedVariables.iterator();
			        		
			        		 char aspas = '"';
						        		
				    		 while (iterator.hasNext()) {
					            String elemento = iterator.next();
					            if (elemento.matches("^[0-9].*") | elemento.startsWith(String.valueOf(aspas))) {
					                iterator.remove();
					            }
					        }
					        
					        /*
					        for (String elemento : usedVariables) {
					            System.out.println("Variaveis usadas tratada -> " + elemento);
					        }
					        */
							
							Set<String> newUsedVariables = new HashSet<String>();
							for(String str : usedVariables){
								newUsedVariables.add(str);
							}
							
							newUsedVariables.removeAll(referencedVariables);
							for(String var : newUsedVariables){
								System.out.println("ALERTA - VALOR: Variável " + var + " está sendo usada sem ter valor inicial");
							}

						    declaredVariables.removeAll(usedVariables);
						    for(String var : declaredVariables) {
						        System.out.println("ALERTA - USO: Variável " + var + " foi declarada mas não foi usada.");
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0115\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\5\2\'\n\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3/\n\3\r\3\16\3\60\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4;\n\4\5\4=\n\4\3\4\3\4\3\4\3\4\3\4\5\4D"+
		"\n\4\7\4F\n\4\f\4\16\4I\13\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"T\n\5\3\6\3\6\3\7\3\7\6\7Z\n\7\r\7\16\7[\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\be\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\ny\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0094\n\f"+
		"\3\f\6\f\u0097\n\f\r\f\16\f\u0098\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a1\n"+
		"\f\3\f\6\f\u00a4\n\f\r\f\16\f\u00a5\3\f\3\f\3\f\5\f\u00ab\n\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00c0\n\r\3\r\6\r\u00c3\n\r\r\r\16\r\u00c4\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00e0\n\16\3\16\3\16\6\16\u00e4"+
		"\n\16\r\16\16\16\u00e5\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00f4\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fb\n\17"+
		"\3\17\5\17\u00fe\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0107\n"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0111\n\21\3\22\3\22"+
		"\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\6\4\2\35\35 "+
		" \3\2\36 \3\2\34\35\3\2\17\22\2\u0126\2$\3\2\2\2\4.\3\2\2\2\6\62\3\2\2"+
		"\2\bS\3\2\2\2\nU\3\2\2\2\fW\3\2\2\2\16d\3\2\2\2\20f\3\2\2\2\22n\3\2\2"+
		"\2\24}\3\2\2\2\26\u0085\3\2\2\2\30\u00ac\3\2\2\2\32\u00c9\3\2\2\2\34\u00fd"+
		"\3\2\2\2\36\u00ff\3\2\2\2 \u0110\3\2\2\2\"\u0112\3\2\2\2$&\7\3\2\2%\'"+
		"\5\4\3\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\5\f\7\2)*\5\"\22\2*+\7\4\2"+
		"\2+,\b\2\1\2,\3\3\2\2\2-/\5\6\4\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60"+
		"\61\3\2\2\2\61\5\3\2\2\2\62\63\5\b\5\2\63\64\7\34\2\2\64<\b\4\1\2\65:"+
		"\7\33\2\2\66\67\7 \2\2\67;\b\4\1\289\7\35\2\29;\b\4\1\2:\66\3\2\2\2:8"+
		"\3\2\2\2;=\3\2\2\2<\65\3\2\2\2<=\3\2\2\2=G\3\2\2\2>?\7\27\2\2?@\7\34\2"+
		"\2@C\b\4\1\2AB\7\33\2\2BD\t\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2E>\3\2"+
		"\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2JL\7\16\2\2KJ\3"+
		"\2\2\2KL\3\2\2\2L\7\3\2\2\2MN\7\5\2\2NT\b\5\1\2OP\7\6\2\2PT\b\5\1\2QR"+
		"\7\7\2\2RT\b\5\1\2SM\3\2\2\2SO\3\2\2\2SQ\3\2\2\2T\t\3\2\2\2UV\t\3\2\2"+
		"V\13\3\2\2\2WY\b\7\1\2XZ\5\16\b\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2"+
		"\2\2\\\r\3\2\2\2]e\5\20\t\2^e\5\22\n\2_e\5\24\13\2`e\5\26\f\2ae\5\30\r"+
		"\2be\5\6\4\2ce\5\32\16\2d]\3\2\2\2d^\3\2\2\2d_\3\2\2\2d`\3\2\2\2da\3\2"+
		"\2\2db\3\2\2\2dc\3\2\2\2e\17\3\2\2\2fg\7\b\2\2gh\7\23\2\2hi\7\34\2\2i"+
		"j\b\t\1\2jk\7\24\2\2kl\7\16\2\2lm\b\t\1\2m\21\3\2\2\2no\7\t\2\2ox\7\23"+
		"\2\2pq\7\34\2\2qy\b\n\1\2rs\7\35\2\2sy\b\n\1\2tu\5\36\20\2uv\b\n\1\2v"+
		"y\3\2\2\2wy\5\34\17\2xp\3\2\2\2xr\3\2\2\2xt\3\2\2\2xw\3\2\2\2yz\3\2\2"+
		"\2z{\7\24\2\2{|\7\16\2\2|\23\3\2\2\2}~\7\34\2\2~\177\b\13\1\2\177\u0080"+
		"\7\33\2\2\u0080\u0081\b\13\1\2\u0081\u0082\5\36\20\2\u0082\u0083\7\16"+
		"\2\2\u0083\u0084\b\13\1\2\u0084\25\3\2\2\2\u0085\u0086\7\n\2\2\u0086\u0087"+
		"\7\23\2\2\u0087\u0088\7\34\2\2\u0088\u0089\b\f\1\2\u0089\u008a\7\30\2"+
		"\2\u008a\u008b\b\f\1\2\u008b\u008c\t\4\2\2\u008c\u008d\b\f\1\2\u008d\u008e"+
		"\7\24\2\2\u008e\u008f\7\25\2\2\u008f\u0093\b\f\1\2\u0090\u0091\5\6\4\2"+
		"\u0091\u0092\b\f\1\2\u0092\u0094\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5\16\b\2\u0096\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\7\26\2\2\u009b\u00aa\b\f\1\2\u009c\u009d\7\13\2\2"+
		"\u009d\u009e\7\25\2\2\u009e\u00a0\b\f\1\2\u009f\u00a1\5\6\4\2\u00a0\u009f"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a4\5\16\b\2"+
		"\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\26\2\2\u00a8\u00a9\b\f\1\2"+
		"\u00a9\u00ab\3\2\2\2\u00aa\u009c\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\27"+
		"\3\2\2\2\u00ac\u00ad\7\f\2\2\u00ad\u00b7\7\23\2\2\u00ae\u00af\5 \21\2"+
		"\u00af\u00b0\b\r\1\2\u00b0\u00b1\7\30\2\2\u00b1\u00b2\b\r\1\2\u00b2\u00b3"+
		"\5 \21\2\u00b3\u00b4\b\r\1\2\u00b4\u00b8\3\2\2\2\u00b5\u00b6\7\32\2\2"+
		"\u00b6\u00b8\b\r\1\2\u00b7\u00ae\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\7\24\2\2\u00ba\u00bb\7\25\2\2\u00bb\u00bf\b\r\1\2"+
		"\u00bc\u00bd\5\6\4\2\u00bd\u00be\b\r\1\2\u00be\u00c0\3\2\2\2\u00bf\u00bc"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00c3\5\16\b\2"+
		"\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7\26\2\2\u00c7\u00c8\b\r\1\2"+
		"\u00c8\31\3\2\2\2\u00c9\u00ca\7\r\2\2\u00ca\u00cb\7\23\2\2\u00cb\u00cc"+
		"\5\6\4\2\u00cc\u00cd\b\16\1\2\u00cd\u00ce\7\16\2\2\u00ce\u00cf\7\34\2"+
		"\2\u00cf\u00d0\b\16\1\2\u00d0\u00d1\7\30\2\2\u00d1\u00d2\b\16\1\2\u00d2"+
		"\u00d3\5 \21\2\u00d3\u00d4\b\16\1\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7"+
		"\16\2\2\u00d6\u00d7\7\34\2\2\u00d7\u00d8\b\16\1\2\u00d8\u00d9\7\31\2\2"+
		"\u00d9\u00da\b\16\1\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\24\2\2\u00dc\u00dd"+
		"\7\25\2\2\u00dd\u00df\b\16\1\2\u00de\u00e0\5\6\4\2\u00df\u00de\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\b\16\1\2\u00e2\u00e4"+
		"\5\16\b\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2"+
		"\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7\26\2\2\u00e8\u00e9"+
		"\b\16\1\2\u00e9\33\3\2\2\2\u00ea\u00eb\7 \2\2\u00eb\u00fe\b\17\1\2\u00ec"+
		"\u00ed\7 \2\2\u00ed\u00f3\b\17\1\2\u00ee\u00ef\7\27\2\2\u00ef\u00f0\b"+
		"\17\1\2\u00f0\u00f1\5 \21\2\u00f1\u00f2\b\17\1\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00ee\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00fa\3\2\2\2\u00f5\u00f6\7\17"+
		"\2\2\u00f6\u00f7\b\17\1\2\u00f7\u00f8\5 \21\2\u00f8\u00f9\b\17\1\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u00fe\b\17\1\2\u00fd\u00ea\3\2\2\2\u00fd\u00ec\3\2\2\2\u00fe"+
		"\35\3\2\2\2\u00ff\u0100\5 \21\2\u0100\u0106\b\20\1\2\u0101\u0102\t\5\2"+
		"\2\u0102\u0103\b\20\1\2\u0103\u0104\5 \21\2\u0104\u0105\b\20\1\2\u0105"+
		"\u0107\3\2\2\2\u0106\u0101\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u0109\b\20\1\2\u0109\37\3\2\2\2\u010a\u010b\7\34\2\2\u010b"+
		"\u0111\b\21\1\2\u010c\u010d\7\35\2\2\u010d\u0111\b\21\1\2\u010e\u010f"+
		"\7 \2\2\u010f\u0111\b\21\1\2\u0110\u010a\3\2\2\2\u0110\u010c\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111!\3\2\2\2\u0112\u0113\b\22\1\2\u0113#\3\2\2\2\34&"+
		"\60:<CGKS[dx\u0093\u0098\u00a0\u00a5\u00aa\u00b7\u00bf\u00c4\u00df\u00e5"+
		"\u00f3\u00fa\u00fd\u0106\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}