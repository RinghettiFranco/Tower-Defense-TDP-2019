package premios;

import control_logico.Constantes;

import javax.swing.*;

public class Bomba extends Premio {

    protected static ImageIcon bomba = new ImageIcon("src/Imagenes/Bomba.png");

    public Bomba(int x, int y) {
        super(Constantes.MAX_INF, 1*Constantes.ANCHO_CELDA, 10, bomba);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
    }


    @Override
    public void actualizar() {

    }

    public void frenar() {}

    @Override
    public Bomba clone(int posX, int posY) {
        return null;
    }
}
