package enemigos;

import javax.swing.ImageIcon;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import movimiento.*;
import torres.Torre;

import java.awt.*;

public class Stormtrooper extends Enemigo {
	
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");
	protected int cuentaRegresiva;

	public Stormtrooper(int x, int y) {
		super(125, 300, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);

		hitBox = new Rectangle(x, y, 100, 100);
		this.setBounds(hitBox);

		cuentaRegresiva = 70;
		tableroJuego.addToObjects(this);

		this.cuentaRegresiva = 70;
	}

	public void colisionar(Torre t) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			System.out.println("Intersecto con " + t.getClass());
			tableroJuego.addToObjects(new ProyectilEnemigo(hitBox.x, hitBox.y, this.impacto));
			cuentaRegresiva = 70;
		}
	}
}
