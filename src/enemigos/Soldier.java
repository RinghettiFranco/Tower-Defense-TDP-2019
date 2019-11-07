package enemigos;

import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

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
