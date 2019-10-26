package control_logico;

import control_grafico.GameObject;
import torres.HanSolo;
import enemigos.Stormtrooper;

import java.util.LinkedList;
import java.util.List;

public class GeneradorNivel {
	
	public List<GameObject> generar(int nivel){
		List<GameObject> oleada = new LinkedList();
		for(int i=0;i<(nivel*2);i++){
			oleada.add(new Stormtrooper(800+(i*100),25));
			oleada.add(new Stormtrooper(800+(i*100),125));
			oleada.add(new Stormtrooper(800+(i*100),225));
			oleada.add(new Stormtrooper(800+(i*100),325));
			oleada.add(new Stormtrooper(800+(i*100),425));
		}
		return oleada;
    }
}