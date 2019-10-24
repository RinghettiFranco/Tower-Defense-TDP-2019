package movimiento;

import java.awt.geom.Point2D;

public class Quieto extends Movimiento {

	public Quieto(int x, int y) {
		super(x, y);
	}

	public Point2D proximaPosicion() {
		return actual;
	}
}
