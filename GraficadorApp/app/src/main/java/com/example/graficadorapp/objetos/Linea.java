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
public class Linea extends Figura {

    private final String TIPO = "Linea";
    private int posicion_x2;
    private int posicion_y2;

    public Linea(int posicion_x2, int posicion_y2, String color, int posicion_x, int posicion_y, Animacion animacion) {
        super(color, posicion_x, posicion_y, animacion);
        this.posicion_x2 = posicion_x2;
        this.posicion_y2 = posicion_y2;
    }

    public int getPosicion_x2() {
        return posicion_x2;
    }

    public int getPosicion_y2() {
        return posicion_y2;
    }

    public void setPosicion_x2(int posicion_x2) {
        this.posicion_x2 = posicion_x2;
    }

    public void setPosicion_y2(int posicion_y2) {
        this.posicion_y2 = posicion_y2;
    }

    @Override
    public String getTIPO() {
        return TIPO;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("%s Color: %s Posicion X2: %d", TIPO, getColor(), getPosicion_x2());
    }
    

}
