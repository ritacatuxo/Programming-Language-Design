grammar Cmm;

@header {
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
}


/************* PROGRAM ****************/


program returns [Program ast = new Program(0, 0)]: // program starts in the first line and column
        (d=definitions {$ast.setDefinitions($d.ast);})*
        mf=mainFunction {$ast.addDefinition($mf.ast);} EOF
       ;

// body of the program
definitions returns [List<Definition> ast = new ArrayList<Definition>()]:
            vd=varDefinition {$ast.addAll($vd.ast);}
            |fd=functionDefinition {$ast.add($fd.ast);}
           ;


mainFunction returns [FuncDefinition ast]:
            'void' main='main' '(' ')'

            '{'
                vd=varDefinitions st=statements
            '}'

            // ast --
                {$ast = new FuncDefinition($main.getLine(), $main.getCharPositionInLine()+1,
                    new FunctionType($main.getLine(), $main.getCharPositionInLine()+1, new ArrayList<>(), new VoidType($main.getLine(), $main.getCharPositionInLine()+1)),
                        $main.text, $vd.ast, $st.ast);}
            ;



/************* EXPRESSIONS ****************/

expression returns [Expression ast]:

          e1=expression '[' e2=expression ']' // Indexing
                                  {$ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast);} // Indexing
          | e1=expression '.' ID
                                  {$ast = new FieldAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $ID.text);} // FieldAccess (ID is the field)
          | '(' pt=primitive_type ')' e1=expression {$ast = new Cast($e1.ast.getLine(), $e1.ast.getColumn(), $pt.ast, $e1.ast);} // Cast
          | '-' e1=expression      {$ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);} // UnaryMinus
          | '!' e1=expression      {$ast = new UnaryNot($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);}   // Arithmetic
          | e1=expression OP=('*'|'/'|'%') e2=expression
                        {$ast = Arithmetic.arithmeticFactory($OP.text, $e1.ast, $e2.ast);} // % has its own type but the same precedence as the other arithmetics ops * /
          | e1=expression OP=('+'|'-') e2=expression
                        {$ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} // Arithmetic
          | e1=expression OP=('>'|'<'|'>='|'<='|'!='|'==') e2=expression
                        {$ast = new Comparison($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} // Comparison
          | e1=expression OP=('&&'|'||') e2=expression
                        {$ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast);} //logical
          | fi=function_invocation {$ast = $fi.ast;} //  function invocation as expression
          | ID               {$ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }   // Variable
          | IC=INT_CONSTANT  {$ast = new IntLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text)); } //  Intliteral
          | CC=CHAR_CONSTANT {$ast = new CharLiteral($CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text)); } // CharLiteral
          | RC=REAL_CONSTANT {$ast = new DoubleLiteral($RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text)); } // DoubleLiteral
          | '(' e1=expression ')'
                             {$ast = $e1.ast;}
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
            (',' e2=expression {$ast.add(new Read($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast));})*';' // Read
         | 'write' e1=expression {$ast.add(new Write($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast));}
            (',' e2=expression {$ast.add(new Write($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast));})*';'// Write
         | e1=expression '=' e2=expression {$ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast));} ';' // Assignment
         | fi=function_invocation {$ast.add($fi.ast);} ';' // function invocation as statement
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
    pm=primitive_type {$ast = $pm.ast;}
    | t1=type '['IC=INT_CONSTANT']'
              { $ast = ArrayType.createArray(Integer.parseInt($IC.text), $t1.ast); }

    | s=struct {$ast = $s.ast;}
    ;


primitive_type returns [Type ast]:
                i='int' {$ast = new IntType($i.getLine(), $i.getCharPositionInLine()+1);}
              | d='double' {$ast = new DoubleType($d.getLine(), $d.getCharPositionInLine()+1);}
              | c='char' {$ast = new CharType($c.getLine(), $c.getCharPositionInLine()+1);}
              ;


struct returns [RecordType ast]:
      st='struct' {$ast = new RecordType($st.getLine(), $st.getCharPositionInLine()+1);}
      '{' (fd=fieldDefinition {((RecordType) $ast).addRecordFields($fd.ast);})+ '}'
      ;

fieldDefinition returns[List<RecordField> ast = new ArrayList<RecordField>()]:
             t1=type ID {$ast.add(new RecordField($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text));}
             (',' ID {$ast.add(new RecordField($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text));} )* ';'
             ;


/************* DEFINITION ****************/

varDefinition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
             t1=type ID {$ast.add(new VarDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text));}
             (',' ID {$ast.add(new VarDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $ID.text));} )* ';'
             ;


functionDefinition returns [FuncDefinition ast]:
                  rt=returnType ID '(' p=parameters ')'
                  '{' vd=varDefinitions st=statements '}'
                        {$ast = new FuncDefinition($ID.getLine(), $ID.getCharPositionInLine()+1,
                            new FunctionType($ID.getLine(), $ID.getCharPositionInLine()+1, $p.ast, $rt.ast), $ID.text, $vd.ast, $st.ast);}
                  ;

returnType returns [Type ast]:
          pt=primitive_type {$ast = $pt.ast;}
          | v='void' {$ast = new VoidType($v.getLine(), $v.getCharPositionInLine()+1);}
          ;



// parameters of the function
parameters returns [List<VarDefinition> ast = new ArrayList<>()]:
          pt1=primitive_type id=ID {$ast.add( new VarDefinition($pt1.ast.getLine(), $pt1.ast.getColumn(), $pt1.ast, $id.text));}
          (',' pt2=primitive_type id2=ID {$ast.add( new VarDefinition($pt2.ast.getLine(), $pt2.ast.getColumn(), $pt2.ast, $id2.text));} )*
          | // epsilon in case there are no parameters
          ;


// -- body of the function
varDefinitions returns[List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
              (vd=varDefinition {$ast.addAll($vd.ast);} )*
              ;
statements returns[List<Statement> ast = new ArrayList<Statement>()]:
              (st=statement {$ast.addAll($st.ast);} )*
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
