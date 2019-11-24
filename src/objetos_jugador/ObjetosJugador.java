package objetos_jugador;

import control_grafico.GameObject;

import javax.swing.*;

public abstract class ObjetosJugador extends GameObject {


    public ObjetosJugador(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
}
