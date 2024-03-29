package objetos_mapa;

import control_logico.Constantes;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class AgujeroNegro extends ObjetoMapa {

    private static ImageIcon agujeroNegro = new ImageIcon("src/Imagenes/an1.png");

    public AgujeroNegro(int x, int y) {
        super(7*Constantes.SEGUNDO, Constantes.ANCHO_CELDA/2, 0, agujeroNegro);

        int celdaX = x - (x % Constantes.ANCHO_CELDA) + 15;
        int celdaY = y - (y % Constantes.ALTO_CELDA);

        this.setBounds(celdaX, celdaY, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Torre t) {
        t.morir();
    }

    public void colisionar(Enemigo e) {
        e.morir();
    }

    public void actualizar() {
        this.recibirDmg(1);
        if (this.obtenerVida() <= 0)
            morir();
    }
}
