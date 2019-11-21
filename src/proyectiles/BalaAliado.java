package proyectiles;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import control_logico.Constantes;
import movimiento.MovimientoProyectil;

public class BalaAliado extends ProyectilAliado {
	 protected static ImageIcon grafico = new ImageIcon("src/Imagenes/dispEnemigo1.png");

	    public BalaAliado(int x, int y, int impacto) {
	        super(1, 10, impacto, grafico);

	        pos=new MovimientoProyectil(x,y, 1);

			this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

	        tableroJuego.addToObjects(this);

	        this.cuentaRegresiva = 35;
	    }


}
