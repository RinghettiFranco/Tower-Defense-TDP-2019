package objetos_jugador;

import control_logico.Constantes;
import enemigos.Enemigo;
import movimiento.Movimiento;
import movimiento.MovimientoProyectil;

import javax.swing.*;
import java.awt.geom.Point2D;

public class R2D2 extends ObjetosJugador {
	
	 private static ImageIcon r2d2 = new ImageIcon("src/Imagenes/R2D2.png");
	 protected Movimiento mov;

    public R2D2(int x, int y) {
        super(10*Constantes.SEGUNDO, 1* Constantes.ANCHO_CELDA, 0, r2d2);

        this.costo = 100;
        this.cuentaRegresiva = 3;

        this.mov = new MovimientoProyectil(x, y, 5);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void frenar() {}

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0)
            e.morir();
    }

    @Override
    public void actualizar() {
        Point2D pos = mov.proximaPosicion();
        this.setBounds((int) pos.getX(), (int) pos.getY(), Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.vida.recibirDmg(1);
        if (this.vida.obtenerVida() <= 0)
            morir();

        if (this.getX() >= Constantes.VENTANA_ANCHO)
            morir();
    }
}