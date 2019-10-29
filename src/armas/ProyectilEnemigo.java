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
    public void atacar(Enemigo e) {

    }

    @Override
    public void atacar(ProyectilAliado pa) {

    }

    @Override
    public void atacar(ProyectilEnemigo pe) {

    }

    @Override
    public void atacar(Torre t) {

    }

    @Override
    public void aceptar(Visitor v) {

    }

    @Override
    public void actualizarPosicion() {

    }
}
