package enemigos;


import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

import armas.Proyectil;

import java.awt.*;

public class DarthVader extends Enemigo {

    private static ImageIcon walkingVader = new ImageIcon("src/Imagenes/WDarthVader.gif");
    private static ImageIcon attackingVader = new ImageIcon("");

    public DarthVader(int x, int y) {
        super(350, 5, 29 ,walkingVader);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 60, 80);
        this.setBounds(hitBox);
    }
}
