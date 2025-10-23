package org.example;

import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Asignatura;
import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Estudiante;
import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Nota;

/**
 * Clase principal para demostrar el funcionamiento del Sistema de Gestión Académica.
 * Incluye casos de ejemplo que muestran cómo usar las clases del sistema.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  SISTEMA DE GESTIÓN ACADÉMICA");
        System.out.println("  Universidad Excelencia Académica");
        System.out.println("========================================\n");

        // Crear un estudiante del Ejemplo 2 del enunciado: María González
        Estudiante maria = new Estudiante("María González", "202315001", 2);

        // ========================== CÁLCULO I ==========================
        Asignatura calculo = new Asignatura("Cálculo I");
        calculo.agregarNota(new Nota("Parcial 1", 3.2, 30));
        calculo.agregarNota(new Nota("Parcial 2", 3.5, 30));
        calculo.agregarNota(new Nota("Examen Final", 3.8, 40));
        maria.agregarAsignatura(calculo);

        // ========================== FÍSICA I ==========================
        Asignatura fisica = new Asignatura("Física I");
        fisica.agregarNota(new Nota("Quiz 1", 4.0, 10));
        fisica.agregarNota(new Nota("Quiz 2", 4.5, 10));
        fisica.agregarNota(new Nota("Laboratorio", 4.2, 20));
        fisica.agregarNota(new Nota("Parcial", 4.3, 30));
        fisica.agregarNota(new Nota("Examen Final", 4.4, 30));
        maria.agregarAsignatura(fisica);

        // ========================== PROGRAMACIÓN I ==========================
        Asignatura programacion = new Asignatura("Programación I");
        programacion.agregarNota(new Nota("Talleres", 2.8, 20));
        programacion.agregarNota(new Nota("Parcial", 2.5, 30));
        programacion.agregarNota(new Nota("Proyecto", 3.2, 50));
        maria.agregarAsignatura(programacion);

        // ========================== INGLÉS I ==========================
        Asignatura ingles = new Asignatura("Inglés I");
        ingles.agregarNota(new Nota("Oral", 4.5, 25));
        ingles.agregarNota(new Nota("Escrito", 4.8, 25));
        ingles.agregarNota(new Nota("Parcial", 4.6, 30));
        ingles.agregarNota(new Nota("Final", 4.7, 20));
        maria.agregarAsignatura(ingles);

        // ========================== MOSTRAR RESULTADOS ==========================
        System.out.println("\n" + maria.mostrarReporteCompleto());

        System.out.println("\n========================================");
        System.out.println("  RESULTADOS ESPERADOS DEL EJEMPLO");
        System.out.println("========================================");
        System.out.println("Cálculo I: 3.53 (APROBADA)");
        System.out.println("Física I: 4.30 (APROBADA)");
        System.out.println("Programación I: 2.91 (REPROBADA)");
        System.out.println("Inglés I: 4.65 (APROBADA CON EXCELENCIA)");
        System.out.println("Promedio General: 3.85");
        System.out.println("Clasificación: Aceptable");
        System.out.println("Estado Académico: Advertencia");
        System.out.println("========================================\n");

        System.out.println("NOTA: Los resultados mostrados arriba son los esperados.");
        System.out.println("Una vez implementes los métodos, deberías obtener estos valores.\n");

        // ========================== EJEMPLO 2: Estudiante en Riesgo ==========================
        System.out.println("\n========================================");
        System.out.println("  EJEMPLO 2: ESTUDIANTE EN RIESGO");
        System.out.println("========================================\n");

        Estudiante carlos = new Estudiante("Carlos Ramírez", "202315002", 1);

        // Crear asignaturas con notas ya calculadas (simplificado)
        Asignatura matematicas = new Asignatura("Matemáticas Básicas");
        matematicas.agregarNota(new Nota("Evaluación", 2.5, 100));
        carlos.agregarAsignatura(matematicas);

        Asignatura intro = new Asignatura("Introducción a la Ingeniería");
        intro.agregarNota(new Nota("Evaluación", 3.2, 100));
        carlos.agregarAsignatura(intro);

        Asignatura quimica = new Asignatura("Química General");
        quimica.agregarNota(new Nota("Evaluación", 2.8, 100));
        carlos.agregarAsignatura(quimica);

        Asignatura progBasica = new Asignatura("Programación Básica");
        progBasica.agregarNota(new Nota("Evaluación", 2.3, 100));
        carlos.agregarAsignatura(progBasica);

        Asignatura expresion = new Asignatura("Expresión Oral y Escrita");
        expresion.agregarNota(new Nota("Evaluación", 3.5, 100));
        carlos.agregarAsignatura(expresion);

        System.out.println("\n" + carlos.mostrarReporteCompleto());

        System.out.println("\n========================================");
        System.out.println("  RESULTADOS ESPERADOS");
        System.out.println("========================================");
        System.out.println("Promedio: 2.86");
        System.out.println("Clasificación: Deficiente");
        System.out.println("Estado Académico: Prueba Académica");
        System.out.println("Aprobadas: 2  |  Reprobadas: 3");
        System.out.println("========================================\n");
    }
}
