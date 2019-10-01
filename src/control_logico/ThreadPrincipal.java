package control_logico;

import control_grafico.TableroJuego;

public class ThreadPrincipal extends Thread {

    protected volatile boolean ejecutar;
    protected TableroJuego map;

    public ThreadPrincipal(TableroJuego m) {
        map = m;
        ejecutar = true;
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 30.0;
        double delta = 0.0;

        while (ejecutar) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                map.actualizar();
                delta--;
            }
            map.renderizar();
        }
    }

    public void pausar() {
        ejecutar = false;
    }

    public void reiniciar() {
        ejecutar =  true;
        run();
    }
}
