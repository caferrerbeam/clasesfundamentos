# 📚 Ejercicios de Preparación - Examen 2

## Decisiones Múltiples Anidadas y Clases en Java

Este paquete contiene **3 ejercicios completos** diseñados para preparar a los estudiantes para el examen sobre decisiones y clases en Java.

---

## 📁 Estructura del Paquete

```
ejercicioexamen2/
├── index.html                          # Página principal de navegación
├── README.md                           # Este archivo
│
├── ejercicio1-salud/
│   ├── enunciado.md                   # Enunciado completo en Markdown
│   └── index.html                     # Página web interactiva
│
├── ejercicio2-taxi/
│   ├── enunciado.md                   # Enunciado completo en Markdown
│   └── index.html                     # Página web interactiva
│
└── ejercicio3-empleado/
    ├── enunciado.md                   # Enunciado completo en Markdown
    └── index.html                     # Página web interactiva
```

---

## 🎯 Ejercicios Incluidos

### 🏥 Ejercicio 1: Sistema de Evaluación de Salud
**Clase:** `EvaluacionSalud`

**Descripción:** Centro médico que calcula el IMC, evalúa el riesgo cardiovascular y genera un puntaje de salud según múltiples factores del paciente.

**Conceptos a practicar:**
- Rangos diferentes por género (IMC distinto para hombres y mujeres)
- Decisiones anidadas por grupos de edad (<30, 30-50, >50)
- Condiciones compuestas (múltiples factores)
- Acumulación de puntos para puntaje de salud

**Métodos a implementar:** 8
- calcularIMC()
- clasificarPeso()
- evaluarRiesgoCardiovascular()
- generarRecomendacion()
- requiereConsultaMedica()
- calcularPuntuacionSalud()
- clasificarSalud()
- mostrarReporteSalud()

---

### 🚕 Ejercicio 2: Sistema de Tarifas de Taxi Premium
**Clase:** `ViajeEnTaxi`

**Descripción:** Empresa de transporte que calcula el costo de viajes considerando tipo de servicio, horarios, zonas especiales y descuentos acumulables.

**Conceptos a practicar:**
- Decisiones anidadas día → hora para recargos
- Switch-case para días de la semana
- Cargos acumulables por zonas
- Descuentos acumulables
- Orden de cálculo: base → recargos → cargos → descuentos

**Métodos a implementar:** 8
- calcularTarifaBase()
- calcularRecargoHorario()
- calcularCargosAdicionales()
- calcularDescuentos()
- esHoraPico()
- calcularCostoTotal()
- determinarTipoViaje()
- generarResumenViaje()

---

### 💼 Ejercicio 3: Sistema de Evaluación Integral de Empleados
**Clase:** `EvaluacionEmpleado`

**Descripción:** Empresa que evalúa el desempeño de empleados calculando bonos, compensación total y elegibilidad para ascenso según 4 niveles de cargo.

**Conceptos a practicar:**
- Switch-case para manejar diferentes cargos
- Decisiones anidadas categoría → asistencia
- Bonificaciones con reglas excluyentes (no siempre acumulables)
- Límites diferentes por categoría (máximo de proyectos)
- Rangos diferentes por cargo (productividad)

**Métodos a implementar:** 9
- determinarCategoriaDesempeño()
- calcularBonoDesempeño()
- calcularBonoAntiguedad()
- calcularBonoProyectos()
- calcularBonificacionExtra()
- calcularCompensacionTotal()
- evaluarElegibilidadAscenso()
- determinarPlanMejora()
- generarReporteCompleto()

---

## 🚀 Cómo Usar Este Paquete

### Opción 1: Navegación Web (Recomendado)
1. Abra el archivo `index.html` en su navegador
2. Navegue entre los ejercicios usando los botones
3. Cada ejercicio tiene una página interactiva con:
   - Contexto del negocio
   - Diagrama de clases (Mermaid)
   - Reglas principales
   - Descripción de métodos
   - Notas importantes

### Opción 2: Lectura de Enunciados
1. Navegue a la carpeta del ejercicio deseado
2. Abra el archivo `enunciado.md`
3. Encontrará:
   - Contexto completo
   - Reglas del negocio detalladas
   - Ejemplos resueltos paso a paso
   - Escenarios de práctica
   - Actividades a desarrollar
   - Criterios de evaluación

---

## 📋 Instrucciones para Estudiantes

### Para cada ejercicio debe:

1. **Identificar Atributos y Métodos**
   - Lea el enunciado completo
   - Identifique los atributos necesarios
   - Liste los métodos requeridos

2. **Diseñar Diagramas de Flujo**
   - Cree diagramas para los métodos principales
   - Represente correctamente las decisiones anidadas
   - Use switch-case donde sea apropiado

3. **Implementar la Clase en Java**
   - Declare todos los atributos con tipos apropiados
   - Implemente el constructor
   - Complete la lógica de cada método
   - Siga las reglas de negocio exactamente

4. **Probar con Método Main**
   - Cree casos de prueba variados
   - Compare con los ejemplos resueltos
   - Verifique todos los escenarios

---

## ⚙️ Requisitos Técnicos

- **Lenguaje:** Java
- **Estructuras permitidas:** if, else if, else, switch-case
- **Estructuras NO permitidas:** arreglos, listas, colecciones
- **Paradigma:** Una sola clase por ejercicio
- **Tipos de datos:** double, int, String, boolean

---

## 🎯 Objetivos de Aprendizaje

Al completar estos ejercicios, los estudiantes serán capaces de:

✅ Implementar decisiones simples y múltiples
✅ Utilizar decisiones anidadas en múltiples niveles
✅ Aplicar switch-case apropiadamente
✅ Identificar atributos necesarios para una clase
✅ Implementar métodos con lógica de negocio compleja
✅ Manejar cálculos con porcentajes y acumulaciones
✅ Trabajar con condiciones compuestas
✅ Aplicar reglas de negocio del mundo real

---

## 📝 Criterios de Evaluación

Cada ejercicio se evalúa según:

1. **Identificación de atributos** (15%)
2. **Identificación de métodos** (15%)
3. **Diagramas de flujo** (30%)
4. **Implementación en Java** (35%)
5. **Pruebas** (5%)

---

## 💡 Recomendaciones

- ⚠️ Lea **todo el enunciado** antes de programar
- 📊 Diseñe los **diagramas de flujo** primero
- 🧪 Pruebe cada método con los **ejemplos resueltos**
- 💬 Use **comentarios** para explicar decisiones complejas
- 🔍 Preste atención a **decisiones anidadas** y su orden
- ✅ Verifique los **tipos de datos** apropiados
- 📐 Siga el **orden de cálculo** especificado

---

## 📞 Soporte

Si tiene dudas sobre los ejercicios:
- Consulte los ejemplos resueltos en cada enunciado
- Revise las notas importantes al final de cada ejercicio
- Verifique que está siguiendo exactamente las reglas de negocio

---

## 📄 Licencia

Material educativo para uso exclusivo de estudiantes de Fundamentos de Programación - EAM Universidad 2025-2

---

**¡Buena suerte con tu preparación para el examen!** 🚀
