package objetos_jugador;

import javax.swing.ImageIcon;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

public class RobotBarrera extends ObjetosJugador {
	
	 private static ImageIcon RobotBarrera = new ImageIcon("src/Imagenes/Barricada.png");

    public RobotBarrera(int x, int y) {
        super(450, 1* Constantes.ANCHO_CELDA, 0, RobotBarrera);
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
    public RobotBarrera clone(int posX, int posY) {
        return null;
    }
}
