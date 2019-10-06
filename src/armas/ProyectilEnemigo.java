package armas;

import control_grafico.GameObject;
import control_logico.VisitorColision;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class ProyectilEnemigo extends Proyectil {

	protected static ImageIcon proyectil = new ImageIcon("");

	public ProyectilEnemigo(int x, int y, int impacto) {
		super(1, 1, impacto, proyectil);
	}

	@Override
	public void actualizarPosicion() {

	}

	@Override
	public void aceptar(VisitorColision vc) {
		vc.visit(this);
	}

	@Override
	public void colisionar(Torre t) {
		this.recibirDmg(t.obtenerImpacto());
	}

	@Override
	public void colisionar(Enemigo e) {}

	@Override
	public void colisionar(ProyectilAliado pa) {}

	@Override
	public void colisionar(ProyectilEnemigo pe) {}
}
