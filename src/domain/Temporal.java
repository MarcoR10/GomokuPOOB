package domain;

import java.awt.*;

public class Temporal implements Ficha{
    private final char Tipo = 'E';
    private Color color;
    private char jugador;
    private int turnosRestantes;

    public void setJugador(char jugador) {
        this.jugador  = jugador;
    }
    public char TypeFicha() {
        return Tipo;
    }

    public void colocarEnTablero(Tablero tablero, int x, int y, char jugador) {
        tablero.colocarFicha(x, y, jugador);
        this.turnosRestantes = 3; // Configurar el contador de turnos restantes
    }

    public void reducirTurno() {
        this.turnosRestantes--;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

}
