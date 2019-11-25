package enemigos;

import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

public class Stormtrooper extends Enemigo {
	
	protected static ImageIcon runningGif = new ImageIcon("src/Imagenes/Stormtrooper.gif");
	protected int cuentaRegresiva;

	public Stormtrooper(int x, int y) {
		super(125, 3*Constantes.ANCHO_CELDA, 13, runningGif);
		pos=new MovimientoEnemigo(x,y);

		this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

		cuentaRegresiva = 70;
		tableroJuego.addToObjects(this);

		this.cuentaRegresiva = 2*Constantes.SEGUNDO;
		this.puntaje = 3;
	}

	public void colisionar(Torre t) {
		cuentaRegresiva--;

		if (cuentaRegresiva == 0) {
			if (distancia(t) >= Constantes.ANCHO_CELDA)
				tableroJuego.addToObjects(new ProyectilEnemigo(this.getX(), this.getY(), this.impacto));
			else
				t.recibirDmg(3*this.impacto/4);
			cuentaRegresiva = 70;
		}
	}
}
