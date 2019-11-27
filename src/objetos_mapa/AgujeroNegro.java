package objetos_mapa;

import javax.swing.*;

public class AgujeroNegro extends ObjetoMapa {
	 private static ImageIcon Fuego = new ImageIcon("src/Imagenes/fire.gif");

    public AgujeroNegro(int vida, int alcance, int impacto) {
        super(vida, alcance, impacto, Fuego);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public AgujeroNegro clone(int posX, int posY) {
        return null;
    }
}
