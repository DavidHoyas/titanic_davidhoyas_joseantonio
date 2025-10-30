package es.etg.dam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Bote {

    public static final String EXTENSION = ".txt";
    public static final Random RANDOM = new Random();
    public static final String ERRORBOTE = "\"Debe indicarse el ID del bote como argumento.\"";
    public static final String ID = "ID BOTE";
    public static final String ERROR = "ERROR AL ESCRIBIR EN EL FICHERO";
    public static final String TOTAL = "Total=%d%nMujeres=%d%nHombres=%d%nNiños=%d%n";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println(ERRORBOTE);
            System.exit(1);
        }

        String id = args[0];
        Path path = Path.of(id + EXTENSION);

        try {
            int espera = 2 + RANDOM.nextInt(5);
            Thread.sleep(espera * 1000L);

            int total = 1 + RANDOM.nextInt(100);
            int ninios = RANDOM.nextInt(total + 1);
            int mujeres = RANDOM.nextInt(total - ninios + 1);
            int hombres = total - ninios - mujeres;

            String contenido = String.format(
                    TOTAL,
                    total, mujeres, hombres, ninios
            );

            Files.writeString(path, contenido);

            System.out.println(ID + id);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
        }
    }
}
