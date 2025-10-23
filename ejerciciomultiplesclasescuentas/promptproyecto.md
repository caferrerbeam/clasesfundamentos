vamos hacer un proyecto que sea igual a este en estructura:

/Users/caferrerb/IdeaProjects/template_tarjeta_credito
usa este enunciado para crear el proyecto @ejerciciomultiplesclasescuentas/enunciado.md

este es el prompt para generar el proyecto:
ULTRATHINK

 Prompt para Generar Proyectos de Programación para GitHub Classroom

## Instrucciones de Uso

Utiliza este prompt para generar un proyecto completo de práctica para estudiantes de fundamentos de programación. Solo debes proporcionar el enunciado del ejercicio en formato markdown y el agente generará toda la estructura del proyecto.
Enunciado:



---

## PROMPT

Eres un asistente experto en crear proyectos educativos de programación para estudiantes universitarios usando GitHub Classroom. Tu tarea es generar un proyecto completo basado en el siguiente enunciado que te proporcionaré.

### ESTRUCTURA DEL PROYECTO A GENERAR:

El proyecto debe seguir exactamente esta estructura:
```
proyecto/
├── .github/
│   ├── classroom/
│   │   └── autograding.json
│   └── workflows/
│       └── classroom.yml
├── .idea/
│   └── (archivos de configuración de IntelliJ IDEA)
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── edu/eam/ingesoft/fundamentos/[tema]/
│   │       │   ├── logica/
│   │       │   │   └── [ClasePrincipal].java
│   │       │   └── gui/
│   │       │       └── [ClasePrincipal]GUI.java
│   │       └── org/example/
│   │           └── Main.java
│   └── test/
│       └── java/
│           └── edu/eam/ingesoft/fundamentos/[tema]/
│               └── [ClasePrincipal]Test.java
├── pom.xml
├── README.md
└── .gitignore
```

### REQUISITOS TÉCNICOS:

1. **Lenguaje**: Java 17
2. **Build Tool**: Maven
3. **Testing**: JUnit Jupiter 5.10.1
4. **GUI**: Swing (opcional, pero recomendado)
5. **Autograding**: GitHub Classroom con autograding.json

### COMPONENTES A GENERAR:

#### 1. README.md
- Título con emoji relevante
- Objetivos del ejercicio (mínimo 2)
- Contexto de negocio claro y motivador
- Reglas de negocio detalladas
- Objetivo 1: Identificación de datos (tabla para que el estudiante complete)
- Objetivo 2: Situaciones para resolver en papel (mínimo 5 casos)
- Objetivo 3: Implementación en Java con instrucciones claras
- Comandos para ejecutar:
  - `mvn test` (pruebas unitarias)
  - `mvn clean compile exec:java -Dexec.mainClass="edu.eam.ingesoft.fundamentos.[tema].gui.[Clase]GUI"` (GUI)
  - `mvn clean compile exec:java -Dexec.mainClass="org.example.Main"` (consola)
- Criterios de éxito
- Pasos para comenzar

#### 2. Clase Principal (src/main/java/.../logica/[Clase].java)
```java
package edu.eam.ingesoft.fundamentos.[tema].logica;

public class [ClasePrincipal] {
    // Atributos privados

    // Constructor con parámetros

    // Métodos de lógica de negocio (vacíos, retornando valores por defecto)

    // Getters y Setters para todos los atributos
}
```

#### 3. Tests (src/test/java/.../[Clase]Test.java)
- Mínimo 10 tests con JUnit 5
- Cobertura de todos los métodos principales
- Casos límite y validaciones
- Usar @BeforeEach para inicialización
- assertEquals con tolerancia para decimales

#### 4. GUI Swing (src/main/java/.../gui/[Clase]GUI.java)
- Interfaz moderna y atractiva con colores personalizados
- Formularios con JTextField, JComboBox según necesidad
- Botones para cada operación principal
- JTextArea para mostrar resultados
- Validación de entrada con mensajes de error claros
- Diseño con GridBagLayout o similar
- Colores corporativos y fuentes consistentes

#### 5. Clase Main (src/main/java/org/example/Main.java)
- Programa de consola con casos de ejemplo
- Impresión formateada de resultados
- Demostración de todas las funcionalidades

#### 6. pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>starter_[tema]_logica</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <!-- Dependencias de JUnit 5 -->
    <!-- Plugins de Maven -->
</project>
```

#### 7. GitHub Actions (.github/workflows/classroom.yml)
- Setup de JDK 17
- Cache de dependencias Maven
- Compilación y ejecución de tests
- Verificación de archivos requeridos
- Integración con GitHub Classroom autograding

#### 8. Autograding (.github/classroom/autograding.json)
- Test de compilación (10 puntos)
- Tests individuales para cada funcionalidad (10 puntos c/u)
- Test completo de todos los tests (10 puntos)
- Total: 100 puntos

### PATRONES DE DISEÑO A SEGUIR:

1. **Nombres de paquetes**: `edu.eam.ingesoft.fundamentos.[tema]`
2. **Separación de responsabilidades**:
   - `logica/`: Clases de negocio
   - `gui/`: Interfaces gráficas
3. **Métodos vacíos en la plantilla**: Los estudiantes deben implementarlos
4. **Tests exhaustivos**: Validar la implementación del estudiante
5. **GUI profesional**: Con manejo de errores y validaciones

### TEMAS COMUNES EN FUNDAMENTOS:
- Cálculos con descuentos/impuestos
- Gestión de inventarios
- Validación de datos
- Operaciones matemáticas/estadísticas
- Conversiones de unidades
- Sistemas de puntos/calificaciones

### IMPORTANTE:
- El código de la clase principal debe tener todos los métodos VACÍOS (retornando valores por defecto)
- Los tests deben estar COMPLETOS y funcionales
- La GUI debe ser FUNCIONAL y llamar a los métodos de la clase principal
- El README debe ser DETALLADO y pedagógico

---

## ENUNCIADO DEL EJERCICIO:

[AQUÍ PEGA EL ENUNCIADO EN MARKDOWN]

### INFORMACIÓN DEL REPOSITORIO:
- **URL del repositorio**: [Se proporcionará en el enunciado]
- **Rama principal (main)**: Contendrá el template con los métodos vacíos para que los estudiantes completen
- **Rama solución (solucion)**: Contendrá la implementación completa para validar que los tests y GitHub Actions funcionen correctamente

---

## SALIDA ESPERADA:

Genera todos los archivos mencionados anteriormente con código completo, listo para ser usado como template en GitHub Classroom. Cada archivo debe estar claramente identificado con su ruta completa.

### Debes generar DOS VERSIONES:

#### 1. VERSIÓN TEMPLATE (rama main):
- Clase principal con métodos VACÍOS retornando valores por defecto
- Para que los estudiantes implementen la solución

#### 2. VERSIÓN SOLUCIÓN (rama solucion):
- Clase principal con la IMPLEMENTACIÓN COMPLETA y funcional
- Para validar que los tests y GitHub Actions funcionen correctamente
- Debe pasar todos los tests al 100%

### Formato de salida:
```
### Archivo: [ruta/completa/archivo.ext]
```[código del archivo]```

Genera el proyecto completo basándote en el enunciado proporcionado.