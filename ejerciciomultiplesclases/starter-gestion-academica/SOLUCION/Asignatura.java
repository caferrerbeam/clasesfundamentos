package edu.eam.ingesoft.fundamentos.gestionacademica.logica;

/**
 * Representa una asignatura (materia) que cursa un estudiante.
 * Cada asignatura tiene un nombre y puede tener hasta 10 notas (evaluaciones).
 * La nota final de la asignatura se calcula como promedio ponderado de todas las notas.
 *
 * VERSIÓN SOLUCIÓN - Con métodos implementados
 */
public class Asignatura {

    private String nombre;
    private Nota[] notas;
    private int cantidadNotas;
    private static final int MAX_NOTAS = 10;

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.notas = new Nota[MAX_NOTAS];
        this.cantidadNotas = 0;
    }

    // ========================== MÉTODOS DE GESTIÓN DE NOTAS ==========================

    public boolean agregarNota(Nota nota) {
        // Validar que no se exceda el límite de notas
        if (cantidadNotas >= MAX_NOTAS) {
            return false;
        }

        // Validar que la nota no sea null
        if (nota == null) {
            return false;
        }

        // Validar que el valor esté entre 0.0 y 5.0
        if (nota.getValor() < 0.0 || nota.getValor() > 5.0) {
            return false;
        }

        // Validar que el porcentaje sea positivo
        if (nota.getPorcentaje() <= 0) {
            return false;
        }

        // Agregar la nota al arreglo
        notas[cantidadNotas] = nota;
        cantidadNotas++;
        return true;
    }

    public boolean validarPorcentajes() {
        double sumaPorcentajes = 0.0;

        for (int i = 0; i < cantidadNotas; i++) {
            sumaPorcentajes += notas[i].getPorcentaje();
        }

        // Verificar si suma exactamente 100 (con tolerancia de 0.01 por precisión de double)
        return Math.abs(sumaPorcentajes - 100.0) < 0.01;
    }

    // ========================== CÁLCULOS ==========================

    public double calcularNotaFinal() {
        // Validar que haya notas
        if (cantidadNotas == 0) {
            return 0.0;
        }

        // Validar que los porcentajes sumen 100%
        if (!validarPorcentajes()) {
            return 0.0;
        }

        double notaFinal = 0.0;

        // Calcular promedio ponderado
        for (int i = 0; i < cantidadNotas; i++) {
            notaFinal += notas[i].getValor() * (notas[i].getPorcentaje() / 100.0);
        }

        return notaFinal;
    }

    public String determinarEstado() {
        double notaFinal = calcularNotaFinal();

        if (notaFinal >= 4.5) {
            return "Aprobada con Excelencia";
        } else if (notaFinal >= 3.0) {
            return "Aprobada";
        } else {
            return "Reprobada";
        }
    }

    public boolean estaAprobada() {
        return calcularNotaFinal() >= 3.0;
    }

    // ========================== GETTERS ==========================

    public String getNombre() {
        return nombre;
    }

    public Nota[] getNotas() {
        return notas;
    }

    public int getCantidadNotas() {
        return cantidadNotas;
    }

    // ========================== SETTERS ==========================

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
