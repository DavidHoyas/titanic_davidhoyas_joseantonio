package es.etg.dam;

import java.io.IOException;

public class LanzadorProcesos {

    public static final String COMMAND = "java -cp ./target/classes es.etg.dam.Bote %s";

    public Process lanzarBote(String id) throws IOException {
        String comando = String.format(COMMAND, id);
        return Runtime.getRuntime().exec(comando);
    }
}
