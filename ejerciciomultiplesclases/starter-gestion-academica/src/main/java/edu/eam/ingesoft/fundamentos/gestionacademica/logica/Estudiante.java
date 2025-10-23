package edu.eam.ingesoft.fundamentos.gestionacademica.logica;

/**
 * Representa un estudiante de la universidad con toda su información académica.
 * Cada estudiante puede cursar hasta 8 asignaturas en un semestre.
 * Esta clase gestiona el rendimiento académico completo del estudiante.
 */
public class Estudiante {

    /**
     * El nombre completo del estudiante
     */
    private String nombreCompleto;

    /**
     * El código único del estudiante
     */
    private String codigo;

    /**
     * El semestre que está cursando actualmente
     */
    private int semestre;

    /**
     * Arreglo de asignaturas que cursa el estudiante (máximo 8)
     */
    private Asignatura[] asignaturas;

    /**
     * Contador de cuántas asignaturas tiene actualmente
     */
    private int cantidadAsignaturas;

    /**
     * Límite máximo de asignaturas por estudiante
     */
    private static final int MAX_ASIGNATURAS = 8;

    /**
     * Constructor que crea un nuevo estudiante.
     *
     * @param nombreCompleto El nombre completo del estudiante
     * @param codigo El código único del estudiante
     * @param semestre El semestre que está cursando
     */
    public Estudiante(String nombreCompleto, String codigo, int semestre) {
        this.nombreCompleto = nombreCompleto;
        this.codigo = codigo;
        this.semestre = semestre;
        this.asignaturas = new Asignatura[MAX_ASIGNATURAS];
        this.cantidadAsignaturas = 0;
    }

    // ========================== GESTIÓN DE ASIGNATURAS ==========================

    /**
     * Agrega una nueva asignatura al estudiante.
     * Valida que no se exceda el límite de 8 asignaturas.
     * Valida que la asignatura tenga un nombre válido (no vacío).
     *
     * @param asignatura La asignatura a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    public boolean agregarAsignatura(Asignatura asignatura) {
        // TODO: Implementar este método
        // Validar que no se exceda MAX_ASIGNATURAS
        // Validar que la asignatura no sea null y tenga nombre
        // Si todo es válido, agregar al arreglo y aumentar cantidadAsignaturas
        return false;
    }

    // ========================== CÁLCULO DE PROMEDIO ==========================

    /**
     * Calcula el promedio general del estudiante.
     * Es el promedio aritmético simple de todas las notas finales de sus asignaturas.
     * Fórmula: (notaFinal1 + notaFinal2 + ... + notaFinalN) / número de asignaturas
     *
     * @return El promedio general del estudiante, o 0.0 si no tiene asignaturas
     */
    public double calcularPromedioGeneral() {
        // TODO: Implementar este método
        // Validar que tenga al menos una asignatura
        // Recorrer todas las asignaturas, calcular su nota final y sumarlas
        // Dividir la suma entre cantidadAsignaturas
        return 0.0;
    }

    /**
     * Clasifica el rendimiento académico del estudiante según su promedio general.
     * - "Excelente" si promedio >= 4.5
     * - "Bueno" si promedio >= 4.0 y < 4.5
     * - "Aceptable" si promedio >= 3.5 y < 4.0
     * - "Regular" si promedio >= 3.0 y < 3.5
     * - "Deficiente" si promedio < 3.0
     *
     * @return La clasificación del rendimiento
     */
    public String clasificarRendimiento() {
        // TODO: Implementar este método
        // Calcular el promedio general
        // Usar if-else para determinar la clasificación
        return "";
    }

    // ========================== ANÁLISIS DE APROBADAS Y REPROBADAS ==========================

    /**
     * Cuenta cuántas asignaturas ha aprobado el estudiante (nota final >= 3.0).
     *
     * @return El número de asignaturas aprobadas
     */
    public int contarAprobadas() {
        // TODO: Implementar este método
        // Recorrer todas las asignaturas
        // Contar cuántas tienen nota final >= 3.0
        return 0;
    }

    /**
     * Cuenta cuántas asignaturas ha reprobado el estudiante (nota final < 3.0).
     *
     * @return El número de asignaturas reprobadas
     */
    public int contarReprobadas() {
        // TODO: Implementar este método
        // Recorrer todas las asignaturas
        // Contar cuántas tienen nota final < 3.0
        return 0;
    }

    // ========================== ESTADO ACADÉMICO ==========================

    /**
     * Determina el estado académico del estudiante basándose en materias reprobadas.
     * - "Regular" si no reprobó ninguna materia
     * - "Advertencia" si reprobó entre 1 y la mitad de las materias
     * - "Prueba Académica" si reprobó más de la mitad de las materias
     *
     * @return El estado académico del estudiante
     */
    public String determinarEstadoAcademico() {
        // TODO: Implementar este método
        // Contar las materias reprobadas
        // Comparar con el total de materias
        // Determinar el estado según las reglas
        return "";
    }

    // ========================== MEJOR Y PEOR ASIGNATURA ==========================

    /**
     * Encuentra la asignatura con la nota final más alta.
     *
     * @return El nombre de la mejor asignatura, o "" si no tiene asignaturas
     */
    public String obtenerMejorAsignatura() {
        // TODO: Implementar este método
        // Recorrer todas las asignaturas
        // Encontrar la que tiene la nota final más alta
        return "";
    }

    /**
     * Obtiene la nota final más alta entre todas las asignaturas.
     *
     * @return La nota final más alta, o 0.0 si no tiene asignaturas
     */
    public double obtenerNotaMejorAsignatura() {
        // TODO: Implementar este método
        // Similar al método anterior pero retornar la nota
        return 0.0;
    }

    /**
     * Encuentra la asignatura con la nota final más baja.
     *
     * @return El nombre de la peor asignatura, o "" si no tiene asignaturas
     */
    public String obtenerPeorAsignatura() {
        // TODO: Implementar este método
        // Recorrer todas las asignaturas
        // Encontrar la que tiene la nota final más baja
        return "";
    }

    /**
     * Obtiene la nota final más baja entre todas las asignaturas.
     *
     * @return La nota final más baja, o 0.0 si no tiene asignaturas
     */
    public double obtenerNotaPeorAsignatura() {
        // TODO: Implementar este método
        // Similar al método anterior pero retornar la nota
        return 0.0;
    }

    // ========================== MEJOR Y PEOR NOTA INDIVIDUAL ==========================

    /**
     * Encuentra la calificación más alta entre todas las evaluaciones de todas las asignaturas.
     *
     * @return La mejor nota individual, o 0.0 si no hay notas
     */
    public double obtenerMejorNotaIndividual() {
        // TODO: Implementar este método
        // Recorrer todas las asignaturas
        // Para cada asignatura, recorrer todas sus notas
        // Encontrar el valor más alto
        return 0.0;
    }

    /**
     * Encuentra la calificación más baja entre todas las evaluaciones de todas las asignaturas.
     *
     * @return La peor nota individual, o 0.0 si no hay notas
     */
    public double obtenerPeorNotaIndividual() {
        // TODO: Implementar este método
        // Recorrer todas las asignaturas
        // Para cada asignatura, recorrer todas sus notas
        // Encontrar el valor más bajo
        return 0.0;
    }

    // ========================== REPORTE ==========================

    /**
     * Genera un reporte completo con toda la información académica del estudiante.
     * Incluye: información personal, lista de asignaturas con notas y estados,
     * promedio general, clasificación, estado académico, análisis de fortalezas y debilidades.
     *
     * @return El reporte completo en formato String
     */
    public String mostrarReporteCompleto() {
        // TODO: Implementar este método
        // Crear un String con formato que incluya toda la información
        // Usar System.lineSeparator() para saltos de línea
        return "";
    }

    // ========================== GETTERS ==========================

    /**
     * Obtiene el nombre completo del estudiante.
     *
     * @return El nombre completo
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Obtiene el código del estudiante.
     *
     * @return El código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el semestre que está cursando.
     *
     * @return El semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Obtiene el arreglo de asignaturas.
     *
     * @return El arreglo de asignaturas
     */
    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    /**
     * Obtiene la cantidad de asignaturas que cursa actualmente.
     *
     * @return El número de asignaturas
     */
    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    // ========================== SETTERS ==========================

    /**
     * Establece el nombre completo del estudiante.
     *
     * @param nombreCompleto El nuevo nombre
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Establece el código del estudiante.
     *
     * @param codigo El nuevo código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece el semestre.
     *
     * @param semestre El nuevo semestre
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
