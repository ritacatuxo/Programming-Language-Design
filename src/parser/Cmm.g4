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

// Identifiers starting with a letter or _ and followed by letter, digit or _
fragment
ID: (LETTER|'_')+
  | (LETTER|'_')+
  ;

// Integer constants without sign (Only base 10)
fragment
INT_CONSTANT: [1-9][0-9]*
     | '0'
     ;


// 12.3, 2., .34
REAL_CONSTANT: ('.' [0-9]+ | INT_CONSTANT '.' [0-9]*)
             ;

// 34.12E-3, 3e3, .3E+3, 2.e23
MANTISSA: (INT_CONSTANT|REAL_CONSTANT) ('e'|'E') ('+'|'-')? INT_CONSTANT
        ;

// 'a' '.' '~'
//CHAR_CONSTANT: '\'' . '\''
//             ;


//Char constants identifying the ASCII code, e.g. '\126' (any integer constant without sign can be written between ' and ')
// The two special char constants '\n' (line feed) and '\t'
CHAR_CONSTANT_ASCII: '\'' . '\''
                   | '\'' '\\' INT_CONSTANT '\''
                   | '\'\\n\''
                   | '\'\\t\''
                   ;
