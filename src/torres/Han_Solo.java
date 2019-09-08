package torres;

import javax.swing.ImageIcon;

public class Han_Solo extends Torre {
	
	protected ImageIcon shooting_animation;
	
	public Han_Solo(int x, int y){
		super(100, 2, 13, new ImageIcon("src/Imagenes/Standing Han Solo.png"));
		this.setBounds(x, y, 25, 63);
	}

	@Override
	public void actualizarPosicion(){}
}
