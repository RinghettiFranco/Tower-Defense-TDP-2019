package control_grafico;

import control_logico.Constantes;
import control_logico.Inventario;
import tienda.Mediator;
import premios.Premio;
import tienda.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TableroCompra extends JPanel implements Inventario {

    private int cantOro;

    private JLabel[] torres, objetos;
    private JPanel panelObjetos;
    private JLabel labelOro;

    private Mediator mediator;

    public TableroCompra(Mediator med) {
        super();

        this.panelObjetos = new JPanel(new GridLayout(2, 2));
        panelObjetos.setBackground(new Color(0x505668));
        this.mediator = med;

        this.setLayout(new GridLayout(1, 6));
        this.setSize(Constantes.VENTANA_ANCHO,Constantes.PANEL_COMPRA_ALTO);
        this.setLocation(0, Constantes.PANEL_JUEGO_ALTO);
        this.setBackground(new Color(0x505668));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        cantOro = 25;

        inicializarTorres();
        inicializarObjetos();

        labelOro = new JLabel("Oro: " + cantOro);
        this.add(labelOro);

        GameObject.setInventario(this);
    }

    public int getCantOro() {
        return cantOro;
    }

    public void actualizarOro(int incremento) {
        cantOro += incremento;
        labelOro.setText("Oro: " + cantOro);

    }

    public void limpiarSeleccion() {
        for (int i = 0; i < 5; i++)
            torres[i].setForeground(Color.BLACK);
        for (int i = 0; i < 4; i++)
            objetos[i].setForeground(Color.BLACK);
    }

    private void inicializarTorres() {
        this.torres = new JLabel[5];

        torres[0] = new ComprarHan(mediator);
        this.add(torres[0]);
        torres[1] = new ComprarChewy(mediator);
        this.add(torres[1]);
        torres[2] = new ComprarLuke(mediator);
        this.add(torres[2]);
        torres[3] = new ComprarLeia(mediator);
        this.add(torres[3]);
        torres[4] = new ComprarEwok(mediator);
        this.add(torres[4]);
    }

    private void inicializarObjetos() {
        this.objetos = new JLabel[4];

        objetos[0] = new ComprarR2D2(mediator);
        panelObjetos.add(objetos[0]);
        objetos[1] = new ComprarEspinas(mediator);
        panelObjetos.add(objetos[1]);
        objetos[2] = new ComprarBarrera(mediator);
        panelObjetos.add(objetos[2]);
        objetos[3] = new ComprarBarrera(mediator);
        panelObjetos.add(objetos[3]);

        this.add(panelObjetos);
    }

    @Override
    public void addPremio(Premio p) {
        System.out.println("Not yet implemented");
    }
}
