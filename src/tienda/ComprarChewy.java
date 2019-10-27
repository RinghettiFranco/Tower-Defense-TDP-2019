package tienda;

import control_logico.Mediator;
import torres.Chewbaca;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComprarChewy extends JLabel {

    private Mediator med;

    public ComprarChewy(Mediator med) {
        super();

        this.setText("Chewbaca");
        this.addMouseListener(new ClickListener());
        this.med = med;
    }


    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.out.println("Chewy");
            med.setObject(new Chewbaca(0, 0));
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
