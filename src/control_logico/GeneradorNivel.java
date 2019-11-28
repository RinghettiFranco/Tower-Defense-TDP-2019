package control_logico;

import control_grafico.GameObject;
import enemigos.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GeneradorNivel {

	public List<GameObject> generar(int nivel){
		LinkedList oleada = new LinkedList();
		Random rnd = new Random(System.currentTimeMillis());
		int h = Constantes.PANEL_JUEGO_ALTO;
		int corrimiento = 900;
		int distancia = 1200;
		int auxInicio,inicio,pos;
		for(int i=0;i<nivel;i++){
			auxInicio = (i==0)?0:1;
			oleada.add(new Stormtrooper(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 0));
			oleada.add(new Stormtrooper(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/6));
			oleada.add(new Stormtrooper(Constantes.VENTANA_ANCHO+(i*distancia)+auxInicio*(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/3));
			oleada.add(new Stormtrooper(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/2));
			oleada.add(new Stormtrooper(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 2*h/3));
			oleada.add(new Stormtrooper(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 5*h/6));

			corrimiento +=(distancia/4);

		}
		for(int i=0;i<nivel;i++){
			oleada.add(new Soldier2(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 0));
			oleada.add(new Soldier2(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/6));
			oleada.add(new Soldier2(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/3));
			oleada.add(new Soldier2(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/2));
			oleada.add(new Soldier2(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 2*h/3));
			oleada.add(new Soldier2(Constantes.VENTANA_ANCHO+(i*distancia)+(distancia/4)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 5*h/6));

			corrimiento +=(distancia/4);

		}
		inicio = corrimiento;
		pos = (rnd.nextInt(5))*100;
		for(int k=0;k<nivel;k++){
			corrimiento += distancia;
			oleada.add(new BobbaFet(corrimiento,pos));
		}
		for(int j=0;j<nivel;j++){
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 0));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/6));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/3));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50), h/2));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 2*h/3));
			oleada.add(new Soldier(inicio+(j*distancia)+(distancia/6)*(rnd.nextInt(3)+1)+rnd.nextInt(50), 5*h/6));

			corrimiento += (distancia/4);
		}
		corrimiento += 200*nivel;
		pos = (rnd.nextInt(5))*100;
		oleada.add(new DarthVader(corrimiento,pos));
		return oleada;
    }
}