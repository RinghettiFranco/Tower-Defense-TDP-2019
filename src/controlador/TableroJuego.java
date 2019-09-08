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

    private TableroPuntos puntaje;
    private TableroCompra compras;

    public TableroJuego(TableroPuntos tp, TableroCompra tc) {
        super();

        this.setLayout(null);
        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_TABLERO_ALTO);
        this.setLocation(0, Constantes.PANEL_PUNTOS_ALTO);
        this.setBackground(new Color(0x3A353F));

        iniciarJuego();

        colisionador = new Colisionador();

        puntaje = tp;
        compras = tc;
    }

    public void gameLoop() {

        // Testeo por el estado de las torres y enemigos
        for (GameObject go: objetosMapa) {
            if (go.estaMuerto()) {
                objetosMapa.remove(go);
                puntaje.actualizarPuntaje(go.obtenerPuntaje());
                compras.actualizarOro(go.obtenerOro());
            } else
                go.actualizarPosicion();
        }

        // Verificamos si hay que generar un nuevo nivel
        // o enviar otra barricada


        // Colisionamos todo con todo O(n^2)...
        colisionador.colisionar(objetosMapa);
    }

    private void iniciarJuego() {
        nivel = 1;
        nivelGen = new GeneradorNivel(nivel);

        objetosMapa = new LinkedList<>();
        nivelGen.generar(objetosMapa);
    }
}
