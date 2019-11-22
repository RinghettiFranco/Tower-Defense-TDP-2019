package proyectiles;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import movimiento.MovimientoProyectil;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class ProyectilAliado extends Proyectil {

    public ProyectilAliado(int x, int y, int impacto,ImageIcon grafico) {
        super(1, 1*Constantes.ANCHO_CELDA, impacto, grafico);

        pos=new MovimientoProyectil(x,y, 1);
        this.setBounds(x, y, 100, 100);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.cuentaRegresiva = 10;
    }

    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}
    public void colisionar(Torre t) {}

    @Override
    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
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
