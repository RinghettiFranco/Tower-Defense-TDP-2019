package enemigos;


import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class Soldier2 extends Enemigo {

    private static ImageIcon walkingSoldier2 = new ImageIcon("src/Imagenes/RunningE2.gif");
    private static ImageIcon attackingSoldier2 = new ImageIcon("src/Imagenes/AttackingE2.gif");

    public Soldier2(int x, int y) {
        super(100, 2*Constantes.ANCHO_CELDA, 12, walkingSoldier2);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 35;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            tableroJuego.addToObjects(new ProyectilEnemigo(hitBox.x, hitBox.y, this.impacto));
            cuentaRegresiva = 35;
        }
    }
}
