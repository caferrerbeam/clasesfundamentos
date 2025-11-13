# Interfaces del Sistema de Wallet de Criptomonedas

Este proyecto incluye **dos interfaces** completas para interactuar con el sistema:

## 🖥️ CLI - Interfaz de Línea de Comandos

La CLI (Command Line Interface) proporciona una interfaz de texto interactiva con menús.

### Características:
- ✅ Menús interactivos con navegación intuitiva
- ✅ Gestión completa de criptomonedas
- ✅ Registro de operaciones (compra/venta)
- ✅ Análisis detallado del portafolio
- ✅ Reportes y estadísticas
- ✅ Análisis individual de criptomonedas
- ✅ Interfaz limpia con formato de tablas

### Cómo ejecutar:

**Linux/Mac:**
```bash
./run-cli.sh
```

**Windows:**
```cmd
run-cli.bat
```

**Manualmente con Maven:**
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="edu.eam.ingesoft.fundamentos.criptomonedas.CLI"
```

### Estructura de Menús:

```
MENÚ PRINCIPAL
├── 1. Gestión de Criptomonedas
│   ├── Agregar nueva criptomoneda
│   ├── Listar criptomonedas
│   └── Buscar criptomoneda
│
├── 2. Registrar Operaciones
│   ├── Registrar Compra
│   └── Registrar Venta
│
├── 3. Análisis de Portafolio
│   └── Ver métricas consolidadas
│
├── 4. Reportes y Estadísticas
│   ├── Reporte completo
│   ├── Criptomonedas con ganancias
│   ├── Criptomonedas con pérdidas
│   └── Criptomonedas sin ventas (HODL)
│
└── 5. Análisis Individual de Criptomoneda
    └── Análisis detallado por símbolo
```

### Ejemplo de Uso CLI:

1. **Configurar portafolio**: Ingresar nombre del dueño
2. **Agregar criptomonedas**: Bitcoin (BTC), Ethereum (ETH)
3. **Registrar operaciones**: Compras y ventas
4. **Ver análisis**: Revisar rentabilidad y métricas
5. **Generar reportes**: Reporte completo del portafolio

---

## 🎨 GUI - Interfaz Gráfica de Usuario

La GUI proporciona una interfaz visual completa usando Java Swing.

### Características:
- ✅ Interfaz gráfica moderna con pestañas
- ✅ Tablas interactivas para visualización de datos
- ✅ Formularios amigables para entrada de datos
- ✅ Reportes con formato en áreas de texto
- ✅ Diálogos informativos
- ✅ Look and Feel del sistema operativo

### Cómo ejecutar:

**Linux/Mac:**
```bash
./run-gui.sh
```

**Windows:**
```cmd
run-gui.bat
```

**Manualmente con Maven:**
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="edu.eam.ingesoft.fundamentos.criptomonedas.GUI"
```

### Pestañas de la GUI:

#### 🏠 **Pestaña Inicio**
- Información del portafolio
- Nombre del dueño
- Botones de acceso rápido
- Resumen general

#### 💰 **Pestaña Gestión**
- Formulario para agregar criptomonedas
- Tabla con todas las criptomonedas
- Columnas: Nombre, Símbolo, Cantidad, Operaciones, Estado
- Botones: Agregar, Actualizar, Ver Detalles

#### 📊 **Pestaña Operaciones**
- Formulario para registrar operaciones
- Selección de tipo (Compra/Venta)
- ComboBox con criptomonedas disponibles
- Campos: Cantidad, Precio, Día, Hora
- Log de operaciones registradas

#### 📈 **Pestaña Análisis**
- Selector de criptomoneda
- Campo para precio actual
- Análisis detallado con:
  - Cantidades (compradas, vendidas, actual)
  - Métricas financieras
  - Ganancia realizada y no realizada
  - Precio break-even
  - Rentabilidad
- Análisis del portafolio completo

#### 📋 **Pestaña Reportes**
- Reporte completo del portafolio
- Criptomonedas con ganancias
- Criptomonedas con pérdidas
- Criptomonedas sin ventas (HODL)
- Formato de texto con estadísticas

### Ejemplo de Uso GUI:

1. **Inicio**: Configurar nombre del dueño
2. **Gestión**: Agregar Bitcoin, Ethereum, Cardano
3. **Operaciones**: Registrar compras y ventas desde formulario
4. **Análisis**: Seleccionar cripto, ingresar precio actual, analizar
5. **Reportes**: Ver reporte completo con formato

---

## 🔧 Requisitos

- **Java 17** o superior
- **Maven 3.9** o superior
- **Sistema operativo**: Windows, Linux o macOS

---

## 📊 Comparación CLI vs GUI

| Característica | CLI | GUI |
|----------------|-----|-----|
| Navegación | Menús de texto | Pestañas visuales |
| Entrada de datos | Teclado (prompts) | Formularios gráficos |
| Visualización | Texto formateado | Tablas y áreas de texto |
| Interactividad | Media | Alta |
| Recursos | Bajo consumo | Medio consumo |
| Accesibilidad | Terminal/SSH | Requiere X11/Pantalla |
| Automatización | Fácil con scripts | Más compleja |

---

## 🚀 Ejecución Rápida

### Opción 1: Scripts automáticos

**Linux/Mac:**
```bash
chmod +x run-cli.sh run-gui.sh
./run-cli.sh    # Para CLI
./run-gui.sh    # Para GUI
```

**Windows:**
```cmd
run-cli.bat     # Para CLI
run-gui.bat     # Para GUI
```

### Opción 2: Maven directo

```bash
# Compilar
mvn clean compile

# Ejecutar CLI
mvn exec:java -Dexec.mainClass="edu.eam.ingesoft.fundamentos.criptomonedas.CLI"

# Ejecutar GUI
mvn exec:java -Dexec.mainClass="edu.eam.ingesoft.fundamentos.criptomonedas.GUI"
```

### Opción 3: JAR ejecutable

```bash
# Crear JAR
mvn clean package

# Ejecutar CLI
java -cp target/sistema-criptomonedas-1.0-SNAPSHOT.jar edu.eam.ingesoft.fundamentos.criptomonedas.CLI

# Ejecutar GUI
java -cp target/sistema-criptomonedas-1.0-SNAPSHOT.jar edu.eam.ingesoft.fundamentos.criptomonedas.GUI
```

---

## 📝 Notas Importantes

### CLI:
- La función de limpiar pantalla puede no funcionar en todos los terminales
- Use CTRL+C para salir en caso de error
- Los menús son navegables con números

### GUI:
- La ventana puede no verse bien en pantallas de baja resolución
- Requiere servidor gráfico (no funciona en SSH sin X11)
- Los ComboBox se actualizan al presionar "Actualizar Lista"

---

## 🐛 Solución de Problemas

### Error: "Command not found: mvn"
**Solución:** Instale Maven o agregue Maven al PATH

### Error: "UnsupportedClassVersionError"
**Solución:** Verifique que esté usando Java 17 o superior
```bash
java -version
```

### GUI no aparece
**Solución:** Verifique que tiene un servidor gráfico activo

### CLI no limpia la pantalla
**Solución:** Normal en algunos terminales, la funcionalidad sigue disponible

---

## 📚 Documentación Adicional

- Ver `README.md` para descripción general del proyecto
- Ver `GUIA_COMPLETA.md` para documentación técnica
- Ver código fuente para detalles de implementación

---

## 👥 Créditos

**Proyecto:** Sistema de Wallet de Criptomonedas
**Curso:** Fundamentos de Programación
**Institución:** Universidad EAM
**Versión:** 1.0

---

## ⚖️ Licencia

Proyecto educativo - EAM 2025
