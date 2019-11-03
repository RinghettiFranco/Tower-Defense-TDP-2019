package armas;

import control_logico.Visitor;
import enemigos.Enemigo;
import movimiento.MovimientoEnemigo;
import movimiento.MovimientoProyectil;
import torres.Torre;

import javax.swing.*;
import java.awt.*;

public class ProyectilAliado extends Proyectil {

    protected static ImageIcon grafico = new ImageIcon("");

    public ProyectilAliado(int x, int y, int impacto) {
        super(1, 25, impacto, grafico);

        pos=new MovimientoProyectil(x,y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }

    @Override
    public void atacar(Enemigo e) {

    }

    @Override
    public void atacar(ProyectilAliado pa) {}

    @Override
    public void atacar(ProyectilEnemigo pe) {}

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    @Override
    public void atacar(Torre t) {}


    @Override
    public void actualizarPosicion() {

    }
}
