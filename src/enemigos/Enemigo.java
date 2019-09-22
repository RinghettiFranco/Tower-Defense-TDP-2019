package enemigos;

import armas.Arma;
import control_grafico.GameObject;

import javax.swing.*;

public abstract class Enemigo extends GameObject {

    protected Arma golpe;

    public Enemigo(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
}
