package edu.eam.ingesoft.fundamentos.gestionacademica.logica;

/**
 * Representa un estudiante de la universidad con toda su información académica.
 * Cada estudiante puede cursar hasta 8 asignaturas en un semestre.
 * Esta clase gestiona el rendimiento académico completo del estudiante.
 *
 * VERSIÓN SOLUCIÓN - Con métodos implementados
 */
public class Estudiante {

    private String nombreCompleto;
    private String codigo;
    private int semestre;
    private Asignatura[] asignaturas;
    private int cantidadAsignaturas;
    private static final int MAX_ASIGNATURAS = 8;

    public Estudiante(String nombreCompleto, String codigo, int semestre) {
        this.nombreCompleto = nombreCompleto;
        this.codigo = codigo;
        this.semestre = semestre;
        this.asignaturas = new Asignatura[MAX_ASIGNATURAS];
        this.cantidadAsignaturas = 0;
    }

    // ========================== GESTIÓN DE ASIGNATURAS ==========================

    public boolean agregarAsignatura(Asignatura asignatura) {
        // Validar que no se exceda el límite
        if (cantidadAsignaturas >= MAX_ASIGNATURAS) {
            return false;
        }

        // Validar que la asignatura no sea null
        if (asignatura == null) {
            return false;
        }

        // Validar que tenga nombre
        if (asignatura.getNombre() == null || asignatura.getNombre().trim().isEmpty()) {
            return false;
        }

        // Agregar al arreglo
        asignaturas[cantidadAsignaturas] = asignatura;
        cantidadAsignaturas++;
        return true;
    }

    // ========================== CÁLCULO DE PROMEDIO ==========================

    public double calcularPromedioGeneral() {
        // Validar que tenga al menos una asignatura
        if (cantidadAsignaturas == 0) {
            return 0.0;
        }

        double sumaNotasFinales = 0.0;

        // Sumar todas las notas finales
        for (int i = 0; i < cantidadAsignaturas; i++) {
            sumaNotasFinales += asignaturas[i].calcularNotaFinal();
        }

        // Calcular promedio aritmético
        return sumaNotasFinales / cantidadAsignaturas;
    }

    public String clasificarRendimiento() {
        double promedio = calcularPromedioGeneral();

        if (promedio >= 4.5) {
            return "Excelente";
        } else if (promedio >= 4.0) {
            return "Bueno";
        } else if (promedio >= 3.5) {
            return "Aceptable";
        } else if (promedio >= 3.0) {
            return "Regular";
        } else {
            return "Deficiente";
        }
    }

    // ========================== ANÁLISIS DE APROBADAS Y REPROBADAS ==========================

    public int contarAprobadas() {
        int contador = 0;

        for (int i = 0; i < cantidadAsignaturas; i++) {
            if (asignaturas[i].estaAprobada()) {
                contador++;
            }
        }

        return contador;
    }

    public int contarReprobadas() {
        int contador = 0;

        for (int i = 0; i < cantidadAsignaturas; i++) {
            if (!asignaturas[i].estaAprobada()) {
                contador++;
            }
        }

        return contador;
    }

    // ========================== ESTADO ACADÉMICO ==========================

    public String determinarEstadoAcademico() {
        int reprobadas = contarReprobadas();

        if (reprobadas == 0) {
            return "Regular";
        } else if (reprobadas > (cantidadAsignaturas / 2.0)) {
            return "Prueba Académica";
        } else {
            return "Advertencia";
        }
    }

    // ========================== MEJOR Y PEOR ASIGNATURA ==========================

    public String obtenerMejorAsignatura() {
        if (cantidadAsignaturas == 0) {
            return "";
        }

        String nombreMejor = asignaturas[0].getNombre();
        double notaMejor = asignaturas[0].calcularNotaFinal();

        for (int i = 1; i < cantidadAsignaturas; i++) {
            double notaActual = asignaturas[i].calcularNotaFinal();
            if (notaActual > notaMejor) {
                notaMejor = notaActual;
                nombreMejor = asignaturas[i].getNombre();
            }
        }

        return nombreMejor;
    }

    public double obtenerNotaMejorAsignatura() {
        if (cantidadAsignaturas == 0) {
            return 0.0;
        }

        double notaMejor = asignaturas[0].calcularNotaFinal();

        for (int i = 1; i < cantidadAsignaturas; i++) {
            double notaActual = asignaturas[i].calcularNotaFinal();
            if (notaActual > notaMejor) {
                notaMejor = notaActual;
            }
        }

        return notaMejor;
    }

    public String obtenerPeorAsignatura() {
        if (cantidadAsignaturas == 0) {
            return "";
        }

        String nombrePeor = asignaturas[0].getNombre();
        double notaPeor = asignaturas[0].calcularNotaFinal();

        for (int i = 1; i < cantidadAsignaturas; i++) {
            double notaActual = asignaturas[i].calcularNotaFinal();
            if (notaActual < notaPeor) {
                notaPeor = notaActual;
                nombrePeor = asignaturas[i].getNombre();
            }
        }

        return nombrePeor;
    }

    public double obtenerNotaPeorAsignatura() {
        if (cantidadAsignaturas == 0) {
            return 0.0;
        }

        double notaPeor = asignaturas[0].calcularNotaFinal();

        for (int i = 1; i < cantidadAsignaturas; i++) {
            double notaActual = asignaturas[i].calcularNotaFinal();
            if (notaActual < notaPeor) {
                notaPeor = notaActual;
            }
        }

        return notaPeor;
    }

    // ========================== MEJOR Y PEOR NOTA INDIVIDUAL ==========================

    public double obtenerMejorNotaIndividual() {
        if (cantidadAsignaturas == 0) {
            return 0.0;
        }

        double mejorNota = 0.0;
        boolean encontrada = false;

        // Recorrer todas las asignaturas
        for (int i = 0; i < cantidadAsignaturas; i++) {
            Asignatura asignatura = asignaturas[i];

            // Recorrer todas las notas de la asignatura
            for (int j = 0; j < asignatura.getCantidadNotas(); j++) {
                double valorNota = asignatura.getNotas()[j].getValor();

                if (!encontrada || valorNota > mejorNota) {
                    mejorNota = valorNota;
                    encontrada = true;
                }
            }
        }

        return mejorNota;
    }

    public double obtenerPeorNotaIndividual() {
        if (cantidadAsignaturas == 0) {
            return 0.0;
        }

        double peorNota = 5.0;
        boolean encontrada = false;

        // Recorrer todas las asignaturas
        for (int i = 0; i < cantidadAsignaturas; i++) {
            Asignatura asignatura = asignaturas[i];

            // Recorrer todas las notas de la asignatura
            for (int j = 0; j < asignatura.getCantidadNotas(); j++) {
                double valorNota = asignatura.getNotas()[j].getValor();

                if (!encontrada || valorNota < peorNota) {
                    peorNota = valorNota;
                    encontrada = true;
                }
            }
        }

        return encontrada ? peorNota : 0.0;
    }

    // ========================== REPORTE ==========================

    public String mostrarReporteCompleto() {
        if (cantidadAsignaturas == 0) {
            return "El estudiante no tiene asignaturas registradas.";
        }

        StringBuilder reporte = new StringBuilder();

        reporte.append("========================================\n");
        reporte.append("    REPORTE ACADÉMICO DEL ESTUDIANTE\n");
        reporte.append("========================================\n");
        reporte.append("Nombre: ").append(nombreCompleto).append("\n");
        reporte.append("Código: ").append(codigo).append("\n");
        reporte.append("Semestre: ").append(semestre).append("\n");
        reporte.append("----------------------------------------\n");
        reporte.append("ASIGNATURAS CURSADAS:\n");
        reporte.append("----------------------------------------\n");

        // Listar todas las asignaturas
        for (int i = 0; i < cantidadAsignaturas; i++) {
            Asignatura asig = asignaturas[i];
            reporte.append((i + 1)).append(". ")
                    .append(asig.getNombre()).append(": ")
                    .append(String.format("%.2f", asig.calcularNotaFinal()))
                    .append(" (").append(asig.determinarEstado().toUpperCase()).append(")\n");
        }

        reporte.append("----------------------------------------\n");
        reporte.append("RESUMEN ACADÉMICO:\n");
        reporte.append("----------------------------------------\n");
        reporte.append("Promedio General: ").append(String.format("%.2f", calcularPromedioGeneral())).append("\n");
        reporte.append("Clasificación: ").append(clasificarRendimiento()).append("\n");
        reporte.append("Asignaturas Aprobadas: ").append(contarAprobadas()).append("\n");
        reporte.append("Asignaturas Reprobadas: ").append(contarReprobadas()).append("\n");
        reporte.append("Estado Académico: ").append(determinarEstadoAcademico()).append("\n");
        reporte.append("----------------------------------------\n");
        reporte.append("ANÁLISIS DE FORTALEZAS Y DEBILIDADES:\n");
        reporte.append("----------------------------------------\n");
        reporte.append("Mejor Asignatura: ").append(obtenerMejorAsignatura())
                .append(" (").append(String.format("%.2f", obtenerNotaMejorAsignatura())).append(")\n");
        reporte.append("Peor Asignatura: ").append(obtenerPeorAsignatura())
                .append(" (").append(String.format("%.2f", obtenerNotaPeorAsignatura())).append(")\n");
        reporte.append("Mejor Nota Individual: ").append(String.format("%.2f", obtenerMejorNotaIndividual())).append("\n");
        reporte.append("Peor Nota Individual: ").append(String.format("%.2f", obtenerPeorNotaIndividual())).append("\n");
        reporte.append("========================================\n");

        return reporte.toString();
    }

    // ========================== GETTERS ==========================

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    // ========================== SETTERS ==========================

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
