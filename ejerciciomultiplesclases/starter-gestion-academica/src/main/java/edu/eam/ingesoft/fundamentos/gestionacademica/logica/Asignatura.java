package edu.eam.ingesoft.fundamentos.gestionacademica.logica;

/**
 * Representa una asignatura (materia) que cursa un estudiante.
 * Cada asignatura tiene un nombre y puede tener hasta 10 notas (evaluaciones).
 * La nota final de la asignatura se calcula como promedio ponderado de todas las notas.
 */
public class Asignatura {

    /**
     * El nombre de la asignatura (ej: "Cálculo I", "Programación", "Física")
     */
    private String nombre;

    /**
     * Arreglo de notas (máximo 10 notas por asignatura)
     */
    private Nota[] notas;

    /**
     * Contador de cuántas notas se han agregado actualmente
     */
    private int cantidadNotas;

    /**
     * Límite máximo de notas por asignatura
     */
    private static final int MAX_NOTAS = 10;

    /**
     * Constructor que crea una nueva asignatura con su nombre.
     *
     * @param nombre El nombre de la asignatura
     */
    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.notas = new Nota[MAX_NOTAS];
        this.cantidadNotas = 0;
    }

    // ========================== MÉTODOS DE GESTIÓN DE NOTAS ==========================

    /**
     * Agrega una nueva nota a la asignatura.
     * Valida que no se exceda el límite de 10 notas.
     * Valida que el valor de la nota esté entre 0.0 y 5.0.
     * Valida que el porcentaje sea positivo.
     *
     * @param nota La nota a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    public boolean agregarNota(Nota nota) {
        // TODO: Implementar este método
        // Validar que no se exceda el límite de notas (MAX_NOTAS)
        // Validar que la nota tenga un valor entre 0.0 y 5.0
        // Validar que el porcentaje sea positivo
        // Si todo es válido, agregar la nota al arreglo y aumentar cantidadNotas
        return false;
    }

    /**
     * Valida que la suma de todos los porcentajes de las notas sea exactamente 100%.
     *
     * @return true si suman 100%, false en caso contrario
     */
    public boolean validarPorcentajes() {
        // TODO: Implementar este método
        // Recorrer todas las notas y sumar sus porcentajes
        // Verificar si la suma es igual a 100.0
        return false;
    }

    // ========================== CÁLCULOS ==========================

    /**
     * Calcula la nota final de la asignatura usando promedio ponderado.
     * Fórmula: (nota1 × porcentaje1/100) + (nota2 × porcentaje2/100) + ... + (notaN × porcentajeN/100)
     *
     * @return La nota final calculada, o 0.0 si no hay notas o los porcentajes no suman 100%
     */
    public double calcularNotaFinal() {
        // TODO: Implementar este método
        // Primero validar que los porcentajes sumen 100%
        // Luego recorrer todas las notas y calcular: suma += (nota.getValor() * nota.getPorcentaje() / 100.0)
        return 0.0;
    }

    /**
     * Determina el estado de aprobación de la asignatura según su nota final.
     * - "Aprobada con Excelencia" si nota final >= 4.5
     * - "Aprobada" si nota final >= 3.0 y < 4.5
     * - "Reprobada" si nota final < 3.0
     *
     * @return El estado de la asignatura
     */
    public String determinarEstado() {
        // TODO: Implementar este método
        // Calcular la nota final
        // Usar if-else para determinar el estado según las reglas
        return "";
    }

    /**
     * Verifica si la asignatura está aprobada (nota final >= 3.0).
     *
     * @return true si está aprobada, false si está reprobada
     */
    public boolean estaAprobada() {
        // TODO: Implementar este método
        // Calcular nota final y comparar con 3.0
        return false;
    }

    // ========================== GETTERS ==========================

    /**
     * Obtiene el nombre de la asignatura.
     *
     * @return El nombre de la asignatura
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el arreglo de notas.
     *
     * @return El arreglo de notas
     */
    public Nota[] getNotas() {
        return notas;
    }

    /**
     * Obtiene la cantidad de notas actualmente agregadas.
     *
     * @return El número de notas
     */
    public int getCantidadNotas() {
        return cantidadNotas;
    }

    // ========================== SETTERS ==========================

    /**
     * Establece el nombre de la asignatura.
     *
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
