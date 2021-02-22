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
public class Poligono extends Figura {

    private final String TIPO = "Poligono";
    private int alto;
    private int ancho;
    private int cantidad_lados;

    public Poligono(int alto, int ancho, int cantidad_lados, String color, int posicion_x, int posicion_y, Animacion animacion) {
        super(color, posicion_x, posicion_y, animacion);
        this.alto = alto;
        this.ancho = ancho;
        this.cantidad_lados = cantidad_lados;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getCantidad_lados() {
        return cantidad_lados;
    }
   
    @Override
    public String getTIPO() {
        return TIPO;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setCantidad_lados(int cantidad_lados) {
        this.cantidad_lados = cantidad_lados;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("%s Color: %s Lados: %d", TIPO, getColor(), getCantidad_lados());
    }
    


}
