package premios;

public class Fuerza extends Premio {

    public Fuerza(int x, int y) {
        super(3, 0, 0, null);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {

    }

    @Override
    public Fuerza clone(int posX, int posY) {
        return null;
    }
}
