package enemigos;

import javax.swing.ImageIcon;

import armas.Proyectil;
import control_grafico.GameObject;
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
	public void colisionar(Torre t) {
		// TODO Auto-generated method stub
		System.out.println("Colisione con una torre");
	}

	@Override
	public void colisionar(Proyectil p) {
		// TODO Auto-generated method stub
		
	}
}
