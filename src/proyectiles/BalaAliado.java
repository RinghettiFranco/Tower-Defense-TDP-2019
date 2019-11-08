package proyectiles;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import movimiento.MovimientoProyectil;

public class BalaAliado extends ProyectilAliado {
	 protected static ImageIcon grafico = new ImageIcon("src/Imagenes/dispEnemigo1.png");

	    public BalaAliado(int x, int y, int impacto) {
	        super(1, 10, impacto, grafico);

	        pos=new MovimientoProyectil(x,y, 1);

	        hitBox = new Rectangle(x, y, 100, 100);
	        this.setBounds(hitBox);

	        tableroJuego.addToObjects(this);

	        this.cuentaRegresiva = 35;
	    }


}
