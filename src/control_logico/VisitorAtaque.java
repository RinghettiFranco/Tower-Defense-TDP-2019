package control_logico;

import control_grafico.GameObject;
import enemigos.Enemigo;
import objetos_jugador.ObjetosJugador;
import objetos_mapa.ObjetoMapa;
import premios.Premio;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
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

    @Override
    public void visitar(ObjetosJugador oj) {
        objeto.colisionar(oj);
    }

    @Override
    public void visitar(ObjetoMapa om) {
        objeto.colisionar(om);
    }

    @Override
    public void visitar(Premio p) {
        objeto.colisionar(p);
    }
}
