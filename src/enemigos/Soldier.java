package enemigos;

import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

import armas.Proyectil;

import java.awt.*;

public class Soldier extends Enemigo {

    protected static ImageIcon walkingDarthSidious = new ImageIcon("src/Imagenes/WSoldier.gif");
    protected static ImageIcon attackingDarthSidious = new ImageIcon("");

    public Soldier(int x, int y) {
        super(400, 1, 33, walkingDarthSidious);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }
}
