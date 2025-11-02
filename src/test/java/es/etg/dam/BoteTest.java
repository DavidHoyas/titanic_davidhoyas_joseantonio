package es.etg.dam;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoteTest {

    public static final String VERIFICACION_DISPLAY = "Verifica que la constante FORMATO_SALIDA sea correcta";
    public static final String FORMATO_MESSAGE = "El formato de salida no coincide con el esperado";
    public static final String SIMULADOR_DISPLAY = "Simula datos generados por el main y comprueba coherencia";
    public static final String TOTAL_ASSERT = "Total debe estar entre 10 y 100";
    public static final String NINIOS_ASSERT = "Nadie puede tener valores negativos";
    public static final String SUMA_ASSERT = "La suma debe coincidir con el total";
    public static final String SALIDA_ID = "La salida debe incluir el ID del bote";
    public static final String SALIDA_SEPARADORES = "La salida debe tener separadores ';'";
    public static final String EJECUTADOR_DISPLAY = "Ejecutar main sin argumentos no lanza errores";
    public static final String METODO = "El método main debe manejar correctamente la falta de argumentos";

    @Test
    @DisplayName(VERIFICACION_DISPLAY)
    void testFormatoSalidaConstante() {
        assertEquals("%s;%d;%d;%d;%d%n", Bote.FORMATO_SALIDA,
                FORMATO_MESSAGE);
    }

    @Test
    @DisplayName(SIMULADOR_DISPLAY)
    void testDatosGeneradosSonValidos() {
        Random random = new Random();

        String id = "B01";
        int total = 10 + random.nextInt(91);
        int ninios = random.nextInt(total / 2 + 1);
        int mujeres = random.nextInt(total - ninios + 1);
        int hombres = total - ninios - mujeres;

        assertTrue(total >= 10 && total <= 100, TOTAL_ASSERT);
        assertTrue(ninios >= 0 && mujeres >= 0 && hombres >= 0, NINIOS_ASSERT);
        assertEquals(total, ninios + mujeres + hombres, SUMA_ASSERT);

        String salida = String.format(Bote.FORMATO_SALIDA, id, total, mujeres, hombres, ninios);
        assertTrue(salida.contains(id), SALIDA_ID);
        assertTrue(salida.contains(";"), SALIDA_SEPARADORES);
    }

    @Test
    @DisplayName(EJECUTADOR_DISPLAY)
    void testMainSinArgumentos() {
        assertDoesNotThrow(() -> Bote.main(new String[]{}),
                METODO);
    }
}
