package domain;
import java.awt.*;

public class Jugadores implements Jugador{
    protected String Nombre;
    protected Color color;
    protected char Ficha;
    protected int Puntaje;
    public Jugadores(char Ficha){
        this.Ficha = Ficha;
    }
    public char getFicha(){
        return Ficha;
    }
    public void Play(){
    }

}
