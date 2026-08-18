import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Sesión 1 - Ejercicio 1: Estructuras de datos básicas en Java.
 *
 * Estructuras utilizadas:
 *   - record         -> Datos fijos del club, equivalente a una tupla inmutable.
 *   - Set (HashSet)  -> IDs únicos de miembros, sin duplicados.
 *   - Map (HashMap)  -> Perfiles de miembros, indexados por ID.
 *   - List (ArrayList) -> Fila de espera, colección ordenada y mutable.
 */
public class GestionClub {

    /** Registro inmutable (equivalente a una tupla en Python). */
    public record ClubInfo(String nombre, int anioFundacion) {
    }

    /** Crea el conjunto de IDs de miembros. Los duplicados son ignorados por el Set. */
    private static Set<Integer> registrarMiembros() {
        Set<Integer> miembrosId = new HashSet<>();
        miembrosId.add(101);
        miembrosId.add(102);
        miembrosId.add(103);
        miembrosId.add(104);
        miembrosId.add(101); // Intento de duplicado: Java lo ignora
        return miembrosId;
    }

    /** Crea el diccionario (Map) de perfiles de miembros. */
    private static Map<Integer, String> crearPerfiles() {
        Map<Integer, String> perfiles = new HashMap<>();
        perfiles.put(101, "Ana - Tenis");
        perfiles.put(102, "Luis - Natación");
        perfiles.put(103, "María - Tenis");
        perfiles.put(104, "Carlos - Fútbol");
        return perfiles;
    }

    /** Crea la fila de espera de ingreso al club. */
    private static List<String> crearFilaEspera() {
        List<String> filaEspera = new ArrayList<>();
        filaEspera.add("Elena");
        filaEspera.add("Pedro");
        filaEspera.add("Sofía"); // Agrega al final de la fila
        return filaEspera;
    }

    /** Imprime en consola el reporte completo del club. */
    private static void mostrarReporte(ClubInfo club, Set<Integer> miembrosId,
            Map<Integer, String> perfiles, List<String> filaEspera) {

        System.out.println("--- BIENVENIDO A " + club.nombre().toUpperCase()
                + " (Fundado en " + club.anioFundacion() + ") ---\n");

        System.out.println("IDs de miembros registrados (sin duplicados): " + miembrosId);

        System.out.println("\nLista de perfiles de miembros:");
        for (Map.Entry<Integer, String> entrada : perfiles.entrySet()) {
            System.out.println(" - ID " + entrada.getKey() + ": " + entrada.getValue());
        }

        System.out.println("\nPróximo en la fila de espera para ingresar: " + filaEspera.get(0));
        System.out.println("Fila de espera completa: " + filaEspera);
    }

    public static void main(String[] args) {
        ClubInfo club = new ClubInfo("Club Deportivo Alfa", 2026);
        Set<Integer> miembrosId = registrarMiembros();
        Map<Integer, String> perfiles = crearPerfiles();
        List<String> filaEspera = crearFilaEspera();

        mostrarReporte(club, miembrosId, perfiles, filaEspera);
    }
}
