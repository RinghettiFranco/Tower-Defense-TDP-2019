package controlador;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class TableroJuego extends JPanel {

    private int nivel;

    private Colisionador colisionador;
    private GeneradorNivel nivelGen;
    private List<GameObject> objetosMapa;


    public TableroJuego() {
        super();

        this.setLayout(null);
        this.setSize(300, 530);
        this.setBackground(Color.BLACK);

        nivel = 1;
        nivelGen = new GeneradorNivel(nivel);
        objetosMapa = new LinkedList<>();
        nivelGen.generar(objetosMapa);

        colisionador = new Colisionador();
    }

    public void gameLoop() {

    }
}
