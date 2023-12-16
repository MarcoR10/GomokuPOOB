package domain;

import java.awt.*;

public class Fichas implements Ficha{
    protected char Tipo;
    protected Color color;
    protected char jugador;

    public Fichas(char Jugador){
        jugador = Jugador;
        Tipo = 'N';
    }
    public void setJugador(char jugador) {
        this.jugador  = jugador;
    }
    public char TypeFicha() {
        return Tipo;
    }
    public char getJugador() {
        return jugador;
    }
}
