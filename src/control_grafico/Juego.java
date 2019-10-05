package control_grafico;

import control_logico.Constantes;

import javax.swing.*;

public class Juego {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("TDP2019");

        TableroPuntos puntos = new TableroPuntos();
        TableroCompra compra = new TableroCompra();
        TableroJuego juego = new TableroJuego(puntos, compra);

        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.add(puntos);
        ventana.add(juego);
        ventana.add(compra);
        ventana.setSize(Constantes.VENTANA_ANCHO, Constantes.VENTANA_ALTO);

        ventana.setVisible(true);
    }
}