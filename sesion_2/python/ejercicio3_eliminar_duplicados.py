"""
Sesión 2 - Ejercicio 3: Detección y eliminación de valores duplicados.

Conserva el orden original de aparición. No utiliza estructuras de Python
que eliminen duplicados automáticamente (como set()).

Complejidad temporal: O(n^2) en el peor caso, por la búsqueda lineal
'valor in vistos' dentro del recorrido principal.
Complejidad espacial: O(n) por la lista auxiliar de valores ya vistos.
"""

from typing import Any, Dict, List


def eliminar_duplicados(arreglo: List[Any]) -> List[Any]:
    """Devuelve un nuevo arreglo sin duplicados, conservando el orden de aparición."""
    resultado: List[Any] = []
    vistos: List[Any] = []

    for valor in arreglo:
        if valor not in vistos:
            vistos.append(valor)
            resultado.append(valor)

    return resultado


def reportar_duplicados(arreglo: List[Any]) -> Dict[Any, int]:
    """
    Devuelve un diccionario {valor: número de repeticiones} solo para los
    valores que aparecen más de una vez. No utiliza set().
    """
    conteo: Dict[Any, int] = {}
    for valor in arreglo:
        conteo[valor] = conteo.get(valor, 0) + 1

    return {valor: veces for valor, veces in conteo.items() if veces > 1}


def _prueba(nombre: str, entrada: List[Any], esperado: List[Any]) -> None:
    resultado = eliminar_duplicados(entrada)
    duplicados = reportar_duplicados(entrada)
    estado = "OK" if resultado == esperado else "FALLÓ"
    print(f"[{estado}] {nombre}: {resultado} (esperado: {esperado}) | duplicados detectados: {duplicados}")


if __name__ == "__main__":
    print("--- PRUEBAS: eliminar_duplicados() y reportar_duplicados() ---")
    _prueba("Números con repetidos", [1, 2, 2, 3, 1, 4, 3, 3], [1, 2, 3, 4])
    _prueba(
        "Cadenas con repetidos",
        ["Teclado", "Mouse", "Mouse", "Monitor", "Teclado"],
        ["Teclado", "Mouse", "Monitor"],
    )
    _prueba("Sin duplicados", [5, 6, 7], [5, 6, 7])
    _prueba("Arreglo vacío", [], [])
