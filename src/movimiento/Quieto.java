package movimiento;

import java.awt.geom.Point2D;

public class Quieto extends Movimiento {

	protected Point2D actual;

	public Quieto(int x, int y) {
		actual = new Point2D.Double(x, y);
	}

	public Point2D proximaPosicion() {
		return actual;
	}
}
