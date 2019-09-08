package armas;

import controlador.GameObject;

import javax.swing.*;

public abstract class Proyectil extends GameObject {


    public Proyectil(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
}
