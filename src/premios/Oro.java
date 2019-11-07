package premios;

import control_grafico.TableroJuego;
import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Oro extends ObjetoMapa {

    protected static ImageIcon oro = new ImageIcon("");

    protected int cantOro;

    public Oro(int x, int y, int cant) {
        super(1, 1, 1, oro);
        this.hitBox = new Rectangle(x, y, 100, 100);
        this.setBounds(hitBox);

        cantOro = cant;

        this.addMouseListener(new ClickListener());
    }

    @Override
    public void aceptar(Visitor v) {}

    @Override
    public void atacar(Torre t) {}

    @Override
    public void atacar(Enemigo e) {}

    @Override
    public void atacar(ProyectilAliado pa) {}

    @Override
    public void atacar(ProyectilEnemigo pe) {}

    @Override
    public void actualizarPosicion() {}

    @Override
    public void morir() {}

    private class ClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            // Aca iria el tema de incrementar la cantidad de oro
            TableroJuego t = (TableroJuego) tableroJuego;

            tableroJuego.sumarOro(cantOro);
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
