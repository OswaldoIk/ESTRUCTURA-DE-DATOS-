import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ejercicio adicional: captura de N estudiantes por teclado y generación de
 * un listado concatenado, usando un ciclo FOR de tamaño definido.
 */
public class CapturaEstudiantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes desea registrar? ");
        int cantidad = leerEnteroValido(scanner);

        List<String> estudiantes = capturarEstudiantes(scanner, cantidad);
        String listado = concatenarListado(estudiantes);

        System.out.println("\n--- LISTADO DE ESTUDIANTES REGISTRADOS ---");
        System.out.println(listado);

        scanner.close();
    }

    /** Valida que la entrada sea un entero positivo antes de continuar. */
    private static int leerEnteroValido(Scanner scanner) {
        int valor = -1;
        boolean esValido = false;

        while (!esValido) {
            while (!scanner.hasNextInt()) {
                System.out.println("Error: ingrese un número entero válido.");
                scanner.next();
            }
            valor = scanner.nextInt();

            if (valor <= 0) {
                System.out.print("La cantidad debe ser mayor a 0. Intente de nuevo: ");
            } else {
                esValido = true;
            }
        }

        scanner.nextLine(); // Limpia el salto de línea pendiente antes de usar nextLine()
        return valor;
    }

    /** Ciclo FOR de tamaño definido: captura el nombre de cada estudiante. */
    private static List<String> capturarEstudiantes(Scanner scanner, int cantidad) {
        List<String> estudiantes = new ArrayList<>();

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Nombre del estudiante " + i + ": ");
            String nombre = scanner.nextLine().trim();
            estudiantes.add(nombre);
        }

        return estudiantes;
    }

    /** Concatena los nombres en un solo listado separado por comas. */
    private static String concatenarListado(List<String> estudiantes) {
        StringBuilder listado = new StringBuilder();

        for (int i = 0; i < estudiantes.size(); i++) {
            listado.append(estudiantes.get(i));
            if (i < estudiantes.size() - 1) {
                listado.append(", ");
            }
        }

        return listado.toString();
    }
}
