package com.example.graficadorapp.lexer;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
import com.example.graficadorapp.parser.sym;
import static com.example.graficadorapp.parser.sym.*;
import com.example.graficadorapp.reportes.ErrorToken;


%%

%public
%class Lexer
%cup
%cupdebug
%line
%column

//caracteres y separadores
SEPARADORES = [ \r\t\b\f\n]

//reservadas
ENTERO = [0-9]+
PARENTESIS_A = "("
PARENTESIS_C = ")"
COLOR = ("azul" | "rojo" | "verde" | "amarillo" | "naranja" | "morado" | "cafe" | "negro" )
SUMA = "+"
RESTA = "-"
MULTI = "*"
DIVISION = "/"
CIRCULO = "circulo"
CUADRADO = "cuadrado"
RECTANGULO = "rectangulo"
LINEA = "linea"
POLIGONO = "poligono"
GRAFICAR = "graficar"
COMA = ","
ANIMAR = "animar"
OBJETO = "objeto"
ANTERIOR = "anterior"
CURVA = "curva"


%{

	private ArrayList<ErrorToken> errorsList = new ArrayList<>();
%}

%{
	private Symbol symbol(int type) {
        String lexeme = yytext();
        //System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type, String lexeme) {
        //System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private void error(String lexeme) {
       ErrorToken error = new ErrorToken(lexeme,yyline+1,yycolumn+1,"Simbolo no existe en el lenguaje","Lexico");
       System.out.printf("Lexema: %s Linea: %s Columna: %s Descripcion: %s",error.getLexeme(),error.getLine(),error.getColumn(),error.getDescripcion());
       errorsList.add(error);
    }

    public ArrayList<ErrorToken> getErrorsList(){
        return errorsList;
    }


%}


%%

/* reglas lexicas */
<YYINITIAL> {
    {PARENTESIS_A}
		{/*System.out.printf(" PARENTESIS: %s\n", yytext());*/ return  symbol(PARENTESIS_A, yytext());}
    {PARENTESIS_C}
		{/*System.out.printf(" PARENTESIS: %s\n", yytext());*/ return  symbol(PARENTESIS_C, yytext());}
    {PARENTESIS_A}
		{/*System.out.printf(" PARENTESIS: %s\n", yytext());*/ return  symbol(PARENTESIS_A, yytext());}
    {CUADRADO}
		{/*System.out.printf(" CUADRADO: %s\n", yytext());*/ return  symbol(CUADRADO, yytext());}
    {CIRCULO}
		{/*System.out.printf(" CIRCULO: %s\n", yytext());*/ return  symbol(CIRCULO, yytext());}
    {RECTANGULO}
		{/*System.out.printf(" RECTANGULO: %s\n", yytext());*/ return  symbol(RECTANGULO, yytext());}
    {LINEA}
		{/*System.out.printf(" RECTANGULO: %s\n", yytext());*/ return  symbol(LINEA, yytext());}
    {POLIGONO}
		{/*System.out.printf(" RECTANGULO: %s\n", yytext());*/ return  symbol(POLIGONO, yytext());}
    {GRAFICAR}
        {/*System.out.printf(" GRAFICAR: %s\n", yytext());*/ return  symbol(GRAFICAR, yytext());}
    {COMA}
        {/*System.out.printf(" COMA: %s\n", yytext());*/ return  symbol(COMA, yytext());}
    {ENTERO}
        {/*System.out.printf(" ENTERO: %s\n", yytext());*/ return  symbol(ENTERO, yytext());}
    {SUMA}
        {/*System.out.printf(" ENTERO: %s\n", yytext());*/ return  symbol(SUMA, yytext());}
    {RESTA}
        {/*System.out.printf(" ENTERO: %s\n", yytext());*/ return  symbol(RESTA, yytext());}
    {MULTI}
        {/*System.out.printf(" ENTERO: %s\n", yytext());*/ return  symbol(MULTI, yytext());}
    {DIVISION}
        {/*System.out.printf(" ENTERO: %s\n", yytext());*/ return  symbol(DIVISION, yytext());}
    {COLOR}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(COLOR, yytext());}
    {ANIMAR}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(ANIMAR, yytext());}
    {OBJETO}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(OBJETO, yytext());}
    {ANTERIOR}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(ANTERIOR, yytext());}
    {CURVA}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(CURVA, yytext());}
	{SEPARADORES}
	 	{/* los ignoramos */}
}

/* Error por cualquier otro simbolo*/
[^]
		{ error(yytext()); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }