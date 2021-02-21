package com.example.graficadorapp.herramientas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;


import com.example.graficadorapp.objetos.Circulo;
import com.example.graficadorapp.objetos.Cuadrado;
import com.example.graficadorapp.objetos.Figura;
import com.example.graficadorapp.objetos.Linea;
import com.example.graficadorapp.objetos.Poligono;
import com.example.graficadorapp.objetos.Rectangulo;

import java.util.ArrayList;

public class Dibujador extends View {
    private ArrayList<Figura> listaFiguras;

    public Dibujador(Context context, ArrayList<Figura> listaFiguras) {
        super(context);
        this.listaFiguras = listaFiguras;
    }

    public ArrayList<Figura> getListaFiguras() {
        return listaFiguras;
    }

    protected void onDraw(Canvas canvas){
        int[] rgbColor = new int[3];
        /*Fondo del lienzo*/
        canvas.drawRGB(204, 255, 255);

        /*Pincel*/
        Paint pincel = new Paint();


        for(Figura figura: listaFiguras){
            int x = figura.getPosicion_x();
            int y = figura.getPosicion_y();
            rgbColor = crearColor(figura.getColor());
            pincel.setARGB(255, rgbColor[0], rgbColor[1], rgbColor[2]);
            pincel.setStrokeWidth(1);



            if(figura instanceof Cuadrado){
                Cuadrado forma = (Cuadrado) figura;
                canvas.drawRect(x,y,x+forma.getLongitud_lado(),y+forma.getLongitud_lado(),pincel);
            }else if(figura instanceof Circulo){
                Circulo forma = (Circulo) figura;
                canvas.drawCircle(x,y,forma.getRadio(),pincel);
            }else if(figura instanceof Rectangulo){
                Rectangulo forma = (Rectangulo) figura;
                canvas.drawRect(x,y,forma.getAncho()+x,y+forma.getAlto(),pincel);
            }else if (figura instanceof Linea){
                pincel.setStrokeWidth(15);
                Linea forma = (Linea) figura;
                canvas.drawLine(x,y,forma.getPosicion_x2(),forma.getPosicion_y2(),pincel);
            }else if(figura instanceof Poligono){
                Poligono forma = (Poligono) figura;
               // canvas.drawRect(x,y,forma.getAncho()+x,y+forma.getAlto(),pincel);

                Path path = new Path();
                float lado = (float) ((Math.PI * 2) / forma.getCantidad_lados());
                System.out.println("X "+Math.cos(lado)+" Y "+Math.sin(lado));
                float x_inicial = x + forma.getAncho();
                float y_inicial = y;
                path.moveTo(x_inicial,y_inicial);


                for (int i =1; i< forma.getCantidad_lados(); i++){
                        float x_1 = forma.getAncho() * (float) Math.cos(lado*i);
                        float y_1 = forma.getAlto() * (float) Math.sin(lado*i);
                        path.lineTo(x_1+x,y_1+y);
                }
                canvas.drawPath(path,pincel);
            }


        }

    }

    public int[] crearColor(String color){
        int[] rgbColor = new int[3];
        if(color.equals("azul")){
            rgbColor[0] = 0;
            rgbColor[1] = 102;
            rgbColor[2] = 204;
        }else if (color.equals("rojo")){
            rgbColor[0] = 255;
            rgbColor[1] = 0;
            rgbColor[2] = 0;
        }else if (color.equals("verde")){
            rgbColor[0] = 0;
            rgbColor[1] = 255;
            rgbColor[2] = 0;
        }else if (color.equals("amarillo")){
            rgbColor[0] = 255;
            rgbColor[1] = 255;
            rgbColor[2] = 0;
        }else if (color.equals("naranja")){
            rgbColor[0] = 255;
            rgbColor[1] = 165;
            rgbColor[2] = 0;
        }else if (color.equals("morado")){
            rgbColor[0] = 128;
            rgbColor[1] = 0;
            rgbColor[2] = 128;
        }else if (color.equals("cafe")){
            rgbColor[0] = 139;
            rgbColor[1] = 69;
            rgbColor[2] = 19;
        }else if (color.equals("negro")){
            rgbColor[0] = 0;
            rgbColor[1] = 0;
            rgbColor[2] = 0;
        }
        return rgbColor;
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


}
