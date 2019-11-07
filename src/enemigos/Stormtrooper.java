package enemigos;

import javax.swing.ImageIcon;

import control_logico.Constantes;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import movimiento.*;
import torres.Torre;

import java.awt.*;

public class Stormtrooper extends Enemigo {
	
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");
	protected int cuentaRegresiva;

	public Stormtrooper(int x, int y) {
		super(125, 3*Constantes.ANCHO_CELDA, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);

		hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
		this.setBounds(hitBox);

		cuentaRegresiva = 70;
		tableroJuego.addToObjects(this);

		this.cuentaRegresiva = 70;
	}

	public void colisionar(Torre t) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			tableroJuego.addToObjects(new ProyectilEnemigo(hitBox.x, hitBox.y, this.impacto));
			cuentaRegresiva = 70;
		}

		if (t.estaMuerto())
			pos = new MovimientoEnemigo(hitBox.x, hitBox.y);
	}
}
