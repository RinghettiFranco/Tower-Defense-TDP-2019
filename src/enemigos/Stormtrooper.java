package enemigos;

import javax.swing.ImageIcon;
import movimiento.*;
import java.awt.geom.Point2D;
public class Stormtrooper extends Enemigo {
	
	protected Movimiento pos;
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");

	public Stormtrooper(int x, int y) {
		super(100, 2, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);
		this.setBounds(x, y, 33, 73);
		
	}

	@Override
	public void actualizarPosicion() {
	Point2D nueva=pos.proximaPosicion();
	int x=(int) nueva.getX();
	int y=(int) nueva.getY();
	this.setBounds(x,y,33,73);
		
	
	}
	
	

}
