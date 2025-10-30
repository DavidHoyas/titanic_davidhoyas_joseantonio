package es.etg.dam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Registros {

    private String id;
    private int total;
    private int mujeres;
    private int hombres;
    private int ninos;

}
