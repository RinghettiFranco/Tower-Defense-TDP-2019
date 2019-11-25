package objetos_jugador;

import javax.swing.ImageIcon;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

public class Espinas extends ObjetosJugador {

	 private static ImageIcon espina = new ImageIcon("src/Imagenes/Espina.gif");
	 

    public Espinas(int x, int y) {
        super(30, 1* Constantes.ANCHO_CELDA, 10, espina);
        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
        System.out.println("pone");
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
    public Espinas clone(int posX, int posY) {
        return null;
    }
}
