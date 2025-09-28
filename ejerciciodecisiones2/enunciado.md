# 💳 Ejercicio de Programación: Sistema de Control de Tarjeta de Crédito

## Contexto del Negocio

El banco **"Confianza Total"** necesita un sistema para administrar las tarjetas de crédito de sus clientes. Una tarjeta de crédito es un medio de pago que permite a los clientes hacer compras sin tener el dinero en ese momento, pero con el compromiso de pagarlo después al banco.

Cuando un cliente obtiene una tarjeta, el banco le asigna un **límite máximo** de dinero que puede usar. Cada vez que el cliente hace una compra, el banco le "presta" ese dinero y el cliente queda debiendo esa cantidad. El cliente puede hacer pagos para reducir su deuda y así tener más dinero disponible para usar nuevamente.

### Reglas del Negocio

1. **Límite de Crédito y Saldo**
   - Cada tarjeta tiene un **límite de crédito** fijo que es el máximo que el banco le presta al cliente (ejemplo: $5,000,000 significa que el cliente puede llegar a deber hasta $5,000,000)
   - El **saldo actual** representa cuánto dinero debe actualmente el cliente al banco (si debe $2,000,000, ese es su saldo)
   - El **cupo disponible** es cuánto más puede gastar el cliente. Se calcula como: límite de crédito - saldo actual
     * Ejemplo: Si el límite es $5,000,000 y debe $2,000,000, entonces puede gastar hasta $3,000,000 más
   - No se pueden hacer compras que excedan el cupo disponible (el banco no prestará más del límite establecido)

2. **Tipos de Transacciones**
   - **Compra Nacional**: Compra realizada en Colombia. El valor se carga directamente al saldo sin recargos
   - **Compra Internacional**: Compra realizada en otro país. Como hay que convertir monedas, se cobra un 5% adicional sobre el valor de la compra
     * Ejemplo: Compra de $1,000,000 en el exterior → se cargan $1,050,000 al saldo
   - **Avance en Efectivo**: El cliente retira dinero en efectivo del cajero usando la tarjeta. Esto es más costoso: se cobra una comisión fija de $50,000 más el 3% del monto retirado
     * Ejemplo: Retirar $1,000,000 → se cargan $50,000 + $30,000 = $1,080,000 adicionales, total: $1,080,000
   - **Pago/Abono**: El cliente paga parte o toda su deuda. Esto reduce el saldo adeudado y aumenta el cupo disponible

3. **Categorías de Cliente según Uso Mensual**
   El banco clasifica a sus clientes según cuánto usan la tarjeta cada mes (contando compras y retiros, no los pagos):
   - **Básico**: Cliente que usa poco la tarjeta (menos de 5 transacciones en el mes)
   - **Frecuente**: Cliente que usa moderadamente la tarjeta (entre 5 y 15 transacciones en el mes)
   - **Premium**: Cliente que usa mucho la tarjeta (más de 15 transacciones en el mes)

4. **Beneficios por Categoría**
   El banco premia a los buenos clientes cuando hacen pagos. Los beneficios se aplican como descuentos en los intereses:
   - **Básico**: No recibe descuentos
   - **Frecuente**: Si paga más de la mitad de lo que debe (más del 50% del saldo), el banco le perdona $20,000 de intereses
   - **Premium**: Si paga al menos el 30% de lo que debe, el banco le perdona $50,000 de intereses
   
   Nota: Primero se calculan los intereses, luego se aplica el descuento si corresponde

5. **Cálculo de Intereses**
   - Cuando el cliente va a hacer un pago y tiene saldo > $0, el banco cobra un interés del 2.5% sobre lo que debe
   - Este interés se calcula y se suma al saldo justo antes de aplicar el pago
   - Ejemplo: Si debe $1,000,000 y va a pagar, primero se cobran intereses de $25,000 (el 2.5% de $1,000,000), quedando un saldo de $1,025,000, y luego se aplica el pago
   - Los intereses SOLO se cobran cuando se hace un pago, no en las compras

6. **Estado de la Tarjeta**
   El banco controla el riesgo clasificando las tarjetas según cuánto cupo les queda:
   - **Activa**: La tarjeta funciona normalmente (tiene más de $100,000 de cupo disponible)
   - **Alerta**: La tarjeta está cerca del límite, hay que tener cuidado (cupo disponible entre $1 y $100,000)
   - **Bloqueada**: La tarjeta no puede hacer más compras porque llegó al límite (cupo es $0 o ya se pasó)

---

## Conceptos Importantes para Entender el Problema

### ¿Qué significa USAR la tarjeta?

Usar la tarjeta significa hacer compras o retirar efectivo. Cuando un cliente usa su tarjeta:
- El banco le está prestando dinero que deberá pagar después
- Su deuda (saldo) aumenta
- Su capacidad de gastar (cupo disponible) disminuye
- Cada uso cuenta como una transacción para determinar su categoría
- El banco debe verificar que el cliente no exceda su límite permitido
- Según el tipo de uso, pueden aplicarse costos adicionales

### ¿Qué significa PAGAR?

Pagar significa que el cliente le devuelve dinero al banco para reducir su deuda. Cuando un cliente paga:
- Su deuda (saldo) disminuye
- Su capacidad de gastar (cupo disponible) aumenta
- El banco cobra intereses sobre lo que debía antes del pago
- Según qué tan buen cliente sea y cuánto pague, puede recibir beneficios
- Los pagos NO cuentan como transacciones para la categoría

### La diferencia clave:
- **Usar la tarjeta** = Aumentar la deuda, el banco verifica que no exceda límites
- **Pagar** = Reducir la deuda, pero primero se cobran intereses por el dinero prestado

---

## Ejemplos Resueltos

Para entender mejor cómo funciona el sistema, veamos varios casos reales:

### Ejemplo 1: Compra Internacional con Tarjeta Frecuente

**Situación Inicial:**
- Cliente: María González
- Límite de crédito: $3,000,000 (máximo que puede deber)
- Saldo actual: $1,200,000 (ya debe esta cantidad)
- Transacciones del mes: 8 (ya ha hecho 8 compras/retiros este mes)
- Categoría: Frecuente (porque tiene entre 5 y 15 transacciones)

**Operación:** María realiza una compra internacional de $500,000

**Proceso de decisión paso a paso:**
1. Calcular cupo disponible: $3,000,000 - $1,200,000 = $1,800,000
2. Como es compra internacional, calcular el recargo del 5%: $500,000 × 5% = $25,000
3. Monto total a cargar: $500,000 + $25,000 = $525,000
4. ¿Hay cupo suficiente? ¿$525,000 ≤ $1,800,000? SÍ ✓
5. Actualizar saldo: $1,200,000 + $525,000 = $1,725,000
6. Nuevo cupo disponible: $3,000,000 - $1,725,000 = $1,275,000
7. Determinar estado: Como $1,275,000 > $100,000 → Estado: Activa
8. Actualizar contador: 8 + 1 = 9 transacciones

**Resultado:** Compra aprobada. María ahora debe $1,725,000 al banco

---

### Ejemplo 2: Pago con Beneficio Premium

**Situación Inicial:**
- Cliente: Carlos Ruiz
- Límite de crédito: $5,000,000
- Saldo actual: $3,500,000 (Carlos debe esta cantidad)
- Transacciones del mes: 18 (ha usado mucho la tarjeta)
- Categoría: Premium (porque tiene más de 15 transacciones)

**Operación:** Carlos realiza un pago de $1,500,000 (está pagando parte de su deuda)

**Proceso completo:**

**Paso 1 - Al momento de pagar, se calculan intereses sobre lo que debe:**
- Carlos debe $3,500,000
- Como va a pagar, se cobran intereses del 2.5%: $3,500,000 × 2.5% = $87,500
- Saldo actualizado con intereses: $3,500,000 + $87,500 = $3,587,500

**Paso 2 - Aplicar el pago y verificar beneficios:**
- Monto del pago: $1,500,000
- ¿Qué porcentaje del saldo (con intereses) está pagando? $1,500,000 ÷ $3,587,500 = 41.8%
- Como Carlos es Premium y pagó más del 30%, tiene derecho al beneficio de $50,000

**Paso 3 - Calcular el nuevo saldo:**
- Saldo con intereses: $3,587,500
- Menos el pago: $3,587,500 - $1,500,000 = $2,087,500
- Menos el beneficio: $2,087,500 - $50,000 = $2,037,500

**Paso 4 - Actualizar cupo y estado:**
- Nuevo cupo disponible: $5,000,000 - $2,037,500 = $2,962,500
- Estado: Activa (porque $2,962,500 > $100,000)

**Resultado:** Carlos redujo su deuda a $2,037,500. Se le cobraron $87,500 de intereses pero recibió un descuento de $50,000 por ser buen cliente

---

### Ejemplo 3: Avance en Efectivo cerca del Límite

**Situación Inicial:**
- Cliente: Ana López
- Límite de crédito: $2,000,000
- Saldo actual: $1,850,000 (Ana ya debe esta cantidad al banco)
- Transacciones del mes: 3
- Categoría: Básico

**Operación:** Ana solicita un avance en efectivo de $100,000 (quiere retirar $100,000 del cajero)

**Cálculo paso a paso:**
1. Cupo disponible actual: $2,000,000 - $1,850,000 = $150,000
2. Costo total del avance:
   - Monto a retirar: $100,000
   - Comisión fija: $50,000
   - Comisión variable (3% de $100,000): $3,000
   - Total a cargar al saldo: $100,000 + $50,000 + $3,000 = $153,000
3. Verificar si hay cupo suficiente: ¿$153,000 ≤ $150,000? NO

**Resultado:** Transacción rechazada. Ana no puede retirar porque el costo total ($153,000) supera su cupo disponible ($150,000)

---

### Ejemplo 4: Compra Nacional que Cambia Estado

**Situación Inicial:**
- Cliente: Luis Pérez
- Límite de crédito: $4,000,000
- Saldo actual: $3,920,000 (Luis está muy cerca de su límite)
- Transacciones del mes: 7
- Categoría: Frecuente (tiene entre 5 y 15 transacciones)

**Operación:** Luis hace una compra nacional de $75,000 en un supermercado

**Análisis de la situación:**
1. **Calcular cupo antes de la compra:** $4,000,000 - $3,920,000 = $80,000 (muy poco cupo)
2. **Verificar si puede hacer la compra:** 
   - Compra nacional: no tiene recargos, son $75,000 exactos
   - ¿$75,000 ≤ $80,000? SÍ, apenas alcanza ✓
3. **Actualizar el saldo:** $3,920,000 + $75,000 = $3,995,000
4. **Calcular nuevo cupo:** $4,000,000 - $3,995,000 = $5,000 (¡quedó con muy poco cupo!)
5. **Determinar nuevo estado:** 
   - ¿$5,000 > $100,000? NO
   - ¿$5,000 está entre $1 y $100,000? SÍ → Estado: ALERTA
6. **Actualizar transacciones:** 7 + 1 = 8 transacciones

**Resultado:** La compra fue aprobada pero la tarjeta pasó a estado de ALERTA. Luis solo puede gastar $5,000 más antes de que se bloquee

---

## Escenarios de Práctica para Resolver

### Escenario 1: Cliente con múltiples operaciones

**Situación Inicial:**
- Cliente: Pedro Martínez
- Límite de crédito: $2,500,000
- Saldo actual: $800,000
- Transacciones del mes: 4
- Categoría: Básico

**Secuencia de operaciones a procesar:**
1. Pedro hace una compra nacional de $300,000
2. Pedro retira $200,000 del cajero (avance en efectivo)
3. Pedro hace una compra internacional de $600,000
4. Pedro realiza un pago de $700,000

**Pregunta:** 
- ¿Cuál es el saldo final de Pedro?
- ¿Cuál es su categoría final?
- ¿Cuál es el estado final de su tarjeta?
- ¿Cuáles operaciones fueron aprobadas y cuáles rechazadas?

### Escenario 2: Cliente cerca del límite

**Situación Inicial:**
- Cliente: Sofia Ramírez
- Límite de crédito: $1,500,000
- Saldo actual: $1,380,000
- Transacciones del mes: 12
- Categoría: Frecuente

**Secuencia de operaciones a procesar:**
1. Sofia intenta hacer una compra nacional de $50,000
2. Sofia intenta hacer una compra internacional de $100,000
3. Sofia realiza un pago de $800,000
4. Sofia intenta hacer una compra nacional de $50,000

**Pregunta:**
- ¿Cuál es el saldo final de Sofia?
- ¿Cuál es su categoría final?
- ¿Cuál es el estado final de su tarjeta?
- ¿Recibió algún beneficio? ¿Por qué?
- ¿Cuáles operaciones fueron aprobadas y cuáles rechazadas?

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto del negocio y los ejemplos proporcionados, identifique:

a) **Atributos necesarios** para la clase TarjetaCredito (mínimo 5 atributos)

b) **Métodos necesarios** para implementar todas las operaciones descritas (mínimo 6 métodos)

### 2. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

a) **Método realizarCompra(tipoCompra, monto)**
   - Debe validar el cupo disponible
   - Aplicar recargos según el tipo de compra
   - Actualizar el saldo y contador de transacciones
   - Retornar si la compra fue exitosa o no

b) **Método realizarPago(monto)**
   - Calcular intereses sobre el saldo actual (si el saldo > 0)
   - Sumar los intereses al saldo
   - Aplicar el pago
   - Verificar y aplicar beneficios según la categoría
   - Actualizar el saldo final

c) **Método determinarEstado()**
   - Calcular el cupo disponible
   - Determinar el estado según las reglas de negocio
   - Retornar el estado actual

### 3. Implementación en Java

**Instrucciones:** Implemente la clase completa `TarjetaCredito` en Java con:

- Todos los atributos identificados
- Constructor que inicialice la tarjeta con los valores necesarios
- Todos los métodos identificados con su lógica completa
- Un método `mostrarResumenCuenta()` que imprima:
  - Información del titular
  - Límite de crédito
  - Saldo actual
  - Cupo disponible
  - Categoría actual
  - Estado de la tarjeta
  - Número de transacciones del mes

**Consideraciones importantes:**
- Use solo estructuras de decisión (if, else if, else, switch)
- NO use arreglos, listas o colecciones
- Todos los cálculos deben estar en una sola clase
- Use tipos de datos apropiados (double para montos, int para contadores, String para textos)
- Recuerde que cada transacción (compra/retiro) incrementa el contador, pero los pagos NO
- El estado y la categoría se determinan según las reglas explicadas

---

## Criterios de Evaluación

1. **Identificación correcta de atributos** (20%)
   - Completitud y relevancia de los atributos

2. **Identificación correcta de métodos** (20%)
   - Coherencia con las operaciones del negocio

3. **Diagramas de flujo** (30%)
   - Correcta representación de la lógica
   - Uso apropiado de decisiones simples, múltiples y anidadas

4. **Implementación en Java** (30%)
   - Sintaxis correcta
   - Lógica completa y funcional
   - Manejo adecuado de todas las reglas del negocio

---

## Notas Finales

- Este ejercicio está diseñado para practicar decisiones en múltiples niveles
- Preste atención a las validaciones antes de realizar operaciones
- Recuerde que algunas decisiones dependen de otras (decisiones anidadas)
- El orden de las validaciones puede afectar el resultado final