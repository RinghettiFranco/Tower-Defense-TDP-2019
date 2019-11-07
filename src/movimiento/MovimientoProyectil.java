package movimiento;

import java.awt.geom.Point2D;

public class MovimientoProyectil extends Movimiento {

    protected int dir;

    public MovimientoProyectil(int x, int y, int dir) {
        actual = new Point2D.Double(x, y);

        if (dir > 0)
            this.dir = 5;
        else if (dir < 0)
            this.dir = -5;
        else
            System.exit(32);
    }

    @Override
    public Point2D proximaPosicion() {
        int nuevoX = (int) actual.getX() + dir;
        int nuevoY = (int) actual.getY();

        actual = new Point2D.Double(nuevoX, nuevoY);

        return actual;
    }
}
