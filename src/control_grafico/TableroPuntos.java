package control_grafico;

import controlador.Constantes;

import javax.swing.*;
import java.awt.*;

public class TableroPuntos extends JPanel {

    private JLabel texto;
    private int puntos;

    public TableroPuntos() {
        super();

        puntos = 0;

        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_PUNTOS_ALTO);
        this.setLocation(0, 0);
        this.setBackground(new Color(0xE2AB7F));

        texto = new JLabel("Puntaje: " + puntos);
        this.add(texto);
    }

    public void actualizarPuntaje(int incremento) {
        puntos += incremento;

        texto.setText("Puntaje: " + puntos);
    }
}