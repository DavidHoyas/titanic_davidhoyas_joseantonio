package es.etg.dam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Registros {

    private final String id;
    private final int total;
    private final int mujeres;
    private final int hombres;
    private final int ninios;

}
