package objetos_jugador;

import control_grafico.GameObject;
import control_logico.Visitor;

import javax.swing.*;

public abstract class ObjetosJugador extends GameObject {

    protected int costo;
    protected int cuentaRegresiva;

    public ObjetosJugador(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }

    public int costo() {
        return costo;
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}