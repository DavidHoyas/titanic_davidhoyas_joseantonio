package es.etg.dam;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bote {

    public static final String FORMATO_SALIDA = "%s;%d;%d;%d;%d%n";

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        String id = args[0];
        Random random = new Random();

        int total = 10 + random.nextInt(91);
        int ninos = random.nextInt(total / 2 + 1);
        int mujeres = random.nextInt(total - ninos + 1);
        int hombres = total - ninos - mujeres;

        System.out.printf(FORMATO_SALIDA, id, total, mujeres, hombres, ninos);
    }
}
