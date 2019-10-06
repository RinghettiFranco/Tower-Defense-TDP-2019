package enemigos;

import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.VisitorColision;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

import armas.Proyectil;

import java.awt.*;

public class DarthSidious extends Enemigo {

    protected static ImageIcon walkingDarthSidious = new ImageIcon("");
    protected static ImageIcon attackingDarthSidious = new ImageIcon("");

    public DarthSidious(int x, int y) {
        super(400, 1, 33, walkingDarthSidious);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }

    @Override
    public void aceptar(VisitorColision vc) {
        vc.visit(this);
    }

    @Override
    public void colisionar(Torre t) {
        this.recibirDmg(t.obtenerImpacto());
    }

    @Override
    public void colisionar(Enemigo e) {}

    @Override
    public void colisionar(ProyectilAliado pa) {
        this.recibirDmg(pa.obtenerImpacto());
    }

    @Override
    public void colisionar(ProyectilEnemigo pe) {}
}
