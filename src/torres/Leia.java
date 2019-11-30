package torres;


import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.BalaAliado;

import javax.swing.*;

public class Leia extends Torre {

	protected static ImageIcon standingLeiaEscudo = new ImageIcon("src/Imagenes/standingLeiaEscudo.gif");
	protected static ImageIcon standingleia = new ImageIcon("src/Imagenes/standingLeia.png");

	public Leia(int x, int y) {
		super(150, 4*Constantes.ANCHO_CELDA, 16, standingleia);

		this.costo = 12;
		this.cuentaRegresiva = 2*Constantes.SEGUNDO;

		this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

		tableroJuego.addToObjects(this);
	}

	public void colisionar(Enemigo e) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			if (escudo) {
				e.morir();
				escudo = false;
				this.setIcon(standingleia);
			} else {
				if (distancia(e) >= Constantes.ANCHO_CELDA)
					tableroJuego.addToObjects(new BalaAliado(this.getX(), this.getY(), this.impacto));
				else {
					e.recibirDmg(3 * this.impacto / 4);
					e.frenar();
				}
			}
			cuentaRegresiva = 2*Constantes.SEGUNDO;
		}
		e.frenar();
	}

	@Override
	public void aplicarEscudo() {
		escudo = true;
		this.setIcon(standingLeiaEscudo);
	}
}
