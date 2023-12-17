package domain;
import java.io.Serializable;
import java.util.Random;


/**
 * La clase Teleport representa una casilla de teletransporte en un juego de tablero.
 * Extiende la clase abstracta Casillas e implementa la interfaz Serializable.
 */
public class Teleport extends Casillas implements Serializable {
    private boolean Utilizado = false;

    /**
     * Constructor de la clase Teleport.
     * @param x Coordenada x de la casilla de teletransporte.
     * @param y Coordenada y de la casilla de teletransporte.
     */
    public Teleport(int x, int y) {
        super(x,y);
        type = 'T';
    }
    /**
     * Teletransporta al jugador a una posición aleatoria en el tablero.
     * @param jugador El jugador a teletransportar.
     * @param ficha La ficha que representa al jugador.
     * @param tablero El tablero en el que se está jugando.
     */
    public void teletransportar(Jugador jugador, char ficha, Tablero tablero) {
        Random random = new Random();
        int maxAttempts = tablero.getLongitud() * tablero.getAltura(); // Número máximo de intentos
        int attempt = 0;
        while (attempt < maxAttempts) {
            int newX = random.nextInt(tablero.getLongitud());
            int newY = random.nextInt(tablero.getAltura());
            if (tablero.getCasilla(newX, newY) instanceof Casillas) {
                tablero.getCasilla(x, y).setFicha(' ');
                tablero.getCasilla(newX, newY).setFicha(ficha);
                return; // Salir del método si se encontró una posición válida
            }
            attempt++;
        }
        System.out.println("No se encontró una posición válida para teletransportar al jugador.");
        // Aquí puedes manejar el caso cuando no se encuentra una posición válida después de los intentos máximos
    }
}
