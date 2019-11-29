package control_logico;

import control_grafico.GameObject;

public abstract class Vida {

    protected int vida;

    public Vida(int vida) {
        this.vida = vida;
    }

    public int obtenerVida() {
        return vida;
    }

    public abstract void recibirDmg(int dmg);
    
    public abstract void cambiarEstado(GameObject go);
}
