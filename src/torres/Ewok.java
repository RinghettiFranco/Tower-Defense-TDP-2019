package torres;


import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.Flecha;

import javax.swing.*;

public class Ewok extends Torre {

    protected static ImageIcon standingEwok = new ImageIcon("src/Imagenes/standingEwok.png");
    protected static ImageIcon attackingEwok = new ImageIcon("src/Imagenes/AttackingEwok.gif");

    public Ewok(int x, int y) {
        super(100, 2*Constantes.ANCHO_CELDA,  12, standingEwok);

        this.costo = 10;
        this.cuentaRegresiva = 1*Constantes.SEGUNDO;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Enemigo e) {
    	cuentaRegresiva--;
    	this.setIcon(attackingEwok);

		if (cuentaRegresiva == 0) {
			if (distancia(e) >= Constantes.ANCHO_CELDA)
				tableroJuego.addToObjects(new Flecha(this.getX(), this.getY(), this.impacto));
			else {
				e.recibirDmg(3 * this.impacto / 4);
				e.frenar();
			}
            this.cuentaRegresiva = 1*Constantes.SEGUNDO;
		}
	}
}
