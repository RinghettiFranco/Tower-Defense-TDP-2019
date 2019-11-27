package premios;

public class Bomba extends Premio {

    public Bomba(int x, int y) {
        super(3, 0, 0, null);
    }


    @Override
    public void actualizar() {

    }

    @Override
    public void frenar() {

    }

    @Override
    public Bomba clone(int posX, int posY) {
        return null;
    }
}
