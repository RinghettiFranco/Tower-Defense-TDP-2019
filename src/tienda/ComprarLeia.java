package tienda;

import control_logico.Constantes;
import torres.Leia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComprarLeia extends JLabel {

    protected Mediator mediador;

    public ComprarLeia(Mediator med) {
        super();

        this.setText("Leia");
        this.addMouseListener(new ClickListener());
        mediador = med;
    }

    private class ClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            mediador.setObject(new Leia(Constantes.MAX_INF, Constantes.MAX_INF));
            setForeground(Color.GREEN);
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
