package control_logico;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import control_grafico.GameObject;
import enemigos.Enemigo;
import torres.Torre;

public class VisitorColision implements Visitor {

    protected GameObject colisionado;

    public VisitorColision() {
        colisionado = null;
    }

    public void setColisionado(GameObject go) {
        colisionado = go;
    }

    @Override
    public void visit(Torre t) {
        if (colisionado != null)
            colisionado.colisionar(t);
    }

    @Override
    public void visit(Enemigo e) {
        if (colisionado != null)
            colisionado.colisionar(e);
    }

    @Override
    public void visit(ProyectilAliado pa) {
        if (colisionado != null)
            colisionado.colisionar(pa);
    }

    @Override
    public void visit(ProyectilEnemigo pe) {
        if (colisionado != null)
            colisionado.colisionar(pe);
    }
}
