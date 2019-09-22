package controlador;

import control_grafico.GameObject;
import torres.Han_Solo;

import java.util.List;

public class GeneradorNivel {

    public GeneradorNivel(int nivel) {
    }

    public void generar(List<GameObject> enemigos) {
        enemigos.add(new Han_Solo(20, 20));
    }
}