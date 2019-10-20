package proyectiles;

import control_logico.Visitor;
import control_logico.VisitorColision;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;


public class ProyectilAliado extends Proyectil {

	protected static ImageIcon proyectil = new ImageIcon("");

	public ProyectilAliado(int x, int y, int impacto) {
		super(1, 1, impacto, proyectil);
	}

	@Override
	public void actualizarPosicion() {

	}

	public void aceptar(Visitor v) {
		v.visit(this);
	}

	@Override
	public void colisionar(Torre t) {}

	@Override
	public void colisionar(Enemigo e) {
		this.recibirDmg(e.obtenerImpacto());
	}

	@Override
	public void colisionar(ProyectilAliado pa) {}

	@Override
	public void colisionar(ProyectilEnemigo pe) {}
}
