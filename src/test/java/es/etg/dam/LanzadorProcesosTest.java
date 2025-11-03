package es.etg.dam;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class LanzadorProcesosTest {

    @Test
    void testLanzarBoteNoLanzaExcepcion() {
        LanzadorProcesos lanzador = new LanzadorProcesos();

        assertDoesNotThrow(() -> {
            Process proceso = lanzador.lanzarBote("B00");
            assertNotNull(proceso);
        });
    }
}

