"""
Sesión 1 - Ejercicio 1: Estructuras de datos básicas en Python.

Estructuras utilizadas:
    - set   -> IDs únicos de miembros (no permite duplicados).
    - tuple -> Datos fijos del club, inmutables una vez creados.
    - dict  -> Perfiles de miembros, indexados por ID (búsqueda O(1)).
    - list  -> Fila de espera, colección ordenada y mutable.
"""

from typing import Dict, List, Set, Tuple

Perfil = Dict[str, str]


def registrar_miembros() -> Set[int]:
    """Crea el conjunto de IDs de miembros. Los duplicados se ignoran."""
    miembros_id: Set[int] = {101, 102, 103}
    miembros_id.add(104)  # Nuevo ingreso
    miembros_id.add(101)  # Intento de duplicado: el set lo ignora
    return miembros_id


def crear_info_club() -> Tuple[str, int]:
    """Información fija del club (nombre, año de fundación) como tupla inmutable."""
    return ("Club Deportivo Alfa", 2026)


def crear_perfiles() -> Dict[int, Perfil]:
    """Diccionario de perfiles de miembros, indexado por ID."""
    perfiles: Dict[int, Perfil] = {
        101: {"nombre": "Ana", "deporte": "Tenis"},
        102: {"nombre": "Luis", "deporte": "Natación"},
        103: {"nombre": "María", "deporte": "Tenis"},
    }
    perfiles[104] = {"nombre": "Carlos", "deporte": "Fútbol"}
    return perfiles


def crear_fila_espera() -> List[str]:
    """Fila de espera de ingreso al club (lista ordenada y mutable)."""
    fila_espera = ["Elena", "Pedro"]
    fila_espera.append("Sofía")  # Llega una nueva persona a la fila
    return fila_espera


def mostrar_reporte(
    club_info: Tuple[str, int],
    miembros_id: Set[int],
    perfiles: Dict[int, Perfil],
    fila_espera: List[str],
) -> None:
    """Imprime en consola el reporte completo del club."""
    print(f"--- BIENVENIDO A {club_info[0].upper()} (Fundado en {club_info[1]}) ---\n")
    print(f"IDs de miembros registrados (sin duplicados): {miembros_id}")

    print("\nLista de perfiles de miembros:")
    for id_miembro, datos in perfiles.items():
        print(f" - ID {id_miembro}: {datos['nombre']} practica {datos['deporte']}")

    print(f"\nPróximo en la fila de espera para ingresar: {fila_espera[0]}")
    print(f"Fila de espera completa: {fila_espera}")


def main() -> None:
    club_info = crear_info_club()
    miembros_id = registrar_miembros()
    perfiles = crear_perfiles()
    fila_espera = crear_fila_espera()
    mostrar_reporte(club_info, miembros_id, perfiles, fila_espera)


if __name__ == "__main__":
    main()
