package enemigos;


import control_logico.Constantes;
import movimiento.MovimientoEnemigo;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

public class Soldier2 extends Enemigo {

    private static ImageIcon walkingSoldier2 = new ImageIcon("src/Imagenes/RunningE2.gif");
    private static ImageIcon attackingSoldier2 = new ImageIcon("src/Imagenes/AttackingE2.gif");

    public Soldier2(int x, int y) {
        super(120, 2*Constantes.ANCHO_CELDA, 20, walkingSoldier2);
        pos = new MovimientoEnemigo(x, y);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.cuentaRegresiva = 2*Constantes.SEGUNDO;
        this.puntaje = 5;

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Torre t) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            if (distancia(t) >= Constantes.ANCHO_CELDA)
                tableroJuego.addToObjects(new ProyectilEnemigo(this.getX(), this.getY(), this.impacto));
            else
                t.recibirDmg(this.impacto/2);
            cuentaRegresiva = 2*Constantes.SEGUNDO;
        }
    }
}
