package es.etg.dam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServicioEmergencia {

    public final LanzadorProcesos LANZADOR = new LanzadorProcesos();
    public final ProcesadorInforme PROCESADOR = new ProcesadorInforme();
    public final Random RANDOM = new Random();
    public final static String ERROR = "Error lanzando bote ";
    public final static String CORRECTO = " generado correctamente";
    public final static String IDBOTES = "B%02d";

    public void gestionarEmergencia(int numBotes) {
        List<String> resultados = new ArrayList<>();

        for (int i = 0; i < numBotes; i++) {
            String id = String.format(IDBOTES, i);

            try {
                int espera = 2000 + RANDOM.nextInt(4001);
                Thread.sleep(espera);
                System.out.println(id + CORRECTO);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            try {
                Process proceso = LANZADOR.lanzarBote(id);

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

        PROCESADOR.generarInforme(resultados);
    }
}
