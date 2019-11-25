package control_logico;

import enemigos.Enemigo;
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

    @Override
    public void visitar(Enemigo e) {
        cantEnemigos++;
    }

    public int cantEnemigos() {
        return cantEnemigos;
    }
}
