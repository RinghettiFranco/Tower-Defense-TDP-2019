package movimiento;

import java.awt.geom.Point2D;

public class MovimientoCaida extends Movimiento {

    public MovimientoCaida(int x, int y) {
        actual = new Point2D.Double(x, y);
    }

    public Point2D proximaPosicion() {
        actual.setLocation(actual.getX(), actual.getY()+0.65);
        return actual;
    }
}
