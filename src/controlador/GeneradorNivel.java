package controlador;

import control_grafico.GameObject;
import torres.Han_Solo;
import enemigos.Enemigo;
import enemigos.Stormtrooper;

import java.util.List;

public class GeneradorNivel {

    public GeneradorNivel(int nivel) {
    }

    public void generar(List<GameObject> enemigos) {
        enemigos.add(new Han_Solo(20, 20));
        GameObject enemy = new Stormtrooper(800,20);
        enemigos.add(enemy);
    }
    
    public void removerEnemigo(List<GameObject> enemigos, GameObject e){
    	enemigos.remove(e);
    	e.setIcon(null);
    }
    
    public GameObject devolverEnemigo(List<GameObject> enemigos){
    	return enemigos.get(1);
    }
}