package com.example.graficadorapp.reportes;

import com.example.graficadorapp.lexer.*;

import java.io.Serializable;
import java.util.List;

import static com.example.graficadorapp.parser.sym.*;

public class ErrorToken extends Token implements Serializable  {
    private String descripcion;
    private String tipo;


    public ErrorToken(String lexeme, int line, int column, String descripcion, String tipo) {
        super(lexeme, line, column);
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void siguiente(List<Integer> tipo){
        int cont=0;
        if(tipo.size()==1){
            setDescripcion("Se esperaba: "+terminalNames[tipo.get(0)]);
        }else{
            setDescripcion("Se esperaba: ");
            for(int tipoT: tipo){
                if(tipoT!=1) {
                    if(cont==0) {
                        setDescripcion(getDescripcion() + terminalNames[tipoT]);
                        cont++;
                    }else{
                        setDescripcion(getDescripcion() +" o "+terminalNames[tipoT]);
                    }
                }
            }
        }
    }
}
