package enemigos;


import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class DarthVader extends Enemigo {

    private static ImageIcon walkingVader = new ImageIcon("src/Imagenes/WDarthVader.gif");
    private static ImageIcon attackingVader = new ImageIcon("");

    public DarthVader(int x, int y) {
        super(350, 50, 29 ,walkingVader);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 60, 80);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 30;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 30;
            pos = new MovimientoEnemigo(hitBox.x, hitBox.y);
        }
    }
}
