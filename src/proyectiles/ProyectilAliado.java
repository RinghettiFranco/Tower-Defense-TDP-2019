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
        super(1, 10, impacto, grafico);

        pos=new MovimientoProyectil(x,y, 1);

        hitBox = new Rectangle(x, y, 100, 100);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 35;
    }

    @Override
    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
        }
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
