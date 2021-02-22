package com.example.graficadorapp.reportes;

import java.io.Serializable;

public class FiguraReport implements Serializable {
    private String objeto;
    private int contador;

    public FiguraReport(String objeto, int contador) {
        this.objeto = objeto;
        this.contador = contador;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getObjeto() {
        return objeto;
    }

    public int getContador() {
        return contador;
    }
}
