package armas;

import control_grafico.GameObject;
import torres.Torre;


public class ProyectilAliado implements Proyectil {

	protected static ImageIcon proyectil = new IconImage("");

	public ProyectilAliado(int x, int y, int impacto) {
		super(1, 1, impacto, proyectil);
	}

	public void colisionar(Enemigo e) {
		e.recibirDmg(impacto);
	}

	public void colisionar(Torre t) {}
}
