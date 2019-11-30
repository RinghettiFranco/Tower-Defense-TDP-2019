package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

public class Soldier extends Enemigo {

    protected static ImageIcon walkingSoldier = new ImageIcon("src/Imagenes/WSoldier.gif");
    protected static ImageIcon walkingSoldierEscudo = new ImageIcon("src/Imagenes/WSoldierEscudo.gif");

    public Soldier(int x, int y) {
        super(150, 1*Constantes.ANCHO_CELDA, 12, walkingSoldier);

        this.pos = new MovimientoEnemigo(x, y);
        this.cuentaRegresiva = 1*Constantes.SEGUNDO;
        this.puntaje = 5;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

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
