package controlador;

import torres.Han_Solo;

import java.util.List;

public class GeneradorNivel {

    public GeneradorNivel(int nivel) {
    }

    public void generar(List<GameObject> enemigos) {
        enemigos.add(new Han_Solo(0, 0));
    }
}