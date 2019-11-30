package torres;

import control_grafico.GameObject;
import control_logico.Constantes;
import control_logico.Grilla;
import control_logico.Visitor;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Torre extends GameObject {

    protected static Grilla miGrilla;

    protected boolean escudo;
    protected int costo;
    protected int cuentaRegresiva;
    protected int vidaInicial;

    public Torre(int vidaInicial, int alcance, int impacto, ImageIcon graphic) {
        super(vidaInicial, alcance, impacto, graphic);
        this.puntaje = -this.puntaje;
        this.vidaInicial=vidaInicial;
        vida=vidaInicial;
        addMouseListener(new Vender());
    }
    
    public abstract void aplicarEscudo();

    public static void setGrilla(Grilla g) {
        miGrilla = g;
    }

    public void actualizar(){
        if (this.obtenerVida() <= 0)
            morir();
    }

    public int costo() {
        return costo;
    }

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void morir() {
        int posX = getX() - (getX() % Constantes.ANCHO_CELDA) + 15;
        int posY = getY() - (getY() % Constantes.ALTO_CELDA);
        int x = posX / Constantes.ANCHO_CELDA;
        int y = posY / Constantes.ALTO_CELDA;

        miGrilla.liberarPosicion(x, y);
        super.morir();
    }
    
    public boolean recibioDmg(){
    	return !(vidaInicial==this.obtenerVida());
    }
    
    private class Vender implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
            int posX = getX() - (getX() % Constantes.ANCHO_CELDA) + 15;
            int posY = getY() - (getY() % Constantes.ALTO_CELDA);
            int x = posX / Constantes.ANCHO_CELDA;
            int y = posY / Constantes.ALTO_CELDA;

            if(SwingUtilities.isRightMouseButton(e)){
				if(!recibioDmg()){
					inventario.actualizarOro((int) (costo*0.7));
					miGrilla.liberarPosicion(x, y);
					tableroJuego.delFromObjects(Torre.this);
				}else{
					System.out.print("no se puede vender");
				}
			}
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
    	
    }
}