grammar CaquiScript;

prog	: 'start' bloco 'end'
		;
		
bloco	: (cmd)+
		;

cmd		: cmdLeitura | cmdEscrita | cmdAttr
		;
		
cmdLeitura : 'read' AP ID FP SC
		   ;

cmdEscrita : 'write' AP ID FP SC
			;

cmdAttr	: ID ATTR expr SC
		;

expr	: termo ( OP termo )*
		;
		
termo	: ID | NUMBER
		;

AP	: '('
	;

FP	: ')'
	;

SC	: ';'
	;

OP	: '+' | '-' | '*' | '/'
	;
	
OP_REL	: '<' | '<=' | '>' | '>=' | '==' | '!='
		;

ATTR	: '='
		;
		
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

WS	: (' ' | '\t' | '\n' | '\r') -> skip
    ;