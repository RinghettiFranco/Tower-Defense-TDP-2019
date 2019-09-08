package torres;

import javax.swing.ImageIcon;

public class Han_Solo extends Torre{
	
	protected ImageIcon shooting_animation;
	
	public Han_Solo(int vida, int alcance, int impacto, ImageIcon graphic, ImageIcon shooting_animation){
		super(vida, alcance, impacto, graphic);
	}

	@Override
	public void actualizarPosicion(){}
}
