package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

public class BobbaFet extends Enemigo {

    protected static ImageIcon walkingBobbaFet = new ImageIcon("src/Imagenes/WBobbaFet.gif");
    protected static ImageIcon walkingBobbaFetEscudo = new ImageIcon("src/Imagenes/WBobbaEscudo.gif");

    public BobbaFet(int x, int y) {
        super(150, 1*Constantes.ANCHO_CELDA, 20, walkingBobbaFet);

        this.pos = new MovimientoEnemigo(x, y);
        this.cuentaRegresiva = 1*Constantes.SEGUNDO;
        this.puntaje = 7;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            if (escudo) {
                t.morir();
                this.setIcon(walkingBobbaFet);
                escudo = false;
            } else {
                t.recibirDmg(this.impacto);
                cuentaRegresiva = 1 * Constantes.SEGUNDO;
            }
        }
    }

    @Override
    public void aplicarEscudo() {
        escudo = true;
        this.setIcon(walkingBobbaFetEscudo);
    }
}
