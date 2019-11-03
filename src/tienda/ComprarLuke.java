package tienda;

import control_logico.Constantes;
import control_logico.Mediator;
import torres.LukeSkywalker;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComprarLuke extends JLabel {

    private Mediator med;

    public ComprarLuke(Mediator med) {
        super();

        this.setText("Luke Skywalker");
        this.addMouseListener(new ClickListener());
        this.med = med;
    }

    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            med.setObject(new LukeSkywalker(Constantes.MAX_INF,Constantes.MAX_INF));
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
