# 💼 Proyecto: Wallet de Criptomonedas

## Sistema de Gestión de Portafolio con ArrayList - Fundamentos de Programación

[![GitHub Classroom](https://img.shields.io/badge/GitHub-Classroom-brightgreen?logo=github)](https://classroom.github.com/a/DNUpbPYt)
[![Documentación](https://img.shields.io/badge/Docs-Sitio_Web-blue)](docs/index.html)

🎓 **[Aceptar Asignación en GitHub Classroom](https://classroom.github.com/a/DNUpbPYt)**

⏰ **Fecha de Entrega: 25 de Noviembre de 2025 a las 0:00**

---

## 🚀 Inicio Rápido

### Para Estudiantes:

1. **Acepta la asignación**: [GitHub Classroom](https://classroom.github.com/a/DNUpbPYt)
2. **Lee la documentación completa**: Abre `docs/index.html` en tu navegador
3. **Lee la guía detallada**: `GUIA_COMPLETA.md` (2,630 líneas con todos los detalles)
4. **Revisa los tests**: `src/test/java/.../` - 39 tests para verificar tu implementación
5. **Compila y prueba**: `mvn clean compile && mvn test`
6. **Implementa los 54 métodos** siguiendo las especificaciones

### Recursos Disponibles:

- 📖 **Sitio Web Completo**: `docs/index.html` - Toda la guía en formato web bonito
- 📝 **Guía Completa**: `GUIA_COMPLETA.md` - Análisis detallado de cada método
- 🧪 **Tests Automatizados**: 39 tests unitarios para verificar tu código
- 🎨 **Interfaces**: CLI y GUI ya implementadas para probar el sistema
- 🤖 **Autograding**: GitHub Actions califica automáticamente tu código
- 🐳 **Codespaces**: Entorno preconfigurado con Java 17 y Maven

---

## 📚 Descripción del Proyecto

Este proyecto es un ejercicio completo de programación orientada a objetos diseñado para practicar el uso de **ArrayList** y técnicas de **recorrido, búsqueda, filtrado y ordenamiento** de colecciones.

El sistema simula un portafolio real de criptomonedas donde puedes:
- Agregar múltiples criptomonedas dinámicamente
- Registrar operaciones de compra y venta
- Calcular comisiones variables según día y hora
- Analizar rendimiento y ganancias
- Generar reportes completos

---

## 🎯 Objetivos de Aprendizaje

### Conceptos de Programación:
✅ Programación Orientada a Objetos (POO)
✅ Uso de ArrayList para colecciones dinámicas
✅ Recorridos con for-each y for tradicional
✅ Búsqueda lineal de elementos
✅ Filtrado y creación de nuevas listas
✅ Búsqueda de máximos y mínimos
✅ Acumuladores y contadores
✅ Relaciones entre clases (composición)
✅ Encapsulamiento y modificadores de acceso
✅ Métodos privados y públicos
✅ **Valores calculados vs valores almacenados** (¡FUNDAMENTAL!)
✅ toString() y representación de objetos

---

## 🔑 Conceptos Clave del Ejercicio

### 1️⃣ **Valores Calculados (no almacenados)**

**IMPORTANTE:** Este ejercicio enseña una buena práctica fundamental de POO:

### ❌ **NO hacer esto:**
Almacenar valores calculados como atributos que hay que actualizar manualmente:
```java
private double cantidadComprada;  // ❌ Malo
private double ganancia;          // ❌ Malo

public void agregarOperacion(...) {
    // Actualizar manualmente todos los atributos
    cantidadComprada += ...;
    ganancia = ...;  // ¡Fácil olvidar esto!
}
```

### ✅ **Hacer esto:**
Solo almacenar datos básicos y calcular el resto con métodos:
```java
private ArrayList<Operacion> operaciones;  // ✅ Solo datos básicos

public double getCantidadComprada() {  // ✅ Método que calcula
    double total = 0;
    for (Operacion op : operaciones) {
        if (op.getTipo().equals("Compra")) {
            total += op.getCantidad();
        }
    }
    return total;  // Siempre actualizado, nunca inconsistente
}
```

**Ventajas:** Datos siempre consistentes, menos errores, más fácil de mantener.

### 2️⃣ **Instanciación de Objetos en Métodos**

**IMPORTANTE:** Para practicar la creación de objetos, los métodos NO reciben objetos ya creados, sino los datos individuales:

#### ❌ **NO hacer esto:**
```java
public void agregarOperacion(Operacion op) {
    operaciones.add(op);  // Recibe objeto ya creado
}
```

#### ✅ **Hacer esto:**
```java
public void agregarOperacion(String tipo, double cantidad, double precio, String dia, int hora) {
    Operacion op = new Operacion(tipo, cantidad, precio, dia, hora);  // ✅ Crear objeto aquí
    operaciones.add(op);
}
```

**¿Por qué?**
- Practicas la sintaxis `new NombreClase(parametros)`
- Entiendes mejor la relación entre atributos y constructor
- Es más realista: el usuario provee datos, no objetos
- Aplica en: `agregarOperacion()`, `agregarCriptomoneda()`, `registrarCompra()`, `registrarVenta()`

---

## 📂 Estructura del Proyecto

```
ejerciciocriptomonedas/
│
├── README.md                             # Este archivo - Visión general
├── GUIA_MAESTRA_COMPLETA.md              # 🎓 DOCUMENTO PRINCIPAL - Todo en uno
│                                         #    • Análisis inductivo completo
│                                         #    • Ejercicios progresivos
│                                         #    • Patrones y referencia
├── enunciado.md                          # Enunciado formal del ejercicio
├── EstructuraClasesSugerida.java         # Template con firmas de métodos
│
└── [Tu implementación aquí]
    ├── Operacion.java                    # Clase para operaciones individuales
    ├── Criptomoneda.java                 # Clase para cada criptomoneda
    ├── Wallet.java                       # Clase principal del portafolio
    └── Main.java                         # Programa principal de prueba
```

---

## 🚀 Cómo Empezar

### 📖 LEER PRIMERO (¡Obligatorio!)

**ANTES de escribir cualquier código:**

1. 🎓 Abre `GUIA_MAESTRA_COMPLETA.md` - **Tu documento principal**
   - **PARTE 1:** Entenderás los principios fundamentales
   - **PARTE 2:** Verás el análisis inductivo completo (requerimientos → diseño)
   - **PARTE 3:** Seguirás los ejercicios progresivos paso a paso
   - **PARTE 4:** Consultarás patrones y referencia

2. 📖 Opcionalmente, revisa `enunciado.md` - **Enunciado formal**
   - Descripción detallada del problema
   - Especificaciones técnicas
   - Caso de prueba completo

### Ruta de Aprendizaje Recomendada

1. ✅ Lee **PARTE 1** de GUIA_MAESTRA_COMPLETA.md (Principios fundamentales)
2. ✅ Lee **PARTE 2** de GUIA_MAESTRA_COMPLETA.md (Análisis inductivo)
3. ✅ Implementa siguiendo **PARTE 3** (Ejercicios progresivos)
4. ✅ Consulta **PARTE 4** cuando necesites referencia
5. ✅ Usa `EstructuraClasesSugerida.java` como guía de firmas de métodos
7. Prueba cada método antes de continuar

### Opción 2: Usar la estructura base

1. ✅ Leíste `ANALISIS_INDUCTIVO.md` (fundamental)
2. ✅ Leíste `IMPORTANTE_ValoresCalculados.md`
3. Estudia el archivo `EstructuraClasesSugerida.java` completo
4. Observa que solo tiene 10 atributos en total (5+3+2)
5. Nota que `agregarOperacion()` es solo una línea
6. Entiende cómo cada método se deriva de un requerimiento
7. Implementa tu propia versión siguiendo el mismo patrón

### Opción 3: Para estudiantes avanzados

1. ✅ Leíste `ANALISIS_INDUCTIVO.md` (obligatorio - entender el proceso de diseño)
2. ✅ Leíste `IMPORTANTE_ValoresCalculados.md` (obligatorio incluso para avanzados)
3. Lee solo el `enunciado.md`
4. Diseña tu estructura respetando: solo 10 atributos totales
5. Implementa todo desde cero
6. Compara con `EstructuraClasesSugerida.java`
7. Verifica tu trazabilidad: cada método debe responder a un requerimiento

---

## 📖 Archivos del Proyecto

### 🌟 Archivos ESENCIALES (Lee Primero)

#### 1. ANALISIS_INDUCTIVO.md 🧠 **[FUNDAMENTAL]**
**Contenido:**
- **Proceso completo desde requerimientos hasta diseño**
- Por qué cada clase existe
- Por qué cada atributo es necesario
- Derivación inductiva de cada método
- Patrones de recorrido identificados
- Tabla de rastreabilidad: requerimiento → método
- **Responde: ¿Por qué el diseño es así?**

**Cuándo usarlo:** Lee esto PRIMERO para entender el PORQUÉ del diseño. Es el documento más importante para comprender la arquitectura.

---

#### 2. IMPORTANTE_ValoresCalculados.md 📖
**Contenido:**
- El concepto clave del ejercicio
- Explicación detallada: ¿Almacenar o calcular?
- Comparación lado a lado con ejemplos
- Por qué es mejor calcular que almacenar
- Checklist de verificación

**Cuándo usarlo:** Después del análisis inductivo, para profundizar en el concepto de valores calculados.

---

#### 3. GUIA_RAPIDA.md ⚡
**Contenido:**
- Resumen de lo esencial en 5 minutos
- Estructura de atributos por clase (5+3+2)
- Ejemplos de código correcto vs incorrecto
- Checklist de implementación
- Valores esperados del caso de prueba

**Cuándo usarlo:** Referencia rápida constante mientras programas.

---

### 📚 Archivos de Implementación

#### 4. enunciado.md
**Contenido:**
- Contexto del problema
- Descripción detallada de las 3 clases
- Reglas de negocio (comisiones, alertas, etc.)
- 6 niveles de ejercicios prácticos
- Caso de prueba completo con 10 operaciones
- 15 preguntas para responder
- Criterios de evaluación

**Cuándo usarlo:** Referencia completa del problema.

---

#### 5. EjerciciosProgresivos.md
**Contenido:**
- Explicación del concepto de valores calculados
- Guía paso a paso dividida en 4 fases
- Ejercicios incrementales con pruebas
- Explicaciones detalladas de cada método
- Código de ejemplo para cada ejercicio
- Checklist de completitud

**Cuándo usarlo:** Guía paso a paso si es tu primera vez.

---

#### 6. EstructuraClasesSugerida.java
**Contenido:**
- Código completo de las 3 clases CORRECTO
- Solo 10 atributos en total (5+3+2)
- agregarOperacion() de 1 línea
- Todos los valores se calculan sobre la marcha
- Programa Main con caso de prueba
- Comentarios explicativos detallados

**Cuándo usarlo:** Ejemplo completo de la implementación correcta. Usa esto para verificar tu propia implementación.

---

## 🎓 Niveles de Dificultad

### 🟢 Nivel 1: Principiante
**Si eres nuevo en programación:**
- Sigue `EjerciciosProgresivos.md` desde el inicio
- Completa las Fases 1 y 2 completas
- Pide ayuda si te atascas
- **Objetivo:** Entender clases, objetos y ArrayList básico

### 🟡 Nivel 2: Intermedio
**Si ya conoces POO básico:**
- Completa las Fases 1, 2 y 3
- Implementa todos los métodos de análisis
- Responde las 15 preguntas del caso de prueba
- **Objetivo:** Dominar recorridos y filtros

### 🔴 Nivel 3: Avanzado
**Si dominas Java:**
- Implementa todo desde cero sin mirar la estructura
- Agrega los métodos de ordenamiento
- Implementa los retos adicionales
- Crea tus propios análisis creativos
- **Objetivo:** Optimización y diseño elegante

---

## 📝 Caso de Prueba Incluido

El enunciado incluye un caso de prueba completo con:
- 10 operaciones pre-diseñadas
- 5 criptomonedas diferentes (BTC, ETH, ADA, SOL, XRP)
- Operaciones en diferentes días y horarios
- Mezcla de compras y ventas
- Cálculos esperados documentados

**Resultado esperado del caso de prueba:**
- Total invertido: $61,010
- Total recuperado: $16,950
- Ganancia total: $2,664
- Comisiones totales: $593.87
- Mejor rentabilidad: Cardano (71.76%)
- Peor rentabilidad: Bitcoin (15.56%)

---

## 🔑 Conceptos Clave a Dominar

### 1. ArrayList vs Arrays Normales
```java
// Array normal (tamaño fijo)
Criptomoneda[] criptos = new Criptomoneda[5]; // Solo 5 máximo

// ArrayList (tamaño dinámico) ✅
ArrayList<Criptomoneda> criptos = new ArrayList<>(); // ¡Ilimitado!
criptos.add(nuevaCripto); // Agregar fácilmente
```

### 2. Recorrido de ArrayList
```java
// For-each (recomendado para lectura)
for (Criptomoneda cripto : criptomonedas) {
    System.out.println(cripto.getNombre());
}

// For tradicional (si necesitas el índice)
for (int i = 0; i < criptomonedas.size(); i++) {
    Criptomoneda cripto = criptomonedas.get(i);
}
```

### 3. Búsqueda Lineal
```java
public Criptomoneda buscar(String simbolo) {
    for (Criptomoneda cripto : criptomonedas) {
        if (cripto.getSimbolo().equals(simbolo)) {
            return cripto; // Encontrado
        }
    }
    return null; // No encontrado
}
```

### 4. Filtrado
```java
public ArrayList<Criptomoneda> filtrarConGanancias() {
    ArrayList<Criptomoneda> resultado = new ArrayList<>();
    for (Criptomoneda cripto : criptomonedas) {
        if (cripto.getGananciaRealizada() > 0) {
            resultado.add(cripto);
        }
    }
    return resultado;
}
```

### 5. Búsqueda de Máximo
```java
public Criptomoneda encontrarMejor() {
    Criptomoneda mejor = null;
    double maxRentabilidad = Double.MIN_VALUE;

    for (Criptomoneda cripto : criptomonedas) {
        if (cripto.getRentabilidad() > maxRentabilidad) {
            maxRentabilidad = cripto.getRentabilidad();
            mejor = cripto;
        }
    }

    return mejor;
}
```

### 6. Acumuladores
```java
public double calcularTotal() {
    double total = 0;
    for (Criptomoneda cripto : criptomonedas) {
        total += cripto.getDineroInvertido();
    }
    return total;
}
```

---

## ⚠️ Errores Comunes a Evitar

### 1. NullPointerException
```java
// ❌ INCORRECTO
Criptomoneda cripto = buscarCriptomoneda("XYZ");
System.out.println(cripto.getNombre()); // ¡Puede ser null!

// ✅ CORRECTO
Criptomoneda cripto = buscarCriptomoneda("XYZ");
if (cripto != null) {
    System.out.println(cripto.getNombre());
}
```

### 2. División por Cero
```java
// ❌ INCORRECTO
precioPromedio = dineroInvertido / cantidadComprada; // ¡Puede ser 0!

// ✅ CORRECTO
if (cantidadComprada > 0) {
    precioPromedio = dineroInvertido / cantidadComprada;
}
```

### 3. Modificar Lista Mientras se Recorre
```java
// ❌ INCORRECTO
for (Operacion op : operaciones) {
    if (op.getMonto() > 1000) {
        operaciones.remove(op); // ¡Error!
    }
}

// ✅ CORRECTO
ArrayList<Operacion> aEliminar = new ArrayList<>();
for (Operacion op : operaciones) {
    if (op.getMonto() > 1000) {
        aEliminar.add(op);
    }
}
operaciones.removeAll(aEliminar);
```

### 4. Almacenar Valores que Deberían Ser Calculados
```java
// ❌ INCORRECTO - Almacenar valores calculados como atributos
private double cantidadComprada;
private double precioPromedio;

// ✅ CORRECTO - Calcular sobre la marcha
public double getCantidadComprada() {
    double total = 0;
    for (Operacion op : operaciones) {
        if (op.getTipo().equals("Compra")) {
            total += op.getCantidad();
        }
    }
    return total;
}
```

**Regla de oro:** Si un valor puede calcularse a partir de otros datos, NO lo almacenes como atributo. Calcúlalo con un método.

---

## 🧪 Cómo Probar tu Implementación

### Prueba 1: Operación Individual
```java
Operacion op = new Operacion("Compra", 0.5, 45000, "Lunes", 9);
assert op.getMontoOperacion() == 22500.0;
assert op.getPeriodo().equals("Mañana");
assert op.getComisionPorcentaje() == 0.5;
```

### Prueba 2: Criptomoneda Individual
```java
Criptomoneda btc = new Criptomoneda("Bitcoin", "BTC");
btc.agregarOperacion(new Operacion("Compra", 0.5, 45000, "Lunes", 9));
assert btc.getCantidadActual() == 0.5;
assert btc.getPrecioPromedioCompra() == 45000.0;
```

### Prueba 3: Wallet Completo
```java
Wallet wallet = new Wallet("Test");
wallet.agregarCriptomoneda("Bitcoin", "BTC");
wallet.registrarCompra("BTC", 0.5, 45000, "Lunes", 9);
assert wallet.calcularValorTotalInvertido() == 22500.0;
```

---

## 📊 Métricas de Éxito

Al completar el proyecto, deberías poder:

✅ Crear y manipular ArrayList de objetos
✅ Implementar búsquedas en colecciones
✅ Filtrar elementos según criterios
✅ Encontrar máximos y mínimos
✅ Calcular totales y promedios
✅ Trabajar con relaciones entre clases
✅ Generar reportes formateados
✅ Validar datos antes de procesarlos
✅ Manejar casos especiales (listas vacías, null, etc.)

---

## 🏆 Retos Opcionales

Si completaste todo y quieres más desafío:

### Reto 1: Persistencia
Guarda el portafolio en un archivo de texto y cárgalo al iniciar.

### Reto 2: Interfaz de Usuario
Crea un menú interactivo por consola para operar el wallet.

### Reto 3: Validaciones Avanzadas
Impide vender más de lo que tienes, precios negativos, etc.

### Reto 4: Gráficos
Genera un gráfico ASCII de las rentabilidades.

### Reto 5: Histórico de Precios
Registra el precio de cada cripto en cada momento y calcula la variación.

---

## 📞 Ayuda y Recursos

### Si te atascas:
1. Revisa los ejemplos en `EjerciciosProgresivos.md`
2. Consulta la estructura en `EstructuraClasesSugerida.java`
3. Busca el concepto específico en la documentación de Java
4. Pregunta a tu profesor o compañeros

### Documentación útil:
- [Java ArrayList Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Java Tutorials - Collections](https://docs.oracle.com/javase/tutorial/collections/)

---

## ✅ Criterios de Evaluación

| Aspecto | Peso | Qué se evalúa |
|---------|------|---------------|
| **Implementación de Clases** | 20% | Estructura correcta, atributos, constructores |
| **Métodos de Recorrido** | 25% | Búsquedas, filtros, máximo/mínimo |
| **Cálculos Correctos** | 20% | Comisiones, promedios, ganancias |
| **Ordenamientos** | 15% | Ordenar por diferentes criterios |
| **Reportes** | 10% | Formato profesional, información completa |
| **Validaciones** | 10% | Manejo de errores, casos especiales |

---

## 🎓 Para el Profesor

### Objetivos Pedagógicos:
- Reforzar conceptos de POO
- Practicar ArrayList extensivamente
- Dominar diferentes tipos de recorridos
- Aplicar lógica de negocio compleja
- Generar reportes profesionales

### Tiempo Estimado:
- Estudiantes principiantes: 8-12 horas
- Estudiantes intermedios: 5-8 horas
- Estudiantes avanzados: 3-5 horas

### Variaciones Posibles:
- Cambiar las criptomonedas por otros activos (acciones, bonos)
- Modificar las reglas de comisiones
- Agregar nuevos tipos de análisis
- Incluir más alertas personalizadas

---

## 📄 Licencia

Este material es de uso educativo para el curso de Fundamentos de Programación.

---

**¡Disfruta el proceso de aprendizaje! 🚀💻**

*Recuerda: El objetivo no es solo que funcione, sino que entiendas cada línea de código que escribes.*
