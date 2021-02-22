package com.example.graficadorapp.reportes;

import java.io.Serializable;

public class AnimacionReport implements Serializable {
    private String animacion;
    private int contador;

    public AnimacionReport(String animacion, int contador) {
        this.animacion = animacion;
        this.contador = contador;
    }

    public String getAnimacion() {
        return animacion;
    }

    public int getContador() {
        return contador;
    }

    public void setAnimacion(String animacion) {
        this.animacion = animacion;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
