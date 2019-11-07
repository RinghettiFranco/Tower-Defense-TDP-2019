package proyectiles;

import control_grafico.GameObject;
import movimiento.Movimiento;

import javax.swing.*;

public abstract class Proyectil extends GameObject {

    protected int cuentaRegresiva;
    protected Movimiento pos;

    public Proyectil(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }

    @Override
    public void morir() {
        tableroJuego.delFromObjects(this);
    }
    public void frenar() {}
}
