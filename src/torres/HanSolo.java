package torres;



import javax.swing.ImageIcon;

import java.awt.*;

public class HanSolo extends Torre {

	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/ShootingHansolo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/StandingHanSolo.png");

	public HanSolo(int x, int y) {
		super(150, 300, 13, standing);
		this.costo = 12;

		hitBox = new Rectangle(x, y, 25, 63);
		this.setBounds(hitBox);

		tableroJuego.addToObjects(this);
	}

	@Override
	public Torre clone(int x, int y) {
		return new HanSolo(x, y);
	}
}
