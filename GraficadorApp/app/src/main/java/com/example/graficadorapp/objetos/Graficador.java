/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.graficadorapp.objetos;

import java.util.ArrayList;

/**
 *
 * @author lex
 */
public class Graficador {

    private ArrayList<Figura> listaFiguras = new ArrayList<Figura>();

    public Graficador() {
    }

    public void mostrarFiguras() {

        for (int i = 0; i < listaFiguras.size(); i++) {
            Figura figura = listaFiguras.get(i);

            if (figura instanceof Circulo) {

                Circulo forma = (Circulo) figura;
                System.out.println("Se obtuvo un circulo " + forma.getColor() + " Radio: " + forma.getRadio());
                if (forma.getAnimacion() == null) {
                    System.out.println("No tiene animacion");
                } else {
                    System.out.println("Animacion " + forma.getAnimacion().getTipo_animacion());
                }

            } else if (figura instanceof Cuadrado) {

                Cuadrado forma = (Cuadrado) figura;
                System.out.println("Se obtuvo un cuadrado " + forma.getColor() + " Longitud de lados: " + forma.getLongitud_lado());
                if (forma.getAnimacion() == null) {
                    System.out.println("No tiene animacion");
                } else {
                    System.out.println("Animacion " + forma.getAnimacion().getTipo_animacion());
                    
                }

            }else if (figura instanceof Rectangulo) {

                Rectangulo forma = (Rectangulo) figura;
                System.out.println("Se obtuvo un rectangulo " + forma.getColor() + " Alto: " + forma.getAlto()+" Ancho: "+forma.getAncho());
                if (forma.getAnimacion() == null) {
                    System.out.println("No tiene animacion");
                } else {
                    System.out.println("Animacion " + forma.getAnimacion().getTipo_animacion());
                    
                }

            }else if (figura instanceof Linea) {

                Linea forma = (Linea) figura;
                System.out.println("Se obtuvo un linea " + forma.getColor() + " Pos x2: " + forma.getPosicion_x2()+" Pos y2: "+forma.getPosicion_y2());
                if (forma.getAnimacion() == null) {
                    System.out.println("No tiene animacion");
                } else {
                    System.out.println("Animacion " + forma.getAnimacion().getTipo_animacion());
                    
                }

            }else if (figura instanceof Poligono) {

                Poligono forma = (Poligono) figura;
                System.out.println("Se obtuvo un poligono " + forma.getColor() + " Cantidad de lados: " + forma.getCantidad_lados());
                if (forma.getAnimacion() == null) {
                    System.out.println("No tiene animacion");
                } else {
                    System.out.println("Animacion " + forma.getAnimacion().getTipo_animacion());
                    
                }

            }
            

        }
    }

    public void setListaFiguras(ArrayList<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public void addFigure(Figura figura) {
        try {
            listaFiguras.add(figura);
        } catch (NullPointerException e) {
            System.out.println("Error al agregar una figura nueva " + e);
        }

    }

    public ArrayList<Figura> getListaFiguras(){
        return listaFiguras;
    }

}
