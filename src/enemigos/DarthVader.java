package enemigos;

import armas.ArmaLaser;
import movimiento.MovimientoEnemigo;

import javax.swing.*;
import java.awt.*;

public class DarthVader extends Enemigo {

    private static ImageIcon walkingVader = new ImageIcon("");
    private static ImageIcon attackingVader = new ImageIcon("");

    public DarthVader(int x, int y) {
        super(350, 5, 29 ,walkingVader);
        pos = new MovimientoEnemigo(x, y);

        golpe = new ArmaLaser();

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }
}
