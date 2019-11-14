package control_logico;

import torres.*;

public interface Mediator {

    void setObject(Torre t);
    void delObject();
    Torre getObject();

    boolean tengoOro();
    void gastar(int oro);
    void sumarOro(int cant);
}
