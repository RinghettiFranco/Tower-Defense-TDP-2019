package controlador;

import javax.swing.*;

public class Juego {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("TDP2019");

        TableroPuntos puntos = new TableroPuntos();
        TableroCompra compra = new TableroCompra();
        TableroJuego juego = new TableroJuego(puntos, compra);

        ventana.setLayout(null);
        ventana.add(puntos);
        ventana.add(juego);
        ventana.add(compra);
        ventana.setSize(Constantes.VENTANA_ANCHO, Constantes.VENTANA_ALTO);

        juego.gameLoop();

        ventana.setVisible(true);
        ventana.show();
    }
}