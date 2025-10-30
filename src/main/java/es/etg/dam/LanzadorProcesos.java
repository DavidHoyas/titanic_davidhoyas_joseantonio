package es.etg.dam;

import java.io.IOException;

public class LanzadorProcesos {

    public static final String LANZADOR = "Lanzado proceso para bote ";

    public void lanzarBote(String id) throws IOException {
        String comando = String.format("java -cp ./target/classes es.etg.dam.Bote %s", id);

        Process process = Runtime.getRuntime().exec(comando);

        System.out.println(LANZADOR + id);
    }
}
