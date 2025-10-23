/**
 * Clase Main
 * Programa principal para demostrar el funcionamiento del juego de Triqui
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   SISTEMA DE JUEGO DE TRIQUI");
        System.out.println("   Juegos Clásicos Digital");
        System.out.println("==============================================\n");

        // Crear una instancia del juego
        JuegoTriqui juego = new JuegoTriqui();

        System.out.println("*** ESCENARIO 1: Victoria del Jugador 1 por diagonal ***\n");

        // Mostrar tablero inicial
        juego.mostrarTablero();

        // Jugada 1: Jugador 1 selecciona casilla 5 (centro)
        System.out.println("Jugador 1 intenta jugar en casilla 5");
        juego.jugar(1, 5);
        juego.mostrarTablero();
        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Turno actual: Jugador " + juego.obtenerTurnoActual() + "\n");

        // Jugada 2: Jugador 2 selecciona casilla 1
        System.out.println("Jugador 2 intenta jugar en casilla 1");
        juego.jugar(2, 1);
        juego.mostrarTablero();
        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Turno actual: Jugador " + juego.obtenerTurnoActual() + "\n");

        // Jugada 3: Jugador 1 selecciona casilla 3
        System.out.println("Jugador 1 intenta jugar en casilla 3");
        juego.jugar(1, 3);
        juego.mostrarTablero();
        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Turno actual: Jugador " + juego.obtenerTurnoActual() + "\n");

        // Jugada 4: Jugador 2 selecciona casilla 2
        System.out.println("Jugador 2 intenta jugar en casilla 2");
        juego.jugar(2, 2);
        juego.mostrarTablero();
        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Turno actual: Jugador " + juego.obtenerTurnoActual() + "\n");

        // Jugada 5: Jugador 1 selecciona casilla 7 (¡Victoria por diagonal!)
        System.out.println("Jugador 1 intenta jugar en casilla 7");
        juego.jugar(1, 7);
        juego.mostrarTablero();
        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Jugadas realizadas: " + juego.obtenerJugadasRealizadas() + "\n");

        System.out.println("==============================================\n");

        // Reiniciar juego para nuevo escenario
        juego.reiniciarJuego();

        System.out.println("\n*** ESCENARIO 2: Jugadas inválidas y recuperación ***\n");

        // Jugada 1: Jugador 1 selecciona casilla 5
        System.out.println("Jugador 1 intenta jugar en casilla 5");
        juego.jugar(1, 5);
        juego.mostrarTablero();

        // Jugada 2 (INVÁLIDA): Jugador 2 intenta jugar en casilla 5 (ocupada)
        System.out.println("Jugador 2 intenta jugar en casilla 5 (¡casilla ocupada!)");
        boolean resultado = juego.jugar(2, 5);
        System.out.println("¿Jugada aceptada? " + resultado);
        System.out.println("Turno actual: Jugador " + juego.obtenerTurnoActual() + "\n");

        // Jugada 2 (VÁLIDA): Jugador 2 juega en casilla 1
        System.out.println("Jugador 2 intenta jugar en casilla 1");
        juego.jugar(2, 1);
        juego.mostrarTablero();

        // Jugada 3 (INVÁLIDA): Jugador 1 intenta jugar en casilla 1 (ocupada)
        System.out.println("Jugador 1 intenta jugar en casilla 1 (¡casilla ocupada!)");
        resultado = juego.jugar(1, 1);
        System.out.println("¿Jugada aceptada? " + resultado);
        System.out.println("Turno actual: Jugador " + juego.obtenerTurnoActual() + "\n");

        // Jugada 3 (VÁLIDA): Jugador 1 juega en casilla 9
        System.out.println("Jugador 1 intenta jugar en casilla 9");
        juego.jugar(1, 9);
        juego.mostrarTablero();

        // Jugada 4: Jugador 2 juega en casilla 3
        System.out.println("Jugador 2 intenta jugar en casilla 3");
        juego.jugar(2, 3);
        juego.mostrarTablero();

        System.out.println("==============================================\n");

        // Reiniciar juego para nuevo escenario
        juego.reiniciarJuego();

        System.out.println("\n*** ESCENARIO 3: Victoria del Jugador 2 por columna ***\n");

        // Secuencia de jugadas para victoria del Jugador 2
        System.out.println("Jugador 1 juega en casilla 1");
        juego.jugar(1, 1);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 5 (centro)");
        juego.jugar(2, 5);
        juego.mostrarTablero();

        System.out.println("Jugador 1 juega en casilla 9");
        juego.jugar(1, 9);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 3");
        juego.jugar(2, 3);
        juego.mostrarTablero();

        System.out.println("Jugador 1 juega en casilla 2");
        juego.jugar(1, 2);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 7 (¡Victoria por diagonal!)");
        juego.jugar(2, 7);
        juego.mostrarTablero();
        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Jugadas realizadas: " + juego.obtenerJugadasRealizadas() + "\n");

        System.out.println("==============================================\n");

        // Reiniciar juego para escenario de empate
        juego.reiniciarJuego();

        System.out.println("\n*** ESCENARIO 4: Empate ***\n");

        // Secuencia que resulta en empate
        System.out.println("Jugador 1 juega en casilla 1");
        juego.jugar(1, 1);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 5");
        juego.jugar(2, 5);
        juego.mostrarTablero();

        System.out.println("Jugador 1 juega en casilla 2");
        juego.jugar(1, 2);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 3");
        juego.jugar(2, 3);
        juego.mostrarTablero();

        System.out.println("Jugador 1 juega en casilla 6");
        juego.jugar(1, 6);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 4");
        juego.jugar(2, 4);
        juego.mostrarTablero();

        System.out.println("Jugador 1 juega en casilla 8");
        juego.jugar(1, 8);
        juego.mostrarTablero();

        System.out.println("Jugador 2 juega en casilla 7");
        juego.jugar(2, 7);
        juego.mostrarTablero();

        System.out.println("Jugador 1 juega en casilla 9");
        juego.jugar(1, 9);
        juego.mostrarTablero();

        System.out.println("Estado del juego: " + juego.obtenerEstadoJuego());
        System.out.println("Jugadas realizadas: " + juego.obtenerJugadasRealizadas() + "\n");

        System.out.println("==============================================");
        System.out.println("   FIN DE LA DEMOSTRACIÓN");
        System.out.println("==============================================");
    }
}
