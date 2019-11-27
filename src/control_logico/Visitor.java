package control_logico;

import enemigos.Enemigo;
import objetos_jugador.ObjetosJugador;
import objetos_mapa.ObjetoMapa;
import premios.Premio;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

public interface Visitor {

    void visitar(Torre t);
    void visitar(Enemigo e);
    void visitar(ProyectilAliado pa);
    void visitar(ProyectilEnemigo pe);
	void visitar(ObjetosJugador oj);
	void visitar(ObjetoMapa om);
	void visitar(Premio p);
}
