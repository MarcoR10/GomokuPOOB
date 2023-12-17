package domain;

import java.awt.*;
import java.io.Serializable;

/**
 * La clase Fichas representa las fichas utilizadas en el juego Gomoku.
 * Implementa la interfaz Ficha y proporciona métodos para manipular las características de las fichas.
 */
public class Fichas implements Ficha, Serializable {
    protected char Tipo;
    protected Color color;
    protected char jugador;

    /**
     * Constructor de la clase Fichas que inicializa una ficha para un jugador específico.
     * @param Jugador El carácter que representa al jugador (ej. 'X' o 'O')
     */
    public Fichas(char Jugador){
        jugador = Jugador;
        Tipo = 'N';
    }
    /**
     * Establece el jugador asociado a la ficha.
     * @param jugador El carácter que representa al jugador (ej. 'X' o 'O')
     */
    public void setJugador(char jugador) {
        this.jugador  = jugador;
    }
    /**
     * Obtiene el tipo de la ficha.
     * @return El carácter que representa el tipo de la ficha.
     */
    public char TypeFicha() {
        return Tipo;
    }
    /**
     * Obtiene el jugador asociado a la ficha.
     * @return El carácter que representa al jugador (ej. 'X' o 'O')
     */
    public char getJugador() {
        return jugador;
    }
}
