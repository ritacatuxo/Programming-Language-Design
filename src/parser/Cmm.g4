grammar Cmm;



/************* EXPRESSIONS ****************/

expression: '(' type ')' expression // Cast
          | '-' expression // UnaryMinus
          | '!' expression // Arithmetic
          | expression ('*'|'/'|'%') expression // Arithmetic
          | expression ('+'|'-') expression // Arithmetic
          | expression ('>'|'<'|'>='|'<='|'!='|'==') expression // Comparison
          | expression ('&&'|'||') expression //logical
          | expression '.' ID  // FieldAccess (ID is the field)
          | expression '[' expression ']' // Indexing
          | function_invocation
          | ID // Variable
          | INT_CONSTANT //  Intliteral
          | CHAR_CONSTANT // CharLiteral
          | REAL_CONSTANT // DoubleLiteral
          ;

function_invocation: ID '(' (expression | expression (',' expression)*)? ')'// FunctionInvocation
;




/************* STATEMENTS ****************/

statement: 'while' '(' expression ')' block // While
         | 'if' '(' expression ')' block ('else' block)? // IfElse
         | 'read' expression ';' // Read
         | 'write' expression (',' expression)*';'// Write
         | expression '=' expression ';'// Assignment
         | function_invocation ';'
         | 'return' expression ';' // Return
         ;

block: statement
     | '{' statement* '}'
     ;





/************* TYPES ****************/

type:
    | 'int'
    | 'double'
    | 'char'
    | 'void'
    | type '['INT_CONSTANT']' ('['INT_CONSTANT']')* ID ';'// Array
    | 'struct' '{' (type ID ';') (type ID ';')*  '}' ID ';'
    ;




/************* DEFINITION ****************/

varDefinition: type ID (',' ID)* ';'
             ;



// deberia sacar lo de los params a otro?
functionDefinition: type ID '(' (type ID | type ID (',' type ID)*)? ')' '{' varDefinition* statement*'}'
                  ;


/************* PROGRAM ****************/

program: (varDefinition|functionDefinition)*
       ;





/************* LEXER ****************/



fragment
LETTER: [a-zA-Z]
      ;

fragment
DIGIT: [0-9]
     ;

// Identifiers starting with a letter or _ and followed by letter, digit or _
// var1	 _var_1  VAR_1_AB_2
ID: LETTER (LETTER|DIGIT|'_')*
  | '_' (LETTER|DIGIT|'_')*
  ;

// Integer constants without sign (Only base 10)
INT_CONSTANT: [1-9][0-9]*
     |'0'
     ;


// Real constants with floating point (without sign)
// 12.3, 2., .34
fragment
FLOAT: ('.' [0-9]+ | INT_CONSTANT '.' [0-9]*)
             ;

// Real constants with mantissa and exponent
// 34.12E-3, 3e3, .3E+3, 2.e23
fragment
MANTISSA: (INT_CONSTANT|FLOAT) ('e'|'E') ('+'|'-')? INT_CONSTANT
        ;

REAL_CONSTANT: FLOAT
             | MANTISSA
             ;



// Char constants between ' and '
// 'a' '.' '~'
//CHAR_CONSTANT: '\'' . '\''
//             ;


// Char constants identifying the ASCII code (any integer constant without sign can be written between ' and ')
// '\126' and the two special char constants '\n' (line feed) and '\t'
CHAR_CONSTANT: '\'' . '\''
                   |'\'' '\\' INT_CONSTANT '\''
                   |'\'\\n\''
                   |'\'\\t\''
                   ;



// One-line comments starting with //
COMMENT: '//' .*? ('\n'| '\r' | EOF) -> skip
       ;

// Multiple-line comments starting with /* and ending with */
MULTILINE_COLUMN: '/*' .*? '*/' -> skip
                ;

//white spaces
WS: [ \t\n\r]+ -> skip ;
