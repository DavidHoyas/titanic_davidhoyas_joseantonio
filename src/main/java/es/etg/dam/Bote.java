package es.etg.dam;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bote {

    public static final Random RANDOM = new Random();

    private final String id;
    private final int total;
    private final int mujeres;
    private final int hombres;
    private final int ninios;

    public Bote(String id) {
        this.id = id;

        this.total = 10 + RANDOM.nextInt(91); // [10, 100]

        this.ninios = RANDOM.nextInt(total / 2 + 1);

        this.mujeres = RANDOM.nextInt(total - ninios + 1);

        this.hombres = total - ninios - mujeres;
    }

    @Override
    public String toString() {
        return String.format("Bote %s [Total=%d, Mujeres=%d, Hombres=%d, Niños=%d]",
                id, total, mujeres, hombres, ninios);
    }
}
