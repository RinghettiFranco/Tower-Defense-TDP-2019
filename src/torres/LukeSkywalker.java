package torres;

import armas.Melee;

import javax.swing.*;
import java.awt.*;

public class LukeSkywalker extends Torre {

    protected static ImageIcon staindingLuke = new ImageIcon("src/Imagenes/Standing Luke Skywalker.png");
    protected static ImageIcon attackingLuke = new ImageIcon("src/Imagenes/Standing Luke Skywalker.png");

    public LukeSkywalker(int x, int y) {
        super(100, 1, 12, staindingLuke);

        golpe = new Melee();
        hitBox = new Rectangle(x, y, 25, 63);
        this.setBounds(hitBox);
    }
}
