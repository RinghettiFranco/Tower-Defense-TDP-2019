package enemigos;

import movimiento.MovimientoEnemigo;

import javax.swing.*;
import java.awt.*;

public class DarthSidious extends Enemigo {

    protected static ImageIcon walkingDarthSidious = new ImageIcon("");
    protected static ImageIcon attackingDarthSidious = new ImageIcon("");

    public DarthSidious(int x, int y) {
        super(400, 1, 33, walkingDarthSidious);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }
}
