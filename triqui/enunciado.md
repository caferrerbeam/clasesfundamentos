# 🎮 Ejercicio de Programación: Sistema de Juego de Triqui

## Contexto del Juego

La empresa de entretenimiento **"Juegos Clásicos Digital"** necesita un sistema para controlar un juego de Triqui (también conocido como Tic-Tac-Toe o Tres en Línea). Este es un juego tradicional donde dos jugadores compiten por formar una línea de tres símbolos iguales en un tablero de 3x3 casillas.

El sistema debe ser capaz de administrar completamente una partida: controlar los turnos de los jugadores, validar las jugadas, detectar al ganador y determinar si hay empate.

### Reglas del Juego

1. **El Tablero**
   - El juego se juega en un tablero de 3x3 casillas (9 casillas en total)
   - Cada casilla se identifica con un número del 1 al 9:
     ```
     1 | 2 | 3
    -----------
     4 | 5 | 6
    -----------
     7 | 8 | 9
     ```
   - Al inicio del juego, todas las casillas están vacías (valor: " " o "")
   - Una vez que una casilla tiene un símbolo (X o O), no se puede cambiar

2. **Los Jugadores**
   - Hay exactamente 2 jugadores en cada partida
   - **Jugador 1**: Siempre usa el símbolo "X" y siempre juega primero
   - **Jugador 2**: Siempre usa el símbolo "O" y juega después del Jugador 1
   - Los jugadores se turnan: después de cada jugada válida, el turno pasa al otro jugador

3. **Cómo se Juega (Jugadas Válidas)**
   - En su turno, el jugador selecciona una casilla (número del 1 al 9)
   - La jugada es VÁLIDA si:
     * La casilla seleccionada está vacía (no tiene "X" ni "O")
     * El número de casilla está entre 1 y 9
   - La jugada es INVÁLIDA si:
     * La casilla ya está ocupada por algún símbolo
     * El número de casilla no existe (menor que 1 o mayor que 9)
   - Si la jugada es válida: se coloca el símbolo del jugador y se cambia el turno
   - Si la jugada es inválida: NO se cambia el turno, el mismo jugador debe intentar de nuevo

4. **Condiciones de Victoria**
   Un jugador gana cuando logra formar una línea de 3 símbolos iguales en cualquiera de estas configuraciones:

   **Líneas Horizontales (3 formas de ganar):**
   - Fila superior: casillas 1, 2, 3 tienen el mismo símbolo
   - Fila media: casillas 4, 5, 6 tienen el mismo símbolo
   - Fila inferior: casillas 7, 8, 9 tienen el mismo símbolo

   **Líneas Verticales (3 formas de ganar):**
   - Columna izquierda: casillas 1, 4, 7 tienen el mismo símbolo
   - Columna media: casillas 2, 5, 8 tienen el mismo símbolo
   - Columna derecha: casillas 3, 6, 9 tienen el mismo símbolo

   **Líneas Diagonales (2 formas de ganar):**
   - Diagonal principal: casillas 1, 5, 9 tienen el mismo símbolo
   - Diagonal secundaria: casillas 3, 5, 7 tienen el mismo símbolo

   **Total: 8 formas posibles de ganar**

5. **Estados del Juego**
   Después de cada jugada válida, el juego debe retornar un código que indica el estado:
   - **0**: El juego continúa, nadie ha ganado aún y hay casillas disponibles
   - **1**: Ganó el Jugador 1 (hay una línea de tres "X")
   - **2**: Ganó el Jugador 2 (hay una línea de tres "O")
   - **-1**: Empate (todas las casillas están llenas y nadie ganó)

6. **Control de Turnos**
   - El sistema debe saber siempre de quién es el turno actual
   - Al inicio: el turno es del Jugador 1
   - Después de cada jugada VÁLIDA: el turno cambia al otro jugador
   - Después de una jugada INVÁLIDA: el turno NO cambia
   - Cuando hay un ganador o empate: no hay más turnos

---

## Conceptos Importantes para Entender el Problema

### ¿Qué es una Jugada?

Una jugada es cuando un jugador intenta colocar su símbolo en una casilla específica del tablero. Para que una jugada sea exitosa:
1. Debe ser el turno correcto del jugador
2. La casilla seleccionada debe estar vacía
3. La casilla debe ser válida (entre 1 y 9)

---

## Ejemplos Resueltos

### Ejemplo 1: Secuencia de jugadas básica con victoria

**Situación Inicial:**
- Tablero vacío (todas las casillas en "")
- Turno actual: Jugador 1
- Estado del juego: 0 (en progreso)

**Tablero inicial:**
```
  |   |
-----------
  |   |
-----------
  |   |
```

**Secuencia de Jugadas:**

**Jugada 1:** Jugador 1 selecciona casilla 5 (centro)
- ¿Es el turno del Jugador 1? SÍ ✓
- ¿La casilla 5 está vacía? SÍ ✓
- Colocar "X" en casilla 5
- Verificar victoria: NO (solo hay una X)
- Verificar empate: NO (quedan 8 casillas vacías)
- Cambiar turno a Jugador 2
- **Estado retornado: 0** (juego continúa)

**Tablero después:**
```
  |   |
-----------
  | X |
-----------
  |   |
```

**Jugada 2:** Jugador 2 selecciona casilla 1 (esquina superior izquierda)
- ¿Es el turno del Jugador 2? SÍ ✓
- ¿La casilla 1 está vacía? SÍ ✓
- Colocar "O" en casilla 1
- Verificar victoria: NO
- Verificar empate: NO
- Cambiar turno a Jugador 1
- **Estado retornado: 0** (juego continúa)

**Tablero después:**
```
O |   |
-----------
  | X |
-----------
  |   |
```

**Jugada 3:** Jugador 1 selecciona casilla 3 (esquina superior derecha)
- ¿Es el turno del Jugador 1? SÍ ✓
- ¿La casilla 3 está vacía? SÍ ✓
- Colocar "X" en casilla 3
- Verificar victoria: NO
- Cambiar turno a Jugador 2
- **Estado retornado: 0** (juego continúa)

**Tablero después:**
```
O |   | X
-----------
  | X |
-----------
  |   |
```

**Jugada 4:** Jugador 2 selecciona casilla 2
- Colocar "O" en casilla 2
- Cambiar turno a Jugador 1
- **Estado retornado: 0** (juego continúa)

**Tablero después:**
```
O | O | X
-----------
  | X |
-----------
  |   |
```

**Jugada 5:** Jugador 1 selecciona casilla 7 (esquina inferior izquierda)
- Colocar "X" en casilla 7
- **Verificar victoria:**
  - ¿Casillas 1, 5, 9 son todas "X"? NO (1 es "O")
  - ¿Casillas 3, 5, 7 son todas "X"? SÍ ✓ (¡Diagonal secundaria!)
- **¡GANÓ EL JUGADOR 1!**
- **Estado retornado: 1**

**Tablero final:**
```
O | O | X
-----------
  | X |
-----------
X |   |
```

---

### Ejemplo 2: Jugada inválida (casilla ocupada)

**Situación:**
- Turno actual: Jugador 2
- Casilla 5 tiene "X"

**Tablero:**
```
  |   |
-----------
  | X |
-----------
  |   |
```

**Jugada:** Jugador 2 intenta jugar en casilla 5

**Proceso de decisión:**
1. ¿Es el turno del Jugador 2? SÍ ✓
2. ¿La casilla 5 está vacía? NO ✗
3. **Jugada RECHAZADA**
4. NO se coloca el símbolo
5. NO se cambia el turno (sigue siendo turno del Jugador 2)
6. Se debe informar al jugador que la casilla está ocupada

**Resultado:** El turno sigue siendo del Jugador 2, debe elegir otra casilla

---

### Ejemplo 3: Detección de empate

**Situación antes de la última jugada:**
- Turno: Jugador 1
- 8 casillas ocupadas, solo queda la casilla 9

**Tablero:**
```
X | O | X
-----------
O | O | X
-----------
X | X |
```

**Jugada:** Jugador 1 selecciona casilla 9

**Proceso:**
1. Colocar "X" en casilla 9
2. **Verificar victoria:** Revisar todas las 8 combinaciones posibles
   - Fila 1 (1,2,3): X, O, X → NO
   - Fila 2 (4,5,6): O, O, X → NO
   - Fila 3 (7,8,9): X, X, X → **¡SÍ! ¡GANÓ JUGADOR 1!**

**Resultado:** El Jugador 1 ganó en la última jugada posible

**Tablero final:**
```
X | O | X
-----------
O | O | X
-----------
X | X | X
```
**Estado retornado: 1**

---

### Ejemplo 4: Empate real (todas las casillas llenas, sin ganador)

**Situación antes de la última jugada:**
- Turno: Jugador 1
- 8 casillas ocupadas

**Tablero:**
```
X | X | O
-----------
O | O | X
-----------
X | O |
```

**Jugada:** Jugador 1 selecciona casilla 9

**Proceso:**
1. Colocar "X" en casilla 9
2. **Verificar victoria:** Revisar todas las 8 combinaciones
   - Todas las combinaciones tienen mezcla de X y O
   - NO hay tres símbolos iguales en línea
3. **Verificar empate:** ¿Todas las casillas están ocupadas? SÍ
4. **Estado retornado: -1** (empate)

**Tablero final:**
```
X | X | O
-----------
O | O | X
-----------
X | O | X
```

---

## Escenarios de Práctica para Resolver

### Escenario 1: Juego completo con victoria del Jugador 2

**Situación Inicial:**
- Tablero vacío
- Turno: Jugador 1

**Secuencia de operaciones a procesar:**
1. Jugador 1 juega en casilla 1
2. Jugador 2 juega en casilla 5 (centro)
3. Jugador 1 juega en casilla 9
4. Jugador 2 juega en casilla 3
5. Jugador 1 juega en casilla 2
6. Jugador 2 juega en casilla 7

**Preguntas:**
- Dibuje el tablero después de cada jugada
- ¿Qué estado retorna el juego después de cada jugada?
- ¿Quién ganó y cómo? (¿qué línea formó?)
- ¿Cuántas jugadas válidas se realizaron en total?

### Escenario 2: Jugadas inválidas y recuperación

**Situación Inicial:**
- Tablero vacío
- Turno: Jugador 1

**Secuencia de operaciones a procesar:**
1. Jugador 1 juega en casilla 5
2. Jugador 2 juega en casilla 5 (casilla ocupada)
3. Jugador 2 juega en casilla 1
4. Jugador 1 juega en casilla 1 (casilla ocupada)
5. Jugador 1 juega en casilla 9
6. Jugador 2 juega en casilla 3

**Preguntas:**
- ¿Cuáles jugadas fueron aceptadas y cuáles rechazadas?
- ¿De quién es el turno después de cada intento?
- Dibuje el estado final del tablero
- ¿Cuál es el estado del juego después de la última jugada válida?

### Escenario 3: Detección de victoria por columna

**Situación:**
Implemente una secuencia de jugadas donde el Jugador 1 gane formando una línea vertical (columna).

**Restricciones:**
- El juego debe terminar en exactamente 5 jugadas del Jugador 1
- El Jugador 2 debe hacer jugadas válidas pero sin ganar
- Debe resultar en una victoria por columna (no diagonal ni fila)

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto del juego y los ejemplos proporcionados, identifique:

a) **Atributos necesarios** para la clase JuegoTriqui (Mínimo esperado: 10 atributos)

b) **Métodos necesarios** para implementar todas las operaciones descritas (Mínimo esperado: 7 métodos)

### 2. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

a) **Método jugar(jugador, casilla)** - Debe procesar una jugada y retornar si fue exitosa

b) **Método verificarVictoria()** - Debe retornar 1 si ganó Jugador 1, 2 si ganó Jugador 2, 0 si nadie ganó

c) **Método obtenerEstadoJuego()** - Debe retornar el código correspondiente: 0, 1, 2, o -1

### 3. Implementación en Java

**Instrucciones:** Implemente la clase completa `JuegoTriqui` en Java que cumpla con todas las reglas del juego descritas anteriormente.

**Consideraciones importantes:**
- **NO use arreglos, listas o colecciones**
- **NO use ciclos (for, while, do-while)**
- Use SOLO estructuras de decisión (if, else if, else)
- Los símbolos de los jugadores son "X" para Jugador 1 y "O" para Jugador 2

### 4. Programa Principal (Clase Main)

Cree una clase con método main que demuestre el funcionamiento del juego mediante una secuencia de jugadas que incluya:
- Jugadas válidas
- Al menos un intento de jugada inválida
- Visualización del estado del juego después de cada jugada

---

## Criterios de Evaluación

1. **Identificación correcta de atributos** (15%)
   - Completitud: todas las casillas representadas
   - Control de turno implementado
   - Otros atributos relevantes

2. **Identificación correcta de métodos** (15%)
   - Coherencia con las operaciones del juego
   - Separación adecuada de responsabilidades

3. **Diagramas de flujo** (30%)
   - Correcta representación de la lógica
   - Uso apropiado de decisiones simples y anidadas
   - Validaciones completas
   - Verificación correcta de las 8 combinaciones ganadoras

4. **Implementación en Java** (40%)
   - Sintaxis correcta
   - Lógica completa y funcional
   - Manejo correcto de las 9 casillas individuales SIN arreglos
   - Verificación correcta de victoria (las 8 combinaciones)
   - Control adecuado de turnos
   - Validaciones completas de jugadas
   - Detección correcta de empate
   - Código limpio y bien estructurado

---

## Desafíos Adicionales (Opcionales)

1. **Validación de jugador:** Agregar verificación de que el parámetro `jugador` sea 1 o 2
2. **Estadísticas:** Agregar contadores de jugadas válidas e inválidas
3. **Reiniciar juego:** Implementar un método para reiniciar el tablero y empezar nueva partida
4. **Modo de un jugador:** Agregar un método que haga que el Jugador 2 juegue automáticamente en una casilla vacía aleatoria
