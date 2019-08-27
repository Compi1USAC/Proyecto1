package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
%%
%{
    String cadena="";
    int llamadaString = 0;
    int ESTADOACTUAL = 0;

    public Symbol addSymbol(Symbol s){
        System.out.println(s.value.toString());
        return s;
    }
%}

%public
%class LexicoUFE
%cupsym Symu
%cup
%char
%line
%column
%full
%unicode
%ignorecase

digito = [0-9]
entero = {digito}+
doble = {digito}+"." {digito}+
numero = {digito}+("." {digito}+)?
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*   
caracter = "\'" [^\'] "\'"
espacio = \t|\f|" "|\r|\n


%state COMENTMULTI
%state COMENTSIMPLE
%state STRING
%state UFEX

%%

<STRING>{
    [\"] {  yybegin(ESTADOACTUAL);
            String temporal = cadena; 
            cadena = "";
            return addSymbol( new Symbol(Symu.tCadena, yychar,yyline,temporal) );   
         }
    [^\"] { cadena += yytext(); }
}

<COMENTMULTI>{
    "*/"         {yybegin(ESTADOACTUAL);}
    .            {}
    [ \t\r\n\f]  {}
}

<COMENTSIMPLE>{ 
    [^"\n"]      {}
      "\n"       {yybegin(ESTADOACTUAL);}
}

<YYINITIAL>{ 
    "/*"            { ESTADOACTUAL = YYINITIAL; yybegin(COMENTMULTI);} 
    "//"            { ESTADOACTUAL = YYINITIAL; yybegin(COMENTSIMPLE);}
    "\""            { ESTADOACTUAL = YYINITIAL; yybegin(STRING);}
    "component"     {return addSymbol(new Symbol(Symu.tComponent,yycolumn,yyline,yytext()));}
    "var"           {return addSymbol(new Symbol(Symu.tVar,yycolumn,yyline,yytext()));}
    "="             {return addSymbol(new Symbol(Symu.tIgual,yycolumn,yyline,yytext()));}
    ";"             {return addSymbol(new Symbol(Symu.tPuntoComa,yycolumn,yyline,yytext()));}
    ","             {return addSymbol(new Symbol(Symu.tComa,yycolumn,yyline,yytext()));}
    "}"             {return addSymbol(new Symbol(Symu.tLlaveC,yycolumn,yyline,yytext()));}
    "{"             {return addSymbol(new Symbol(Symu.tLlaveA,yycolumn,yyline,yytext()));}
    "("             {return addSymbol(new Symbol(Symu.tParA,yycolumn,yyline,yytext()));}
    ")"             {return addSymbol(new Symbol(Symu.tParC,yycolumn,yyline,yytext()));}
    "+"             {return addSymbol(new Symbol(Symu.tSuma,yycolumn,yyline,yytext()));}
    "-"             {return addSymbol(new Symbol(Symu.tResta,yycolumn,yyline,yytext()));}
    "*"             {return addSymbol(new Symbol(Symu.tMult,yycolumn,yyline,yytext()));}
    "/"             {return addSymbol(new Symbol(Symu.tDiv,yycolumn,yyline,yytext()));}
    "pow"           {return addSymbol(new Symbol(Symu.tPow,yycolumn,yyline,yytext()));}
    "true"          {return addSymbol(new Symbol(Symu.tTrue,yycolumn,yyline,yytext()));}
    "false"         {return addSymbol(new Symbol(Symu.tFalse,yycolumn,yyline,yytext()));}

    "return("
                    {yybegin(UFEX); return addSymbol(new Symbol(Symu.tReturn,yycolumn,yyline,yytext())); }
    "return" {espacio} "("  
                    {yybegin(UFEX); return addSymbol(new Symbol(Symu.tReturn,yycolumn,yyline,yytext())); }

    {id}            {return addSymbol(new Symbol(Symu.tId,yycolumn,yyline,yytext()));}
    {caracter}      {return addSymbol(new Symbol(Symu.tCaracter,yycolumn,yyline,yytext()));}
    {entero}        {return addSymbol(new Symbol(Symu.tEntero,yycolumn,yyline,yytext()));}
    {doble}         {return addSymbol(new Symbol(Symu.tDoble,yycolumn,yyline,yytext()));}
}

<UFEX>{
    "/*"            { ESTADOACTUAL = UFEX; yybegin(COMENTMULTI);} 
    "//"            { ESTADOACTUAL = UFEX; yybegin(COMENTSIMPLE);}
    "\""            { ESTADOACTUAL = UFEX; yybegin(STRING);}
    ")"             {yybegin(YYINITIAL);return addSymbol(new Symbol(Symu.tParC,yycolumn,yyline,yytext()));}
    ">"             {return addSymbol(new Symbol(Symu.tMayorQ,yycolumn,yyline,yytext()));}
    "<"             {return addSymbol(new Symbol(Symu.tMenorQ,yycolumn,yyline,yytext()));}
    "panel"         {return addSymbol(new Symbol(Symu.tPanel,yycolumn,yyline,yytext()));}
    "x"             {return addSymbol(new Symbol(Symu.tX,yycolumn,yyline,yytext()));}
    "y"             {return addSymbol(new Symbol(Symu.tY,yycolumn,yyline,yytext()));}
    "height"        {return addSymbol(new Symbol(Symu.tHeight,yycolumn,yyline,yytext()));}
    "width"         {return addSymbol(new Symbol(Symu.tWidth,yycolumn,yyline,yytext()));}
    "color"         {return addSymbol(new Symbol(Symu.tColor,yycolumn,yyline,yytext()));}
    "border"        {return addSymbol(new Symbol(Symu.tBorder,yycolumn,yyline,yytext()));}
    "classname"     {return addSymbol(new Symbol(Symu.tClassname,yycolumn,yyline,yytext()));}
    "id"            {return addSymbol(new Symbol(Symu.tIdEtq,yycolumn,yyline,yytext()));}
    "="             {return addSymbol(new Symbol(Symu.tIgual,yycolumn,yyline,yytext()));}
    "/"             {return addSymbol(new Symbol(Symu.tDiagonal,yycolumn,yyline,yytext()));}
    {id}            {return addSymbol(new Symbol(Symu.tId,yycolumn,yyline,yytext()));}
    {entero}        {return addSymbol(new Symbol(Symu.tEntero,yycolumn,yyline,yytext()));}
    {doble}         {return addSymbol(new Symbol(Symu.tDoble,yycolumn,yyline,yytext()));}
}

<YYINITIAL, UFEX>{
    {espacio}       { /* ignorar */ }
    .               {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}
