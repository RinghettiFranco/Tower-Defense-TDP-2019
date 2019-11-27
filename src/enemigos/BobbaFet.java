package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

public class BobbaFet extends Enemigo {

    protected static ImageIcon walkingBobbaFet = new ImageIcon("src/Imagenes/WBobbaFet.gif");
    protected static ImageIcon attackingBobbaFet = new ImageIcon("");

    public BobbaFet(int x, int y) {
        super(250, 1*Constantes.ANCHO_CELDA, 23, walkingBobbaFet);
        pos = new MovimientoEnemigo(x, y);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.cuentaRegresiva = 1*Constantes.SEGUNDO;
        this.puntaje = 7;

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 1*Constantes.SEGUNDO;
        }
    }
}
