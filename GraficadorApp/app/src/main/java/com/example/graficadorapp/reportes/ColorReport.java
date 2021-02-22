package com.example.graficadorapp.reportes;

import java.io.Serializable;
import java.util.ArrayList;

public class ColorReport implements Serializable {
   private String color;
   private int contador;

    public ColorReport(String color, int contador) {
        this.color = color;
        this.contador = contador;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getColor() {
        return color;
    }

    public int getContador() {
        return contador;
    }

}
