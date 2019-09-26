package control_grafico;

import controlador.Colisionador;
import controlador.Constantes;
import controlador.GeneradorNivel;
import controlador.ThreadPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class TableroJuego extends JPanel {

    private int nivel;

    private Colisionador colisionador;
    private GeneradorNivel nivelGen;
    private List<GameObject> objetosMapa;

    private TableroPuntos puntaje;
    private TableroCompra compras;

    private ThreadPrincipal ppal;

    public TableroJuego(TableroPuntos tp, TableroCompra tc) {
        super();

        this.setLayout(null);
        this.setSize(Constantes.VENTANA_ANCHO, Constantes.PANEL_TABLERO_ALTO);
        this.setLocation(0, Constantes.PANEL_PUNTOS_ALTO);
        this.setBackground(new Color(0xD8D5C4));
        
        JButton detonar = new JButton("Detonar");
        detonar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		GameObject toDetonate = nivelGen.devolverEnemigo(objetosMapa);
        		nivelGen.removerEnemigo(objetosMapa, toDetonate);
        		puntaje.actualizarPuntaje(100);
        	}
        });
        detonar.setBounds(50, 50, 50, 50);
        this.add(detonar);
        detonar.setVisible(true);

        iniciarJuego();

        colisionador = new Colisionador();
        ppal = new ThreadPrincipal(this);
        puntaje = tp;
        compras = tc;
        ppal.start();
    }

    public void actualizar() {
        // Colisionamos todo con todo O(n^2)
        //   Si un enemigo muere, sumammos los puntos y lo sacamos el mapa
        //   Si una torre muere, la sacamos del mapa

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

    private void iniciarJuego() {
        nivel = 1;
        nivelGen = new GeneradorNivel(nivel);

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

