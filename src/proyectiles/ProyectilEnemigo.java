package proyectiles;

import control_logico.Visitor;
import enemigos.Enemigo;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class ProyectilEnemigo extends Proyectil {

    protected static ImageIcon grafico = new ImageIcon("src/Imagenes/disp1.png");

    public ProyectilEnemigo(int x, int y, int impacto) {
        super(1, 25, impacto, grafico);

        pos=new MovimientoEnemigo(x,y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}

    @Override
    public void colisionar(Torre t) {
        t.recibirDmg(this.impacto);
        //this.morir();
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    @Override
    public void actualizarPosicion() {
        Point2D nueva=pos.proximaPosicion();
        int x=(int) nueva.getX();
        int y=(int) nueva.getY();

        hitBox.setBounds(x,y,33,73);
        this.setBounds(hitBox);
    }
}
