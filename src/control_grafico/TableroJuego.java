package control_grafico;


import control_logico.*;
import enemigos.Enemigo;
import objetos_mapa.AgujeroNegro;
import objetos_mapa.Meteorito;
import tienda.Mediator;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TableroJuego extends JPanel implements Agregable, Grilla {

    private boolean[][] posicionesOcupadas;

    private int nivel;

    private GeneradorNivel nivelGen;
    private List<GameObject> objetosMapa, toDel;

    private ThreadPrincipal ppal;

    private Mediator mediador;

    private VisitorPerder vp;
    private VisitorContador vc;

    public TableroJuego(Mediator mediador) {
        super();

        this.setLayout(null);
        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_JUEGO_ALTO);
        this.setLocation(0, Constantes.PANEL_PUNTOS_ALTO);
        this.setBackground(new Color(0xD8D5C4));
        this.addMouseListener(new ClickListener());

        objetosMapa = new LinkedList<>();
        GameObject.setTableroJuego(this);
        Enemigo.setGrilla(this);
        Torre.setGrilla(this);

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
        ponerObjetoMapa();
        colisionar();

        for (GameObject go: toDel)
            objetosMapa.remove(go);

        for (int i = 0; i < objetosMapa.size(); i++)
            objetosMapa.get(i).actualizar();

        verificarPerder();
        verificarOleadaNueva();
    }

    private void ponerObjetoMapa() {
        int x, y;
        Random rnd = new Random(System.currentTimeMillis());

        // Se agrega un objeto de mapa con un 0.5% de probabilidad
        if (rnd.nextInt() % 200 == 1) {
            x = rnd.nextInt(Constantes.VENTANA_ANCHO);
            y = rnd.nextInt(Constantes.PANEL_JUEGO_ALTO);
            switch (rnd.nextInt() % 2) {
                case 0:
                    addToObjects(new AgujeroNegro(x, y));
                    break;
                case 1:
                    addToObjects(new Meteorito(x, y));
                    break;
            }
        }
    }

    private synchronized void verificarPerder() {
        JLabel wasted;

        vp = new VisitorPerder();
        for (GameObject go: objetosMapa)
            go.aceptar(vp);

        if (vp.perdi()) {
            wasted = new JLabel();
            wasted.setIcon(new ImageIcon("src/Imagenes/perder.png"));
            wasted.setBounds(Constantes.VENTANA_ANCHO/5,0,Constantes.VENTANA_ANCHO, Constantes.PANEL_JUEGO_ALTO);

            for (GameObject go : objetosMapa)
                this.remove(go);
            this.add(wasted);
            this.repaint();

            objetosMapa.clear();
            ppal.pausar();
        }
    }

    private synchronized void verificarOleadaNueva() {
        vc = new VisitorContador();

        for (GameObject go: objetosMapa)
            go.aceptar(vc);

        if (vc.cantEnemigos() == 0) {
            nivel++;
            objetosMapa.addAll(nivelGen.generar(nivel));
        }
    }

    public synchronized void renderizar() {
        for (GameObject go: objetosMapa)
            go.repaint();
        this.repaint();
    }

    public synchronized void addToObjects(GameObject go) {
        objetosMapa.add(go);
        this.add(go);
    }

    public synchronized void delFromObjects(GameObject go) {
		toDel.add(go);
		this.remove(go);
    }

    public void liberarPosicion(int x, int y) {
        posicionesOcupadas[x][y] = false;
    }

    // Devuelve verdadero si la posicion (x, y) no esta
    // marcada como ocupada
    public boolean estaOcupada(int x, int y) {
        return posicionesOcupadas[x][y];
    }

    private void colisionar() {
        GameObject objectI, objectJ;

        // Colisionamos a los objetos entre ellos
        for (int i = 0; i < objetosMapa.size(); i++) {
            objectI = objetosMapa.get(i);
            for (int j = 0; j < objetosMapa.size(); j++) {
                objectJ = objetosMapa.get(j);
                if (objectI.distancia(objectJ) <= objectJ.obtenerAlcance())
                    objectI.aceptar(new VisitorAtaque(objectJ)); // Esto es equivalente a J.atacar(I)

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
                GameObject t = mediador.getObject();
                if (t != null) {
                    if (mediador.tengoOro()) {
                        t.setBounds(posX, posY, Constantes.ANCHO_CELDA, Constantes.ALTO_CELDA);
                        posicionesOcupadas[x][y] = true;
                        mediador.gastar(t.costo());
                        mediador.delObject();
                    } else
                        mediador.delObject();
                }
            } else
                mediador.delObject();
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