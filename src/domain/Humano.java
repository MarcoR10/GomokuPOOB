package domain;

import java.io.Serializable;

public class Humano extends Jugadores implements Serializable {
    public Humano(Fichas ficha,char Tipo){
        super(ficha,Tipo);
    }
}
