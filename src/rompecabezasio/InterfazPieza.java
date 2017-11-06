package rompecabezasio;

import java.awt.Graphics;

/**
 * Interface comun para todas las figuras que se pueden dibujar y arrastrar con
 * el raton en LienzoParaArrastrarFiguras.
 */
public interface InterfazPieza {

    /**
     * Debe devolver true si x,y esta dentro de la figura, false en caso
     * contrario
     *
     * @param x
     * @param y
     *
     * @return true si x,y esta dentro de la figura
     */
    public boolean estaDentro(int x, int y);

    /**
     * Fija la posicion en la que se debe dibujar la figura
     *
     * @param x
     * @param y
     */
    public void setPosicion(int x, int y);

    /**
     * Devuelve la x en la que se dibuja la figura
     *
     * @return x de la figura
     */
    public int getX();

    /**
     * Devuelve la y en la que se dibuja la figura
     *
     * @return y de la figura
     */
    public int getY();

    /**
     * Dibuja la figura en el Graphics que se le pasa, en la posicion x,y que se
     * indico por medio de setPosicion()
     *
     * @param g Graphics con el que dibujar.
     */
    public void dibujate(Graphics g);

    public String getNombre();

}
