package premios;

import control_logico.Constantes;

import javax.swing.*;

public class Fuerza extends Premio {

    protected static ImageIcon fuerza = new ImageIcon("src/Imagenes/Fuerza.png");

    public Fuerza(int x, int y) {
        super(5*Constantes.SEGUNDO, 1*Constantes.ANCHO_CELDA, 0, fuerza);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {}

    @Override
    public Fuerza clone(int posX, int posY) {
        return null;
    }
}
