package enemigos;

import javax.swing.ImageIcon;

import armas.Proyectil;
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
}
