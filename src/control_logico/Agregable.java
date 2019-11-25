package control_logico;

import control_grafico.GameObject;

public interface Agregable {

    void addToObjects(GameObject go);
    void delFromObjects(GameObject go);

    void liberarPosicion(int x, int y);
}
