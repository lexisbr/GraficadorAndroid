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
public class Circulo extends Figura {
    private final String TIPO = "Circulo";
    private int radio;

    public Circulo(int radio, String color, int posicion_x, int posicion_y, Animacion animacion) {
        super(color, posicion_x, posicion_y, animacion);
        this.radio = radio;
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public String getTIPO() {
        return TIPO;
    }
    
     
    @Override
    public void mostrarDatos(){
        System.out.printf("%s Color: %s Radio: %d",TIPO,getColor(),getRadio());
    }
    

}
