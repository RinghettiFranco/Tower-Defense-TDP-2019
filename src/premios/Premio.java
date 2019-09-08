package premios;

import controlador.GameObject;

import javax.swing.*;

public abstract class Premio extends GameObject {


    public Premio(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
}
