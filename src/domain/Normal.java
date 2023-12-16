package domain;
import java.awt.*;
import java.io.Serializable;

public class Normal extends Fichas implements Serializable {
    private char Tipo;
    private Color color;
    private char jugador;

    public Normal(char Jugador){
        super(Jugador);
    }

}
