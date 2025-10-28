package es.etg.dam;

public class Main {

    public static final int BOAT_COUNT = 20;

    public static void main(String[] args) {
        EmergencyService service = new EmergencyService(new MarkdownReportGenerator());

        for (int i = 0; i < BOAT_COUNT; i++) {
            String id = String.format("B%02d", i);
            Boat boat = new Boat(id, service);
            boat.run();
        }

        service.waitForAllReports(BOAT_COUNT);

        service.generateReport();

        System.out.println("Informe generado: Informe.md en el directorio de trabajo.");
    }
}
