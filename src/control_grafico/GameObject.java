package control_grafico;

import control_logico.*;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class GameObject extends JLabel {

    protected JLabel labelVida;

    protected static Agregable tableroJuego;
    protected static Inventario inventario;

    protected Vida vida;
    protected int alcance, impacto;
    protected int puntaje, oro;

    protected Rectangle hitBox;

    public GameObject(int vida, int alcance, int impacto, ImageIcon graphic) {
        Random rnd = new Random(System.currentTimeMillis());
        this.vida = new SinEscudo(vida);
        this.alcance = alcance;
        this.impacto = impacto;

        this.puntaje = (int) Math.random();
        this.oro = rnd.nextInt(30);

        this.setIcon(graphic);

        labelVida = new JLabel();
        labelVida.setOpaque(true);
        labelVida.setBackground(Color.GREEN);
    }

    public static void setTableroJuego(Agregable a) {
        tableroJuego = a;
    }
    public static void setInventario(Inventario i) {
        inventario = i;
    }

    public abstract void aceptar(Visitor v);

    public abstract void colisionar(Torre t);
    public abstract void colisionar(Enemigo e);
    public abstract void colisionar(ProyectilAliado pa);
    public abstract void colisionar(ProyectilEnemigo pe);

    public void recibirDmg(int dmg) {
        vida.recibirDmg(dmg);
    }

    public abstract void actualizar();

    public abstract void frenar();
    public abstract void morir();
    public boolean estaMuerto() {
        return vida.obtenerVida() <= 0;
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

    protected int distancia (Rectangle r1, Rectangle r2) {
        if (r1.y == r2.y)
            return (int) Math.sqrt((r2.x-r1.x)*(r2.x-r1.x) + (r2.y-r1.y)*(r2.y-r1.y));
        else
            return Constantes.MAX_INF;
    }
}