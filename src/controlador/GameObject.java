package controlador;

import javax.swing.*;

public abstract class GameObject extends JLabel {

    protected int vida, alcance, impacto;

    protected int puntaje, oro;

    public GameObject(int vida, int alcance, int impacto, ImageIcon graphic) {
        this.vida = vida;
        this.alcance = alcance;
        this.impacto = impacto;

        this.puntaje = (int) Math.random();
        this.oro = (int) Math.random();

        this.setIcon(graphic);
    }

    public abstract void actualizarPosicion();

    public boolean estaMuerto() {
        return vida == 0;
    }

    public int obtenerAlcance() {
        return alcance;
    }

    public int obtenerImpacto() {
        return impacto;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public int obtenerOro() {
        return oro;
    }
}