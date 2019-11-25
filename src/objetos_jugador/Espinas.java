package objetos_jugador;

import control_logico.Constantes;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

public class Espinas extends ObjetosJugador {

	 private static ImageIcon espina = new ImageIcon("src/Imagenes/Espina.gif");
	 

    public Espinas(int x, int y) {
        super(6*Constantes.SEGUNDO, 1* Constantes.ANCHO_CELDA, 10, espina);

        this.costo = 10;
        this.cuentaRegresiva = 20;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void aceptar(Visitor v) {}
    public void colisionar(Torre t) {}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {}
    public void frenar() {}

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 20;
        }
    }

    @Override
    public void actualizar() {
        this.vida.recibirDmg(1);
        if (this.vida.obtenerVida() <= 0)
            morir();
    }

    @Override
    public Espinas clone(int posX, int posY) {
        return new Espinas(posX, posY);
    }
}