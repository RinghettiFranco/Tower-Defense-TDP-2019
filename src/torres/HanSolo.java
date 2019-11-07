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
		super(150, (int) (3.5*Constantes.ANCHO_CELDA), 15, standing);
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
			tableroJuego.addToObjects(new ProyectilAliado(hitBox.x, hitBox.y, this.impacto));
			cuentaRegresiva = 35;
		}
		e.frenar();
	}
}
