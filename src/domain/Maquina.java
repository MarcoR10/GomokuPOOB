package domain;

import java.io.Serializable;

public class Maquina extends Jugadores implements Serializable {
    public Maquina(Fichas ficha,char Tipo){
        super(ficha,Tipo);
    }
    public Fichas getFicha(){
        return Ficha;
    }

    public void Play(Tablero tablero, Gomoku gomoku) {
        int x = generarMovimientoAleatorio(tablero.getLongitud());
        int y = generarMovimientoAleatorio(tablero.getAltura());
        // Verificar si la casilla generada aleatoriamente está vacía y realizar el movimiento si lo está
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

    // Generar un movimiento aleatorio dentro de los límites del tablero
    private int generarMovimientoAleatorio(int limite) {
        return (int) (Math.random() * limite);
    }
}
