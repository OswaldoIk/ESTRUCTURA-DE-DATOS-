# Estructuras de Datos — Sesiones 1 y 2

Repositorio de ejercicios prácticos del curso de Estructuras de Datos:
estructuras básicas (Set, Tupla/Record, Diccionario/Map, Lista), ciclos
repetitivos (`for`, `while`, `do-while`), y algoritmos sobre estructuras
lineales (recorrido, inserción, eliminación, inversión, rotación y
eliminación de duplicados), resueltos en Python y Java.

## Tabla de contenidos

- [Estructura del repositorio](#estructura-del-repositorio)
- [Prerrequisitos](#prerrequisitos)
- [Cómo ejecutar — Python](#cómo-ejecutar--python)
- [Cómo ejecutar — Java](#cómo-ejecutar--java)
- [Resumen de ejercicios resueltos](#resumen-de-ejercicios-resueltos)
- [Análisis de complejidad (Big O)](#análisis-de-complejidad-big-o)

## Estructura del repositorio

```
estructuras-de-datos/
├── README.md
├── sesion_1/
│   ├── python/
│   │   ├── gestion_club_deportivo.py    # Set, Tuple, Dict, List
│   │   └── gestion_calificaciones.py    # for / while / do-while simulado
│   └── java/
│       ├── GestionClub.java             # Set, record, Map, List
│       └── GestionInventario.java       # do-while / while / for + IVA
├── sesion_2/
│   └── python/
│       ├── operaciones_lineales.py            # recorrer, insertar, eliminar
│       ├── ejercicio1_invertir_arreglo.py      # inversión con dos punteros
│       ├── ejercicio2_rotacion_circular.py     # rotación circular a la derecha
│       └── ejercicio3_eliminar_duplicados.py   # detección/eliminación de duplicados
└── ejercicios_adicionales/
    └── java/
        ├── CapturaEstudiantes.java      # captura + listado concatenado (for)
        ├── FactorialSerie.java          # factorial 1..n con ciclos anidados
        ├── TrianguloAsteriscos.java     # patrón de asteriscos (ciclos anidados)
        └── ContadorMultiplos3.java      # contador/acumulador + modularización
```

## Prerrequisitos

| Herramienta | Versión usada / mínima |
|---|---|
| Python | 3.10 o superior |
| JDK (Java Development Kit) | 17 o superior (probado con OpenJDK 21) |

Todo el código Python usa únicamente la librería estándar (`typing`). No se
requieren dependencias externas.

## Cómo ejecutar — Python

Desde la raíz del repositorio:

```bash
# Sesión 1
python3 sesion_1/python/gestion_club_deportivo.py
python3 sesion_1/python/gestion_calificaciones.py     # interactivo: pide notas por teclado

# Sesión 2
python3 sesion_2/python/operaciones_lineales.py
python3 sesion_2/python/ejercicio1_invertir_arreglo.py
python3 sesion_2/python/ejercicio2_rotacion_circular.py
python3 sesion_2/python/ejercicio3_eliminar_duplicados.py
```

Los tres archivos de la Sesión 2 (`ejercicio1`, `ejercicio2`, `ejercicio3`)
incluyen sus propios casos de prueba en el bloque `if __name__ == "__main__":`,
por lo que se ejecutan de forma autónoma y muestran `[OK]` o `[FALLÓ]` para
cada caso.

## Cómo ejecutar — Java

Se recomienda compilar con codificación UTF-8 explícita para que las tildes
se muestren correctamente en cualquier sistema operativo:

```bash
# Sesión 1
javac -encoding UTF-8 -d out sesion_1/java/GestionClub.java
java -Dfile.encoding=UTF-8 -cp out GestionClub

javac -encoding UTF-8 -d out sesion_1/java/GestionInventario.java
java -Dfile.encoding=UTF-8 -cp out GestionInventario

# Ejercicios adicionales
javac -encoding UTF-8 -d out ejercicios_adicionales/java/*.java
java -Dfile.encoding=UTF-8 -cp out CapturaEstudiantes
java -Dfile.encoding=UTF-8 -cp out FactorialSerie
java -Dfile.encoding=UTF-8 -cp out TrianguloAsteriscos
java -Dfile.encoding=UTF-8 -cp out ContadorMultiplos3
```

Todos los `.java` fueron compilados y ejecutados con OpenJDK 21 antes de
subirse al repositorio; no presentan errores de compilación.

## Resumen de ejercicios resueltos

| Sesión | Ejercicio | Lenguaje(s) | Conceptos clave |
|---|---|---|---|
| 1 | Gestión de club deportivo | Python, Java | Set, Tupla/Record, Diccionario/Map, Lista |
| 1 | Gestión de calificaciones / inventario con IVA | Python, Java | `for`, `while`, `do-while` simulado, contadores, acumuladores |
| 2 | Operaciones lineales base | Python | Recorrido, inserción por posición, eliminación por valor |
| 2 | Ejercicio 1 — Invertir arreglo | Python | Algoritmo de dos punteros, in-place, O(n) |
| 2 | Ejercicio 2 — Rotación circular a la derecha | Python | Slicing vs. algoritmo de tres inversiones |
| 2 | Ejercicio 3 — Eliminar duplicados | Python | Conservación de orden sin usar `set()`, reporte de repetidos |
| Adicional | Captura de estudiantes | Java | Ciclo `for` de tamaño definido, `StringBuilder` |
| Adicional | Factorial de la serie 1..n | Java | Ciclos anidados, `long` para evitar overflow |
| Adicional | Triángulo de asteriscos | Java | Ciclos anidados, construcción de patrones |
| Adicional | Contador de múltiplos de 3 | Java | Contador, acumulador, modularización en funciones |

## Análisis de complejidad (Big O)

| Algoritmo | Complejidad temporal | Complejidad espacial | Justificación |
|---|---|---|---|
| Recorrido (`recorrer`) | O(n) | O(1) | Visita cada elemento una única vez. |
| Inserción por posición | O(n) peor caso | O(1) | Insertar al final es ~O(1) amortizado; al inicio o en el medio desplaza los `n` elementos posteriores. |
| Eliminación por valor | O(n) | O(1) | Requiere buscar el valor (`O(n)`) y desplazar los elementos posteriores para cerrar el espacio. |
| Inversión manual (dos punteros) | O(n) | O(1) | Se recorre solo la mitad del arreglo (`n/2` intercambios); es in-place, no usa memoria adicional proporcional a `n`. |
| Rotación circular — por slicing | O(n) | O(n) | Se crea un arreglo nuevo combinando dos segmentos del original. |
| Rotación circular — tres inversiones | O(n) | O(1) | Tres pasadas de inversión, todas in-place; el trabajo total sigue siendo lineal (3·O(n) = O(n)). |
| Eliminación de duplicados (sin `set()`) | O(n²) peor caso | O(n) | Por cada elemento se verifica `valor in vistos`, una búsqueda lineal sobre una lista que puede crecer hasta `n`; la lista auxiliar `vistos` es el costo en espacio. |

**Nota:** si el orden de aparición no fuera un requisito, `eliminar_duplicados()`
podría implementarse en O(n) usando un `set()` o un `dict()` como estructura
de apoyo (búsqueda O(1) promedio), a costa de perder el orden original salvo
que se combine con un recorrido adicional para reconstruirlo — que es
justamente el enfoque usado en `reportar_duplicados()` de este repositorio.
