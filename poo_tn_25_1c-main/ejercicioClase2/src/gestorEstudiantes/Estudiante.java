package gestorEstudiantes;
import java.util.Scanner;


public class Estudiante {
    public String nombre;
    public int edad;
    public String numeroDeEstudiante;

    public void mostrarEstudiante() {
        System.out.println("Nombre: " +nombre);
        System.out.println("Edad: " +edad);
        System.out.println("Número de Estudiante: " + numeroDeEstudiante);
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

        do {
            System.out.print("Ingresa nueva edad: ");
            while(!scanner.hasNextInt()) {
                System.out.println("Ingresá un número válido.");
                scanner.next();
            }
            edad = scanner.nextInt();
            if (edad < 16 || edad > 100) {
                System.out.println("Edad inválida. Debe estar entre 16 y 100.");
            }
        } while (edad < 16 || edad > 100);

        scanner.nextLine();

        do {
            System.out.print("Ingresa nuevo número de estudiante (formato STU-AAAA-XXXX): ");
            numeroDeEstudiante = scanner.nextLine();
            if (!numeroDeEstudiante.matches("STU-\\d{4}-\\d{4}")) {
                System.out.println("Formato inválido. Ejemplo válido: STU-2025-0001");
            }
        } while (!numeroDeEstudiante.matches("STU-\\d{4}-\\d{4}"));
    }
}
