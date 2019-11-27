package enemigos;


import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

public class DarthVader extends Enemigo {

    private static ImageIcon walkingVader = new ImageIcon("src/Imagenes/WDarthVader.gif");
    private static ImageIcon attackingVader = new ImageIcon("");

    public DarthVader(int x, int y) {
        super(350, 1*Constantes.ANCHO_CELDA, 35 ,walkingVader);
        pos = new MovimientoEnemigo(x, y);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.cuentaRegresiva = Constantes.SEGUNDO/2;
        this.puntaje = 15;

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            t.recibirDmg(this.impacto);
            cuentaRegresiva = Constantes.SEGUNDO/2;
        }
    }
}
