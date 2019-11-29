package premios;

import control_logico.Constantes;

import javax.swing.*;

public class Bomba extends Premio {

    protected static ImageIcon bomba = new ImageIcon("src/Imagenes/Bomba.png");

    public Bomba(int x, int y) {
        super(5*Constantes.SEGUNDO, 0, 0, bomba);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void actualizar() {
        this.vida.recibirDmg(1);
        if (this.vida.obtenerVida() <= 0)
            morir();
    }

    public void frenar() {}
}
