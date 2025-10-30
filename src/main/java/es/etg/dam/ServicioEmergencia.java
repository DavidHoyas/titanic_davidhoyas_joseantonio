package es.etg.dam;

import java.io.IOException;

public class ServicioEmergencia {

    public final LanzadorProcesos lanzador = new LanzadorProcesos();
    public final ProcesadorInforme procesador = new ProcesadorInforme();
    public final static String ERROR = "Error lanzando bote ";

    public void lanzarBotes(int numBotes) {
        for (int i = 0; i < numBotes; i++) {
            String id = String.format("B%02d", i);
            try {
                lanzador.lanzarBote(id);
            } catch (IOException e) {
                System.err.println(ERROR + id);
            }
        }
    }

    public void generarInforme(int numBotes) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        procesador.generarInforme(numBotes);
    }
}
