package torres;

import armas.PistolaBlaster;

import javax.swing.*;
import java.awt.*;

public class Chewbaca extends Torre {

    protected static ImageIcon standingChewbaca = new ImageIcon("");
    protected static ImageIcon attackingChewbaca = new ImageIcon("");

    public Chewbaca(int x, int y) {
        super(200, 5,  22, standingChewbaca);

        golpe = new PistolaBlaster();

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }
}
