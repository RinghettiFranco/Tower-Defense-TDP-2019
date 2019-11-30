package premios;

import control_logico.Constantes;
import enemigos.Enemigo;

import javax.swing.*;

public class Fuego extends Premio {

    protected static ImageIcon fuego = new ImageIcon("src/Imagenes/fire.gif");
    protected int cuentaRegresiva;

    public Fuego(int x, int y) {
        super(5*Constantes.SEGUNDO,  1*Constantes.ANCHO_CELDA, 8, fuego);

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        this.cuentaRegresiva = Constantes.SEGUNDO/2;

        tableroJuego.addToObjects(this);
    }

    @Override
    public void actualizar() {
        this.vida.recibirDmg(1);
        if (this.vida.obtenerVida() <= 0)
            morir();
    }

    @Override
    public void colisionar(Enemigo e) {
        this.cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = Constantes.SEGUNDO/2;
            System.out.println("Fuego -> enemigo");
        }
    }

    @Override
    public void frenar() {}
    public void CambiarImagenEscudo() {}
    public void CambiarImagenSinEscudo() {}
}
