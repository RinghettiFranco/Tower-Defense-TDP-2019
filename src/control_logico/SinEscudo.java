package control_logico;

public class SinEscudo extends Vida {

    public SinEscudo(int vida) {
        super(vida);
    }

    @Override
    public void recibirDmg(int dmg) {
        this.vida -= dmg;
    }
}
