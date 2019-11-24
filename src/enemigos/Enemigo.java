package enemigos;


import control_grafico.GameObject;
import control_logico.Escudo;
import control_logico.Visitor;
import movimiento.Movimiento;
import movimiento.MovimientoQuieto;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.Random;

public abstract class Enemigo extends GameObject {

    protected int cuentaRegresiva;
    protected Movimiento pos;

    public Enemigo(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
        this.setBounds(60,60,25, 63);
        
        Random rnd = new Random(System.currentTimeMillis());
        int ran = rnd.nextInt(20);
        
        if(ran==10)this.vida=new Escudo(vida);
    }

    public void actualizar() {
        if (this.vida.obtenerVida() <= 0)
            morir();
        else {
            Point2D nueva = pos.proximaPosicion();
            int x = (int) nueva.getX();
            int y = (int) nueva.getY();

            this.setBounds(x, y, 100, 100);
        }
    }

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void morir() {
        inventario.actualizarOro(this.oro);
        tableroJuego.delFromObjects(this);
        // TODO Sumar puntos
    }

    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilEnemigo pe) {}

    public void colisionar(ProyectilAliado pa) {
        //pa.morir();
    }

    public void frenar() {
        pos = new MovimientoQuieto(this.getX(), this.getY());
    }

    public Enemigo clone(int posX, int posY) {
        return null;
    }
}
