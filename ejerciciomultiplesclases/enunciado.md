# 📚 Ejercicio de Programación: Sistema de Gestión Académica de Estudiantes

## Contexto del Negocio

La universidad **"Excelencia Académica"** necesita un sistema para administrar el rendimiento académico de sus estudiantes. El sistema debe permitir registrar las calificaciones de diferentes asignaturas, calcular promedios, identificar fortalezas y debilidades académicas, y determinar el estado de aprobación de cada materia.

Cuando un estudiante se matricula en un semestre, debe cursar varias asignaturas. Cada asignatura tiene diferentes componentes de evaluación (parciales, talleres, quices, proyecto final, etc.), cada uno con un porcentaje que define cuánto vale en la nota final de esa materia. Al final del semestre, el estudiante debe saber cuántas materias aprobó, cuántas reprobó, cuál es su promedio general y cuál es su mejor asignatura.

### Reglas del Negocio

1. **Estructura Académica**
   - Cada **estudiante** tiene un nombre completo, un código único (identificación) y está cursando un determinado semestre
   - Un **curso** representa el conjunto de todas las asignaturas que está cursando el estudiante en ese semestre
   - Cada **asignatura** tiene un nombre (ejemplo: "Cálculo", "Programación", "Física") y puede tener múltiples notas
   - Cada **nota** tiene tres componentes:
     * **Nombre**: Identifica el tipo de evaluación (ejemplo: "Parcial 1", "Taller 2", "Quiz Final")
     * **Valor**: La calificación obtenida (escala de 0.0 a 5.0)
     * **Porcentaje**: Cuánto vale esa nota en la nota final de la asignatura (ejemplo: 30% significa que vale 30% de la nota final)
   - La suma de todos los porcentajes de las notas de una asignatura DEBE ser exactamente 100%

2. **Cálculo de Nota Final de una Asignatura**
   - La nota final de una asignatura se calcula como el promedio ponderado de todas sus notas
   - Fórmula: (nota1 × porcentaje1/100) + (nota2 × porcentaje2/100) + ... + (notaN × porcentajeN/100)
   - Ejemplo: Si tienes:
     * Parcial 1: 4.0 (vale 30%)
     * Taller: 3.5 (vale 20%)
     * Examen Final: 4.5 (vale 50%)
     * Nota final = (4.0 × 0.30) + (3.5 × 0.20) + (4.5 × 0.50) = 1.2 + 0.7 + 2.25 = 4.15

3. **Estado de Aprobación de una Asignatura**
   - **Aprobada con Excelencia**: Nota final ≥ 4.5 (el estudiante demostró un dominio sobresaliente)
   - **Aprobada**: Nota final entre 3.0 y 4.49 (el estudiante cumplió con los objetivos)
   - **Reprobada**: Nota final < 3.0 (el estudiante debe repetir la materia)
   - La nota mínima para aprobar cualquier asignatura es 3.0

4. **Cálculo del Promedio General del Estudiante**
   - El promedio general (promedio semestral) es el promedio aritmético simple de las notas finales de TODAS las asignaturas
   - Fórmula: (notaFinal1 + notaFinal2 + ... + notaFinalN) / número de asignaturas
   - Ejemplo: Si un estudiante tiene 4 materias con notas finales 4.2, 3.8, 4.5 y 2.9:
     * Promedio = (4.2 + 3.8 + 4.5 + 2.9) / 4 = 15.4 / 4 = 3.85

5. **Clasificación del Rendimiento Académico del Estudiante**
   El sistema clasifica al estudiante según su promedio general:
   - **Excelente**: Promedio ≥ 4.5 (estudiante destacado, candidato a becas)
   - **Bueno**: Promedio entre 4.0 y 4.49 (estudiante con buen desempeño)
   - **Aceptable**: Promedio entre 3.5 y 3.99 (estudiante cumple satisfactoriamente)
   - **Regular**: Promedio entre 3.0 y 3.49 (estudiante debe mejorar)
   - **Deficiente**: Promedio < 3.0 (estudiante en riesgo académico)

6. **Análisis de Fortalezas y Debilidades**
   - **Mejor Asignatura**: Es aquella con la nota final más alta
   - **Peor Asignatura**: Es aquella con la nota final más baja
   - **Mejor Nota Individual**: Es la calificación más alta obtenida en cualquier evaluación de cualquier asignatura
   - **Peor Nota Individual**: Es la calificación más baja obtenida en cualquier evaluación de cualquier asignatura

7. **Conteo de Aprobadas y Reprobadas**
   - El sistema debe contar cuántas asignaturas aprobó el estudiante (nota final ≥ 3.0)
   - El sistema debe contar cuántas asignaturas reprobó el estudiante (nota final < 3.0)
   - Si reprueba más de la mitad de las asignaturas, el estudiante queda en "Prueba Académica"

8. **Estado Académico del Estudiante**
   Basándose en el número de materias reprobadas:
   - **Regular**: No reprobó ninguna materia (0 reprobadas)
   - **Advertencia**: Reprobó entre 1 y la mitad de las materias (pero no más de la mitad)
   - **Prueba Académica**: Reprobó más de la mitad de las materias cursadas (riesgo de perder el cupo)

---

## Requisitos Funcionales

El sistema debe permitir realizar las siguientes operaciones:

### RF-01: Gestión de Notas

**RF-01.1 Registrar Nota**
- El sistema debe permitir agregar una nota a una asignatura
- Debe validar que el valor de la nota esté entre 0.0 y 5.0
- Debe validar que el porcentaje sea un valor positivo
- Debe almacenar el nombre descriptivo de la evaluación
- No debe permitir agregar más de 10 notas por asignatura

**RF-01.2 Validar Porcentajes**
- El sistema debe verificar que la suma de todos los porcentajes de las notas de una asignatura sea exactamente 100%
- Debe mostrar un mensaje de error si los porcentajes no suman 100%
- No debe permitir calcular la nota final si los porcentajes son inválidos

### RF-02: Cálculo de Notas Finales

**RF-02.1 Calcular Nota Final de Asignatura**
- El sistema debe calcular la nota final de una asignatura usando promedio ponderado
- Debe aplicar la fórmula: Σ(valor × porcentaje/100)
- Debe retornar un valor decimal (tipo double) con precisión de 2 decimales

**RF-02.2 Determinar Estado de Aprobación**
- El sistema debe clasificar cada asignatura como:
  * "Aprobada con Excelencia" si nota final ≥ 4.5
  * "Aprobada" si nota final entre 3.0 y 4.49
  * "Reprobada" si nota final < 3.0

### RF-03: Gestión de Asignaturas

**RF-03.1 Registrar Asignatura**
- El sistema debe permitir crear una asignatura con su nombre
- Debe inicializar el arreglo de notas (máximo 10)
- Debe inicializar el contador de notas en 0

**RF-03.2 Agregar Asignatura al Estudiante**
- El sistema debe permitir agregar asignaturas a un estudiante
- No debe permitir agregar más de 8 asignaturas por estudiante
- Debe validar que la asignatura tenga un nombre válido

### RF-04: Cálculo de Promedio General

**RF-04.1 Calcular Promedio del Estudiante**
- El sistema debe calcular el promedio aritmético de todas las notas finales de las asignaturas
- Debe aplicar la fórmula: Σ(notas finales) / número de asignaturas
- Debe validar que el estudiante tenga al menos una asignatura antes de calcular

**RF-04.2 Clasificar Rendimiento Académico**
- El sistema debe clasificar al estudiante según su promedio:
  * "Excelente" si promedio ≥ 4.5
  * "Bueno" si promedio entre 4.0 y 4.49
  * "Aceptable" si promedio entre 3.5 y 3.99
  * "Regular" si promedio entre 3.0 y 3.49
  * "Deficiente" si promedio < 3.0

### RF-05: Análisis Estadístico

**RF-05.1 Contar Asignaturas Aprobadas y Reprobadas**
- El sistema debe contar cuántas asignaturas tienen nota final ≥ 3.0 (aprobadas)
- El sistema debe contar cuántas asignaturas tienen nota final < 3.0 (reprobadas)
- Debe retornar ambos contadores

**RF-05.2 Identificar Mejor Asignatura**
- El sistema debe encontrar la asignatura con la nota final más alta
- Debe retornar el nombre de la asignatura y su nota final
- Si hay empate, debe retornar la primera que encuentre

**RF-05.3 Identificar Peor Asignatura**
- El sistema debe encontrar la asignatura con la nota final más baja
- Debe retornar el nombre de la asignatura y su nota final
- Si hay empate, debe retornar la primera que encuentre

**RF-05.4 Identificar Mejor Nota Individual**
- El sistema debe buscar en todas las evaluaciones de todas las asignaturas
- Debe encontrar el valor más alto entre todas las notas individuales
- Debe retornar ese valor

**RF-05.5 Identificar Peor Nota Individual**
- El sistema debe buscar en todas las evaluaciones de todas las asignaturas
- Debe encontrar el valor más bajo entre todas las notas individuales
- Debe retornar ese valor

### RF-06: Determinación de Estado Académico

**RF-06.1 Calcular Estado Académico**
- El sistema debe determinar el estado del estudiante basándose en materias reprobadas:
  * "Regular" si no reprobó ninguna materia
  * "Advertencia" si reprobó entre 1 y la mitad de las materias
  * "Prueba Académica" si reprobó más de la mitad de las materias
- Debe realizar la comparación: reprobadas > (total/2)

### RF-07: Generación de Reportes

**RF-07.1 Mostrar Reporte Completo del Estudiante**
- El sistema debe generar un reporte que incluya:
  * Información personal (nombre, código, semestre)
  * Lista de todas las asignaturas con sus notas finales y estado
  * Promedio general del estudiante
  * Clasificación de rendimiento académico
  * Número de asignaturas aprobadas y reprobadas
  * Estado académico del estudiante
  * Mejor y peor asignatura con sus notas
  * Mejor y peor nota individual
- El reporte debe estar formateado de manera clara y legible

**RF-07.2 Mostrar Detalle de Asignatura**
- El sistema debe permitir visualizar todas las notas de una asignatura específica
- Debe mostrar: nombre de la evaluación, valor obtenido, porcentaje
- Debe mostrar la nota final calculada

### RF-08: Validaciones del Sistema

**RF-08.1 Validar Límites de Arreglos**
- El sistema debe verificar que no se exceda el límite de 10 notas por asignatura
- El sistema debe verificar que no se exceda el límite de 8 asignaturas por estudiante
- Debe mostrar mensajes de error apropiados cuando se alcancen los límites

**RF-08.2 Validar Rangos de Notas**
- El sistema debe validar que todas las notas estén en el rango 0.0 a 5.0
- Debe rechazar notas negativas o mayores a 5.0
- Debe mostrar mensaje de error descriptivo

**RF-08.3 Validar Integridad de Datos**
- El sistema debe validar que los nombres de estudiantes y asignaturas no estén vacíos
- El sistema debe validar que el código del estudiante sea válido
- El sistema debe validar que el semestre sea un número positivo

---

## Conceptos Importantes para Entender el Problema

### ¿Qué es una Nota Ponderada?

Una nota ponderada significa que no todas las evaluaciones valen lo mismo. Algunas son más importantes que otras:
- Si un examen final vale 50% y un quiz vale 10%, el examen tiene 5 veces más peso en la nota final
- Para calcular la nota final, multiplicamos cada nota por su porcentaje y sumamos todo
- Por eso un estudiante puede sacar 5.0 en un quiz del 10% pero si saca 2.0 en el final del 50%, igual puede perder la materia

### ¿Cómo se diferencia Promedio Ponderado vs Promedio Aritmético?

- **Promedio Ponderado**: Se usa para calcular la nota final de UNA asignatura (porque cada evaluación tiene diferente peso)
  * Ejemplo: Parcial 4.0 (30%) + Taller 3.0 (20%) + Final 5.0 (50%) = 4.2

- **Promedio Aritmético**: Se usa para calcular el promedio general del estudiante (todas las asignaturas valen igual)
  * Ejemplo: Matemáticas 4.0 + Física 3.5 + Programación 4.5 = (4.0 + 3.5 + 4.5) / 3 = 4.0

### ¿Cuál es la diferencia entre Nota Individual y Nota Final?

- **Nota Individual**: Es la calificación de UNA evaluación específica (un parcial, un taller, un quiz)
  * Ejemplo: Sacaste 4.5 en el Parcial 1 de Matemáticas

- **Nota Final**: Es el resultado de combinar TODAS las notas individuales de una asignatura según sus porcentajes
  * Ejemplo: Después de combinar todas las evaluaciones de Matemáticas, la nota final es 4.0

---

## Ejemplos Resueltos

Para entender mejor cómo funciona el sistema, veamos varios casos reales:

### Ejemplo 1: Cálculo de Nota Final de una Asignatura

**Situación:**
- Asignatura: Programación I
- Estudiante: Juan Pérez
- Evaluaciones de la asignatura:
  1. Quiz 1: Nota 3.5, Vale 10%
  2. Taller 1: Nota 4.2, Vale 15%
  3. Parcial 1: Nota 3.8, Vale 25%
  4. Proyecto: Nota 4.5, Vale 20%
  5. Examen Final: Nota 4.0, Vale 30%

**Pregunta:** ¿Cuál es la nota final de Juan en Programación I y aprobó la materia?

**Proceso de cálculo paso a paso:**

1. **Verificar que los porcentajes sumen 100%:**
   - 10% + 15% + 25% + 20% + 30% = 100% ✓

2. **Calcular la contribución de cada nota:**
   - Quiz 1: 3.5 × (10/100) = 3.5 × 0.10 = 0.35
   - Taller 1: 4.2 × (15/100) = 4.2 × 0.15 = 0.63
   - Parcial 1: 3.8 × (25/100) = 3.8 × 0.25 = 0.95
   - Proyecto: 4.5 × (20/100) = 4.5 × 0.20 = 0.90
   - Examen Final: 4.0 × (30/100) = 4.0 × 0.30 = 1.20

3. **Sumar todas las contribuciones:**
   - Nota Final = 0.35 + 0.63 + 0.95 + 0.90 + 1.20 = 4.03

4. **Determinar el estado de la asignatura:**
   - ¿4.03 ≥ 4.5? NO → No es "Excelencia"
   - ¿4.03 ≥ 3.0? SÍ → Estado: **Aprobada**

**Resultado:** Juan obtuvo 4.03 en Programación I y **APROBÓ** la materia.

---

### Ejemplo 2: Análisis Completo de un Estudiante con Múltiples Asignaturas

**Situación:**
- Estudiante: María González
- Código: 202315001
- Semestre: 2
- Asignaturas cursadas: 4 (Cálculo I, Física I, Programación I, Inglés I)

**Detalle de cada asignatura:**

**CÁLCULO I:**
- Parcial 1: 3.2 (30%)
- Parcial 2: 3.5 (30%)
- Examen Final: 3.8 (40%)

**FÍSICA I:**
- Quiz 1: 4.0 (10%)
- Quiz 2: 4.5 (10%)
- Laboratorio: 4.2 (20%)
- Parcial: 4.3 (30%)
- Examen Final: 4.4 (30%)

**PROGRAMACIÓN I:**
- Talleres: 2.8 (20%)
- Parcial: 2.5 (30%)
- Proyecto: 3.2 (50%)

**INGLÉS I:**
- Oral: 4.5 (25%)
- Escrito: 4.8 (25%)
- Parcial: 4.6 (30%)
- Final: 4.7 (20%)

**Proceso completo de análisis:**

**Paso 1 - Calcular la nota final de cada asignatura:**

**Cálculo I:**
- 3.2 × 0.30 = 0.96
- 3.5 × 0.30 = 1.05
- 3.8 × 0.40 = 1.52
- **Nota Final Cálculo I = 3.53** → Aprobada ✓

**Física I:**
- 4.0 × 0.10 = 0.40
- 4.5 × 0.10 = 0.45
- 4.2 × 0.20 = 0.84
- 4.3 × 0.30 = 1.29
- 4.4 × 0.30 = 1.32
- **Nota Final Física I = 4.30** → Aprobada ✓

**Programación I:**
- 2.8 × 0.20 = 0.56
- 2.5 × 0.30 = 0.75
- 3.2 × 0.50 = 1.60
- **Nota Final Programación I = 2.91** → Reprobada ✗

**Inglés I:**
- 4.5 × 0.25 = 1.125
- 4.8 × 0.25 = 1.200
- 4.6 × 0.30 = 1.380
- 4.7 × 0.20 = 0.940
- **Nota Final Inglés I = 4.645 ≈ 4.65** → Aprobada con Excelencia ✓

**Paso 2 - Calcular el promedio general del estudiante:**
- Promedio = (3.53 + 4.30 + 2.91 + 4.65) / 4
- Promedio = 15.39 / 4
- **Promedio General = 3.85**

**Paso 3 - Clasificar el rendimiento académico:**
- ¿3.85 ≥ 4.5? NO
- ¿3.85 ≥ 4.0? NO
- ¿3.85 ≥ 3.5? SÍ → Clasificación: **Aceptable**

**Paso 4 - Identificar mejor y peor asignatura:**
- Mejor asignatura: **Inglés I con 4.65**
- Peor asignatura: **Programación I con 2.91**

**Paso 5 - Contar aprobadas y reprobadas:**
- Aprobadas: 3 (Cálculo I, Física I, Inglés I)
- Reprobadas: 1 (Programación I)
- Total de asignaturas: 4
- ¿Reprobó más de la mitad? 1 > 2 → NO

**Paso 6 - Determinar estado académico:**
- Reprobó 1 materia
- ¿Es 0? NO
- ¿Es más de la mitad (más de 2)? NO
- Estado: **Advertencia** (reprobó entre 1 y la mitad)

**Paso 7 - Encontrar mejor y peor nota individual:**
- Revisando todas las notas individuales:
  * Mejor nota individual: **4.8** (Examen Escrito de Inglés I)
  * Peor nota individual: **2.5** (Parcial de Programación I)

**Resumen Final de María:**
\`\`\`
========================================
    REPORTE ACADÉMICO DEL ESTUDIANTE
========================================
Nombre: María González
Código: 202315001
Semestre: 2
----------------------------------------
ASIGNATURAS CURSADAS:
----------------------------------------
1. Cálculo I: 3.53 (APROBADA)
2. Física I: 4.30 (APROBADA)
3. Programación I: 2.91 (REPROBADA)
4. Inglés I: 4.65 (APROBADA CON EXCELENCIA)
----------------------------------------
RESUMEN ACADÉMICO:
----------------------------------------
Promedio General: 3.85
Clasificación: Aceptable
Asignaturas Aprobadas: 3
Asignaturas Reprobadas: 1
Estado Académico: Advertencia
----------------------------------------
ANÁLISIS DE FORTALEZAS Y DEBILIDADES:
----------------------------------------
Mejor Asignatura: Inglés I (4.65)
Peor Asignatura: Programación I (2.91)
Mejor Nota Individual: 4.8
Peor Nota Individual: 2.5
========================================
\`\`\`

---

### Ejemplo 3: Estudiante en Riesgo Académico

**Situación:**
- Estudiante: Carlos Ramírez
- Código: 202315002
- Semestre: 1
- Asignaturas cursadas: 5

**Notas Finales calculadas (ya ponderadas):**
- Matemáticas Básicas: 2.5 (Reprobada)
- Introducción a la Ingeniería: 3.2 (Aprobada)
- Química General: 2.8 (Reprobada)
- Programación Básica: 2.3 (Reprobada)
- Expresión Oral y Escrita: 3.5 (Aprobada)

**Análisis paso a paso:**

**Paso 1 - Contar aprobadas y reprobadas:**
- Aprobadas: 2 (Introducción a la Ingeniería, Expresión Oral y Escrita)
- Reprobadas: 3 (Matemáticas, Química, Programación)
- Total: 5 materias

**Paso 2 - Determinar si reprobó más de la mitad:**
- Mitad de 5 = 2.5
- ¿Reprobó 3 materias? SÍ
- ¿3 > 2.5? SÍ → Reprobó más de la mitad

**Paso 3 - Calcular promedio:**
- Promedio = (2.5 + 3.2 + 2.8 + 2.3 + 3.5) / 5
- Promedio = 14.3 / 5
- **Promedio = 2.86**

**Paso 4 - Clasificar rendimiento:**
- ¿2.86 ≥ 3.0? NO
- Clasificación: **Deficiente**

**Paso 5 - Determinar estado académico:**
- Reprobó 3 de 5 materias (más de la mitad)
- Estado: **Prueba Académica**

**Resultado:** Carlos está en una situación crítica. Con un promedio de 2.86 (Deficiente) y habiendo reprobado más de la mitad de sus materias, está en Prueba Académica y debe mejorar significativamente el próximo semestre o podría perder su cupo en la universidad.

---

### Ejemplo 4: Identificando la Importancia de los Porcentajes

**Situación:**
- Asignatura: Matemáticas Aplicadas
- Estudiante: Laura Sánchez

**Caso A: Laura prioriza los exámenes grandes**
- Quiz 1: 3.0 (Vale 10%)
- Quiz 2: 2.8 (Vale 10%)
- Taller: 3.2 (Vale 15%)
- Parcial: 4.2 (Vale 25%)
- Examen Final: 4.5 (Vale 40%)

**Cálculo:**
- 3.0 × 0.10 = 0.30
- 2.8 × 0.10 = 0.28
- 3.2 × 0.15 = 0.48
- 4.2 × 0.25 = 1.05
- 4.5 × 0.40 = 1.80
- **Nota Final = 3.91** → Aprobada ✓

**Análisis:** Aunque Laura tuvo notas bajas en los quices (2.8 y 3.0), logró aprobar porque se enfocó en las evaluaciones de mayor peso. El examen final (40%) y el parcial (25%) juntos valen 65% de la nota, y en esos sacó buenas calificaciones.

**Caso B: Pedro prioriza los trabajos pequeños**
- Quiz 1: 5.0 (Vale 10%)
- Quiz 2: 5.0 (Vale 10%)
- Taller: 4.8 (Vale 15%)
- Parcial: 2.5 (Vale 25%)
- Examen Final: 2.0 (Vale 40%)

**Cálculo:**
- 5.0 × 0.10 = 0.50
- 5.0 × 0.10 = 0.50
- 4.8 × 0.15 = 0.72
- 2.5 × 0.25 = 0.625
- 2.0 × 0.40 = 0.80
- **Nota Final = 3.145 ≈ 3.15** → Aprobada (pero apenas)

**Análisis:** Aunque Pedro sacó excelentes notas en los quices y el taller (5.0, 5.0, 4.8), estas evaluaciones solo valen 35% en total. Como le fue mal en el parcial y el final (que juntos valen 65%), apenas logró aprobar con 3.15.

**Lección importante:** No todas las notas tienen el mismo impacto. Es más importante sacar buenas notas en las evaluaciones con mayor porcentaje.

---

## Escenarios de Práctica para Resolver

### Escenario 1: Estudiante con Rendimiento Variable

**Situación Inicial:**
- Estudiante: Andrea Morales
- Código: 202415001
- Semestre: 3
- Asignaturas: 4

**Detalle de Asignaturas:**

**ÁLGEBRA LINEAL:**
- Parcial 1: 3.8 (35%)
- Parcial 2: 4.0 (35%)
- Examen Final: 3.5 (30%)

**ESTRUCTURAS DE DATOS:**
- Quices (promedio): 4.5 (20%)
- Talleres: 3.8 (20%)
- Proyecto: 4.2 (30%)
- Examen Final: 3.9 (30%)

**BASES DE DATOS:**
- Talleres: 2.8 (25%)
- Parcial: 3.0 (35%)
- Proyecto Final: 3.5 (40%)

**ÉTICA PROFESIONAL:**
- Ensayos: 4.8 (30%)
- Presentación: 4.5 (30%)
- Examen: 4.6 (40%)

**Preguntas:**
1. ¿Cuál es la nota final de cada asignatura?
2. ¿Cuántas asignaturas aprobó y cuántas reprobó Andrea?
3. ¿Cuál es el promedio general de Andrea?
4. ¿Cuál es su clasificación de rendimiento académico?
5. ¿Cuál es su mejor y peor asignatura?
6. ¿Cuál es su estado académico?

---

### Escenario 2: Estudiante con Dificultades en Materias Técnicas

**Situación Inicial:**
- Estudiante: Diego Torres
- Código: 202415002
- Semestre: 2
- Asignaturas: 5

**Notas Finales ya calculadas:**
- Cálculo Diferencial: 2.7
- Física Mecánica: 2.5
- Programación Orientada a Objetos: 2.9
- Constitución Política: 4.0
- Comunicación Escrita: 4.3

**Preguntas:**
1. ¿Cuántas materias aprobó y cuántas reprobó Diego?
2. ¿Cuál es su promedio general?
3. ¿Cuál es su clasificación de rendimiento?
4. ¿Cuál es su estado académico? ¿Está en riesgo?
5. ¿Cuáles son sus fortalezas y debilidades académicas?

---

### Escenario 3: Impacto de una Sola Evaluación

**Situación:**
- Asignatura: Cálculo Integral
- Estudiante: Sofía Hernández
- Ya han pasado 4 evaluaciones

**Evaluaciones completadas:**
- Quiz 1: 4.5 (10%)
- Taller: 4.0 (15%)
- Parcial 1: 4.2 (25%)
- Proyecto: 4.3 (20%)

**Evaluación pendiente:**
- Examen Final: ? (Vale 30%)

**Preguntas:**
1. Si Sofía quiere aprobar con al menos 3.0, ¿cuál es la nota mínima que necesita en el examen final?
2. Si Sofía quiere lograr "Aprobada con Excelencia" (4.5), ¿cuál es la nota mínima que necesita en el examen final?
3. Si Sofía saca 3.0 en el examen final, ¿cuál sería su nota final en la asignatura?

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto académico y los ejemplos proporcionados, identifique:

a) **Atributos necesarios para la clase Estudiante** (mínimo 4 atributos)
   - Piense en la información básica del estudiante

b) **Atributos necesarios para la clase Asignatura** (mínimo 3 atributos)
   - Piense en qué información necesita una materia

c) **Atributos necesarios para la clase Nota** (exactamente 3 atributos)
   - Revise qué compone una nota individual

d) **Métodos necesarios para implementar todas las operaciones** (mínimo 8 métodos)
   - Piense en qué cálculos y operaciones debe hacer el sistema

### 2. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

a) **Método calcularNotaFinalAsignatura()**
   - Debe recorrer todas las notas de la asignatura
   - Calcular el promedio ponderado
   - Retornar la nota final

b) **Método determinarEstadoAsignatura(notaFinal)**
   - Debe determinar si está aprobada, aprobada con excelencia, o reprobada
   - Retornar el estado correspondiente

c) **Método calcularPromedioGeneral()**
   - Debe calcular la nota final de cada asignatura
   - Calcular el promedio aritmético de todas las notas finales
   - Retornar el promedio general

d) **Método determinarEstadoAcademico()**
   - Debe contar cuántas materias reprobó
   - Comparar con el total de materias
   - Determinar si está Regular, en Advertencia o en Prueba Académica
   - Retornar el estado

### 3. Implementación en Java

**Instrucciones:** Implemente las clases completas en Java:

**Clase \`Nota\`:**
- Atributos: nombre, valor, porcentaje
- Constructor
- Métodos getters necesarios

**Clase \`Asignatura\`:**
- Atributos necesarios incluyendo el nombre y las notas (máximo 10 notas por asignatura)
- Constructor
- Método para agregar una nota
- Método para calcular la nota final
- Método para determinar el estado (aprobada/reprobada)
- Contador de cuántas notas tiene actualmente

**Clase \`Estudiante\`:**
- Atributos necesarios incluyendo información personal y asignaturas (máximo 8 asignaturas)
- Constructor
- Método para agregar una asignatura
- Método para calcular promedio general
- Método para determinar clasificación de rendimiento
- Método para contar aprobadas y reprobadas
- Método para determinar estado académico
- Método para encontrar mejor y peor asignatura
- Método \`mostrarReporteCompleto()\` que imprima toda la información del estudiante

**Consideraciones importantes:**
- Use arreglos SIMPLES para almacenar múltiples notas y asignaturas (NO listas ni colecciones avanzadas)
- Use estructuras de decisión (if, else if, else, switch)
- Use ciclos (for, while) para recorrer las notas y asignaturas
- Todos los cálculos deben ser precisos usando tipo \`double\`
- El sistema debe validar que los porcentajes de una asignatura sumen 100%
- Use contadores para saber cuántas notas/asignaturas se han agregado

**Ejemplo de estructura de arreglos:**
\`\`\`java
// En la clase Asignatura
private Nota[] notas;  // Arreglo de máximo 10 notas
private int cantidadNotas;  // Contador de notas actuales

// En la clase Estudiante
private Asignatura[] asignaturas;  // Arreglo de máximo 8 asignaturas
private int cantidadAsignaturas;  // Contador de asignaturas actuales
\`\`\`

### 4. Programa Principal de Prueba

**Instrucciones:** Cree una clase \`SistemaAcademico\` con el método \`main\` que:

1. Cree un estudiante con sus datos
2. Cree al menos 3 asignaturas con sus respectivas notas
3. Agregue las asignaturas al estudiante
4. Muestre el reporte completo del estudiante

**Ejemplo de caso de prueba:**
Cree el caso de María González del Ejemplo 2 y verifique que los cálculos coincidan con los resultados mostrados.

---

## Criterios de Evaluación

1. **Identificación correcta de atributos** (15%)
   - Completitud y relevancia de los atributos de cada clase

2. **Identificación correcta de métodos** (15%)
   - Coherencia con las operaciones académicas necesarias

3. **Diagramas de flujo** (25%)
   - Correcta representación de la lógica
   - Uso apropiado de decisiones y ciclos
   - Claridad en los pasos

4. **Implementación en Java** (35%)
   - Sintaxis correcta
   - Lógica completa y funcional
   - Correcta implementación de ciclos y arreglos
   - Manejo adecuado de todas las reglas académicas
   - Validaciones apropiadas

5. **Programa de prueba** (10%)
   - Creación correcta de objetos
   - Casos de prueba completos
   - Resultados correctos

---

## Conceptos Técnicos que Debe Aplicar

### Estructuras de Decisión
- **Decisiones simples**: Para validar si una nota es válida (0.0 a 5.0)
- **Decisiones múltiples**: Para clasificar el rendimiento académico
- **Decisiones anidadas**: Para determinar el estado académico considerando múltiples condiciones

### Estructuras de Repetición
- **Ciclo for**: Para recorrer todas las notas de una asignatura
- **Ciclo while**: Para validar que los porcentajes sumen 100%
- **Ciclos anidados**: Para calcular el promedio de todas las asignaturas (ciclo externo para asignaturas, interno para notas)

### Arreglos
- **Arreglos de objetos**: Para almacenar múltiples notas en una asignatura
- **Arreglos de objetos**: Para almacenar múltiples asignaturas en un estudiante
- **Uso de contadores**: Para saber cuántos elementos hay en cada arreglo

### Cálculos Matemáticos
- **Promedio ponderado**: Para calcular notas finales de asignaturas
- **Promedio aritmético**: Para calcular el promedio general
- **Porcentajes**: Para validar que sumen 100% y para aplicar ponderaciones

---

## Casos Especiales a Considerar

1. **Validación de Porcentajes**
   - ¿Qué pasa si los porcentajes de una asignatura no suman exactamente 100%?
   - El sistema debe detectar este error y no permitir calcular la nota final

2. **Asignaturas sin Notas**
   - ¿Qué pasa si una asignatura no tiene ninguna nota registrada?
   - El sistema debe manejar este caso sin generar errores

3. **Estudiante sin Asignaturas**
   - ¿Qué pasa si se intenta calcular el promedio de un estudiante sin materias?
   - El sistema debe validar esta situación

4. **Notas Fuera de Rango**
   - ¿Qué pasa si alguien intenta agregar una nota de 6.0 o -1.0?
   - El sistema debe validar que las notas estén entre 0.0 y 5.0

5. **Arreglos Llenos**
   - ¿Qué pasa si se intenta agregar más de 10 notas a una asignatura?
   - ¿Qué pasa si se intenta agregar más de 8 asignaturas a un estudiante?
   - El sistema debe validar estos límites

---

## Pistas para la Solución

### Para calcular la nota final de una asignatura:
\`\`\`
1. Inicializar una variable notaFinal en 0
2. Para cada nota en la asignatura:
   a. Multiplicar el valor de la nota por (porcentaje/100)
   b. Sumar el resultado a notaFinal
3. Retornar notaFinal
\`\`\`

### Para determinar el estado académico:
\`\`\`
1. Contar cuántas materias tiene el estudiante (total)
2. Contar cuántas materias reprobó (contador)
3. Calcular la mitad: total / 2
4. Si contador == 0: Estado Regular
5. Si contador > mitad: Estado Prueba Académica
6. Si no: Estado Advertencia
\`\`\`

### Para encontrar la mejor asignatura:
\`\`\`
1. Inicializar mejorNota con la nota de la primera asignatura
2. Inicializar nombreMejor con el nombre de la primera asignatura
3. Para cada asignatura restante:
   a. Calcular su nota final
   b. Si esta nota > mejorNota:
      - Actualizar mejorNota
      - Actualizar nombreMejor
4. Retornar nombreMejor y mejorNota
\`\`\`

---

## Notas Finales

- Este ejercicio está diseñado para practicar programación orientada a objetos básica
- Preste atención a la diferencia entre promedio ponderado y aritmético
- Las validaciones son fundamentales para un sistema robusto
- Recuerde que debe manejar múltiples objetos relacionados (Estudiante tiene Asignaturas, Asignaturas tienen Notas)
- El orden de los cálculos es importante: primero calcule las notas finales de cada asignatura, luego el promedio general
- Los contadores son esenciales para trabajar con arreglos que no están completamente llenos
- Pruebe su código con los ejemplos proporcionados para verificar que funciona correctamente
