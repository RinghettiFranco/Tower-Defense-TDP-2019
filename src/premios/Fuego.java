package premios;

public class Fuego extends Premio {

    public Fuego(int x, int y) {
        super(3,  0, 0, null);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {

    }

    @Override
    public Fuego clone(int posX, int posY) {
        return null;
    }
}
