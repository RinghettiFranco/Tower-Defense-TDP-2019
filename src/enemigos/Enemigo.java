package enemigos;


import control_grafico.TableroJuego;
import premios.Oro;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.Visitor;
import movimiento.Movimiento;
import movimiento.MovimientoQuieto;
import torres.Torre;

import javax.swing.*;

import java.awt.geom.Point2D;
import java.util.Random;

public abstract class Enemigo extends GameObject {

    protected int cuentaRegresiva;
    protected Movimiento pos;

    public Enemigo(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
        this.setBounds(60,60,25, 63);
    }

    public void actualizarPosicion() {
        Point2D nueva=pos.proximaPosicion();
        int x=(int) nueva.getX();
        int y=(int) nueva.getY();

        hitBox.setBounds(x,y,100, 100);
        this.setBounds(hitBox);
    }

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void morir() {
        tableroJuego.addToObjects(new Oro(hitBox.x, hitBox.y, oro));
        tableroJuego.delFromObjects(this);
        // TODO Sumar puntos
    }

    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilEnemigo pe) {}

    public void colisionar(ProyectilAliado pa) {
        pa.morir();
    }

    protected void frenar() {
        pos = new MovimientoQuieto(hitBox.x, hitBox.y);
    }
}
