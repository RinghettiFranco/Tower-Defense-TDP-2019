package control_grafico;

import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_logico.Agregable;
import control_logico.SinEscudo;
import control_logico.Vida;
import control_logico.Visitor;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject extends JLabel {

    protected static Agregable tableroJuego;

    protected Vida vida;
    protected int alcance, impacto;
    protected int puntaje, oro;

    protected Rectangle hitBox;

    public GameObject(int vida, int alcance, int impacto, ImageIcon graphic) {
        this.vida = new SinEscudo(vida);
        this.alcance = alcance;
        this.impacto = impacto;

        this.puntaje = (int) Math.random();
        this.oro = (int) Math.random();

        this.setIcon(graphic);
    }

    public static void setTableroJuego(Agregable a) {
        tableroJuego = a;
    }

    public abstract void aceptar(Visitor v);

    public abstract void atacar(Torre t);
    public abstract void atacar(Enemigo e);
    public abstract void atacar(ProyectilAliado pa);
    public abstract void atacar(ProyectilEnemigo pe);

    public abstract void actualizarPosicion();

    public boolean estaMuerto() {
        return vida.obtenerVida() == 0;
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