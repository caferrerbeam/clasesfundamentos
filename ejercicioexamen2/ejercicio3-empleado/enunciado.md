# 💼 Ejercicio de Programación: Sistema de Evaluación Integral de Empleados

## Contexto del Negocio

La empresa **"TechCorp Solutions"** necesita un sistema automatizado para evaluar el desempeño de sus empleados y calcular su compensación anual. El sistema debe considerar múltiples factores: productividad, asistencia, antigüedad, número de proyectos completados, trabajo en equipo, certificaciones profesionales y responsabilidades de liderazgo.

La empresa tiene una estructura organizacional con cuatro niveles de cargos (operativo, administrativo, gerencial y directivo), cada uno con criterios de evaluación y compensación diferentes. El sistema debe ser justo, transparente y motivar a los empleados a mejorar su desempeño.

### Reglas del Negocio

1. **Estructura de Cargos de la Empresa**

   La empresa tiene cuatro niveles de cargos con responsabilidades diferentes:

   - **Operativo**: Personal de ejecución y soporte técnico
   - **Administrativo**: Personal de gestión administrativa y coordinación
   - **Gerencial**: Gerentes de área y jefes de departamento
   - **Directivo**: Directores y alta gerencia

2. **Evaluación de Productividad**

   Cada empleado recibe un puntaje de productividad de 0 a 100. La categoría de desempeño se determina según el cargo y el puntaje:

   **Cargo Operativo:**
   - 90-100 puntos: "Sobresaliente"
   - 75-89 puntos: "Destacado"
   - 60-74 puntos: "Satisfactorio"
   - Menos de 60 puntos: "Requiere mejora"

   **Cargo Administrativo:**
   - 85-100 puntos: "Sobresaliente"
   - 70-84 puntos: "Destacado"
   - 55-69 puntos: "Satisfactorio"
   - Menos de 55 puntos: "Requiere mejora"

   **Cargo Gerencial:**
   - 80-100 puntos: "Sobresaliente"
   - 65-79 puntos: "Destacado"
   - 50-64 puntos: "Satisfactorio"
   - Menos de 50 puntos: "Requiere mejora"

   **Cargo Directivo:**
   - 80-100 puntos: "Sobresaliente"
   - 65-79 puntos: "Destacado"
   - 50-64 puntos: "Satisfactorio"
   - Menos de 50 puntos: "Requiere mejora"

   Nota: Los rangos son más exigentes para cargos de mayor responsabilidad

3. **Cálculo del Bono por Desempeño**

   El bono principal depende de la categoría de desempeño y el porcentaje de asistencia:

   **Categoría "Sobresaliente":**
   - Asistencia ≥ 98%: 25% del salario mensual
   - Asistencia 95-97%: 20% del salario mensual
   - Asistencia 90-94%: 15% del salario mensual
   - Asistencia < 90%: 10% del salario mensual

   **Categoría "Destacado":**
   - Asistencia ≥ 95%: 15% del salario mensual
   - Asistencia 90-94%: 12% del salario mensual
   - Asistencia < 90%: 8% del salario mensual

   **Categoría "Satisfactorio":**
   - Asistencia ≥ 95%: 8% del salario mensual
   - Asistencia ≥ 90%: 5% del salario mensual
   - Asistencia < 90%: 0% (sin bono)

   **Categoría "Requiere mejora":**
   - Sin bono (0%)

4. **Bono por Antigüedad**

   La empresa reconoce la lealtad de sus empleados con un bono adicional:

   - 1 a 3 años: 3% del salario mensual
   - 4 a 7 años: 6% del salario mensual
   - 8 a 12 años: 10% del salario mensual
   - Más de 12 años: 15% del salario mensual

5. **Bono por Proyectos Completados**

   Cada proyecto completado exitosamente recibe un bono. El valor varía según el cargo:

   **Cargo Operativo:**
   - $100,000 por proyecto
   - Máximo 5 proyectos contabilizados

   **Cargo Administrativo:**
   - $200,000 por proyecto
   - Máximo 8 proyectos contabilizados

   **Cargo Gerencial:**
   - $500,000 por proyecto
   - Máximo 10 proyectos contabilizados

   **Cargo Directivo:**
   - $1,000,000 por proyecto
   - Máximo 15 proyectos contabilizados

   Nota: Si un empleado completa más proyectos que el máximo, solo se pagan los permitidos

6. **Bonificación Extra por Características Especiales**

   La empresa ofrece bonificaciones adicionales por habilidades y responsabilidades:

   **Tiene certificaciones Y trabajo en equipo ≥ 4:**
   - 5% adicional del salario mensual

   **Lidera equipo Y categoría "Sobresaliente" o "Destacado":**
   - 8% adicional del salario mensual

   **Tiene certificaciones Y lidera equipo:**
   - 10% adicional del salario mensual
   - Esta bonificación reemplaza las dos anteriores (no se acumulan)

7. **Compensación Total Anual**

   La compensación total del empleado incluye:
   - Salario base mensual × 12 meses
   - Bono por desempeño
   - Bono por antigüedad
   - Bono por proyectos
   - Bonificaciones extra

8. **Evaluación para Ascenso**

   Los criterios de elegibilidad para ascenso varían según el cargo actual:

   **Cargo Operativo → Administrativo:**
   - Categoría "Sobresaliente" O "Destacado"
   - Y antigüedad ≥ 2 años
   - Y asistencia ≥ 90%

   **Cargo Administrativo → Gerencial:**
   - Categoría "Sobresaliente"
   - Y antigüedad ≥ 3 años
   - Y proyectos completados ≥ 5
   - Y trabajo en equipo ≥ 4

   **Cargo Gerencial → Directivo:**
   - Categoría "Sobresaliente"
   - Y antigüedad ≥ 4 años
   - Y lidera equipo
   - Y tiene certificaciones

   **Cargo Directivo:**
   - Ya está en el nivel máximo (no aplica ascenso)

9. **Plan de Mejora**

   Los empleados que no cumplen expectativas requieren planes de desarrollo:

   **Categoría "Requiere mejora":**
   - Si asistencia < 85%: "Plan de mejora - Asistencia y productividad"
   - Si productividad < 50%: "Plan de mejora - Productividad crítica"
   - Otro caso: "Plan de mejora - Capacitación"

   **Categoría "Satisfactorio" Y asistencia < 90%:**
   - "Seguimiento asistencia"

   **Otras categorías:**
   - "Sin plan de mejora"

---

## Conceptos Importantes para Entender el Problema

### ¿Qué es la Productividad?

La productividad mide qué tan bien un empleado cumple con sus responsabilidades:
- En cargos operativos: cantidad y calidad del trabajo técnico
- En cargos administrativos: eficiencia en procesos y coordinación
- En cargos gerenciales: resultados del equipo y cumplimiento de metas
- En cargos directivos: logros estratégicos y visión de largo plazo

Por eso los rangos de evaluación son más exigentes en cargos superiores.

### ¿Por qué la asistencia afecta el bono?

La asistencia es fundamental porque:
- Demuestra compromiso con la empresa
- Afecta la productividad del equipo
- Es un indicador de confiabilidad
- Impacta directamente los resultados

Incluso con excelente productividad, la baja asistencia reduce el bono.

### ¿Qué significa "Lidera equipo"?

Un empleado que lidera equipo tiene responsabilidades adicionales:
- Gestiona y motiva a otras personas
- Toma decisiones que afectan al grupo
- Es responsable de los resultados del equipo
- Requiere habilidades de liderazgo

Por eso recibe bonificación extra y tiene criterios diferentes para ascenso.

### ¿Por qué las certificaciones son importantes?

Las certificaciones profesionales demuestran:
- Conocimiento técnico validado
- Compromiso con el desarrollo profesional
- Actualización en tendencias de la industria
- Mayor valor aportado a la empresa

La empresa incentiva esto con bonificaciones adicionales.

### ¿Cómo funcionan los bonos acumulables?

La mayoría de bonos se SUMAN para calcular la compensación total:
- Bono desempeño + Bono antigüedad + Bono proyectos + Bonificaciones extra

EXCEPCIÓN: En bonificaciones extra, si tiene certificaciones Y lidera equipo, recibe solo el 10% (no suma el 5% + 8%).

---

## Ejemplos Resueltos

Para entender mejor cómo funciona el sistema, veamos varios casos reales:

### Ejemplo 1: Empleado Operativo con Buen Desempeño

**Datos del Empleado:**
- Nombre: Carlos Ramírez
- Cargo: Operativo
- Puntaje productividad: 88 puntos
- Asistencia: 96%
- Años de antigüedad: 5 años
- Salario base mensual: $2,500,000
- Proyectos completados: 4
- Calificación trabajo en equipo: 4 (escala 1-5)
- Tiene certificaciones: Sí
- Lidera equipo: No

**Evaluación Completa:**

**Paso 1 - Determinar categoría de desempeño (operativo con 88 puntos):**
- ¿90-100? NO
- ¿75-89? SÍ → Categoría: "Destacado"

**Paso 2 - Calcular bono por desempeño (Destacado con 96% asistencia):**
- Categoría: "Destacado"
- Asistencia: 96%
- ¿Asistencia ≥ 95%? SÍ → 15% del salario
- Bono desempeño: $2,500,000 × 0.15 = $375,000

**Paso 3 - Calcular bono por antigüedad (5 años):**
- ¿1-3 años? NO
- ¿4-7 años? SÍ → 6% del salario
- Bono antigüedad: $2,500,000 × 0.06 = $150,000

**Paso 4 - Calcular bono por proyectos (4 proyectos, cargo operativo):**
- Proyectos completados: 4
- Máximo permitido para operativo: 5
- Como 4 ≤ 5, se pagan todos
- Bono proyectos: 4 × $100,000 = $400,000

**Paso 5 - Calcular bonificaciones extra:**
- ¿Tiene certificaciones Y trabajo en equipo ≥ 4? SÍ (cert: Sí, equipo: 4) → 5%
- ¿Lidera equipo Y categoría Sobresaliente/Destacado? NO (no lidera)
- ¿Tiene certificaciones Y lidera equipo? NO (no lidera)
- Bonificación aplicable: 5%
- Bonificación extra: $2,500,000 × 0.05 = $125,000

**Paso 6 - Calcular compensación total:**
- Salario anual: $2,500,000 × 12 = $30,000,000
- Bono desempeño: $375,000
- Bono antigüedad: $150,000
- Bono proyectos: $400,000
- Bonificación extra: $125,000
- **Compensación total: $30,000,000 + $375,000 + $150,000 + $400,000 + $125,000 = $31,050,000**

**Paso 7 - Evaluar elegibilidad para ascenso (Operativo → Administrativo):**
- ¿Categoría Sobresaliente o Destacado? SÍ (Destacado)
- ¿Antigüedad ≥ 2 años? SÍ (5 años)
- ¿Asistencia ≥ 90%? SÍ (96%)
- **Elegible para ascenso: SÍ**

**Paso 8 - Determinar plan de mejora:**
- Categoría: "Destacado" (no es "Requiere mejora" ni "Satisfactorio con baja asistencia")
- **Plan de mejora: "Sin plan de mejora"**

**Resultado Final:**
- Categoría de desempeño: Destacado
- Bono desempeño: $375,000
- Bono antigüedad: $150,000
- Bono proyectos: $400,000
- Bonificación extra: $125,000
- **Compensación total anual: $31,050,000**
- Elegible para ascenso: SÍ
- Plan de mejora: Sin plan de mejora

---

### Ejemplo 2: Gerente con Liderazgo y Múltiples Bonificaciones

**Datos del Empleado:**
- Nombre: Andrea Martínez
- Cargo: Gerencial
- Puntaje productividad: 92 puntos
- Asistencia: 99%
- Años de antigüedad: 9 años
- Salario base mensual: $8,000,000
- Proyectos completados: 12
- Calificación trabajo en equipo: 5
- Tiene certificaciones: Sí
- Lidera equipo: Sí

**Análisis Detallado:**

**Paso 1 - Determinar categoría (gerencial con 92 puntos):**
- ¿80-100? SÍ → Categoría: "Sobresaliente"

**Paso 2 - Calcular bono desempeño (Sobresaliente con 99% asistencia):**
- ¿Asistencia ≥ 98%? SÍ → 25%
- Bono: $8,000,000 × 0.25 = $2,000,000

**Paso 3 - Bono antigüedad (9 años):**
- ¿8-12 años? SÍ → 10%
- Bono: $8,000,000 × 0.10 = $800,000

**Paso 4 - Bono proyectos (12 proyectos, gerencial):**
- Proyectos completados: 12
- Máximo para gerencial: 10
- Se pagan solo 10 proyectos
- Bono: 10 × $500,000 = $5,000,000

**Paso 5 - Bonificaciones extra:**
- ¿Tiene certificaciones Y trabajo en equipo ≥ 4? SÍ
- ¿Lidera equipo Y categoría Sobresaliente/Destacado? SÍ
- ¿Tiene certificaciones Y lidera equipo? SÍ → **Esta es la bonificación aplicable: 10%**
- (Las otras dos no se suman, esta las reemplaza)
- Bonificación: $8,000,000 × 0.10 = $800,000

**Paso 6 - Compensación total:**
- Salario anual: $8,000,000 × 12 = $96,000,000
- Bono desempeño: $2,000,000
- Bono antigüedad: $800,000
- Bono proyectos: $5,000,000
- Bonificación extra: $800,000
- **Total: $96,000,000 + $2,000,000 + $800,000 + $5,000,000 + $800,000 = $104,600,000**

**Paso 7 - Evaluar ascenso (Gerencial → Directivo):**
- ¿Categoría Sobresaliente? SÍ
- ¿Antigüedad ≥ 4 años? SÍ (9 años)
- ¿Lidera equipo? SÍ
- ¿Tiene certificaciones? SÍ
- **Elegible para ascenso: SÍ**

**Paso 8 - Plan de mejora:**
- **"Sin plan de mejora"**

**Resultado Final:**
- Categoría: Sobresaliente
- Bonos totales: $8,600,000
- **Compensación total: $104,600,000**
- Elegible para ascenso a Directivo: SÍ
- Plan de mejora: Sin plan de mejora

**Nota importante:** Aunque completó 12 proyectos, solo se pagaron 10 (el máximo para gerentes).

---

### Ejemplo 3: Empleado Administrativo que Requiere Mejora

**Datos del Empleado:**
- Nombre: Luis Torres
- Cargo: Administrativo
- Puntaje productividad: 48 puntos
- Asistencia: 82%
- Años de antigüedad: 2 años
- Salario base mensual: $3,500,000
- Proyectos completados: 2
- Calificación trabajo en equipo: 2
- Tiene certificaciones: No
- Lidera equipo: No

**Evaluación Paso a Paso:**

**Paso 1 - Categoría (administrativo con 48 puntos):**
- ¿85-100? NO
- ¿70-84? NO
- ¿55-69? NO
- ¿Menos de 55? SÍ → Categoría: "Requiere mejora"

**Paso 2 - Bono desempeño:**
- Categoría "Requiere mejora" → Sin bono
- Bono desempeño: $0

**Paso 3 - Bono antigüedad (2 años):**
- ¿1-3 años? SÍ → 3%
- Bono: $3,500,000 × 0.03 = $105,000

**Paso 4 - Bono proyectos (2 proyectos, administrativo):**
- Proyectos: 2
- Máximo administrativo: 8
- Bono: 2 × $200,000 = $400,000

**Paso 5 - Bonificaciones extra:**
- ¿Certificaciones Y trabajo ≥ 4? NO (no tiene certificaciones, y equipo es 2)
- ¿Lidera Y Sobresaliente/Destacado? NO (no lidera, y es "Requiere mejora")
- ¿Certificaciones Y lidera? NO
- Bonificación extra: $0

**Paso 6 - Compensación total:**
- Salario anual: $3,500,000 × 12 = $42,000,000
- Bono desempeño: $0
- Bono antigüedad: $105,000
- Bono proyectos: $400,000
- Bonificación extra: $0
- **Total: $42,000,000 + $0 + $105,000 + $400,000 + $0 = $42,505,000**

**Paso 7 - Evaluar ascenso:**
- Categoría: "Requiere mejora" (no es Sobresaliente ni Destacado)
- **Elegible para ascenso: NO**

**Paso 8 - Plan de mejora (categoría "Requiere mejora"):**
- ¿Asistencia < 85%? SÍ (82%) → **"Plan de mejora - Asistencia y productividad"**

**Resultado Final:**
- Categoría: Requiere mejora
- Compensación total: $42,505,000 (solo salario + antigüedad + proyectos)
- Elegible para ascenso: NO
- Plan de mejora: Plan de mejora - Asistencia y productividad

**Observación:** Luis tiene serios problemas de productividad y asistencia. Necesita mejorar urgentemente o podría enfrentar consecuencias laborales.

---

### Ejemplo 4: Director con Máxima Antigüedad

**Datos del Empleado:**
- Nombre: Patricia Gómez
- Cargo: Directivo
- Puntaje productividad: 85 puntos
- Asistencia: 94%
- Años de antigüedad: 15 años
- Salario base mensual: $15,000,000
- Proyectos completados: 18
- Calificación trabajo en equipo: 5
- Tiene certificaciones: Sí
- Lidera equipo: Sí

**Cálculo Completo:**

**Paso 1 - Categoría (directivo con 85 puntos):**
- ¿80-100? SÍ → Categoría: "Sobresaliente"

**Paso 2 - Bono desempeño (Sobresaliente, 94% asistencia):**
- Asistencia: 94%
- ¿≥ 98%? NO
- ¿95-97%? NO
- ¿90-94%? SÍ → 15%
- Bono: $15,000,000 × 0.15 = $2,250,000

**Paso 3 - Bono antigüedad (15 años):**
- ¿Más de 12 años? SÍ → 15%
- Bono: $15,000,000 × 0.15 = $2,250,000

**Paso 4 - Bono proyectos (18 proyectos, directivo):**
- Proyectos completados: 18
- Máximo directivo: 15
- Se pagan 15 proyectos
- Bono: 15 × $1,000,000 = $15,000,000

**Paso 5 - Bonificaciones extra:**
- ¿Certificaciones Y lidera equipo? SÍ → 10%
- Bonificación: $15,000,000 × 0.10 = $1,500,000

**Paso 6 - Compensación total:**
- Salario anual: $15,000,000 × 12 = $180,000,000
- Bono desempeño: $2,250,000
- Bono antigüedad: $2,250,000
- Bono proyectos: $15,000,000
- Bonificación extra: $1,500,000
- **Total: $180,000,000 + $2,250,000 + $2,250,000 + $15,000,000 + $1,500,000 = $201,000,000**

**Paso 7 - Evaluar ascenso:**
- Cargo: Directivo (nivel máximo)
- **No aplica ascenso**

**Paso 8 - Plan de mejora:**
- **"Sin plan de mejora"**

**Resultado Final:**
- Categoría: Sobresaliente
- Compensación total: $201,000,000
- Elegible para ascenso: No aplica (ya está en nivel máximo)
- Plan de mejora: Sin plan de mejora

**Observación:** Patricia es una ejecutiva senior muy valiosa para la empresa, con compensación acorde a su experiencia y resultados.

---

## Escenarios de Práctica para Resolver

### Escenario 1: Comparación entre empleados del mismo cargo

**Empleado A - María Silva:**
- Cargo: Administrativo
- Productividad: 78, Asistencia: 97%
- Antigüedad: 6 años, Salario: $4,000,000
- Proyectos: 7, Trabajo equipo: 5
- Certificaciones: Sí, Lidera: No

**Empleado B - Jorge Díaz:**
- Cargo: Administrativo
- Productividad: 86, Asistencia: 88%
- Antigüedad: 3 años, Salario: $4,000,000
- Proyectos: 6, Trabajo equipo: 3
- Certificaciones: No, Lidera: No

**Preguntas:**
- ¿Cuál tiene mejor categoría de desempeño?
- ¿Quién recibe mayor bono por desempeño y por qué?
- ¿Quién tiene mayor compensación total?
- ¿Quién es elegible para ascenso?

### Escenario 2: Empleado con proyectos excedentes

**Empleado: Roberto Vargas**
- Cargo: Gerencial
- Productividad: 76, Asistencia: 95%
- Antigüedad: 10 años, Salario: $7,000,000
- Proyectos completados: 14
- Trabajo equipo: 4, Certificaciones: Sí, Lidera: Sí

**Preguntas:**
- ¿Cuál es su categoría de desempeño?
- ¿Cuántos proyectos se le pagan? ¿Por qué?
- ¿Cuál es su compensación total?
- ¿Es elegible para ascenso a directivo?

### Escenario 3: Empleado operativo destacado

**Empleado: Carolina Ruiz**
- Cargo: Operativo
- Productividad: 95, Asistencia: 98%
- Antigüedad: 3 años, Salario: $2,800,000
- Proyectos: 5, Trabajo equipo: 5
- Certificaciones: Sí, Lidera: No

**Preguntas:**
- ¿Cuál es su categoría de desempeño?
- Calcule todos sus bonos y bonificaciones
- ¿Cuál es su compensación total?
- ¿Es elegible para ascenso?
- ¿Qué pasaría con su compensación si tuviera solo 90% de asistencia?

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto del negocio y los ejemplos proporcionados, identifique:

a) **Atributos necesarios** para la clase `EvaluacionEmpleado` (mínimo 10 atributos)
   - Datos personales del empleado
   - Métricas de desempeño
   - Información laboral
   - Habilidades y responsabilidades

b) **Métodos necesarios** para implementar todas las operaciones descritas (mínimo 9 métodos)
   - Determinación de categoría
   - Cálculo de cada tipo de bono
   - Cálculo de compensación total
   - Evaluación de ascenso
   - Determinación de plan de mejora
   - Generación de reporte

---

### 2. Diagrama de Clases

A continuación se presenta el diagrama de clases que debe implementar. **Su tarea es llenar la lógica de cada uno de los métodos** siguiendo las reglas de negocio descritas en este documento.

```
┌─────────────────────────────────────────────────────────┐
│              EvaluacionEmpleado                         │
├─────────────────────────────────────────────────────────┤
│ - nombre: String                                        │
│ - cargo: String                                         │
│ - puntajeProductividad: int                             │
│ - porcentajeAsistencia: double                          │
│ - aniosAntiguedad: int                                  │
│ - salarioBaseMensual: double                            │
│ - proyectosCompletados: int                             │
│ - calificacionTrabajoEquipo: int                        │
│ - tieneCertificaciones: boolean                         │
│ - lideraEquipo: boolean                                 │
├─────────────────────────────────────────────────────────┤
│ + EvaluacionEmpleado(nombre, cargo,                    │
│                       puntajeProductividad, asistencia, │
│                       antiguedad, salario, proyectos,   │
│                       trabajoEquipo, certificaciones,   │
│                       lidera)                           │
│ + determinarCategoriaDesempeño(): String                │
│ + calcularBonoDesempeño(): double                       │
│ + calcularBonoAntiguedad(): double                      │
│ + calcularBonoProyectos(): double                       │
│ + calcularBonificacionExtra(): double                   │
│ + calcularCompensacionTotal(): double                   │
│ + evaluarElegibilidadAscenso(): boolean                 │
│ + determinarPlanMejora(): String                        │
│ + generarReporteCompleto(): void                        │
└─────────────────────────────────────────────────────────┘
```

**Descripción de los métodos que debe implementar:**

1. **determinarCategoriaDesempeño()**: Determina la categoría según cargo y productividad
   - Usa switch-case para el cargo
   - Aplica rangos diferentes de productividad para cada cargo
   - Retorna: "Sobresaliente", "Destacado", "Satisfactorio" o "Requiere mejora"

2. **calcularBonoDesempeño()**: Calcula bono según categoría y asistencia
   - Primero determina la categoría de desempeño
   - Usa decisiones anidadas: categoría → asistencia
   - Aplica el porcentaje correspondiente al salario mensual
   - Retorna el monto del bono

3. **calcularBonoAntiguedad()**: Calcula bono según años de antigüedad
   - Aplica porcentajes según rangos de años
   - Retorna el monto del bono

4. **calcularBonoProyectos()**: Calcula bono por proyectos completados
   - Determina máximo de proyectos según cargo
   - Toma el menor entre completados y máximo
   - Multiplica por valor según cargo
   - Retorna el monto del bono

5. **calcularBonificacionExtra()**: Calcula bonificación por habilidades especiales
   - IMPORTANTE: Si tiene certificaciones Y lidera, solo aplica 10% (no suma otras)
   - Si no cumple ambas, verifica las otras condiciones por separado
   - Retorna el monto de la bonificación

6. **calcularCompensacionTotal()**: Calcula la compensación anual total
   - Suma: salario anual + todos los bonos y bonificaciones
   - Retorna la compensación total

7. **evaluarElegibilidadAscenso()**: Determina si califica para ascenso
   - Usa decisiones según el cargo actual
   - Aplica criterios específicos para cada nivel
   - Directivo retorna false (nivel máximo)
   - Retorna true o false

8. **determinarPlanMejora()**: Determina el plan de desarrollo requerido
   - Verifica categoría de desempeño
   - Evalúa asistencia y productividad para casos especiales
   - Retorna el plan correspondiente

9. **generarReporteCompleto()**: Imprime reporte completo de evaluación
   - Muestra todas las métricas, bonos, compensación, ascenso y plan

---

### 3. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

a) **Método determinarCategoriaDesempeño()**
   - Primero debe identificar el cargo
   - Según el cargo, aplicar rangos diferentes de productividad
   - Retornar la categoría correspondiente
   - Usar switch-case para el cargo

b) **Método calcularBonoDesempeño()**
   - Primero determinar la categoría de desempeño
   - Según la categoría, evaluar el porcentaje de asistencia
   - Aplicar el porcentaje correspondiente al salario
   - Retornar el monto del bono
   - Requiere decisiones anidadas (categoría → asistencia)

c) **Método calcularBonoProyectos()**
   - Determinar el máximo de proyectos según el cargo
   - Tomar el menor entre proyectos completados y el máximo
   - Calcular el valor por proyecto según el cargo
   - Multiplicar y retornar el bono total

d) **Método calcularBonificacionExtra()**
   - Verificar las tres condiciones posibles
   - IMPORTANTE: Si cumple certificaciones Y lidera, solo aplicar el 10%
   - Si no, verificar las otras dos condiciones por separado
   - Calcular y retornar el monto de la bonificación

e) **Método evaluarElegibilidadAscenso()**
   - Determinar el cargo actual
   - Según el cargo, aplicar criterios específicos
   - Si es directivo, retornar false (no aplica)
   - Retornar true o false según cumplimiento de criterios
   - Usar decisiones anidadas

f) **Método determinarPlanMejora()**
   - Verificar si categoría es "Requiere mejora"
   - Si sí, evaluar asistencia y productividad para tipo de plan
   - Si no, verificar si es "Satisfactorio" con baja asistencia
   - Retornar el plan correspondiente

### 4. Implementación en Java

**Instrucciones:** Implemente la clase completa `EvaluacionEmpleado` en Java con:

- Todos los atributos identificados
- Constructor que inicialice todos los datos del empleado
- Todos los métodos identificados con su lógica completa
- Un método `generarReporteCompleto()` que imprima:
  - Información del empleado (nombre, cargo)
  - Métricas de desempeño (productividad, asistencia, antigüedad)
  - Categoría de desempeño
  - Desglose de bonos:
    - Bono por desempeño
    - Bono por antigüedad
    - Bono por proyectos
    - Bonificación extra
  - Compensación total anual
  - Elegibilidad para ascenso
  - Plan de mejora (si aplica)

**Consideraciones importantes:**
- Use solo estructuras de decisión (if, else if, else, switch)
- NO use arreglos, listas o colecciones
- Todos los cálculos deben estar en una sola clase
- Use tipos de datos apropiados:
  - `String` para nombre, cargo, categorías, planes
  - `double` para salario, bonos, porcentajes
  - `int` para productividad, años, proyectos, calificación equipo
  - `boolean` para certificaciones y lidera equipo
- Use switch-case para decisiones basadas en cargo
- Las bonificaciones extra NO siempre se acumulan (certificaciones Y lidera reemplaza las otras)
- Preste atención a los límites de proyectos según el cargo
- Los rangos de productividad son diferentes para cada cargo

### 5. Método Main de Prueba

Cree un método main que pruebe su clase con al menos 5 empleados diferentes:
- Un empleado operativo con buen desempeño
- Un empleado administrativo que requiere mejora
- Un gerente con liderazgo y certificaciones
- Un director senior
- Un empleado en el límite de categorías (para probar los rangos)

Para cada empleado, llame al método `generarReporteCompleto()`.

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
   - Uso apropiado de decisiones anidadas multinivel
   - Manejo correcto de condiciones excluyentes (bonificaciones extra)
   - Uso de switch-case donde sea apropiado
   - Claridad y organización

4. **Implementación en Java** (35%)
   - Sintaxis correcta
   - Lógica completa y funcional
   - Manejo adecuado de todas las reglas del negocio
   - Correcta implementación de rangos según cargo
   - Aplicación correcta de límites de proyectos
   - Lógica correcta para bonificaciones extra (no acumulables completamente)
   - Decisiones anidadas bien implementadas

5. **Método main y pruebas** (5%)
   - Casos de prueba representativos
   - Cobertura de diferentes cargos y escenarios

---

## Notas Finales

- Este ejercicio está diseñado para practicar decisiones múltiples anidadas en varios niveles
- La determinación de categoría requiere primero identificar el cargo, luego aplicar rangos específicos
- El cálculo de bono por desempeño requiere decisiones doblemente anidadas: categoría → asistencia
- Las bonificaciones extra tienen una regla especial: certificaciones Y lidera NO se suma con las otras
- Los límites de proyectos varían según el cargo - use switch-case para esto
- Los criterios de ascenso son completamente diferentes para cada nivel - use decisiones anidadas
- Preste atención al orden de evaluación en bonificaciones extra
- Use switch-case para el cargo en múltiples métodos
- Recuerde que "Requiere mejora" tiene subclasificaciones según asistencia y productividad
- Un empleado puede tener buena antigüedad y proyectos pero mal desempeño - cada bono es independiente
- Use comentarios para explicar las decisiones anidadas complejas
- El cargo directivo no tiene ascenso posible (ya está en el máximo nivel)
