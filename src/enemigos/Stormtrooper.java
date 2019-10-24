package enemigos;

import javax.swing.ImageIcon;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import movimiento.*;
import torres.Torre;

import java.awt.*;

public class Stormtrooper extends Enemigo {
	
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");

	public Stormtrooper(int x, int y) {
		super(100, 2, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);


		hitBox = new Rectangle(x, y, 33, 73);
		this.setBounds(hitBox);
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
