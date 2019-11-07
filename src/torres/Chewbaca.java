package torres;



import enemigos.Enemigo;
import proyectiles.ProyectilEnemigo;

import javax.swing.*;

import java.awt.*;

public class Chewbaca extends Torre {

    protected static ImageIcon standingChewbaca = new ImageIcon("src/Imagenes/StandingChewbaca.png");
    protected static ImageIcon attackingChewbaca = new ImageIcon("src/Imagenes/AttackingChewbaca.gif");

    public Chewbaca(int x, int y) {
        super(200, 50,  20, standingChewbaca);
        this.costo = 10;

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 45;
    }

    @Override
    public Torre clone(int x, int y) {
        return new Chewbaca(x, y);
    }

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 45;
        }

    }
}
