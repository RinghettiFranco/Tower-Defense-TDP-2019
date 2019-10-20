package control_logico;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import enemigos.Enemigo;
import torres.Torre;

public interface Visitor{

    void visit(Torre t);
    void visit(Enemigo e);
    void visit(ProyectilAliado pa);
    void visit(ProyectilEnemigo pe);
}
