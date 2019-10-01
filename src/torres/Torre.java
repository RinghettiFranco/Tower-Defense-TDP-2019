
package torres;

import armas.Arma;
import control_grafico.GameObject;

import javax.swing.*;

public abstract class Torre extends GameObject {

    protected Arma golpe;

    public Torre(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
    
    public void disparar(){
    	//Manejo del colisionador verificando si hay enemigo al alcance o no.
    	golpe.disparar();
    }

    public void actualizarPosicion() {}
}

