package enemigos;

import javax.swing.ImageIcon;

import armas.Proyectil;
import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.VisitorColision;
import movimiento.*;
import torres.Torre;

import java.awt.*;
import java.awt.geom.Point2D;

public class Stormtrooper extends Enemigo {
	
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");

	public Stormtrooper(int x, int y) {
		super(100, 2, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);


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
		this.frenar();
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
