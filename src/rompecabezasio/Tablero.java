package rompecabezasio;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class Tablero extends Canvas implements MouseMotionListener {

    private final LinkedList<InterfazPieza> listaFiguras = new LinkedList<>();
    private InterfazPieza figuraArrastrandose = null;
    private int xAnteriorRaton;
    private int yAnteriorRaton;

    public Tablero() {
        addMouseMotionListener(this);
    }

    public void addFigura(InterfazPieza figura) {
        listaFiguras.add(figura);
    }

    public void removeFigura(InterfazPieza figura) {
        listaFiguras.remove(figura);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 700);
    }

    @Override
    public void paint(Graphics g) {
        listaFiguras.forEach((figura) -> {
            figura.dibujate(g);
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Si comienza el arrastre ...
        if (figuraArrastrandose == null) {
            // Se guardan las posiciones del raton
            xAnteriorRaton = e.getX();
            yAnteriorRaton = e.getY();
            // y se marca que ha comenzado el arrastre.
            figuraArrastrandose = dameFigura(e);
        } else {
            // Si ya habia empezado el arrastre, se calculan las nuevas
            // coordenadas del rectangulo
            figuraArrastrandose.setPosicion(
                    figuraArrastrandose.getX() + (e.getX() - xAnteriorRaton),
                    figuraArrastrandose.getY() + (e.getY() - yAnteriorRaton));
            // Se guarda la posicion del raton para el siguiente calculo
            xAnteriorRaton = e.getX();
            yAnteriorRaton = e.getY();
            System.out.println("Ficha: " + figuraArrastrandose.getNombre());
            System.out.println("Pos x: " + xAnteriorRaton);
            System.out.println("Pos y: " + yAnteriorRaton);
            // y se manda repintar el Canvas
            repaint();
        }
    }

    /**
     * Para ver si el raton esta dentro del rectangulo. Si esta dentro, puede
     * comenzar el arrastre.
     */
    private InterfazPieza dameFigura(MouseEvent e) {
        for (InterfazPieza figura : listaFiguras) {
            if (figura.estaDentro(e.getX(), e.getY())) {
                return figura;
            }
        }

        return null;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        figuraArrastrandose = null;
    }
}
