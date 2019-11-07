package torres;



import javax.swing.*;

import java.awt.*;

public class LukeSkywalker extends Torre {

    protected static ImageIcon standingLuke = new ImageIcon("src/Imagenes/StandingLuke.png");
    protected static ImageIcon attackingLuke = new ImageIcon("src/Imagenes/AttackingLuke.gif");

    public LukeSkywalker(int x, int y) {
        super(250, 50, 16, standingLuke);
        this.costo = 25;

        hitBox = new Rectangle(x, y, 40, 80);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);
    }

    @Override
    public Torre clone(int x, int y) {
        return new LukeSkywalker(x, y);
    }
}
