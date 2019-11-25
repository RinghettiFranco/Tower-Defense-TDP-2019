package objetos_jugador;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

public class RobotBarrera extends ObjetosJugador {
	
	 private static ImageIcon RobotBarrera = new ImageIcon("src/Imagenes/Barricada.png");

    public RobotBarrera(int x, int y) {
        super(600, 1* Constantes.ANCHO_CELDA, 0, RobotBarrera);

        this.costo = 10;
        this.cuentaRegresiva = 0;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void aceptar(Visitor v) {}
    public void colisionar(Torre t) {}
    public void colisionar(Enemigo e) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}
    public void frenar() {}

    @Override
    public void actualizar() {
        if (this.vida.obtenerVida() <= 0)
            morir();
    }

    @Override
    public RobotBarrera clone(int posX, int posY) {
        return new RobotBarrera(posX, posY);
    }
}