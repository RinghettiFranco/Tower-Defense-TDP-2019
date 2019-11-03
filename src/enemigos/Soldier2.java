package enemigos;


import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

import armas.Proyectil;

import java.awt.*;

public class Soldier2 extends Enemigo {

    private static ImageIcon walkingSoldier2 = new ImageIcon("src/Imagenes/RunningE2.png");
    private static ImageIcon attackingSoldier2 = new ImageIcon("src/Imagenes/AttackingE2.png");

    public Soldier2(int x, int y) {
        super(350, 50, 29 ,walkingSoldier2);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 100, 100);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }
}
