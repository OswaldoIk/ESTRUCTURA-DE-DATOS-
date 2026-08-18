"""
Sesión 1 - Ejercicio 2: Estructuras repetitivas (FOR, WHILE, DO-WHILE simulado).

Python no tiene una instrucción nativa do-while; se simula con
`while True:` y una condición de salida (`break`) evaluada al final del
cuerpo del ciclo, garantizando al menos una ejecución.
"""

from typing import List


def leer_notas() -> List[float]:
    """
    Estructura WHILE: captura notas (0 a 10) hasta que el usuario escriba 'FIN'.
    Valida el rango y el tipo de dato en cada intento.
    """
    notas: List[float] = []
    entrada = ""

    print("\nIngrese las notas del alumno (0 a 10). Escriba 'FIN' para terminar:")
    while entrada.upper() != "FIN":
        entrada = input("Nota: ")

        if entrada.upper() != "FIN":
            try:
                nota = float(entrada)
                if 0 <= nota <= 10:
                    notas.append(nota)
                else:
                    print("Error: La nota debe estar entre 0 y 10.")
            except ValueError:
                print("Error: Ingrese un número válido o 'FIN'.")

    return notas


def calcular_reporte(notas: List[float]) -> None:
    """Estructura FOR: recorre la lista de notas y calcula promedio y nota máxima."""
    if not notas:
        print("\nNo se registraron notas válidas.")
        return

    suma_notas = 0.0
    nota_maxima = notas[0]

    for n in notas:
        suma_notas += n
        if n > nota_maxima:
            nota_maxima = n

    promedio = suma_notas / len(notas)

    print("\n--- REPORTE FINAL ---")
    print(f"Total de notas evaluadas: {len(notas)}")
    print(f"Nota promedio obtenida: {promedio:.2f}")
    print(f"La nota más alta fue: {nota_maxima}")


def main() -> None:
    """Menú principal. Simula un DO-WHILE: el menú se muestra al menos una vez."""
    while True:
        print("\n--- MENÚ DE CALIFICACIONES ---")
        print("1. Registrar y analizar notas")
        print("2. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            notas = leer_notas()
            calcular_reporte(notas)
        elif opcion == "2":
            print("\nSaliendo del sistema...")
            break  # Rompe el ciclo principal (simulación DO-WHILE)
        else:
            print("\nOpción inválida. Intente de nuevo.")

    print("Programa finalizado con éxito.")


if __name__ == "__main__":
    main()
