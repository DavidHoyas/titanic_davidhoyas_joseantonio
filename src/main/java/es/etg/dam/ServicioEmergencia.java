package es.etg.dam;

import java.io.IOException;
import java.util.List;

public class ServicioEmergencia {

    public static final int NUM_BOTES = 20;
    public static final int TIEMPO_ESPERA_FINAL = 2000;
    public static final String CORRECTO = "Simulación finalizada. Informe generado en 'Informe.md'.";
    public static final String ERROR = "Error en el Servicio de Emergencias ";

    private final LanzadorProcesos lanzador = new LanzadorProcesos();
    private final ProcesadorInforme procesador = new ProcesadorInforme();

    public void ejecutarSimulacion() {
        try {

            List<Process> procesos = lanzador.lanzarBotes(NUM_BOTES);
            System.out.println(procesos.size());

            for (Process p : procesos) {
                p.waitFor();
            }

            Thread.sleep(TIEMPO_ESPERA_FINAL);

            procesador.generarInforme(NUM_BOTES);

            System.out.println(CORRECTO);

        } catch (IOException | InterruptedException e) {
            System.err.println(ERROR + e.getMessage());
            e.printStackTrace();
        }
    }
}
