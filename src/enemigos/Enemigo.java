package enemigos;


import control_grafico.GameObject;
import movimiento.Movimiento;

import javax.swing.*;
import java.awt.geom.Point2D;

public abstract class Enemigo extends GameObject {

    protected Movimiento pos;

    public Enemigo(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
        this.setBounds(60,60,25, 63);
    }

    public void actualizarPosicion() {
        Point2D nueva=pos.proximaPosicion();
        int x=(int) nueva.getX();
        int y=(int) nueva.getY();

        hitBox.setBounds(x,y,33,73);
        this.setBounds(hitBox);
    }
}
