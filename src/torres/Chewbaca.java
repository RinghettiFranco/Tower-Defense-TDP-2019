package torres;



import javax.swing.*;

import armas.Proyectil;
import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.VisitorColision;
import enemigos.Enemigo;

import java.awt.*;

public class Chewbaca extends Torre {

    protected static ImageIcon standingChewbaca = new ImageIcon("");
    protected static ImageIcon attackingChewbaca = new ImageIcon("");

    public Chewbaca(int x, int y) {
        super(200, 5,  22, standingChewbaca);

        hitBox = new Rectangle(x, y, 33, 73);
        this.setBounds(hitBox);
    }

    @Override
    public void aceptar(VisitorColision vc) {
        vc.visit(this);
    }

    @Override
    public void colisionar(Torre t) {}

    @Override
	public void colisionar(Enemigo e) {
		this.recibirDmg(e.obtenerImpacto());
	}

    @Override
    public void colisionar(ProyectilAliado pa) {}

    @Override
    public void colisionar(ProyectilEnemigo pe) {
        this.recibirDmg(pe.obtenerImpacto());
    }
}
