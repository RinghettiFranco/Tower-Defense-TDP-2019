package premios;

import control_logico.Constantes;

import javax.swing.*;

public class Fuego extends Premio {

    protected static ImageIcon fuego = new ImageIcon("src/Imagenes/fire.gif");

    public Fuego(int x, int y) {
        super(6*Constantes.SEGUNDO,  1*Constantes.ANCHO_CELDA, 10, fuego);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {

    }

    @Override
    public Fuego clone(int posX, int posY) {
        return null;
    }
}
