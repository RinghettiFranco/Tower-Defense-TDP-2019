package objetos_jugador;

import javax.swing.ImageIcon;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

public class R2D2 extends ObjetosJugador {
	
	 private static ImageIcon r2d2 = new ImageIcon("src/Imagenes/Barricada.png");

    public R2D2(int x, int y) {
        super(400, 1* Constantes.ANCHO_CELDA, 0, r2d2);
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
    public R2D2 clone(int posX, int posY) {
        return null;
    }
}
