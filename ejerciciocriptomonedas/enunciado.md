# 💼 Sistema de Wallet de Criptomonedas con ArrayList
## Curso: Fundamentos de Programación - Práctica de ArrayList y POO

---

## 🎯 Objetivo del Ejercicio

Implementar un sistema completo de gestión de portafolio de criptomonedas utilizando **ArrayList** y **Programación Orientada a Objetos**. Este ejercicio te permitirá practicar:

- ✅ Uso de ArrayList para colecciones dinámicas
- ✅ Recorrido de ArrayList con diferentes estructuras de control
- ✅ Búsqueda y filtrado de elementos
- ✅ Ordenamiento de elementos
- ✅ Cálculos agregados (sumas, promedios, máximos, mínimos)
- ✅ Relaciones entre clases
- ✅ Encapsulamiento y buenas prácticas de POO

---

## 📋 Estructura de Clases

### 1. Clase `Operacion`

Representa una operación individual de compra o venta de criptomonedas.

**Atributos:**
- `tipo` (String): "Compra" o "Venta"
- `cantidad` (double): Cantidad de criptomonedas en la operación
- `precioUnitario` (double): Precio en dólares por unidad
- `dia` (String): Día de la semana
- `hora` (int): Hora en formato 24h (0-23)

**Métodos (valores calculados):**
- Constructor que recibe: tipo, cantidad, precioUnitario, dia, hora
- Getters para los atributos básicos
- `getPeriodo()`: Calcula y retorna "Mañana", "Tarde" o "Noche" según la hora
- `getComisionPorcentaje()`: Calcula el porcentaje de comisión según día y período
- `getMontoOperacion()`: Calcula cantidad × precioUnitario
- `getComisionDolares()`: Calcula monto × (comisiónPorcentaje / 100)
- `getCostoTotal()`: Si es compra, retorna monto + comisión; sino 0
- `getIngresoNeto()`: Si es venta, retorna monto - comisión; sino 0
- `toString()`: Representación legible de la operación

**IMPORTANTE:** Los valores como periodo, monto, comisión, etc. NO son atributos, son métodos que calculan sobre la marcha para evitar inconsistencias.

---

### 2. Clase `Criptomoneda`

Representa una criptomoneda específica en el portafolio.

**Atributos:**
- `nombre` (String): Nombre de la cripto (ej: "Bitcoin")
- `simbolo` (String): Símbolo (ej: "BTC")
- `operaciones` (ArrayList&lt;Operacion&gt;): Historial de operaciones

**Métodos básicos:**
- Constructor con nombre y símbolo
- Getters para nombre, símbolo y operaciones
- `agregarOperacion(String tipo, double cantidad, double precioUnitario, String dia, int hora)`: Crea objeto Operacion y lo agrega al ArrayList
- `contarOperaciones()`: Retorna operaciones.size()
- `tieneVentas()`: Retorna true si hay al menos una venta
- `toString()`: Información resumida

**IMPORTANTE:** El método `agregarOperacion` NO recibe un objeto Operacion, recibe los 5 datos individuales y crea el objeto internamente para practicar instanciación.

**Métodos calculados (recorren el ArrayList de operaciones):**
- `getCantidadComprada()`: Recorre operaciones y suma cantidades de tipo "Compra"
- `getCantidadVendida()`: Recorre operaciones y suma cantidades de tipo "Venta"
- `getCantidadActual()`: Retorna getCantidadComprada() - getCantidadVendida()
- `getDineroInvertido()`: Recorre operaciones "Compra" y suma montos (sin comisión)
- `getDineroRecuperado()`: Recorre operaciones "Venta" y suma montos (sin comisión)
- `getComisionesTotales()`: Recorre todas las operaciones y suma comisiones
- `getPrecioPromedioCompra()`: getDineroInvertido() / getCantidadComprada()
- `getPrecioPromedioVenta()`: getDineroRecuperado() / getCantidadVendida()
- `getGananciaRealizada()`: getDineroRecuperado() - (getCantidadVendida() × getPrecioPromedioCompra())
- `getRentabilidadPorcentaje()`: ((getPrecioPromedioVenta() - getPrecioPromedioCompra()) / getPrecioPromedioCompra()) × 100
- `getEstado()`: Retorna "Ganancia", "Pérdida" o "Sin ventas" según getGananciaRealizada()

**Métodos de filtrado:**
- `obtenerOperacionesPorTipo(String tipo)`: Filtra operaciones por tipo
- `obtenerOperacionesPorDia(String dia)`: Filtra operaciones por día
- `obtenerOperacionesPorPeriodo(String periodo)`: Filtra operaciones por período
- `obtenerComisionMasAlta()`: Busca la operación con mayor comisión
- `obtenerComisionMasBaja()`: Busca la operación con menor comisión

**IMPORTANTE:** Los valores como cantidades, dinero, promedios, ganancia y rentabilidad NO son atributos almacenados. Son métodos que calculan recorriendo el ArrayList de operaciones cada vez que se llaman. Esto garantiza que siempre estén actualizados.

---

### 3. Clase `Wallet` (CLASE PRINCIPAL)

Representa el portafolio completo de criptomonedas.

**Atributos:**
- `criptomonedas` (ArrayList&lt;Criptomoneda&gt;): Lista de todas las criptos
- `nombreDueno` (String): Nombre del dueño del portafolio

**Métodos Básicos:**
- Constructor
- `agregarCriptomoneda(String nombre, String simbolo)`: Crea objeto Criptomoneda y lo agrega al ArrayList
- `buscarCriptomoneda(String simbolo)`: Busca por símbolo, retorna la cripto o null
- `existeCriptomoneda(String simbolo)`: Retorna true/false
- `eliminarCriptomoneda(String simbolo)`: Elimina una cripto del portafolio

**IMPORTANTE:** El método `agregarCriptomoneda` NO recibe un objeto Criptomoneda, recibe los 2 datos individuales (nombre y símbolo) y crea el objeto internamente para practicar instanciación.

**Métodos de Operaciones:**
- `registrarCompra(String simbolo, double cantidad, double precio, String dia, int hora)`: Busca la cripto y llama a su método agregarOperacion con tipo "Compra"
- `registrarVenta(String simbolo, double cantidad, double precio, String dia, int hora)`: Busca la cripto y llama a su método agregarOperacion con tipo "Venta"

**IMPORTANTE:** Estos métodos NO reciben objetos Operacion, reciben los 5 datos individuales. La cripto crea el objeto internamente para practicar instanciación delegada.

**Métodos de Análisis (REQUIEREN RECORRER ARRAYS):**

#### 📊 Análisis de Rendimiento:
- `obtenerCriptoConMejorRentabilidad()`: Busca entre todas las criptos con ventas
- `obtenerCriptoConPeorRentabilidad()`: Busca la de menor rentabilidad
- `obtenerCriptoConMayorGanancia()`: La que más dinero ha ganado
- `obtenerCriptoConMayorPerdida()`: La que más dinero ha perdido
- `obtenerCriptosConGanancias()`: ArrayList de criptos en ganancia
- `obtenerCriptosConPerdidas()`: ArrayList de criptos en pérdida
- `obtenerCriptosSinVentas()`: ArrayList de criptos sin ventas

#### 💰 Análisis Financiero:
- `calcularValorTotalInvertido()`: Suma de todo el dinero invertido
- `calcularValorTotalRecuperado()`: Suma de todo el dinero recuperado
- `calcularGananciaTotalPortafolio()`: Suma de todas las ganancias/pérdidas
- `calcularComisionesTotalesPortafolio()`: Suma de todas las comisiones
- `calcularComisionesPorCripto()`: Retorna ArrayList con desglose
- `calcularPorcentajeComisionesSobreGanancias()`: Impacto de comisiones

#### 📈 Análisis de Operaciones:
- `contarTotalOperaciones()`: Total de operaciones en todo el portafolio
- `contarOperacionesPorTipo(String tipo)`: Cuenta compras o ventas
- `obtenerOperacionesPorDia(String dia)`: Todas las operaciones de un día
- `obtenerOperacionesPorPeriodo(String periodo)`: Filtra por Mañana/Tarde/Noche
- `obtenerOperacionesConComisionAlta()`: Las que tienen comisión > 1%
- `calcularComisionPromedioPortafolio()`: Promedio de todas las comisiones

#### 🎯 Búsquedas Específicas:
- `obtenerCriptoConMasOperaciones()`: La cripto más operada
- `obtenerCriptoConMenosOperaciones()`: La menos operada
- `obtenerOperacionMasGrande()`: La operación de mayor monto
- `obtenerOperacionMasPequena()`: La operación de menor monto
- `buscarOperacionesMayoresA(double monto)`: Operaciones sobre cierto monto

#### 📅 Análisis Temporal:
- `obtenerDiaMasOperado()`: El día con más operaciones
- `obtenerPeriodoMasOperado()`: El período con más operaciones
- `obtenerDiasOperados()`: ArrayList de días únicos en los que se operó
- `calcularComisionPromedioEnFinDeSemana()`: Promedio de comisiones sábado/domingo
- `calcularComisionPromedioEntreSemana()`: Promedio lunes a viernes

#### 🔢 Ordenamientos:
- `obtenerCriptosOrdenadasPorRentabilidad()`: De mayor a menor
- `obtenerCriptosOrdenadasPorGanancia()`: De mayor a menor
- `obtenerCriptosOrdenadasPorComisiones()`: De mayor a menor
- `obtenerCriptosOrdenadasPorCantidadActual()`: De mayor a menor

#### 📊 Reportes:
- `generarReporteCompleto()`: String con todo el análisis
- `generarReportePorCripto(String simbolo)`: Reporte detallado de una cripto
- `generarReporteComisiones()`: Análisis detallado de comisiones
- `generarReporteOperacionesPorDia()`: Resumen por día de la semana
- `generarReporteCriptosConAlerta()`: Muestra alertas activas

#### ⚠️ Alertas y Validaciones:
- `verificarAlertasCripto(String simbolo, double precio, String tipo)`: Verifica alertas específicas
- `obtenerTodasLasAlertas()`: ArrayList de strings con todas las alertas activas
- `validarVentaSuficiente(String simbolo, double cantidad)`: Verifica si hay suficiente cantidad

---

## 📐 Reglas de Negocio (del ejercicio original)

### Determinación del Período del Día

```
Si hora >= 6 Y hora <= 11 → "Mañana"
Si hora >= 12 Y hora <= 17 → "Tarde"
Si no → "Noche"
```

### Cálculo de Comisiones

**Comisión Base por Día:**
- Lunes a Viernes: 0.5%
- Sábado: 0.8%
- Domingo: 1.0%

**Ajuste por Período:**
- Mañana: +0.0%
- Tarde: +0.2%
- Noche: +0.5%

**Comisión Total = Comisión Base + Ajuste Período**

### Alertas por Criptomoneda

#### Bitcoin (BTC):
- Si precio compra > $60,000: "⚠️ ALERTA: BTC en precio histórico alto"
- Si precio venta < $30,000: "⚠️ ALERTA: Posible venta en pérdida de BTC"

#### Ethereum (ETH):
- Si precio compra > $3,500: "⚠️ ALERTA: ETH cerca de máximo histórico"
- Si compras > 10 ETH: "💎 Compra grande de ETH detectada"

#### Cardano (ADA):
- Si precio < $0.30: "🔥 OPORTUNIDAD: ADA en precio bajo"
- Si vendes con ganancia > 50%: "🎉 Excelente operación con ADA"

#### Solana (SOL):
- Si precio > $150: "⚠️ PRECAUCIÓN: SOL en zona de resistencia"
- Si compras en fin de semana: "⏰ Compra de SOL en fin de semana"

#### Ripple (XRP):
- Si precio < $0.50: "💰 Precio atractivo de XRP"
- Si vendes > 1000 XRP: "📊 Venta significativa de XRP"

### Recomendaciones de Estrategia

**Mañana + Lunes a Viernes:**
"✅ Horario óptimo para operar - Buena liquidez"

**Mañana + Fin de semana:**
"⚠️ Liquidez moderada en fin de semana"

**Tarde + Lunes a Viernes:**
"📊 Alta volatilidad esperada - Oportunidades y riesgos"

**Tarde + Fin de semana:**
"⚠️ Comisiones más altas en fin de semana"

**Noche + Cualquier día:**
"🌙 Comisión alta por baja liquidez - Considere operar en la mañana"

---

## 🎓 Ejercicios Prácticos (Para Estudiantes)

### Nivel 1: Implementación Básica

**Ejercicio 1.1:** Implementar las tres clases con todos sus atributos y constructores.

**Ejercicio 1.2:** Implementar los métodos de cálculo de período y comisión en la clase `Operacion`.

**Ejercicio 1.3:** Implementar los métodos básicos de `Wallet` (agregar, buscar, existir cripto).

### Nivel 2: Operaciones y Actualización

**Ejercicio 2.1:** Implementar el método `agregarOperacion` en `Criptomoneda` que actualice todos los valores.

**Ejercicio 2.2:** Implementar los métodos de registro de operaciones en `Wallet`.

**Ejercicio 2.3:** Crear un programa principal que permita registrar 10 operaciones en diferentes criptos.

### Nivel 3: Análisis y Recorridos

**Ejercicio 3.1:** Implementar todos los métodos de análisis de rendimiento (mejor/peor, ganancias/pérdidas).

**Ejercicio 3.2:** Implementar los métodos de análisis financiero (totales, comisiones).

**Ejercicio 3.3:** Implementar los métodos de análisis de operaciones (conteos, filtros).

### Nivel 4: Búsquedas y Filtros

**Ejercicio 4.1:** Implementar los métodos de búsquedas específicas (más/menos operaciones, operación más grande).

**Ejercicio 4.2:** Implementar los filtros por día y período.

**Ejercicio 4.3:** Implementar la búsqueda de operaciones por rango de montos.

### Nivel 5: Ordenamientos

**Ejercicio 5.1:** Implementar los métodos de ordenamiento por rentabilidad.

**Ejercicio 5.2:** Implementar los métodos de ordenamiento por ganancia y comisiones.

**Ejercicio 5.3:** Implementar ordenamiento personalizado usando Comparator.

### Nivel 6: Reportes y Análisis Avanzado

**Ejercicio 6.1:** Implementar `generarReporteCompleto()` con formato profesional.

**Ejercicio 6.2:** Implementar el análisis de comisiones con comparación de horarios.

**Ejercicio 6.3:** Implementar el sistema de alertas completo.

---

## 📝 Caso de Prueba Completo

### Escenario: "El Trader Activo"

Crea un programa que simule la siguiente historia de trading:

```java
Wallet miWallet = new Wallet("Juan Pérez");

// Agregar criptomonedas al portafolio
miWallet.agregarCriptomoneda("Bitcoin", "BTC");
miWallet.agregarCriptomoneda("Ethereum", "ETH");
miWallet.agregarCriptomoneda("Cardano", "ADA");
miWallet.agregarCriptomoneda("Solana", "SOL");
miWallet.agregarCriptomoneda("Ripple", "XRP");

// Operación 1: Lunes, 9 AM - Compra inicial de Bitcoin
miWallet.registrarCompra("BTC", 0.5, 45000, "Lunes", 9);

// Operación 2: Miércoles, 2 PM - Compra de Cardano
miWallet.registrarCompra("ADA", 2000, 0.28, "Miércoles", 14);

// Operación 3: Viernes, 9 PM - Compra más Cardano
miWallet.registrarCompra("ADA", 3000, 0.25, "Viernes", 21);

// Operación 4: Lunes siguiente, 10 AM - Venta de Cardano
miWallet.registrarVenta("ADA", 3000, 0.45, "Lunes", 10);

// Operación 5: Miércoles, 3 PM - Compra de Ethereum
miWallet.registrarCompra("ETH", 12, 3100, "Miércoles", 15);

// Operación 6: Sábado, 10 PM - Venta de Bitcoin
miWallet.registrarVenta("BTC", 0.3, 52000, "Sábado", 22);

// Operación 7: Domingo, 3 AM - Compra de Solana
miWallet.registrarCompra("SOL", 20, 155, "Domingo", 3);

// Operación 8: Martes, 11 AM - Venta de Ethereum
miWallet.registrarVenta("ETH", 6, 3700, "Martes", 11);

// Operación 9: Jueves, 4 PM - Compra de Ripple
miWallet.registrarCompra("XRP", 4000, 0.48, "Jueves", 16);

// Operación 10: Viernes, 8 AM - Más Bitcoin
miWallet.registrarCompra("BTC", 0.3, 44000, "Viernes", 8);
```

### Preguntas a Responder (Practicando Recorridos):

1. **¿Cuál es la criptomoneda con mejor rentabilidad?**
   - Método: `obtenerCriptoConMejorRentabilidad()`
   - Debe recorrer todas las criptos con ventas y comparar rentabilidades

2. **¿Cuál es la criptomoneda con peor rentabilidad?**
   - Método: `obtenerCriptoConPeorRentabilidad()`

3. **¿Cuánto dinero se ha invertido en total?**
   - Método: `calcularValorTotalInvertido()`
   - Debe recorrer todas las criptos y sumar

4. **¿Cuánto se ha pagado en comisiones en total?**
   - Método: `calcularComisionesTotalesPortafolio()`

5. **¿Qué porcentaje de las ganancias representan las comisiones?**
   - Método: `calcularPorcentajeComisionesSobreGanancias()`

6. **¿Cuántas operaciones se han realizado en total?**
   - Método: `contarTotalOperaciones()`
   - Debe recorrer todas las criptos y sumar sus operaciones

7. **¿Cuál es el día de la semana más operado?**
   - Método: `obtenerDiaMasOperado()`
   - Debe recorrer todas las operaciones y contar por día

8. **¿Cuál es el período del día más operado?**
   - Método: `obtenerPeriodoMasOperado()`

9. **¿Cuáles operaciones tienen comisión mayor al 1%?**
   - Método: `obtenerOperacionesConComisionAlta()`
   - Debe recorrer todas las operaciones de todas las criptos

10. **¿Cuál es la criptomoneda con más operaciones?**
    - Método: `obtenerCriptoConMasOperaciones()`

11. **¿Cuántas criptos tienen ganancias y cuántas pérdidas?**
    - Métodos: `obtenerCriptosConGanancias()` y `obtenerCriptosConPerdidas()`

12. **¿Cuál fue la operación más grande (mayor monto)?**
    - Método: `obtenerOperacionMasGrande()`

13. **Lista de criptos ordenadas por rentabilidad de mayor a menor**
    - Método: `obtenerCriptosOrdenadasPorRentabilidad()`

14. **¿Cuánto se habría ahorrado en comisiones operando solo en horario óptimo?**
    - Método personalizado que compare comisiones actuales vs óptimas

15. **Generar un reporte completo del portafolio**
    - Método: `generarReporteCompleto()`

---

## 🎯 Objetivos de Aprendizaje Específicos

### Recorridos de ArrayList que debes dominar:

1. **Recorrido simple con for-each:**
```java
for (Criptomoneda cripto : criptomonedas) {
    // Procesar cada cripto
}
```

2. **Recorrido con índice:**
```java
for (int i = 0; i < criptomonedas.size(); i++) {
    Criptomoneda cripto = criptomonedas.get(i);
}
```

3. **Búsqueda lineal:**
```java
for (Criptomoneda cripto : criptomonedas) {
    if (cripto.getSimbolo().equals(simboloBuscado)) {
        return cripto;
    }
}
return null;
```

4. **Acumuladores:**
```java
double total = 0;
for (Criptomoneda cripto : criptomonedas) {
    total += cripto.getDineroInvertido();
}
```

5. **Contadores:**
```java
int contador = 0;
for (Criptomoneda cripto : criptomonedas) {
    if (cripto.tieneVentas()) {
        contador++;
    }
}
```

6. **Búsqueda de máximo/mínimo:**
```java
Criptomoneda mejorCripto = null;
double mejorRentabilidad = Double.MIN_VALUE;
for (Criptomoneda cripto : criptomonedas) {
    if (cripto.tieneVentas()) {
        if (cripto.getRentabilidadPorcentaje() > mejorRentabilidad) {
            mejorRentabilidad = cripto.getRentabilidadPorcentaje();
            mejorCripto = cripto;
        }
    }
}
```

7. **Filtrado a nuevo ArrayList:**
```java
ArrayList<Criptomoneda> criptosConGanancias = new ArrayList<>();
for (Criptomoneda cripto : criptomonedas) {
    if (cripto.getGananciaRealizada() > 0) {
        criptosConGanancias.add(cripto);
    }
}
```

8. **Recorridos anidados:**
```java
for (Criptomoneda cripto : criptomonedas) {
    for (Operacion op : cripto.getOperaciones()) {
        // Procesar cada operación de cada cripto
    }
}
```

---

## 💡 Consejos para la Implementación

### 1. Orden de Implementación Recomendado:
1. Clase `Operacion` completa
2. Clase `Criptomoneda` sin métodos avanzados
3. Clase `Wallet` métodos básicos
4. Probar con operaciones simples
5. Agregar métodos de análisis uno por uno
6. Probar cada método nuevo

### 2. Buenas Prácticas:
- Usar nombres descriptivos de variables
- Comentar código complejo
- Validar entradas (precios positivos, cantidades válidas, etc.)
- Manejar casos especiales (división por cero, listas vacías)
- Usar constantes para valores fijos (nombres de días, períodos)

### 3. Validaciones Importantes:
```java
// Antes de dividir
if (cantidadComprada > 0) {
    precioPromedio = dineroInvertido / cantidadComprada;
}

// Antes de vender
if (cantidadActual >= cantidadAVender) {
    // Permitir venta
}

// Verificar lista vacía
if (!criptomonedas.isEmpty()) {
    // Procesar
}
```

### 4. Formato de Reportes:
```
=====================================
  REPORTE COMPLETO DE WALLET
  Propietario: Juan Pérez
=====================================

CRIPTOMONEDAS EN PORTAFOLIO: 5

1. Bitcoin (BTC)
   - Cantidad actual: 0.5 BTC
   - Dinero invertido: $22,500.00
   - Dinero recuperado: $15,600.00
   - Ganancia realizada: $2,100.00
   - Rentabilidad: 15.56%
   - Comisiones pagadas: $315.30
   - Total operaciones: 3

[... más criptos ...]

RESUMEN GENERAL:
- Valor total invertido: $61,010.00
- Valor total recuperado: $16,950.00
- Ganancia/Pérdida total: $2,664.00
- Comisiones totales: $593.87
- Comisiones sobre ganancias: 22.29%

MEJOR RENDIMIENTO: Cardano (ADA) - 71.76%
PEOR RENDIMIENTO: Bitcoin (BTC) - 15.56%

TOTAL DE OPERACIONES: 10
```

---

## 🏆 Retos Adicionales (Opcional)

### Reto 1: Método de Exportación
Implementa un método que guarde el reporte completo en un archivo de texto.

### Reto 2: Estadísticas Avanzadas
Calcula la desviación estándar de las rentabilidades.

### Reto 3: Simulador de Precios
Agrega un método que simule cómo cambiaría el valor del portafolio con diferentes precios.

### Reto 4: Análisis de Tendencias
Determina si cada cripto está en tendencia alcista o bajista basándose en las últimas 3 operaciones.

### Reto 5: Sistema de Recomendaciones
Implementa un método que recomiende qué cripto comprar o vender basándose en el análisis del portafolio.

---

## ✅ Entregables

1. **Código fuente completo** de las tres clases
2. **Clase Main** con el caso de prueba completo
3. **Respuestas** a las 15 preguntas del caso de prueba
4. **Reporte completo** generado por el programa
5. **Documentación** de al menos 5 métodos que requieran recorridos complejos

---

## 📚 Criterios de Evaluación

| Criterio | Puntos |
|----------|--------|
| Implementación correcta de clases | 20% |
| Métodos de recorrido y búsqueda | 25% |
| Cálculos correctos (comisiones, ganancias) | 20% |
| Ordenamientos y filtros | 15% |
| Reportes y presentación | 10% |
| Manejo de excepciones y validaciones | 10% |

**Total: 100%**

---

## 🎓 Notas del Profesor

Este ejercicio está diseñado para que domines el uso de ArrayList en Java. La clave está en:

1. **Entender cuándo usar cada tipo de recorrido**
2. **Practicar la búsqueda de máximos y mínimos**
3. **Dominar los filtros y acumuladores**
4. **Aprender a trabajar con estructuras anidadas** (ArrayList de objetos que contienen ArrayList)

Recuerda: **No uses arrays normales, debes usar ArrayList en todo momento**. Esto te permitirá agregar tantas criptomonedas y operaciones como necesites sin preocuparte por el tamaño fijo.

**¡Éxito en tu implementación! 🚀💰**

---

*Última actualización: 2025*
*Curso: Fundamentos de Programación*
*Prof. [Tu Nombre]*
