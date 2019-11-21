package control_grafico;


import control_logico.*;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class TableroJuego extends JPanel implements Agregable {

    private boolean posicionesOcupadas[][];

    private int nivel;

    private GeneradorNivel nivelGen;
    private List<GameObject> objetosMapa, toDel;

    private ThreadPrincipal ppal;

    private Mediator mediador;

    public TableroJuego(Mediator mediador) {
        super();

        this.setLayout(null);
        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_JUEGO_ALTO);
        this.setLocation(0, Constantes.PANEL_PUNTOS_ALTO);
        this.setBackground(new Color(0xD8D5C4));
        this.addMouseListener(new ClickListener());

        objetosMapa = new LinkedList<>();
        GameObject.setTableroJuego(this);

        nivel = 1;
        nivelGen = new GeneradorNivel();

        toDel = new LinkedList<>();
        objetosMapa = nivelGen.generar(nivel);

        int i=0;
        for (GameObject go: objetosMapa){
            this.add(go);
        }

        this.posicionesOcupadas = new boolean[Constantes.VENTANA_ANCHO/Constantes.ANCHO_CELDA][Constantes.VENTANA_ALTO/Constantes.ALTO_CELDA];

        ppal = new ThreadPrincipal(this);
        ppal.start();

        this.mediador = mediador;
    }

    public void actualizar() {
        // Colisionamos todo con todo O(n^2)
        //   Si un enemigo muere, sumammos los puntos y lo sacamos el mapa
        //   Si una torre muere, la sacamos del mapa
        colisionar();

        VisitorPerder vp = new VisitorPerder();
        // Movemos todos los objetos restantes del mapa
        for (GameObject go: objetosMapa) {
            go.actualizar();
            go.aceptar(vp);
        }

        for (GameObject go: toDel) {
            objetosMapa.remove(go);
            this.remove(go);
        }

        if (vp.perdi())
            System.exit(32);
    }

    public synchronized void renderizar() {
        for (GameObject go: objetosMapa)
            go.repaint();
    }

    public synchronized void addToObjects(GameObject go) {
        objetosMapa.add(go);
        this.add(go);
    }

    public synchronized void delFromObjects(GameObject toDel) {
		this.toDel.add(toDel);
    }

    private void colisionar() {
        GameObject objectI, objectJ;

        // Colisionamos a los objetos entre ellos
        for (int i = 0; i < objetosMapa.size(); i++) {
            objectI = objetosMapa.get(i);
            for (int j = 0; j < objetosMapa.size(); j++) {
                objectJ = objetosMapa.get(j);
                if (objectI.distancia(objectJ) <= objectJ.obtenerAlcance()) {
                    objectI.aceptar(new VisitorAtaque(objectJ)); // Esto es equivalente a J.atacar(I)
                }
            }
        }
    }

    // Seteamos el fondo
    protected void paintComponent(Graphics g) {
        ImageIcon bgImage = new ImageIcon("src/Imagenes/PC Computer - RPG Maker MV - Sand.png");
        Image bg = bgImage.getImage();

        super.paintComponent(g);
        g.drawImage(bg, 0 ,0, null);
    }

    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            int posX = mouseEvent.getX() - (mouseEvent.getX() % Constantes.ANCHO_CELDA) + 15;
            int posY = mouseEvent.getY() - (mouseEvent.getY() % Constantes.ALTO_CELDA);
            int x = posX / Constantes.ANCHO_CELDA;
            int y = posY / Constantes.ALTO_CELDA;

            if (!posicionesOcupadas[x][y]) {
                Torre t = mediador.getObject();
                if (t != null) {
                    if (mediador.tengoOro()) {
                        t.clone(posX, posY);
                        posicionesOcupadas[x][y] = true;
                        mediador.gastar(t.costo());
                    } else
                        mediador.delObject();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {}

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {}

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {}

        @Override
        public void mouseExited(MouseEvent mouseEvent) {}
    }
}