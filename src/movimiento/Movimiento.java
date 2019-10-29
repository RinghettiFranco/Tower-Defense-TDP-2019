package movimiento;

import java.awt.geom.Point2D;

public abstract class Movimiento {
    Point2D actual;

    public abstract Point2D proximaPosicion();
}
