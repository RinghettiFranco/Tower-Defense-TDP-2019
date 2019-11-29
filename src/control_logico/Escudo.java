package control_logico;

import control_grafico.GameObject;

public class Escudo extends Vida {

    public Escudo(int vida) {
        super(vida);
    }

 
    public void recibirDmg(int dmg) {
        this.vida -= (dmg*0.75);
    }

	
	public void cambiarEstado(GameObject go) {
		go.setEstado(new SinEscudo(go.obtenerVida()));
		go.CambiarImagenSinEscudo();
		
	}
}
