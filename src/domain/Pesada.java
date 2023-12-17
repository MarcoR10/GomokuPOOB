package domain;

import java.awt.*;
import java.io.Serializable;

/**
 * La clase Pesada representa una ficha pesada en un juego de tablero.
 * Extiende la clase abstracta Fichas e implementa la interfaz Serializable.
 */
public class Pesada extends Fichas implements Serializable {
    private char Tipo = 'P';
    private Color color;
    private char jugador;

    /**
     * Constructor de la clase Pesada.
     * @param Jugador El jugador al que pertenece la ficha pesada.
     */
    public Pesada(char Jugador){
        super(Jugador);
        Tipo = 'P';
    }

    /**
     * Coloca la ficha pesada en el tablero en las coordenadas especificadas por 'x' e 'y'.
     * @param tablero El tablero en el que se coloca la ficha.
     * @param x Coordenada x en el tablero.
     * @param y Coordenada y en el tablero.
     * @param jugador El jugador que coloca la ficha.
     */
    public void colocarEnTablero(Tablero tablero, int x, int y, char jugador) {
        // Verificar si es posible colocar la ficha pesada en la dirección este/derecha
        if (x + 1 < tablero.getLongitud()) {
            Casillas casilla1 = tablero.getCasilla(x, y);
            Casillas casilla2 = tablero.getCasilla(x + 1, y);
            // Verificar que las dos casillas estén vacías para poder colocar la ficha pesada
            if (casilla1.getFicha() == ' ' && casilla2.getFicha() == ' ') {
                // Colocar la ficha pesada ocupando dos casillas consecutivas
                tablero.colocarFicha(x, y, jugador);
                tablero.colocarFicha(x + 1, y, jugador);
            } else {
                System.out.println("No es posible colocar la ficha pesada en esta dirección.");
            }
        } else {
            System.out.println("No es posible colocar la ficha pesada en esta dirección, se excede el límite del tablero.");
        }
    }

}
