package enemigos;

import control_grafico.GameObject;
import movimiento.MovimientoEnemigo;
import torres.Torre;

import javax.swing.*;

import armas.Proyectil;

import java.awt.*;

public class DarthSidious extends Enemigo {

    protected static ImageIcon walkingDarthSidious = new ImageIcon("");
    protected static ImageIcon attackingDarthSidious = new ImageIcon("");

    public DarthSidious(int x, int y) {
        super(400, 1, 33, walkingDarthSidious);
        pos = new MovimientoEnemigo(x, y);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }

	@Override
	public void colisionar(Torre t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionar(Proyectil p) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void colisionar(GameObject go) {
    }
}
