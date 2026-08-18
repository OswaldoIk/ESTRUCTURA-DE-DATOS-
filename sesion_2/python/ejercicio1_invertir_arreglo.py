"""
Sesión 2 - Ejercicio 1: Invertir un arreglo manualmente (sin usar reverse()).

Algoritmo de dos punteros: 'inicio' y 'fin' se acercan intercambiando
elementos hasta cruzarse.

Complejidad temporal: O(n) -> se recorre la mitad del arreglo.
Complejidad espacial:  O(1) -> se invierte en el mismo arreglo (in-place).
"""

from typing import Any, List


def invertir_arreglo(arreglo: List[Any]) -> List[Any]:
    """Invierte 'arreglo' en el mismo lugar, usando dos índices que se acercan."""
    inicio = 0
    fin = len(arreglo) - 1

    while inicio < fin:
        arreglo[inicio], arreglo[fin] = arreglo[fin], arreglo[inicio]
        inicio += 1
        fin -= 1

    return arreglo


def _prueba(nombre: str, entrada: List[Any], esperado: List[Any]) -> None:
    resultado = invertir_arreglo(entrada.copy())
    estado = "OK" if resultado == esperado else "FALLÓ"
    print(f"[{estado}] {nombre}: {resultado} (esperado: {esperado})")


if __name__ == "__main__":
    print("--- PRUEBAS: invertir_arreglo() ---")
    _prueba("Arreglo de números, tamaño impar", [1, 2, 3, 4, 5], [5, 4, 3, 2, 1])
    _prueba("Arreglo de cadenas, tamaño par", ["a", "b", "c", "d"], ["d", "c", "b", "a"])
    _prueba("Arreglo con un solo elemento", [10], [10])
    _prueba("Arreglo vacío", [], [])
