package movimiento;

import java.awt.geom.Point2D;


public class MovimientoEnemigo extends Movimiento {

	
	public MovimientoEnemigo(int x,int y) {
		super(x, y);
	}

	public Point2D proximaPosicion() {
		actual.setLocation(actual.getX()-1,actual.getY());
		return actual;
	}

}
