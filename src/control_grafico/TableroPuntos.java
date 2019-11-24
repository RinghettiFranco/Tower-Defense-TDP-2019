package control_grafico;

import control_logico.Constantes;
import tienda.Mediator;

import javax.swing.*;
import java.awt.*;

public class TableroPuntos extends JPanel {

    private JLabel texto;
    private int puntos;

    private Mediator mediador;

    public TableroPuntos(Mediator mediador) {
        super();

        puntos = 0;

        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_PUNTOS_ALTO);
        this.setLocation(0, 0);
        this.setBackground(new Color(0xE2AB7F));

        texto = new JLabel("Puntaje: " + puntos);
        this.add(texto);
        this.mediador = mediador;
    }

    public void actualizarPuntaje(int incremento) {
        puntos += incremento;

        texto.setText("Puntaje: " + puntos);
    }
}