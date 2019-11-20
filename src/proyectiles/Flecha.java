package proyectiles;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import movimiento.MovimientoProyectil;

public class Flecha extends ProyectilAliado {
	 protected static ImageIcon grafico = new ImageIcon("src/Imagenes/flechaewok.png");

	    public Flecha(int x, int y, int impacto) {
	        super(1, 10, impacto, grafico);

	        pos=new MovimientoProyectil(x,y, 1);

			this.setBounds(x, y, 100, 100);

	        tableroJuego.addToObjects(this);

	        this.cuentaRegresiva = 35;
	    }


}
