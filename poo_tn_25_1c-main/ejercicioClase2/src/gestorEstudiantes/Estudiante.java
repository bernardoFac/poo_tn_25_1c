package gestorEstudiantes;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Estudiante {
    public String nombre;
    public int edad;
    private final String idEstudiante;
    private static int parte1 = 1;
    private static int parte2 = 0;

    public Estudiante() {
        this.idEstudiante = generarId();
    }
    private int leerEdadValida(Scanner scanner) {
        int edadIngresada = -1;

        while (true) {
            System.out.print("Ingresa nueva edad: ");
            if (scanner.hasNextInt()) {
                edadIngresada = scanner.nextInt();
                if (edadIngresada >= 16 && edadIngresada <= 100) {
                    break;
                } else {
                    System.out.println("Edad inválida. Debe estar entre 16 y 100.");
                }
            } else {
                System.out.println("Ingresá un número válido.");
                scanner.next();
            }
        }
        return edadIngresada;
    }
    public void mostrarEstudiante() {
        System.out.println("Nombre: " +nombre);
        System.out.println("Edad: " +edad);
        System.out.println("ID: " + idEstudiante);
    }
    public static String generarId() {
        String id = String.format("STU-%04d-%04d", parte1, parte2);
        parte2++;
        if (parte2 > 9999) {
            parte2 = 0;
            parte1++;
        }
        return id;
    }
    public void actualizarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingresa nuevo nombre: ");
            nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()){
                System.out.println("El nombre no puede estar vacio");
            }
        } while (nombre.trim().isEmpty());

        edad = leerEdadValida(scanner);

    }
}
