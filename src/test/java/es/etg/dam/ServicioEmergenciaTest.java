package es.etg.dam;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ServicioEmergenciaTest {

    public static final String INFORME_EMERGENCIA = "El informe debe existir después de gestionar la emergencia";

    @Test
    void testGestionarEmergenciaGeneraInforme() {
        ServicioEmergencia servicio = new ServicioEmergencia();
        servicio.gestionarEmergencia(3);

        Path informe = Path.of(ProcesadorInforme.INFORME);
        assertTrue(Files.exists(informe), INFORME_EMERGENCIA);
    }
}
