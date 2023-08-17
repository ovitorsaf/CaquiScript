grammar ConditionalGrammar;

program: statement*;

statement: ifStatement | otherStatement;

ifStatement: 'if' '(' expression ')' block ('else' block)?;

otherStatement: ID '=' expression ';';

block: '{' statement* '}';

expression: ID | INT | '(' expression ')' | expression op expression;

op: '+' | '-' | '*' | '/';

ID: [a-zA-Z]+;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;




program: declaration*;

declaration: type ID '=' value ';';

type: 'int' | 'double' | 'string';

value: INT | DOUBLE | STRING;

ID: [a-zA-Z]+;
INT: [0-9]+;
DOUBLE: [0-9]+'.'[0-9]+;
STRING: '"' ~["]* '"';

WS: [ \t\r\n]+ -> skip;
