package es.etg.dam;

public class Main {

    public static final int CONTADOR_BOTES = 20;

    public static void main(String[] args) {
<<<<<<< HEAD
        ServicioEmergencia servicio = new ServicioEmergencia(new ProcesadorInforme());
=======
        // Creamos el servicio de emergencias
        ServicioEmergencia servicio = new ServicioEmergencia(new GeneradorMD());
>>>>>>> main

        // Lanzamos los botes en hilos independientes
        for (int i = 0; i < CONTADOR_BOTES; i++) {
            String id = String.format("B%02d", i);
            Personas bote = new Personas(id, servicio);
            Thread hilo = new Thread(bote);
            hilo.start();
        }

        // Esperamos a que todos los reportes se reciban
        servicio.waitForAllReports(CONTADOR_BOTES);

<<<<<<< HEAD
        servicio.generarInforme();
=======
        // Generamos el informe final
        servicio.generateReport();
>>>>>>> main

        System.out.println("Informe generado correctamente.");
    }
}
