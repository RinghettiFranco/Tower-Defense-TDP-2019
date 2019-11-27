package control_logico;

import enemigos.Enemigo;
import objetos_jugador.ObjetosJugador;
import objetos_mapa.ObjetoMapa;
import premios.Premio;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

public class VisitorContador implements Visitor {
    private int cantEnemigos;

    public VisitorContador() {
        cantEnemigos = 0;
    }

    public void visitar(Torre t) {}
    public void visitar(ProyectilAliado pa) {}
    public void visitar(ProyectilEnemigo pe) {}
    public void visitar(ObjetosJugador oj) {}
    public void visitar(ObjetoMapa om) {}
    public void visitar(Premio p) {}

    public void visitar(Enemigo e) {
        cantEnemigos++;
    }

    public int cantEnemigos() {
        return cantEnemigos;
    }
}
