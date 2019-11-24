package tienda;

import control_grafico.GameObject;
import control_grafico.TableroCompra;
import torres.*;

public class MediadorCompra implements Mediator {

    protected GameObject miObjeto;

    private TableroCompra tienda;

    public MediadorCompra() {
        miObjeto = null;
    }

    @Override
    public void setObject(GameObject t) {
        tienda.limpiarSeleccion();
        miObjeto = t;
    }

    @Override
    public void delObject() {
        miObjeto = null;
        tienda.limpiarSeleccion();
    }

    @Override
    public GameObject getObject() {
        return miObjeto;
    }

    public boolean tengoOro() {
        int oro = tienda.getCantOro();

        return miObjeto.costo() <= oro;
    }

    public void setTienda(TableroCompra tienda) {
        this.tienda = tienda;
    }

    public void gastar(int oro) {
        tienda.actualizarOro(-oro);
    }

    public void sumarOro(int oro) {
        tienda.actualizarOro(oro);
    }
}
