package domain;
import java.util.Random;

public class Teleport extends Casillas{
    private boolean Utilizado = false;
    public Teleport(int x, int y) {
        super(x,y);
        type = 'T';
    }
    public void teletransportar(Jugador jugador, char ficha, Tablero tablero) {
        Random random = new Random();
        int nuevoX, nuevoY;
            do {
                nuevoX = random.nextInt(tablero.getLongitud());
                nuevoY = random.nextInt(tablero.getAltura());
            } while (tablero.getCasilla(nuevoX, nuevoY) instanceof Mine); // Evitar teletransportarse a una mina
            // Obtener las coordenadas actuales del jugador (suponiendo que estén disponibles en el objeto Jugador)
            //int x = jugador.getX();
            //int y = jugador.getY();
            // Actualizar la posición del jugador en el tablero
            tablero.getCasilla(x, y).setFicha(' '); // Limpiar la casilla actual
            tablero.getCasilla(nuevoX, nuevoY).setFicha(ficha); // Colocar la ficha en la nueva posición
            // Actualizar las coordenadas del jugador en el objeto Jugador (si es necesario)
            //jugador.setPosicion(nuevoX, nuevoY);
    }

}
