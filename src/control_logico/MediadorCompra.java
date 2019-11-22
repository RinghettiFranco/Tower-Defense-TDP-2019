package control_logico;

import control_grafico.TableroCompra;
import torres.*;

public class MediadorCompra implements Mediator {

    protected Torre miTorre;

    private TableroCompra tienda;

    public MediadorCompra() {
        miTorre = null;
    }

    @Override
    public void setObject(Torre t) {
        tienda.limpiarSeleccion();
        miTorre = t;
    }

    @Override
    public void delObject() {
        miTorre = null;
        tienda.limpiarSeleccion();
    }

    @Override
    public Torre getObject() {
        return miTorre;
    }

    public boolean tengoOro() {
        int oro = tienda.getCantOro();

        return miTorre.costo() <= oro;
    }

    public void setTienda(TableroCompra tienda) {
        this.tienda = tienda;
    }

    public void gastar(int oro) {
        tienda.actualizarOro(-oro);
    }

    public void sumarOro(int cant) {
        tienda.actualizarOro(cant);
    }
}
