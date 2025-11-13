# 🎓 Guía Completa: Sistema de Wallet de Criptomonedas
## Análisis Inductivo - Del Problema al Diseño

---

# PARTE 1: ENUNCIADO DEL PROBLEMA

## 🎯 Contexto

Un trader de criptomonedas necesita un sistema para gestionar su portafolio que le permita:

- Registrar todas sus operaciones de compra y venta
- Calcular automáticamente las comisiones según el día y hora de operación
- Analizar el rendimiento de cada criptomoneda
- Conocer su ganancia o pérdida total
- Identificar cuál criptomoneda le da mejor rentabilidad
- Generar reportes detallados de su actividad

El sistema debe manejar múltiples criptomonedas (Bitcoin, Ethereum, Cardano, etc.) y múltiples operaciones por cada una.

---

## 📐 Reglas de Negocio

### 1. Período del Día
Cada operación se clasifica automáticamente según su hora:
- **Mañana:** 6:00 a 11:59
- **Tarde:** 12:00 a 17:59
- **Noche:** 18:00 a 5:59

### 2. Sistema de Comisiones Variables

Las comisiones se calculan en dos pasos:

**Paso 1 - Comisión Base por Día:**
- Lunes a Viernes: 0.5%
- Sábado: 0.8%
- Domingo: 1.0%

**Paso 2 - Ajuste por Período:**
- Mañana: +0.0%
- Tarde: +0.2%
- Noche: +0.5%

**Comisión Total = Base + Ajuste**

Ejemplo: Operar un sábado a las 10 PM (noche) = 0.8% + 0.5% = 1.3%

### 3. Cálculos Financieros Base

Para cada operación:
- **Monto:** cantidad × precio unitario
- **Comisión en $:** monto × (comisión% / 100)
- **Costo Total (compra):** monto + comisión
- **Ingreso Neto (venta):** monto - comisión

---

# PARTE 2: IDENTIFICACIÓN DE ATRIBUTOS

## 🔍 Análisis de Sustantivos

Del enunciado identificamos sustantivos clave:

| Sustantivo | Análisis | Decisión |
|------------|----------|----------|
| **Portafolio/Wallet** | Contenedor principal, gestiona múltiples criptomonedas | **Clase** |
| **Criptomoneda** | Entidad con identidad propia (Bitcoin, Ethereum) y su historial | **Clase** |
| **Operación** | Transacción individual con datos específicos | **Clase** |
| Tipo (Compra/Venta) | Dato que el usuario ingresa | Atributo en Operacion |
| Cantidad | Dato que el usuario ingresa | Atributo en Operacion |
| Precio | Dato que el usuario ingresa | Atributo en Operacion |
| Día | Dato que el usuario ingresa | Atributo en Operacion |
| Hora | Dato que el usuario ingresa | Atributo en Operacion |
| Nombre cripto | Dato que el usuario ingresa | Atributo en Criptomoneda |
| Símbolo | Dato que el usuario ingresa | Atributo en Criptomoneda |
| Dueño | Dato que el usuario ingresa | Atributo en Wallet |
| Monto | Se CALCULA (cantidad × precio) | NO es atributo |
| Período | Se DERIVA de la hora | NO es atributo |
| Comisión | Se CALCULA según reglas | NO es atributo |
| Ganancia | Se CALCULA de operaciones | NO es atributo |

**Resultado:** 3 clases, 10 atributos totales

---

## ✅ Atributos por Clase

### Clase `Operacion` - 5 atributos

**Pregunta:** ¿Qué datos debe proporcionar el usuario para registrar una operación?

**Respuesta:**
1. `tipo` (String) - "Compra" o "Venta"
2. `cantidad` (double) - Cuántas unidades negoció
3. `precioUnitario` (double) - Precio por unidad en dólares
4. `dia` (String) - Día de la semana
5. `hora` (int) - Hora en formato 24h (0-23)

**Principio:** Solo almacenamos lo que el usuario ingresa. Todo lo demás (monto, comisión, período) se calcula.

---

### Clase `Criptomoneda` - 3 atributos

**Pregunta:** ¿Qué define a una criptomoneda y qué debe recordar?

**Respuesta:**
1. `nombre` (String) - Nombre completo (ej: "Bitcoin")
2. `simbolo` (String) - Identificador único (ej: "BTC")
3. `operaciones` (ArrayList\<Operacion\>) - Historial completo de transacciones

**Principio:** Solo identidad + historial. Todo análisis (cantidades, promedios, ganancias) se calcula recorriendo el ArrayList.

---

### Clase `Wallet` - 2 atributos

**Pregunta:** ¿Qué define a un portafolio?

**Respuesta:**
1. `nombreDueno` (String) - Dueño del portafolio
2. `criptomonedas` (ArrayList\<Criptomoneda\>) - Colección de criptomonedas

**Principio:** Solo dueño + colección. Todo análisis del portafolio se calcula recorriendo las criptomonedas.

---

## 📊 Resumen de Atributos

```
Operacion:     5 atributos (datos de entrada del usuario)
Criptomoneda:  3 atributos (identidad + historial)
Wallet:        2 atributos (dueño + colección)
───────────────────────────────────────────
TOTAL:        10 atributos
```

**Regla de oro:** Almacena solo lo que el usuario INGRESA. Calcula todo lo demás.

---

# PARTE 3: DE REQUISITOS A MÉTODOS

## 📋 Distribución de Métodos por Clase

Antes de profundizar en cada método, aquí está la distribución completa:

### Clase `Operacion` - 6 métodos (REQ-1 al REQ-6)
1. `getPeriodo()` - Determinar período del día
2. `getMontoOperacion()` - Calcular monto total
3. `getComisionPorcentaje()` - Calcular porcentaje de comisión
4. `getComisionDolares()` - Calcular comisión en dólares
5. `getCostoTotal()` - Calcular costo total de compra
6. `getIngresoNeto()` - Calcular ingreso neto de venta

### Clase `Criptomoneda` - 20 métodos (REQ-7 al REQ-26)
7. `agregarOperacion()` - Registrar nueva operación
8. `getCantidadComprada()` - Total de unidades compradas
9. `getCantidadVendida()` - Total de unidades vendidas
10. `getCantidadActual()` - Unidades disponibles actualmente
11. `getDineroInvertido()` - Total invertido en compras
12. `getDineroRecuperado()` - Total recuperado en ventas
13. `getComisionesTotales()` - Comisiones pagadas en total
14. `getPrecioPromedioCompra()` - Precio promedio de compra
15. `getPrecioPromedioVenta()` - Precio promedio de venta
16. `getGananciaRealizada()` - Ganancia de operaciones cerradas
17. `getRentabilidadPorcentaje()` - Rentabilidad porcentual
18. `tieneVentas()` - Verificar si hay ventas
19. `getEstado()` - Estado de la inversión
20. `obtenerOperacionesPorTipo()` - Filtrar por tipo
21. `obtenerOperacionesPorDia()` - Filtrar por día
22. `obtenerOperacionesPorPeriodo()` - Filtrar por período
23. `obtenerComisionMasAlta()` - Operación con mayor comisión
24. `obtenerComisionMasBaja()` - Operación con menor comisión
25. **`getGananciaNoRealizada(double precioActual)`** - Ganancia potencial no realizada
26. **`getPrecioBreakEven()`** - Precio de punto de equilibrio

### Clase `Wallet` - 28 métodos (REQ-27 al REQ-54)
27. `agregarCriptomoneda()` - Agregar cripto al portafolio
28. `buscarCriptomoneda()` - Buscar por símbolo
29. `existeCriptomoneda()` - Verificar existencia
30. `registrarCompra()` - Registrar compra
31. `registrarVenta()` - Registrar venta
32. `calcularValorTotalInvertido()` - Inversión total
33. `calcularValorTotalRecuperado()` - Recuperación total
34. `calcularGananciaTotalPortafolio()` - Ganancia total
35. `calcularComisionesTotalesPortafolio()` - Comisiones totales
36. `calcularPorcentajeComisionesSobreGanancias()` - % comisiones
37. `obtenerCriptoConMejorRentabilidad()` - Mejor inversión
38. `obtenerCriptoConPeorRentabilidad()` - Peor inversión
39. `obtenerCriptosConGanancias()` - Lista con ganancias
40. `obtenerCriptosConPerdidas()` - Lista con pérdidas
41. `obtenerCriptosSinVentas()` - Holdings puros
42. `obtenerCriptoConMasOperaciones()` - Más activa
43. `contarTotalOperaciones()` - Total de transacciones
44. `contarOperacionesPorTipo()` - Contar por tipo
45. `obtenerOperacionesPorDia()` - Consolidado por día
46. `obtenerOperacionesPorPeriodo()` - Consolidado por período
47. `obtenerOperacionMasGrande()` - Operación más grande
48. `obtenerOperacionesConComisionAlta()` - Operaciones costosas
49. `obtenerDiaMasOperado()` - Día más activo
50. `obtenerPeriodoMasOperado()` - Período más activo
51. `obtenerDiasOperados()` - Días únicos
52. `generarReporteCompleto()` - Reporte completo

**Total: 54 métodos**

---

## 📝 Clase `Operacion`

### REQ-1: Determinar el período del día automáticamente

**Contexto:** El sistema de comisiones penaliza operar de noche. El usuario solo ingresa la hora (ej: 22), el sistema debe clasificarla automáticamente en "Mañana", "Tarde" o "Noche".

**Ejemplo:**
- Usuario registra operación a las 9 → debe clasificarse como "Mañana"
- Usuario registra operación a las 14 → debe clasificarse como "Tarde"
- Usuario registra operación a las 22 → debe clasificarse como "Noche"

**Método resultante:**
```java
public String getPeriodo()
```

**Pasos del cálculo:**
1. Tomar el valor del atributo `hora` (ejemplo: 22)
2. Verificar si hora está entre 6 y 11 → retornar "Mañana"
3. Si no, verificar si hora está entre 12 y 17 → retornar "Tarde"
4. Si no cumple ninguna → retornar "Noche"

**Ejemplo de ejecución:**
- `hora = 22`
- ¿22 está entre 6 y 11? NO
- ¿22 está entre 12 y 17? NO
- Entonces retorna "Noche"

**Por qué es necesario:** Este valor se usa para calcular el ajuste de comisión según el período.

**Patrón:** Decisión lógica con rangos

---

### REQ-2: Calcular el monto total de la operación

**Contexto:** El usuario dice "Compré 0.5 BTC a 45000 cada uno". Necesitamos saber el valor total de esa transacción antes de aplicar comisiones.

**Ejemplo:**
- Compré 0.5 BTC a $45,000 cada uno
- Monto total = 0.5 × 45,000 = $22,500

**Método resultante:**
```java
public double getMontoOperacion()
```

**Pasos del cálculo:**
1. Tomar el valor de `cantidad` (ejemplo: 0.5)
2. Tomar el valor de `precioUnitario` (ejemplo: 45000)
3. Multiplicar cantidad × precioUnitario
4. Retornar el resultado

**Ejemplo de ejecución:**
- `cantidad = 0.5`
- `precioUnitario = 45000`
- Cálculo: 0.5 × 45000 = 22500
- Retorna 22500.0

**Por qué es necesario:** Base para calcular comisiones y saber cuánto dinero se mueve en la operación.

**Patrón:** Cálculo simple

---

### REQ-3: Calcular el porcentaje de comisión aplicable

**Contexto:** La comisión varía según el día (fin de semana más caro) y el período (noche más caro). Debemos aplicar ambas reglas.

**Ejemplo:**
- Operación el sábado a las 22:00
- Comisión base (sábado) = 0.8%
- Período (noche) = +0.5%
- Comisión total = 0.8 + 0.5 = 1.3%

**Método resultante:**
```java
public double getComisionPorcentaje()
```

**Pasos del cálculo:**

**PASO 1: Determinar comisión base por día**
1. Tomar el valor de `dia` (ejemplo: "Sábado")
2. Si es Lunes, Martes, Miércoles, Jueves o Viernes → base = 0.5
3. Si es Sábado → base = 0.8
4. Si es Domingo → base = 1.0

**PASO 2: Determinar ajuste por período**
5. Llamar al método `getPeriodo()` (ejemplo: retorna "Noche")
6. Si periodo es "Mañana" → ajuste = 0.0
7. Si periodo es "Tarde" → ajuste = 0.2
8. Si periodo es "Noche" → ajuste = 0.5

**PASO 3: Sumar**
9. Sumar base + ajuste
10. Retornar el resultado

**Ejemplo de ejecución:**
- `dia = "Sábado"`
- `hora = 22` (que da período "Noche")
- Base: "Sábado" → 0.8
- Ajuste: "Noche" → 0.5
- Comisión total: 0.8 + 0.5 = 1.3
- Retorna 1.3

**Por qué es necesario:** Determinar cuánto porcentaje se cobrará de comisión en esta operación específica.

**Patrón:** Decisión lógica con dos criterios

---

### REQ-4: Calcular la comisión en dólares

**Contexto:** Saber que la comisión es 1.3% no es suficiente. Necesitamos saber cuántos dólares reales se pagan.

**Ejemplo:**
- Monto de operación = $22,500
- Comisión = 1.3%
- Comisión en dólares = $22,500 × 0.013 = $292.50

**Método resultante:**
```java
public double getComisionDolares()
```

**Pasos del cálculo:**
1. Llamar a `getMontoOperacion()` para obtener el monto (ejemplo: 22500)
2. Llamar a `getComisionPorcentaje()` para obtener el % (ejemplo: 1.3)
3. Dividir el porcentaje entre 100 para convertirlo a decimal (1.3 / 100 = 0.013)
4. Multiplicar monto × decimal (22500 × 0.013)
5. Retornar el resultado

**Ejemplo de ejecución:**
- Monto = 22500
- Porcentaje = 1.3
- Cálculo: 22500 × (1.3 / 100) = 22500 × 0.013 = 292.5
- Retorna 292.5

**Por qué es necesario:** Conocer el costo monetario real de la comisión.

**Patrón:** Cálculo derivado (usa otros métodos)

---

### REQ-5: Calcular cuánto dinero sale de la cuenta en una compra

**Contexto:** Al comprar criptomonedas, no solo pagas el precio, también pagas la comisión. Necesitamos saber el costo total.

**Ejemplo:**
- Compra de 0.5 BTC a $45,000
- Monto = $22,500
- Comisión = $292.50
- Costo total = $22,500 + $292.50 = $22,792.50

**Método resultante:**
```java
public double getCostoTotal()
```

**Pasos del cálculo:**
1. Verificar el atributo `tipo` (ejemplo: "Compra")
2. Si tipo es "Compra":
   - Llamar a `getMontoOperacion()` (ejemplo: 22500)
   - Llamar a `getComisionDolares()` (ejemplo: 292.5)
   - Sumar monto + comisión
   - Retornar la suma
3. Si tipo es "Venta":
   - Retornar 0

**Ejemplo de ejecución (Compra):**
- `tipo = "Compra"`
- Monto = 22500
- Comisión = 292.5
- Costo total = 22500 + 292.5 = 22792.5
- Retorna 22792.5

**Ejemplo de ejecución (Venta):**
- `tipo = "Venta"`
- Retorna 0 (porque en una venta no SALE dinero, ENTRA)

**Por qué es necesario:** Saber cuánto dinero realmente sale de mi cuenta al comprar.

**Patrón:** Cálculo condicional según tipo

---

### REQ-6: Calcular cuánto dinero entra a la cuenta en una venta

**Contexto:** Al vender criptomonedas, no recibes el monto completo porque se descuenta la comisión.

**Ejemplo:**
- Venta de 0.3 BTC a $52,000
- Monto = $15,600
- Comisión = $203
- Ingreso neto = $15,600 - $203 = $15,397

**Método resultante:**
```java
public double getIngresoNeto()
```

**Pasos del cálculo:**
1. Verificar el atributo `tipo` (ejemplo: "Venta")
2. Si tipo es "Venta":
   - Llamar a `getMontoOperacion()` (ejemplo: 15600)
   - Llamar a `getComisionDolares()` (ejemplo: 203)
   - Restar monto - comisión
   - Retornar el resultado
3. Si tipo es "Compra":
   - Retornar 0

**Ejemplo de ejecución (Venta):**
- `tipo = "Venta"`
- Monto = 15600
- Comisión = 203
- Ingreso neto = 15600 - 203 = 15397
- Retorna 15397

**Ejemplo de ejecución (Compra):**
- `tipo = "Compra"`
- Retorna 0 (porque en una compra no ENTRA dinero, SALE)

**Por qué es necesario:** Saber cuánto dinero realmente entra a mi cuenta al vender.

**Patrón:** Cálculo condicional según tipo

---

## 📝 Clase `Criptomoneda`

### REQ-7: Registrar una nueva operación

**Contexto:** El usuario realiza una compra o venta. Necesitamos agregar esta transacción al historial de la criptomoneda.

**Ejemplo:**
- Usuario dice: "Compré 0.5 BTC a $45,000 el lunes a las 9"
- Debemos crear una operación y agregarla al ArrayList

**Método resultante:**
```java
public void agregarOperacion(String tipo, double cantidad, double precioUnitario, String dia, int hora)
```

**Pasos:**
1. Recibir los 5 parámetros (ejemplo: "Compra", 0.5, 45000, "Lunes", 9)
2. Crear un objeto Operacion: `Operacion op = new Operacion("Compra", 0.5, 45000, "Lunes", 9)`
3. Agregar el objeto al ArrayList: `operaciones.add(op)`

**Ejemplo de ejecución:**
- Parámetros recibidos: "Compra", 0.5, 45000.0, "Lunes", 9
- Se crea: `new Operacion("Compra", 0.5, 45000.0, "Lunes", 9)`
- Se agrega al ArrayList `operaciones`
- Ahora el ArrayList tiene una operación más

**Por qué es necesario:** Construir el historial de transacciones.

**Nota pedagógica:** El método NO recibe un objeto ya creado, recibe los datos sueltos para que el estudiante practique la instanciación.

**Patrón:** Instanciación y agregación

---

### REQ-8: Calcular cuántas unidades se han comprado en total

**Contexto:** El usuario ha hecho múltiples compras en diferentes momentos. Necesitamos saber el total acumulado.

**Ejemplo:**
Historial de operaciones de Bitcoin:
1. Compra: 0.5 BTC
2. Compra: 0.3 BTC
3. Venta: 0.2 BTC
4. Compra: 0.1 BTC

Cantidad comprada = 0.5 + 0.3 + 0.1 = 0.9 BTC (ignoramos la venta)

**Método resultante:**
```java
public double getCantidadComprada()
```

**Pasos del cálculo:**
1. Crear una variable `total` inicializada en 0
2. Recorrer el ArrayList `operaciones` uno por uno
3. Por cada operación:
   - Verificar si su tipo es "Compra"
   - Si es compra: sumar su cantidad al total
   - Si no es compra: ignorarla y continuar
4. Al terminar el recorrido, retornar el total

**Ejemplo de ejecución:**
```
ArrayList operaciones tiene 4 elementos:
  [0]: Operacion(tipo="Compra", cantidad=0.5, ...)
  [1]: Operacion(tipo="Compra", cantidad=0.3, ...)
  [2]: Operacion(tipo="Venta", cantidad=0.2, ...)
  [3]: Operacion(tipo="Compra", cantidad=0.1, ...)

Proceso:
  total = 0
  Revisar [0]: tipo="Compra" → total = 0 + 0.5 = 0.5
  Revisar [1]: tipo="Compra" → total = 0.5 + 0.3 = 0.8
  Revisar [2]: tipo="Venta" → ignorar
  Revisar [3]: tipo="Compra" → total = 0.8 + 0.1 = 0.9

Retorna: 0.9
```

**Por qué es necesario:** Base para calcular cuánto poseemos y precios promedio.

**Patrón:** Acumulador con filtro

---

### REQ-9: Calcular cuántas unidades se han vendido en total

**Contexto:** Similar al anterior, pero para ventas.

**Ejemplo:**
Usando el mismo historial:
1. Compra: 0.5 BTC
2. Compra: 0.3 BTC
3. Venta: 0.2 BTC
4. Compra: 0.1 BTC

Cantidad vendida = 0.2 BTC (solo la venta)

**Método resultante:**
```java
public double getCantidadVendida()
```

**Pasos del cálculo:**
1. Crear una variable `total` inicializada en 0
2. Recorrer el ArrayList `operaciones`
3. Por cada operación:
   - Verificar si su tipo es "Venta"
   - Si es venta: sumar su cantidad al total
   - Si no es venta: ignorarla
4. Retornar el total

**Ejemplo de ejecución:**
```
ArrayList operaciones (mismo de antes)

Proceso:
  total = 0
  Revisar [0]: tipo="Compra" → ignorar
  Revisar [1]: tipo="Compra" → ignorar
  Revisar [2]: tipo="Venta" → total = 0 + 0.2 = 0.2
  Revisar [3]: tipo="Compra" → ignorar

Retorna: 0.2
```

**Por qué es necesario:** Saber cuánto hemos vendido para calcular cantidad actual.

**Patrón:** Acumulador con filtro

---

### REQ-10: Calcular cuántas unidades tenemos disponibles actualmente

**Contexto:** Balance actual = lo que compré - lo que vendí

**Ejemplo:**
- Total comprado: 0.9 BTC
- Total vendido: 0.2 BTC
- Cantidad actual: 0.9 - 0.2 = 0.7 BTC

**Método resultante:**
```java
public double getCantidadActual()
```

**Pasos del cálculo:**
1. Llamar a `getCantidadComprada()` → obtener 0.9
2. Llamar a `getCantidadVendida()` → obtener 0.2
3. Restar comprada - vendida → 0.9 - 0.2
4. Retornar el resultado → 0.7

**Ejemplo de ejecución:**
- Cantidad comprada = 0.9
- Cantidad vendida = 0.2
- Cálculo: 0.9 - 0.2 = 0.7
- Retorna 0.7

**Por qué es necesario:** Saber cuántas unidades poseemos AHORA.

**Patrón:** Cálculo derivado (usa otros métodos)

---

### REQ-11: Calcular cuánto dinero hemos invertido comprando

**Contexto:** Sumar el valor de todas las compras (sin contar comisiones).

**Ejemplo:**
Operaciones de Bitcoin:
1. Compra: 0.5 BTC a $45,000 → monto = $22,500
2. Compra: 0.3 BTC a $44,000 → monto = $13,200
3. Venta: 0.2 BTC a $52,000 → ignorar
4. Compra: 0.1 BTC a $46,000 → monto = $4,600

Dinero invertido = $22,500 + $13,200 + $4,600 = $40,300

**Método resultante:**
```java
public double getDineroInvertido()
```

**Pasos del cálculo:**
1. Crear variable `total` = 0
2. Recorrer el ArrayList `operaciones`
3. Por cada operación:
   - Verificar si tipo es "Compra"
   - Si es compra:
     - Llamar a `operacion.getMontoOperacion()`
     - Sumar ese monto al total
   - Si no es compra: ignorar
4. Retornar total

**Ejemplo de ejecución:**
```
ArrayList operaciones:
  [0]: Compra, cantidad=0.5, precio=45000 → monto=22500
  [1]: Compra, cantidad=0.3, precio=44000 → monto=13200
  [2]: Venta, cantidad=0.2, precio=52000 → monto=10400
  [3]: Compra, cantidad=0.1, precio=46000 → monto=4600

Proceso:
  total = 0
  [0]: tipo="Compra" → monto=22500 → total = 0 + 22500 = 22500
  [1]: tipo="Compra" → monto=13200 → total = 22500 + 13200 = 35700
  [2]: tipo="Venta" → ignorar
  [3]: tipo="Compra" → monto=4600 → total = 35700 + 4600 = 40300

Retorna: 40300
```

**Por qué es necesario:** Base para calcular precio promedio de compra.

**Patrón:** Acumulador con filtro

---

### REQ-12: Calcular cuánto dinero hemos recuperado vendiendo

**Contexto:** Sumar el valor de todas las ventas (sin contar comisiones).

**Ejemplo:**
Usando el mismo historial, solo hay una venta:
- Venta: 0.2 BTC a $52,000 → monto = $10,400

Dinero recuperado = $10,400

**Método resultante:**
```java
public double getDineroRecuperado()
```

**Pasos del cálculo:**
1. Crear variable `total` = 0
2. Recorrer el ArrayList `operaciones`
3. Por cada operación:
   - Verificar si tipo es "Venta"
   - Si es venta: sumar su monto al total
   - Si no: ignorar
4. Retornar total

**Ejemplo de ejecución:**
```
(Mismo ArrayList de antes)

Proceso:
  total = 0
  [0]: tipo="Compra" → ignorar
  [1]: tipo="Compra" → ignorar
  [2]: tipo="Venta" → monto=10400 → total = 0 + 10400 = 10400
  [3]: tipo="Compra" → ignorar

Retorna: 10400
```

**Por qué es necesario:** Base para calcular precio promedio de venta y ganancias.

**Patrón:** Acumulador con filtro

---

### REQ-13: Calcular cuánto hemos pagado en comisiones

**Contexto:** Cada operación (compra O venta) tiene una comisión. Necesitamos el total.

**Ejemplo:**
```
Operaciones:
  [0]: Compra → comisión = $112.50
  [1]: Compra → comisión = $66.00
  [2]: Venta → comisión = $135.20
  [3]: Compra → comisión = $23.00
```

Comisiones totales = $112.50 + $66 + $135.20 + $23 = $336.70

**Método resultante:**
```java
public double getComisionesTotales()
```

**Pasos del cálculo:**
1. Crear variable `total` = 0
2. Recorrer el ArrayList `operaciones`
3. Por cada operación (SIN importar el tipo):
   - Llamar a `operacion.getComisionDolares()`
   - Sumar esa comisión al total
4. Retornar total

**Ejemplo de ejecución:**
```
Proceso:
  total = 0
  [0]: comisión=112.50 → total = 0 + 112.50 = 112.50
  [1]: comisión=66.00 → total = 112.50 + 66.00 = 178.50
  [2]: comisión=135.20 → total = 178.50 + 135.20 = 313.70
  [3]: comisión=23.00 → total = 313.70 + 23.00 = 336.70

Retorna: 336.70
```

**Por qué es necesario:** Medir el impacto de las comisiones en nuestra inversión.

**Patrón:** Acumulador simple (sin filtro, todas las operaciones)

---

### REQ-14: Calcular el precio promedio al que compramos

**Contexto:** Si compré 2 unidades a $100 y 3 unidades a $150, mi precio promedio ponderado es:
- Total invertido: (2 × $100) + (3 × $150) = $200 + $450 = $650
- Total comprado: 2 + 3 = 5
- Precio promedio: $650 / 5 = $130

**Ejemplo con nuestros datos:**
- Dinero invertido: $40,300
- Cantidad comprada: 0.9 BTC
- Precio promedio: $40,300 / 0.9 = $44,777.78 por BTC

**Método resultante:**
```java
public double getPrecioPromedioCompra()
```

**Pasos del cálculo:**
1. Llamar a `getCantidadComprada()` → ejemplo: 0.9
2. Verificar si cantidad > 0 (para evitar división por cero)
3. Si cantidad > 0:
   - Llamar a `getDineroInvertido()` → ejemplo: 40300
   - Dividir dinero / cantidad → 40300 / 0.9
   - Retornar el resultado
4. Si cantidad = 0:
   - Retornar 0

**Ejemplo de ejecución:**
- Cantidad comprada = 0.9
- ¿0.9 > 0? SÍ
- Dinero invertido = 40300
- Cálculo: 40300 / 0.9 = 44777.777...
- Retorna 44777.777

**Por qué es necesario:** Saber el costo promedio de cada unidad que poseemos.

**Patrón:** Cálculo derivado con validación

---

### REQ-15: Calcular el precio promedio al que vendimos

**Contexto:** Similar al anterior, para ventas.

**Ejemplo:**
- Dinero recuperado: $10,400
- Cantidad vendida: 0.2 BTC
- Precio promedio: $10,400 / 0.2 = $52,000 por BTC

**Método resultante:**
```java
public double getPrecioPromedioVenta()
```

**Pasos del cálculo:**
1. Llamar a `getCantidadVendida()` → ejemplo: 0.2
2. Verificar si cantidad > 0
3. Si cantidad > 0:
   - Llamar a `getDineroRecuperado()` → ejemplo: 10400
   - Dividir dinero / cantidad → 10400 / 0.2
   - Retornar el resultado
4. Si cantidad = 0:
   - Retornar 0

**Ejemplo de ejecución:**
- Cantidad vendida = 0.2
- ¿0.2 > 0? SÍ
- Dinero recuperado = 10400
- Cálculo: 10400 / 0.2 = 52000
- Retorna 52000.0

**Por qué es necesario:** Comparar con precio promedio de compra para calcular rentabilidad.

**Patrón:** Cálculo derivado con validación

---

### REQ-16: Calcular la ganancia o pérdida realizada

**Contexto:** Ganancia = (lo que recuperé vendiendo) - (lo que me costó lo que vendí)

**Ejemplo:**
- Vendí 0.2 BTC
- Precio promedio de compra: $44,777.78
- Lo que me costó lo vendido: 0.2 × $44,777.78 = $8,955.56
- Lo que recuperé: $10,400
- Ganancia: $10,400 - $8,955.56 = $1,444.44

**Método resultante:**
```java
public double getGananciaRealizada()
```

**Pasos del cálculo:**
1. Llamar a `getCantidadVendida()` → ejemplo: 0.2
2. Verificar si cantidad vendida > 0
3. Si hay ventas:
   - Llamar a `getDineroRecuperado()` → ejemplo: 10400
   - Llamar a `getCantidadVendida()` → ejemplo: 0.2
   - Llamar a `getPrecioPromedioCompra()` → ejemplo: 44777.78
   - Calcular costo de lo vendido: 0.2 × 44777.78 = 8955.556
   - Calcular ganancia: 10400 - 8955.556 = 1444.444
   - Retornar ganancia
4. Si no hay ventas:
   - Retornar 0

**Ejemplo de ejecución:**
- Cantidad vendida = 0.2
- ¿0.2 > 0? SÍ
- Recuperado = 10400
- Costo de lo vendido = 0.2 × 44777.78 = 8955.556
- Ganancia = 10400 - 8955.556 = 1444.444
- Retorna 1444.444

**Por qué es necesario:** Saber si estamos ganando o perdiendo dinero.

**Patrón:** Cálculo derivado con lógica condicional

---

### REQ-17: Calcular la rentabilidad porcentual

**Contexto:** Rentabilidad % = ((precio venta - precio compra) / precio compra) × 100

**Ejemplo:**
- Precio promedio compra: $44,777.78
- Precio promedio venta: $52,000
- Diferencia: $52,000 - $44,777.78 = $7,222.22
- Rentabilidad: ($7,222.22 / $44,777.78) × 100 = 16.13%

**Método resultante:**
```java
public double getRentabilidadPorcentaje()
```

**Pasos del cálculo:**
1. Llamar a `tieneVentas()` (método que veremos después)
2. Llamar a `getPrecioPromedioCompra()` → ejemplo: 44777.78
3. Verificar si tiene ventas Y precio compra > 0
4. Si ambas condiciones se cumplen:
   - Llamar a `getPrecioPromedioVenta()` → ejemplo: 52000
   - Calcular diferencia: 52000 - 44777.78 = 7222.22
   - Dividir entre precio compra: 7222.22 / 44777.78 = 0.1613
   - Multiplicar por 100: 0.1613 × 100 = 16.13
   - Retornar 16.13
5. Si no cumple:
   - Retornar 0

**Ejemplo de ejecución:**
- Tiene ventas: SÍ
- Precio compra = 44777.78, ¿> 0? SÍ
- Precio venta = 52000
- Cálculo: ((52000 - 44777.78) / 44777.78) × 100
- = (7222.22 / 44777.78) × 100
- = 0.1613 × 100 = 16.13
- Retorna 16.13

**Por qué es necesario:** Comparar desempeño entre diferentes criptomonedas.

**Patrón:** Cálculo derivado con validación

---

### REQ-18: Verificar si hay operaciones de venta

**Contexto:** Muchos cálculos solo tienen sentido si hay ventas. Necesitamos verificar rápidamente.

**Ejemplo:**
```
Operaciones:
  [0]: Compra
  [1]: Compra
  [2]: Venta ← encontramos una venta
  [3]: Compra

Resultado: true (sí hay ventas)
```

**Método resultante:**
```java
public boolean tieneVentas()
```

**Pasos:**
1. Recorrer el ArrayList `operaciones`
2. Por cada operación:
   - Verificar si su tipo es "Venta"
   - Si encontramos una venta: retornar `true` inmediatamente (no seguir buscando)
3. Si terminamos de recorrer todo y no encontramos ninguna:
   - Retornar `false`

**Ejemplo de ejecución:**
```
Proceso:
  Revisar [0]: tipo="Compra" → continuar
  Revisar [1]: tipo="Compra" → continuar
  Revisar [2]: tipo="Venta" → ¡encontrada! → retornar true inmediatamente
  (ya no revisamos [3])

Retorna: true
```

**Ejemplo sin ventas:**
```
Operaciones solo de compras:
  [0]: Compra
  [1]: Compra
  [2]: Compra

Proceso:
  Revisar todas → ninguna es venta
  Terminar recorrido

Retorna: false
```

**Por qué es necesario:** Validación previa para cálculos de rentabilidad y ganancia.

**Patrón:** Búsqueda booleana con salida temprana

---

### REQ-19: Clasificar el estado de la inversión

**Contexto:** Queremos una clasificación simple para reportes.

**Ejemplo 1:** Tiene ventas y ganancia positiva → "Ganancia"
**Ejemplo 2:** Tiene ventas y ganancia negativa → "Pérdida"
**Ejemplo 3:** No tiene ventas → "Sin ventas"

**Método resultante:**
```java
public String getEstado()
```

**Pasos:**
1. Llamar a `tieneVentas()`
2. Si NO tiene ventas:
   - Retornar "Sin ventas"
3. Si tiene ventas:
   - Llamar a `getGananciaRealizada()` → ejemplo: 1444.44
   - Si ganancia > 0:
     - Retornar "Ganancia"
   - Si ganancia ≤ 0:
     - Retornar "Pérdida"

**Ejemplo de ejecución 1:**
- Tiene ventas: SÍ
- Ganancia realizada: 1444.44
- ¿1444.44 > 0? SÍ
- Retorna "Ganancia"

**Ejemplo de ejecución 2 (sin ventas):**
- Tiene ventas: NO
- Retorna "Sin ventas"

**Por qué es necesario:** Clasificación rápida para reportes.

**Patrón:** Decisión lógica

---

### REQ-20: Obtener todas las operaciones de un tipo específico

**Contexto:** Queremos analizar solo las compras o solo las ventas por separado.

**Ejemplo:**
```
Operaciones:
  [0]: Compra, cantidad=0.5
  [1]: Compra, cantidad=0.3
  [2]: Venta, cantidad=0.2
  [3]: Compra, cantidad=0.1

Si pedimos tipo="Compra", debe retornar: [0], [1], [3]
```

**Método resultante:**
```java
public ArrayList<Operacion> obtenerOperacionesPorTipo(String tipo)
```

**Pasos:**
1. Crear un ArrayList vacío llamado `resultado`
2. Recorrer el ArrayList `operaciones`
3. Por cada operación:
   - Verificar si su tipo coincide con el parámetro `tipo`
   - Si coincide: agregar esa operación al `resultado`
   - Si no coincide: ignorarla
4. Retornar el ArrayList `resultado`

**Ejemplo de ejecución (tipo="Compra"):**
```
Crear resultado = ArrayList vacío
Revisar [0]: tipo="Compra" → ¿coincide? SÍ → agregar a resultado
Revisar [1]: tipo="Compra" → ¿coincide? SÍ → agregar a resultado
Revisar [2]: tipo="Venta" → ¿coincide? NO → ignorar
Revisar [3]: tipo="Compra" → ¿coincide? SÍ → agregar a resultado

resultado tiene ahora 3 operaciones: [0], [1], [3]
Retorna resultado
```

**Por qué es necesario:** Análisis separado de compras y ventas.

**Patrón:** Filtrado

---

### REQ-21: Obtener todas las operaciones de un día específico

**Contexto:** Ver qué operaciones hicimos un día en particular.

**Ejemplo:**
```
Operaciones:
  [0]: día="Lunes", cantidad=0.5
  [1]: día="Miércoles", cantidad=0.3
  [2]: día="Lunes", cantidad=0.2
  [3]: día="Viernes", cantidad=0.1

Si pedimos dia="Lunes", debe retornar: [0], [2]
```

**Método resultante:**
```java
public ArrayList<Operacion> obtenerOperacionesPorDia(String dia)
```

**Pasos:**
1. Crear ArrayList vacío `resultado`
2. Recorrer `operaciones`
3. Por cada operación:
   - Verificar si su día coincide con el parámetro
   - Si coincide: agregarla al resultado
4. Retornar resultado

**Ejemplo de ejecución (dia="Lunes"):**
```
resultado = vacío
[0]: día="Lunes" → agregar
[1]: día="Miércoles" → ignorar
[2]: día="Lunes" → agregar
[3]: día="Viernes" → ignorar

Retorna ArrayList con 2 operaciones
```

**Por qué es necesario:** Análisis temporal por día de la semana.

**Patrón:** Filtrado

---

### REQ-22: Obtener operaciones de un período específico

**Contexto:** Analizar operaciones de mañana, tarde o noche.

**Ejemplo:**
```
Operaciones:
  [0]: hora=9 → período="Mañana"
  [1]: hora=14 → período="Tarde"
  [2]: hora=22 → período="Noche"
  [3]: hora=10 → período="Mañana"

Si pedimos periodo="Mañana", debe retornar: [0], [3]
```

**Método resultante:**
```java
public ArrayList<Operacion> obtenerOperacionesPorPeriodo(String periodo)
```

**Pasos:**
1. Crear ArrayList vacío `resultado`
2. Recorrer `operaciones`
3. Por cada operación:
   - Llamar a `operacion.getPeriodo()`
   - Si el período coincide con el parámetro: agregarla
4. Retornar resultado

**Ejemplo de ejecución (periodo="Mañana"):**
```
resultado = vacío
[0]: getPeriodo()="Mañana" → agregar
[1]: getPeriodo()="Tarde" → ignorar
[2]: getPeriodo()="Noche" → ignorar
[3]: getPeriodo()="Mañana" → agregar

Retorna ArrayList con 2 operaciones
```

**Por qué es necesario:** Identificar en qué franja horaria operamos más.

**Patrón:** Filtrado

---

### REQ-23: Encontrar la operación con la comisión más alta

**Contexto:** Identificar cuál operación nos costó más en comisiones.

**Ejemplo:**
```
Operaciones:
  [0]: comisión=$112.50
  [1]: comisión=$66.00
  [2]: comisión=$203.00 ← la más alta
  [3]: comisión=$23.00
```

**Método resultante:**
```java
public Operacion obtenerComisionMasAlta()
```

**Pasos:**
1. Verificar si el ArrayList está vacío → si está vacío, retornar null
2. Tomar la primera operación como "máximo provisional"
3. Obtener su comisión y guardarla como "comisión máxima"
4. Recorrer las demás operaciones (desde la segunda)
5. Por cada operación:
   - Obtener su comisión
   - Comparar con la comisión máxima actual
   - Si es mayor: actualizar el máximo y la operación máxima
6. Retornar la operación con mayor comisión

**Ejemplo de ejecución:**
```
¿ArrayList vacío? NO

Paso inicial:
  operacionMax = operaciones[0] (comisión=$112.50)
  comisionMax = 112.50

Recorrer desde [1]:
  [1]: comisión=66.00 → ¿66 > 112.50? NO → no cambiar
  [2]: comisión=203.00 → ¿203 > 112.50? SÍ → operacionMax=[2], comisionMax=203
  [3]: comisión=23.00 → ¿23 > 203? NO → no cambiar

Retorna operaciones[2]
```

**Por qué es necesario:** Optimizar horarios de trading.

**Patrón:** Búsqueda de máximo

---

### REQ-24: Encontrar la operación con la comisión más baja

**Contexto:** Identificar el mejor caso para replicarlo.

**Ejemplo:**
Usando el mismo ejemplo, la comisión más baja es $23 (operación [3])

**Método resultante:**
```java
public Operacion obtenerComisionMasBaja()
```

**Pasos:**
1. Verificar si el ArrayList está vacío → retornar null si está vacío
2. Tomar la primera operación como "mínimo provisional"
3. Obtener su comisión como "comisión mínima"
4. Recorrer las demás operaciones
5. Por cada una:
   - Si su comisión es MENOR que el mínimo actual: actualizar
6. Retornar la operación con menor comisión

**Ejemplo de ejecución:**
```
operacionMin = operaciones[0] (comisión=$112.50)
comisionMin = 112.50

Recorrer:
  [1]: comisión=66 → ¿66 < 112.50? SÍ → operacionMin=[1], comisionMin=66
  [2]: comisión=203 → ¿203 < 66? NO → no cambiar
  [3]: comisión=23 → ¿23 < 66? SÍ → operacionMin=[3], comisionMin=23

Retorna operaciones[3]
```

**Por qué es necesario:** Identificar mejores prácticas de horario.

**Patrón:** Búsqueda de mínimo

---

### REQ-25: Calcular ganancia no realizada dado un precio de mercado actual

**Contexto:** La ganancia realizada solo considera operaciones YA ejecutadas (compras y ventas cerradas). Pero aún tenemos criptomonedas en nuestro poder que no hemos vendido. Si el precio actual del mercado es diferente al precio promedio que pagamos, tenemos una ganancia o pérdida "en papel" (no realizada).

**¿Por qué necesitamos el precio actual como parámetro?**

El sistema NO conoce automáticamente el precio actual del Bitcoin, Ethereum, etc. Estos precios cambian cada segundo en el mercado. Por eso, el USUARIO debe proporcionarlo. El usuario consulta el precio en un exchange (ej: "Bitcoin está a $48,000 ahora") y nos lo pasa como parámetro.

**Ejemplo:**
- Compramos en total: 0.9 BTC
- Vendimos: 0.2 BTC
- Cantidad actual que poseemos: 0.7 BTC
- Precio promedio que pagamos: $44,777.78 por BTC
- Lo que pagamos por los 0.7 BTC que AÚN tenemos: 0.7 × $44,777.78 = $31,344.45

**Ahora el usuario consulta el precio actual:**
- Precio actual del mercado: $48,000 por BTC
- Lo que VALDRÍA ahora si vendiéramos: 0.7 × $48,000 = $33,600

**Ganancia no realizada:**
- Valor actual - Costo de lo que tenemos
- $33,600 - $31,344.45 = $2,255.55
- Esto significa que si vendiéramos AHORA, ganaríamos $2,255.55 adicionales

**Método resultante:**
```java
public double getGananciaNoRealizada(double precioActual)
```

**Pasos del cálculo:**

**PASO 1: Obtener la cantidad actual que poseemos**
1. Llamar a `getCantidadActual()` → ejemplo: 0.7 BTC

**PASO 2: Verificar si tenemos unidades**
2. Si cantidad actual ≤ 0:
   - Retornar 0 (no tenemos nada, no hay ganancia no realizada)

**PASO 3: Calcular cuánto pagamos por lo que aún tenemos**
3. Llamar a `getPrecioPromedioCompra()` → ejemplo: 44777.78
4. Multiplicar: cantidad actual × precio promedio compra
5. Ejemplo: 0.7 × 44777.78 = 31344.446 (lo que PAGAMOS)

**PASO 4: Calcular cuánto vale ahora en el mercado**
6. Tomar el parámetro `precioActual` → ejemplo: 48000
7. Multiplicar: cantidad actual × precio actual
8. Ejemplo: 0.7 × 48000 = 33600 (lo que VALE ahora)

**PASO 5: Calcular la diferencia**
9. Restar: valor actual - costo pagado
10. Ejemplo: 33600 - 31344.446 = 2255.554
11. Retornar el resultado

**Ejemplo de ejecución:**
```
Parámetro recibido: precioActual = 48000

Paso 1: Cantidad actual = 0.7 BTC
Paso 2: ¿0.7 > 0? SÍ, continuar

Paso 3: Calcular lo que pagamos
  - Precio promedio compra = 44777.78
  - Costo = 0.7 × 44777.78 = 31344.446

Paso 4: Calcular lo que vale ahora
  - Valor actual = 0.7 × 48000 = 33600

Paso 5: Calcular ganancia
  - Ganancia no realizada = 33600 - 31344.446 = 2255.554

Retorna: 2255.554
```

**Ejemplo con pérdida no realizada:**
```
Si el precio actual fuera $42,000 (bajó en lugar de subir):
  - Valor actual: 0.7 × 42000 = 29400
  - Costo pagado: 31344.446
  - Ganancia no realizada: 29400 - 31344.446 = -1944.446 (pérdida)
```

**Por qué es necesario:** Permite al trader saber si debe vender ahora (si hay ganancia) o esperar (si hay pérdida). Es fundamental para tomar decisiones de trading en tiempo real. La ganancia realizada solo muestra el pasado; la ganancia no realizada muestra el potencial del presente.

**Patrón:** Cálculo derivado con parámetro externo

---

### REQ-26: Calcular el precio de punto de equilibrio (break-even)

**Contexto:** Un trader necesita saber: "¿A qué precio debería vender para NO perder dinero?" Este es el "punto de equilibrio" o "break-even price". Si vendo por ENCIMA de este precio, gano. Si vendo por DEBAJO, pierdo.

**¿Cómo se calcula?**

Debemos recuperar EXACTAMENTE lo que pagamos por las unidades que AÚN tenemos (considerando también las comisiones futuras).

**Ejemplo:**
- Cantidad actual: 0.7 BTC
- Precio promedio de compra: $44,777.78
- Lo que pagamos: 0.7 × $44,777.78 = $31,344.45

**Pero hay un problema:** Cuando vendamos, pagaremos una comisión. Para simplificar, asumiremos la comisión promedio más baja posible (día laboral en la mañana = 0.5% + 0% = 0.5%).

Si vendemos al precio X:
- Monto bruto: 0.7 × X
- Comisión: (0.7 × X) × 0.005
- Ingreso neto: (0.7 × X) - comisión

Para el punto de equilibrio:
- Ingreso neto = Lo que pagamos
- (0.7 × X) - (0.7 × X × 0.005) = 31344.45
- (0.7 × X) × (1 - 0.005) = 31344.45
- (0.7 × X) × 0.995 = 31344.45
- X = 31344.45 / (0.7 × 0.995)
- X = 31344.45 / 0.6965
- X = 45,000.36

**Resultado:** Si vendo a $45,000.36 por BTC, recupero exactamente lo que invertí (ni gano ni pierdo).

**Método resultante:**
```java
public double getPrecioBreakEven()
```

**Pasos del cálculo:**

**PASO 1: Obtener cantidad actual**
1. Llamar a `getCantidadActual()` → ejemplo: 0.7

**PASO 2: Validar que tengamos unidades**
2. Si cantidad ≤ 0:
   - Retornar 0 (no tiene sentido calcular break-even si no tenemos nada)

**PASO 3: Calcular lo que pagamos por lo que tenemos**
3. Llamar a `getPrecioPromedioCompra()` → ejemplo: 44777.78
4. Multiplicar: cantidad × precio promedio
5. Ejemplo: 0.7 × 44777.78 = 31344.446 (esto es lo que DEBEMOS recuperar)

**PASO 4: Considerar la comisión de venta**
6. Definir comisión mínima = 0.5% = 0.005
7. Calcular factor de ajuste: 1 - 0.005 = 0.995
8. Este factor representa que del monto de venta, solo recibiremos el 99.5%

**PASO 5: Calcular el precio necesario**
9. Precio break-even = costo pagado / (cantidad × factor ajuste)
10. Ejemplo: 31344.446 / (0.7 × 0.995)
11. Cálculo: 31344.446 / 0.6965 = 45000.64
12. Retornar el resultado

**Ejemplo de ejecución:**
```
Paso 1: Cantidad actual = 0.7 BTC
Paso 2: ¿0.7 > 0? SÍ, continuar

Paso 3: Calcular costo pagado
  - Precio promedio compra = 44777.78
  - Costo pagado = 0.7 × 44777.78 = 31344.446

Paso 4: Factor de comisión
  - Comisión venta mínima = 0.5% = 0.005
  - Factor de ajuste = 1 - 0.005 = 0.995

Paso 5: Calcular precio break-even
  - Cantidad ajustada = 0.7 × 0.995 = 0.6965
  - Precio break-even = 31344.446 / 0.6965 = 45000.64

Retorna: 45000.64
```

**Interpretación del resultado:**
```
Si el precio break-even es $45,000.64:

- Vender a $46,000 → GANANCIA (está por encima)
- Vender a $45,000.64 → EQUILIBRIO (ni gano ni pierdo)
- Vender a $44,000 → PÉRDIDA (está por debajo)
```

**Ejemplo con otro caso:**
```
Supongamos:
  - Cantidad actual: 1.5 BTC
  - Precio promedio compra: $38,000
  - Costo pagado: 1.5 × 38000 = 57000

Cálculo:
  - Cantidad ajustada: 1.5 × 0.995 = 1.4925
  - Precio break-even: 57000 / 1.4925 = 38193.52

Si vendo a $38,193.52, recupero exactamente mi inversión.
```

**Por qué es necesario:** Este método es CRÍTICO para decisiones de trading. El trader puede:
1. Comparar el precio actual del mercado con su break-even
2. Decidir si debe vender ahora o esperar
3. Establecer "stop-loss" automático en ese precio
4. Saber cuánto margen tiene para negociar

Si el precio actual está MUY por debajo del break-even, el trader sabe que está en riesgo de pérdidas grandes.

**Por qué necesita cálculo:** No podemos simplemente usar el precio promedio de compra, porque:
1. Solo consideramos lo que AÚN tenemos (no todo lo comprado)
2. Debemos considerar la comisión futura de venta
3. Es un cálculo matemático específico para break-even

**Patrón:** Cálculo derivado con ajuste por comisión

---

## 📝 Clase `Wallet`

### REQ-27: Agregar una criptomoneda al portafolio

**Contexto:** El trader quiere empezar a operar con Bitcoin.

**Ejemplo:**
```
Portafolio vacío
Usuario dice: "Agrega Bitcoin (BTC)"
Resultado: crear objeto Criptomoneda y agregarlo
```

**Método resultante:**
```java
public void agregarCriptomoneda(String nombre, String simbolo)
```

**Pasos:**
1. Recibir parámetros (ejemplo: "Bitcoin", "BTC")
2. Verificar si ya existe una cripto con ese símbolo
3. Si NO existe:
   - Crear objeto: `Criptomoneda cripto = new Criptomoneda("Bitcoin", "BTC")`
   - Agregarlo: `criptomonedas.add(cripto)`
4. Si ya existe:
   - No hacer nada (evitar duplicados)

**Ejemplo de ejecución:**
```
Parámetros: "Bitcoin", "BTC"
¿Existe "BTC"? NO
Crear: new Criptomoneda("Bitcoin", "BTC")
Agregar al ArrayList criptomonedas
```

**Por qué es necesario:** Inicializar nuevas inversiones.

**Nota pedagógica:** Recibe datos sueltos para practicar instanciación.

**Patrón:** Instanciación y agregación condicional

---

### REQ-28: Buscar una criptomoneda por símbolo

**Contexto:** Para registrar una operación en Bitcoin, primero debo encontrarlo.

**Ejemplo:**
```
Portafolio tiene:
  [0]: Criptomoneda(nombre="Bitcoin", simbolo="BTC")
  [1]: Criptomoneda(nombre="Ethereum", simbolo="ETH")
  [2]: Criptomoneda(nombre="Cardano", simbolo="ADA")

Buscar "ETH" → debe retornar el objeto [1]
```

**Método resultante:**
```java
public Criptomoneda buscarCriptomoneda(String simbolo)
```

**Pasos:**
1. Recibir símbolo a buscar (ejemplo: "ETH")
2. Recorrer el ArrayList `criptomonedas`
3. Por cada criptomoneda:
   - Obtener su símbolo
   - Comparar con el símbolo buscado
   - Si coincide: retornar esa criptomoneda inmediatamente
4. Si termina el recorrido sin encontrar:
   - Retornar null

**Ejemplo de ejecución:**
```
Buscar "ETH"
Revisar [0]: símbolo="BTC" → ¿es "ETH"? NO → continuar
Revisar [1]: símbolo="ETH" → ¿es "ETH"? SÍ → retornar criptomonedas[1]
(no revisar [2])
```

**Ejemplo sin encontrar:**
```
Buscar "SOL" (no existe)
Revisar [0]: "BTC" ≠ "SOL"
Revisar [1]: "ETH" ≠ "SOL"
Revisar [2]: "ADA" ≠ "SOL"
Terminar recorrido
Retornar null
```

**Por qué es necesario:** Localizar una cripto específica para operaciones.

**Patrón:** Búsqueda lineal

---

### REQ-29: Verificar si existe una criptomoneda

**Contexto:** Antes de agregar Bitcoin, verificar que no esté ya.

**Método resultante:**
```java
public boolean existeCriptomoneda(String simbolo)
```

**Pasos:**
1. Llamar a `buscarCriptomoneda(simbolo)`
2. Si retorna null → retornar false
3. Si retorna un objeto → retornar true

**Ejemplo de ejecución:**
```
existeCriptomoneda("BTC")
Llamar buscarCriptomoneda("BTC")
Resultado: objeto Criptomoneda (no es null)
¿null? NO
Retornar true
```

**Por qué es necesario:** Validación antes de agregar.

**Patrón:** Delegación simple

---

### REQ-30: Registrar una operación de compra

**Contexto:** Usuario dice: "Compré 0.5 BTC a $45,000 el lunes a las 9"

**Método resultante:**
```java
public void registrarCompra(String simbolo, double cantidad, double precio, String dia, int hora)
```

**Pasos:**
1. Recibir parámetros (ejemplo: "BTC", 0.5, 45000, "Lunes", 9)
2. Buscar la criptomoneda: `Criptomoneda cripto = buscarCriptomoneda("BTC")`
3. Verificar si existe (cripto != null)
4. Si existe:
   - Llamar a `cripto.agregarOperacion("Compra", 0.5, 45000, "Lunes", 9)`
5. Si no existe:
   - No hacer nada (o mostrar error)

**Ejemplo de ejecución:**
```
Parámetros: "BTC", 0.5, 45000.0, "Lunes", 9
Buscar "BTC" → encontrado
Llamar: cripto.agregarOperacion("Compra", 0.5, 45000.0, "Lunes", 9)
La operación se agrega al historial de Bitcoin
```

**Por qué es necesario:** Interfaz simple para el usuario.

**Patrón:** Delegación

---

### REQ-31: Registrar una operación de venta

**Contexto:** Similar al anterior pero para ventas.

**Método resultante:**
```java
public void registrarVenta(String simbolo, double cantidad, double precio, String dia, int hora)
```

**Pasos:**
1. Buscar la criptomoneda
2. Si existe: llamar a `agregarOperacion` con tipo "Venta"

**Ejemplo:**
```
registrarVenta("BTC", 0.3, 52000, "Sábado", 22)
Buscar "BTC" → encontrado
Llamar: cripto.agregarOperacion("Venta", 0.3, 52000, "Sábado", 22)
```

**Por qué es necesario:** Interfaz simple para ventas.

**Patrón:** Delegación

---

### REQ-32: Calcular el dinero total invertido en el portafolio

**Contexto:** Sumar lo invertido en TODAS las criptomonedas.

**Ejemplo:**
```
Portafolio tiene:
  Bitcoin: dinero invertido = $40,300
  Ethereum: dinero invertido = $37,200
  Cardano: dinero invertido = $1,310

Total invertido = $40,300 + $37,200 + $1,310 = $78,810
```

**Método resultante:**
```java
public double calcularValorTotalInvertido()
```

**Pasos:**
1. Crear variable `total` = 0
2. Recorrer el ArrayList `criptomonedas`
3. Por cada criptomoneda:
   - Llamar a `cripto.getDineroInvertido()`
   - Sumar ese valor al total
4. Retornar total

**Ejemplo de ejecución:**
```
total = 0
Revisar Bitcoin: getDineroInvertido()=40300 → total = 0 + 40300 = 40300
Revisar Ethereum: getDineroInvertido()=37200 → total = 40300 + 37200 = 77500
Revisar Cardano: getDineroInvertido()=1310 → total = 77500 + 1310 = 78810

Retorna 78810
```

**Por qué es necesario:** Vista global del capital invertido.

**Patrón:** Acumulador sobre colección de objetos

---

### REQ-33: Calcular el dinero total recuperado del portafolio

**Contexto:** Sumar lo recuperado de TODAS las ventas.

**Ejemplo:**
```
Bitcoin: recuperado = $10,400
Ethereum: recuperado = $22,200
Cardano: recuperado = $1,350

Total = $10,400 + $22,200 + $1,350 = $33,950
```

**Método resultante:**
```java
public double calcularValorTotalRecuperado()
```

**Pasos:**
1. Crear variable `total` = 0
2. Recorrer `criptomonedas`
3. Por cada una: sumar su `getDineroRecuperado()`
4. Retornar total

**Ejemplo de ejecución:**
```
total = 0
Bitcoin: 10400 → total = 10400
Ethereum: 22200 → total = 32600
Cardano: 1350 → total = 33950

Retorna 33950
```

**Por qué es necesario:** Saber cuánto hemos recuperado en total.

**Patrón:** Acumulador

---

### REQ-34: Calcular la ganancia total del portafolio

**Contexto:** Sumar ganancias de las criptos QUE TIENEN VENTAS.

**Ejemplo:**
```
Bitcoin: tiene ventas, ganancia = $1,444
Ethereum: tiene ventas, ganancia = $3,600
Cardano: tiene ventas, ganancia = $564
Solana: SIN ventas → ignorar
Ripple: SIN ventas → ignorar

Total ganancia = $1,444 + $3,600 + $564 = $5,608
```

**Método resultante:**
```java
public double calcularGananciaTotalPortafolio()
```

**Pasos:**
1. Crear variable `total` = 0
2. Recorrer `criptomonedas`
3. Por cada criptomoneda:
   - Verificar si tiene ventas
   - Si tiene ventas: sumar su ganancia realizada
   - Si no tiene ventas: ignorarla
4. Retornar total

**Ejemplo de ejecución:**
```
total = 0
Bitcoin: tieneVentas()=true → ganancia=1444 → total=1444
Ethereum: tieneVentas()=true → ganancia=3600 → total=5044
Cardano: tieneVentas()=true → ganancia=564 → total=5608
Solana: tieneVentas()=false → ignorar
Ripple: tieneVentas()=false → ignorar

Retorna 5608
```

**Por qué es necesario:** Resultado financiero final del portafolio.

**Patrón:** Acumulador con filtro

---

### REQ-35: Calcular las comisiones totales del portafolio

**Contexto:** Sumar TODAS las comisiones de TODAS las criptos.

**Ejemplo:**
```
Bitcoin: comisiones = $336.70
Ethereum: comisiones = $420.50
Cardano: comisiones = $13.20
Solana: comisiones = $10.00
Ripple: comisiones = $9.60

Total = $336.70 + $420.50 + $13.20 + $10 + $9.60 = $790
```

**Método resultante:**
```java
public double calcularComisionesTotalesPortafolio()
```

**Pasos:**
1. Crear variable `total` = 0
2. Recorrer todas las criptomonedas
3. Por cada una: sumar su `getComisionesTotales()`
4. Retornar total

**Ejemplo de ejecución:**
```
total = 0
Bitcoin: 336.70 → total = 336.70
Ethereum: 420.50 → total = 757.20
Cardano: 13.20 → total = 770.40
Solana: 10.00 → total = 780.40
Ripple: 9.60 → total = 790.00

Retorna 790.00
```

**Por qué es necesario:** Medir el impacto global de las comisiones.

**Patrón:** Acumulador

---

### REQ-36: Calcular porcentaje de comisiones sobre ganancias

**Contexto:** Si gané $5,608 pero pagué $790 en comisiones, ¿qué % representan?

**Cálculo:** ($790 / $5,608) × 100 = 14.09%

**Método resultante:**
```java
public double calcularPorcentajeComisionesSobreGanancias()
```

**Pasos:**
1. Llamar a `calcularGananciaTotalPortafolio()` → ejemplo: 5608
2. Verificar si ganancia > 0
3. Si ganancia > 0:
   - Llamar a `calcularComisionesTotalesPortafolio()` → ejemplo: 790
   - Dividir: 790 / 5608 = 0.1409
   - Multiplicar por 100: 0.1409 × 100 = 14.09
   - Retornar 14.09
4. Si ganancia ≤ 0:
   - Retornar 0

**Ejemplo de ejecución:**
```
Ganancia total = 5608
¿5608 > 0? SÍ
Comisiones totales = 790
Cálculo: (790 / 5608) × 100 = 14.09
Retorna 14.09
```

**Por qué es necesario:** Evaluar eficiencia de la estrategia.

**Patrón:** Cálculo derivado con validación

---

### REQ-37: Encontrar la criptomoneda con mejor rentabilidad

**Contexto:** De las criptos CON VENTAS, ¿cuál tiene mayor rentabilidad %?

**Ejemplo:**
```
Bitcoin: tiene ventas, rentabilidad = 16.13%
Ethereum: tiene ventas, rentabilidad = 19.35% ← la mejor
Cardano: tiene ventas, rentabilidad = 71.76% ← ¡la mejor real!
Solana: SIN ventas → ignorar
Ripple: SIN ventas → ignorar

Mejor: Cardano con 71.76%
```

**Método resultante:**
```java
public Criptomoneda obtenerCriptoConMejorRentabilidad()
```

**Pasos:**
1. Crear variables: `mejorCripto = null`, `mejorRentabilidad = valor muy negativo`
2. Recorrer `criptomonedas`
3. Por cada criptomoneda:
   - Verificar si tiene ventas
   - Si tiene ventas:
     - Obtener su rentabilidad
     - Si es mayor que `mejorRentabilidad`:
       - Actualizar `mejorCripto` y `mejorRentabilidad`
   - Si no tiene ventas: ignorarla
4. Retornar `mejorCripto`

**Ejemplo de ejecución:**
```
mejorCripto = null
mejorRentabilidad = -∞

Bitcoin: tieneVentas()=true
  rentabilidad = 16.13
  ¿16.13 > -∞? SÍ → mejorCripto=Bitcoin, mejorRentabilidad=16.13

Ethereum: tieneVentas()=true
  rentabilidad = 19.35
  ¿19.35 > 16.13? SÍ → mejorCripto=Ethereum, mejorRentabilidad=19.35

Cardano: tieneVentas()=true
  rentabilidad = 71.76
  ¿71.76 > 19.35? SÍ → mejorCripto=Cardano, mejorRentabilidad=71.76

Solana: tieneVentas()=false → ignorar
Ripple: tieneVentas()=false → ignorar

Retorna Cardano
```

**Por qué es necesario:** Identificar la inversión más exitosa.

**Patrón:** Búsqueda de máximo con filtro

---

### REQ-38: Encontrar la criptomoneda con peor rentabilidad

**Contexto:** De las criptos con ventas, ¿cuál tiene menor rentabilidad?

**Ejemplo:**
Del ejemplo anterior, Bitcoin con 16.13% sería la peor (entre las que tienen ventas).

**Método resultante:**
```java
public Criptomoneda obtenerCriptoConPeorRentabilidad()
```

**Pasos:**
1. Crear: `peorCripto = null`, `peorRentabilidad = valor muy positivo`
2. Recorrer criptomonedas con ventas
3. Por cada una: si su rentabilidad < peorRentabilidad, actualizar
4. Retornar peorCripto

**Ejemplo de ejecución:**
```
peorRentabilidad = +∞

Bitcoin: rent=16.13 → ¿16.13 < +∞? SÍ → peorCripto=Bitcoin, peorRent=16.13
Ethereum: rent=19.35 → ¿19.35 < 16.13? NO
Cardano: rent=71.76 → ¿71.76 < 16.13? NO
(Solana y Ripple sin ventas → ignorar)

Retorna Bitcoin
```

**Por qué es necesario:** Identificar inversiones problemáticas.

**Patrón:** Búsqueda de mínimo con filtro

---

### REQ-39: Obtener lista de criptomonedas en ganancia

**Contexto:** ¿Cuáles inversiones nos están dando dinero?

**Ejemplo:**
```
Bitcoin: tiene ventas, ganancia = $1,444 (positiva) → incluir
Ethereum: tiene ventas, ganancia = $3,600 (positiva) → incluir
Cardano: tiene ventas, ganancia = -$200 (negativa) → NO incluir
Solana: SIN ventas → NO incluir

Resultado: [Bitcoin, Ethereum]
```

**Método resultante:**
```java
public ArrayList<Criptomoneda> obtenerCriptosConGanancias()
```

**Pasos:**
1. Crear ArrayList vacío `resultado`
2. Recorrer `criptomonedas`
3. Por cada cripto:
   - Verificar si tiene ventas
   - Si tiene ventas:
     - Obtener su ganancia realizada
     - Si ganancia > 0: agregarla al resultado
4. Retornar resultado

**Ejemplo de ejecución:**
```
resultado = vacío

Bitcoin: tieneVentas()=true, ganancia=1444 → ¿1444>0? SÍ → agregar
Ethereum: tieneVentas()=true, ganancia=3600 → ¿3600>0? SÍ → agregar
Cardano: tieneVentas()=true, ganancia=-200 → ¿-200>0? NO
Solana: tieneVentas()=false → no revisar ganancia

Retorna ArrayList con [Bitcoin, Ethereum]
```

**Por qué es necesario:** Filtrar inversiones exitosas.

**Patrón:** Filtrado con condición compuesta

---

### REQ-40: Obtener lista de criptomonedas en pérdida

**Contexto:** ¿Cuáles inversiones nos están perdiendo dinero?

**Ejemplo:**
Cardano con ganancia = -$200 (negativa)

**Método resultante:**
```java
public ArrayList<Criptomoneda> obtenerCriptosConPerdidas()
```

**Pasos:**
1. Crear ArrayList vacío
2. Recorrer criptomonedas
3. Por cada una con ventas:
   - Si ganancia < 0: agregarla
4. Retornar resultado

**Ejemplo:**
```
Solo Cardano tiene ganancia negativa
Retorna ArrayList con [Cardano]
```

**Por qué es necesario:** Identificar inversiones problemáticas.

**Patrón:** Filtrado

---

### REQ-41: Obtener criptomonedas sin ventas

**Contexto:** ¿Cuáles son "holdings" puros (solo compras)?

**Ejemplo:**
Solana y Ripple no tienen ventas → [Solana, Ripple]

**Método resultante:**
```java
public ArrayList<Criptomoneda> obtenerCriptosSinVentas()
```

**Pasos:**
1. Crear ArrayList vacío
2. Recorrer criptomonedas
3. Por cada una:
   - Si NO tiene ventas: agregarla
4. Retornar resultado

**Ejemplo:**
```
Bitcoin: tieneVentas()=true → ignorar
Ethereum: tieneVentas()=true → ignorar
Cardano: tieneVentas()=true → ignorar
Solana: tieneVentas()=false → agregar
Ripple: tieneVentas()=false → agregar

Retorna [Solana, Ripple]
```

**Por qué es necesario:** Identificar inversiones a largo plazo.

**Patrón:** Filtrado por negación

---

### REQ-42: Encontrar la criptomoneda más operada

**Contexto:** ¿Con cuál hemos hecho más transacciones?

**Ejemplo:**
```
Bitcoin: 10 operaciones ← la más operada
Ethereum: 8 operaciones
Cardano: 5 operaciones
Solana: 1 operación
Ripple: 1 operación
```

**Método resultante:**
```java
public Criptomoneda obtenerCriptoConMasOperaciones()
```

**Pasos:**
1. Verificar si portafolio vacío → retornar null
2. Tomar la primera cripto como máximo provisional
3. Obtener su cantidad de operaciones
4. Recorrer las demás
5. Por cada una: si tiene más operaciones, actualizar máximo
6. Retornar la cripto con más operaciones

**Ejemplo de ejecución:**
```
criptoMax = Bitcoin
maxOps = 10

Ethereum: ops=8 → ¿8>10? NO
Cardano: ops=5 → ¿5>10? NO
Solana: ops=1 → ¿1>10? NO
Ripple: ops=1 → ¿1>10? NO

Retorna Bitcoin
```

**Por qué es necesario:** Identificar nuestra cripto favorita.

**Patrón:** Búsqueda de máximo

---

### REQ-43: Contar operaciones totales del portafolio

**Contexto:** ¿Cuántas transacciones en total?

**Ejemplo:**
Bitcoin (10) + Ethereum (8) + Cardano (5) + Solana (1) + Ripple (1) = 25 operaciones

**Método resultante:**
```java
public int contarTotalOperaciones()
```

**Pasos:**
1. Crear contador = 0
2. Recorrer criptomonedas
3. Por cada una: sumar su cantidad de operaciones
4. Retornar contador

**Ejemplo:**
```
total = 0
Bitcoin: 10 → total = 10
Ethereum: 8 → total = 18
Cardano: 5 → total = 23
Solana: 1 → total = 24
Ripple: 1 → total = 25

Retorna 25
```

**Por qué es necesario:** Métrica de actividad.

**Patrón:** Acumulador

---

### REQ-44: Contar operaciones por tipo en todo el portafolio

**Contexto:** ¿Cuántas compras en total? ¿Cuántas ventas?

**Ejemplo:**
```
Bitcoin: 7 compras, 3 ventas
Ethereum: 5 compras, 3 ventas
Cardano: 3 compras, 2 ventas
Solana: 1 compra, 0 ventas
Ripple: 1 compra, 0 ventas

Si pedimos tipo="Compra" → 7+5+3+1+1 = 17 compras
```

**Método resultante:**
```java
public int contarOperacionesPorTipo(String tipo)
```

**Pasos:**
1. Crear contador = 0
2. Recorrer criptomonedas
3. Por cada cripto:
   - Llamar a `obtenerOperacionesPorTipo(tipo)`
   - Ese método retorna un ArrayList
   - Contar cuántos elementos tiene ese ArrayList
   - Sumar al contador
4. Retornar contador

**Ejemplo (tipo="Compra"):**
```
contador = 0
Bitcoin: obtenerOperacionesPorTipo("Compra") → ArrayList con 7 elementos → contador=7
Ethereum: obtenerOperacionesPorTipo("Compra") → ArrayList con 5 elementos → contador=12
Cardano: obtenerOperacionesPorTipo("Compra") → ArrayList con 3 elementos → contador=15
Solana: obtenerOperacionesPorTipo("Compra") → ArrayList con 1 elemento → contador=16
Ripple: obtenerOperacionesPorTipo("Compra") → ArrayList con 1 elemento → contador=17

Retorna 17
```

**Por qué es necesario:** Analizar balance entre compras y ventas.

**Patrón:** Acumulador con delegación

---

### REQ-45: Obtener todas las operaciones de un día (consolidado)

**Contexto:** Ver TODAS las operaciones del lunes, de CUALQUIER cripto.

**Ejemplo:**
```
Bitcoin tiene 2 operaciones del lunes
Ethereum tiene 1 operación del lunes
Cardano tiene 0 operaciones del lunes
Solana tiene 1 operación del lunes

Resultado: ArrayList con 4 operaciones del lunes
```

**Método resultante:**
```java
public ArrayList<Operacion> obtenerOperacionesPorDia(String dia)
```

**Pasos:**
1. Crear ArrayList vacío `resultado`
2. Recorrer todas las criptomonedas
3. Por cada cripto:
   - Llamar a `cripto.obtenerOperacionesPorDia(dia)`
   - Ese método retorna un ArrayList con las operaciones de ese día
   - Agregar TODAS esas operaciones al `resultado` (usar addAll)
4. Retornar resultado

**Ejemplo (dia="Lunes"):**
```
resultado = vacío

Bitcoin: obtenerOperacionesPorDia("Lunes") → ArrayList con [op1, op2]
  resultado.addAll([op1, op2]) → resultado ahora tiene 2 elementos

Ethereum: obtenerOperacionesPorDia("Lunes") → ArrayList con [op3]
  resultado.addAll([op3]) → resultado ahora tiene 3 elementos

Cardano: obtenerOperacionesPorDia("Lunes") → ArrayList vacío
  resultado.addAll([]) → resultado sigue con 3 elementos

Solana: obtenerOperacionesPorDia("Lunes") → ArrayList con [op4]
  resultado.addAll([op4]) → resultado ahora tiene 4 elementos

Retorna ArrayList con 4 operaciones
```

**Por qué es necesario:** Análisis temporal cruzando criptomonedas.

**Patrón:** Consolidación (unir múltiples listas)

---

### REQ-46: Obtener operaciones de un período (consolidado)

**Contexto:** Todas las operaciones de la mañana, de cualquier cripto.

**Método resultante:**
```java
public ArrayList<Operacion> obtenerOperacionesPorPeriodo(String periodo)
```

**Pasos:** Idénticos al REQ-43, pero llamando a `obtenerOperacionesPorPeriodo`

**Ejemplo (periodo="Mañana"):**
```
Bitcoin: 3 operaciones de mañana
Ethereum: 2 operaciones de mañana
Cardano: 1 operación de mañana
Solana: 0 operaciones de mañana
Ripple: 1 operación de mañana

Consolidar todas → ArrayList con 7 operaciones
```

**Por qué es necesario:** Analizar patrones horarios.

**Patrón:** Consolidación

---

### REQ-47: Encontrar la operación más grande del portafolio

**Contexto:** De TODAS las operaciones de TODAS las criptos, ¿cuál tiene mayor monto?

**Ejemplo:**
```
Bitcoin op1: monto=$22,500
Bitcoin op2: monto=$13,200
Ethereum op1: monto=$37,200 ← la más grande
Cardano op1: monto=$560
...
```

**Método resultante:**
```java
public Operacion obtenerOperacionMasGrande()
```

**Pasos:**
1. Crear: `operacionMax = null`, `montoMax = valor muy negativo`
2. Recorrer cada criptomoneda
3. Por cada cripto:
   - Obtener su ArrayList de operaciones
   - Recorrer cada operación de esa cripto:
     - Obtener su monto
     - Si monto > montoMax: actualizar máximo
4. Retornar operacionMax

**Ejemplo de ejecución (recorrido anidado):**
```
operacionMax = null
montoMax = -∞

Recorrer Bitcoin:
  op1: monto=22500 → ¿22500>-∞? SÍ → operacionMax=op1, montoMax=22500
  op2: monto=13200 → ¿13200>22500? NO

Recorrer Ethereum:
  op1: monto=37200 → ¿37200>22500? SÍ → operacionMax=op1_eth, montoMax=37200
  op2: monto=22200 → ¿22200>37200? NO

Recorrer Cardano:
  op1: monto=560 → ¿560>37200? NO
  ...

Retorna la operación de Ethereum con monto $37,200
```

**Por qué es necesario:** Identificar operaciones significativas.

**Patrón:** Búsqueda de máximo en estructura anidada

---

### REQ-48: Obtener operaciones con comisión alta

**Contexto:** Todas las operaciones (de cualquier cripto) con comisión > 1%.

**Ejemplo:**
```
Bitcoin op1: comisión=0.5% → NO incluir
Bitcoin op2: comisión=1.3% → incluir
Ethereum op1: comisión=0.7% → NO incluir
Solana op1: comisión=1.5% → incluir

Resultado: [Bitcoin op2, Solana op1]
```

**Método resultante:**
```java
public ArrayList<Operacion> obtenerOperacionesConComisionAlta()
```

**Pasos:**
1. Crear ArrayList vacío `resultado`
2. Recorrer cada criptomoneda
3. Por cada cripto:
   - Recorrer cada operación de esa cripto:
     - Obtener su comisión %
     - Si comisión > 1.0: agregarla al resultado
4. Retornar resultado

**Ejemplo:**
```
resultado = vacío

Recorrer Bitcoin:
  op1: comisión%=0.5 → ¿0.5>1.0? NO
  op2: comisión%=1.3 → ¿1.3>1.0? SÍ → agregar

Recorrer Ethereum:
  op1: comisión%=0.7 → NO
  op2: comisión%=0.7 → NO

Recorrer Solana:
  op1: comisión%=1.5 → ¿1.5>1.0? SÍ → agregar

Retorna ArrayList con 2 operaciones
```

**Por qué es necesario:** Identificar operaciones costosas.

**Patrón:** Filtrado en estructura anidada

---

### REQ-49: Determinar el día más operado

**Contexto:** ¿Qué día de la semana operamos más?

**Ejemplo:**
```
Lunes: 8 operaciones ← el más operado
Martes: 3 operaciones
Miércoles: 5 operaciones
Jueves: 2 operaciones
Viernes: 6 operaciones
Sábado: 0 operaciones
Domingo: 1 operación
```

**Método resultante:**
```java
public String obtenerDiaMasOperado()
```

**Pasos:**
1. Crear 7 contadores (uno por cada día de la semana), todos en 0
2. Recorrer cada criptomoneda
3. Por cada cripto:
   - Recorrer cada operación:
     - Obtener su día
     - Incrementar el contador de ese día
4. Encontrar cuál contador es el mayor
5. Retornar el día correspondiente a ese contador

**Ejemplo de ejecución:**
```
Contadores:
  contLunes=0, contMartes=0, contMiercoles=0, contJueves=0,
  contViernes=0, contSabado=0, contDomingo=0

Recorrer Bitcoin (10 operaciones):
  op1: día="Lunes" → contLunes++
  op2: día="Lunes" → contLunes++
  op3: día="Miércoles" → contMiercoles++
  ...

Recorrer Ethereum (8 operaciones):
  ...

Al final:
  contLunes=8, contMartes=3, contMiercoles=5, contJueves=2,
  contViernes=6, contSabado=0, contDomingo=1

Encontrar máximo: contLunes=8 es el mayor
Retorna "Lunes"
```

**Por qué es necesario:** Identificar patrones de comportamiento.

**Patrón:** Análisis estadístico con contadores múltiples

---

### REQ-50: Determinar el período más operado

**Contexto:** ¿Mañana, tarde o noche?

**Ejemplo:**
Mañana: 12 operaciones ← el más operado
Tarde: 8 operaciones
Noche: 5 operaciones

**Método resultante:**
```java
public String obtenerPeriodoMasOperado()
```

**Pasos:**
1. Crear 3 contadores: contMañana=0, contTarde=0, contNoche=0
2. Recorrer cada cripto y cada operación
3. Por cada operación:
   - Obtener su período (llamando getPeriodo())
   - Incrementar el contador correspondiente
4. Encontrar el contador mayor
5. Retornar ese período

**Ejemplo:**
```
Después de recorrer todo:
  contMañana=12, contTarde=8, contNoche=5

Máximo: contMañana=12
Retorna "Mañana"
```

**Por qué es necesario:** Analizar horarios preferidos.

**Patrón:** Análisis estadístico

---

### REQ-51: Obtener días únicos operados

**Contexto:** ¿En cuáles días hemos operado? (sin repetir)

**Ejemplo:**
```
Operamos en: Lunes, Miércoles, Viernes, Sábado
NO operamos en: Martes, Jueves, Domingo

Resultado: ["Lunes", "Miércoles", "Viernes", "Sábado"]
```

**Método resultante:**
```java
public ArrayList<String> obtenerDiasOperados()
```

**Pasos:**
1. Crear ArrayList vacío `resultado`
2. Recorrer cada criptomoneda
3. Por cada cripto:
   - Recorrer cada operación:
     - Obtener su día
     - Verificar si ese día YA está en `resultado`
     - Si NO está: agregarlo
     - Si ya está: ignorarlo (evitar duplicados)
4. Retornar resultado

**Ejemplo de ejecución:**
```
resultado = vacío []

Bitcoin op1: día="Lunes" → ¿está en []? NO → agregar → ["Lunes"]
Bitcoin op2: día="Lunes" → ¿está en ["Lunes"]? SÍ → ignorar
Bitcoin op3: día="Miércoles" → ¿está? NO → agregar → ["Lunes", "Miércoles"]
Ethereum op1: día="Viernes" → ¿está? NO → agregar → ["Lunes", "Miércoles", "Viernes"]
Ethereum op2: día="Lunes" → ¿está? SÍ → ignorar
Solana op1: día="Sábado" → ¿está? NO → agregar → ["Lunes", "Miércoles", "Viernes", "Sábado"]

Retorna ["Lunes", "Miércoles", "Viernes", "Sábado"]
```

**Por qué es necesario:** Identificar cobertura temporal.

**Patrón:** Extracción de valores únicos

---

### REQ-52: Generar reporte completo

**Contexto:** Documento de texto con toda la información resumida.

**Método resultante:**
```java
public String generarReporteCompleto()
```

**Pasos:**
1. Crear un String (o StringBuilder) para acumular el texto
2. Agregar encabezado con nombre del dueño
3. Recorrer cada criptomoneda y agregar:
   - Nombre y símbolo
   - Cantidad actual
   - Dinero invertido y recuperado
   - Ganancia y rentabilidad
   - Comisiones pagadas
   - Total de operaciones
4. Agregar resumen general:
   - Valor total invertido
   - Ganancia total
   - Comisiones totales
   - Mejor y peor criptomoneda
5. Retornar el String completo

**Ejemplo de salida:**
```
=================================
REPORTE DE PORTAFOLIO
Dueño: Juan Pérez
=================================

BITCOIN (BTC)
  Cantidad actual: 0.7 BTC
  Dinero invertido: $40,300.00
  Dinero recuperado: $10,400.00
  Ganancia realizada: $1,444.44
  Rentabilidad: 16.13%
  Comisiones pagadas: $336.70
  Operaciones: 10

[... más criptos ...]

RESUMEN GENERAL:
  Valor total invertido: $78,810.00
  Ganancia total: $5,608.00
  Comisiones totales: $790.00
  Mejor rentabilidad: Cardano (71.76%)
  Peor rentabilidad: Bitcoin (16.13%)
  Total operaciones: 25
```

**Por qué es necesario:** Visualización completa del portafolio.

**Patrón:** Consolidación de información con formato

---

## 📊 RESUMEN FINAL

### Total de Métodos por Clase

```
Operacion: 6 métodos de cálculo
Criptomoneda: 20 métodos
Wallet: 28 métodos
─────────────────────────
TOTAL: 54 métodos
```

### Patrones de Recorrido Identificados

1. **Acumulador simple:** Suma valores recorriendo ArrayList
2. **Acumulador con filtro:** Suma solo elementos que cumplen condición
3. **Búsqueda de máximo/mínimo:** Encuentra elemento con mayor/menor valor
4. **Filtrado:** Crea nuevo ArrayList con elementos que cumplen condición
5. **Búsqueda booleana:** Verifica si existe al menos un elemento que cumple condición
6. **Cálculo derivado:** Usa resultados de otros métodos
7. **Consolidación:** Une resultados de múltiples fuentes
8. **Recorrido anidado:** Recorre ArrayList dentro de otro ArrayList
9. **Análisis estadístico:** Usa contadores múltiples para análisis
10. **Extracción de únicos:** Filtra elementos sin repetir

### Principios del Diseño

1. **Solo 10 atributos totales:** Todo lo demás se calcula
2. **Instanciación interna:** Los métodos reciben datos sueltos, NO objetos
3. **Sin redundancia:** No almacenamos valores calculables
4. **Siempre correcto:** Como todo se calcula en tiempo real, nunca hay datos desactualizados
5. **Recorridos frecuentes:** La mayoría de métodos requieren recorrer ArrayLists

---

## ✅ Tarea del Estudiante

Para cada método listado:

1. **Copiar la firma** exactamente como se especificó
2. **Implementar la lógica** siguiendo los pasos numerados
3. **Usar el patrón** de recorrido apropiado
4. **Validar casos especiales:**
   - Listas vacías
   - División por cero
   - Valores null

**Lo que NO proporcionamos:** El código interno completo (eso es tu práctica)

**Lo que SÍ proporcionamos:**
- La firma exacta de cada método
- Ejemplo concreto de entrada
- Pasos numerados del cálculo
- Ejemplo de ejecución paso a paso
- Ejemplo del resultado esperado
- Explicación de por qué es necesario
- El patrón a aplicar

---

*Fin de la Guía Completa*
