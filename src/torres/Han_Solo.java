package torres;

import javax.swing.ImageIcon;

public class Han_Solo extends Torre{
	
	protected ImageIcon shooting_animation;
	
	public Han_Solo(int x, int y){
		super(100, 2, 13, new ImageIcon("src/resources/img.jpg"));
		this.setBounds(x, y, 200, 200);
	}

	@Override
	public void actualizarPosicion(){}
}
