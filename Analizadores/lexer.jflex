package com.example.graficadorapp.lexer;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
import com.example.graficadorapp.parser.sym;
import static com.example.graficadorapp.parser.sym.*;
import com.example.graficadorapp.reportes.*;


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
  private ArrayList<ColorReport> colores = new ArrayList<>();
  private ArrayList<FiguraReport> figuras = new ArrayList<>();
  private ArrayList<AnimacionReport> animaciones = new ArrayList<>();

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

    public void addColor(String lexeme){
      if(lexeme.equals("azul")){
        ColorReport color = (ColorReport) colores.get(0); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("rojo")){
        ColorReport color = (ColorReport) colores.get(1); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("verde")){
        ColorReport color = (ColorReport) colores.get(2); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("amarillo")){
        ColorReport color = (ColorReport) colores.get(3); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("naranja")){
        ColorReport color = (ColorReport) colores.get(4); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("morado")){
        ColorReport color = (ColorReport) colores.get(5); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("cafe")){
        ColorReport color = (ColorReport) colores.get(6); 
        color.setContador(color.getContador()+1);
      }else if(lexeme.equals("negro")){
        ColorReport color = (ColorReport) colores.get(7); 
        color.setContador(color.getContador()+1);
      }
    }

    public void addFigura(String lexeme){
      if(lexeme.equals("circulo")){
        FiguraReport figura = (FiguraReport) figuras.get(0);
        figura.setContador(figura.getContador()+1);
      } else if(lexeme.equals("cuadrado")){
        FiguraReport figura = (FiguraReport) figuras.get(1);
        figura.setContador(figura.getContador()+1);
      } else if(lexeme.equals("rectangulo")){
        FiguraReport figura = (FiguraReport) figuras.get(2);
        figura.setContador(figura.getContador()+1);
      }else if(lexeme.equals("linea")){
        FiguraReport figura = (FiguraReport) figuras.get(3);
        figura.setContador(figura.getContador()+1);
      }else if(lexeme.equals("poligono")){
        FiguraReport figura = (FiguraReport) figuras.get(4);
        figura.setContador(figura.getContador()+1);
      }

    }

    public void addAnimacion(String lexeme){
       if(lexeme.equals("linea")){
        AnimacionReport animacion = (AnimacionReport) animaciones.get(0);
        animacion.setContador(animacion.getContador()+1);
      } else if(lexeme.equals("curva")){
        AnimacionReport animacion = (AnimacionReport) animaciones.get(1);
        animacion.setContador(animacion.getContador()+1);
      } 

    }

    public ArrayList<ColorReport> getColorsList(){
      return colores;
    }

    public ArrayList<FiguraReport> getFigurasList(){
      return figuras;
    }

    public ArrayList<AnimacionReport> getAnimacionesList(){
      return animaciones;
    }


%}

%init{
        colores.add( new ColorReport("Azul",0));
        colores.add( new ColorReport("Rojo",0));
        colores.add( new ColorReport("Verde",0));
        colores.add( new ColorReport("Amarillo",0));
        colores.add( new ColorReport("Naranja",0));
        colores.add( new ColorReport("Morado",0));
        colores.add( new ColorReport("Cafe",0));
        colores.add( new ColorReport("Negro",0));

        figuras.add( new FiguraReport("Circulo",0));
        figuras.add( new FiguraReport("Cuadrado",0));
        figuras.add( new FiguraReport("Rectangulo",0));
        figuras.add( new FiguraReport("Linea",0));
        figuras.add( new FiguraReport("Poligono",0));

        animaciones.add( new AnimacionReport("Linea",0));
        animaciones.add( new AnimacionReport("Curva",0));
%init}

%%

/* reglas lexicas */
<YYINITIAL> {
    {PARENTESIS_A}
		{/*System.out.printf(" PARENTESIS: %s\n", yytext());*/ return  symbol(PARENTESIS_A, yytext());}
    {PARENTESIS_C}
		{/*System.out.printf(" PARENTESIS: %s\n", yytext());*/ return  symbol(PARENTESIS_C, yytext());}
    {CUADRADO}
		{/*System.out.printf(" CUADRADO: %s\n", yytext());*/ addFigura(yytext()); return  symbol(CUADRADO, yytext());}
    {CIRCULO}
		{/*System.out.printf(" CIRCULO: %s\n", yytext());*/ addFigura(yytext()); return  symbol(CIRCULO, yytext());}
    {RECTANGULO}
		{/*System.out.printf(" RECTANGULO: %s\n", yytext());*/  addFigura(yytext()); return  symbol(RECTANGULO, yytext());}
    {LINEA}
		{/*System.out.printf(" RECTANGULO: %s\n", yytext());*/  return  symbol(LINEA, yytext());}
    {POLIGONO}
		{/*System.out.printf(" RECTANGULO: %s\n", yytext());*/ addFigura(yytext()); return  symbol(POLIGONO, yytext());}
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
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ addColor(yytext()); return  symbol(COLOR, yytext());}
    {ANIMAR}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(ANIMAR, yytext());}
    {OBJETO}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(OBJETO, yytext());}
    {ANTERIOR}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ return  symbol(ANTERIOR, yytext());}
    {CURVA}
        {/*System.out.printf(" COLOR: %s\n", yytext());*/ addAnimacion(yytext()); return  symbol(CURVA, yytext());}
	{SEPARADORES}
	 	{/* los ignoramos */}
}

/* Error por cualquier otro simbolo*/
[^]
		{ error(yytext()); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }