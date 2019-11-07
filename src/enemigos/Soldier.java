package enemigos;

import movimiento.MovimientoEnemigo;

import javax.swing.*;

import java.awt.*;

public class Soldier extends Enemigo {

    protected static ImageIcon walkingDarthSidious = new ImageIcon("src/Imagenes/WSoldier.gif");
    protected static ImageIcon attackingDarthSidious = new ImageIcon("");

    public Soldier(int x, int y) {
        super(100, 50, 12, walkingDarthSidious);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }
}
