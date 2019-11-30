package torres;

import control_logico.Constantes;
import enemigos.Enemigo;

import javax.swing.*;

public class LukeSkywalker extends Torre {

    protected static ImageIcon standingLuke = new ImageIcon("src/Imagenes/StandingLuke.png");
    protected static ImageIcon attackingLuke = new ImageIcon("src/Imagenes/luke.gif");
    protected static ImageIcon standingLukeEscudo = new ImageIcon("src/Imagenes/StandingLukeEscudo");
    public LukeSkywalker(int x, int y) {
        super(350, 1*Constantes.ANCHO_CELDA, 33, standingLuke);

        this.costo = 25;
        this.cuentaRegresiva = Constantes.SEGUNDO/2;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            if (escudo) {
                e.morir();
                escudo = false;
                this.setIcon(standingLuke);
            } else
                e.recibirDmg(this.impacto);
            cuentaRegresiva = Constantes.SEGUNDO/2;
        }
        e.frenar();
    }

    @Override
    public void aplicarEscudo() {
        escudo = true;
        this.setIcon(standingLukeEscudo);
    }
}
