/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import lexer.Lexer;
import lexer.Token;
import parser.Parser;

/**
 *
 * @author lex
 */
public class Analizador {

    public static void main(String[] args) {

        String entrada1 = "graficar circulo (25+123*8-5,15+56+66+(12+12)*7,45,rojo) graficar cuadrado(25,15-8+,45,rojo) graficar rectangulo graficar (12+(12),12,12,12,amarillo) "
                + "graficar linea (12,12,12,12,amarillo) graficar poligono (12,12,12,12,12,amarillo) animar objeto anterior (55,55,curva)";
        String entrada = "graficar + cuadrado (25+,25,25,rojo)";
        StringReader reader = new StringReader(entrada);

        Lexer lex = new Lexer(reader);
        Parser parser = new Parser(lex);

        try {
            parser.parse();

            if (parser.getErrores()) {
                System.out.println("Tiene errores no ejecutara nada");
            } else {
                parser.getGraficador().mostrarFiguras();
            }

        } catch (Exception ex) {
            System.out.println("Error irrecuperable " + ex);
        }

    }

}
