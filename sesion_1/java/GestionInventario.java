import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sesión 1 - Ejercicio 2: Estructuras repetitivas (DO-WHILE, WHILE, FOR)
 * aplicadas a un sistema de registro de productos con cálculo de IVA y descuento.
 */
public class GestionInventario {

    private static final double IVA = 0.19;          // 19 % de impuesto fijo
    private static final double UMBRAL_DESCUENTO = 100000; // Umbral para aplicar descuento
    private static final double PORCENTAJE_DESCUENTO = 0.10; // 10 % de descuento

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Estructura DO-WHILE: el menú se muestra al menos una vez antes de evaluar la salida
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE INVENTARIO ---");
            System.out.println("1. Registrar lote de productos");
            System.out.println("2. Salir del programa");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            if (opcion == 1) {
                procesarLote(scanner);
            } else if (opcion != 2) {
                System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 2); // Condición de permanencia del menú principal

        System.out.println("\nPrograma finalizado correctamente.");
        scanner.close();
    }

    /** Captura los precios de un lote y muestra el reporte con IVA y descuento. */
    private static void procesarLote(Scanner scanner) {
        ArrayList<Double> precios = capturarPrecios(scanner);

        if (precios.isEmpty()) {
            System.out.println("\nNo se registraron productos en este lote.");
            return;
        }

        generarReporte(precios);
    }

    /** Estructura WHILE: captura precios de forma indefinida hasta la condición de parada. */
    private static ArrayList<Double> capturarPrecios(Scanner scanner) {
        ArrayList<Double> precios = new ArrayList<>();

        System.out.println("\nIngrese los precios base de los productos.");
        System.out.println("Ingrese un valor menor o igual a 0 para terminar de registrar.");

        while (true) {
            System.out.print("Precio del producto: $");
            while (!scanner.hasNextDouble()) {
                System.out.println("Error: Ingrese un valor numérico decimal.");
                scanner.next();
            }
            double precio = scanner.nextDouble();

            if (precio <= 0) {
                break; // Condición de salida del ciclo de captura
            }
            precios.add(precio);
        }

        return precios;
    }

    /** Estructura FOR: procesa la lista de precios de tamaño definido y calcula el reporte. */
    private static void generarReporte(ArrayList<Double> precios) {
        double sumaBase = 0;
        double totalConIVA = 0;

        System.out.println("\n--- PROCESANDO LOTE ---");

        for (int i = 0; i < precios.size(); i++) {
            double precioActual = precios.get(i);
            sumaBase += precioActual;

            double precioConIva = precioActual * (1 + IVA);
            totalConIVA += precioConIva;

            System.out.printf("Producto %d: Base $%.2f -> Con IVA $%.2f%n",
                    (i + 1), precioActual, precioConIva);
        }

        double descuento = (totalConIVA > UMBRAL_DESCUENTO) ? totalConIVA * PORCENTAJE_DESCUENTO : 0;
        double totalFinal = totalConIVA - descuento;

        System.out.println("\n--- RESUMEN DEL REPORTE ---");
        System.out.printf("Total productos registrados: %d%n", precios.size());
        System.out.printf("Costo total base: $%.2f%n", sumaBase);
        System.out.printf("Costo total con IVA (19%%): $%.2f%n", totalConIVA);
        System.out.printf("Descuento aplicado (10%%): $%.2f%n", descuento);
        System.out.printf("VALOR NETO A PAGAR: $%.2f%n", totalFinal);
    }
}
