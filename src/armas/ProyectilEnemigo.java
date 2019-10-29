package armas;

import control_logico.Visitor;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public class ProyectilEnemigo extends Proyectil {

    public ProyectilEnemigo(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
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
    public void colisionar(Torre t) {

    }

    @Override
    public void aceptar(Visitor v) {

    }

    @Override
    public void actualizarPosicion() {

    }
}
