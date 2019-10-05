package armas;

import control_grafico.GameObject;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class ProyectilEnemigo extends Proyectil {

	protected static ImageIcon proyectil = new ImageIcon("");

	public ProyectilEnemigo(int x, int y, int impacto) {
		super(1, 1, impacto, proyectil);
	}

	public void colisionar(Enemigo e) {}

	public void colisionar(Torre t) {
		t.recibirDmg(impacto);
	}
}
