package control_grafico;

import control_logico.Constantes;
import control_logico.MediadorCompra;
import control_logico.Mediator;

import javax.swing.*;

public class Juego {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("TDP2019");

        Mediator mediador = new MediadorCompra();

        TableroPuntos puntos = new TableroPuntos(mediador);
        TableroCompra compra = new TableroCompra(mediador);
        TableroJuego juego = new TableroJuego(mediador);
        ((MediadorCompra)mediador).setTienda(compra);


        ventana.setLayout(null);
        ventana.add(puntos);
        ventana.add(juego);
        ventana.add(compra);
        ventana.setSize(Constantes.VENTANA_ANCHO, Constantes.VENTANA_ALTO);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ventana.setVisible(true);
    }
}