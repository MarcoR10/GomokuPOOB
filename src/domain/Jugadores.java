package domain;
import java.awt.*;
import java.io.Serializable;

public class Jugadores implements Jugador, Serializable {
    protected String Nombre;
    protected Color color;
    protected Fichas Ficha;
    protected  char Tipo;
    protected int Puntaje;
    public Jugadores(Fichas Ficha,char Tipo){
        this.Ficha = Ficha;
        this.Tipo = Tipo;
    }
    public Ficha getFicha(){
        return Ficha;
    }
    public char getJugador(){
        return Ficha.getJugador();
    }
    public char getTipo(){
        return Tipo;
    }
    public void Play(){
    }

}
