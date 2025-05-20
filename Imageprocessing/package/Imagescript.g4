grammar Imagescript;

script: command* EOF;

command:
      loadCmd
    | resizeCmd
    | grayscaleCmd
    | rotateCmd
    | flipCmd
    | saveCmd
    ;

loadCmd         : 'LOAD' filePath=STRING_LITERAL 'AS' varName=ID SEMI?;
resizeCmd       : 'RESIZE' inputVar=ID 'WIDTH' width=NUMBER 'HEIGHT' height=NUMBER 'AS' outputVar=ID SEMI?;
grayscaleCmd    : 'GRAYSCALE' inputVar=ID 'AS' outputVar=ID SEMI?;
rotateCmd       : 'ROTATE' inputVar=ID 'ANGLE' angle=NUMBER 'AS' outputVar=ID SEMI?;
flipCmd         : 'FLIP' inputVar=ID (direction='HORIZONTAL' | direction='VERTICAL' | direction='BOTH') 'AS' outputVar=ID SEMI?;
saveCmd         : 'SAVE' varName=ID 'TO' filePath=STRING_LITERAL 'FORMAT' formatName=STRING_LITERAL SEMI?;

// Lexer Rules
ID              : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMBER          : [0-9]+ ('.' [0-9]+)? ;
STRING_LITERAL  : '"' ( ~["\r\n] | '""' )*? '"' ;

SEMI            : ';' ;

LOAD            : 'LOAD';
AS              : 'AS';
RESIZE          : 'RESIZE';
WIDTH           : 'WIDTH';
HEIGHT          : 'HEIGHT';
GRAYSCALE       : 'GRAYSCALE';
ROTATE          : 'ROTATE';
ANGLE           : 'ANGLE';
FLIP            : 'FLIP';
HORIZONTAL      : 'HORIZONTAL';
VERTICAL        : 'VERTICAL';
BOTH            : 'BOTH';
SAVE            : 'SAVE';
TO              : 'TO';
FORMAT          : 'FORMAT';

WS              : [ \t\r\n]+ -> skip ;
COMMENT         : '//' .*? '\r'? '\n' -> skip ;