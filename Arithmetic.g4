grammar Arithmetic;

prog : expression EOF;

expression
    : primary
    | expression MUL expression
    | expression DIV expression
    | expression ADD expression
    | expression SUB expression
    ;


primary
    : INT
    | LPAREN expression RPAREN
    ;


ADD      : '+';
SUB      : '-';
MUL      : '*';
DIV      : '/';
LPAREN   : '(';
RPAREN   : ')';

INT      : [0-9]+;

WS       : [ \t\r\n]+ -> skip;