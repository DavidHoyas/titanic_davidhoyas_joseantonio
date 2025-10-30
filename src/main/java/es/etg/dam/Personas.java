package es.etg.dam;

import java.util.Random;

public class Personas implements Runnable {

    private final String id;
    private final ServicioEmergencia servicio;
    private static final Random RANDOM = new Random();

    public Personas(String id, ServicioEmergencia servicio) {
        this.id = id;
        this.servicio = servicio;
    }

    @Override
    public void run() {
        try {
            // Espera aleatoria de 2 a 6 segundos
            int espera = 2 + RANDOM.nextInt(5);
            Thread.sleep(espera * 1000L);

            // Generar datos aleatorios del bote
            int total = 1 + RANDOM.nextInt(100);
            int ninos = RANDOM.nextInt(total + 1);
            int mujeres = RANDOM.nextInt(total - ninos + 1);
            int hombres = total - ninos - mujeres;

            // Mandar el registro al servicio de emergencias
            servicio.mandar(new Registros(id, total, mujeres, hombres, ninos));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
