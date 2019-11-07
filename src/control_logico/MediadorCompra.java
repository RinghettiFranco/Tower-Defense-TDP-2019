package control_logico;

import control_grafico.TableroCompra;
import torres.Chewbaca;
import torres.HanSolo;
import torres.LukeSkywalker;
import torres.Torre;

public class MediadorCompra implements Mediator {

    private Chewbaca chewy;
    private HanSolo hanSolo;
    private LukeSkywalker lukeSkywalker;

    private TableroCompra tienda;

    public MediadorCompra() {
        chewy = null;
        hanSolo = null;
        lukeSkywalker = null;
    }

    @Override
    public void setObject(Chewbaca chewy) {
        this.chewy = chewy;
        hanSolo = null;
        lukeSkywalker = null;
    }

    @Override
    public void setObject(HanSolo han) {
        this.hanSolo = han;
        chewy = null;
        lukeSkywalker = null;
    }

    @Override
    public void setObject(LukeSkywalker luke) {
        this.lukeSkywalker = luke;
        hanSolo = null;
        chewy = null;
    }

    @Override
    public void delObject() {
        if (chewy != null)
            chewy = null;

        if (hanSolo != null)
            hanSolo = null;

        if (lukeSkywalker != null)
            lukeSkywalker = null;
    }

    @Override
    public Torre getObject() {
        if (chewy != null)
            return chewy;

        if (hanSolo != null)
            return hanSolo;

        if (lukeSkywalker != null)
            return lukeSkywalker;

        // Nunca tendria que llegar aca
        return null;
    }

    public boolean tengoOro() {
        int oro = tienda.getCantOro();

        if (chewy != null)
            return chewy.costo() <= oro;

        if (hanSolo != null)
            return hanSolo.costo() <= oro;

        if (lukeSkywalker != null)
            return lukeSkywalker.costo() <= oro;

        return false;
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
