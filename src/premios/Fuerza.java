package premios;

import control_grafico.GameObject;
import control_logico.Constantes;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;

public class Fuerza extends Premio {

    protected static ImageIcon fuerza = new ImageIcon("src/Imagenes/Fuerza.png");

    protected GameObject miObjetivo;
    public Fuerza(int x, int y) {
        super(5*Constantes.SEGUNDO, 1*Constantes.ANCHO_CELDA, 0, fuerza);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    @Override
    public void colisionar(Enemigo e) {
        if (miObjetivo == null) {
            miObjetivo = e;
            e.deltaImpacto(5);
            System.out.println("Fuerza -> enemigo");
        }
        // Sacamos el objeto de la vista
        this.setIcon(null);
        this.setBounds(Constantes.MAX_INF, Constantes.MAX_INF, 1, 1);
    }

    @Override
    public void colisionar(Torre t) {
        if (miObjetivo == null) {
            miObjetivo = t;
            t.deltaImpacto(5);
            t.setOpaque(true);
            t.setBackground(Color.RED);
            System.out.println("Fuerza -> torre");
        }
        // Sacamos el objeto de la vista
        this.setIcon(null);
        this.setBounds(Constantes.MAX_INF, Constantes.MAX_INF, 1, 1);
    }

    public void actualizar() {
        this.recibirDmg(1);
        if (this.obtenerVida() <= 0) {
            if (miObjetivo != null) {
                miObjetivo.deltaImpacto(-5);
                miObjetivo.setOpaque(false);
            }
            this.morir();
        }
    }
}
