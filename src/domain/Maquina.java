package domain;

import java.io.Serializable;

/**
 * La clase Maquina representa un jugador controlado por la máquina en un juego.
 * Extiende la clase abstracta Jugadores e implementa la interfaz Serializable.
 */
public class Maquina extends Jugadores implements Serializable {

    /**
     * Constructor de la clase Maquina.
     * @param ficha La ficha que usará la máquina como jugador.
     * @param Tipo El tipo de ficha que la máquina utilizará en el juego.
     */
    public Maquina(Fichas ficha,char Tipo){
        super(ficha,Tipo);
    }
    /**
     * Obtiene la ficha que utiliza la máquina como jugador.
     * @return La ficha que utiliza la máquina.
     */
    public Fichas getFicha(){
        return Ficha;
    }
    /**
     * Realiza un movimiento aleatorio en el tablero en el juego de Gomoku.
     * @param tablero El tablero en el que se realiza el movimiento.
     * @param gomoku El juego de Gomoku en el que se está jugando.
     */
    public void Play(Tablero tablero, Gomoku gomoku) {
        int x = generarMovimientoAleatorio(tablero.getLongitud());
        int y = generarMovimientoAleatorio(tablero.getAltura());
        while (tablero.getCasilla(x, y).getFicha() != ' ') {
            x = generarMovimientoAleatorio(tablero.getLongitud());
            y = generarMovimientoAleatorio(tablero.getAltura());
        }
        gomoku.playGame(x, y);
    }

    public void Play(Tablero tablero, Gomoku gomoku, int fila, int columna) {
        if (tablero.getCasilla(fila, columna).getFicha() == ' ') {
            gomoku.playGame(fila, columna);
        } else {
            System.out.println("La casilla en la fila " + fila + " y columna " + columna + " no está vacía.");
        }
    }
    /**
     * Genera un número aleatorio dentro de un límite dado.
     * @param limite El límite superior para generar el número aleatorio.
     * @return Un número aleatorio dentro del rango especificado.
     */
    private int generarMovimientoAleatorio(int limite) {
        return (int) (Math.random() * limite);
    }
}
