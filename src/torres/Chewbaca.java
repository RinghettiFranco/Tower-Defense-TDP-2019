package torres;



import control_logico.Constantes;
import enemigos.Enemigo;

import javax.swing.*;

public class Chewbaca extends Torre {

    protected static ImageIcon standingChewbaca = new ImageIcon("src/Imagenes/StandingChewbaca.png");
    protected static ImageIcon attackingChewbaca = new ImageIcon("src/Imagenes/AttackingChewbaca.gif");

    public Chewbaca(int x, int y) {
        super(220, 1*Constantes.ANCHO_CELDA,  22, standingChewbaca);

        this.costo = 10;
        this.cuentaRegresiva = 2*Constantes.SEGUNDO;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    @Override
    public Torre clone(int x, int y) {
        return new Chewbaca(x, y);
    }

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 2*Constantes.SEGUNDO;
        }
        e.frenar();
    }
}