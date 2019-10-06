package torres;

import javax.swing.ImageIcon;

import armas.Proyectil;
import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.VisitorColision;
import enemigos.Enemigo;

import java.awt.*;

public class HanSolo extends Torre {
	
	protected static ImageIcon shooting = new ImageIcon("src/Imagenes/Shooting Han solo.png");
	protected static ImageIcon standing = new ImageIcon("src/Imagenes/Standing Han Solo.png");
	
	public HanSolo(int x, int y){
		super(100, 2, 13, standing);
		hitBox = new Rectangle(x, y, 25, 63);
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
