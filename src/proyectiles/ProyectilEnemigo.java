package proyectiles;

import control_logico.Constantes;
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
        super(1, 1*Constantes.ANCHO_CELDA, impacto, grafico);

        pos=new MovimientoProyectil(x,y, -1);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 10;
    }

    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}

    @Override
    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            this.morir();
        }
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    @Override
    public void actualizar() {
        Point2D nueva = pos.proximaPosicion();
        int x = (int) nueva.getX();
        int y = (int) nueva.getY();

        this.setBounds(x, y, 100, 100);
    }
}
