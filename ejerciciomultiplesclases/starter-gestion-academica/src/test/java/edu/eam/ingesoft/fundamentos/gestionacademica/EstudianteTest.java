package edu.eam.ingesoft.fundamentos.gestionacademica;

import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Asignatura;
import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Estudiante;
import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Nota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas para el Sistema de Gestión Académica.
 * Valida el correcto funcionamiento de todas las operaciones del sistema.
 */
class EstudianteTest {

    private Estudiante maria;
    private Estudiante carlos;

    /**
     * Configuración inicial que se ejecuta antes de cada test.
     * Crea el caso de María González del Ejemplo 2 del enunciado.
     */
    @BeforeEach
    void setUp() {
        // Crear estudiante María González del Ejemplo 2
        maria = new Estudiante("María González", "202315001", 2);

        // CÁLCULO I
        Asignatura calculo = new Asignatura("Cálculo I");
        calculo.agregarNota(new Nota("Parcial 1", 3.2, 30));
        calculo.agregarNota(new Nota("Parcial 2", 3.5, 30));
        calculo.agregarNota(new Nota("Examen Final", 3.8, 40));
        maria.agregarAsignatura(calculo);

        // FÍSICA I
        Asignatura fisica = new Asignatura("Física I");
        fisica.agregarNota(new Nota("Quiz 1", 4.0, 10));
        fisica.agregarNota(new Nota("Quiz 2", 4.5, 10));
        fisica.agregarNota(new Nota("Laboratorio", 4.2, 20));
        fisica.agregarNota(new Nota("Parcial", 4.3, 30));
        fisica.agregarNota(new Nota("Examen Final", 4.4, 30));
        maria.agregarAsignatura(fisica);

        // PROGRAMACIÓN I
        Asignatura programacion = new Asignatura("Programación I");
        programacion.agregarNota(new Nota("Talleres", 2.8, 20));
        programacion.agregarNota(new Nota("Parcial", 2.5, 30));
        programacion.agregarNota(new Nota("Proyecto", 3.2, 50));
        maria.agregarAsignatura(programacion);

        // INGLÉS I
        Asignatura ingles = new Asignatura("Inglés I");
        ingles.agregarNota(new Nota("Oral", 4.5, 25));
        ingles.agregarNota(new Nota("Escrito", 4.8, 25));
        ingles.agregarNota(new Nota("Parcial", 4.6, 30));
        ingles.agregarNota(new Nota("Final", 4.7, 20));
        maria.agregarAsignatura(ingles);

        // Crear estudiante Carlos Ramírez (Ejemplo 3 - En riesgo)
        carlos = new Estudiante("Carlos Ramírez", "202315002", 1);
        Asignatura mat = new Asignatura("Matemáticas Básicas");
        mat.agregarNota(new Nota("Evaluación", 2.5, 100));
        carlos.agregarAsignatura(mat);

        Asignatura intro = new Asignatura("Introducción a la Ingeniería");
        intro.agregarNota(new Nota("Evaluación", 3.2, 100));
        carlos.agregarAsignatura(intro);

        Asignatura qui = new Asignatura("Química General");
        qui.agregarNota(new Nota("Evaluación", 2.8, 100));
        carlos.agregarAsignatura(qui);

        Asignatura prog = new Asignatura("Programación Básica");
        prog.agregarNota(new Nota("Evaluación", 2.3, 100));
        carlos.agregarAsignatura(prog);

        Asignatura exp = new Asignatura("Expresión Oral y Escrita");
        exp.agregarNota(new Nota("Evaluación", 3.5, 100));
        carlos.agregarAsignatura(exp);
    }

    // ========================== TESTS DE ASIGNATURA ==========================

    @Test
    void testCalcularNotaFinalCalculoI() {
        // Cálculo I: 3.2×0.30 + 3.5×0.30 + 3.8×0.40 = 0.96 + 1.05 + 1.52 = 3.53
        Asignatura calculo = maria.getAsignaturas()[0];
        double notaFinal = calculo.calcularNotaFinal();
        assertEquals(3.53, notaFinal, 0.01, "La nota final de Cálculo I debe ser 3.53");
    }

    @Test
    void testCalcularNotaFinalFisicaI() {
        // Física I: 4.0×0.10 + 4.5×0.10 + 4.2×0.20 + 4.3×0.30 + 4.4×0.30 = 4.30
        Asignatura fisica = maria.getAsignaturas()[1];
        double notaFinal = fisica.calcularNotaFinal();
        assertEquals(4.30, notaFinal, 0.01, "La nota final de Física I debe ser 4.30");
    }

    @Test
    void testCalcularNotaFinalProgramacionI() {
        // Programación I: 2.8×0.20 + 2.5×0.30 + 3.2×0.50 = 0.56 + 0.75 + 1.60 = 2.91
        Asignatura programacion = maria.getAsignaturas()[2];
        double notaFinal = programacion.calcularNotaFinal();
        assertEquals(2.91, notaFinal, 0.01, "La nota final de Programación I debe ser 2.91");
    }

    @Test
    void testCalcularNotaFinalInglesI() {
        // Inglés I: 4.5×0.25 + 4.8×0.25 + 4.6×0.30 + 4.7×0.20 = 4.645 ≈ 4.65
        Asignatura ingles = maria.getAsignaturas()[3];
        double notaFinal = ingles.calcularNotaFinal();
        assertEquals(4.65, notaFinal, 0.01, "La nota final de Inglés I debe ser 4.65");
    }

    @Test
    void testDeterminarEstadoAsignaturas() {
        // Cálculo I: 3.53 → Aprobada
        assertEquals("Aprobada", maria.getAsignaturas()[0].determinarEstado(),
                "Cálculo I debe estar Aprobada");

        // Física I: 4.30 → Aprobada
        assertEquals("Aprobada", maria.getAsignaturas()[1].determinarEstado(),
                "Física I debe estar Aprobada");

        // Programación I: 2.91 → Reprobada
        assertEquals("Reprobada", maria.getAsignaturas()[2].determinarEstado(),
                "Programación I debe estar Reprobada");

        // Inglés I: 4.65 → Aprobada con Excelencia
        assertEquals("Aprobada con Excelencia", maria.getAsignaturas()[3].determinarEstado(),
                "Inglés I debe estar Aprobada con Excelencia");
    }

    @Test
    void testValidarPorcentajes() {
        // Todas las asignaturas de María deben tener porcentajes válidos (suman 100%)
        for (int i = 0; i < maria.getCantidadAsignaturas(); i++) {
            assertTrue(maria.getAsignaturas()[i].validarPorcentajes(),
                    "Los porcentajes de " + maria.getAsignaturas()[i].getNombre() + " deben sumar 100%");
        }
    }

    // ========================== TESTS DE ESTUDIANTE ==========================

    @Test
    void testCalcularPromedioGeneralMaria() {
        // Promedio María: (3.53 + 4.30 + 2.91 + 4.65) / 4 = 15.39 / 4 = 3.8475 ≈ 3.85
        double promedio = maria.calcularPromedioGeneral();
        assertEquals(3.85, promedio, 0.02, "El promedio general de María debe ser 3.85");
    }

    @Test
    void testClasificarRendimientoMaria() {
        // María con promedio 3.85 debe estar en "Aceptable" (3.5 <= 3.85 < 4.0)
        String clasificacion = maria.clasificarRendimiento();
        assertEquals("Aceptable", clasificacion,
                "María debe tener clasificación Aceptable");
    }

    @Test
    void testContarAprobadasYReprobadasMaria() {
        // María aprobó 3 y reprobó 1
        assertEquals(3, maria.contarAprobadas(), "María debe tener 3 asignaturas aprobadas");
        assertEquals(1, maria.contarReprobadas(), "María debe tener 1 asignatura reprobada");
    }

    @Test
    void testDeterminarEstadoAcademicoMaria() {
        // María reprobó 1 de 4 materias (no más de la mitad) → Advertencia
        String estado = maria.determinarEstadoAcademico();
        assertEquals("Advertencia", estado,
                "María debe estar en estado Advertencia (reprobó 1 de 4 materias)");
    }

    @Test
    void testObtenerMejorAsignaturaMaria() {
        // La mejor asignatura de María es Inglés I con 4.65
        String mejorAsignatura = maria.obtenerMejorAsignatura();
        double notaMejor = maria.obtenerNotaMejorAsignatura();

        assertEquals("Inglés I", mejorAsignatura, "La mejor asignatura debe ser Inglés I");
        assertEquals(4.65, notaMejor, 0.01, "La nota de la mejor asignatura debe ser 4.65");
    }

    @Test
    void testObtenerPeorAsignaturaMaria() {
        // La peor asignatura de María es Programación I con 2.91
        String peorAsignatura = maria.obtenerPeorAsignatura();
        double notaPeor = maria.obtenerNotaPeorAsignatura();

        assertEquals("Programación I", peorAsignatura, "La peor asignatura debe ser Programación I");
        assertEquals(2.91, notaPeor, 0.01, "La nota de la peor asignatura debe ser 2.91");
    }

    @Test
    void testObtenerMejorNotaIndividualMaria() {
        // La mejor nota individual de María es 4.8 (Examen Escrito de Inglés I)
        double mejorNota = maria.obtenerMejorNotaIndividual();
        assertEquals(4.8, mejorNota, 0.01, "La mejor nota individual debe ser 4.8");
    }

    @Test
    void testObtenerPeorNotaIndividualMaria() {
        // La peor nota individual de María es 2.5 (Parcial de Programación I)
        double peorNota = maria.obtenerPeorNotaIndividual();
        assertEquals(2.5, peorNota, 0.01, "La peor nota individual debe ser 2.5");
    }

    // ========================== TESTS DE CARLOS (ESTUDIANTE EN RIESGO) ==========================

    @Test
    void testCalcularPromedioGeneralCarlos() {
        // Promedio Carlos: (2.5 + 3.2 + 2.8 + 2.3 + 3.5) / 5 = 14.3 / 5 = 2.86
        double promedio = carlos.calcularPromedioGeneral();
        assertEquals(2.86, promedio, 0.01, "El promedio general de Carlos debe ser 2.86");
    }

    @Test
    void testClasificarRendimientoCarlos() {
        // Carlos con promedio 2.86 debe estar en "Deficiente" (< 3.0)
        String clasificacion = carlos.clasificarRendimiento();
        assertEquals("Deficiente", clasificacion,
                "Carlos debe tener clasificación Deficiente");
    }

    @Test
    void testContarAprobadasYReprobadasCarlos() {
        // Carlos aprobó 2 y reprobó 3
        assertEquals(2, carlos.contarAprobadas(), "Carlos debe tener 2 asignaturas aprobadas");
        assertEquals(3, carlos.contarReprobadas(), "Carlos debe tener 3 asignaturas reprobadas");
    }

    @Test
    void testDeterminarEstadoAcademicoCarlos() {
        // Carlos reprobó 3 de 5 materias (más de la mitad) → Prueba Académica
        String estado = carlos.determinarEstadoAcademico();
        assertEquals("Prueba Académica", estado,
                "Carlos debe estar en Prueba Académica (reprobó 3 de 5 materias)");
    }

    // ========================== TESTS DE VALIDACIONES ==========================

    @Test
    void testAgregarNotaConValorInvalido() {
        // Intentar agregar una nota con valor fuera del rango 0.0-5.0
        Asignatura test = new Asignatura("Test");
        boolean resultado1 = test.agregarNota(new Nota("Nota inválida", 6.0, 50));
        boolean resultado2 = test.agregarNota(new Nota("Nota negativa", -1.0, 50));

        assertFalse(resultado1, "No debe permitir agregar nota con valor > 5.0");
        assertFalse(resultado2, "No debe permitir agregar nota con valor < 0.0");
    }

    @Test
    void testLimiteMaximoNotas() {
        // Intentar agregar más de 10 notas a una asignatura
        Asignatura test = new Asignatura("Test");
        for (int i = 0; i < 10; i++) {
            test.agregarNota(new Nota("Nota " + (i + 1), 4.0, 10));
        }

        // La nota 11 no debe agregarse
        boolean resultado = test.agregarNota(new Nota("Nota 11", 4.0, 10));
        assertFalse(resultado, "No debe permitir agregar más de 10 notas por asignatura");
        assertEquals(10, test.getCantidadNotas(), "Debe tener exactamente 10 notas");
    }

    @Test
    void testLimiteMaximoAsignaturas() {
        // Intentar agregar más de 8 asignaturas a un estudiante
        Estudiante test = new Estudiante("Test", "00000", 1);
        for (int i = 0; i < 8; i++) {
            test.agregarAsignatura(new Asignatura("Asignatura " + (i + 1)));
        }

        // La asignatura 9 no debe agregarse
        boolean resultado = test.agregarAsignatura(new Asignatura("Asignatura 9"));
        assertFalse(resultado, "No debe permitir agregar más de 8 asignaturas por estudiante");
        assertEquals(8, test.getCantidadAsignaturas(), "Debe tener exactamente 8 asignaturas");
    }

    @Test
    void testEstudianteSinAsignaturas() {
        // Un estudiante sin asignaturas debe tener promedio 0.0
        Estudiante vacio = new Estudiante("Vacío", "00000", 1);
        double promedio = vacio.calcularPromedioGeneral();
        assertEquals(0.0, promedio, 0.01, "Un estudiante sin asignaturas debe tener promedio 0.0");
    }

    @Test
    void testAsignaturaSinNotas() {
        // Una asignatura sin notas debe tener nota final 0.0
        Asignatura vacia = new Asignatura("Vacía");
        double notaFinal = vacia.calcularNotaFinal();
        assertEquals(0.0, notaFinal, 0.01, "Una asignatura sin notas debe tener nota final 0.0");
    }

    @Test
    void testPorcentajesInvalidos() {
        // Una asignatura con porcentajes que no suman 100% no debe calcular nota final
        Asignatura invalida = new Asignatura("Inválida");
        invalida.agregarNota(new Nota("Parcial 1", 4.0, 30));
        invalida.agregarNota(new Nota("Parcial 2", 4.0, 30));
        // Solo suma 60%, falta 40%

        assertFalse(invalida.validarPorcentajes(), "Los porcentajes no deben ser válidos");
        assertEquals(0.0, invalida.calcularNotaFinal(), 0.01,
                "No debe calcular nota final con porcentajes inválidos");
    }

    @Test
    void testEstudianteExcelente() {
        // Crear un estudiante con promedio excelente (>= 4.5)
        Estudiante excelente = new Estudiante("Excelente", "11111", 1);
        Asignatura a1 = new Asignatura("A1");
        a1.agregarNota(new Nota("Eval", 4.6, 100));
        excelente.agregarAsignatura(a1);

        Asignatura a2 = new Asignatura("A2");
        a2.agregarNota(new Nota("Eval", 4.7, 100));
        excelente.agregarAsignatura(a2);

        assertEquals("Excelente", excelente.clasificarRendimiento(),
                "Un estudiante con promedio >= 4.5 debe tener clasificación Excelente");
        assertEquals("Regular", excelente.determinarEstadoAcademico(),
                "Un estudiante sin reprobadas debe estar en estado Regular");
    }
}
