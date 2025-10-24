# 🚕 Ejercicio de Programación: Sistema de Cálculo de Tarifas de Taxi Premium

## Contexto del Negocio

La empresa de transporte **"TaxiExpress Premium"** necesita un sistema automatizado para calcular el costo de los viajes en taxi. La empresa ofrece diferentes categorías de servicio y el precio varía según múltiples factores: distancia, día de la semana, hora del día, zonas de origen/destino, y beneficios para clientes frecuentes.

Cuando un cliente solicita un viaje, el sistema debe calcular el costo exacto considerando todos los factores aplicables, aplicar recargos por hora pico o servicio nocturno, agregar cargos por zonas especiales, y finalmente aplicar descuentos si el cliente califica para ellos.

### Reglas del Negocio

1. **Tipos de Servicio**

   La empresa ofrece tres categorías de servicio con tarifas diferentes:

   - **Económico**: Servicio básico en vehículo estándar
     - Tarifa base: $5,000
     - Costo por kilómetro: $2,000

   - **Premium**: Servicio mejorado en vehículo confortable
     - Tarifa base: $8,000
     - Costo por kilómetro: $3,000

   - **Ejecutivo**: Servicio de lujo en vehículo premium
     - Tarifa base: $12,000
     - Costo por kilómetro: $4,500

   Ejemplo: Un viaje de 10 km en servicio Premium = $8,000 + (10 × $3,000) = $38,000

2. **Recargos por Horario**

   El sistema cobra recargos diferentes según el día de la semana y la hora del viaje. Estos recargos se calculan como un porcentaje sobre la tarifa base calculada.

   **Fines de semana (Sábado y Domingo):**
   - De 0:00 a 5:59 (madrugada): 40% de recargo
   - De 6:00 a 21:59 (día): 20% de recargo
   - De 22:00 a 23:59 (noche): 35% de recargo

   **Entre semana (Lunes a Viernes):**
   - De 0:00 a 5:59 (madrugada): 30% de recargo
   - De 6:00 a 7:59 (hora pico mañana): 25% de recargo
   - De 8:00 a 16:59 (día normal): Sin recargo (0%)
   - De 17:00 a 19:59 (hora pico tarde): 25% de recargo
   - De 20:00 a 23:59 (noche): 15% de recargo

   Ejemplo: Viaje de $38,000 un martes a las 18:00 (hora pico tarde) → Recargo = $38,000 × 25% = $9,500

3. **Cargos Adicionales por Zona**

   Algunas zonas de la ciudad tienen cargos adicionales fijos:

   **Aeropuerto (origen O destino):**
   - Servicio económico: +$10,000
   - Servicio premium: +$15,000
   - Servicio ejecutivo: +$20,000

   **Centro (origen O destino):**
   - Cualquier servicio: +$5,000

   **Zona Norte ↔ Zona Sur (cuando el viaje cruza entre estas zonas):**
   - Cualquier servicio: +$8,000

   **Peaje (cuando la distancia es mayor a 15 km):**
   - Cualquier servicio: +$10,000

   Nota: Los cargos son acumulables. Si un viaje va del Aeropuerto (Zona Norte) al Centro (Zona Sur), se cobran todos los cargos aplicables.

4. **Descuentos para Clientes**

   La empresa ofrece descuentos según el tipo de cliente y características del viaje:

   **Descuento por ser cliente frecuente:**
   - Servicio económico: 5% de descuento
   - Servicio premium: 10% de descuento
   - Servicio ejecutivo: 15% de descuento

   **Descuento por viaje largo fuera de hora pico:**
   - Si el viaje es mayor a 20 km Y NO es hora pico: 8% de descuento adicional
   - Horas pico: lunes a viernes de 6:00-7:59 y de 17:00-19:59

   **Descuento por grupo en servicio ejecutivo:**
   - Si son más de 3 pasajeros Y servicio ejecutivo: 5% de descuento adicional

   Nota: Los descuentos son acumulables. Un cliente frecuente con viaje largo en ejecutivo puede acumular 15% + 8% + 5% = 28% de descuento total.

5. **Clasificación del Tipo de Viaje**

   El sistema clasifica cada viaje según su distancia y costo final:

   **Viajes cortos (distancia menor a 5 km):**
   - Si costo final < $15,000: "Viaje corto económico"
   - Si costo final ≥ $15,000: "Viaje corto premium"

   **Viajes medios (distancia de 5 a 20 km):**
   - Si costo final < $40,000: "Viaje medio estándar"
   - Si costo final ≥ $40,000: "Viaje medio ejecutivo"

   **Viajes largos (distancia mayor a 20 km):**
   - Si costo final < $60,000: "Viaje largo"
   - Si costo final ≥ $60,000: "Viaje largo premium"

6. **Cálculo del Costo Total**

   El costo final se calcula en el siguiente orden:
   1. Calcular tarifa base (según tipo de servicio y distancia)
   2. Aplicar recargo por horario (porcentaje sobre tarifa base)
   3. Sumar cargos adicionales por zonas
   4. Calcular subtotal
   5. Aplicar descuentos (porcentaje sobre subtotal)
   6. Obtener costo final

---

## Conceptos Importantes para Entender el Problema

### ¿Qué es la "Tarifa Base"?

La tarifa base es el costo fundamental del viaje antes de aplicar recargos o descuentos. Se compone de:
- **Banderazo**: Un costo fijo por iniciar el viaje (la "tarifa base" del servicio)
- **Costo por distancia**: Un valor que se multiplica por cada kilómetro recorrido

Ejemplo: En servicio Premium, si viajo 15 km:
- Banderazo: $8,000
- Distancia: 15 km × $3,000/km = $45,000
- Tarifa base total: $8,000 + $45,000 = $53,000

### ¿Qué significa "Hora Pico"?

Las horas pico son los momentos del día donde hay más tráfico y los viajes tardan más tiempo. El taxi cobra más porque:
- El conductor pasa más tiempo en el viaje
- Hay mayor demanda de servicio
- Se consume más combustible por el tráfico

Entre semana hay dos horas pico:
- Mañana (6:00-7:59): Cuando la gente va al trabajo
- Tarde (17:00-19:59): Cuando la gente regresa a casa

### ¿Cómo se aplican los recargos y descuentos?

**Recargos:** Se calculan como un porcentaje de la tarifa base
- Ejemplo: Tarifa base $50,000 con recargo del 25% → $50,000 × 0.25 = $12,500 adicionales

**Descuentos:** Se calculan como un porcentaje del subtotal (tarifa base + recargos + cargos)
- Ejemplo: Subtotal $75,000 con 10% descuento → $75,000 × 0.10 = $7,500 de descuento

### ¿Por qué las zonas tienen cargos adicionales?

- **Aeropuerto**: Está lejos y los taxis deben pagar peaje/estacionamiento
- **Centro**: Hay congestión y es difícil circular
- **Cruce Norte-Sur**: Son distancias largas que atraviesan toda la ciudad
- **Peaje**: El taxi paga el peaje y lo traslada al pasajero

---

## Ejemplos Resueltos

Para entender mejor cómo funciona el sistema, veamos varios casos reales:

### Ejemplo 1: Viaje Ejecutivo en Hora Pico con Cliente Frecuente

**Datos del Viaje:**
- Distancia: 12 km
- Día: Miércoles
- Hora: 18:30 (6:30 PM)
- Tipo de servicio: Ejecutivo
- Número de pasajeros: 2
- Zona origen: Centro
- Zona destino: Residencial (zona normal)
- Cliente frecuente: Sí

**Cálculo Paso a Paso:**

**Paso 1 - Calcular tarifa base (servicio ejecutivo):**
- Banderazo: $12,000
- Distancia: 12 km × $4,500/km = $54,000
- **Tarifa base: $12,000 + $54,000 = $66,000**

**Paso 2 - Determinar recargo horario:**
- Día: Miércoles (entre semana)
- Hora: 18:30
- ¿Está entre 17:00 y 19:59? SÍ → Hora pico tarde
- Recargo: 25%
- **Monto recargo: $66,000 × 0.25 = $16,500**

**Paso 3 - Calcular cargos por zona:**
- ¿Origen o destino es Aeropuerto? NO
- ¿Origen o destino es Centro? SÍ (origen es Centro)
  - Cargo: +$5,000
- ¿Viaje cruza Zona Norte ↔ Zona Sur? NO
- ¿Distancia > 15 km para peaje? NO (solo 12 km)
- **Total cargos adicionales: $5,000**

**Paso 4 - Calcular subtotal:**
- Tarifa base: $66,000
- Recargo horario: $16,500
- Cargos adicionales: $5,000
- **Subtotal: $66,000 + $16,500 + $5,000 = $87,500**

**Paso 5 - Calcular descuentos:**
- ¿Es cliente frecuente? SÍ
  - Servicio ejecutivo: 15% descuento
- ¿Viaje > 20 km y NO es hora pico? NO (es hora pico)
- ¿Más de 3 pasajeros en ejecutivo? NO (solo 2 pasajeros)
- **Total descuentos: 15%**
- **Monto descuento: $87,500 × 0.15 = $13,125**

**Paso 6 - Costo final:**
- Subtotal: $87,500
- Descuento: -$13,125
- **Costo final: $87,500 - $13,125 = $74,375**

**Paso 7 - Clasificar tipo de viaje:**
- Distancia: 12 km → ¿Entre 5 y 20 km? SÍ (viaje medio)
- Costo final: $74,375 → ¿≥ $40,000? SÍ
- **Clasificación: "Viaje medio ejecutivo"**

**Resultado Final:**
- Tarifa base: $66,000
- Recargo por hora pico: $16,500
- Cargos adicionales: $5,000
- Subtotal: $87,500
- Descuento (15%): -$13,125
- **COSTO TOTAL: $74,375**
- Tipo de viaje: Viaje medio ejecutivo

---

### Ejemplo 2: Viaje al Aeropuerto en Madrugada de Fin de Semana

**Datos del Viaje:**
- Distancia: 22 km
- Día: Sábado
- Hora: 4:30 (4:30 AM)
- Tipo de servicio: Premium
- Número de pasajeros: 1
- Zona origen: Zona Norte (residencia)
- Zona destino: Aeropuerto (Zona Sur)
- Cliente frecuente: No

**Análisis Completo:**

**Paso 1 - Calcular tarifa base (servicio premium):**
- Banderazo: $8,000
- Distancia: 22 km × $3,000/km = $66,000
- **Tarifa base: $8,000 + $66,000 = $74,000**

**Paso 2 - Determinar recargo horario:**
- Día: Sábado (fin de semana)
- Hora: 4:30
- ¿Está entre 0:00 y 5:59? SÍ → Madrugada
- Recargo fin de semana madrugada: 40%
- **Monto recargo: $74,000 × 0.40 = $29,600**

**Paso 3 - Calcular cargos por zona:**
- ¿Origen o destino es Aeropuerto? SÍ (destino)
  - Servicio premium: +$15,000
- ¿Origen o destino es Centro? NO
- ¿Viaje cruza Zona Norte ↔ Zona Sur? SÍ (origen Norte, destino Sur)
  - Cargo: +$8,000
- ¿Distancia > 15 km para peaje? SÍ (22 km > 15 km)
  - Cargo peaje: +$10,000
- **Total cargos adicionales: $15,000 + $8,000 + $10,000 = $33,000**

**Paso 4 - Calcular subtotal:**
- Tarifa base: $74,000
- Recargo horario: $29,600
- Cargos adicionales: $33,000
- **Subtotal: $74,000 + $29,600 + $33,000 = $136,600**

**Paso 5 - Calcular descuentos:**
- ¿Es cliente frecuente? NO → Sin descuento por cliente frecuente
- ¿Viaje > 20 km y NO es hora pico?
  - ¿Viaje > 20 km? SÍ (22 km)
  - ¿Es hora pico? NO (madrugada de sábado no es hora pico)
  - Descuento: 8%
- ¿Más de 3 pasajeros en ejecutivo? NO (no es ejecutivo)
- **Total descuentos: 8%**
- **Monto descuento: $136,600 × 0.08 = $10,928**

**Paso 6 - Costo final:**
- Subtotal: $136,600
- Descuento: -$10,928
- **Costo final: $136,600 - $10,928 = $125,672**

**Paso 7 - Clasificar tipo de viaje:**
- Distancia: 22 km → ¿Mayor a 20 km? SÍ (viaje largo)
- Costo final: $125,672 → ¿≥ $60,000? SÍ
- **Clasificación: "Viaje largo premium"**

**Resultado Final:**
- Tarifa base: $74,000
- Recargo madrugada fin de semana (40%): $29,600
- Cargos adicionales (Aeropuerto + Norte-Sur + Peaje): $33,000
- Subtotal: $136,600
- Descuento viaje largo (8%): -$10,928
- **COSTO TOTAL: $125,672**
- Tipo de viaje: Viaje largo premium

---

### Ejemplo 3: Viaje Económico Corto en Día Normal

**Datos del Viaje:**
- Distancia: 4 km
- Día: Martes
- Hora: 10:00 (10:00 AM)
- Tipo de servicio: Económico
- Número de pasajeros: 1
- Zona origen: Barrio residencial
- Zona destino: Centro comercial (no es Centro de la ciudad)
- Cliente frecuente: Sí

**Proceso Detallado:**

**Paso 1 - Calcular tarifa base (servicio económico):**
- Banderazo: $5,000
- Distancia: 4 km × $2,000/km = $8,000
- **Tarifa base: $5,000 + $8,000 = $13,000**

**Paso 2 - Determinar recargo horario:**
- Día: Martes (entre semana)
- Hora: 10:00
- ¿Está entre 8:00 y 16:59? SÍ → Día normal
- Recargo: 0% (sin recargo)
- **Monto recargo: $0**

**Paso 3 - Calcular cargos por zona:**
- ¿Origen o destino es Aeropuerto? NO
- ¿Origen o destino es Centro? NO (es centro comercial, no Centro de ciudad)
- ¿Viaje cruza Zona Norte ↔ Zona Sur? NO
- ¿Distancia > 15 km para peaje? NO (solo 4 km)
- **Total cargos adicionales: $0**

**Paso 4 - Calcular subtotal:**
- Tarifa base: $13,000
- Recargo horario: $0
- Cargos adicionales: $0
- **Subtotal: $13,000**

**Paso 5 - Calcular descuentos:**
- ¿Es cliente frecuente? SÍ
  - Servicio económico: 5% descuento
- ¿Viaje > 20 km y NO es hora pico? NO (solo 4 km)
- ¿Más de 3 pasajeros en ejecutivo? NO
- **Total descuentos: 5%**
- **Monto descuento: $13,000 × 0.05 = $650**

**Paso 6 - Costo final:**
- Subtotal: $13,000
- Descuento: -$650
- **Costo final: $13,000 - $650 = $12,350**

**Paso 7 - Clasificar tipo de viaje:**
- Distancia: 4 km → ¿Menor a 5 km? SÍ (viaje corto)
- Costo final: $12,350 → ¿< $15,000? SÍ
- **Clasificación: "Viaje corto económico"**

**Resultado Final:**
- Tarifa base: $13,000
- Recargo horario: $0
- Cargos adicionales: $0
- Subtotal: $13,000
- Descuento cliente frecuente (5%): -$650
- **COSTO TOTAL: $12,350**
- Tipo de viaje: Viaje corto económico

---

### Ejemplo 4: Viaje Ejecutivo con Grupo y Múltiples Descuentos

**Datos del Viaje:**
- Distancia: 25 km
- Día: Jueves
- Hora: 14:00 (2:00 PM)
- Tipo de servicio: Ejecutivo
- Número de pasajeros: 4
- Zona origen: Zona residencial
- Zona destino: Zona residencial (sin zonas especiales)
- Cliente frecuente: Sí

**Cálculo Detallado:**

**Paso 1 - Calcular tarifa base (servicio ejecutivo):**
- Banderazo: $12,000
- Distancia: 25 km × $4,500/km = $112,500
- **Tarifa base: $12,000 + $112,500 = $124,500**

**Paso 2 - Determinar recargo horario:**
- Día: Jueves (entre semana)
- Hora: 14:00
- ¿Está entre 8:00 y 16:59? SÍ → Día normal
- Recargo: 0%
- **Monto recargo: $0**

**Paso 3 - Calcular cargos por zona:**
- ¿Origen o destino es Aeropuerto? NO
- ¿Origen o destino es Centro? NO
- ¿Viaje cruza Zona Norte ↔ Zona Sur? NO
- ¿Distancia > 15 km para peaje? SÍ (25 km > 15 km)
  - Cargo peaje: +$10,000
- **Total cargos adicionales: $10,000**

**Paso 4 - Calcular subtotal:**
- Tarifa base: $124,500
- Recargo horario: $0
- Cargos adicionales: $10,000
- **Subtotal: $124,500 + $0 + $10,000 = $134,500**

**Paso 5 - Calcular descuentos (¡ACUMULABLES!):**
- ¿Es cliente frecuente? SÍ
  - Servicio ejecutivo: 15% descuento
- ¿Viaje > 20 km y NO es hora pico?
  - ¿Viaje > 20 km? SÍ (25 km)
  - ¿Es hora pico? NO (14:00 es día normal, no hora pico)
  - Descuento adicional: 8%
- ¿Más de 3 pasajeros en ejecutivo? SÍ (4 pasajeros)
  - Descuento adicional: 5%
- **Total descuentos: 15% + 8% + 5% = 28%**
- **Monto descuento: $134,500 × 0.28 = $37,660**

**Paso 6 - Costo final:**
- Subtotal: $134,500
- Descuento: -$37,660
- **Costo final: $134,500 - $37,660 = $96,840**

**Paso 7 - Clasificar tipo de viaje:**
- Distancia: 25 km → ¿Mayor a 20 km? SÍ (viaje largo)
- Costo final: $96,840 → ¿≥ $60,000? SÍ
- **Clasificación: "Viaje largo premium"**

**Resultado Final:**
- Tarifa base: $124,500
- Recargo horario: $0
- Cargos adicionales (Peaje): $10,000
- Subtotal: $134,500
- Descuentos acumulados (28%): -$37,660
  - Cliente frecuente ejecutivo: 15%
  - Viaje largo fuera hora pico: 8%
  - Grupo en ejecutivo: 5%
- **COSTO TOTAL: $96,840**
- Tipo de viaje: Viaje largo premium

**Observación importante:** Este ejemplo muestra cómo los descuentos se acumulan. El cliente ahorra $37,660 gracias a los tres descuentos combinados.

---

## Escenarios de Práctica para Resolver

### Escenario 1: Viaje matutino al trabajo

**Datos del Viaje:**
- Distancia: 8 km
- Día: Lunes
- Hora: 7:15 AM
- Tipo de servicio: Premium
- Número de pasajeros: 1
- Zona origen: Zona Norte (residencia)
- Zona destino: Centro (oficina)
- Cliente frecuente: Sí

**Preguntas:**
- ¿Cuál es la tarifa base?
- ¿Qué recargo horario aplica? ¿Por qué?
- ¿Qué cargos adicionales se aplican?
- ¿Qué descuentos recibe el cliente?
- ¿Cuál es el costo final?
- ¿Cómo se clasifica el viaje?

### Escenario 2: Comparación de servicios para el mismo viaje

**Datos comunes:**
- Distancia: 15 km
- Día: Viernes
- Hora: 22:30 (10:30 PM)
- Número de pasajeros: 2
- Zona origen: Centro
- Zona destino: Zona residencial
- Cliente frecuente: No

**Calcule el costo para:**
- Viaje A: Servicio Económico
- Viaje B: Servicio Premium
- Viaje C: Servicio Ejecutivo

**Preguntas:**
- ¿Cuál es la diferencia de precio entre cada servicio?
- ¿Qué recargo horario aplica?
- ¿Vale la pena pagar por el servicio ejecutivo en este caso?

### Escenario 3: Viaje al aeropuerto

**Datos del Viaje:**
- Distancia: 18 km
- Día: Domingo
- Hora: 15:00 (3:00 PM)
- Tipo de servicio: Ejecutivo
- Número de pasajeros: 4
- Zona origen: Zona Sur
- Zona destino: Aeropuerto (Zona Norte)
- Cliente frecuente: Sí

**Preguntas:**
- ¿Cuántos cargos adicionales se aplican? ¿Cuáles?
- ¿Qué descuentos recibe el cliente y por qué?
- ¿Cuál es el costo total?
- Si el cliente no fuera frecuente, ¿cuánto pagaría más?

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto del negocio y los ejemplos proporcionados, identifique:

a) **Atributos necesarios** para la clase `ViajeEnTaxi` (mínimo 9 atributos)
   - Información del viaje (distancia, zonas, pasajeros)
   - Información temporal (día, hora)
   - Tipo de servicio
   - Información del cliente

b) **Métodos necesarios** para implementar todas las operaciones descritas (mínimo 8 métodos)
   - Cálculo de tarifa base
   - Cálculo de recargos
   - Cálculo de cargos adicionales
   - Cálculo de descuentos
   - Cálculo de costo total
   - Clasificación del viaje
   - Generación de resumen

---

### 2. Diagrama de Clases

A continuación se presenta el diagrama de clases que debe implementar. **Su tarea es llenar la lógica de cada uno de los métodos** siguiendo las reglas de negocio descritas en este documento.

```
┌─────────────────────────────────────────────────────────┐
│                  ViajeEnTaxi                            │
├─────────────────────────────────────────────────────────┤
│ - distancia: double                                     │
│ - dia: String                                           │
│ - hora: int                                             │
│ - tipoServicio: String                                  │
│ - numeroPasajeros: int                                  │
│ - zonaOrigen: String                                    │
│ - zonaDestino: String                                   │
│ - clienteFrecuente: boolean                             │
├─────────────────────────────────────────────────────────┤
│ + ViajeEnTaxi(distancia, dia, hora, tipoServicio,      │
│               numeroPasajeros, zonaOrigen, zonaDestino, │
│               clienteFrecuente)                         │
│ + calcularTarifaBase(): double                          │
│ + calcularRecargoHorario(): double                      │
│ + calcularCargosAdicionales(): double                   │
│ + calcularDescuentos(): double                          │
│ + esHoraPico(): boolean                                 │
│ + calcularCostoTotal(): double                          │
│ + determinarTipoViaje(): String                         │
│ + generarResumenViaje(): void                           │
└─────────────────────────────────────────────────────────┘
```

**Descripción de los métodos que debe implementar:**

1. **calcularTarifaBase()**: Calcula la tarifa según tipo de servicio y distancia
   - Económico: $5,000 + (distancia × $2,000)
   - Premium: $8,000 + (distancia × $3,000)
   - Ejecutivo: $12,000 + (distancia × $4,500)
   - Retorna el monto de la tarifa base

2. **calcularRecargoHorario()**: Calcula el recargo según día y hora
   - Usa decisiones anidadas: primero evalúa si es fin de semana o entre semana
   - Luego según el día, evalúa la hora para determinar el recargo
   - Retorna el monto del recargo (porcentaje de la tarifa base)

3. **calcularCargosAdicionales()**: Calcula todos los cargos por zonas
   - Verifica Aeropuerto, Centro, cruce Norte-Sur, peaje
   - Suma todos los cargos aplicables
   - Retorna el total de cargos adicionales

4. **calcularDescuentos()**: Calcula el porcentaje total de descuentos
   - Verifica descuento por cliente frecuente (según tipo de servicio)
   - Verifica descuento por viaje largo fuera de hora pico
   - Verifica descuento por grupo en ejecutivo
   - Suma todos los porcentajes y retorna el total

5. **esHoraPico()**: Determina si el viaje es en hora pico
   - Solo entre semana: 6:00-7:59 y 17:00-19:59
   - Retorna true o false

6. **calcularCostoTotal()**: Calcula el costo final del viaje
   - Tarifa base + recargo + cargos - descuentos
   - Retorna el costo total

7. **determinarTipoViaje()**: Clasifica el viaje según distancia y costo
   - Usa decisiones anidadas: primero por distancia, luego por costo
   - Retorna la clasificación del viaje

8. **generarResumenViaje()**: Imprime un resumen completo del viaje
   - Muestra todos los detalles, cargos, descuentos y costo total

---

### 3. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

a) **Método calcularTarifaBase()**
   - Debe considerar el tipo de servicio
   - Calcular banderazo + (distancia × costo por km)
   - Retornar la tarifa base

b) **Método calcularRecargoHorario()**
   - Primero debe determinar si es fin de semana o entre semana
   - Según el día, evaluar la hora para determinar el período
   - Aplicar el porcentaje de recargo correspondiente
   - Retornar el monto del recargo
   - **Importante:** Este método requiere decisiones anidadas (primero día, luego hora)

c) **Método calcularCargosAdicionales()**
   - Verificar si origen o destino es Aeropuerto
   - Verificar si origen o destino es Centro
   - Verificar si cruza Zona Norte ↔ Zona Sur
   - Verificar si aplica peaje (distancia > 15 km)
   - Sumar todos los cargos que apliquen
   - Retornar total de cargos adicionales

d) **Método calcularDescuentos()**
   - Verificar descuento por cliente frecuente (según tipo de servicio)
   - Verificar descuento por viaje largo fuera de hora pico
   - Verificar descuento por grupo en ejecutivo
   - Sumar todos los porcentajes de descuento
   - Retornar el porcentaje total de descuento

e) **Método determinarTipoViaje()**
   - Clasificar primero por distancia (corto/medio/largo)
   - Dentro de cada categoría, clasificar por costo
   - Retornar la clasificación completa

### 4. Implementación en Java

**Instrucciones:** Implemente la clase completa `ViajeEnTaxi` en Java con:

- Todos los atributos identificados
- Constructor que inicialice todos los datos del viaje
- Todos los métodos identificados con su lógica completa
- Un método `generarResumenViaje()` que imprima:
  - Información del viaje (distancia, día, hora, servicio)
  - Tarifa base
  - Recargos aplicados y su monto
  - Cargos adicionales y detalle
  - Subtotal
  - Descuentos aplicados y porcentaje total
  - Costo total final
  - Clasificación del viaje

**Consideraciones importantes:**
- Use solo estructuras de decisión (if, else if, else, switch)
- NO use arreglos, listas o colecciones
- Todos los cálculos deben estar en una sola clase
- Use tipos de datos apropiados:
  - `double` para distancia, montos y porcentajes
  - `int` para hora y número de pasajeros
  - `String` para día, zonas, tipo de servicio
  - `boolean` para cliente frecuente
- El método `calcularRecargoHorario()` debe usar switch para el día y if anidados para la hora
- Los descuentos se aplican al subtotal, no a la tarifa base
- Recuerde que los descuentos son acumulables (se suman los porcentajes)

### 5. Método Main de Prueba

Cree un método main que pruebe su clase con al menos 5 viajes diferentes que incluyan:
- Un viaje en hora pico entre semana
- Un viaje en fin de semana
- Un viaje al aeropuerto
- Un viaje con múltiples descuentos acumulados
- Un viaje económico corto

Para cada viaje, llame al método `generarResumenViaje()` para ver el desglose completo.

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
   - Uso apropiado de decisiones anidadas (especialmente en recargo horario)
   - Manejo correcto de condiciones múltiples
   - Uso de switch-case donde sea apropiado
   - Claridad y organización

4. **Implementación en Java** (35%)
   - Sintaxis correcta
   - Lógica completa y funcional
   - Manejo adecuado de todas las reglas del negocio
   - Correcta implementación de decisiones anidadas
   - Cálculo correcto de porcentajes
   - Acumulación correcta de descuentos

5. **Método main y pruebas** (5%)
   - Casos de prueba representativos
   - Cobertura de diferentes escenarios (días, horas, servicios, zonas)

---

## Notas Finales

- Este ejercicio está diseñado para practicar decisiones múltiples anidadas en varios niveles
- El cálculo del recargo horario requiere decisiones anidadas: primero evaluar el día, luego según el día, evaluar la hora
- Los cargos adicionales pueden acumularse - un viaje puede tener varios cargos a la vez
- Los descuentos también se acumulan - sume los porcentajes antes de aplicar al subtotal
- Preste atención al orden de los cálculos: base → recargos → cargos → subtotal → descuentos → total
- Use switch-case para el día de la semana, es más claro que múltiples if
- Use comentarios para explicar las decisiones anidadas complejas
- Recuerde que "hora pico" solo aplica entre semana, no fines de semana
- El peaje solo se cobra cuando la distancia es mayor a 15 km
- Los descuentos se calculan sobre el subtotal (después de sumar todo), no sobre la tarifa base
