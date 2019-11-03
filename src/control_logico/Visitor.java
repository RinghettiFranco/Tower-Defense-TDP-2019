package control_logico;

import armas.ProyectilAliado;
import armas.ProyectilEnemigo;
import enemigos.Enemigo;
import torres.Torre;

public interface Visitor {

    void visitar(Torre t);
    void visitar(Enemigo e);
    void visitar(ProyectilAliado pa);
    void visitar(ProyectilEnemigo pe);
	
}
