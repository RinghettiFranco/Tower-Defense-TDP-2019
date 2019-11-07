package control_logico;

import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import enemigos.Enemigo;
import torres.Torre;

public class VisitorPerder implements Visitor {

    protected boolean perdi;

    public VisitorPerder() {
        perdi = false;
    }
    @Override
    public void visitar(Torre t) {}

    @Override
    public void visitar(ProyectilAliado pa) {}

    @Override
    public void visitar(ProyectilEnemigo pe) {}

    @Override
    public void visitar(Enemigo e) {
        if (!perdi)
            perdi = (e.getX() == 0);
    }

    public boolean perdi() {
        return perdi;
    }
}
