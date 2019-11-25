
package torres;

import control_grafico.GameObject;
import control_logico.Constantes;
import control_logico.Visitor;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Torre extends GameObject {

    protected int costo;
    protected int cuentaRegresiva;
    protected int vidaInicial;

    public Torre(int vida, int alcance, int impacto, ImageIcon graphic) {
        super(vida, alcance, impacto, graphic);
        this.puntaje = -this.puntaje;
        this.vidaInicial=vida;
        addMouseListener(new Vender());
    }

    public void actualizar(){
        if (this.vida.obtenerVida() <= 0)
            morir();
    }

    public int costo() {
        return costo;
    }

    public abstract Torre clone(int x, int y);

    public void aceptar(Visitor v) {
        v.visitar(this);
    }

    public void colisionar(Torre t){}
    public void colisionar(ProyectilAliado pa) {}

    public void colisionar(ProyectilEnemigo pe) {
        //pe.morir();
    }

    public void morir() {
        int posX = getX() - (getX() % Constantes.ANCHO_CELDA) + 15;
        int posY = getY() - (getY() % Constantes.ALTO_CELDA);
        int x = posX / Constantes.ANCHO_CELDA;
        int y = posY / Constantes.ALTO_CELDA;

        tableroJuego.liberarPosicion(x, y);
        tableroJuego.delFromObjects(this);
    }
    public void frenar() {}
    
    public boolean recibioDmg(){
    	return !(vidaInicial==this.vida.obtenerVida());
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
					inventario.actualizarOro(costo);
					tableroJuego.liberarPosicion(x, y);
					tableroJuego.delFromObjects(Torre.this);
				}else{
					System.out.print("no se puede vender");
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}

