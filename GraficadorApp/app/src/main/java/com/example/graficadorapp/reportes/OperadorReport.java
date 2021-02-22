package com.example.graficadorapp.reportes;

import com.example.graficadorapp.lexer.*;

import java.io.Serializable;

public class OperadorReport implements Serializable {
    private String operador;
    private int linea;
    private int column;
    private String ocurrencia;

    public OperadorReport(String operador, int linea, int column, String ocurrencia) {
        this.operador = operador;
        this.linea = linea;
        this.column = column;
        this.ocurrencia = ocurrencia;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    public String getOperador() {
        return operador;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumn() {
        return column;
    }

    public String getOcurrencia() {
        return ocurrencia;
    }
}
