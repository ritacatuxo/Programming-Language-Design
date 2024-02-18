grammar Cmm;	

program: CHAR_CONSTANT_ASCII
       ;

// One-line comments starting with //
COMMENT: '//' .*? ('\n'| '\r' | EOF)
       ;

// Multiple-line comments starting with /* and ending with */
MULTILINE_COLUMN: '/*' .*? '*/'
                ;

fragment
LETTER: [a-zA-Z]
      ;

fragment
DIGIT: [0-9]
     ;

// Identifiers starting with a letter or _ and followed by letter, digit or _
// var1	 _var_1  VAR_1_AB_2
fragment
ID: LETTER (LETTER|DIGIT|'_')*
  | '_' (LETTER|DIGIT|'_')*
  ;

// Integer constants without sign (Only base 10)
fragment
INT_CONSTANT: [1-9][0-9]*
     | '0'
     ;


// Real constants with floating point (without sign)
// 12.3, 2., .34
REAL_CONSTANT: ('.' [0-9]+ | INT_CONSTANT '.' [0-9]*)
             ;

// Real constants with mantissa and exponent
// 34.12E-3, 3e3, .3E+3, 2.e23
MANTISSA: (INT_CONSTANT|REAL_CONSTANT) ('e'|'E') ('+'|'-')? INT_CONSTANT
        ;

// Char constants between ' and '
// 'a' '.' '~'
CHAR_CONSTANT: '\'' . '\''
             ;


// Char constants identifying the ASCII code (any integer constant without sign can be written between ' and ')
// '\126' and the two special char constants '\n' (line feed) and '\t'
CHAR_CONSTANT_ASCII: '\'' . '\''
                   | '\'' '\\' INT_CONSTANT '\''
                   | '\'\\n\''
                   | '\'\\t\''
                   ;
