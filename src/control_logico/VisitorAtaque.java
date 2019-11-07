package control_logico;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import control_grafico.GameObject;
import enemigos.Enemigo;
import torres.Torre;

public class VisitorAtaque implements Visitor {

    protected GameObject objeto;

    public VisitorAtaque(GameObject go) {
        objeto = go;
    }

    @Override
    public void visitar(Torre t) {
        objeto.colisionar(t);
    }

    @Override
    public void visitar(Enemigo e) {
        objeto.colisionar(e);
    }

    @Override
    public void visitar(ProyectilAliado pa) {
        objeto.colisionar(pa);
    }

    @Override
    public void visitar(ProyectilEnemigo pe) {
        objeto.colisionar(pe);
    }
}
