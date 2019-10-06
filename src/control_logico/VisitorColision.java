package control_logico;

import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
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
        colisionado.colisionar(t);
    }

    @Override
    public void visit(Enemigo e) {
        colisionado.colisionar(e);
    }

    @Override
    public void visit(ProyectilAliado pa) {
        colisionado.colisionar(pa);
    }

    @Override
    public void visit(ProyectilEnemigo pe) {
        colisionado.colisionar(pe);
    }
}
