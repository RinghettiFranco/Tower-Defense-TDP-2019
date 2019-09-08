package torres;

import javax.swing.ImageIcon;

public class Han_Solo extends Torre {
	
	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/Shooting Han solo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/Standing Han Solo.png");
	
	public Han_Solo(int x, int y){
		super(100, 2, 13, standing);
		this.setBounds(x, y, 25, 63);
	}

	@Override
	public void actualizarPosicion(){}
}
