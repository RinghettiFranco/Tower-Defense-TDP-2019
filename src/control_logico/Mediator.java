package control_logico;

import torres.*;

public interface Mediator {

    void setObject(Chewbaca chewy);
    void setObject(HanSolo han);
    void setObject(LukeSkywalker luke);
    void setObject(Leia leia);
    void setObject(Ewok ewok);

    void delObject();

    Torre getObject();

    boolean tengoOro();
    void gastar(int oro);
    void sumarOro(int cant);
}
