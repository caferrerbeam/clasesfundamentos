# 🪙 Sistema de Gestión de Portafolio de Criptomonedas

## Contexto del Problema

Eres un trader de criptomonedas que necesita llevar el control de tus operaciones de compra y venta. Has decidido trabajar únicamente con **5 criptomonedas específicas** que consideras las más prometedoras del mercado.

Tu sistema debe registrar **UNA operación a la vez** (ya sea compra o venta) y mantener el control actualizado de tu portafolio, mostrando estadísticas y análisis después de cada operación.

## Las 5 Criptomonedas Disponibles

Tu portafolio solo puede incluir estas criptomonedas:

1. **Bitcoin (BTC)**
2. **Ethereum (ETH)**
3. **Cardano (ADA)**
4. **Solana (SOL)**
5. **Ripple (XRP)**

## Información de Cada Operación

Cuando realizas una operación, debes registrar:

- **Tipo de operación**: "Compra" o "Venta"
- **Criptomoneda**: Una de las 5 disponibles (BTC, ETH, ADA, SOL, XRP)
- **Cantidad de monedas**: Cuántas unidades estás comprando o vendiendo
- **Precio unitario**: Precio en dólares de cada moneda en el momento de la operación
- **Día de la semana**: "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" o "Domingo"
- **Hora del día**: Número entre 0 y 23 (formato 24 horas)

## Determinación del Período del Día

El sistema debe determinar automáticamente el período según la hora ingresada:

- **Mañana**: Si la hora está entre 6 y 11 (inclusive) → 6:00 AM a 11:59 AM
- **Tarde**: Si la hora está entre 12 y 17 (inclusive) → 12:00 PM a 5:59 PM
- **Noche**: Si la hora está entre 18 y 23, o entre 0 y 5 → 6:00 PM a 5:59 AM

**Ejemplos:**
- Hora = 8 → Mañana
- Hora = 14 → Tarde
- Hora = 20 → Noche
- Hora = 3 → Noche

## Estado del Portafolio (Por cada Criptomoneda)

Tu sistema debe mantener y calcular para **CADA** una de las 5 criptomonedas:

- **Cantidad total comprada**: Suma de todas las monedas compradas
- **Cantidad total vendida**: Suma de todas las monedas vendidas
- **Cantidad actual en portafolio**: Compradas - Vendidas
- **Dinero invertido total**: Suma del costo de todas las compras (SIN incluir comisiones)
- **Dinero recuperado total**: Suma del ingreso de todas las ventas (SIN incluir comisiones)
- **Precio promedio de compra**: Dinero invertido / Cantidad comprada (si hay compras)
- **Precio promedio de venta**: Dinero recuperado / Cantidad vendida (si hay ventas)
- **Ganancia/Pérdida realizada**: Dinero recuperado - Dinero invertido proporcional a las ventas
- **Total pagado en comisiones**: Suma de todas las comisiones pagadas en esa cripto

## Control Global de Comisiones

El sistema debe llevar el control de:

- **Comisiones totales pagadas**: Suma de TODAS las comisiones de TODAS las operaciones realizadas
- **Comisiones pagadas por cada criptomoneda**: Desglose individual

## Análisis Requeridos

### 1. Análisis por Criptomoneda
Para cada cripto, calcular:
- Rentabilidad porcentual: ((Precio promedio venta - Precio promedio compra) / Precio promedio compra) × 100
- Estado: "Ganancia", "Pérdida" o "Sin ventas aún"
- Total pagado en comisiones para esa cripto específica

### 2. Análisis General del Portafolio
- **Ganancia/Pérdida total**: Suma de ganancias/pérdidas de todas las criptos
- **Valor total invertido**: Suma de todo el dinero invertido en compras
- **Valor total recuperado**: Suma de todo el dinero de ventas
- **Cripto con mejor rentabilidad**: La que tiene mayor porcentaje de ganancia
- **Cripto con peor rentabilidad**: La que tiene menor porcentaje (puede ser negativo)
- **Total acumulado en comisiones**: Todo el dinero pagado en comisiones desde el inicio

### 3. Comisiones Especiales por Horario y Día

Las comisiones varían según el **día de la semana** Y el **período del día** (determinado por la hora):

#### Por Día de la Semana:
- **Lunes a Viernes**: Comisión base 0.5%
- **Sábado**: Comisión base 0.8% (fin de semana)
- **Domingo**: Comisión base 1.0% (menor liquidez)

#### Ajuste Adicional por Período del Día:
- **Mañana** (hora 6-11): Sin ajuste adicional
- **Tarde** (hora 12-17): +0.2% adicional (alta volatilidad)
- **Noche** (hora 18-23 o 0-5): +0.5% adicional (baja liquidez)

**Ejemplo de cálculo de comisión:**
- Si operas un **Sábado** a las **21 horas** (Noche): 0.8% (sábado) + 0.5% (noche) = **1.3% de comisión**
- Si operas un **Martes** a las **9 horas** (Mañana): 0.5% (martes) + 0% (mañana) = **0.5% de comisión**
- Si operas un **Viernes** a las **15 horas** (Tarde): 0.5% (viernes) + 0.2% (tarde) = **0.7% de comisión**

### 4. Alertas y Recomendaciones Especiales

Según la **criptomoneda específica**, debes mostrar alertas:

#### Para Bitcoin (BTC):
- Si el precio de compra es **mayor a $60,000**: "⚠️ ALERTA: BTC en precio histórico alto"
- Si el precio de venta es **menor a $30,000**: "⚠️ ALERTA: Posible venta en pérdida de BTC"

#### Para Ethereum (ETH):
- Si el precio de compra es **mayor a $3,500**: "⚠️ ALERTA: ETH cerca de máximo histórico"
- Si compras **más de 10 ETH**: "💎 Compra grande de ETH detectada"

#### Para Cardano (ADA):
- Si el precio es **menor a $0.30**: "🔥 OPORTUNIDAD: ADA en precio bajo"
- Si vendes con **ganancia mayor al 50%**: "🎉 Excelente operación con ADA"

#### Para Solana (SOL):
- Si el precio es **mayor a $150**: "⚠️ PRECAUCIÓN: SOL en zona de resistencia"
- Si compras en **fin de semana** (Sábado o Domingo): "⏰ Compra de SOL en fin de semana - Mayor volatilidad"

#### Para Ripple (XRP):
- Si el precio es **menor a $0.50**: "💰 Precio atractivo de XRP"
- Si vendes **más de 1000 XRP**: "📊 Venta significativa de XRP"

### 5. Recomendación de Estrategia

Basado en el **período del día** (determinado por la hora), mostrar recomendación:

#### Si es Mañana (hora 6-11):
- **Y es Lunes a Viernes**: "✅ Horario óptimo para operar - Buena liquidez"
- **Y es fin de semana**: "⚠️ Liquidez moderada en fin de semana"

#### Si es Tarde (hora 12-17):
- **Y es Lunes a Viernes**: "📊 Alta volatilidad esperada - Oportunidades y riesgos"
- **Y es fin de semana**: "⚠️ Comisiones más altas en fin de semana"

#### Si es Noche (hora 18-23 o 0-5):
- **Para cualquier día**: "🌙 Comisión alta por baja liquidez - Considere operar en la mañana"

---

## 🎯 Historia de Trading: Ejemplos Encadenados

### 📅 LUNES - Operación 1: Iniciando el Portafolio con Bitcoin

**Contexto:** Es tu primera operación. Decides comenzar comprando Bitcoin en un horario óptimo.

**Operación:**
- Tipo: Compra
- Cripto: Bitcoin (BTC)
- Cantidad: 0.5 BTC
- Precio unitario: $45,000
- Día: Lunes
- Hora: 9

**Paso 1: Determinar el período del día**

> 💡 **Recuerda:** Según las reglas de determinación del período:
> - Mañana: hora entre 6 y 11
> - Tarde: hora entre 12 y 17
> - Noche: hora entre 18-23 o 0-5

- Hora = 9, está entre 6 y 11 → **Mañana**

**Paso 2: Calcular el monto de la operación**

> 💡 **Recuerda:** Monto de operación = Cantidad × Precio unitario

- Monto de operación: 0.5 × $45,000 = $22,500

**Paso 3: Calcular la comisión**

> 💡 **Recuerda:** La comisión tiene dos componentes:
> - Comisión base por día: Lunes a Viernes = 0.5%, Sábado = 0.8%, Domingo = 1.0%
> - Ajuste por período: Mañana = 0%, Tarde = +0.2%, Noche = +0.5%

- Día: Lunes (día laboral) → 0.5% base
- Período: Mañana → +0% adicional
- Comisión total: 0.5% + 0% = 0.5%
- Comisión en dólares: $22,500 × 0.005 = $112.50
- Costo total: $22,500 + $112.50 = $22,612.50

**Paso 4: Actualizar el estado del portafolio de BTC**

> 💡 **Recuerda:** Al comprar, actualizas:
> - Cantidad comprada (suma)
> - Dinero invertido (suma, SIN incluir comisiones)
> - Precio promedio = Dinero invertido / Cantidad comprada
> - Comisiones pagadas (suma)

**Estado del Portafolio BTC:**
- Cantidad comprada: 0 + 0.5 = 0.5 BTC
- Cantidad vendida: 0 BTC
- Cantidad actual: 0.5 - 0 = 0.5 BTC
- Dinero invertido: $0 + $22,500 = $22,500
- Dinero recuperado: $0
- Precio promedio compra: $22,500 / 0.5 = $45,000
- Ganancia/Pérdida: $0 (aún no hay ventas)
- Comisiones pagadas en BTC: $0 + $112.50 = $112.50

**Estado de Otras Criptos:**
- ETH: Sin operaciones
- ADA: Sin operaciones
- SOL: Sin operaciones
- XRP: Sin operaciones

**Paso 5: Actualizar el resumen general**

> 💡 **Recuerda:** El resumen general suma valores de TODAS las criptos

**Resumen General del Portafolio:**
- Valor total invertido: $22,500 (solo BTC)
- Valor total recuperado: $0
- Ganancia/Pérdida total: $0
- Comisiones totales pagadas: $112.50
- Cripto con mejor rentabilidad: N/A (sin ventas)

**Desglose de Comisiones:**
- BTC: $112.50
- ETH: $0
- ADA: $0
- SOL: $0
- XRP: $0
- **TOTAL: $112.50**

**Paso 6: Evaluar alertas específicas de Bitcoin**

> 💡 **Recuerda:** Para BTC, las alertas son:
> - Si precio de compra > $60,000: "ALERTA: BTC en precio histórico alto"
> - Si precio de venta < $30,000: "ALERTA: Posible venta en pérdida de BTC"

- Precio de compra: $45,000 (no es mayor a $60,000)
- Alertas: Ninguna

**Paso 7: Mostrar recomendación de estrategia**

> 💡 **Recuerda:** La recomendación depende del período Y del día:
> - Mañana + Lunes a Viernes: "Horario óptimo para operar - Buena liquidez"
> - Mañana + Fin de semana: "Liquidez moderada en fin de semana"
> - Tarde + Lunes a Viernes: "Alta volatilidad esperada"
> - Tarde + Fin de semana: "Comisiones más altas en fin de semana"
> - Noche + Cualquier día: "Comisión alta por baja liquidez"

- Período: Mañana
- Día: Lunes (laboral)
- Recomendación: "✅ Horario óptimo para operar - Buena liquidez"

**Análisis Final:**
- Estado BTC: "Sin ventas aún"
- Período del día: Mañana
- Alertas: Ninguna
- Recomendación: "✅ Horario óptimo para operar - Buena liquidez"

---

### 📅 MIÉRCOLES - Operación 2: Diversificando con Cardano

**Contexto:** Dos días después, ves que Cardano está a buen precio. Decides diversificar tu portafolio.

**Estado previo del portafolio:**
- BTC: 0.5 BTC en portafolio, $22,500 invertidos, $112.50 en comisiones
- Comisiones totales acumuladas: $112.50

**Operación:**
- Tipo: Compra
- Cripto: Cardano (ADA)
- Cantidad: 2000 ADA
- Precio unitario: $0.28
- Día: Miércoles
- Hora: 14

**Paso 1: Determinar el período del día**

> 💡 **Recuerda:** Hora 14 está entre 12 y 17 → Tarde

- Hora = 14, está entre 12 y 17 → **Tarde**

**Paso 2: Calcular el monto de la operación**

- Monto de operación: 2000 × $0.28 = $560

**Paso 3: Calcular la comisión**

> 💡 **Recuerda:** Miércoles es día laboral (0.5% base) y Tarde tiene +0.2% adicional

- Día: Miércoles (día laboral) → 0.5% base
- Período: Tarde → +0.2% adicional
- Comisión total: 0.5% + 0.2% = 0.7%
- Comisión en dólares: $560 × 0.007 = $3.92
- Costo total: $560 + $3.92 = $563.92

**Paso 4: Actualizar el estado del portafolio de ADA**

> 💡 **Recuerda:** Esta es la primera compra de ADA, así que partimos de cero

**Estado del Portafolio ADA:**
- Cantidad comprada: 0 + 2000 = 2000 ADA
- Cantidad vendida: 0 ADA
- Cantidad actual: 2000 - 0 = 2000 ADA
- Dinero invertido: $0 + $560 = $560
- Dinero recuperado: $0
- Precio promedio compra: $560 / 2000 = $0.28
- Ganancia/Pérdida: $0
- Comisiones pagadas en ADA: $0 + $3.92 = $3.92

**Estado del Portafolio BTC (sin cambios):**
- Cantidad actual: 0.5 BTC
- Dinero invertido: $22,500
- Comisiones pagadas en BTC: $112.50

**Paso 5: Actualizar el resumen general**

> 💡 **Recuerda:** Ahora debes sumar los valores de BTC y ADA

**Resumen General del Portafolio:**
- Valor total invertido: $22,500 (BTC) + $560 (ADA) = $23,060
- Valor total recuperado: $0
- Ganancia/Pérdida total: $0
- Comisiones totales pagadas: $112.50 + $3.92 = $116.42
- Cripto con mejor rentabilidad: N/A (sin ventas)

**Desglose de Comisiones:**
- BTC: $112.50
- ETH: $0
- ADA: $3.92
- SOL: $0
- XRP: $0
- **TOTAL: $116.42**

**Paso 6: Evaluar alertas específicas de Cardano**

> 💡 **Recuerda:** Para ADA, las alertas son:
> - Si precio < $0.30: "OPORTUNIDAD: ADA en precio bajo"
> - Si vendes con ganancia > 50%: "Excelente operación con ADA"

- Precio: $0.28 (es menor a $0.30) ✓
- Alertas: "🔥 OPORTUNIDAD: ADA en precio bajo"

**Paso 7: Mostrar recomendación de estrategia**

- Período: Tarde
- Día: Miércoles (laboral)
- Recomendación: "📊 Alta volatilidad esperada - Oportunidades y riesgos"

**Análisis Final:**
- Estado ADA: "Sin ventas aún"
- Período del día: Tarde
- Alertas: "🔥 OPORTUNIDAD: ADA en precio bajo"
- Recomendación: "📊 Alta volatilidad esperada - Oportunidades y riesgos"

---

### 📅 VIERNES - Operación 3: Comprando más Cardano en horario nocturno

**Contexto:** El precio de Cardano sigue bajando. Decides comprar más para promediar tu precio, pero es tarde en la noche.

**Estado previo del portafolio:**
- BTC: 0.5 BTC, invertido $22,500, comisiones $112.50
- ADA: 2000 ADA (precio promedio $0.28), invertido $560, comisiones $3.92
- Comisiones totales: $116.42

**Operación:**
- Tipo: Compra
- Cripto: Cardano (ADA)
- Cantidad: 3000 ADA
- Precio unitario: $0.25
- Día: Viernes
- Hora: 21

**Paso 1: Determinar el período del día**

> 💡 **Recuerda:** Hora 21 está entre 18 y 23 → Noche

- Hora = 21, está entre 18 y 23 → **Noche**

**Paso 2: Calcular el monto de la operación**

- Monto de operación: 3000 × $0.25 = $750

**Paso 3: Calcular la comisión**

> 💡 **Recuerda:** Viernes es día laboral (0.5% base) pero Noche tiene +0.5% adicional

- Día: Viernes (día laboral) → 0.5% base
- Período: Noche → +0.5% adicional
- Comisión total: 0.5% + 0.5% = 1.0%
- Comisión en dólares: $750 × 0.01 = $7.50
- Costo total: $750 + $7.50 = $757.50

**Paso 4: Actualizar el estado del portafolio de ADA**

> 💡 **Recuerda:** Ya tenías 2000 ADA. Al comprar más, debes:
> - SUMAR las cantidades compradas
> - SUMAR el dinero invertido
> - RECALCULAR el precio promedio = Total invertido / Total comprado

**Estado del Portafolio ADA (ACTUALIZADO):**
- Cantidad comprada: 2000 + 3000 = 5000 ADA
- Cantidad vendida: 0 ADA
- Cantidad actual: 5000 - 0 = 5000 ADA
- Dinero invertido: $560 + $750 = $1,310
- Dinero recuperado: $0
- Precio promedio compra: $1,310 / 5000 = $0.262 ← **¡Cambió!**
- Ganancia/Pérdida: $0
- Comisiones pagadas en ADA: $3.92 + $7.50 = $11.42

**Estado del Portafolio BTC (sin cambios):**
- Cantidad actual: 0.5 BTC
- Dinero invertido: $22,500
- Comisiones pagadas en BTC: $112.50

**Paso 5: Actualizar el resumen general**

**Resumen General del Portafolio:**
- Valor total invertido: $22,500 + $1,310 = $23,810
- Valor total recuperado: $0
- Ganancia/Pérdida total: $0
- Comisiones totales pagadas: $112.50 + $11.42 = $123.92
- Cripto con mejor rentabilidad: N/A (sin ventas)

**Desglose de Comisiones:**
- BTC: $112.50
- ETH: $0
- ADA: $11.42
- SOL: $0
- XRP: $0
- **TOTAL: $123.92**

**Paso 6: Evaluar alertas**

- Precio: $0.25 (es menor a $0.30) ✓
- Alertas: "🔥 OPORTUNIDAD: ADA en precio bajo"

**Paso 7: Mostrar recomendación de estrategia**

> 💡 **Recuerda:** Noche siempre da la misma recomendación sin importar el día

- Período: Noche
- Recomendación: "🌙 Comisión alta por baja liquidez - Considere operar en la mañana"

**Análisis Final:**
- Estado ADA: "Sin ventas aún"
- Período del día: Noche
- Alertas: "🔥 OPORTUNIDAD: ADA en precio bajo"
- Recomendación: "🌙 Comisión alta por baja liquidez - Considere operar en la mañana"
- **Nota:** El precio promedio de compra de ADA bajó de $0.28 a $0.262

---

### 📅 LUNES SIGUIENTE - Operación 4: Primera Venta - Tomando Ganancias en Cardano

**Contexto:** Una semana después, Cardano subió significativamente. Decides tomar ganancias vendiendo parte de tu posición en horario óptimo.

**Estado previo del portafolio:**
- BTC: 0.5 BTC, invertido $22,500, comisiones $112.50
- ADA: 5000 ADA (precio promedio $0.262), invertido $1,310, comisiones $11.42
- Comisiones totales: $123.92

**Operación:**
- Tipo: Venta
- Cripto: Cardano (ADA)
- Cantidad: 3000 ADA
- Precio unitario: $0.45
- Día: Lunes
- Hora: 10

**Paso 1: Determinar el período del día**

- Hora = 10, está entre 6 y 11 → **Mañana**

**Paso 2: Calcular el monto de la operación**

- Monto de operación: 3000 × $0.45 = $1,350

**Paso 3: Calcular la comisión**

> 💡 **Recuerda:** Lunes es día laboral (0.5% base) y Mañana no tiene ajuste adicional

- Día: Lunes (día laboral) → 0.5% base
- Período: Mañana → +0% adicional
- Comisión total: 0.5% + 0% = 0.5%
- Comisión en dólares: $1,350 × 0.005 = $6.75
- Ingreso neto: $1,350 - $6.75 = $1,343.25

**Paso 4: Actualizar el estado del portafolio de ADA**

> 💡 **Recuerda:** Al VENDER, actualizas:
> - Cantidad vendida (suma)
> - Cantidad actual (compradas - vendidas)
> - Dinero recuperado (suma, SIN incluir comisiones)
> - Precio promedio de venta = Dinero recuperado / Cantidad vendida
> - Ganancia = Dinero recuperado - (Cantidad vendida × Precio promedio compra)
> - Rentabilidad = ((Precio venta - Precio compra) / Precio compra) × 100

**Estado del Portafolio ADA (ACTUALIZADO):**
- Cantidad comprada: 5000 ADA (sin cambio)
- Cantidad vendida: 0 + 3000 = 3000 ADA
- Cantidad actual: 5000 - 3000 = 2000 ADA
- Dinero invertido: $1,310 (sin cambio)
- Dinero recuperado: $0 + $1,350 = $1,350
- Precio promedio compra: $0.262 (sin cambio)
- Precio promedio venta: $1,350 / 3000 = $0.45
- Costo de las 3000 vendidas: 3000 × $0.262 = $786
- **Ganancia realizada: $1,350 - $786 = $564** ← ¡Primera ganancia!
- **Rentabilidad: (($0.45 - $0.262) / $0.262) × 100 = 71.76%**
- Comisiones pagadas en ADA: $11.42 + $6.75 = $18.17

**Estado del Portafolio BTC (sin cambios):**
- Cantidad actual: 0.5 BTC
- Dinero invertido: $22,500
- Comisiones pagadas en BTC: $112.50

**Paso 5: Actualizar el resumen general**

> 💡 **Recuerda:** Ahora que tienes una venta, puedes calcular ganancia total

**Resumen General del Portafolio:**
- Valor total invertido: $23,810
- Valor total recuperado: $1,350
- **Ganancia/Pérdida total: $564** (solo de ADA)
- Comisiones totales pagadas: $112.50 + $18.17 = $130.67
- **Cripto con mejor rentabilidad: Cardano (ADA) con 71.76%**
- **Cripto con peor rentabilidad: Cardano (ADA) con 71.76%** (única con ventas)

**Desglose de Comisiones:**
- BTC: $112.50
- ETH: $0
- ADA: $18.17
- SOL: $0
- XRP: $0
- **TOTAL: $130.67**

**Paso 6: Evaluar alertas específicas de Cardano**

> 💡 **Recuerda:** Para ADA en venta, verificar si la ganancia es > 50%

- Rentabilidad: 71.76% (es mayor a 50%) ✓
- Alertas: "🎉 Excelente operación con ADA"

**Paso 7: Mostrar recomendación de estrategia**

- Período: Mañana
- Día: Lunes (laboral)
- Recomendación: "✅ Horario óptimo para operar - Buena liquidez"

**Análisis Final:**
- Estado ADA: "Ganancia"
- Rentabilidad ADA: 71.76%
- Período del día: Mañana
- Alertas: "🎉 Excelente operación con ADA"
- Recomendación: "✅ Horario óptimo para operar - Buena liquidez"
- **Nota importante:** Has ganado $564 pero has pagado $130.67 en comisiones totales (23.17% de tus ganancias)

---

### 📅 MIÉRCOLES - Operación 5: Agregando Ethereum al Portafolio

**Contexto:** Con las ganancias de Cardano, decides diversificar más comprando Ethereum en la tarde.

**Estado previo del portafolio:**
- BTC: 0.5 BTC, invertido $22,500, comisiones $112.50
- ADA: 2000 ADA, invertido $1,310, recuperado $1,350, ganancia $564, comisiones $18.17
- Comisiones totales: $130.67
- Ganancia total: $564

**Operación:**
- Tipo: Compra
- Cripto: Ethereum (ETH)
- Cantidad: 12 ETH
- Precio unitario: $3,100
- Día: Miércoles
- Hora: 15

**Paso 1: Determinar el período del día**

- Hora = 15, está entre 12 y 17 → **Tarde**

**Paso 2: Calcular el monto de la operación**

- Monto de operación: 12 × $3,100 = $37,200

**Paso 3: Calcular la comisión**

- Día: Miércoles (día laboral) → 0.5% base
- Período: Tarde → +0.2% adicional
- Comisión total: 0.5% + 0.2% = 0.7%
- Comisión en dólares: $37,200 × 0.007 = $260.40
- Costo total: $37,200 + $260.40 = $37,460.40

**Paso 4: Actualizar el estado del portafolio de ETH**

> 💡 **Recuerda:** Esta es la primera operación de ETH

**Estado del Portafolio ETH:**
- Cantidad comprada: 0 + 12 = 12 ETH
- Cantidad vendida: 0 ETH
- Cantidad actual: 12 - 0 = 12 ETH
- Dinero invertido: $0 + $37,200 = $37,200
- Dinero recuperado: $0
- Precio promedio compra: $37,200 / 12 = $3,100
- Ganancia/Pérdida: $0
- Comisiones pagadas en ETH: $0 + $260.40 = $260.40

**Estados de las demás criptos (sin cambios):**
- BTC: 0.5 BTC, invertido $22,500, comisiones $112.50
- ADA: 2000 ADA, ganancia $564, comisiones $18.17

**Paso 5: Actualizar el resumen general**

> 💡 **Recuerda:** Suma inversiones de BTC, ETH y ADA

**Resumen General del Portafolio:**
- Valor total invertido: $22,500 + $1,310 + $37,200 = $61,010
- Valor total recuperado: $1,350
- Ganancia/Pérdida total: $564 (solo de ADA)
- Comisiones totales pagadas: $112.50 + $18.17 + $260.40 = $391.07
- Cripto con mejor rentabilidad: Cardano (ADA) con 71.76%
- Cripto con peor rentabilidad: Cardano (ADA) con 71.76% (única con ventas)

**Desglose de Comisiones:**
- BTC: $112.50
- ETH: $260.40
- ADA: $18.17
- SOL: $0
- XRP: $0
- **TOTAL: $391.07**

**Paso 6: Evaluar alertas específicas de Ethereum**

> 💡 **Recuerda:** Para ETH, las alertas son:
> - Si precio de compra > $3,500: "ALERTA: ETH cerca de máximo histórico"
> - Si compras > 10 ETH: "Compra grande de ETH detectada"

- Precio: $3,100 (no es mayor a $3,500)
- Cantidad: 12 ETH (es mayor a 10) ✓
- Alertas: "💎 Compra grande de ETH detectada"

**Paso 7: Mostrar recomendación de estrategia**

- Período: Tarde
- Día: Miércoles (laboral)
- Recomendación: "📊 Alta volatilidad esperada - Oportunidades y riesgos"

**Análisis Final:**
- Estado ETH: "Sin ventas aún"
- Período del día: Tarde
- Alertas: "💎 Compra grande de ETH detectada"
- Recomendación: "📊 Alta volatilidad esperada - Oportunidades y riesgos"
- **Nota crítica:** Las comisiones totales ($391.07) representan 69.34% de tus ganancias totales ($564)

---

### 📅 SÁBADO - Operación 6: Venta de Bitcoin en Fin de Semana

**Contexto:** Bitcoin subió de precio y decides tomar ganancias, aunque sea fin de semana por la noche (peor horario para comisiones).

**Estado previo del portafolio:**
- BTC: 0.5 BTC (precio promedio $45,000), invertido $22,500, comisiones $112.50
- ETH: 12 ETH, invertido $37,200, comisiones $260.40
- ADA: 2000 ADA, ganancia realizada $564, comisiones $18.17
- Comisiones totales: $391.07
- Ganancia total: $564

**Operación:**
- Tipo: Venta
- Cripto: Bitcoin (BTC)
- Cantidad: 0.3 BTC
- Precio unitario: $52,000
- Día: Sábado
- Hora: 22

**Paso 1: Determinar el período del día**

- Hora = 22, está entre 18 y 23 → **Noche**

**Paso 2: Calcular el monto de la operación**

- Monto de operación: 0.3 × $52,000 = $15,600

**Paso 3: Calcular la comisión**

> 💡 **Recuerda:** Sábado es fin de semana (0.8% base) y Noche tiene +0.5% adicional

- Día: Sábado (fin de semana) → 0.8% base
- Período: Noche → +0.5% adicional
- Comisión total: 0.8% + 0.5% = 1.3%
- Comisión en dólares: $15,600 × 0.013 = $202.80
- Ingreso neto: $15,600 - $202.80 = $15,397.20

**Paso 4: Actualizar el estado del portafolio de BTC**

> 💡 **Recuerda:** Al vender, calcula la ganancia usando el precio promedio de compra

**Estado del Portafolio BTC (ACTUALIZADO):**
- Cantidad comprada: 0.5 BTC (sin cambio)
- Cantidad vendida: 0 + 0.3 = 0.3 BTC
- Cantidad actual: 0.5 - 0.3 = 0.2 BTC
- Dinero invertido: $22,500 (sin cambio)
- Dinero recuperado: $0 + $15,600 = $15,600
- Precio promedio compra: $45,000 (sin cambio)
- Precio promedio venta: $15,600 / 0.3 = $52,000
- Costo de las 0.3 vendidas: 0.3 × $45,000 = $13,500
- **Ganancia realizada: $15,600 - $13,500 = $2,100**
- **Rentabilidad: (($52,000 - $45,000) / $45,000) × 100 = 15.56%**
- Comisiones pagadas en BTC: $112.50 + $202.80 = $315.30

**Estados de las demás criptos (sin cambios):**
- ETH: 12 ETH, invertido $37,200, comisiones $260.40
- ADA: 2000 ADA, ganancia $564, rentabilidad 71.76%, comisiones $18.17

**Paso 5: Actualizar el resumen general**

> 💡 **Recuerda:** Ahora tienes dos criptos con ganancias realizadas

**Resumen General del Portafolio:**
- Valor total invertido: $61,010
- Valor total recuperado: $1,350 (ADA) + $15,600 (BTC) = $16,950
- **Ganancia/Pérdida total: $564 (ADA) + $2,100 (BTC) = $2,664**
- Comisiones totales pagadas: $315.30 + $260.40 + $18.17 = $593.87
- **Cripto con mejor rentabilidad: Cardano (ADA) con 71.76%**
- **Cripto con peor rentabilidad: Bitcoin (BTC) con 15.56%**

**Desglose de Comisiones:**
- BTC: $315.30
- ETH: $260.40
- ADA: $18.17
- SOL: $0
- XRP: $0
- **TOTAL: $593.87**

**Paso 6: Evaluar alertas**

> 💡 **Recuerda:** Para BTC en venta, verificar si el precio < $30,000

- Precio: $52,000 (no es menor a $30,000)
- Alertas: Ninguna

**Paso 7: Mostrar recomendación de estrategia**

- Período: Noche
- Recomendación: "🌙 Comisión alta por baja liquidez - Considere operar en la mañana"

**Análisis Final:**
- Estado BTC: "Ganancia"
- Rentabilidad BTC: 15.56%
- Período del día: Noche
- Alertas: Ninguna
- Recomendación: "🌙 Comisión alta por baja liquidez - Considere operar en la mañana"
- **Dato alarmante:** Si hubieras operado un lunes en la mañana, la comisión hubiera sido solo $78 (0.5%) en lugar de $202.80 (1.3%). **Perdiste $124.80 extra por operar en mal horario.**
- **Análisis de impacto:** Las comisiones totales ($593.87) representan el 22.29% de tus ganancias totales ($2,664)

---

## 💼 Situaciones Problema (Para que resuelvas)

### Problema 1: Continuando la Historia - Comprando Solana el Domingo

**Contexto:** Es domingo por la madrugada y ves que Solana está a buen precio. A pesar del mal horario, decides comprar.

**Estado actual de tu portafolio (antes de esta operación):**
- BTC: 0.2 BTC, invertido $22,500, recuperado $15,600, ganancia $2,100, comisiones $315.30
- ETH: 12 ETH, invertido $37,200, recuperado $0, comisiones $260.40
- ADA: 2000 ADA, invertido $1,310, recuperado $1,350, ganancia $564, comisiones $18.17
- SOL: Sin operaciones
- XRP: Sin operaciones
- Comisiones totales: $593.87
- Ganancia total: $2,664

**Datos de la nueva operación:**
- Tipo: Compra
- Cripto: Solana (SOL)
- Cantidad: 20 SOL
- Precio unitario: $155
- Día: Domingo
- Hora: 3

**Tu tarea:** 
1. Determinar en qué período del día se está operando (Mañana, Tarde o Noche)
2. Calcular la comisión porcentual total (recuerda sumar comisión base del día + ajuste por período)
3. Calcular la comisión en dólares
4. Calcular el costo total de la operación
5. Actualizar el estado completo del portafolio de SOL (todas sus variables)
6. Determinar qué alertas deben mostrarse (revisa las reglas de alertas para SOL)
7. Calcular el nuevo total de comisiones pagadas en SOL
8. Calcular el nuevo total de comisiones globales
9. Actualizar el resumen general del portafolio (valor total invertido)
10. Mostrar la recomendación de estrategia según día y período
11. Calcular qué porcentaje de tus ganancias totales representan ahora las comisiones totales

---

### Problema 2: Continuando la Historia - Vendiendo Ethereum con Ganancias

**Contexto:** Ethereum subió a $3,700. Decides vender la mitad de tu posición en un horario favorable.

**Estado actual de tu portafolio (después de la operación anterior de SOL):**
- BTC: 0.2 BTC, ganancia realizada $2,100, rentabilidad 15.56%, comisiones $315.30
- ETH: 12 ETH (precio promedio $3,100), invertido $37,200, recuperado $0, comisiones $260.40
- ADA: 2000 ADA, ganancia realizada $564, rentabilidad 71.76%, comisiones $18.17
- SOL: 20 SOL (precio promedio $155), invertido $3,100, comisiones $[calculadas en problema 1]
- XRP: Sin operaciones
- Comisiones totales: $[calculadas en problema 1]
- Ganancia total: $2,664

**Datos de la nueva operación:**
- Tipo: Venta
- Cripto: Ethereum (ETH)
- Cantidad: 6 ETH
- Precio unitario: $3,700
- Día: Martes
- Hora: 11

**Tu tarea:**
1. Determinar en qué período del día se está operando
2. Calcular la comisión porcentual y en dólares de esta operación
3. Calcular el ingreso neto después de comisiones
4. Calcular la ganancia o pérdida realizada en ETH (recuerda usar el precio promedio de compra)
5. Calcular la rentabilidad porcentual de ETH
6. Actualizar el estado completo del portafolio de ETH (todas sus variables)
7. Calcular cuántos ETH quedan en el portafolio
8. Calcular el nuevo total de comisiones pagadas en ETH
9. Calcular el nuevo total de comisiones globales
10. Calcular la nueva ganancia total del portafolio (suma de todas las ganancias)
11. Determinar cuál es ahora la cripto con mejor rentabilidad
12. Determinar cuál es la cripto con peor rentabilidad
13. Mostrar todas las alertas correspondientes (revisa las reglas de ETH)
14. Calcular qué porcentaje de tus ganancias totales representan las comisiones
15. Mostrar la recomendación de estrategia

---

### Problema 3: Análisis Completo Final del Portafolio

**Contexto:** Después de la operación anterior de ETH, decides hacer un análisis completo de tu desempeño como trader y agregar una última operación de Ripple.

**Estado actual de tu portafolio (después de vender ETH):**
- BTC: 0.2 BTC, ganancia realizada $2,100, rentabilidad 15.56%, comisiones $315.30
- ETH: 6 ETH, ganancia realizada $[calculada en problema 2], rentabilidad $[calculada en problema 2], comisiones $[calculadas en problema 2]
- ADA: 2000 ADA, ganancia realizada $564, rentabilidad 71.76%, comisiones $18.17
- SOL: 20 SOL (sin ventas), invertido $3,100, comisiones $[calculadas en problema 1]
- XRP: Sin operaciones
- Comisiones totales: $[calculadas en problema 2]
- Ganancia total: $[calculada en problema 2]

**Decides hacer una última operación:**
- Tipo: Compra
- Cripto: Ripple (XRP)
- Cantidad: 4000 XRP
- Precio unitario: $0.48
- Día: Jueves
- Hora: 16

**Tu tarea:**
1. Determinar en qué período del día se está operando
2. Calcular toda la información de esta compra de XRP
3. Actualizar el estado completo de XRP
4. Determinar qué alertas deben mostrarse (revisa las reglas de XRP)
5. Generar un **REPORTE COMPLETO FINAL** que incluya:
   - Estado detallado de TODAS las criptos (cantidad actual, dinero invertido, recuperado, ganancias/pérdidas)
   - Rentabilidad de cada cripto que tenga ventas
   - Cripto con mejor rentabilidad
   - Cripto con peor rentabilidad
   - Valor total invertido en todo el portafolio
   - Valor total recuperado
   - Ganancia/pérdida total del portafolio
   - Desglose completo de comisiones por cada cripto
   - Total de comisiones pagadas
   - Porcentaje que representan las comisiones sobre las ganancias totales
6. **Análisis adicional:** Calcula cuánto habrías pagado en comisiones si TODAS tus operaciones hubieran sido en días laborales por la mañana (0.5% en cada operación). ¿Cuánto dinero "perdiste" por operar en malos horarios?
7. **Recomendación final:** Basándote en tu análisis de comisiones, ¿qué estrategia de horarios recomendarías para futuras operaciones?

---

## 📝 Notas Importantes para tu Implementación

### Variables que debes mantener (NO uses arreglos):

**Para cada criptomoneda (BTC, ETH, ADA, SOL, XRP):**
- `[cripto]Compradas` (ejemplo: btcCompradas)
- `[cripto]Vendidas`
- `[cripto]Actuales`
- `[cripto]DineroInvertido`
- `[cripto]DineroRecuperado`
- `[cripto]PrecioPromCompra`
- `[cripto]PrecioPromVenta`
- `[cripto]Ganancia`
- `[cripto]Rentabilidad`
- `[cripto]Comisiones`

**Variables globales:**
- `comisionesTotales`
- `gananciaTotal`
- `valorTotalInvertido`
- `valorTotalRecuperado`

### Estructura de decisiones sugerida:

**Para determinar el período del día:**
```
Si hora >= 6 Y hora <= 11 entonces
    periodo = "Mañana"
Si no, si hora >= 12 Y hora <= 17 entonces
    periodo = "Tarde"
Si no
    periodo = "Noche"
```

**Para calcular comisión base por día (usar switch/case):**
```
Según dia:
    caso "Lunes", "Martes", "Miércoles", "Jueves", "Viernes":
        comisionBase = 0.5
    caso "Sábado":
        comisionBase = 0.8
    caso "Domingo":
        comisionBase = 1.0
```

**Para calcular ajuste por período:**
```
Según periodo:
    caso "Mañana":
        ajustePeriodo = 0.0
    caso "Tarde":
        ajustePeriodo = 0.2
    caso "Noche":
        ajustePeriodo = 0.5
```

**Para alertas específicas por cripto (usar switch/case para cripto, if's para condiciones):**
```
Según criptomoneda:
    caso "BTC":
        Si precio > 60000 entonces
            mostrar alerta...
    caso "ETH":
        Si precio > 3500 entonces
            mostrar alerta...
        Si cantidad > 10 entonces
            mostrar alerta...
    ...
```

### Recuerda:
- Cada operación afecta SOLO una cripto, las demás mantienen sus valores
- Al comprar más de una cripto que ya tienes, el precio promedio cambia
- Las comisiones NUNCA se suman al dinero invertido/recuperado
- Solo puedes vender si tienes cantidad disponible
- La ganancia se calcula: Dinero recuperado - (Cantidad vendida × Precio promedio compra)
- En los problemas, usa los valores calculados en problemas anteriores

**¡Éxito construyendo tu sistema de trading!** 📈💰