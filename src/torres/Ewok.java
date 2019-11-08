package torres;



import control_logico.Constantes;
import enemigos.Enemigo;
import proyectiles.BalaAliado;
import proyectiles.Flecha;
import proyectiles.ProyectilEnemigo;

import javax.swing.*;

import java.awt.*;

public class Ewok extends Torre {

    protected static ImageIcon standingEwok = new ImageIcon("src/Imagenes/standingEwok.png");
    protected static ImageIcon attackingEwok = new ImageIcon("src/Imagenes/AttackingEwok.gif");

    public Ewok(int x, int y) {
        super(200, 1*Constantes.ANCHO_CELDA,  20, standingEwok);
        this.costo = 10;

        hitBox = new Rectangle(x, y, Constantes.ALTO_CELDA, Constantes.ANCHO_CELDA);
        this.setBounds(hitBox);

        tableroJuego.addToObjects(this);

        this.cuentaRegresiva = 65;
    }

    @Override
    public Torre clone(int x, int y) {
        return new Ewok(x, y);
    }

    public void colisionar(Enemigo e) {
    	cuentaRegresiva--;
    	this.setIcon(attackingEwok);

		if (cuentaRegresiva == 0) {
			if (distancia(hitBox, e.getBounds()) >= Constantes.ANCHO_CELDA)
				tableroJuego.addToObjects(new Flecha(hitBox.x, hitBox.y, this.impacto));
			else {
				e.recibirDmg(3 * this.impacto / 4);
				e.frenar();
			}
			cuentaRegresiva = 35;
		}
	}
}
