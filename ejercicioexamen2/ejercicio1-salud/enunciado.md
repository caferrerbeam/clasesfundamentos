# 🏥 Ejercicio de Programación: Sistema de Evaluación de Salud

## Contexto del Negocio

El centro médico **"Vida Saludable"** necesita un sistema para evaluar el estado de salud de sus pacientes y determinar su riesgo cardiovascular. El sistema debe analizar múltiples factores de salud para clasificar a los pacientes y generar recomendaciones personalizadas.

Cuando un paciente se registra en el sistema, se recopilan datos básicos como peso, altura, edad y género, además de información sobre sus hábitos de vida (si fuma, hace ejercicio) y resultados de exámenes médicos (nivel de colesterol). Con esta información, el sistema calcula indicadores de salud y determina el nivel de riesgo del paciente.

### Reglas del Negocio

1. **Cálculo del Índice de Masa Corporal (IMC)**
   - El IMC es un indicador que relaciona el peso y la altura de una persona
   - Fórmula: IMC = peso (kg) / (altura (m) × altura (m))
   - Ejemplo: Una persona de 70 kg y 1.70 m tiene IMC = 70 / (1.70 × 1.70) = 70 / 2.89 = 24.2

2. **Clasificación del Peso según IMC y Género**

   **Para Hombres:**
   - IMC menor a 18.5: "Bajo peso"
   - IMC entre 18.5 y 24.9: "Peso normal"
   - IMC entre 25 y 29.9: "Sobrepeso"
   - IMC de 30 o más: "Obesidad"

   **Para Mujeres:**
   - IMC menor a 18: "Bajo peso"
   - IMC entre 18 y 24: "Peso normal"
   - IMC entre 24.1 y 29: "Sobrepeso"
   - IMC de 29.1 o más: "Obesidad"

   Nota: Los rangos son diferentes porque la composición corporal varía entre géneros

3. **Niveles de Colesterol**
   El colesterol es una sustancia en la sangre que en exceso puede ser peligrosa:
   - **Bajo**: Nivel óptimo de colesterol (menos de 200 mg/dL)
   - **Normal**: Nivel aceptable (200-239 mg/dL)
   - **Alto**: Nivel de riesgo (240 mg/dL o más)

4. **Evaluación del Riesgo Cardiovascular**

   El riesgo cardiovascular se evalúa combinando múltiples factores según grupos de edad:

   **Pacientes menores de 30 años:**
   - Si NO fuma Y hace ejercicio: "Riesgo bajo"
   - Si fuma O no hace ejercicio: "Riesgo moderado"

   **Pacientes entre 30 y 50 años:**
   - Si tiene peso normal Y no fuma Y colesterol bajo o normal: "Riesgo bajo"
   - Si tiene sobrepeso O fuma O colesterol alto: "Riesgo moderado"
   - Si tiene obesidad Y fuma: "Riesgo alto"

   **Pacientes mayores de 50 años:**
   - Si tiene peso normal Y no fuma Y hace ejercicio Y colesterol bajo o normal: "Riesgo moderado"
   - Si tiene sobrepeso O obesidad O fuma O colesterol alto: "Riesgo alto"
   - Si tiene obesidad Y fuma Y colesterol alto: "Riesgo muy alto"

5. **Generación de Recomendaciones**

   Según la clasificación de peso y la edad del paciente:

   - **Bajo peso:**
     - "Consulta nutricional urgente - posible desnutrición"

   - **Sobrepeso u Obesidad en menores de 40 años:**
     - "Plan de ejercicio intensivo y dieta balanceada"

   - **Sobrepeso u Obesidad en mayores de 40 años:**
     - "Consulta médica y programa de ejercicio moderado"

   - **Peso normal:**
     - "Mantener hábitos saludables - control anual"

6. **Determinación de Consulta Médica Urgente**

   Un paciente requiere consulta médica urgente si cumple CUALQUIERA de estas condiciones:
   - Tiene riesgo cardiovascular "Alto" o "Muy alto"
   - Tiene obesidad Y es mayor de 45 años
   - Fuma Y tiene sobrepeso u obesidad
   - Tiene colesterol alto Y fuma

7. **Puntuación de Salud General**

   El sistema asigna un puntaje de salud (0-100 puntos) según estos criterios:

   **Puntos base según IMC:**
   - Peso normal: 40 puntos
   - Bajo peso: 25 puntos
   - Sobrepeso: 20 puntos
   - Obesidad: 10 puntos

   **Bonificación por hábitos:**
   - Hace ejercicio: +20 puntos
   - No fuma: +20 puntos

   **Bonificación por colesterol:**
   - Colesterol bajo: +20 puntos
   - Colesterol normal: +10 puntos
   - Colesterol alto: 0 puntos

   **Clasificación final según puntuación:**
   - 80-100 puntos: "Salud excelente"
   - 60-79 puntos: "Salud buena"
   - 40-59 puntos: "Salud regular"
   - 0-39 puntos: "Salud deficiente"

---

## Conceptos Importantes para Entender el Problema

### ¿Qué es el IMC y por qué es importante?

El Índice de Masa Corporal (IMC) es una medida que relaciona el peso de una persona con su altura. Es importante porque:
- Ayuda a identificar si una persona tiene un peso saludable
- Niveles muy altos o muy bajos pueden indicar problemas de salud
- Es diferente para hombres y mujeres debido a diferencias en composición corporal
- No considera masa muscular, pero es útil como indicador general

### ¿Qué significa "Riesgo Cardiovascular"?

El riesgo cardiovascular es la probabilidad de que una persona desarrolle enfermedades del corazón. Factores que aumentan el riesgo:
- **Obesidad:** El exceso de peso sobrecarga el corazón
- **Fumar:** Daña las arterias y reduce el oxígeno en la sangre
- **No hacer ejercicio:** El corazón necesita actividad para mantenerse fuerte
- **Colesterol alto:** Se acumula en las arterias y las bloquea
- **Edad:** El riesgo aumenta con los años

### ¿Por qué la edad cambia la evaluación?

Las personas jóvenes tienen mayor capacidad de recuperación, por eso:
- En menores de 30 años, los malos hábitos tienen menos impacto inmediato
- Entre 30-50 años, los factores de riesgo empiezan a acumularse
- Mayores de 50 años tienen mayor riesgo incluso con buenos hábitos

---

## Ejemplos Resueltos

Para entender mejor cómo funciona el sistema, veamos varios casos reales:

### Ejemplo 1: Paciente Joven con Buenos Hábitos

**Datos del Paciente:**
- Nombre: Andrea Gómez
- Peso: 62 kg
- Altura: 1.65 m
- Edad: 25 años
- Género: Femenino (F)
- Fuma: No
- Hace ejercicio: Sí
- Nivel de colesterol: Bajo

**Proceso de Evaluación:**

**Paso 1 - Calcular IMC:**
- IMC = 62 / (1.65 × 1.65)
- IMC = 62 / 2.7225
- IMC = 22.8

**Paso 2 - Clasificar peso (mujer):**
- ¿IMC (22.8) < 18? NO
- ¿IMC está entre 18 y 24? SÍ → Clasificación: "Peso normal"

**Paso 3 - Evaluar riesgo cardiovascular (edad 25 años, es menor de 30):**
- ¿NO fuma? SÍ
- ¿Hace ejercicio? SÍ
- Ambas condiciones cumplidas → Riesgo: "Riesgo bajo"

**Paso 4 - Generar recomendación (peso normal):**
- Recomendación: "Mantener hábitos saludables - control anual"

**Paso 5 - Verificar consulta urgente:**
- ¿Riesgo alto o muy alto? NO
- ¿Obesidad y mayor de 45? NO
- ¿Fuma y sobrepeso/obesidad? NO
- ¿Colesterol alto y fuma? NO
- Consulta urgente: NO

**Paso 6 - Calcular puntuación de salud:**
- Puntos base (peso normal): 40 puntos
- Bonificación por ejercicio: +20 puntos
- Bonificación por no fumar: +20 puntos
- Bonificación por colesterol bajo: +20 puntos
- **Total: 100 puntos → "Salud excelente"**

**Resultado Final:**
- IMC: 22.8
- Clasificación: Peso normal
- Riesgo cardiovascular: Riesgo bajo
- Recomendación: Mantener hábitos saludables - control anual
- Requiere consulta urgente: NO
- Puntuación de salud: 100 - Salud excelente

---

### Ejemplo 2: Paciente de Mediana Edad con Factores de Riesgo

**Datos del Paciente:**
- Nombre: Roberto Díaz
- Peso: 95 kg
- Altura: 1.75 m
- Edad: 45 años
- Género: Masculino (M)
- Fuma: Sí
- Hace ejercicio: No
- Nivel de colesterol: Normal

**Proceso Completo:**

**Paso 1 - Calcular IMC:**
- IMC = 95 / (1.75 × 1.75)
- IMC = 95 / 3.0625
- IMC = 31.0

**Paso 2 - Clasificar peso (hombre):**
- ¿IMC (31.0) < 18.5? NO
- ¿IMC está entre 18.5 y 24.9? NO
- ¿IMC está entre 25 y 29.9? NO
- ¿IMC ≥ 30? SÍ → Clasificación: "Obesidad"

**Paso 3 - Evaluar riesgo cardiovascular (edad 45 años, está entre 30 y 50):**
- ¿Tiene peso normal Y no fuma Y colesterol bajo/normal? NO (tiene obesidad)
- ¿Tiene sobrepeso O fuma O colesterol alto? SÍ (tiene obesidad que es peor que sobrepeso, y además fuma)
- ¿Tiene obesidad Y fuma? SÍ → Riesgo: "Riesgo alto"

**Paso 4 - Generar recomendación (obesidad y mayor de 40):**
- Recomendación: "Consulta médica y programa de ejercicio moderado"

**Paso 5 - Verificar consulta urgente:**
- ¿Riesgo alto o muy alto? SÍ (tiene riesgo alto) → Consulta urgente: SÍ
- También cumple: ¿Fuma y sobrepeso/obesidad? SÍ

**Paso 6 - Calcular puntuación de salud:**
- Puntos base (obesidad): 10 puntos
- Bonificación por ejercicio: 0 (no hace ejercicio)
- Bonificación por no fumar: 0 (fuma)
- Bonificación por colesterol normal: +10 puntos
- **Total: 20 puntos → "Salud deficiente"**

**Resultado Final:**
- IMC: 31.0
- Clasificación: Obesidad
- Riesgo cardiovascular: Riesgo alto
- Recomendación: Consulta médica y programa de ejercicio moderado
- Requiere consulta urgente: SÍ
- Puntuación de salud: 20 - Salud deficiente

---

### Ejemplo 3: Paciente Mayor con Control de Riesgos

**Datos del Paciente:**
- Nombre: Carmen Silva
- Peso: 68 kg
- Altura: 1.60 m
- Edad: 58 años
- Género: Femenino (F)
- Fuma: No
- Hace ejercicio: Sí
- Nivel de colesterol: Bajo

**Análisis Paso a Paso:**

**Paso 1 - Calcular IMC:**
- IMC = 68 / (1.60 × 1.60)
- IMC = 68 / 2.56
- IMC = 26.6

**Paso 2 - Clasificar peso (mujer):**
- ¿IMC (26.6) < 18? NO
- ¿IMC está entre 18 y 24? NO
- ¿IMC está entre 24.1 y 29? SÍ → Clasificación: "Sobrepeso"

**Paso 3 - Evaluar riesgo cardiovascular (edad 58 años, es mayor de 50):**
- ¿Tiene peso normal Y no fuma Y hace ejercicio Y colesterol bajo/normal? NO (tiene sobrepeso, no peso normal)
- ¿Tiene sobrepeso O obesidad O fuma O colesterol alto? SÍ (tiene sobrepeso) → Riesgo: "Riesgo alto"

**Paso 4 - Generar recomendación (sobrepeso y mayor de 40):**
- Recomendación: "Consulta médica y programa de ejercicio moderado"

**Paso 5 - Verificar consulta urgente:**
- ¿Riesgo alto o muy alto? SÍ (tiene riesgo alto) → Consulta urgente: SÍ

**Paso 6 - Calcular puntuación de salud:**
- Puntos base (sobrepeso): 20 puntos
- Bonificación por ejercicio: +20 puntos
- Bonificación por no fumar: +20 puntos
- Bonificación por colesterol bajo: +20 puntos
- **Total: 80 puntos → "Salud excelente"**

**Resultado Final:**
- IMC: 26.6
- Clasificación: Sobrepeso
- Riesgo cardiovascular: Riesgo alto
- Recomendación: Consulta médica y programa de ejercicio moderado
- Requiere consulta urgente: SÍ
- Puntuación de salud: 80 - Salud excelente

**Nota importante:** Este caso muestra que aunque tiene sobrepeso y riesgo alto por su edad, sus buenos hábitos le dan una puntuación excelente. Necesita bajar de peso pero está haciendo las cosas correctas.

---

### Ejemplo 4: Paciente Joven con Bajo Peso

**Datos del Paciente:**
- Nombre: Julián Vargas
- Peso: 58 kg
- Altura: 1.78 m
- Edad: 22 años
- Género: Masculino (M)
- Fuma: No
- Hace ejercicio: Sí
- Nivel de colesterol: Bajo

**Evaluación Detallada:**

**Paso 1 - Calcular IMC:**
- IMC = 58 / (1.78 × 1.78)
- IMC = 58 / 3.1684
- IMC = 18.3

**Paso 2 - Clasificar peso (hombre):**
- ¿IMC (18.3) < 18.5? SÍ → Clasificación: "Bajo peso"

**Paso 3 - Evaluar riesgo cardiovascular (edad 22 años, es menor de 30):**
- ¿NO fuma? SÍ
- ¿Hace ejercicio? SÍ
- Ambas condiciones cumplidas → Riesgo: "Riesgo bajo"

**Paso 4 - Generar recomendación (bajo peso):**
- Recomendación: "Consulta nutricional urgente - posible desnutrición"

**Paso 5 - Verificar consulta urgente:**
- ¿Riesgo alto o muy alto? NO
- ¿Obesidad y mayor de 45? NO
- ¿Fuma y sobrepeso/obesidad? NO
- ¿Colesterol alto y fuma? NO
- Consulta urgente: NO (aunque necesita consulta nutricional)

**Paso 6 - Calcular puntuación de salud:**
- Puntos base (bajo peso): 25 puntos
- Bonificación por ejercicio: +20 puntos
- Bonificación por no fumar: +20 puntos
- Bonificación por colesterol bajo: +20 puntos
- **Total: 85 puntos → "Salud excelente"**

**Resultado Final:**
- IMC: 18.3
- Clasificación: Bajo peso
- Riesgo cardiovascular: Riesgo bajo
- Recomendación: Consulta nutricional urgente - posible desnutrición
- Requiere consulta urgente: NO
- Puntuación de salud: 85 - Salud excelente

**Observación:** El bajo peso no es bueno, pero sus buenos hábitos le dan alta puntuación. Necesita ganar peso de manera saludable.

---

## Escenarios de Práctica para Resolver

### Escenario 1: Evaluación de tres hermanos

**Hermano 1 - Carlos Méndez:**
- Peso: 72 kg, Altura: 1.70 m
- Edad: 28 años, Género: M
- Fuma: No, Hace ejercicio: Sí
- Colesterol: Normal

**Hermano 2 - Luis Méndez:**
- Peso: 92 kg, Altura: 1.72 m
- Edad: 35 años, Género: M
- Fuma: Sí, Hace ejercicio: No
- Colesterol: Alto

**Hermano 3 - Jorge Méndez:**
- Peso: 110 kg, Altura: 1.75 m
- Edad: 52 años, Género: M
- Fuma: Sí, Hace ejercicio: No
- Colesterol: Alto

**Preguntas:**
- ¿Cuál es el IMC de cada uno?
- ¿Cuál es la clasificación de peso de cada uno?
- ¿Cuál tiene el riesgo cardiovascular más alto?
- ¿Quién requiere consulta médica urgente?
- ¿Cuál tiene la mejor puntuación de salud?

### Escenario 2: Comparación de pacientes con mismo peso

**Paciente A - María Torres:**
- Peso: 75 kg, Altura: 1.68 m
- Edad: 42 años, Género: F
- Fuma: No, Hace ejercicio: Sí
- Colesterol: Bajo

**Paciente B - Laura Sánchez:**
- Peso: 75 kg, Altura: 1.68 m
- Edad: 42 años, Género: F
- Fuma: Sí, Hace ejercicio: No
- Colesterol: Alto

**Preguntas:**
- ¿Tienen el mismo IMC? ¿Por qué?
- ¿Tienen la misma clasificación de peso?
- ¿Tienen el mismo riesgo cardiovascular? ¿Por qué?
- ¿Cuál es la diferencia en sus puntuaciones de salud?
- ¿Qué muestra este ejemplo sobre la importancia de los hábitos?

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto del negocio y los ejemplos proporcionados, identifique:

a) **Atributos necesarios** para la clase `EvaluacionSalud` (mínimo 7 atributos)
   - Piense en toda la información del paciente que se necesita para los cálculos
   - Incluya datos personales, medidas físicas y hábitos

b) **Métodos necesarios** para implementar todas las operaciones descritas (mínimo 7 métodos)
   - Identifique qué cálculos se necesitan
   - Qué clasificaciones se deben hacer
   - Qué validaciones se requieren

---

### 2. Diagrama de Clases

A continuación se presenta el diagrama de clases que debe implementar. **Su tarea es llenar la lógica de cada uno de los métodos** siguiendo las reglas de negocio descritas en este documento.

```
┌─────────────────────────────────────────────────────────┐
│              EvaluacionSalud                            │
├─────────────────────────────────────────────────────────┤
│ - nombre: String                                        │
│ - peso: double                                          │
│ - altura: double                                        │
│ - edad: int                                             │
│ - genero: String                                        │
│ - fuma: boolean                                         │
│ - haceEjercicio: boolean                                │
│ - nivelColesterol: String                               │
├─────────────────────────────────────────────────────────┤
│ + EvaluacionSalud(nombre, peso, altura, edad,          │
│                    genero, fuma, haceEjercicio,         │
│                    nivelColesterol)                     │
│ + calcularIMC(): double                                 │
│ + clasificarPeso(): String                              │
│ + evaluarRiesgoCardiovascular(): String                 │
│ + generarRecomendacion(): String                        │
│ + requiereConsultaMedica(): boolean                     │
│ + calcularPuntuacionSalud(): int                        │
│ + clasificarSalud(): String                             │
│ + mostrarReporteSalud(): void                           │
└─────────────────────────────────────────────────────────┘
```

**Descripción de los métodos que debe implementar:**

1. **calcularIMC()**: Calcula y retorna el IMC usando la fórmula: peso / (altura × altura)

2. **clasificarPeso()**: Determina la clasificación de peso según el IMC y el género
   - Debe usar decisiones para distinguir entre hombre y mujer
   - Retorna: "Bajo peso", "Peso normal", "Sobrepeso" o "Obesidad"

3. **evaluarRiesgoCardiovascular()**: Evalúa el riesgo combinando edad, peso, hábitos y colesterol
   - Usa decisiones anidadas: primero por edad, luego por factores de riesgo
   - Retorna: "Riesgo bajo", "Riesgo moderado", "Riesgo alto" o "Riesgo muy alto"

4. **generarRecomendacion()**: Genera recomendación según clasificación de peso y edad
   - Retorna un String con la recomendación apropiada

5. **requiereConsultaMedica()**: Determina si necesita consulta urgente
   - Retorna true si cumple alguna de las condiciones de riesgo alto

6. **calcularPuntuacionSalud()**: Calcula puntuación (0-100) sumando puntos base y bonificaciones
   - Retorna el puntaje total

7. **clasificarSalud()**: Clasifica la salud según la puntuación obtenida
   - Retorna: "Salud excelente", "Salud buena", "Salud regular" o "Salud deficiente"

8. **mostrarReporteSalud()**: Imprime un reporte completo con todos los resultados

---

### 3. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

a) **Método calcularIMC()**
   - Recibe peso y altura
   - Calcula y retorna el IMC
   - Use la fórmula correcta

b) **Método clasificarPeso()**
   - Debe considerar el IMC y el género
   - Aplicar rangos diferentes para hombres y mujeres
   - Retornar la clasificación correspondiente

c) **Método evaluarRiesgoCardiovascular()**
   - Debe considerar edad, clasificación de peso, hábitos y colesterol
   - Usar decisiones anidadas según el grupo de edad
   - Retornar el nivel de riesgo

d) **Método calcularPuntuacionSalud()**
   - Calcular puntos base según clasificación de peso
   - Sumar bonificaciones por hábitos
   - Sumar bonificación por colesterol
   - Clasificar según puntuación final

### 4. Implementación en Java

**Instrucciones:** Implemente la clase completa `EvaluacionSalud` en Java con:

- Todos los atributos identificados
- Constructor que inicialice los datos del paciente
- Todos los métodos identificados con su lógica completa
- Un método `mostrarReporteSalud()` que imprima:
  - Nombre del paciente
  - Datos básicos (peso, altura, edad, género)
  - IMC calculado
  - Clasificación de peso
  - Riesgo cardiovascular
  - Recomendación
  - Si requiere consulta urgente
  - Puntuación de salud y clasificación

**Consideraciones importantes:**
- Use solo estructuras de decisión (if, else if, else)
- NO use arreglos, listas o colecciones
- Todos los cálculos deben estar en una sola clase
- Use tipos de datos apropiados:
  - `double` para peso, altura, IMC
  - `int` para edad y puntuación
  - `String` para nombre, género, clasificaciones
  - `boolean` para hábitos (fuma, hace ejercicio)
- Preste especial atención a las decisiones anidadas en la evaluación de riesgo
- Los rangos de IMC son diferentes para hombres y mujeres

### 5. Método Main de Prueba

Cree un método main que pruebe su clase con al menos 4 pacientes diferentes:
- Un paciente joven con buenos hábitos
- Un paciente de mediana edad con factores de riesgo
- Un paciente mayor con control de riesgos
- Un paciente con bajo peso

Para cada paciente, llame al método `mostrarReporteSalud()` para ver los resultados completos.

---

## Criterios de Evaluación

1. **Identificación correcta de atributos** (15%)
   - Completitud y relevancia de los atributos
   - Elección de tipos de datos apropiados

2. **Identificación correcta de métodos** (15%)
   - Coherencia con las operaciones del negocio
   - Separación adecuada de responsabilidades

3. **Diagramas de flujo** (30%)
   - Correcta representación de la lógica
   - Uso apropiado de decisiones simples y anidadas
   - Manejo correcto de múltiples condiciones
   - Claridad y organización

4. **Implementación en Java** (35%)
   - Sintaxis correcta
   - Lógica completa y funcional
   - Manejo adecuado de todas las reglas del negocio
   - Correcta aplicación de rangos según género
   - Decisiones anidadas bien implementadas

5. **Método main y pruebas** (5%)
   - Casos de prueba representativos
   - Cobertura de diferentes escenarios

---

## Notas Finales

- Este ejercicio está diseñado para practicar decisiones anidadas en múltiples niveles
- La evaluación de riesgo cardiovascular requiere analizar la edad PRIMERO y luego aplicar reglas diferentes para cada grupo
- Los rangos de IMC son diferentes para hombres y mujeres - no los confunda
- Preste atención al orden de las validaciones, puede afectar el resultado
- La puntuación de salud es independiente del riesgo cardiovascular - un paciente puede tener buena puntuación pero riesgo alto
- Recuerde que algunas decisiones dependen del resultado de otras (decisiones anidadas)
- Use comentarios en su código para explicar la lógica de las decisiones más complejas
