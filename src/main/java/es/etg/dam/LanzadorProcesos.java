package es.etg.dam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanzadorProcesos {

    public List<Process> lanzarBotes(int numBotes) throws IOException {
        List<Process> lista = new ArrayList<>();

        for (int i = 0; i < numBotes; i++) {
            String idBote = "B" + String.format("%02d", i);
            lista.add(lanzarBote(idBote));
        }

        return lista;
    }

    private Process lanzarBote(String id) throws IOException {
        String comando = "java com.titanic.procesos.Bote " + id;
        System.out.println("Lanzando proceso para " + id);
        return Runtime.getRuntime().exec(comando);
    }
}
