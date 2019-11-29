package objetos_jugador;

import control_logico.Constantes;
import enemigos.Enemigo;

import javax.swing.*;

public class Espinas extends ObjetosJugador {

	 private static ImageIcon espina = new ImageIcon("src/Imagenes/Espina.gif");
	 

    public Espinas(int x, int y) {
        super(6*Constantes.SEGUNDO, 1* Constantes.ANCHO_CELDA, 10, espina);

        this.costo = 22;
        this.cuentaRegresiva = 20;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void frenar() {}

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 20;
        }
    }

   
    public void actualizar() {
        this.vida.recibirDmg(1);
        if (this.vida.obtenerVida() <= 0)
            morir();
    }

    public void CambiarImagenEscudo() {}
    public void CambiarImagenSinEscudo() {}
    
}