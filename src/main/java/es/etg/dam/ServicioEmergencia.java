package es.etg.dam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServicioEmergencia {

    public final LanzadorProcesos lanzador = new LanzadorProcesos();
    public final ProcesadorInforme procesador = new ProcesadorInforme();
    public final Random random = new Random();
    public final static String ERROR = "Error lanzando bote ";
    public final static String CORRECTO = " generado correctamente"; 

    public void gestionarEmergencia(int numBotes) {
        List<String> resultados = new ArrayList<>();

        for (int i = 0; i < numBotes; i++) {
            String id = String.format("B%02d", i);

            try {
                int espera = 2000 + random.nextInt(4001);
                Thread.sleep(espera);
                System.out.println(id + CORRECTO);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            try {
                Process proceso = lanzador.lanzarBote(id);

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream()))) {

                    String linea = reader.readLine();
                    if (linea != null) {
                        resultados.add(linea);
                    }
                    proceso.waitFor();
                }

            } catch (IOException | InterruptedException e) {
                System.err.println(ERROR + id + ": " + e.getMessage());
            }
        }

        procesador.generarInforme(resultados);
    }
}
