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

        VisitorPerder vp = new VisitorPerder();
        // Movemos todos los objetos restantes del mapa
        for (GameObject go: objetosMapa) {
            go.actualizarPosicion();
            go.aceptar(vp);
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

    public synchronized void delFromObjects(List<GameObject> toDel) {
	for (GameObject go: toDel)
		objetosMapa.remove(go);
    }

    private void colisionar() {
        GameObject objectI, objectJ;
        VisitorAtaque v = new VisitorAtaque();

        // Colisionamos a los objetos entre ellos
        for (int i = 0; i < objetosMapa.size(); i++) {
            objectI = objetosMapa.get(i);
            for (int j = i+1; j < objetosMapa.size(); j++) {
                objectJ = objetosMapa.get(j);

                v.setObjeto(objectJ);
                objectI.aceptar(v);

                v.setObjeto(objectI);
                objectJ.aceptar(v);
            }

        }
    }

    private int distancia(Rectangle r1, Rectangle r2) {
        return (int) Math.sqrt(Math.pow(r2.x-r1.x, 2) + Math.pow(r2.y-r1.y, 2));
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

            if(posY<125){
            	posY=25;
            }else{
            	if(posY<225){
            		posY=125;
            	}else{
            		if(posY<325){
            			posY=225;
            		}else{
            			if(posY<425){
            				posY=325;
            			}else{
            				posY=425;
            			}
            		}
            	}
            }
            
            if(posX<125){
            	posX=25;
            }else{
            	if(posX<225){
            		posX=125;
            	}else{
            		if(posX<325){
            			posX=225;
            		}else{
            			if(posX<425){
            				posX=325;
            			}else{
            				if(posX<525){
            					posX=425;
            				}else{
            					if(posX<625){
            						posX=525;
            					}else{
            						if(posX<725){
            							posX=625;
            						}else{
            							if(posX<825){
            								posX=725;
            							}else{
            								posX=825;
            							}
            						}
            					}
            				}
            			}
            		}
            	}
            }
            
            if (mediador.tengoOro()) {
                Torre t = mediador.getObject().clone(posX, posY);
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

