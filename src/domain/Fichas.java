package domain;

import java.awt.*;

public class Fichas implements Ficha{
    protected  char Tipo = ' ';
    protected Color color;
    protected char jugador;

    public Fichas(){

    }
    public void setJugador(char jugador) {
        this.jugador  = jugador;
    }
    public char TypeFicha() {
        return Tipo;
    }
}
