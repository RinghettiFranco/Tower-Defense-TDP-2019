package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

public class Soldier extends Enemigo {

    protected static ImageIcon walkingSoldier = new ImageIcon("src/Imagenes/WSoldier.gif");
    protected static ImageIcon attackingSoldier = new ImageIcon("");

    public Soldier(int x, int y) {
        super(100, 1*Constantes.ANCHO_CELDA, 12, walkingSoldier);
        pos = new MovimientoEnemigo(x, y);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 1*Constantes.SEGUNDO;
        this.puntaje = 5;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 35;
        }
    }
}
