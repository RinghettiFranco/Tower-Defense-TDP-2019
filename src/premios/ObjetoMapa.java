package premios;

import control_grafico.GameObject;

import javax.swing.*;

// Estos son los objetos que compra el jugador
public abstract class ObjetoMapa extends GameObject {

    public ObjetoMapa(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
}
