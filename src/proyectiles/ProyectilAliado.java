package proyectiles;

import control_logico.Visitor;
import enemigos.Enemigo;
import movimiento.MovimientoProyectil;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class ProyectilAliado extends Proyectil {

    protected static ImageIcon grafico = new ImageIcon("src/Imagenes/dispEnemigo1.png");

    public ProyectilAliado(int x, int y, int impacto) {
        super(1, 25, impacto, grafico);

        pos=new MovimientoProyectil(x,y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }

    @Override
    public void colisionar(Enemigo e) {
        e.recibirDmg(this.impacto);
        //this.morir();
    }

    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}
    public void colisionar(Torre t) {}

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
