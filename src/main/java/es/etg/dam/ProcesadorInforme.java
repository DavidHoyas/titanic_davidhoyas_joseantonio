package es.etg.dam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProcesadorInforme {

    public static final String INFORME = "src/main/resources/Informe.md";
    public static final String ERROR_INFORME = "Error al escribir el informe final.";
    public static final String SERVEMERGENCIA = "# SERVICIO DE EMERGENCIAS";
    public static final String SALTOLINEA = "\n";
    public static final String REALIZADO = "Ejecución realizada el día ";
    public static final String TOTALSALVADOS = "- Total Salvados ";
    public static final String TEXTMUJERES = "  - Mujeres ";
    public static final String TEXTHOMBRES = "  - HOMBRES ";
    public static final String TEXTNINOS = "  - NIÑOS ";

    public void generarInforme(List<String> datosBotes) {
        StringBuilder sb = new StringBuilder();

        sb.append(SERVEMERGENCIA + SALTOLINEA);
        sb.append(REALIZADO)
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm:ss")))
                .append("\n\n");

        int total = 0, mujeres = 0, hombres = 0, ninos = 0;

        for (String linea : datosBotes) {
            String[] partes = linea.split(";");
            if (partes.length != 5) {
                continue;
            }

            String id = partes[0];
            int t = Integer.parseInt(partes[1]);
            int m = Integer.parseInt(partes[2]);
            int h = Integer.parseInt(partes[3]);
            int n = Integer.parseInt(partes[4]);

            sb.append("## Bote ").append(id).append("\n\n");
            sb.append(TOTALSALVADOS).append(t).append("\n");
            sb.append(TEXTMUJERES).append(m).append("\n");
            sb.append(TEXTHOMBRES).append(h).append("\n");
            sb.append(TEXTNINOS).append(n).append("\n\n");

            total += t;
            mujeres += m;
            hombres += h;
            ninos += n;
        }

        sb.append("## Total\n\n");
        sb.append(TOTALSALVADOS).append(total).append("\n");
        sb.append(TEXTMUJERES).append(mujeres).append("\n");
        sb.append(TEXTHOMBRES).append(hombres).append("\n");
        sb.append(TEXTNINOS).append(ninos).append("\n");

        try {
            Files.writeString(Path.of(INFORME), sb.toString());
        } catch (IOException e) {
            System.err.println(ERROR_INFORME);
        }
    }
}
