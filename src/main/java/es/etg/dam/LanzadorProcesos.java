package es.etg.dam;

import java.io.IOException;

public class LanzadorProcesos {

    private static final String MSG_ERROR = "Error al ejecutar el comando";

    public void lanzarBote(String id) throws IOException {
        String comando = String.format("java -cp ./target/classes es.etg.dam.Bote %s", id);

        Process process = Runtime.getRuntime().exec(comando);

        System.out.println("Lanzado proceso para bote " + id);
    }
}
