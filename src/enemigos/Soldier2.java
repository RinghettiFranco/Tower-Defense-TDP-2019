package enemigos;


import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class Soldier2 extends Enemigo {

    private static ImageIcon walkingSoldier2 = new ImageIcon("src/Imagenes/RunningE2.png");
    private static ImageIcon attackingSoldier2 = new ImageIcon("src/Imagenes/AttackingE2.png");

    public Soldier2(int x, int y) {
        super(100, 50, 12, walkingSoldier2);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 100, 100);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 35;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 35;
            pos = new MovimientoEnemigo(hitBox.x, hitBox.y);
        }
    }
}
