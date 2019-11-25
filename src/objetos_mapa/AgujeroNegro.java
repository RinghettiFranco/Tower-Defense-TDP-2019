package objetos_mapa;

import control_logico.Visitor;
import enemigos.Enemigo;
import proyectiles.ProyectilAliado;
import proyectiles.ProyectilEnemigo;
import torres.Torre;

import javax.swing.*;

public class AgujeroNegro extends ObjetoMapa {
	
	 private static ImageIcon AgujeroNegro = new ImageIcon("src/Imagenes/AgujeroNegro.png");

    public AgujeroNegro(int vida, int alcance, int impacto) {
        super(vida, alcance, impacto, AgujeroNegro);
    }

    @Override
    public void aceptar(Visitor v) {

    }

    @Override
    public void colisionar(Torre t) {

    }

    @Override
    public void colisionar(Enemigo e) {

    }

    @Override
    public void colisionar(ProyectilAliado pa) {

    }

    @Override
    public void colisionar(ProyectilEnemigo pe) {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public void morir() {

    }

    @Override
    public AgujeroNegro clone(int posX, int posY) {
        return null;
    }
}
