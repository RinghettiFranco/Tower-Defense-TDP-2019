package control_logico;

import torres.Chewbaca;
import torres.HanSolo;
import torres.LukeSkywalker;
import torres.Torre;

public interface Mediator {

    void setObject(Chewbaca chewy);
    void setObject(HanSolo han);
    void setObject(LukeSkywalker luke);

    void delObject();

    Torre getObject();

    boolean tengoOro();
    void gastar(int oro);
    void sumarOro(int cant);
}
