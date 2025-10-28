package es.etg.dam;

public class Main {

    public static final int CONTADORBOTES = 20;

    public static void main(String[] args) {
        ServicioEmergencia servicio = new ServicioEmergencia(new GeneradorMD());

        for (int i = 0; i < CONTADORBOTES; i++) {
            String id = String.format("B%02d", i);
            Personas bote = new Personas(id, servicio);
            bote.run();
        }

        servicio.waitForAllReports(CONTADORBOTES);

        servicio.generateReport();

        System.out.println("Informe generado");
    }
}
