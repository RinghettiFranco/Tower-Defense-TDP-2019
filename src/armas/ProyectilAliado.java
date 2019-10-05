package armas;

import control_grafico.GameObject;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;


public class ProyectilAliado extends Proyectil {

	protected static ImageIcon proyectil = new ImageIcon("");

	public ProyectilAliado(int x, int y, int impacto) {
		super(1, 1, impacto, proyectil);
	}

	public void colisionar(Enemigo e) {
		e.recibirDmg(impacto);
	}

	public void colisionar(Torre t) {}

	@Override
	public void actualizarPosicion() {

	}

	@Override
	public void colisionar(GameObject go) {

	}
}
