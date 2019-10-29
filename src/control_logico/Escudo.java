package control_logico;

public class Escudo extends Vida {

    public Escudo(int vida) {
        super(vida);
    }

    @Override
    public void recibirDmg(int dmg) {
        this.vida -= (dmg*0.75);
    }
}
