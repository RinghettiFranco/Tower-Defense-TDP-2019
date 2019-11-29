package objetos_jugador;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;

import javax.swing.*;

public class RobotPiso extends ObjetosJugador {
	
	 private static ImageIcon RobotPiso = new ImageIcon("src/Imagenes/RobotPiso.png");

    public RobotPiso(int x, int y) {
        super(200, 1* Constantes.ANCHO_CELDA, 7, RobotPiso);

        this.costo = 50;
        this.cuentaRegresiva = 25;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void frenar() {}
    public void CambiarImagenEscudo() {}
    public void CambiarImagenSinEscudo() {}

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 25;
        }
    }

    @Override
    public void actualizar() {
        if (this.vida.obtenerVida() <= 0)
            morir();
    }
}