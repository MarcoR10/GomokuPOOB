package domain;

import java.awt.*;

public class Pesada implements Ficha {
    private final char Tipo = 'P';
    private Color color;
    private char jugador;

    public void setJugador(char jugador) {
        this.jugador  = jugador;
    }
    public char TypeFicha() {
        return Tipo;
    }

    public void colocarEnTablero(Tablero tablero, int x, int y, char jugador) {
        // Colocar la ficha pesada en el tablero ocupando dos casillas consecutivas
        // Puedes implementar la lógica para verificar y colocar la ficha pesada según las direcciones permitidas en el tablero
        // Por ejemplo, para dirección este (derecha):
        if (x + 1 < tablero.getLongitud()) {
            tablero.colocarFicha(x, y, jugador);
            tablero.colocarFicha(x + 1, y, jugador);
        }
        // Puedes implementar lógica similar para las direcciones norte y noreste
    }

}
