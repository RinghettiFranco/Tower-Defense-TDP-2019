package control_grafico;

import control_logico.*;
import enemigos.Enemigo;
import objetos_jugador.Espinas;
import objetos_jugador.R2D2;
import objetos_jugador.RobotBarrera;
import objetos_jugador.RobotPiso;
import objetos_mapa.AgujeroNegro;
import objetos_mapa.Meteorito;
import premios.Bomba;
import premios.Fuego;
import premios.Fuerza;
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

    protected Vida vida;
    protected int alcance, impacto;
    protected int puntaje, oro;

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
    public static void setPuntaje(TableroPuntos tp) {
        puntos = tp;
    }

    public abstract void aceptar(Visitor v);

    public void colisionar(Torre t) {}
    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}

    public void colisionar(Espinas e) {}
    public void colisionar(R2D2 r2) {}
    public void colisionar(RobotBarrera rb) {}
    public void colisionar(RobotPiso rp) {}

    public void colisionar(AgujeroNegro an) {}
    public void colisionar(Meteorito m) {}

    public void colisionar(Bomba b) {}
    public void colisionar(Escudo e) {}
    public void colisionar(Fuego f) {}
    public void colisionar(Fuerza f) {}


    public void recibirDmg(int dmg) {
        vida.recibirDmg(dmg);
    }

    public abstract void actualizar();

    public abstract void frenar();
    public void morir() {
        tableroJuego.delFromObjects(this);
    }
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

    public int costo() {
        return 0;
    }

    public abstract GameObject clone(int posX, int posY);

    public int distancia (GameObject go) {
        if (this.getY() == go.getY())
            return (int) Math.sqrt((go.getX()-this.getX())*(go.getX()-this.getX()) + (go.getY()-this.getY())*(go.getY()-this.getY()));
        else
            return Constantes.MAX_INF;
    }
}