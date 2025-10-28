package es.etg.dam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProcesadorInforme {

    private static final String EXTENSION = ".txt";
    private static final String INFORME = "Informe.md";

    public void generarInforme(int numBotes) {
        StringBuilder sb = new StringBuilder();

        sb.append("# SERVICIO DE EMERGENCIAS\n\n");
        sb.append("Ejecución realizada el día ")
          .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm:ss")))
          .append("\n\n");

        int total = 0, mujeres = 0, varones = 0, ninos = 0;

        for (int i = 0; i < numBotes; i++) {
            String id = "B" + String.format("%02d", i);
            Path path = Path.of(id + EXTENSION);

            sb.append("## Bote ").append(id).append("\n\n");

            if (!Files.exists(path)) {
                sb.append("- Sin datos\n\n");
                continue;
            }

            try {
                List<String> lineas = Files.readAllLines(path);
                int t = getValor(lineas, "Total");
                int m = getValor(lineas, "Mujeres");
                int v = getValor(lineas, "Varones");
                int n = getValor(lineas, "Niños");

                sb.append("- Total Salvados ").append(t).append("\n");
                sb.append("  - Mujeres ").append(m).append("\n");
                sb.append("  - Varones ").append(v).append("\n");
                sb.append("  - Niños ").append(n).append("\n\n");

                total += t;
                mujeres += m;
                varones += v;
                ninos += n;

            } catch (IOException e) {
                System.err.println("Error leyendo el fichero del " + id);
            }
        }

        sb.append("## Total\n\n");
        sb.append("- Total Salvados ").append(total).append("\n");
        sb.append("  - Mujeres ").append(mujeres).append("\n");
        sb.append("  - Varones ").append(varones).append("\n");
        sb.append("  - Niños ").append(ninos).append("\n");

        try {
            Files.writeString(Path.of(INFORME), sb.toString());
        } catch (IOException e) {
            System.err.println("Error al escribir el informe final.");
        }
    }

    private int getValor(List<String> lineas, String clave) {
        for (String l : lineas) {
            if (l.startsWith(clave + "=")) {
                return Integer.parseInt(l.split("=")[1]);
            }
        }
        return 0;
    }
}
