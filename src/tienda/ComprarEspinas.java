package tienda;

import control_logico.Constantes;
import objetos_jugador.Espinas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComprarEspinas extends JLabel {
    private Mediator med;

    public ComprarEspinas(Mediator med) {
        super();

        this.setText("Espinas");
        this.addMouseListener(new ClickListener());
        this.med = med;
    }


    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            med.setObject(new Espinas(Constantes.MAX_INF, Constantes.MAX_INF));
            setForeground(Color.GREEN);
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
