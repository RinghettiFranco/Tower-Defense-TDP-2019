package enemigos;

import movimiento.MovimientoEnemigo;

import javax.swing.*;

import java.awt.*;

public class BobbaFet extends Enemigo {

    protected static ImageIcon walkingBobbaFet = new ImageIcon("src/Imagenes/WBobbaFet.gif");
    protected static ImageIcon attackingBobbaFet = new ImageIcon("");

    public BobbaFet(int x, int y) {
        super(150, 50, 20, walkingBobbaFet);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }
}
