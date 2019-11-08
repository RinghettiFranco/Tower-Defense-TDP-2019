package torres;



import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;

import javax.swing.ImageIcon;

import java.awt.*;

public class HanSolo extends Torre {

	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/ShootingHansolo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/StandingHanSolo.png");

	public HanSolo(int x, int y) {
		super(150, 3*Constantes.ANCHO_CELDA, 15, standing);
		this.costo = 12;

		hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
		this.setBounds(hitBox);

		tableroJuego.addToObjects(this);

		this.cuentaRegresiva = 35;
	}

	@Override
	public Torre clone(int x, int y) {
		return new HanSolo(x, y);
	}

	public void colisionar(Enemigo e) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			if (distancia(hitBox, e.getBounds()) >= Constantes.ANCHO_CELDA)
				tableroJuego.addToObjects(new ProyectilAliado(hitBox.x, hitBox.y, this.impacto));
			else {
				e.recibirDmg(3 * this.impacto / 4);
				e.frenar();
			}
			cuentaRegresiva = 35;
		}
	}
}
