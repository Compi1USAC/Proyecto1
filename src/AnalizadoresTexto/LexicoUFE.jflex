package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
%%
%{
    String cadena="";
    int llamadaString = 0;
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
%state HTML
%state STRINGHTML

%%

<STRING>{
    [\"] {  yybegin(YYINITIAL);
            yybegin(HTML);
            String temporal = cadena; 
            cadena = "";
            return new Symbol(Symu.tCadena, yychar,yyline,temporal);   
         }
    [^\"] { cadena += yytext(); }
}

<STRINGHTML>{
    [\"] {  yybegin(HTML);
            String temporal = cadena; 
            cadena = "";
            return new Symbol(Symu.tCadena, yychar,yyline,temporal);   
         }
    [^\"] { cadena += yytext(); }
}

<COMENTMULTI>{
    "*/"         {yybegin(YYINITIAL);}
    .            {}
    [ \t\r\n\f]  {}
}

<COMENTSIMPLE>{ 
    [^"\n"]      {}
      "\n"       {yybegin(YYINITIAL);}
}

<YYINITIAL>{ 
    "/*"            {yybegin(COMENTMULTI);} 
    "//"            {yybegin(COMENTSIMPLE);}  
    "\""            { yybegin(STRING);}
    "component"     {return new Symbol(Symu.tComponent,yycolumn,yyline,yytext());}
    "var"           {return new Symbol(Symu.tVar,yycolumn,yyline,yytext());}
    "="             {return new Symbol(Symu.tIgual,yycolumn,yyline,yytext());}
    ";"             {return new Symbol(Symu.tPuntoComa,yycolumn,yyline,yytext());}
    ","             {return new Symbol(Symu.tComa,yycolumn,yyline,yytext());}
    "}"             {return new Symbol(Symu.tLlaveC,yycolumn,yyline,yytext());}
    "{"             {return new Symbol(Symu.tLlaveA,yycolumn,yyline,yytext());}
    "("             {return new Symbol(Symu.tParA,yycolumn,yyline,yytext());}
    ")"             {return new Symbol(Symu.tParC,yycolumn,yyline,yytext());}
    "+"             {return new Symbol(Symu.tSuma,yycolumn,yyline,yytext());}
    "-"             {return new Symbol(Symu.tResta,yycolumn,yyline,yytext());}
    "*"             {return new Symbol(Symu.tMult,yycolumn,yyline,yytext());}
    "/"             {return new Symbol(Symu.tDiv,yycolumn,yyline,yytext());}
    "pow"           {return new Symbol(Symu.tPow,yycolumn,yyline,yytext());}
    "true"          {return new Symbol(Symu.tTrue,yycolumn,yyline,yytext());}
    "false"         {return new Symbol(Symu.tFalse,yycolumn,yyline,yytext());}

    "return("
                    {yybegin(HTML); return new Symbol(Symu.tReturn,yycolumn,yyline,yytext()); }
    "return" {espacio} "("  
                    {yybegin(HTML); return new Symbol(Symu.tReturn,yycolumn,yyline,yytext()); }

    {id}            {return new Symbol(Symu.tId,yycolumn,yyline,yytext());}
    {caracter}      {return new Symbol(Symu.tCaracter,yycolumn,yyline,yytext());}
    {entero}        {return new Symbol(Symu.tEntero,yycolumn,yyline,yytext());}
    {doble}         {return new Symbol(Symu.tDoble,yycolumn,yyline,yytext());}
}

<HTML>{
    ")"             {yybegin(YYINITIAL);return new Symbol(Symu.tParC,yycolumn,yyline,yytext());}
    ">"             {return new Symbol(Symu.tMayorQ,yycolumn,yyline,yytext());}
    "<"             {return new Symbol(Symu.tMenorQ,yycolumn,yyline,yytext());}
    "\""            { yybegin(STRINGHTML);}
    "panel"         {return new Symbol(Symu.tPanel,yycolumn,yyline,yytext());}
    "x"             {return new Symbol(Symu.tX,yycolumn,yyline,yytext());}
    "y"             {return new Symbol(Symu.tY,yycolumn,yyline,yytext());}
    "height"        {return new Symbol(Symu.tHeigth,yycolumn,yyline,yytext());}
    "width"         {return new Symbol(Symu.tWidth,yycolumn,yyline,yytext());}
    "color"         {return new Symbol(Symu.tColor,yycolumn,yyline,yytext());}
    "border"        {return new Symbol(Symu.tBorder,yycolumn,yyline,yytext());}
    "id"            {return new Symbol(Symu.tIdEtq,yycolumn,yyline,yytext());}
    "="             {return new Symbol(Symu.tIgual,yycolumn,yyline,yytext());}
    "/"             {return new Symbol(Symu.tDiagonal,yycolumn,yyline,yytext());}
    {id}            {return new Symbol(Symu.tId,yycolumn,yyline,yytext());}
    {numero}        {return new Symbol(Symu.tNumero,yycolumn,yyline,yytext());}
}

<YYINITIAL, HTML>{
    {espacio}       { /* ignorar */ }
    .               {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}
