import java.util.Scanner;

/**
 * Ejercicio adicional: cálculo del factorial de cada número de la serie 1..n
 * (n <= 20, para no exceder el rango de long), usando ciclos anidados.
 *
 * Ciclo externo: recorre cada número de 1 a n.
 * Ciclo interno: calcula el factorial de ese número.
 */
public class FactorialSerie {

    private static final int LIMITE_MAXIMO = 20; // 20! aún cabe en un long

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = leerLimiteValido(scanner);

        System.out.println("\n--- FACTORIALES DE LA SERIE 1 a " + n + " ---");

        // Ciclo externo: recorre cada número de la serie
        for (int numero = 1; numero <= n; numero++) {
            long factorial = calcularFactorial(numero);
            System.out.printf("%d! = %d%n", numero, factorial);
        }

        scanner.close();
    }

    /** Solicita n validando que esté en el rango permitido (1 a 20). */
    private static int leerLimiteValido(Scanner scanner) {
        int n = -1;
        boolean esValido = false;

        while (!esValido) {
            System.out.print("Ingrese el límite superior de la serie (1 a " + LIMITE_MAXIMO + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: ingrese un número entero válido.");
                scanner.next();
            }
            n = scanner.nextInt();

            if (n < 1 || n > LIMITE_MAXIMO) {
                System.out.println("El valor debe estar entre 1 y " + LIMITE_MAXIMO + ".");
            } else {
                esValido = true;
            }
        }

        return n;
    }

    /** Ciclo interno: calcula el factorial de 'numero' mediante multiplicación acumulada. */
    private static long calcularFactorial(int numero) {
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
