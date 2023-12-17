package domain;

import java.io.Serializable;


/**
 * La clase Mine representa una casilla mina en un juego de tablero.
 * Extiende la clase abstracta Casillas e implementa la interfaz Serializable.
 */
public class Mine extends Casillas implements Serializable {
    private boolean explotado = false;
    public Mine(int x, int y) {
        super(x, y);
        type = 'M';

    }

    /**
     * Realiza la explosión de la mina, eliminando las fichas alrededor de la casilla mina.
     * @param jugador El jugador activador de la explosión.
     * @param casillas La matriz de casillas del tablero donde se encuentra la mina.
     */
    public void explotar(Jugador jugador, Casillas[][] casillas) {
        int longitud = casillas.length;
        int altura = casillas[0].length;
        int x = getX();
        int y = getY();
        for (int i = Math.max(0, x - 1); i <= Math.min(longitud - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(altura - 1, y + 1); j++) {
                casillas[i][j].setFicha(' ');
            }
        }
        explotado = true;
    }
}
