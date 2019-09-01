package juego;

import javax.swing.*;
import java.awt.*;

public class Juego {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("TDP2019");

        ventana.setLayout(new GridLayout(3, 1));
        ventana.add(new TableroPuntos());
        ventana.add(new TableroJuego());
        ventana.add(new TableroCompra());
        ventana.setSize(300, 600);

        ventana.setVisible(true);
        ventana.show();
    }
}
