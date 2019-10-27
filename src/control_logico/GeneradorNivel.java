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
		Random rnd1 = new Random();
		Random rnd2 = new Random();
		int corrimiento = 900;
		int distancia = 1200;
		int auxInicio;
		for(int i=0;i<(nivel*2);i++){
			auxInicio = (i==0)?0:1;
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd2.nextInt(3)+1)+rnd1.nextInt(50),25));
			oleada.add(new Stormtrooper(900+(i*distancia)+auxInicio*(distancia/4)*(rnd.nextInt(3)+1)+rnd1.nextInt(50),125));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd1.nextInt(50),225));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd2.nextInt(3)+1)+rnd1.nextInt(50),325));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd1.nextInt(50),425));
			corrimiento +=(distancia/4);
			
		}
		int inicio = corrimiento;
		for(int j=0;j<nivel;j++){
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd2.nextInt(3)+1)+rnd1.nextInt(50),25));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd1.nextInt(50),125));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd2.nextInt(3)+1)+rnd1.nextInt(50),225));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd1.nextInt(50),325));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd2.nextInt(3)+1)+rnd1.nextInt(50),425));
			corrimiento += (distancia/4);
		}
		corrimiento += distancia*nivel;
		int pos = (rnd.nextInt()%4+1)*100 + 25;
		oleada.add(new DarthVader(corrimiento,pos));
		return oleada;
    }
}