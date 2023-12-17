package domain;

import java.io.Serializable;

/**
 * La clase Humano representa un jugador humano en un juego.
 * Extiende la clase Jugadores y es serializable.
 */
public class Humano extends Jugadores implements Serializable {
    /**
     * Constructor de la clase Humano.
     * @param ficha La ficha asociada al jugador humano.
     * @param Tipo El tipo de ficha del jugador humano.
     */
    public Humano(Fichas ficha,char Tipo){
        super(ficha,Tipo);
    }
}
