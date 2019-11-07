package control_logico;

import control_grafico.GameObject;
import torres.*;
import enemigos.*;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class GeneradorNivel {
	
	public List<GameObject> generar(int nivel){
		List<GameObject> oleada = new LinkedList();
		Random rnd = new Random(System.currentTimeMillis());

		int corrimiento = 900;
		int distancia = 1200;
		int auxInicio,inicio,pos; 
		for(int i=0;i<nivel;i++){
			auxInicio = (i==0)?0:1;
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),25));
			oleada.add(new Stormtrooper(900+(i*distancia)+auxInicio*(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),125));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),225));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),325));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),425));
			oleada.add(new Stormtrooper(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),525));
			corrimiento +=(distancia/4);
			
		}
		inicio = corrimiento;
		for(int i=0;i<nivel;i++){
			oleada.add(new Soldier2(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),25));
			oleada.add(new Soldier2(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),125));
			oleada.add(new Soldier2(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),225));
			oleada.add(new Soldier2(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),325));
			oleada.add(new Soldier2(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),425));
			oleada.add(new Soldier2(900+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50),525));
			corrimiento +=(distancia/4);
			
		}
		inicio = corrimiento;
		pos = (rnd.nextInt(5))*100 + 25;
		for(int k=0;k<nivel;k++){
			corrimiento += distancia;
			oleada.add(new BobbaFet(corrimiento,pos));
		}
		for(int j=0;j<nivel;j++){
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50),25));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50),125));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50),225));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50),325));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50),425));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50),525));
			corrimiento += (distancia/4);
		}
		corrimiento += 200*nivel;
		pos = (rnd.nextInt(5))*100 + 25;
		oleada.add(new DarthVader(corrimiento,pos));
		return oleada;
    }
}