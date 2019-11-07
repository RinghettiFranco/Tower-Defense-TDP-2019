package enemigos;


import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilAliado;
import torres.Torre;

import javax.swing.*;

import java.awt.*;

public class DarthVader extends Enemigo {

    private static ImageIcon walkingVader = new ImageIcon("src/Imagenes/WDarthVader.gif");
    private static ImageIcon attackingVader = new ImageIcon("");

    public DarthVader(int x, int y) {
        super(350, 1*Constantes.ANCHO_CELDA, 29 ,walkingVader);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 30;
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = 30;
        }
    }
}
