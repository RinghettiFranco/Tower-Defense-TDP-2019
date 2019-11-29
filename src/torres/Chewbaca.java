package torres;



import control_logico.Constantes;
import enemigos.Enemigo;

import javax.swing.*;

public class Chewbaca extends Torre {

    protected static ImageIcon standingChewbaca = new ImageIcon("src/Imagenes/StandingChewbaca.png");
    protected static ImageIcon attackingChewbaca = new ImageIcon("src/Imagenes/AttackingChewbaca.gif");
    protected static ImageIcon StandingChewbacaEscudo = new ImageIcon("src/Imagenes/ChewyEscudo.gif");
    public Chewbaca(int x, int y) {
        super(225, 1*Constantes.ANCHO_CELDA,  18, standingChewbaca);

        this.costo = 10;
        this.cuentaRegresiva = 1*Constantes.SEGUNDO;

        this.setBounds(x, y, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);

        tableroJuego.addToObjects(this);
    }

    public void colisionar(Enemigo e) {
        cuentaRegresiva--;

        if (cuentaRegresiva == 0) {
            e.recibirDmg(this.impacto);
            cuentaRegresiva = 1*Constantes.SEGUNDO;
        }
        e.frenar();
    }

	@Override
	public void CambiarImagenEscudo() {
		this.setIcon(StandingChewbacaEscudo);
		
	}

	@Override
	public void CambiarImagenSinEscudo() {
		this.setIcon(standingChewbaca);
		
	}
}