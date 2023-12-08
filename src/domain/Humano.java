package domain;

public class Humano implements Jugador{

    private String Nombre;
    private char Ficha;
    private int Puntaje;
   // private Tiempo time;

    public Humano(char ficha){
        Ficha = ficha;
    }

    public char getFicha(){
        return Ficha;
    }
    public void Play(){

    }

}
