package control_grafico;

import control_logico.Visitor;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import control_logico.VisitorColision;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject extends JLabel {

    protected int vida, alcance, impacto;
    protected int puntaje, oro;

    protected Rectangle hitBox;

    public GameObject(int vida, int alcance, int impacto, ImageIcon graphic) {
        this.vida = vida;
        this.alcance = alcance;
        this.impacto = impacto;

        this.puntaje = (int) Math.random();
        this.oro = (int) Math.random();

        this.setIcon(graphic);
    }

    public abstract void actualizarPosicion();

    public boolean intersecta(GameObject go) {
        return this.hitBox.intersects(go.hitBox);
    }

    public abstract void aceptar(Visitor v);

    public abstract void colisionar(Torre t);
    public abstract void colisionar(Enemigo e);
    public abstract void colisionar(ProyectilAliado pa);
    public abstract void colisionar(ProyectilEnemigo pe);

    public void recibirDmg(int dmg) {
        this.vida -= dmg;
    }

    public boolean estaMuerto() {
        return vida <= 0;
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