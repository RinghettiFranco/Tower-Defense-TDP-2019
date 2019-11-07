
package torres;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.Visitor;
import enemigos.Enemigo;

import javax.swing.*;

public abstract class Torre extends GameObject {

    protected int costo;
    protected int cuentaRegresiva;

    public Torre(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
        this.puntaje = -this.puntaje;
    }

    public void actualizarPosicion(){}

    public int costo() {
        return costo;
    }

    public abstract Torre clone(int x, int y);

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void colisionar(Torre t){}
    public void colisionar(ProyectilAliado pa) {}
    public void colisionar(ProyectilEnemigo pe) {
        pe.morir();
    }

    @Override
    public void morir() {
        tableroJuego.delFromObjects(this);
    }
    public void frenar() {}
}

