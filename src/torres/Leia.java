package torres;



import enemigos.Enemigo;
import proyectiles.ProyectilEnemigo;

import javax.swing.ImageIcon;

import java.awt.*;

public class Leia extends Torre {

	protected static ImageIcon shootingleia = new ImageIcon("src/Imagenes/leia100.png");
	protected static ImageIcon standingleia = new ImageIcon("src/Imagenes/standingLeia.png");

	public Leia(int x, int y) {
		super(150, 300, 13, standingleia);
		this.costo = 12;

		hitBox = new Rectangle(x, y, 100, 100);
		this.setBounds(hitBox);

		tableroJuego.addToObjects(this);

		this.cuentaRegresiva = 35;
	}

	@Override
	public Torre clone(int x, int y) {
		return new Leia(x, y);
	}

	public void colisionar(Enemigo e) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			e.recibirDmg(this.impacto);
			cuentaRegresiva = 35;
		}

	}
}
