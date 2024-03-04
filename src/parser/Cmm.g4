grammar Cmm;

@header {
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
}


/************* PROGRAM ****************/

program returns [Program ast] locals [List<Definition> defs]:

        (vd=varDefinition {$defs.add($vd.ast);} | fd=functionDefinition  {$defs.add($fd.ast);} )*
        mf=mainFunction {$defs.add($mf.ast);} EOF
            {$ast = new Program(0, 0, $defs);} // program starts always in the first line and column -> nadie usa este line and column asique es igual
       ;


mainFunction returns [FuncDefinition ast]
             locals [List<VarDefinition> varDefs, List<Statement> statements]:
            'void' main='main' '(' p=parameters ')'

            // body --
            '{' (vd=varDefinition {$varDefs.add($vd.ast); } )* // creo l alista y lg voy añadiendo
                (s=statement { $statements.addAll($s.ast); } )* '}'

            // ast --
                {$ast = new FuncDefinition($main.getLine(), $main.getCharPositionInLine()+1,
                    new FunctionType($main.getLine(), $main.getCharPositionInLine()+1, $p.ast, new VoidType($main.getLine(), $main.getCharPositionInLine()+1)),
                        $main.text, $varDefs, $statements);}

            ;





/************* EXPRESSIONS ****************/

expression returns [Expression ast]:
          '(' pt=primitive_type ')' e1=expression {$ast = new Cast($e1.ast.getLine(), $e1.ast.getColumn(), $pt.ast, $e1.ast);} // Cast
          | '-' e1=expression      {$ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);} // UnaryMinus
          | '!' e1=expression      {$ast = new Negation($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);}   // Arithmetic
          | e1=expression OP=('*'|'/'|'%') e2=expression
                        {$ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} // Arithmetic
                        // antiguo -> //{$ast = new Arithmetic.arithmeticFactory($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast)}

          // % has its own type -> necesitas otra clase para remainder (modulus)
          // no puedes seàrarñp bc tiene la misma precedemce que los otros * /
          // es lo mismo  que en aray tpe -> el conrsuctor no va
          // solucion: crete an algoih (factory method)
          // usa factory y no el contrucor

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
              {$ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, $fip.ast, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.getText()));}
        ;

funcInvParameters returns [List<Expression> ast = new ArrayList<Expression>()]:
                 e2=expression {$ast.add($e2.ast);}
                 (',' e3=expression {$ast.add($e3.ast);} )*
                 | // epsilon so that in case there are no parameters, the list is empty
                 ;


/************* STATEMENTS ****************/

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
           'while' '(' e1=expression ')' b1=block // While
                        {$ast.add(new While($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast));}
         | 'if' '(' e1=expression ')' b1=block eb=elseBody
                        {$ast.add(new IfElse($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast, $eb.ast));}
         | 'read' e1=expression {$ast.add(new Read($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast));}
            (',' e2=expression {$ast.add(new Read($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast));} )*';' // Read
         | 'write' e1=expression {$ast.add(new Read($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast));}
            (',' e2=expression {$ast.add(new Read($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast));})*';'// Write
         | e1=expression '=' e2=expression {$ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast));} ';' // Assignment
         | function_invocation ';'
         | 'return' e1=expression {$ast.add(new Return($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast));}';' // Return
         ;

elseBody returns[List<Statement> ast = new ArrayList<Statement>()]:
        'else' b1=block {$ast = $b1.ast;}
        | // epsilon
        ;

block returns [List<Statement> ast = new ArrayList<Statement>()]:
     s1=statement {$ast = $s1.ast;}
     | '{' (s1=statement {$ast.addAll($s1.ast);})* '}'
     ;






/************* TYPES ****************/

type returns [Type ast]:
    primitive_type
    | t1=type '['IC=INT_CONSTANT']'
            //{ $ast = ArrayType.buildArray(Integer.parseInt(IC.text), $t1.ast); }
              {$ast = new ArrayType($t1.ast.getLine(), $t1.ast.getColumn(), LexerHelper.lexemeToInt($IC.text), $t1.ast);}// recursive array

    | struct
    ;




primitive_type returns [Type ast]:
              i='int' {$ast = new IntType($i.getLine(), $i.getCharPositionInLine()+1);} // do I need to pass line and column?
              | d='double' {$ast = new DoubleType($d.getLine(), $d.getCharPositionInLine()+1);}
              | c='char' {$ast = new CharType($c.getLine(), $c.getCharPositionInLine()+1);}
              ;


struct returns [RecordType ast]:
      st='struct' '{' fd=fieldDefinition+  '}' {$ast = new RecordType( $st.getLine(), $st.getCharPositionInLine()+1, $fd.ast);} // NOT FINISHED
      ;

fieldDefinition returns[List<RecordField> ast = new ArrayList<RecordField>()]:
             t1=type ID {$ast.add(new RecordField($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text));}
             (',' ID {$ast.add(new RecordField($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text));} )* ';'
             ;


/************* DEFINITION ****************/

varDefinition returns [VarDefinition ast]:
             t1=type ID {$ast = new VarDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text);}
             (',' ID {$ast = new VarDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text);} )* ';'
             ;


functionDefinition returns [FuncDefinition ast] locals [List<Statement> statements, List<VarDefinition> varDefs]:
                  ('void'|pt=primitive_type) ID '(' p=parameters ')'
                  '{' (vd=varDefinition {$varDefs.add($vd.ast); } )*
                      (s=statement { $statements.addAll($s.ast); } )* '}'
                        {$ast = new FuncDefinition($ID.getLine(), $ID.getCharPositionInLine()+1,
                            new FunctionType($ID.getLine(), $ID.getCharPositionInLine()+1, $p.ast, $pt.ast), $ID.text, $varDefs, $statements);}
                  ;
parameters returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
          pt1=primitive_type ID {$ast.add( new VarDefinition($pt1.ast.getLine(), $pt1.ast.getColumn(), $pt1.ast, $ID.text));}
          (',' pt2=primitive_type ID {$ast.add( new VarDefinition($pt2.ast.getLine(), $pt2.ast.getColumn(), $pt2.ast, $ID.text));} )*
          | // epsilon in case there are no parameters
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
