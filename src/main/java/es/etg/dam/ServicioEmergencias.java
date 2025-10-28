package es.etg.dam;

import java.io.IOException;
import java.util.List;

public class ServicioEmergencias {

    private static final int NUM_BOTES = 20;
    private static final int TIEMPO_ESPERA_FINAL = 2000;

    private final LanzadorProcesos lanzador = new LanzadorProcesos();
    private final ProcesadorInforme procesador = new ProcesadorInforme();

    public void ejecutarSimulacion() {
        try {
            System.out.println("Iniciando simulación del Titanic...");

            List<Process> procesos = lanzador.lanzarBotes(NUM_BOTES);
            System.out.println("Se han lanzado " + procesos.size() + " procesos de botes.");

            for (Process p : procesos) {
                p.waitFor();
            }

            Thread.sleep(TIEMPO_ESPERA_FINAL);

            procesador.generarInforme(NUM_BOTES);

            System.out.println("Simulación finalizada. Informe generado en 'Informe.md'.");

        } catch (IOException | InterruptedException e) {
            System.err.println("❌ Error en el Servicio de Emergencias: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
