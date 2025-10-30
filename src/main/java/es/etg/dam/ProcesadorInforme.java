package es.etg.dam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcesadorInforme {

    public static final String INFORME = "Informe.md";
    public static final String ERROR_ESCRITURA = "Error al escribir el informe final.";

    public void generarInforme(int numBotes) {
        StringBuilder sb = new StringBuilder();

        sb.append("# SERVICIO DE EMERGENCIAS\n\n");
        sb.append("Ejecución realizada el día ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm:ss")))
                .append("\n\n");

        int total = 0, mujeres = 0, hombres = 0, ninios = 0;

        for (int i = 0; i < numBotes; i++) {
            String id = "B" + String.format("%02d", i);
            Bote bote = new Bote(id);

            sb.append("## Bote ").append(bote.getId()).append("\n\n");
            sb.append("- Total Salvados ").append(bote.getTotal()).append("\n");
            sb.append("  - Mujeres ").append(bote.getMujeres()).append("\n");
            sb.append("  - Hombres ").append(bote.getHombres()).append("\n");
            sb.append("  - Niños ").append(bote.getNinios()).append("\n\n");

            total += bote.getTotal();
            mujeres += bote.getMujeres();
            hombres += bote.getHombres();
            ninios += bote.getNinios();
        }

        sb.append("## Total\n\n");
        sb.append("- Total Salvados ").append(total).append("\n");
        sb.append("  - Mujeres ").append(mujeres).append("\n");
        sb.append("  - Hombres ").append(hombres).append("\n");
        sb.append("  - Niños ").append(ninios).append("\n");

        try {
            Files.writeString(Path.of(INFORME), sb.toString());
            System.out.println("✅ Informe generado correctamente: " + INFORME);
        } catch (IOException e) {
            System.err.println(ERROR_ESCRITURA);
        }
    }

    public static void main(String[] args) {
        int numBotes = 10; 
        new ProcesadorInforme().generarInforme(numBotes);
    }
}
