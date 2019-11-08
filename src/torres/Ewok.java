package torres;



import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.ProyectilEnemigo;

import javax.swing.*;

import java.awt.*;

public class Ewok extends Torre {

    protected static ImageIcon standingEwok = new ImageIcon("src/Imagenes/StandingEwok.png");
    protected static ImageIcon attackingEwok = new ImageIcon("src/Imagenes/AttackingEwok.gif");

    public Ewok(int x, int y) {
        super(200, 1*Constantes.ANCHO_CELDA,  20, standingEwok);
        this.costo = 10;

        hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 65;
    }

    @Override
    public Torre clone(int x, int y) {
        return new Ewok(x, y);
    }

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 65;
        }
        e.frenar();
    }
}
