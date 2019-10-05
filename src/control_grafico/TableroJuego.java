package control_grafico;


import control_logico.Agregable;
import control_logico.Constantes;
import control_logico.GeneradorNivel;
import control_logico.ThreadPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class TableroJuego extends JPanel implements Agregable {

    private int nivel;

    private GeneradorNivel nivelGen;
    private List<GameObject> objetosMapa, toDel;

    private TableroPuntos puntaje;
    private TableroCompra compras;

    private ThreadPrincipal ppal;

    public TableroJuego(TableroPuntos tp, TableroCompra tc) {
        super();

        this.setLayout(null);
        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_TABLERO_ALTO);
        this.setLocation(0, Constantes.PANEL_PUNTOS_ALTO);
        this.setBackground(new Color(0xD8D5C4));

        iniciarJuego();

        ppal = new ThreadPrincipal(this);
        puntaje = tp;
        compras = tc;
        ppal.start();
    }

    public void verificarColisiones() {
        GameObject goi, goj;

        int i = 0;
        while (i < objetosMapa.size()) {
            goi = objetosMapa.get(i);
            for (int j = 0; j < objetosMapa.size(); j++) {
                goj = objetosMapa.get(j);
                if (!goi.equals(goj) && goi.intersecta(goj)) {
                    goi.colisionar(goj);
                    goj.colisionar(goi);
                }

                if (goi.estaMuerto())
                    toDel.add(goi);
                if (goj.estaMuerto())
                    toDel.add(goj);
            }
            i++;
        }
        delFromObjects(toDel);
    }

    public void actualizar() {
        // Colisionamos todo con todo O(n^2)
        //   Si un enemigo muere, sumammos los puntos y lo sacamos el mapa
        //   Si una torre muere, la sacamos del mapa
	    verificarColisiones();

        // Si la cantidad de enemigos es cero:
        //   Si ya pasamos 3 oleadas, next level
        //   Sino, next wave

        // Movemos todos los objetos restantes del mapa
        for (GameObject go: objetosMapa)
            go.actualizarPosicion();
    }

    public void renderizar() {
        for (GameObject go: objetosMapa)
            go.repaint();
    }

    public synchronized void addToObjects(GameObject go) {
        objetosMapa.add(go);
    }

    public synchronized void delFromObjects(List<GameObject> toDel) {
	    for (GameObject go: toDel)
		    objetosMapa.remove(go);
        toDel.clear();
    }

    private void iniciarJuego() {
        nivel = 1;
        nivelGen = new GeneradorNivel(nivel);

	    toDel = new LinkedList<>();
        objetosMapa = new LinkedList<>();
        nivelGen.generar(objetosMapa);

        for (GameObject go: objetosMapa)
            this.add(go);
    }

    // Seteamos el fondo
    protected void paintComponent(Graphics g) {
        ImageIcon bgImage = new ImageIcon("src/Imagenes/PC Computer - RPG Maker MV - Sand.png");
        Image bg = bgImage.getImage();

        super.paintComponent(g);
        g.drawImage(bg, 0 ,0, null);
    }
}

