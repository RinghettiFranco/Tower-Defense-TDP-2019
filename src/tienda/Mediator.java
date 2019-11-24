package tienda;

import control_grafico.GameObject;

public interface Mediator {

    void setObject(GameObject t);
    void delObject();
    GameObject getObject();

    boolean tengoOro();
    void gastar(int oro);
    void sumarOro(int cant);
}
