package control_logico;

import control_grafico.GameObject;

public interface Agregable {

    void addToObjects(GameObject go);
    void delFromObjects(GameObject go);

    void sumarOro(int cant);
}
