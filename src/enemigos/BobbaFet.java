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

public class BobbaFet extends Enemigo {

    protected static ImageIcon walkingBobbaFet = new ImageIcon("");
    protected static ImageIcon attackingBobbaFet = new ImageIcon("");

    public BobbaFet(int x, int y) {
        super(19, 2, 20, walkingBobbaFet);
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
		// TODO Auto-generated method stub
		
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
