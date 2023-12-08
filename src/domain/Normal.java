package domain;
import java.awt.*;

public class Normal implements Ficha{
    private final char Tipo = 'N';
    private Color color;
    private char jugador;
    public void setJugador(char jugador) {
        this.jugador  = jugador;
    }
    public char TypeFicha() {
        return Tipo;
    }

}
