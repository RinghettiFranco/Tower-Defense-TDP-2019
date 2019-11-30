package objetos_jugador;

import control_logico.Constantes;

import javax.swing.*;

public class RobotBarrera extends ObjetosJugador {
	
	 private static ImageIcon RobotBarrera = new ImageIcon("src/Imagenes/Barricada.png");

    public RobotBarrera(int x, int y) {
        super(600, 1* Constantes.ANCHO_CELDA, 0, RobotBarrera);

        this.costo = 20;
        this.cuentaRegresiva = 0;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }


    @Override
    public void actualizar() {
        if (this.obtenerVida() <= 0)
            morir();
    }
}