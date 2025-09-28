# 💳 Ejercicio de Programación: Sistema de Control de Tarjeta de Crédito

## Contexto del Negocio

El banco **"Confianza Total"** necesita un sistema para administrar las tarjetas de crédito de sus clientes. Cada tarjeta tiene un comportamiento específico que debe controlarse cuidadosamente para evitar sobregiros, calcular intereses y otorgar beneficios según el uso.

### Reglas del Negocio

1. **Límite de Crédito y Saldo**
   - Cada tarjeta tiene un **límite de crédito** fijo (ejemplo: $5,000,000)
   - El **saldo actual** representa lo que el cliente debe al banco
   - El **cupo disponible** = límite de crédito - saldo actual
   - No se pueden hacer compras que excedan el cupo disponible

2. **Tipos de Transacciones**
   - **Compra Nacional**: Sin recargo adicional
   - **Compra Internacional**: Se cobra un 5% adicional por conversión de moneda
   - **Avance en Efectivo**: Se cobra una comisión fija de $50,000 más el 3% del monto
   - **Pago/Abono**: Reduce el saldo adeudado

3. **Categorías de Cliente según Uso Mensual**
   - **Básico**: Ha realizado menos de 5 transacciones en el mes
   - **Frecuente**: Entre 5 y 15 transacciones en el mes
   - **Premium**: Más de 15 transacciones en el mes

4. **Beneficios por Categoría**
   - **Básico**: Sin beneficios adicionales
   - **Frecuente**: Si el pago es mayor al 50% del saldo, se condona $20,000 de intereses
   - **Premium**: Si el pago es mayor al 30% del saldo, se condona $50,000 de intereses

5. **Cálculo de Intereses**
   - Si el saldo es mayor a $0, se cobra un interés del 2.5% mensual sobre el saldo
   - Los intereses se calculan ANTES de aplicar cualquier beneficio por categoría

6. **Estado de la Tarjeta**
   - **Activa**: Cupo disponible mayor a $100,000
   - **Alerta**: Cupo disponible entre $1 y $100,000
   - **Bloqueada**: Cupo disponible es $0 o negativo

---

## Ejemplos Resueltos

### Ejemplo 1: Compra Internacional con Tarjeta Frecuente

**Situación Inicial:**
- Cliente: María González
- Límite de crédito: $3,000,000
- Saldo actual: $1,200,000
- Transacciones del mes: 8
- Categoría: Frecuente

**Operación:** María realiza una compra internacional de $500,000

**Cálculo:**
1. Verificar cupo disponible: $3,000,000 - $1,200,000 = $1,800,000 ✓
2. Calcular monto con recargo: $500,000 + (5% × $500,000) = $525,000
3. Verificar si el monto cabe en el cupo: $525,000 < $1,800,000 ✓
4. Nuevo saldo: $1,200,000 + $525,000 = $1,725,000
5. Nuevo cupo disponible: $3,000,000 - $1,725,000 = $1,275,000
6. Estado de la tarjeta: Activa (cupo > $100,000)
7. Transacciones del mes: 9

**Resultado:** Compra aprobada. Nuevo saldo: $1,725,000

---

### Ejemplo 2: Pago con Beneficio Premium

**Situación Inicial:**
- Cliente: Carlos Ruiz
- Límite de crédito: $5,000,000
- Saldo actual: $3,500,000
- Transacciones del mes: 18
- Categoría: Premium

**Operación:** Carlos realiza un pago de $1,500,000

**Cálculo de Intereses antes del pago:**
1. Intereses = 2.5% × $3,500,000 = $87,500
2. Saldo con intereses: $3,500,000 + $87,500 = $3,587,500

**Aplicación del pago:**
3. Porcentaje del pago: $1,500,000 ÷ $3,587,500 = 41.8%
4. Como es Premium y el pago > 30% del saldo, se condonan $50,000
5. Saldo después del pago: $3,587,500 - $1,500,000 - $50,000 = $2,037,500
6. Nuevo cupo disponible: $5,000,000 - $2,037,500 = $2,962,500
7. Estado: Activa

**Resultado:** Pago procesado con beneficio. Nuevo saldo: $2,037,500

---

### Ejemplo 3: Avance en Efectivo cerca del Límite

**Situación Inicial:**
- Cliente: Ana López
- Límite de crédito: $2,000,000
- Saldo actual: $1,850,000
- Transacciones del mes: 3
- Categoría: Básico

**Operación:** Ana solicita un avance en efectivo de $100,000

**Cálculo:**
1. Cupo disponible: $2,000,000 - $1,850,000 = $150,000
2. Costo del avance: $100,000 + $50,000 + (3% × $100,000) = $153,000
3. Verificar cupo: $153,000 > $150,000 ✗

**Resultado:** Transacción rechazada por cupo insuficiente

---

### Ejemplo 4: Compra Nacional que Cambia Estado

**Situación Inicial:**
- Cliente: Luis Pérez
- Límite de crédito: $4,000,000
- Saldo actual: $3,920,000
- Transacciones del mes: 7
- Categoría: Frecuente

**Operación:** Luis hace una compra nacional de $75,000

**Cálculo:**
1. Cupo disponible: $4,000,000 - $3,920,000 = $80,000
2. Verificar: $75,000 < $80,000 ✓
3. Nuevo saldo: $3,920,000 + $75,000 = $3,995,000
4. Nuevo cupo: $4,000,000 - $3,995,000 = $5,000
5. Estado: Alerta (cupo entre $1 y $100,000)
6. Transacciones del mes: 8

**Resultado:** Compra aprobada. Estado cambia a Alerta. Nuevo saldo: $3,995,000

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
   - Calcular intereses sobre el saldo actual
   - Aplicar el pago
   - Verificar y aplicar beneficios según la categoría
   - Actualizar el saldo

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