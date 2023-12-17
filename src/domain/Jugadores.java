package domain;
import java.awt.*;
import java.io.Serializable;

/**
 * La clase Jugadores representa a los jugadores en un juego.
 * Implementa la interfaz Jugador y es serializable.
 */
public class Jugadores implements Jugador, Serializable {
    protected String Nombre;
    protected Color color;
    protected Fichas Ficha;
    protected  char Tipo;
    protected int Puntaje;

    /**
     * Constructor de la clase Jugadores.
     * @param Ficha La ficha asociada al jugador.
     * @param Tipo El tipo de ficha del jugador.
     */
    public Jugadores(Fichas Ficha,char Tipo){
        this.Ficha = Ficha;
        this.Tipo = Tipo;
    }
    /**
     * Obtiene la ficha asociada al jugador.
     * @return La ficha asociada al jugador.
     */
    public Ficha getFicha(){
        return Ficha;
    }
    /**
     * Obtiene el identificador de jugador (carácter) asociado a la ficha.
     * @return El identificador de jugador (carácter).
     */
    public char getJugador(){
        return Ficha.getJugador();
    }
    /**
     * Obtiene el tipo de ficha del jugador.
     * @return El tipo de ficha del jugador.
     */
    public char getTipo(){
        return Tipo;
    }
    /**
     * Establece el tipo de piedra aleatoria para el jugador.
     * @param tipoPiedra El tipo de piedra aleatoria a establecer.
     * @return El tipo de piedra aleatoria establecida.
     */
    public int setPiedraAleatoria(int tipoPiedra) {
        return tipoPiedra;
    }
    /**
     * Realiza la jugada del jugador en el juego.
     * Este método debe ser implementado en las clases derivadas según el tipo de jugador.
     */
    public void Play(){
    }

}
