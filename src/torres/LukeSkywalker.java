package torres;



import javax.swing.*;

import armas.Proyectil;
import enemigos.Enemigo;

import java.awt.*;

public class LukeSkywalker extends Torre {

    protected static ImageIcon standingLuke = new ImageIcon("src/Imagenes/StandingLuke.png");
    protected static ImageIcon attackingLuke = new ImageIcon("src/Imagenes/AttackingLuke.gif");

    public LukeSkywalker(int x, int y) {
        super(100, 1, 12, standingLuke);
        this.costo = 25;

        hitBox = new Rectangle(x, y, 40, 80);
        this.setBounds(hitBox);
    }

    @Override
    public Torre clone(int x, int y) {
        return new LukeSkywalker(x, y);
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
