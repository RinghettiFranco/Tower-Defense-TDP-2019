package enemigos;

import javax.swing.ImageIcon;

import proyectiles.ProyectilEnemigo;
import movimiento.*;
import torres.Torre;

import java.awt.*;

public class Stormtrooper extends Enemigo {
	
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");
	protected int cuentaRegresiva;

	public Stormtrooper(int x, int y) {
		super(100, 300, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);

		hitBox = new Rectangle(x, y, 33, 73);
		this.setBounds(hitBox);

		cuentaRegresiva = 70;
		tableroJuego.addToObjects(this);
	}

	@Override
	public void atacar(Torre t) {
		super.atacar(t);

		cuentaRegresiva--;
		if (cuentaRegresiva == 0) {
			tableroJuego.addToObjects(new ProyectilEnemigo(hitBox.x, hitBox.y, impacto));
			cuentaRegresiva = 70;
		}
	}
}
