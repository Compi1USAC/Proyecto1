package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
%%
%{
    String cadena="", cadenaInterna = "";
    int c = 0;
%}

%public
%class LexicoCSS
%cupsym Symc
%cup
%char
%line
%column
%full
%unicode
%ignorecase

digito = [0-9]
numero = {digito}+("." {digito}+)?
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*   
espacio = \t|\f|" "|\r|\n

%state COMENTMULTI
%state STRING
%state CADENAINTERNA

%%

<STRING>{
    [\"] {  yybegin(YYINITIAL);
            String temporal = cadena; 
            cadena = "";
            return new Symbol(Symh.tCadena, yychar,yyline,temporal);   
         }
    [^\"] { cadena += yytext(); }
}

<COMENTMULTI>{
    "-->"         {yybegin(YYINITIAL);}
    .            {}
    [ \t\r\n\f]  {}
}

<YYINITIAL>{ 
    "id"    {return new Symbol(Symh.tId,yycolumn,yyline,yytext());}
    "="     {return new Symbol(Symh.tIgual,yycolumn,yyline,yytext());}
    "<"     {return new Symbol(Symh.tMenorQue,yycolumn,yyline,yytext());}
    "/"     {return new Symbol(Symh.tDiagonal,yycolumn,yyline,yytext());}
    ">"     {   
                if(c == 1){
                    yybegin(CADENAINTERNA);
                }
                return new Symbol(Symh.tMayorQue,yycolumn,yyline,yytext());
            }
    {espacio} { /* ignorar */ }
    .       {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}

<CADENAINTERNA>{
    "<" {  yybegin(YYINITIAL);
            String temporal = cadenaInterna; 
            cadena = "";
            yypushback(1);
            return new Symbol(Symh.tCadenaInterna, yychar,yyline,temporal);   
         }
    [^<] { cadenaInterna += yytext(); }
}

