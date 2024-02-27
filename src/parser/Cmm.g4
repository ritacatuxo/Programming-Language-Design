grammar Cmm;

@header {
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
}


/************* PROGRAM ****************/

program returns [Program ast]:
        (varDefinition|functionDefinition)* mainFunction EOF
       ;

mainFunction: 'void' 'main' '(' parameters ')' '{' varDefinition* statement* '}'
            ;


/************* EXPRESSIONS ****************/

expression returns [Expression ast]:
          '(' pt=primitive_type ')' e1=expression {$ast = new Cast($e1.ast.getLine(), $e1.ast.getColumn(), $pt.ast, $e1.ast);} // Cast
          | '-' e1=expression      {$ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);} // UnaryMinus
          | '!' e1=expression      {$ast = new Negation($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);}   // Arithmetic
          | e1=expression OP=('*'|'/'|'%') e2=expression
                        {$ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} // Arithmetic
          | e1=expression OP=('+'|'-') e2=expression
                        {$ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} // Arithmetic
          | e1=expression OP=('>'|'<'|'>='|'<='|'!='|'==') e2=expression
                        {$ast = new Comparison($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} // Comparison
          | e1=expression OP=('&&'|'||') e2=expression
                        {$ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} //logical
          | e1=expression '.' ID
                        {$ast = new FieldAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $ID.text);} // FieldAccess (ID is the field)
          | expression '[' expression ']' // Indexing
                        {$ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast);} // Indexing
          | function_invocation
          | ID               {$ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }   // Variable
          | IC=INT_CONSTANT  {$ast = new IntLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text)); } //  Intliteral
          | CC=CHAR_CONSTANT {$ast = new CharLiteral($CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text)); } // CharLiteral
          | RC=REAL_CONSTANT {$ast = new DoubleLiteral($RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text)); } // DoubleLiteral
          ;

function_invocation returns [FunctionInvocation ast]:
        ID '(' fip=funcInvParameters ')'
            {$ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, $fip.ast, $ID.text);} // FunctionInvocation
;

funcInvParameters returns [List<Statement> ast = new ArrayList<Statement>()]:
                 e2=expression {$ast.add($e2.ast);}
                 (',' e3=expression {$ast.add($e3.ast);} )*
                 | // epsilon so that in case there are no parameters, the list is empty
                 ;


/************* STATEMENTS ****************/

statement returns [Statement ast]:
           'while' '(' e1=expression ')' b1=block // While
                        {$ast = new While($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast);}
         | 'if' '(' expression ')' block ('else' block)? // IfElse

         | 'read' expression (',' expression)*';' // Read
         | 'write' expression (',' expression)*';'// Write
         | expression '=' expression ';'// Assignment
         | function_invocation ';'
         | 'return' expression ';' // Return
         ;

block: statement
     | '{' statement* '}'
     ;



/************* TYPES ****************/

type: primitive_type
    | type '['INT_CONSTANT']' // recursive array
    | struct
    ;


primitive_type: 'int'
              | 'double'
              | 'char'
              ;


struct: 'struct' '{' fieldDefinition+  '}'
      ;

fieldDefinition: type ID (',' ID)* ';'
             ;


/************* DEFINITION ****************/

varDefinition: type ID (',' ID)* ';'
             ;


functionDefinition: ('void'|primitive_type) ID '(' parameters ')' '{' varDefinition* statement*'}'
                  ;
parameters: (primitive_type ID | primitive_type ID (',' primitive_type ID)*)?
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
