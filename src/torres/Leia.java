package torres;

import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.BalaAliado;

import javax.swing.*;

public class Leia extends Torre {

	protected static ImageIcon shootingleia = new ImageIcon("src/Imagenes/leia100.png");
	protected static ImageIcon standingleia = new ImageIcon("src/Imagenes/standingLeia.png");

	public Leia(int x, int y) {
		super(250, 4*Constantes.ANCHO_CELDA, 20, standingleia);
		this.costo = 12;

		this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

		tableroJuego.addToObjects(this);

		this.cuentaRegresiva = 2*Constantes.SEGUNDO;
	}

	public void colisionar(Enemigo e) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			if (distancia(e) >= Constantes.ANCHO_CELDA)
				tableroJuego.addToObjects(new BalaAliado(this.getX(), this.getY(), this.impacto));
			else {
				e.recibirDmg(3 * this.impacto / 4);
				e.frenar();
			}
			cuentaRegresiva = 2*Constantes.SEGUNDO;
		}
	}

	@Override
	public Torre clone(int x, int y) {
		return new Leia(x, y);
	}
}
