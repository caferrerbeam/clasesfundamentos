/**
 * Clase JuegoTriqui
 * Sistema para controlar un juego de Triqui (Tic-Tac-Toe)
 * Implementado SIN arreglos, SIN ciclos, SOLO con estructuras de decisión
 */
public class JuegoTriqui {

    // Atributos para las 9 casillas del tablero
    private String casilla1;
    private String casilla2;
    private String casilla3;
    private String casilla4;
    private String casilla5;
    private String casilla6;
    private String casilla7;
    private String casilla8;
    private String casilla9;

    // Control del juego
    private int turnoActual;        // 1 o 2
    private int estadoJuego;        // 0: en progreso, 1: ganó J1, 2: ganó J2, -1: empate
    private int jugadasRealizadas;  // Contador de jugadas válidas

    /**
     * Constructor: Inicializa un nuevo juego
     */
    public JuegoTriqui() {
        casilla1 = "";
        casilla2 = "";
        casilla3 = "";
        casilla4 = "";
        casilla5 = "";
        casilla6 = "";
        casilla7 = "";
        casilla8 = "";
        casilla9 = "";
        turnoActual = 1;  // Jugador 1 siempre empieza
        estadoJuego = 0;  // Juego en progreso
        jugadasRealizadas = 0;
    }

    /**
     * Procesa una jugada del jugador
     * @param jugador Número del jugador (1 o 2)
     * @param casilla Número de casilla (1-9)
     * @return true si la jugada fue válida y aceptada, false si fue rechazada
     */
    public boolean jugar(int jugador, int casilla) {
        // Verificar que el juego no haya terminado
        if (estadoJuego != 0) {
            System.out.println("El juego ya terminó. No se pueden hacer más jugadas.");
            return false;
        }

        // Verificar que sea el turno correcto
        if (jugador != turnoActual) {
            System.out.println("No es el turno del Jugador " + jugador);
            return false;
        }

        // Validar la jugada
        if (!validarJugada(casilla)) {
            System.out.println("Jugada inválida. La casilla " + casilla + " no está disponible.");
            return false;
        }

        // Colocar el símbolo del jugador
        colocarSimbolo(jugador, casilla);
        jugadasRealizadas++;

        // Verificar si hay victoria
        int ganador = verificarVictoria();
        if (ganador == 1) {
            estadoJuego = 1;
            System.out.println("¡Ganó el Jugador 1 (X)!");
            return true;
        } else if (ganador == 2) {
            estadoJuego = 2;
            System.out.println("¡Ganó el Jugador 2 (O)!");
            return true;
        }

        // Verificar si hay empate
        if (verificarEmpate()) {
            estadoJuego = -1;
            System.out.println("¡Empate! El tablero está lleno.");
            return true;
        }

        // Cambiar el turno
        cambiarTurno();

        return true;
    }

    /**
     * Valida si una jugada es posible en la casilla especificada
     * @param casilla Número de casilla (1-9)
     * @return true si la casilla está vacía y es válida
     */
    private boolean validarJugada(int casilla) {
        if (casilla == 1) {
            return casilla1.equals("");
        } else if (casilla == 2) {
            return casilla2.equals("");
        } else if (casilla == 3) {
            return casilla3.equals("");
        } else if (casilla == 4) {
            return casilla4.equals("");
        } else if (casilla == 5) {
            return casilla5.equals("");
        } else if (casilla == 6) {
            return casilla6.equals("");
        } else if (casilla == 7) {
            return casilla7.equals("");
        } else if (casilla == 8) {
            return casilla8.equals("");
        } else if (casilla == 9) {
            return casilla9.equals("");
        } else {
            return false;  // Casilla fuera de rango
        }
    }

    /**
     * Coloca el símbolo del jugador en la casilla especificada
     * @param jugador Número del jugador (1 o 2)
     * @param casilla Número de casilla (1-9)
     */
    private void colocarSimbolo(int jugador, int casilla) {
        String simbolo;
        if (jugador == 1) {
            simbolo = "X";
        } else {
            simbolo = "O";
        }

        switch (casilla) {
            case 1:
                casilla1 = simbolo;
                break;
            case 2:
                casilla2 = simbolo;
                break;
            case 3:
                casilla3 = simbolo;
                break;
            case 4:
                casilla4 = simbolo;
                break;
            case 5:
                casilla5 = simbolo;
                break;
            case 6:
                casilla6 = simbolo;
                break;
            case 7:
                casilla7 = simbolo;
                break;
            case 8:
                casilla8 = simbolo;
                break;
            case 9:
                casilla9 = simbolo;
                break;
        }
    }

    /**
     * Verifica si hay un ganador
     * @return 1 si ganó Jugador 1, 2 si ganó Jugador 2, 0 si no hay ganador
     */
    private int verificarVictoria() {
        // Verificar líneas horizontales
        // Fila 1: casillas 1, 2, 3
        if (!casilla1.equals("") && casilla1.equals(casilla2) && casilla2.equals(casilla3)) {
            if (casilla1.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Fila 2: casillas 4, 5, 6
        if (!casilla4.equals("") && casilla4.equals(casilla5) && casilla5.equals(casilla6)) {
            if (casilla4.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Fila 3: casillas 7, 8, 9
        if (!casilla7.equals("") && casilla7.equals(casilla8) && casilla8.equals(casilla9)) {
            if (casilla7.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Verificar líneas verticales
        // Columna 1: casillas 1, 4, 7
        if (!casilla1.equals("") && casilla1.equals(casilla4) && casilla4.equals(casilla7)) {
            if (casilla1.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Columna 2: casillas 2, 5, 8
        if (!casilla2.equals("") && casilla2.equals(casilla5) && casilla5.equals(casilla8)) {
            if (casilla2.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Columna 3: casillas 3, 6, 9
        if (!casilla3.equals("") && casilla3.equals(casilla6) && casilla6.equals(casilla9)) {
            if (casilla3.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Verificar líneas diagonales
        // Diagonal principal: casillas 1, 5, 9
        if (!casilla1.equals("") && casilla1.equals(casilla5) && casilla5.equals(casilla9)) {
            if (casilla1.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        // Diagonal secundaria: casillas 3, 5, 7
        if (!casilla3.equals("") && casilla3.equals(casilla5) && casilla5.equals(casilla7)) {
            if (casilla3.equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }

        return 0;  // No hay ganador
    }

    /**
     * Verifica si hay empate (todas las casillas ocupadas)
     * @return true si todas las casillas están ocupadas
     */
    private boolean verificarEmpate() {
        if (!casilla1.equals("") && !casilla2.equals("") && !casilla3.equals("") &&
            !casilla4.equals("") && !casilla5.equals("") && !casilla6.equals("") &&
            !casilla7.equals("") && !casilla8.equals("") && !casilla9.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * Cambia el turno al otro jugador
     */
    private void cambiarTurno() {
        if (turnoActual == 1) {
            turnoActual = 2;
        } else {
            turnoActual = 1;
        }
    }

    /**
     * Obtiene el estado actual del juego
     * @return 0: en progreso, 1: ganó J1, 2: ganó J2, -1: empate
     */
    public int obtenerEstadoJuego() {
        return estadoJuego;
    }

    /**
     * Obtiene de quién es el turno actual
     * @return 1 o 2
     */
    public int obtenerTurnoActual() {
        return turnoActual;
    }

    /**
     * Obtiene el número de jugadas válidas realizadas
     * @return cantidad de jugadas
     */
    public int obtenerJugadasRealizadas() {
        return jugadasRealizadas;
    }

    /**
     * Muestra el tablero en la consola
     */
    public void mostrarTablero() {
        String c1 = casilla1.equals("") ? " " : casilla1;
        String c2 = casilla2.equals("") ? " " : casilla2;
        String c3 = casilla3.equals("") ? " " : casilla3;
        String c4 = casilla4.equals("") ? " " : casilla4;
        String c5 = casilla5.equals("") ? " " : casilla5;
        String c6 = casilla6.equals("") ? " " : casilla6;
        String c7 = casilla7.equals("") ? " " : casilla7;
        String c8 = casilla8.equals("") ? " " : casilla8;
        String c9 = casilla9.equals("") ? " " : casilla9;

        System.out.println("\n Tablero actual:");
        System.out.println(" " + c1 + " | " + c2 + " | " + c3);
        System.out.println("-----------");
        System.out.println(" " + c4 + " | " + c5 + " | " + c6);
        System.out.println("-----------");
        System.out.println(" " + c7 + " | " + c8 + " | " + c9);
        System.out.println();
    }

    /**
     * Reinicia el juego a su estado inicial
     */
    public void reiniciarJuego() {
        casilla1 = "";
        casilla2 = "";
        casilla3 = "";
        casilla4 = "";
        casilla5 = "";
        casilla6 = "";
        casilla7 = "";
        casilla8 = "";
        casilla9 = "";
        turnoActual = 1;
        estadoJuego = 0;
        jugadasRealizadas = 0;
        System.out.println("Juego reiniciado. ¡Nueva partida!");
    }
}
