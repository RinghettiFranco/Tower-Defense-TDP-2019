package movimiento;

import java.awt.geom.Point2D;

public class MovimientoQuieto extends Movimiento {

    public MovimientoQuieto(int x, int y) {
        actual = new Point2D.Double(x, y);
    }

    @Override
    public Point2D proximaPosicion() {
        return actual;
    }
}
