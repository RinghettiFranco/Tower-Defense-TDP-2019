package proyectiles;

import control_logico.Constantes;
import movimiento.MovimientoProyectil;

import javax.swing.*;

public class Flecha extends ProyectilAliado {
	 protected static ImageIcon grafico = new ImageIcon("src/Imagenes/flechaewok.png");

	    public Flecha(int x, int y, int impacto) {
	        super(1, 10, impacto, grafico);

	        pos=new MovimientoProyectil(x,y, 1);

			this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

	        tableroJuego.addToObjects(this);

			this.cuentaRegresiva = 1*Constantes.SEGUNDO;
	    }


}
