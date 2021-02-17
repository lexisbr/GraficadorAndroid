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
public abstract class Figura {
    private String TIPO;
    private String color;
    private int posicion_x;
    private int posicion_y;
    private Animacion animacion;

    public Figura(String color, int posicion_x, int posicion_y, Animacion animacion) {
        this.color = color;
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
        this.animacion = animacion;
    }

    public String getColor() {
        return color;
    }

    public int getPosicion_x() {
        return posicion_x;
    }

    public int getPosicion_y() {
        return posicion_y;
    }

    public String getTIPO() {
        return TIPO;
    }

    public Animacion getAnimacion() {
        return animacion;
    }
  
    public void setColor(String color) {
        this.color = color;
    }

    public void setPosicion_x(int posicion_x) {
        this.posicion_x = posicion_x;
    }

    public void setPosicion_y(int posicion_y) {
        this.posicion_y = posicion_y;
    }

    public void setAnimacion(Animacion animacion) {
        this.animacion = animacion;
    }
    
    public void mostrarDatos(){
        System.out.println("Figura");
    }
    
    public abstract Figura getFigura(); 
   
    
}
