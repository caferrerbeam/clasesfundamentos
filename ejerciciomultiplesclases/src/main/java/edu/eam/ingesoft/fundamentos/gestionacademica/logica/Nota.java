package edu.eam.ingesoft.fundamentos.gestionacademica.logica;

/**
 * Representa una evaluación individual dentro de una asignatura.
 * Cada nota tiene un nombre descriptivo, un valor numérico y un porcentaje
 * que indica cuánto vale esa evaluación en la nota final de la asignatura.
 */
public class Nota {

    /**ñ
     * El nombre de la evaluación (ej: "Parcial 1", "Taller 2", "Quiz Final")
     */
    private String nombre;

    /**
     * La calificación obtenida, en escala de 0.0 a 5.0
     */
    private double valor;

    /**
     * El peso de esta nota en la nota final de la asignatura (ej: 30.0 significa 30%)
     */
    private double porcentaje;

    /**
     * Constructor que crea una nueva nota con todos sus atributos.
     *
     * @param nombre El nombre descriptivo de la evaluación
     * @param valor La calificación obtenida (0.0 a 5.0)
     * @param porcentaje El peso en la nota final (ej: 30 para 30%)
     */
    public Nota(String nombre, double valor, double porcentaje) {
        this.nombre = nombre;
        this.valor = valor;
        this.porcentaje = porcentaje;
    }

    // ========================== GETTERS ==========================

    /**
     * Obtiene el nombre de la evaluación.
     *
     * @return El nombre de la nota
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el valor de la calificación.
     *
     * @return El valor de la nota (0.0 a 5.0)
     */
    public double getValor() {
        return valor;
    }

    /**
     * Obtiene el porcentaje de esta nota en la asignatura.
     *
     * @return El porcentaje (ej: 30.0 para 30%)
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    // ========================== SETTERS ==========================

    /**
     * Establece el nombre de la evaluación.
     *
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el valor de la calificación.
     *
     * @param valor El nuevo valor (0.0 a 5.0)
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Establece el porcentaje de esta nota.
     *
     * @param porcentaje El nuevo porcentaje
     */
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
