package control_grafico;

import control_logico.Constantes;
import control_logico.Mediator;
import tienda.ComprarChewy;
import tienda.ComprarHan;
import tienda.ComprarLuke;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TableroCompra extends JPanel {

    private int cantOro;

    private JLabel[] torres;
    private JLabel[] objetos;
    private JLabel labelOro;

    private Mediator mediator;

    public TableroCompra(Mediator med) {
        super();

        this.mediator = med;

        this.setLayout(new GridLayout(1, 6));
        this.setSize(Constantes.VENTANA_ANCHO,Constantes.PANEL_COMPRA_ALTO);
        this.setLocation(0, Constantes.PANEL_JUEGO_ALTO);
        this.setBackground(new Color(0x505668));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        cantOro = 100;

        inicializarTorres();
        inicializarObjetos();

        labelOro = new JLabel("Oro: " + cantOro);
        this.add(labelOro);
    }

    public int getCantOro() {
        return cantOro;
    }
    public void actualizarOro(int incremento) {
        cantOro += incremento;
        labelOro.setText("Oro: " + cantOro);

    }

    private void inicializarTorres() {
        this.torres = new JLabel[3];

        torres[0] = new ComprarHan(mediator);
        this.add(torres[0]);
        torres[1] = new ComprarChewy(mediator);
        this.add(torres[1]);
        torres[2] = new ComprarLuke(mediator);
        this.add(torres[2]);
    }

    private void inicializarObjetos() {
        this.objetos = new JLabel[2];

        objetos[0] = new JLabel("Obj0");
        this.add(objetos[0]);
        objetos[1] = new JLabel("Obj1");
        this.add(objetos[1]);
    }
}
