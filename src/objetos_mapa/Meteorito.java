package objetos_mapa;

import control_logico.Constantes;
import enemigos.Enemigo;
import movimiento.Movimiento;
import movimiento.MovimientoCaida;
import torres.Torre;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Meteorito extends ObjetoMapa {
	
	private static ImageIcon meteoro = new ImageIcon("src/Imagenes/meteorito.png");
	protected Movimiento mov;
	protected int lugarCaida;

    public Meteorito(int x, int y) {
        super(Constantes.MAX_INF, 2*Constantes.ANCHO_CELDA, 0, meteoro);

        Random rnd = new Random(System.currentTimeMillis());
        int celdaX = x - (x % Constantes.ANCHO_CELDA) + 15;
        int celdaY = y - (y % Constantes.ALTO_CELDA);

        this.setBounds(celdaX, celdaY, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.mov = new MovimientoCaida(x, y);
        this.lugarCaida = (y+rnd.nextInt(6)*Constantes.ALTO_CELDA) % Constantes.PANEL_JUEGO_ALTO; //TODO revisar esta formula

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Torre t) {
        t.morir();
    }

    public void colisionar(Enemigo e) {
        e.morir();
    }

    public void actualizar() {
        if (mov.proximaPosicion().getY() == lugarCaida || this.getY() >= Constantes.PANEL_JUEGO_ALTO)
            this.morir();
        else {
            Point2D pos = mov.proximaPosicion();
            this.setBounds((int)pos.getX(), (int)pos.getY(), Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
        }
    }

    public Meteorito clone(int posX, int posY) {
        return null;
    }
}
