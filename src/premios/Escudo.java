package premios;

import control_logico.Constantes;

import javax.swing.*;

public class Escudo extends Premio {

    protected static ImageIcon escudo = new ImageIcon("src/Imagenes/");

    public Escudo(int x, int y) {
        super(3, 0, 0, escudo);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {

    }

    @Override
    public Escudo clone(int posX, int posY) {
        return null;
    }
}
