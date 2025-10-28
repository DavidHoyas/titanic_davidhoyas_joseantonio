package es.etg.dam;

import java.util.Random;

public class Bote implements Runnable {

    public static final String id;
    public static final SERVICIOEMERGENCIA servicio;
    public static final Random RANDOM = new Random();

    public Bote(String id, ServicioEmergencia servicio) {
        this.id = id;
        this.servicio = servicio;
    }

}
