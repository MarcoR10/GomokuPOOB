package domain;

import java.awt.*;

public class Temporal extends Fichas{
    private char Tipo ;
    private Color color;
    private char jugador;
    private int turnosRestantes;
    public Temporal(char Jugador){
        super(Jugador);
        Tipo = 'T';
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
