package domain;

import java.awt.*;
import java.io.Serializable;


/**
 * La clase Temporal representa una ficha temporal en un juego de tablero.
 * Extiende la clase abstracta Fichas e implementa la interfaz Serializable.
 */
public class Temporal extends Fichas implements Serializable {
    private char Tipo ;
    private Color color;
    private char jugador;
    private int turnosRestantes;

    /**
     * Constructor de la clase Temporal.
     * @param Jugador El jugador al que pertenece la ficha.
     */
    public Temporal(char Jugador){
        super(Jugador);
        Tipo = 'T';
    }

    /**
     * Coloca la ficha en el tablero en las coordenadas especificadas por 'x' y 'y'.
     * @param tablero El tablero en el que se coloca la ficha.
     * @param x Coordenada x en el tablero.
     * @param y Coordenada y en el tablero.
     * @param jugador El jugador que coloca la ficha.
     */
    public void colocarEnTablero(Tablero tablero, int x, int y, char jugador) {
        tablero.colocarFicha(x, y, jugador);
        this.turnosRestantes = 3; // Configurar el contador de turnos restantes al colocar la ficha
    }
    /**
     * Reduce en uno el número de turnos restantes para que la ficha se mantenga en el tablero.
     */
    public void reducirTurno() {
        this.turnosRestantes--;
    }
    /**
     * Obtiene el número de turnos restantes para que la ficha se mantenga en el tablero.
     * @return El número de turnos restantes.
     */
    public int getTurnosRestantes() {
        return turnosRestantes;
    }

}
