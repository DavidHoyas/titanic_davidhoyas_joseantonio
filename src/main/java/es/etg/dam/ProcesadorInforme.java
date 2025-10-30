package es.etg.dam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ProcesadorInforme {

    public static final String INFORME = "Informe.md";
    public static final String ERROR_ESCRITURA = "Error al escribir el informe final.";

    public void generarInforme(int numBotes) {
        StringBuilder sb = new StringBuilder();

        sb.append("# SERVICIO DE EMERGENCIAS\n\n");
        sb.append("Ejecución realizada el día ")
                .append(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm:ss")))
                .append("\n\n");

        // Totales globales
        int totalGlobal = 0;
        int mujeresGlobal = 0;
        int hombresGlobal = 0;
        int niniosGlobal = 0;

        Random random = new Random();

        for (int i = 0; i < numBotes; i++) {
            String id = "B" + String.format("%02d", i);
            int mujeres = random.nextInt(10);
            int hombres = random.nextInt(10);
            int ninios = random.nextInt(5);
            int total = mujeres + hombres + ninios;

            totalGlobal += total;
            mujeresGlobal += mujeres;
            hombresGlobal += hombres;
            niniosGlobal += ninios;

            sb.append("## Bote ").append(id).append("\n\n");
            sb.append("- Total Salvados: ").append(total).append("\n");
            sb.append("  - Mujeres: ").append(mujeres).append("\n");
            sb.append("  - Hombres: ").append(hombres).append("\n");
            sb.append("  - Niños: ").append(ninios).append("\n\n");
        }

        sb.append("## TOTAL GENERAL\n\n");
        sb.append("- Total Salvados: ").append(totalGlobal).append("\n");
        sb.append("  - Mujeres: ").append(mujeresGlobal).append("\n");
        sb.append("  - Hombres: ").append(hombresGlobal).append("\n");
        sb.append("  - Niños: ").append(niniosGlobal).append("\n\n");

        sb.append("---\n");
        sb.append("_Informe generado automáticamente._\n");

        try {
            Files.writeString(Path.of(INFORME), sb.toString());
            System.out.println("✅ Informe generado correctamente: " + INFORME);
        } catch (IOException e) {
            System.err.println(ERROR_ESCRITURA);
        }
    }

    public static void main(String[] args) {
        new ProcesadorInforme().generarInforme(20); // genera 20 botes dentro del mismo Markdown
    }
}
