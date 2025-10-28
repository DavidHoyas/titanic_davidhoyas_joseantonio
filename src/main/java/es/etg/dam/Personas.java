package es.etg.dam;

import java.util.Random;

public class Personas implements Runnable {

    public static final String id;
    public static final SERVICIOEMERGENCIA servicio;
    public static final Random RANDOM = new Random();

    public Bote(String id, ServicioEmergencia servicio) {
        this.id = id;
        this.servicio = servicio;
    }

    @Override
    public void run() {
        try {
            int espera = 2 + RANDOM.nextInt(5);
            Thread.sleep(espera * 1000L);

            int total = 1 + RANDOM.nextInt(100);
            int niños = RANDOM.nextInt(total + 1);
            int mujeres = RANDOM.nextInt(total - niños + 1);
            int hombres = total - niños - mujeres;

            servicio.mandar(new registros(id, total, mujeres, hombres, niños));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
