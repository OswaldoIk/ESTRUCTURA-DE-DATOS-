"""
Sesión 2 - Código base: algoritmos fundamentales sobre estructuras lineales
(recorrer, insertar por posición, eliminar por valor).
"""

from typing import Any, List


def recorrer(arreglo: List[Any]) -> None:
    """Recorrido. Complejidad O(n): visita e imprime cada elemento con su posición."""
    for i, valor in enumerate(arreglo):
        print(f"  Posición {i}: {valor}")


def insertar_en_posicion(arreglo: List[Any], posicion: int, valor: Any) -> List[Any]:
    """
    Inserción. Complejidad O(n) en el peor caso (insertar al inicio o en el
    medio desplaza los elementos posteriores); O(1) amortizado al final.
    """
    arreglo.insert(posicion, valor)
    return arreglo


def eliminar_por_valor(arreglo: List[Any], valor: Any) -> bool:
    """
    Eliminación. Complejidad O(n): busca la primera aparición de 'valor' y la
    quita, desplazando los elementos posteriores. Devuelve True si eliminó.
    """
    if valor in arreglo:
        arreglo.remove(valor)
        return True
    return False


def main() -> None:
    inventario = ["Teclado", "Mouse", "Monitor"]

    print("Recorrido inicial:")
    recorrer(inventario)

    insertar_en_posicion(inventario, 1, "Cable HDMI")
    print("\nDespués de insertar en posición 1:")
    recorrer(inventario)

    eliminado = eliminar_por_valor(inventario, "Mouse")
    print(f"\n¿Se eliminó 'Mouse'? {eliminado}")
    recorrer(inventario)


if __name__ == "__main__":
    main()
