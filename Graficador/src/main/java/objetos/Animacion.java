/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author lex
 */
public class Animacion {
    private int destino_x;
    private int destino_y;
    private String tipo_animacion;

    public Animacion(int destino_x, int destino_y, String tipo_animacion) {
        this.destino_x = destino_x;
        this.destino_y = destino_y;
        this.tipo_animacion = tipo_animacion;
    }

    public int getDestino_x() {
        return destino_x;
    }

    public int getDestino_y() {
        return destino_y;
    }

    public String getTipo_animacion() {
        return tipo_animacion;
    }

    public void setDestino_x(int destino_x) {
        this.destino_x = destino_x;
    }

    public void setDestino_y(int destino_y) {
        this.destino_y = destino_y;
    }

    public void setTipo_animacion(String tipo_animacion) {
        this.tipo_animacion = tipo_animacion;
    }
    
    
}
