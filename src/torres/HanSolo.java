package torres;



import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;

import javax.swing.ImageIcon;

import java.awt.*;

public class HanSolo extends Torre {

	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/ShootingHansolo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/StandingHanSolo.png");

	public HanSolo(int x, int y) {
		super(150, 300, 13, standing);
		this.costo = 12;

		hitBox = new Rectangle(x, y, 25, 63);
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
			this.setIcon(shooting);
			System.out.println("Pone un disparo... han solo");
			cuentaRegresiva = 35;
		} else
			this.setIcon(standing);

	}
}
