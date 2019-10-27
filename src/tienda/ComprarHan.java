package tienda;

import control_logico.Mediator;
import torres.HanSolo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComprarHan extends JLabel {

    private Mediator med;

    public ComprarHan(Mediator med) {
        super();

        this.setText("HanSolo");
        this.addMouseListener(new ClickListener());
        this.med = med;
    }

    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.out.println("Han");
            med.setObject(new HanSolo(0, 0));

            //setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
