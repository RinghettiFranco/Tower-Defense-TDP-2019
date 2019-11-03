package movimiento;

import java.awt.geom.Point2D;

public class MovimientoProyectil extends Movimiento {

    public MovimientoProyectil(int x, int y) {
        actual = new Point2D.Double(x, y);
    }

    @Override
    public Point2D proximaPosicion() {
        int nuevoX = (int) actual.getX() + 5;
        int nuevoY = (int) actual.getY();

        actual = new Point2D.Double(nuevoX, nuevoY);

        return actual;
    }
}
