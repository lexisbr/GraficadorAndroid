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
public class Rectangulo extends Figura {

    private final String TIPO = "Rectangulo";
    private int alto;
    private int ancho;

    public Rectangulo(int alto, int ancho, String color, int posicion_x, int posicion_y, Animacion animacion) {
        super(color, posicion_x, posicion_y, animacion);
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    @Override
    public String getTIPO() {
        return TIPO;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("%s Color: %s Alto: %d", TIPO, getColor(), getAlto());
    }
    
    @Override
    public Rectangulo getFigura(){
        return new Rectangulo(getAlto(), getAncho(), getTIPO(), getPosicion_x(), getPosicion_y(), getAnimacion());
    }

}
