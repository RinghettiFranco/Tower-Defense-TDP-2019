package torres;

import armas.PistolaBlaster;

import javax.swing.ImageIcon;
import java.awt.*;

public class HanSolo extends Torre {
	
	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/Shooting Han solo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/Standing Han Solo.png");
	
	public HanSolo(int x, int y){
		super(100, 2, 13, standing);

		golpe = new PistolaBlaster();
		hitBox = new Rectangle(x, y, 25, 63);
		this.setBounds(hitBox);
	}
}
