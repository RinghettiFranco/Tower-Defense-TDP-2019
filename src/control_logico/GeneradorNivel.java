package control_logico;

import control_grafico.GameObject;
import torres.HanSolo;
import enemigos.Stormtrooper;

import java.util.List;

public class GeneradorNivel {

    public GeneradorNivel(int nivel) {
    }

    public void generar(List<GameObject> enemigos) {
        enemigos.add(new HanSolo(20, 20));
        GameObject enemy = new Stormtrooper(800,20);
        enemigos.add(enemy);
    }
}