package control_logico;

import control_grafico.GameObject;

public class SinEscudo extends Vida {

    public SinEscudo(int vida) {
        super(vida);
    }

    
    public void recibirDmg(int dmg) {
        this.vida -= dmg;
    }

	
	public void cambiarEstado(GameObject go) {
		go.setEstado(new Escudo(go.obtenerVida()));
		go.CambiarImagenEscudo();
		
	}
}
