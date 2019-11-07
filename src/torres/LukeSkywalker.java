package torres;



import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.ProyectilEnemigo;

import javax.swing.*;

import java.awt.*;

public class LukeSkywalker extends Torre {

    protected static ImageIcon standingLuke = new ImageIcon("src/Imagenes/StandingLuke.png");
    protected static ImageIcon attackingLuke = new ImageIcon("src/Imagenes/AttackingLuke.gif");

    public LukeSkywalker(int x, int y) {
        super(250, 1*Constantes.ANCHO_CELDA, 16, standingLuke);
        this.costo = 25;

        hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 30;
    }

    @Override
    public Torre clone(int x, int y) {
        return new LukeSkywalker(x, y);
    }

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 30;
        }
        e.frenar();
    }
}
