package control_logico;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import control_grafico.GameObject;
import enemigos.Enemigo;
import torres.Torre;

public class VisitorAtaque implements Visitor {

    protected GameObject objeto;

    public void setObjeto(GameObject go) {
        objeto = go;
    }

    public VisitorAtaque(GameObject go) {
        objeto = go;
    }

    @Override
    public void visitar(Torre t) {
        objeto.atacar(t);
    }

    @Override
    public void visitar(Enemigo e) {
        objeto.atacar(e);
    }

    @Override
    public void visitar(ProyectilAliado pa) {
        objeto.atacar(pa);
    }

    @Override
    public void visitar(ProyectilEnemigo pe) {
        objeto.atacar(pe);
    }
}
