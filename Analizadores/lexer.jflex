package lexer;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
import static parser.sym.*;
import parser.sym;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column
%unicode

LineTerminator = [\r|\n|\r\n]

SEPARADOR = {LineTerminator} | [ \t\f]

ENTERO = ([0-9]+)

PARENTESIS_A = "("

PARENTESIS_C = ")"

COLOR = ("azul" | "rojo" | "verde" | "amarillo" | "naranja" | "morado" | "cafe" | "negro" )


COMA = ","

%{
    private List<String> errorsList;
%}


%{
    private Symbol symbol(int type, String lexeme, String tipo){
        System.out.printf("\n >>>| Lexema: %s | Tipo: %s | Linea: %d | Columna: %d |<<< %n", lexeme == null ? "":lexeme,type,yyline+1,yycolumn+1);
        return new Symbol(type, new Token(lexeme, yyline+1, yycolumn+1));
    }

    private Symbol symbol(int type){
        String lexeme = yytext();
        System.out.printf("Token tipo %d, lexema %s, columna %d\n", type, lexeme == null ? "":lexeme, yyline+1, yycolumn+1);
        return new Symbol(type, new Token(lexeme,yyline+1,yycolumn+1));
    }

    private void error(String lexeme){
        System.out.printf("Error lexico en: %s Linea %d, Columna %d. %n", lexeme, yyline+1,yycolumn+1);
        errorsList.add(String.format("Error lexico en: %s Linea %d, Columna %d. Corrija e intente de nuevo.", lexeme, yyline+1, yycolumn+1));
    }

    public List<String> getErrorsList(){
        return errorsList;
    }
%}

%init{
        errorsList = new ArrayList<>();
%init}

%%

<YYINITIAL>{
    
    "+"
    {
        symbol(SUMA,yytext(),"OPERADOR");
    }
    "-"
    {
        symbol(RESTA,yytext(),"OPERADOR");
    }
    "*"
    {
        symbol(MULTIPLICACION,yytext(),"OPERADOR");
    }
    "/"
    {
        symbol(DIVISION,yytext(),"OPERADOR");
    }
    "circulo"
    {
        symbol(CIRCULO,yytext(),"FIGURA");
    }
    "cuadrado"
    {
        symbol(CUADRADO,yytext(),"FIGURA");
    }
    "rectangulo"
    {
        symbol(RECTANGULO,yytext(),"FIGURA");
    }
    "linea"
    {
        symbol(LINEA,yytext(),"FIGURA");
    }
    "poligono"
    {
        symbol(POLIGONO,yytext(),"FIGURA");
    }
    "graficar"
    {
        symbol(GRAFICAR,yytext(),"PALABRA RESERVADA");
    }
    "animar"
    {
        symbol(ANIMAR,yytext(),"PALABRA RESERVADA");
    }
    "objeto"
    {
        symbol(OBJETO,yytext(),"PALABRA RESERVADA");
    }
    "anterior"
    {
        symbol(ANTERIOR,yytext(),"PALABRA RESERVADA");
    }
    "curva"
    {
        symbol(CURVA,yytext(),"PALABRA RESERVADA");
    }
    {ENTERO}
    {
        symbol(ENTERO,yytext(),"ENTERO");
    }
    {COLOR}
    {
        symbol(COLOR,yytext(),"COLOR");
    }
    {COMA}
    {
        symbol(COMA,yytext(),"COMA");
    }
    {PARENTESIS_A}
    {
        symbol(PARENTESIS_A,yytext(),"PARENTESIS");
    }
    {PARENTESIS_C}
    {
        symbol(PARENTESIS_C,yytext(),"PARENTESIS");
    }

    {SEPARADOR}
    {
        /* IGNORAR */
    }
}

[^]
{
    error(yytext());
    return symbol(error, yytext(),"ERROR");
}

<<EOF>>
{
    return symbol(EOF);
}