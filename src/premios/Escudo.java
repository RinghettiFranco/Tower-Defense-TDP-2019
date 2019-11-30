package premios;

import control_logico.Constantes;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class Escudo extends Premio {

    protected static ImageIcon escudo = new ImageIcon("src/Imagenes/Vida.png");

    public Escudo(int x, int y) {
        super(6*Constantes.SEGUNDO, 1*Constantes.ANCHO_CELDA, 0, escudo);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
    }

    public void colisionar(Torre t) {
        t.aplicarEscudo();
        this.morir();
    }

    public void colisionar(Enemigo e) {
        e.aplicarEscudo();
        this.morir();
    }

    public void actualizar() {}
}
