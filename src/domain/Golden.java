package domain;
import java.io.Serializable;
import java.util.Random;

/**
 * La clase Golden representa una casilla especial en el juego Gomoku.
 * Cuando un jugador aterriza en esta casilla, se le otorga una piedra aleatoria.
 * Extiende la clase Casillas y es identificada por el tipo 'G'.
 */
public class Golden extends Casillas implements Serializable {
    /**
     * Constructor de la clase Golden que inicializa una casilla dorada en una posición específica.
     * @param x Coordenada X de la casilla en el tablero.
     * @param y Coordenada Y de la casilla en el tablero.
     */
    public Golden(int x, int y) {
        super(x, y);
        type = 'G';
    }

    /**
     * Método para otorgar una piedra aleatoria al jugador cuando aterriza en esta casilla dorada.
     * @param jugador El jugador al que se le asignará la piedra aleatoria.
     */
    public void darPiedraAleatoria(Jugador jugador) {
        Random random = new Random();
        int tipoPiedra = random.nextInt(3); // Suponiendo que hay 3 tipos de piedra
        jugador.setPiedraAleatoria(tipoPiedra);
        System.out.println("Se ha asignado una piedra aleatoria al jugador: " + tipoPiedra);
    }
}
