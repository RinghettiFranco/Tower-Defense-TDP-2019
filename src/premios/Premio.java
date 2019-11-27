package premios;

import control_grafico.GameObject;
import control_logico.Visitor;

import javax.swing.*;

/**
 * Los premios constan de un valor de incremento, el cual
 * es aplicado a la torre, y esta es la que decide donde
 * aplicar dicho incremento
 */
public abstract class Premio extends GameObject {

    protected int incremento;

    public Premio(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}
