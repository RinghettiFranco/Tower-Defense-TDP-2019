package objetos_jugador;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

public class RobotPiso extends ObjetosJugador {
	
	 private static ImageIcon RobotPiso = new ImageIcon("src/Imagenes/RobotPiso.png");

    public RobotPiso(int x, int y) {
        super(200, 1* Constantes.ANCHO_CELDA, 13, RobotPiso);
        this.costo = 10;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    @Override
    public void aceptar(Visitor v) {

    }

    @Override
    public void colisionar(Torre t) {

    }

    @Override
    public void colisionar(Enemigo e) {

    }

    @Override
    public void colisionar(ProyectilAliado pa) {

    }

    @Override
    public void colisionar(ProyectilEnemigo pe) {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {

    }

    @Override
    public void morir() {

    }

    @Override
    public RobotPiso clone(int posX, int posY) {
        return new RobotPiso(posX, posY);
    }
}
