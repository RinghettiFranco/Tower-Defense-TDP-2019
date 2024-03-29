package control_grafico;

import control_logico.*;
import enemigos.Enemigo;
import objetos_jugador.ObjetosJugador;
import objetos_mapa.ObjetoMapa;
import premios.Premio;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class GameObject extends JLabel {

    protected JLabel labelVida;

    protected static Agregable tableroJuego;
    protected static Inventario inventario;
    protected static TableroPuntos puntos;

    protected int vida, alcance, impacto;
    protected int puntaje, oro;

    public GameObject(int vida, int alcance, int impacto, ImageIcon graphic) {
        Random rnd = new Random(System.currentTimeMillis());
        this.vida = vida;
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
    public static void setPuntaje(TableroPuntos tp) {
        puntos = tp;
    }

    public abstract void aceptar(Visitor v);

    public void colisionar(Torre t) {}
    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}
    public void colisionar(ObjetosJugador oj) {}
    public void colisionar(ObjetoMapa om) {}
    public void colisionar(Premio p) {}

    public void recibirDmg(int dmg) {
        vida -= dmg;
    }

    public abstract void actualizar();

    public void morir() {
        tableroJuego.delFromObjects(this);
    }
    
    public int obtenerVida() {
    	return vida;
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

    public void deltaImpacto(int incr) {
        this.impacto += incr;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public int costo() {
        return 0;
    }

    public int distancia (GameObject go) {
        if (this.getY() == go.getY())
            return (int) Math.sqrt((go.getX()-this.getX())*(go.getX()-this.getX()) + (go.getY()-this.getY())*(go.getY()-this.getY()));
        else
            return Constantes.MAX_INF;
    }
}