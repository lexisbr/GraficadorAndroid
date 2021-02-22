/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.graficadorapp.objetos;

/**
 *
 * @author lex
 */
public class Cuadrado extends Figura {

    private final String TIPO = "Cuadrado";
    private int longitud_lado;

    public Cuadrado(int longitud_lado, String color, int posicion_x, int posicion_y, Animacion animacion) {
        super(color, posicion_x, posicion_y, animacion);
        this.longitud_lado = longitud_lado;
    }

    public int getLongitud_lado() {
        return longitud_lado;
    }

    public void setLongitud_lado(int longitud_lado) {
        this.longitud_lado = longitud_lado;
    }

    @Override
    public String getTIPO() {
        return TIPO;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("%s Color: %s Longitud lado: %d", TIPO, getColor(), getLongitud_lado());
    }
    


}
