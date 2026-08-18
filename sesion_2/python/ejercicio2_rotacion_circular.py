"""
Sesión 2 - Ejercicio 2: Rotación circular de un arreglo k posiciones a la derecha.

Se incluyen dos variantes:
    - rotar_arreglo_derecha(): por slicing, más legible.
      Complejidad temporal O(n). Complejidad espacial O(n).
    - rotar_arreglo_derecha_in_place(): algoritmo de las tres inversiones,
      reutiliza la lógica de invertir_arreglo() del Ejercicio 1.
      Complejidad temporal O(n). Complejidad espacial O(1).
"""

from typing import Any, List


def rotar_arreglo_derecha(arreglo: List[Any], k: int) -> List[Any]:
    """Devuelve un nuevo arreglo rotado k posiciones hacia la derecha."""
    n = len(arreglo)
    if n == 0:
        return arreglo

    k = k % n  # Normaliza k si es mayor que el tamaño del arreglo
    if k == 0:
        return arreglo[:]

    return arreglo[-k:] + arreglo[:-k]


def rotar_arreglo_derecha_in_place(arreglo: List[Any], k: int) -> List[Any]:
    """
    Rota 'arreglo' k posiciones a la derecha, en el mismo lugar, mediante el
    algoritmo de las tres inversiones:
        1) Invertir todo el arreglo.
        2) Invertir los primeros k elementos.
        3) Invertir los elementos restantes.
    """
    n = len(arreglo)
    if n == 0:
        return arreglo
    k = k % n

    def invertir(lista: List[Any], inicio: int, fin: int) -> None:
        while inicio < fin:
            lista[inicio], lista[fin] = lista[fin], lista[inicio]
            inicio += 1
            fin -= 1

    invertir(arreglo, 0, n - 1)
    invertir(arreglo, 0, k - 1)
    invertir(arreglo, k, n - 1)
    return arreglo


def _prueba(nombre: str, entrada: List[Any], k: int, esperado: List[Any]) -> None:
    resultado_a = rotar_arreglo_derecha(entrada.copy(), k)
    resultado_b = rotar_arreglo_derecha_in_place(entrada.copy(), k)
    estado_a = "OK" if resultado_a == esperado else "FALLÓ"
    estado_b = "OK" if resultado_b == esperado else "FALLÓ"
    print(f"[{estado_a}] rotar_arreglo_derecha           | {nombre}: {resultado_a} (esperado: {esperado})")
    print(f"[{estado_b}] rotar_arreglo_derecha_in_place  | {nombre}: {resultado_b} (esperado: {esperado})")


if __name__ == "__main__":
    print("--- PRUEBAS: rotación circular a la derecha ---")
    _prueba("k=2 en arreglo de 7 elementos", [1, 2, 3, 4, 5, 6, 7], 2, [6, 7, 1, 2, 3, 4, 5])
    _prueba("k mayor que n (k=9, n=5, equivale a k=4)", [1, 2, 3, 4, 5], 9, [2, 3, 4, 5, 1])
    _prueba("k=0 (sin rotación)", ["a", "b", "c"], 0, ["a", "b", "c"])
    _prueba("arreglo vacío", [], 3, [])
