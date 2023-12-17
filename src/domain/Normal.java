package domain;
import java.awt.*;
import java.io.Serializable;

/**
 * La clase Normal representa una ficha normal en un juego de tablero.
 * Extiende la clase abstracta Fichas e implementa la interfaz Serializable.
 */
public class Normal extends Fichas implements Serializable {
    private char Tipo;
    private Color color;
    private char jugador;

    /**
     * Constructor de la clase Normal.
     * @param Jugador El jugador al que pertenece la ficha normal.
     */
    public Normal(char Jugador){
        super(Jugador);
    }

}
