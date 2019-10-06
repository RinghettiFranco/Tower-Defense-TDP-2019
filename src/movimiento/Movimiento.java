package movimiento;

import java.awt.geom.Point2D;

public abstract class Movimiento {

    Point2D actual;

    public Movimiento(int x, int y) {
        actual = new Point2D.Double(x, y);
    }

    public abstract Point2D proximaPosicion();

    public Point2D posicionActual() {
        return actual;
    }
}
