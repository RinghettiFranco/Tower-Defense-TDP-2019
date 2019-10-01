package enemigos;

import armas.Melee;
import movimiento.MovimientoEnemigo;

import javax.swing.*;
import java.awt.*;

public class BobbaFet extends Enemigo {

    protected static ImageIcon walkingBobbaFet = new ImageIcon("");
    protected static ImageIcon attackingBobbaFet = new ImageIcon("");

    public BobbaFet(int x, int y) {
        super(19, 2, 20, walkingBobbaFet);
        pos = new MovimientoEnemigo(x, y);

        golpe = new Melee();

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }
}
