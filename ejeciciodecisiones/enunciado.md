# 🍽️ Ejercicio de Programación: Sistema de Pedidos y Fidelización en Restaurante  

## Contexto de negocio  

El restaurante **“Sabores del Mundo”** está implementando un plan de modernización. Actualmente, sus pedidos se hacen en papel y los clientes participan en un **programa de fidelización** que busca premiar a quienes consumen con frecuencia. Sin embargo, al no tener un sistema organizado, han surgido múltiples problemas:  

- Los meseros olvidan anotar correctamente lo que pide el cliente.  
- El cálculo de la cuenta muchas veces es incorrecto porque se suman mal los precios.  
- Los puntos de fidelidad se pierden, se olvidan o se asignan mal.  
- No hay control sobre cuándo un cliente debería cambiar de categoría (Regular, VIP o Corporativo).  

Por eso, la administración decidió que cada pedido debe registrarse en un **sistema automatizado**, que cumpla con las siguientes condiciones:  

1. **Simplicidad del pedido**:  
   Cada pedido solo puede contener **un tipo de plato** del menú, pero el cliente puede indicar la **cantidad de platos** que desea de esa categoría.  
   - Ejemplo: “3 proteínas” o “2 postres”.  

2. **Menú fijo y sencillo**:  
   Para evitar confusiones, el menú tendrá solo **4 categorías de platos**:  

   - **Proteína**  
     - Precio: $30.000  
     - Puntos: 15 puntos por unidad  
     - Ejemplos: pollo a la plancha, carne asada, pescado frito  

   - **Ensalada**  
     - Precio: $12.000  
     - Puntos: 5 puntos por unidad  
     - Ejemplos: ensalada césar, ensalada de frutas, ensalada verde  

   - **Sopa**  
     - Precio: $15.000  
     - Puntos: 8 puntos por unidad  
     - Ejemplos: sopa de verduras, ajiaco, crema de tomate  

   - **Postre**  
     - Precio: $10.000  
     - Puntos: 3 puntos por unidad  
     - Ejemplos: flan, helado, torta de chocolate  

3. **Acumulación de puntos y categorías**:  
   Cada cliente acumula puntos con sus pedidos. Todos inician en categoría **Regular** con 0 puntos, y suben de nivel automáticamente:  
   - Regular → 0 a 99 puntos  
   - VIP → 100 a 499 puntos  
   - Corporativo → 500 puntos en adelante  

   - **Regular**: no recibe descuentos.  
   - **VIP**: si el pedido supera $100.000, tiene 10% de descuento.  
   - **Corporativo**: si el pedido supera $200.000, tiene 20% de descuento.  

4. **Estadísticas personales**:  
   El sistema debe registrar en todo momento:  
   - El total de platos pedidos por el cliente (histórico).  
   - Los puntos acumulados.  
   - La categoría actual.  

5. **Factura automática**:  
   Cada pedido debe generar una **factura clara y sencilla**, donde se detalle:  
   - Nombre del cliente.  
   - Categoría actual.  
   - Plato elegido y cantidad.  
   - Precio unitario y precio base.  
   - Descuento aplicado (si corresponde).  
   - Valor final a pagar.  
   - Puntos obtenidos en el pedido.  
   - Puntos acumulados y total de platos pedidos.  

---

## Ejemplo de factura  

Supongamos que el cliente **Laura Torres**, quien ya es **VIP**, pide **5 proteínas**.  

```
===============================
        FACTURA DE PEDIDO
===============================
Cliente: Laura Torres
Categoría actual: VIP

Plato elegido: Proteína
Cantidad: 5
Precio unitario: $30.000
----------------------------------------
Precio base del pedido: $150.000
Descuento aplicado (10% VIP): -$15.000
Valor final a pagar: $135.000
----------------------------------------
Puntos obtenidos en este pedido: 75
Puntos acumulados: 220
Platos comprados en total: 18
===============================
   ¡Gracias por su compra!
===============================
```

---

## Situaciones problemáticas  

### Situación 1 – Pedido económico de un cliente Regular  
Un cliente nuevo, **Pedro Ramírez**, pide **2 ensaladas**.  
- Precio base: 2 × $12.000.  
- Puntos ganados: 2 × 5.  
- Categoría: sigue siendo Regular.  
- La factura debe mostrar precio base, sin descuentos, puntos obtenidos y total acumulado.  

---

### Situación 2 – Cambio de categoría  
Un cliente **Regular** ya tiene 95 puntos. En su siguiente pedido pide **1 proteína y 1 sopa** (se elige uno de esos platos con la cantidad correspondiente en el sistema).  
- Puntos del pedido: 15 + 8 = 23.  
- Nuevos puntos acumulados: 95 + 23 = 118.  
- El cliente pasa automáticamente a la categoría VIP.  
- La factura debe mostrar el cambio de categoría.  

---

### Situación 3 – Corporativo con pedido grande  
Un cliente **Corporativo** pide **10 proteínas**.  
- Precio base: 10 × $30.000.  
- Como el pedido supera $200.000, se aplica el 20% de descuento.  
- Puntos obtenidos: 10 × 15 = 150.  
- La factura debe mostrar el descuento, el valor final y los puntos acumulados.  

---

### Situación 4 – Pedido de postres  
Una clienta **Regular** pide **5 postres**.  
- Precio base: 5 × $10.000.  
- Puntos obtenidos: 5 × 3.  
- La categoría sigue siendo Regular porque aún no llega a 100 puntos.  
- La factura debe mostrar claramente el pedido, sin descuentos, pero con los puntos sumados.  

---

## Nota para los estudiantes  

Este ejercicio está diseñado para que se practique:  
- El registro de un pedido sencillo (un solo plato con cantidad).  
- El cálculo de totales con condiciones.  
- La acumulación de puntos y el cambio automático de categorías.  
- La generación de una salida entendible (la factura).  

El reto está en **organizar la información correctamente** y aplicar las condiciones de negocio según la categoría del cliente.  
