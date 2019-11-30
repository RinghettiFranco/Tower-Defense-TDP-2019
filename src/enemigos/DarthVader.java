package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

public class DarthVader extends Enemigo {

    private static ImageIcon walkingVader = new ImageIcon("src/Imagenes/WalkingVader.gif");
    private static ImageIcon walkingVaderEscudo = new ImageIcon("src/Imagenes/WalkingVaderEscudo.gif");

    public DarthVader(int x, int y) {
        super(450, 1 * Constantes.ANCHO_CELDA, 40, walkingVader);

        this.pos = new MovimientoEnemigo(x, y);
        this.cuentaRegresiva = (int) 0.9 * Constantes.SEGUNDO;
        this.puntaje = 15;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);

    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            if (escudo) {
                t.morir();
                this.setIcon(walkingVader);
                escudo = false;
            } else {
                t.recibirDmg(this.impacto);
                cuentaRegresiva = Constantes.SEGUNDO/2;
            }
        }
    }

    @Override
    public void aplicarEscudo() {
        escudo = true;
        this.setIcon(walkingVaderEscudo);
    }
}
