# 📚 Sistema de Gestión Académica de Estudiantes

## 🎯 Objetivos del Ejercicio

1. **Implementar múltiples clases relacionadas** mediante composición (Estudiante tiene Asignaturas, Asignaturas tienen Notas)
2. **Aplicar estructuras de control** (decisiones y ciclos) para resolver problemas de cálculo académico
3. **Trabajar con arreglos** para almacenar y procesar colecciones de objetos
4. **Desarrollar lógica de negocio** con reglas académicas realistas y validaciones

## 📖 Contexto del Negocio

La universidad **"Excelencia Académica"** necesita un sistema para administrar el rendimiento académico de sus estudiantes. El sistema debe permitir registrar las calificaciones de diferentes asignaturas, calcular promedios, identificar fortalezas y debilidades académicas, y determinar el estado de aprobación de cada materia.

Cuando un estudiante se matricula en un semestre, debe cursar varias asignaturas. Cada asignatura tiene diferentes componentes de evaluación (parciales, talleres, quices, proyecto final, etc.), cada uno con un porcentaje que define cuánto vale en la nota final de esa materia. Al final del semestre, el estudiante debe saber cuántas materias aprobó, cuántas reprobó, cuál es su promedio general y cuál es su mejor asignatura.

## 📋 Reglas de Negocio

### 1. Estructura Académica

- Cada **estudiante** tiene un nombre completo, un código único y está cursando un determinado semestre
- Un estudiante puede cursar **hasta 8 asignaturas** por semestre
- Cada **asignatura** tiene un nombre y puede tener **hasta 10 notas**
- Cada **nota** tiene tres componentes:
  - **Nombre**: Identifica el tipo de evaluación (ej: "Parcial 1", "Taller 2")
  - **Valor**: La calificación obtenida (escala de 0.0 a 5.0)
  - **Porcentaje**: Cuánto vale esa nota en la nota final (ej: 30%)
- La suma de todos los porcentajes de las notas de una asignatura **DEBE ser exactamente 100%**

### 2. Cálculo de Nota Final de una Asignatura

La nota final se calcula como **promedio ponderado**:

```
Nota Final = (nota1 × porcentaje1/100) + (nota2 × porcentaje2/100) + ... + (notaN × porcentajeN/100)
```

**Ejemplo:**
- Parcial 1: 4.0 (vale 30%)
- Taller: 3.5 (vale 20%)
- Examen Final: 4.5 (vale 50%)
- **Nota final** = (4.0 × 0.30) + (3.5 × 0.20) + (4.5 × 0.50) = 1.2 + 0.7 + 2.25 = **4.15**

### 3. Estado de Aprobación de una Asignatura

- **Aprobada con Excelencia**: Nota final ≥ 4.5
- **Aprobada**: Nota final entre 3.0 y 4.49
- **Reprobada**: Nota final < 3.0

### 4. Promedio General del Estudiante

El promedio general es el **promedio aritmético simple** de todas las notas finales:

```
Promedio = (notaFinal1 + notaFinal2 + ... + notaFinalN) / número de asignaturas
```

### 5. Clasificación del Rendimiento Académico

- **Excelente**: Promedio ≥ 4.5
- **Bueno**: Promedio entre 4.0 y 4.49
- **Aceptable**: Promedio entre 3.5 y 3.99
- **Regular**: Promedio entre 3.0 y 3.49
- **Deficiente**: Promedio < 3.0

### 6. Estado Académico del Estudiante

Basándose en el número de materias reprobadas:
- **Regular**: No reprobó ninguna materia
- **Advertencia**: Reprobó entre 1 y la mitad de las materias
- **Prueba Académica**: Reprobó más de la mitad de las materias

## 🏗️ Estructura del Proyecto

```
starter-gestion-academica/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── edu/eam/ingesoft/fundamentos/gestionacademica/
│   │       │   ├── logica/
│   │       │   │   ├── Nota.java            ← Clase COMPLETA
│   │       │   │   ├── Asignatura.java      ← Métodos VACÍOS (implementar)
│   │       │   │   └── Estudiante.java      ← Métodos VACÍOS (implementar)
│   │       │   └── gui/
│   │       │       └── EstudianteGUI.java   ← Interfaz gráfica funcional
│   │       └── org/example/
│   │           └── Main.java                ← Casos de ejemplo
│   └── test/
│       └── java/
│           └── edu/eam/ingesoft/fundamentos/gestionacademica/
│               └── EstudianteTest.java      ← Tests completos
├── pom.xml
└── README.md
```

## 📝 Tareas a Realizar

### 1️⃣ Implementar la clase `Asignatura`

Completa los siguientes métodos (actualmente vacíos):

- `agregarNota(Nota nota)`: Agregar una nota validando límites y rangos
- `validarPorcentajes()`: Verificar que los porcentajes sumen 100%
- `calcularNotaFinal()`: Calcular el promedio ponderado
- `determinarEstado()`: Determinar si está aprobada, aprobada con excelencia o reprobada
- `estaAprobada()`: Verificar si la nota final es >= 3.0

### 2️⃣ Implementar la clase `Estudiante`

Completa los siguientes métodos (actualmente vacíos):

- `agregarAsignatura(Asignatura)`: Agregar asignatura validando límites
- `calcularPromedioGeneral()`: Calcular promedio aritmético de todas las notas finales
- `clasificarRendimiento()`: Clasificar según el promedio (Excelente, Bueno, etc.)
- `contarAprobadas()`: Contar asignaturas con nota >= 3.0
- `contarReprobadas()`: Contar asignaturas con nota < 3.0
- `determinarEstadoAcademico()`: Determinar estado (Regular, Advertencia, Prueba Académica)
- `obtenerMejorAsignatura()`: Encontrar asignatura con nota final más alta
- `obtenerPeorAsignatura()`: Encontrar asignatura con nota final más baja
- `obtenerMejorNotaIndividual()`: Encontrar la calificación más alta de todas las evaluaciones
- `obtenerPeorNotaIndividual()`: Encontrar la calificación más baja de todas las evaluaciones
- `mostrarReporteCompleto()`: Generar reporte formateado con toda la información

### 3️⃣ Validaciones Importantes

Tu implementación debe:
- ✅ Validar que las notas estén entre 0.0 y 5.0
- ✅ Validar que los porcentajes sumen exactamente 100%
- ✅ No permitir más de 10 notas por asignatura
- ✅ No permitir más de 8 asignaturas por estudiante
- ✅ Manejar casos especiales (estudiante sin asignaturas, asignatura sin notas)

## 🚀 Comandos para Ejecutar

### Compilar el proyecto
```bash
mvn clean compile
```

### Ejecutar las pruebas unitarias
```bash
mvn test
```

### Ejecutar la GUI
```bash
mvn clean compile exec:java -Dexec.mainClass="edu.eam.ingesoft.fundamentos.gestionacademica.gui.EstudianteGUI"
```

### Ejecutar el programa de consola
```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.Main"
```

## ✅ Criterios de Éxito

Tu implementación será exitosa cuando:

1. ✅ **Todos los tests pasen al 100%** (`mvn test` debe mostrar todos los tests en verde)
2. ✅ **El programa Main muestre los resultados esperados** (ver `Main.java`)
3. ✅ **La GUI funcione correctamente** sin errores al agregar estudiantes, asignaturas y notas
4. ✅ **Los cálculos sean precisos** según las reglas académicas definidas
5. ✅ **Las validaciones funcionen** correctamente en todos los métodos

## 📊 Ejemplo de Caso de Prueba

**María González** (Código: 202315001, Semestre: 2)

| Asignatura | Evaluaciones | Nota Final | Estado |
|------------|-------------|------------|---------|
| Cálculo I | Parcial 1: 3.2 (30%), Parcial 2: 3.5 (30%), Final: 3.8 (40%) | **3.53** | Aprobada |
| Física I | Quiz 1: 4.0 (10%), Quiz 2: 4.5 (10%), Lab: 4.2 (20%), Parcial: 4.3 (30%), Final: 4.4 (30%) | **4.30** | Aprobada |
| Programación I | Talleres: 2.8 (20%), Parcial: 2.5 (30%), Proyecto: 3.2 (50%) | **2.91** | Reprobada |
| Inglés I | Oral: 4.5 (25%), Escrito: 4.8 (25%), Parcial: 4.6 (30%), Final: 4.7 (20%) | **4.65** | Aprobada con Excelencia |

**Resultados esperados:**
- **Promedio General**: 3.85
- **Clasificación**: Aceptable
- **Aprobadas**: 3 | **Reprobadas**: 1
- **Estado Académico**: Advertencia
- **Mejor Asignatura**: Inglés I (4.65)
- **Peor Asignatura**: Programación I (2.91)
- **Mejor Nota Individual**: 4.8
- **Peor Nota Individual**: 2.5

## 🎓 Pasos para Comenzar

1. **Lee el código existente**: Examina las clases `Nota`, `Asignatura` y `Estudiante`
2. **Revisa los tests**: En `EstudianteTest.java` puedes ver qué se espera de cada método
3. **Empieza por `Asignatura`**: Implementa los métodos básicos primero
4. **Continúa con `Estudiante`**: Usa los métodos de `Asignatura` que ya implementaste
5. **Ejecuta los tests frecuentemente**: `mvn test` te dirá qué métodos ya funcionan
6. **Prueba con la GUI**: Verifica que todo funciona correctamente con la interfaz gráfica

## 💡 Pistas para la Implementación

### Para calcular la nota final de una asignatura:
```
1. Validar que los porcentajes sumen 100%
2. Inicializar notaFinal = 0.0
3. Para cada nota en el arreglo (hasta cantidadNotas):
   - notaFinal += nota.getValor() * (nota.getPorcentaje() / 100.0)
4. Retornar notaFinal
```

### Para determinar el estado académico:
```
1. Contar cuántas materias reprobó
2. Si reprobadas == 0: return "Regular"
3. Si reprobadas > (total / 2): return "Prueba Académica"
4. Si no: return "Advertencia"
```

## 🛠️ Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación
- **Maven**: Gestión de dependencias y construcción
- **JUnit 5**: Framework de testing
- **Swing**: Interfaz gráfica de usuario

## 📚 Recursos Adicionales

- [Documentación de Java](https://docs.oracle.com/en/java/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

---

**¡Buena suerte con tu implementación!** 🚀

Si tienes dudas sobre las reglas de negocio, revisa los ejemplos en el código de `Main.java` y los tests en `EstudianteTest.java`.
