package control_logico;

import control_grafico.GameObject;
import torres.*;
import enemigos.*;

import java.util.LinkedList;
import java.util.List;

public class GeneradorNivel {
	
	public List<GameObject> generar(int nivel){
		List<GameObject> oleada = new LinkedList();
		oleada.add(new Chewbaca(25,25));
		oleada.add(new HanSolo(25,125));
		oleada.add(new LukeSkywalker(25,225));
		for(int i=0;i<(nivel*2);i++){
			oleada.add(new BobbaFet(800+(i*100),25));
			oleada.add(new DarthVader(800+(i*100),125));
			oleada.add(new Soldier(800+(i*100),225));
			oleada.add(new Stormtrooper(800+(i*100),325));
			oleada.add(new Stormtrooper(800+(i*100),425));
			
		}
		return oleada;
    }
}