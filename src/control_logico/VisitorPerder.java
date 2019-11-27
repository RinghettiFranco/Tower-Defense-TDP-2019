package control_logico;

import objetos_jugador.ObjetosJugador;
import objetos_mapa.ObjetoMapa;
import premios.Premio;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import enemigos.Enemigo;
import torres.Torre;

public class VisitorPerder implements Visitor {

    protected boolean perdi;

    public VisitorPerder() {
        perdi = false;
    }

    public void visitar(Torre t) {}
    public void visitar(ProyectilAliado pa) {}
    public void visitar(ProyectilEnemigo pe) {}
    public void visitar(ObjetosJugador oj) {}
    public void visitar(ObjetoMapa om) {}
    public void visitar(Premio p) {}

    public void visitar(Enemigo e) {
        if (!perdi)
            perdi = (e.getX() == 0);
    }

    public boolean perdi() {
        return perdi;
    }
}
