
package torres;

import control_grafico.GameObject;
import enemigos.Enemigo;

import javax.swing.*;

import armas.Proyectil;

public abstract class Torre extends GameObject {


    public Torre(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
    
    public void disparar(){
    	//Manejo del colisionador verificando si hay enemigo al alcance o no.
	// Agregar el disparo al mapa
    	
    }

    public void actualizarPosicion(){}
    
    public abstract void colisionar(Enemigo e);
    public abstract void colisionar(Proyectil p);
}

