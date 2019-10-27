package control_logico;

import control_grafico.GameObject;
import torres.HanSolo;
import enemigos.*;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class GeneradorNivel {
	
	public List<GameObject> generar(int nivel){
		List<GameObject> oleada = new LinkedList();
		Random rnd = new Random();
		int corrimiento = 800;
		for(int i=0;i<(nivel*2);i++){
			oleada.add(new Stormtrooper(800+(i*200)+rnd.nextInt(50),25));
			oleada.add(new Stormtrooper(800+(i*200)+rnd.nextInt(50),125));
			oleada.add(new Stormtrooper(800+(i*200)+rnd.nextInt(50),225));
			oleada.add(new Stormtrooper(800+(i*200)+rnd.nextInt(50),325));
			oleada.add(new Stormtrooper(800+(i*200)+rnd.nextInt(50),425));
			corrimiento +=200;
			
		}
		int inicio = corrimiento;
		for(int j=0;j<nivel;j++){
			oleada.add(new Soldier(inicio+(j*200)+rnd.nextInt(50),25));
			oleada.add(new Soldier(inicio+(j*200)+rnd.nextInt(50),125));
			oleada.add(new Soldier(inicio+(j*200)+rnd.nextInt(50),225));
			oleada.add(new Soldier(inicio+(j*200)+rnd.nextInt(50),325));
			oleada.add(new Soldier(inicio+(j*200)+rnd.nextInt(50),425));
			corrimiento+=200;
		}
		int pos = (rnd.nextInt()%4+1)*100 + 25;
		oleada.add(new DarthVader(corrimiento,pos));
		return oleada;
    }
}