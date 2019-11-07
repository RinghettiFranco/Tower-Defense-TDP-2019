package proyectiles;

import control_logico.Visitor;
import enemigos.Enemigo;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;

public class ProyectilEnemigo extends Proyectil {

    protected static ImageIcon grafico = new ImageIcon("");

    public ProyectilEnemigo(int x, int y, int impacto) {
        super(1, 25, impacto, null);

        pos=new MovimientoEnemigo(x,y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }

    @Override
    public void atacar(Enemigo e) {

    }

    @Override
    public void atacar(ProyectilAliado pa) {

    }

    @Override
    public void atacar(ProyectilEnemigo pe) {

    }

    @Override
    public void atacar(Torre t) {

    }

    @Override
    public void aceptar(Visitor v) {

    }

    @Override
    public void actualizarPosicion() {

    }
}
