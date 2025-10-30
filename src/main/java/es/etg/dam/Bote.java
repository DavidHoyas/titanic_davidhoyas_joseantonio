package es.etg.dam;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bote {

    public static final Random RANDOM = new Random();

    private String id;
    private int total;
    private int mujeres;
    private int hombres;
    private int ninios;

    public Bote(String id) {
        this.id = id;

        this.total = 10 + RANDOM.nextInt(91);

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
