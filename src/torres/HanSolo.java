package torres;



import javax.swing.ImageIcon;

import armas.Proyectil;
import enemigos.Enemigo;

import java.awt.*;

public class HanSolo extends Torre {
	
	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/Shooting Han solo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/Standing Han Solo.png");
	
	public HanSolo(int x, int y){
		super(100, 2, 13, standing);
		this.costo = 12;

		hitBox = new Rectangle(x, y, 25, 63);
		this.setBounds(hitBox);
	}

	@Override
	public Torre clone(int x, int y) {
		return new HanSolo(x, y);
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
