package domain;
import java.io.Serializable;
import java.util.Random;

public class Golden extends Casillas implements Serializable {
    public Golden(int x, int y) {
        super(x, y);
        type = 'G';
    }
    public void darPiedraAleatoria(Jugador jugador) {
        Random random = new Random();
        int tipoPiedra = random.nextInt(3); // Suponiendo que hay 3 tipos de piedra
        // Asignar el tipo de piedra aleatorio al jugador
        //jugador.setPiedraAleatoria(tipoPiedra);
    }
}
