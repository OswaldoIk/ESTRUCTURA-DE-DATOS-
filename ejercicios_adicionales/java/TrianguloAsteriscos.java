import java.util.Scanner;

/**
 * Ejercicio adicional: generación de un patrón de triángulo rectángulo de
 * asteriscos, con el número de filas indicado por el usuario.
 *
 * Ejemplo con filas = 4:
 *   *
 *   * *
 *   * * *
 *   * * * *
 */
public class TrianguloAsteriscos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filas = leerFilasValidas(scanner);

        System.out.println("\n--- TRIÁNGULO DE " + filas + " FILAS ---");
        dibujarTriangulo(filas);

        scanner.close();
    }

    /** Solicita el número de filas validando que sea mayor a 0. */
    private static int leerFilasValidas(Scanner scanner) {
        int filas = -1;
        boolean esValido = false;

        while (!esValido) {
            System.out.print("Ingrese el número de filas del triángulo: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: ingrese un número entero válido.");
                scanner.next();
            }
            filas = scanner.nextInt();

            if (filas <= 0) {
                System.out.println("El número de filas debe ser mayor a 0.");
            } else {
                esValido = true;
            }
        }

        return filas;
    }

    /** Ciclo externo: recorre cada fila. Ciclo interno: imprime los asteriscos de esa fila. */
    private static void dibujarTriangulo(int filas) {
        for (int fila = 1; fila <= filas; fila++) {
            StringBuilder linea = new StringBuilder();

            for (int columna = 1; columna <= fila; columna++) {
                linea.append("*");
                if (columna < fila) {
                    linea.append(" ");
                }
            }

            System.out.println(linea);
        }
    }
}
