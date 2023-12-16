package domain;
import java.awt.*;

public class Jugadores implements Jugador{
    protected String Nombre;
    protected Color color;
    protected Fichas Ficha;
    protected int Puntaje;
    public Jugadores(Fichas Ficha){
        this.Ficha = Ficha;
    }
    public Ficha getFicha(){
        return Ficha;
    }

    public char getJugador(){
        return Ficha.getJugador();
    }
    public void Play(){
    }

}
