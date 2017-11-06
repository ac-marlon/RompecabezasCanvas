/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rompecabezasio;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author marlon
 */
public class Pieza implements InterfazPieza {

    private int x;
    private int y;
    private final String nombre;
    ImageIcon img;
    private final int ancho;
    private final int alto;

    public Pieza(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        img = new ImageIcon(getClass().getResource(nombre));
        ancho = img.getIconWidth();
        alto = img.getIconHeight();
    }

    @Override
    public boolean estaDentro(int x, int y) {
        return (x > this.x) && (x < (this.x + ancho)) && (y > this.y) && (y < (this.y + alto));
    }

    @Override
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void dibujate(Graphics g) {
        g.drawImage(img.getImage(), x, y, null);
    }

}
