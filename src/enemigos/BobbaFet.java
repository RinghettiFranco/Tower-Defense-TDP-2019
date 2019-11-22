package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class BobbaFet extends Enemigo {

    protected static ImageIcon walkingBobbaFet = new ImageIcon("src/Imagenes/WBobbaFet.gif");
    protected static ImageIcon attackingBobbaFet = new ImageIcon("");

    public BobbaFet(int x, int y) {
        super(150, 1*Constantes.ANCHO_CELDA, 20, walkingBobbaFet);
        pos = new MovimientoEnemigo(x, y);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 1*Constantes.SEGUNDO;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 35;
        }
    }
}
