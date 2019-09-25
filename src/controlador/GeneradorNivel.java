package controlador;

import control_grafico.GameObject;
import torres.Han_Solo;
import enemigos.Stormtrooper;

import java.util.List;

public class GeneradorNivel {

    public GeneradorNivel(int nivel) {
    }

    public void generar(List<GameObject> enemigos) {
        enemigos.add(new Han_Solo(20, 20));
        enemigos.add(new Stormtrooper(800,20));
        enemigos.add(new Stormtrooper(800,120));
        enemigos.add(new Stormtrooper(800,220));
        enemigos.add(new Stormtrooper(800,320));
    }
}