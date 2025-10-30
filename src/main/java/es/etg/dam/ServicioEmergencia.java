package es.etg.dam;

import java.io.IOException;

public class ServicioEmergencia {

    private final LanzadorProcesos lanzador = new LanzadorProcesos();
    private final ProcesadorInforme procesador = new ProcesadorInforme();

    public void lanzarBotes(int numBotes) {
        for (int i = 0; i < numBotes; i++) {
            String id = String.format("B%02d", i);
            try {
                lanzador.lanzarBote(id);
            } catch (IOException e) {
                System.err.println("Error lanzando bote " + id);
            }
        }
    }

    public void generarInforme(int numBotes) {
        try {
            // Esperamos unos segundos a que terminen los botes
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        procesador.generarInforme(numBotes);
    }
}
