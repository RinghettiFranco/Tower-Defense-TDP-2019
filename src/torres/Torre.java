
package torres;

import control_grafico.GameObject;

import javax.swing.*;

public abstract class Torre extends GameObject {


    public Torre(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
    
    public void disparar(){
    	//Manejo del colisionador verificando si hay enemigo al alcance o no.
    	
    }

    public void actualizarPosicion() {}
}

