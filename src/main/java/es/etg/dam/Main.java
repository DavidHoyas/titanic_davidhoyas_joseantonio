package es.etg.dam;

public class Main {

    public static final int NUM_BOTES = 20;
    public static final String INFORME = "Informe generado correctamente: Informe.md";

    public static void main(String[] args) {

        ServicioEmergencia servicio = new ServicioEmergencia();

        servicio.lanzarBotes(NUM_BOTES);

        servicio.generarInforme(NUM_BOTES);

        System.out.println(INFORME);
    }
}
