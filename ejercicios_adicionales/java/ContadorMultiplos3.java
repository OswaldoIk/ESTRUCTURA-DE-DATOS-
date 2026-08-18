import java.util.Scanner;

/**
 * Ejercicio adicional: conteo de múltiplos de 3 en el rango 1..n, usando un
 * contador acumulador y funciones modulares independientes.
 */
public class ContadorMultiplos3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de n (límite superior del rango 1..n): ");
        int n = leerEnteroPositivo(scanner);

        int cantidadMultiplos = contarMultiplosDeTres(n);
        int sumaMultiplos = sumarMultiplosDeTres(n);

        System.out.println("\n--- REPORTE DE MÚLTIPLOS DE 3 (1 a " + n + ") ---");
        System.out.println("Cantidad de múltiplos de 3 encontrados: " + cantidadMultiplos);
        System.out.println("Suma total de esos múltiplos: " + sumaMultiplos);

        scanner.close();
    }

    /** Valida que el valor ingresado sea un entero mayor a 0. */
    private static int leerEnteroPositivo(Scanner scanner) {
        int valor = -1;
        boolean esValido = false;

        while (!esValido) {
            while (!scanner.hasNextInt()) {
                System.out.println("Error: ingrese un número entero válido.");
                scanner.next();
            }
            valor = scanner.nextInt();

            if (valor <= 0) {
                System.out.print("El valor debe ser mayor a 0. Intente de nuevo: ");
            } else {
                esValido = true;
            }
        }

        return valor;
    }

    /** Contador: recorre 1..n y acumula cuántos números son múltiplos de 3. */
    private static int contarMultiplosDeTres(int n) {
        int contador = 0;
        for (int numero = 1; numero <= n; numero++) {
            if (esMultiploDeTres(numero)) {
                contador++;
            }
        }
        return contador;
    }

    /** Acumulador: recorre 1..n y suma los valores que son múltiplos de 3. */
    private static int sumarMultiplosDeTres(int n) {
        int suma = 0;
        for (int numero = 1; numero <= n; numero++) {
            if (esMultiploDeTres(numero)) {
                suma += numero;
            }
        }
        return suma;
    }

    /** Función modular: determina si un número es múltiplo de 3. */
    private static boolean esMultiploDeTres(int numero) {
        return numero % 3 == 0;
    }
}
