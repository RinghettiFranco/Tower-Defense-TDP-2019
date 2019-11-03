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

    private int nivel;

    private GeneradorNivel nivelGen;
    private List<GameObject> objetosMapa;

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

        objetosMapa = nivelGen.generar(nivel);

        int i=0;
        for (GameObject go: objetosMapa){
            this.add(go);
        }

        ppal = new ThreadPrincipal(this);
        ppal.start();

        this.mediador = mediador;
    }

    public void actualizar() {
        // Colisionamos todo con todo O(n^2)
        //   Si un enemigo muere, sumammos los puntos y lo sacamos el mapa
        //   Si una torre muere, la sacamos del mapa
        colisionar();

        // Si la cantidad de enemigos es cero:
        //   Si ya pasamos 3 oleadas, next level
        //   Sino, next wave

        // Movemos todos los objetos restantes del mapa
        for (GameObject go: objetosMapa)
            go.actualizarPosicion();
    }

    public synchronized void renderizar() {
        for (GameObject go: objetosMapa)
            go.repaint();
    }

    public synchronized void addToObjects(GameObject go) {
        objetosMapa.add(go);
    }

    public synchronized void delFromObjects(List<GameObject> toDel) {
	for (GameObject go: toDel)
		objetosMapa.remove(go);
    }

    private void colisionar() {
        VisitorColision v = new VisitorColision();

        // Colisionamos al objeto I con el objeto J
        for (GameObject objectI: objetosMapa)
            for (GameObject objectJ: objetosMapa)
                if (!objectI.equals(objectJ) && objectI.hitBox.intersects(objectJ.hitBox)) {
                    v.setObjeto(objectJ);
                    objectI.aceptar(v);
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
            int posX = mouseEvent.getX();
            int posY = mouseEvent.getY();

            if (mediador.tengoOro()) {
                Torre t = mediador.getObject().clone(posX, posY);
                add(t);
                mediador.gastar(t.costo());
            }

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}

