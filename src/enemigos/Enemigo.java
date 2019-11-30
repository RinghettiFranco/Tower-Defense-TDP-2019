package enemigos;

import control_grafico.GameObject;
import control_logico.Constantes;
import control_logico.Escudo;
import control_logico.Grilla;
import control_logico.SinEscudo;
import control_logico.Visitor;
import movimiento.Movimiento;
import premios.Bomba;
import premios.Fuego;
import premios.Fuerza;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.Random;

public abstract class Enemigo extends GameObject {

    protected boolean frenado;
    protected static Grilla miGrilla;

    private Random rnd;

    protected int cuentaRegresiva;
    protected Movimiento pos;

    public Enemigo(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
        rnd = new Random(System.currentTimeMillis());
        int ran = rnd.nextInt(5);

        this.frenado = false;

        if(ran==1) {this.cambiarEstado();}
    }

    public static void setGrilla(Grilla g) {
        miGrilla = g;
    }

    public void actualizar() {
        if (this.vida.obtenerVida() <= 0)
            morir();
        else {
            int posX = getX() - (getX() % Constantes.ANCHO_CELDA);
            int posY = getY() - (getY() % Constantes.ALTO_CELDA);

            if (posX < Constantes.VENTANA_ANCHO && posY < Constantes.PANEL_JUEGO_ALTO)
                if (!miGrilla.estaOcupada(posX / Constantes.ANCHO_CELDA, posY / Constantes.ALTO_CELDA) && frenado)
                    frenado = false;

            if (!frenado) {
                Point2D nueva = pos.proximaPosicion();
                this.setBounds((int) nueva.getX(), (int) nueva.getY(), Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
            }
        }
    }

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void morir() {
        int rand = rnd.nextInt() % 2;

        inventario.actualizarOro(this.oro);
        puntos.actualizarPuntaje(puntaje);
        super.morir();

        // Ponemos un premio en el mapa con un
        // 10% de probabilidad de aparicion
        if (rand == 1) {
            rnd.setSeed(System.currentTimeMillis());
            int randPosX = rnd.nextInt(Constantes.VENTANA_ANCHO);
            int randPosY = rnd.nextInt(Constantes.PANEL_JUEGO_ALTO);
            int x = (randPosX - (randPosX % Constantes.ANCHO_CELDA));
            int y = (randPosY - (randPosY % Constantes.ALTO_CELDA));

            rand = rnd.nextInt() % 4;
            switch (rand) {
                case 0:
                    tableroJuego.addToObjects(new Bomba(x, y));
                    break;
                case 1:
                    tableroJuego.addToObjects(new premios.Escudo(x, y));
                    break;
                case 2:
                    tableroJuego.addToObjects(new Fuego(x, y));
                    break;
                case 3:
                    tableroJuego.addToObjects(new Fuerza(x, y));
                    break;
            }
        }
    }

    public void frenar() {
        this.frenado = true;
    }
}