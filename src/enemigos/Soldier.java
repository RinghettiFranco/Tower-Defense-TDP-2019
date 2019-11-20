package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class Soldier extends Enemigo {

    protected static ImageIcon walkingSoldier = new ImageIcon("src/Imagenes/WSoldier.gif");
    protected static ImageIcon attackingSoldier = new ImageIcon("");

    public Soldier(int x, int y) {
        super(100, 1*Constantes.ANCHO_CELDA, 12, walkingSoldier);
        pos = new MovimientoEnemigo(x, y);

        this.setBounds(x, y, 100, 100);

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
