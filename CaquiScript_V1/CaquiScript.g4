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
	import br.com.caquiscript.ast.CommandWhile;
	import br.com.caquiscript.ast.CommandDeclVar;
	import br.com.caquiscript.ast.CommandFor;
	
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashSet;
	import java.util.Set;
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
	
}


prog	: 'start' declaration? bloco checkVars 'end'
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
							setDeclVarName(_varName);
							setDeclVarType(_tipo);
							
							//Adiciona variável para varíaveis declaradas
            				declaredVariables.add(getDeclVarName());
							System.out.println("Declaração Adicionada -> " + getDeclVarType() + " " + getDeclVarName());
		
						}
						else {
							throw new CaquiSemanticException("Symbol  " + _varName + "  already declared");
						}
					}
			(ATTR ( STRING 
					{
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
					| NUMBER
							{
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
								
			))?
			(VI 
				ID {
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
				} 
			(ATTR (STRING | NUMBER))?
			)* (SC)?
		;

type	: 'int' { _tipo = CaquiVariable.INT; } 
		| 'double'  { _tipo = CaquiVariable.DOUBLE; } 
		| 'string' { _tipo = CaquiVariable.STRING; } 
		;

value	: (INT | DOUBLE | STRING)
		;

bloco	: { 
			curThread = new ArrayList<AbstractCommand>(); 
			stack.push(curThread);
		  } 
		(cmd)+
		;

cmd		: cmdLeitura  
		| cmdEscrita
		| cmdAttr 	  
		| ifStatement
		| whileLoop 
		| declvar
		| forLoop
		;
		
cmdLeitura : 'read' AP 
					ID 
					{ 
						verificaID(_input.LT(-1).getText()); 
						_readID = _input.LT(-1).getText();
						System.out.println("ID -> " + _readID);
						
						//Add variavel no usedVariables		
						usedVariables.add(_input.LT(-1).getText());
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
			  	ID 
				  	{ 
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
			  	| NUMBER
			  	{
			  		_writeID = _input.LT(-1).getText();
					CommandEscrita cmd = new CommandEscrita(_writeID);
				  	System.out.println("writeln -> _writeID = " + _writeID);
					stack.peek().add(cmd);
			  	}
			  	| expr
				{
					System.out.println("write -> exprString = " + _exprString);
					CommandEscrita cmd = new CommandEscrita(_exprString);
					stack.peek().add(cmd);
				}
			  	| outputArgs
			) FP SC
			;


cmdAttr	:
		ID { verificaID(_input.LT(-1).getText()); 
			   _exprID = _input.LT(-1).getText();
			   
			   //Add variavel no usedVariables
			   usedVariables.add(_input.LT(-1).getText());
			   
			   //Add variavel no referencedVariables	
			   referencedVariables.add(_input.LT(-1).getText());
			   System.out.println("Variável " + _input.LT(-1).getText() + " referenciada");
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
				   (declvar
					   	{
				  			System.out.println("if -> Declaração = " + getDeclVarType() + " " + getDeclVarName());
				  			CommandDeclVar dclvar = new CommandDeclVar(getDeclVarType(), getDeclVarName());
				  			stack.peek().add(dclvar);
				  		}
				   )?
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
			
whileLoop	: 'while' AP 
						( termo 
						  { 
						  	System.out.println("while -> termo_1 = " + _input.LT(-1).getText()); 
						  	_exprDecision = _input.LT(-1).getText();
						  } 
						  OPREL
						  { 
						  	System.out.println("while -> OPREL = " + _input.LT(-1).getText()); 
						  	_exprDecision += _input.LT(-1).getText();
						  }  
						  termo
						  { 
						  	System.out.println("while -> termo_2 = " + _input.LT(-1).getText()); 
						  	_exprDecision += _input.LT(-1).getText();
						  }
						  | TRUE
						  { 
						  	System.out.println("while -> TRUE = " + _input.LT(-1).getText()); 
						  	_exprDecision += _input.LT(-1).getText();
						  }
						  ) 
					  FP 
					  AC
					  	{ 
						   	curThread = new ArrayList<AbstractCommand>(); 
						   	stack.push(curThread);	
				   		}
					  	(declvar
					  		{
					  			System.out.println("while -> Declaração = " + getDeclVarType() + " " + getDeclVarName());
					  			CommandDeclVar dclvar = new CommandDeclVar(getDeclVarType(), getDeclVarName());
					  			stack.peek().add(dclvar);
					  		}
					  	)?
					  	(cmd)+
					  FC
					  {
				   		commandsWhile = stack.pop();
				   		System.out.println("while -> condition = " + _writeString); 
				   		CommandWhile cmd = new CommandWhile(_exprDecision, commandsWhile);
						stack.peek().add(cmd);
				   	  }
			;
			
forLoop	: 'for' 
		  AP 
		  	(declvar) 
		  	{
		  		System.out.println("for -> Declaração = " + getDeclVarType() + " " + getDeclVarName() + " = " + getDeclVarValue());
	  			_forInitialVar = getDeclVarType() + " " + getDeclVarName() + " = " + getDeclVarValue();
		  	}
		  	SC 
		  	(ID 
		  	{
		  		_exprDecision = _input.LT(-1).getText();
		  	}
		  	OPREL
		  	{
		  		System.out.println("for -> OP_REL = " + _input.LT(-1).getText());
		  		_exprDecision += _input.LT(-1).getText();
		  	} 
		  	termo
		  	{
		  		System.out.println("for -> Termo_2 = " + _input.LT(-1).getText());
		  		_exprDecision += _input.LT(-1).getText();
		  	}) SC 
		  	(ID 
		  	{
		  		_forIncrement = _input.LT(-1).getText();
		  	}
		  	OPINC
		  	{
		  		System.out.println("for -> OP_INCR = " + _input.LT(-1).getText());
		  		_forIncrement += _input.LT(-1).getText();
		  	}) 
		  FP 
		  AC 
		  	{ 
			   	curThread = new ArrayList<AbstractCommand>(); 
			   	stack.push(curThread);	
		   	}
		  	(declvar)?
		  	{
				//System.out.println("for -> Declaração = " + getDeclVarType() + " " + getDeclVarName());
				//CommandDeclVar dclvar = new CommandDeclVar(getDeclVarType(), getDeclVarName());
				//stack.peek().add(dclvar);
			}
		  	(cmd)+ 
		  FC
		  {
		   	commandsFor = stack.pop();
		   	CommandFor cmd = new CommandFor(_forInitialVar, _exprDecision, _forIncrement, commandsFor);
			stack.peek().add(cmd);
		  }
		;

outputArgs	: STRING 
			  {
			  	_writeString = _input.LT(-1).getText();
			  	System.out.println("_writeString = " + _writeString);
			  	CommandEscrita cmd = new CommandEscrita(_writeString);
				stack.peek().add(cmd);
			  }
			  | STRING
			  {
			  	_writeString = _input.LT(-1).getText();
			  	System.out.println("_writeString = " + _writeString);
			  } 
			  ( VI 
			  {
			  	_writeString += ", ";
			  	System.out.println("_writeString = " + _writeString);
			  } 
			  termo
			  {
			  	System.out.println("writeln -> termo = " + _input.LT(-1).getText());
			  	_writeString += _input.LT(-1).getText();
			  }
			  )?
			  ( '+' 
			  {
			  	_writeString += " + ";
			  	System.out.println("_writeString = " + _writeString);
			  } 
			  termo
			  {
			  	System.out.println("writeln -> termo = " + _input.LT(-1).getText());
			  	_writeString += _input.LT(-1).getText();
			  }
			  )?
			  
			  {
			  	System.out.println("writeln -> _writeString final = " + _writeString);
			  	CommandEscrita cmd = new CommandEscrita(_writeString);
				stack.peek().add(cmd);
			  }
			;

expr	: termo
		  {
		  	_writeString = _input.LT(-1).getText();
		  	System.out.println("expr -> termo_1 -> _writeString = " + _writeString);
		  	
		  	//Add variavel no usedVariables		
			usedVariables.add(_input.LT(-1).getText());
		  }
		 ( 
		 (SUM | SUB | MULT | DIV)
			 { 
			 	_writeString += _input.LT(-1).getText(); 
			 	System.out.println("expr -> termo_2 -> OP -> _writeString = " + _writeString);
			 	_exprContent += _input.LT(-1).getText(); 
			 } 
     	 termo
	     	 {
	     	 	_writeString += _input.LT(-1).getText();
	     	 	System.out.println("expr -> termo_3 -> _writeString = " + _writeString);
	     	 	
	     	 	//Add variavel no usedVariables		
				usedVariables.add(_input.LT(-1).getText());
	     	 }
     	 )?
     	 { setExprString(_writeString); }
		;
		
termo	: 	ID 
				{ 
					verificaID(_input.LT(-1).getText()); 
					_exprContent += _input.LT(-1).getText();

					// Em qualquer referência a uma variável, adicione-a ao conjunto de variáveis usadas
					//usedVariables.add(_input.LT(-1).getText());
			 	} 
			| NUMBER { _exprContent += _input.LT(-1).getText(); }
			| STRING { _exprContent += _input.LT(-1).getText(); }
		;
/*		
factor	: ID { verificaID(_input.LT(-1).getText()); 
			 	_exprContent += _input.LT(-1).getText();
			 } 
		| NUMBER { _exprContent += _input.LT(-1).getText(); }
		| STRING { _exprContent += _input.LT(-1).getText(); }
		;
*/

checkVars	: 
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
			;

SC	: ';'
	;


SUM: '+';
SUB: '-';
MULT: '*';
DIV: '/';

AP	: '('
	;

FP	: ')'
	;

AC	: '{'
	;
	
FC	: '}'
	;

VI	: ','
	;
	
OPREL	: '<' | '<=' | '>' | '>=' | '==' | '!='
		;
		
OPINC	: '++' | '--';		
		
TRUE	: 'true'
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