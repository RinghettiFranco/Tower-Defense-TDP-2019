package premios;

import control_logico.Constantes;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class Bomba extends Premio {

    protected static ImageIcon bomba = new ImageIcon("src/Imagenes/Bomba.png");

    protected boolean exploto;

    public Bomba(int x, int y) {
        super(5*Constantes.SEGUNDO, Constantes.ANCHO_CELDA/2, 0, bomba);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.exploto = false;

        tableroJuego.addToObjects(this);
    }

    public void actualizar() {
        if (exploto)
            morir();
        else {
            this.vida.recibirDmg(1);
            if (this.vida.obtenerVida() <= 0)
                morir();
        }
    }

    @Override
    public void colisionar(Enemigo e) {
        this.exploto = true;
        e.morir();
    }

    @Override
    public void colisionar(Torre t) {
        this.exploto = true;
        t.morir();
    }

    public void frenar() {}


	public void CambiarImagenEscudo() {}

	
	public void CambiarImagenSinEscudo() {}
}
