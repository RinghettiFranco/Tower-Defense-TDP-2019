package torres;


import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.BalaAliado;

import javax.swing.*;

public class HanSolo extends Torre {

	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/ShootingHanSolo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/StandingHanSolo.png");

	public HanSolo(int x, int y) {
		super(170, 3*Constantes.ANCHO_CELDA, 17, standing);

		this.costo = 12;
		this.cuentaRegresiva = 1*Constantes.SEGUNDO;

		this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

		tableroJuego.addToObjects(this);
	}

	@Override
	public Torre clone(int x, int y) {
		return new HanSolo(x, y);
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
			cuentaRegresiva = 1*Constantes.SEGUNDO;
		}
	}
}
