grammar CaquiScript;

@header{ 
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
}

@members{ 
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
	
}

prog	: 'start' declaration? bloco 'end'
		  { 
		  	program.setVarTable(symbolTable);
		  	program.setComandos(stack.pop()); 
		  }
		;

declaration	: (declvar)+
			;

declvar	: type ID {
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
			(VI 
				ID {
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
			)* SC
		;

type	: 'int' { _tipo = CaquiVariable.INT; } 
		| 'double'  { _tipo = CaquiVariable.DOUBLE; } 
		| 'string' { _tipo = CaquiVariable.STRING; } 
		;

value	: (INT | DOUBLE | STRING)
		;

bloco	: { curThread = new ArrayList<AbstractCommand>(); 
			stack.push(curThread);
		  } 
		(cmd)+
		;

cmd		: cmdLeitura  
		| cmdEscrita
		| cmdAttr 	  
		| ifStatement 
		;
		
cmdLeitura : 'read' AP 
					ID { 
							verificaID(_input.LT(-1).getText()); 
							_readID = _input.LT(-1).getText();
							System.out.println("ID -> " + _readID);
						} 
					FP 
					SC
					{
						CaquiVariable var = (CaquiVariable)symbolTable.get(_readID);
						CommandLeitura cmd = new CommandLeitura(_readID, var);
						stack.peek().add(cmd);
					}
		   ;

cmdEscrita : 'write' AP 
					(
						ID { 
							verificaID(_input.LT(-1).getText()); 
							_writeID = _input.LT(-1).getText();
						} 
						| NUMBER 
						| expr
						| STRING
					)* 
					FP SC
					{
						CommandEscrita cmd = new CommandEscrita(_writeID);
						stack.peek().add(cmd);
					}
			;

cmdAttr	: ID { verificaID(_input.LT(-1).getText()); 
			   _exprID = _input.LT(-1).getText();
			 } 
		ATTR { _exprContent = ""; } 
		expr SC
		{
			CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			stack.peek().add(cmd);
		}
		;

ifStatement	: 'if' AP 
				   ID { _exprDecision = _input.LT(-1).getText(); } 
				   OPREL { _exprDecision += _input.LT(-1).getText(); }
				   (ID | NUMBER) { _exprDecision += _input.LT(-1).getText(); }
				   FP 
				   AC 
				   { 
				   	curThread = new ArrayList<AbstractCommand>(); 
				   	stack.push(curThread);	
				   }
				   (declvar)?
				   (cmd)+ 
				   FC 	
				   {
				   	listaTrue = stack.pop();
				   }
				   ('else' 
				   		
				   		AC
				   		{
				   			curThread = new ArrayList<AbstractCommand>(); 
				   			stack.push(curThread);
				   		}
						(declvar)?
				   		(cmd)+ 
				   		FC
				   		{
							listaFalse = stack.pop();
							CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
							stack.peek().add(cmd);
						}
				   	)?
			;

expr	: termo ( OP { 
						_exprContent += _input.LT(-1).getText(); 
					 } 
				  termo 
				 )*
		;
		
termo	: ID { verificaID(_input.LT(-1).getText()); 
			 	_exprContent += _input.LT(-1).getText();
			 } 
		| NUMBER { _exprContent += _input.LT(-1).getText(); }
		;

AP	: '('
	;

FP	: ')'
	;

SC	: ';'
	;

AC	: '{'
	;
	
FC	: '}'
	;

OP	: '+' | '-' | '*' | '/'
	;

VI	: ','
	;
	
OPREL	: '<' | '<=' | '>' | '>=' | '==' | '!='
		;

ATTR	: '='
		;
		
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

INT: [0-9]+;

DOUBLE: [0-9]+'.'[0-9]+;

STRING: '"' ~["]* '"';

WS	: (' ' | '\t' | '\n' | '\r') -> skip
    ;