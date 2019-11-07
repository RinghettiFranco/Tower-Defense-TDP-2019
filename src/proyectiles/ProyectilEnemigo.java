package proyectiles;

import control_logico.Visitor;
import enemigos.Enemigo;
import movimiento.MovimientoEnemigo;
import movimiento.MovimientoProyectil;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class ProyectilEnemigo extends Proyectil {

    protected static ImageIcon grafico = new ImageIcon("src/Imagenes/disp3.png");

    public ProyectilEnemigo(int x, int y, int impacto) {
        super(1, 10, impacto, grafico);

        pos=new MovimientoProyectil(x,y, -1);

        hitBox = new Rectangle(x, y, 100, 100);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 35;
    }

    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}

    @Override
    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
        }
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
