package armas;

import control_grafico.GameObject;
import enemigos.Enemigo;
import torres.Torre;

import javax.swing.*;

public abstract class Proyectil extends GameObject {


    public Proyectil(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }

}
