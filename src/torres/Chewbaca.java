package torres;



import javax.swing.*;

import armas.Proyectil;
import enemigos.Enemigo;

import java.awt.*;

public class Chewbaca extends Torre {

    protected static ImageIcon standingChewbaca = new ImageIcon("");
    protected static ImageIcon attackingChewbaca = new ImageIcon("");

    public Chewbaca(int x, int y) {
        super(200, 5,  22, standingChewbaca);
        this.costo = 10;

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }

    @Override
    public Torre clone(int x, int y) {
        return new Chewbaca(x, y);
    }

    @Override
	public void colisionar(Enemigo e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colisionar(Proyectil p) {
		// TODO Auto-generated method stub
	}
}
