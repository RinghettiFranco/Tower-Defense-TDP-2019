package movimiento;

import java.awt.geom.Point2D;


public class MovimientoEnemigo extends Movimiento {

	public MovimientoEnemigo(int x,int y) {
		actual=new Point2D.Double(x,y);	
	}
	
	
	public Point2D proximaPosicion() {
		actual.setLocation(actual.getX()-0.65,actual.getY());
		return actual;
	}

}
