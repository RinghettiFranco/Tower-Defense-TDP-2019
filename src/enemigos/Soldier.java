package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class Soldier extends Enemigo {

    protected static ImageIcon walkingDarthSidious = new ImageIcon("src/Imagenes/WSoldier.gif");
    protected static ImageIcon attackingDarthSidious = new ImageIcon("");

    public Soldier(int x, int y) {
        super(100, 1*Constantes.ANCHO_CELDA, 12, walkingDarthSidious);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 35;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 35;
        }
    }
}
