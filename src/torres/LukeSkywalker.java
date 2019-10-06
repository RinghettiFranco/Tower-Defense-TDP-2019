package torres;

import javax.swing.*;

import armas.Proyectil;
import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.VisitorColision;
import enemigos.Enemigo;

import java.awt.*;

public class LukeSkywalker extends Torre {

    protected static ImageIcon staindingLuke = new ImageIcon("src/Imagenes/Standing Luke Skywalker.png");
    protected static ImageIcon attackingLuke = new ImageIcon("src/Imagenes/Standing Luke Skywalker.png");

    public LukeSkywalker(int x, int y) {
        super(100, 1, 12, staindingLuke);

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
