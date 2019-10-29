
package torres;

import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import control_grafico.GameObject;
import control_logico.Visitor;
import enemigos.Enemigo;

import javax.swing.*;

import armas.Proyectil;

public abstract class Torre extends GameObject {

    protected int costo;

    public Torre(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
    }
    
    public void disparar(){
    	//Manejo del colisionador verificando si hay enemigo al alcance o no.
	// Agregar el disparo al mapa
    	
    }

    public void actualizarPosicion(){}

    public int costo() {
        return costo;
    }

    public abstract Torre clone(int x, int y);

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void atacar(Torre t){}
    public void atacar(ProyectilAliado pa) {}

    public void atacar(Enemigo e) {
        vida.recibirDmg(e.obtenerImpacto());
    }

    public void atacar(ProyectilEnemigo pe) {
        vida.recibirDmg(pe.obtenerImpacto());
    }
}

