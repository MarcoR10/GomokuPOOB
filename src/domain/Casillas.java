package domain;

import java.io.Serializable;

/**
 * La clase Casillas representa cada celda individual en el juego Gomoku.
 * Cada casilla tiene una posición (coordenadas x, y), una ficha asociada y un tipo.
 */
public class Casillas implements Serializable {
    protected int x,y;
    protected char ficha,type;
    /**
     * Constructor de la clase Casillas para inicializar una casilla en una posición dada.
     * @param x Coordenada X de la casilla en el tablero
     * @param y Coordenada Y de la casilla en el tablero
     */
    public Casillas(int x, int y) {
        this.x = x;
        this.y = y;
        ficha = ' ';
        type = 'N';
    }
    /**
     * Obtiene la coordenada X de la casilla.
     * @return Coordenada X de la casilla
     */
    public int getX(){
        return x;
    }
    /**
     * Obtiene la coordenada Y de la casilla.
     * @return Coordenada Y de la casilla
     */
    public int getY(){
        return y;
    }
    /**
     * Establece la ficha asociada a la casilla.
     * @param ficha Carácter que representa la ficha a asignar a la casilla
     */
    public void setFicha(char Ficha){
        this.ficha = Ficha;
    }
    /**
     * Obtiene la ficha asociada a la casilla.
     * @return Carácter que representa la ficha en la casilla
     */
    public char getFicha(){
        return ficha;
    }
    /**
     * Obtiene el tipo de la casilla.
     * @return Carácter que representa el tipo de la casilla
     */
    public char getType(){
        return type;
    }
}
