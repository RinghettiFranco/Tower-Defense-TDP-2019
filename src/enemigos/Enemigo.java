package enemigos;


import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.Visitor;
import movimiento.Movimiento;
import movimiento.MovimientoQuieto;
import torres.Torre;

import javax.swing.*;

import armas.Proyectil;

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

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void atacar(Torre t) {
        vida.recibirDmg(t.obtenerImpacto());
        this.frenar();
    }
    public void atacar(ProyectilAliado pa) {
        vida.recibirDmg(pa.obtenerImpacto());
    }

    public void atacar(Enemigo e) {}
    public void atacar(ProyectilEnemigo pe) {}

    protected void frenar() {
        pos = new MovimientoQuieto(hitBox.x, hitBox.y);
    }
}
