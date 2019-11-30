package premios;

import control_logico.Constantes;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class Bomba extends Premio {

    protected static ImageIcon bomba = new ImageIcon("src/Imagenes/Bomba.png");

    protected boolean exploto;

    public Bomba(int x, int y) {
        super(15*Constantes.SEGUNDO, Constantes.ANCHO_CELDA/2, 0, bomba);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.exploto = false;

        tableroJuego.addToObjects(this);
    }

    public void actualizar() {
        if (exploto)
            morir();
        else {
            this.recibirDmg(1);
            if (this.obtenerVida() <= 0)
                morir();
        }
    }

    public void colisionar(Enemigo e) {
        this.exploto = true;
        e.morir();
    }

    public void colisionar(Torre t) {
        this.exploto = true;
        t.morir();
    }
}
