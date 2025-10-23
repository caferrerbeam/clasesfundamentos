# 🏦 Ejercicio de Programación: Sistema de Gestión de Cuentas Bancarias

## Contexto del Negocio

El banco **"BancoSeguro"** necesita un sistema para administrar las cuentas bancarias de sus clientes. Cada cliente puede tener múltiples cuentas con diferentes características y cada operación tiene costos específicos según el tipo de cuenta y el número de transacciones realizadas en el mes.

### Reglas del Negocio

1. **Cliente**
   - Cada cliente tiene un **nombre** y una **cédula** (identificador único)
   - Un cliente puede tener hasta **6 cuentas** en total
   - De esas 6 cuentas, máximo **3 pueden ser cuentas corrientes**
   - El resto pueden ser cuentas de ahorros

2. **Cuenta Bancaria**
   - Cada cuenta tiene:
     - **Número de cuenta** (identificador único)
     - **Tipo**: Ahorros o Corriente
     - **Saldo actual**
     - **Número de transacciones mensuales** (contador que se reinicia cada mes)

3. **Operación de Retiro**
   - **NO se puede retirar más del saldo disponible** (el saldo no puede quedar negativo)
   - **Cuenta de Ahorros**:
     - Las primeras 3 transacciones del mes son gratuitas
     - A partir de la transacción número 4, se cobra un **1% del monto retirado**
   - **Cuenta Corriente**:
     - Las primeras 5 transacciones del mes son gratuitas
     - A partir de la transacción número 6, se cobra un **2% del monto retirado**

4. **Operación de Consignación (Depósito)**
   - **Cuenta de Ahorros**:
     - Todas las consignaciones son **gratuitas**
     - No hay límite de transacciones sin costo
   - **Cuenta Corriente**:
     - Las primeras 4 transacciones del mes son gratuitas
     - A partir de la transacción número 5, se cobra un **1% del monto consignado**

5. **Apertura de Cuentas**
   - El cliente puede abrir nuevas cuentas siempre que:
     - No tenga ya 6 cuentas en total
     - Si es cuenta corriente, no tenga ya 3 cuentas corrientes
   - La cuenta nueva se abre con saldo $0

6. **Cierre de Cuentas**
   - Una cuenta solo puede cerrarse si **su saldo es exactamente $0**
   - Al cerrar una cuenta, se elimina del registro del cliente

7. **Estado del Cliente según Actividad**
   - **Inactivo**: Tiene menos de 5 transacciones totales en el mes (sumando todas sus cuentas)
   - **Activo**: Tiene entre 5 y 20 transacciones totales en el mes
   - **VIP**: Tiene más de 20 transacciones totales en el mes

---

## Ejemplos Resueltos

### Ejemplo 1: Retiro en Cuenta de Ahorros con Cargo

**Situación Inicial:**
- Cliente: María Rodríguez
- Cédula: 1.234.567.890
- Cuenta de Ahorros #001
- Saldo: $500,000
- Transacciones del mes en esta cuenta: 3

**Operación:** María retira $100,000 de su cuenta de ahorros

**Cálculo:**
1. Tipo de cuenta: Ahorros
2. Transacciones previas: 3 (las primeras 3 son gratis)
3. Esta será la transacción número 4, por lo tanto se cobra 1%
4. Cargo por retiro: 1% × $100,000 = $1,000
5. Monto total a descontar: $100,000 + $1,000 = $101,000
6. Verificar saldo: $500,000 > $101,000 ✓
7. Nuevo saldo: $500,000 - $101,000 = $399,000
8. Transacciones del mes: 4

**Resultado:** Retiro exitoso. Nuevo saldo: $399,000. Se cobró $1,000 por comisión.

---

### Ejemplo 2: Consignación en Cuenta Corriente con Cargo

**Situación Inicial:**
- Cliente: Carlos Gómez
- Cédula: 9.876.543.210
- Cuenta Corriente #002
- Saldo: $1,200,000
- Transacciones del mes en esta cuenta: 5

**Operación:** Carlos consigna $300,000 en su cuenta corriente

**Cálculo:**
1. Tipo de cuenta: Corriente
2. Transacciones previas: 5
3. Esta será la transacción número 6, y para consignaciones en corriente se cobra a partir de la 5ta
4. Como ya pasó la transacción 4, se cobra 1%
5. Cargo por consignación: 1% × $300,000 = $3,000
6. Monto neto a consignar: $300,000 - $3,000 = $297,000
7. Nuevo saldo: $1,200,000 + $297,000 = $1,497,000
8. Transacciones del mes: 6

**Resultado:** Consignación exitosa. Nuevo saldo: $1,497,000. Se cobró $3,000 por comisión.

---

### Ejemplo 3: Intento de Retiro Excediendo el Saldo

**Situación Inicial:**
- Cliente: Ana López
- Cédula: 5.555.555.555
- Cuenta de Ahorros #003
- Saldo: $50,000
- Transacciones del mes en esta cuenta: 1

**Operación:** Ana intenta retirar $60,000

**Cálculo:**
1. Tipo de cuenta: Ahorros
2. Transacciones previas: 1 (sin cargo, es transacción número 2)
3. Monto a retirar: $60,000
4. Verificar saldo: $50,000 < $60,000 ✗

**Resultado:** Retiro rechazado. Saldo insuficiente.

---

### Ejemplo 4: Intento de Retiro con Cargo que Excede el Saldo

**Situación Inicial:**
- Cliente: Luis Martínez
- Cédula: 3.333.333.333
- Cuenta Corriente #004
- Saldo: $100,000
- Transacciones del mes en esta cuenta: 8

**Operación:** Luis intenta retirar $99,500

**Cálculo:**
1. Tipo de cuenta: Corriente
2. Transacciones previas: 8 (ya pasó la transacción 5, se cobra 2%)
3. Cargo por retiro: 2% × $99,500 = $1,990
4. Monto total necesario: $99,500 + $1,990 = $101,490
5. Verificar saldo: $100,000 < $101,490 ✗

**Resultado:** Retiro rechazado. El saldo no alcanza para cubrir el retiro más la comisión.

---

### Ejemplo 5: Apertura de Nueva Cuenta

**Situación Inicial:**
- Cliente: Pedro Sánchez
- Cédula: 7.777.777.777
- Cuentas actuales: 2 cuentas de ahorros, 2 cuentas corrientes (4 en total)

**Operación:** Pedro solicita abrir una nueva cuenta corriente

**Validación:**
1. Total de cuentas: 4 < 6 ✓
2. Cuentas corrientes: 2 < 3 ✓
3. Se puede abrir la cuenta

**Resultado:** Cuenta Corriente #005 abierta exitosamente con saldo $0

---

### Ejemplo 6: Intento de Apertura Excediendo Límites

**Situación Inicial:**
- Cliente: Sandra Torres
- Cédula: 2.222.222.222
- Cuentas actuales: 2 cuentas de ahorros, 3 cuentas corrientes (5 en total)

**Operación:** Sandra solicita abrir una nueva cuenta corriente

**Validación:**
1. Total de cuentas: 5 < 6 ✓
2. Cuentas corrientes: 3 = 3 ✗ (ya tiene el máximo permitido)

**Resultado:** Apertura rechazada. Ya tiene el máximo de cuentas corrientes permitidas.

---

### Ejemplo 7: Cierre de Cuenta

**Situación Inicial:**
- Cliente: Roberto Díaz
- Cédula: 8.888.888.888
- Cuenta de Ahorros #006
- Saldo: $0

**Operación:** Roberto solicita cerrar la cuenta #006

**Validación:**
1. Saldo de la cuenta: $0 ✓
2. Se puede cerrar la cuenta

**Resultado:** Cuenta #006 cerrada exitosamente.

---

### Ejemplo 8: Intento de Cierre con Saldo Pendiente

**Situación Inicial:**
- Cliente: Laura Méndez
- Cédula: 4.444.444.444
- Cuenta Corriente #007
- Saldo: $5,000

**Operación:** Laura solicita cerrar la cuenta #007

**Validación:**
1. Saldo de la cuenta: $5,000 ✗ (debe ser $0)

**Resultado:** Cierre rechazado. La cuenta tiene saldo pendiente.

---

## Actividades a Desarrollar

### 1. Identificación de Atributos y Métodos

**Instrucciones:** Basándose en el contexto del negocio y los ejemplos proporcionados, identifique:

#### a) Para la clase Cuenta

**Atributos necesarios** (identifique todos los atributos necesarios):
- ¿Qué información debe almacenar cada cuenta?

**Métodos necesarios** (identifique todos los métodos necesarios):
- ¿Qué operaciones puede realizar una cuenta?

#### b) Para la clase Cliente

**Atributos necesarios** (identifique todos los atributos necesarios):
- ¿Qué información debe almacenar cada cliente?
- ¿Cómo almacenará las cuentas? (Recuerde: NO usar arreglos ni colecciones, máximo 6 cuentas)

**Métodos necesarios** (identifique todos los métodos necesarios):
- ¿Qué operaciones puede realizar un cliente?
- ¿Cómo manejará las múltiples cuentas?

### 2. Diagramas de Flujo

**Instrucciones:** Diseñe los diagramas de flujo para los siguientes métodos:

#### a) Método retirar(monto) en la clase Cuenta
   - Debe determinar el tipo de cuenta
   - Calcular el cargo según las transacciones del mes
   - Validar que el saldo sea suficiente para el retiro + cargo
   - Actualizar el saldo y el contador de transacciones
   - Retornar si el retiro fue exitoso y el monto del cargo

#### b) Método consignar(monto) en la clase Cuenta
   - Debe determinar el tipo de cuenta
   - Calcular el cargo según las transacciones del mes
   - Calcular el monto neto a consignar
   - Actualizar el saldo y el contador de transacciones
   - Retornar el monto del cargo aplicado

#### c) Método abrirCuenta(tipoCuenta, numeroCuenta) en la clase Cliente
   - Contar cuántas cuentas tiene el cliente
   - Si es corriente, contar cuántas corrientes tiene
   - Validar que se pueda abrir la cuenta
   - Crear y agregar la nueva cuenta
   - Retornar si la apertura fue exitosa

#### d) Método cerrarCuenta(numeroCuenta) en la clase Cliente
   - Buscar la cuenta por número
   - Verificar que el saldo sea $0
   - Eliminar la cuenta de la lista del cliente
   - Retornar si el cierre fue exitoso

#### e) Método determinarEstado() en la clase Cliente
   - Sumar las transacciones de todas las cuentas del cliente
   - Determinar el estado según las reglas de negocio
   - Retornar el estado actual

### 3. Implementación en Java

**Instrucciones:** Implemente las clases completas en Java:

#### Clase Cuenta
Debe incluir:
- Todos los atributos identificados
- Constructor que inicialice una cuenta nueva
- Método `retirar(double monto)` con toda su lógica
- Método `consignar(double monto)` con toda su lógica
- Método `calcularCargoRetiro()` que determine el cargo según el tipo y transacciones
- Método `calcularCargoConsignacion()` que determine el cargo según el tipo y transacciones
- Método `mostrarInformacion()` que imprima:
  - Número de cuenta
  - Tipo de cuenta
  - Saldo actual
  - Transacciones del mes

#### Clase Cliente
Debe incluir:
- Todos los atributos identificados (incluyendo las 6 cuentas como atributos individuales)
- Constructor que inicialice el cliente
- Método `abrirCuenta(String tipoCuenta, String numeroCuenta)` con toda su lógica
- Método `cerrarCuenta(String numeroCuenta)` con toda su lógica
- Método `realizarRetiro(String numeroCuenta, double monto)` que busque la cuenta y ejecute el retiro
- Método `realizarConsignacion(String numeroCuenta, double monto)` que busque la cuenta y ejecute la consignación
- Método `contarCuentas()` que retorne el total de cuentas
- Método `contarCuentasCorrientes()` que retorne el total de cuentas corrientes
- Método `contarTransaccionesTotales()` que sume las transacciones de todas las cuentas
- Método `determinarEstado()` que retorne el estado del cliente
- Método `mostrarResumen()` que imprima:
  - Nombre del cliente
  - Cédula
  - Número total de cuentas
  - Estado del cliente
  - Información detallada de cada cuenta

**Consideraciones importantes:**
- Use solo estructuras de decisión (if, else if, else, switch)
- NO use arreglos, listas o colecciones
- Almacene las cuentas como atributos individuales (cuenta1, cuenta2, ..., cuenta6)
- Use tipos de datos apropiados (double para saldos, int para contadores, String para textos)
- Maneje el valor null para indicar que una posición de cuenta está vacía

---

## Criterios de Evaluación

1. **Identificación correcta de atributos** (15%)
   - Clase Cuenta: Completitud y relevancia de los atributos
   - Clase Cliente: Completitud y relevancia, manejo correcto de múltiples cuentas sin colecciones

2. **Identificación correcta de métodos** (15%)
   - Coherencia con las operaciones del negocio
   - Distribución adecuada de responsabilidades entre clases

3. **Diagramas de flujo** (30%)
   - Correcta representación de la lógica de cada método
   - Uso apropiado de decisiones simples, múltiples y anidadas
   - Correcta validación de condiciones

4. **Implementación en Java** (40%)
   - **Clase Cuenta** (20%):
     - Sintaxis correcta
     - Lógica completa para retiros y consignaciones
     - Cálculo correcto de cargos
     - Validaciones apropiadas
   - **Clase Cliente** (20%):
     - Sintaxis correcta
     - Manejo correcto de múltiples cuentas sin usar arreglos
     - Lógica completa para apertura y cierre de cuentas
     - Búsqueda correcta de cuentas
     - Validaciones apropiadas

---

## Casos de Prueba Sugeridos

Para verificar que su implementación es correcta, pruebe los siguientes escenarios:

### Prueba 1: Crear cliente y abrir cuentas
- Crear un cliente
- Abrir 3 cuentas de ahorros y 3 corrientes
- Intentar abrir una 7ma cuenta (debe fallar)
- Intentar abrir una 4ta cuenta corriente (debe fallar)

### Prueba 2: Operaciones en cuenta de ahorros
- Abrir cuenta de ahorros con saldo inicial $0
- Consignar $500,000 (sin cargo, transacción 1)
- Consignar $200,000 (sin cargo, transacción 2)
- Retirar $100,000 (sin cargo, transacción 3)
- Retirar $50,000 (con cargo 1%, transacción 4)
- Verificar saldo final

### Prueba 3: Operaciones en cuenta corriente
- Abrir cuenta corriente con saldo inicial $0
- Consignar $1,000,000 (sin cargo, transacción 1)
- Consignar $500,000 (sin cargo, transacción 2)
- Consignar $300,000 (sin cargo, transacción 3)
- Consignar $200,000 (sin cargo, transacción 4)
- Consignar $100,000 (con cargo 1%, transacción 5)
- Retirar $50,000 (sin cargo, transacción 6)
- Retirar $30,000 (con cargo 2%, transacción 7)
- Verificar saldo final

### Prueba 4: Cierre de cuentas
- Crear cuenta con saldo $1,000
- Intentar cerrar (debe fallar)
- Retirar todo el saldo
- Cerrar cuenta (debe tener éxito)

### Prueba 5: Estado del cliente
- Cliente con 3 transacciones totales → Estado: Inactivo
- Cliente con 12 transacciones totales → Estado: Activo
- Cliente con 25 transacciones totales → Estado: VIP

---

## Notas Finales

- Este ejercicio está diseñado para practicar:
  - Relaciones entre clases
  - Manejo de múltiples objetos sin usar colecciones
  - Decisiones en múltiples niveles
  - Validaciones complejas

- Preste atención especial a:
  - Las validaciones antes de realizar operaciones
  - El cálculo correcto de cargos según el tipo de cuenta y número de transacciones
  - La búsqueda de cuentas en la clase Cliente sin usar arreglos
  - El manejo de cuentas vacías (null) vs cuentas existentes

- Recuerde que:
  - Algunas decisiones dependen de otras (decisiones anidadas)
  - El orden de las validaciones puede afectar el resultado final
  - Cada clase tiene responsabilidades específicas que deben respetarse
