package domain;

/**
 * La interfaz Ficha define los métodos para la manipulación de fichas en el juego Gomoku.
 */
public interface Ficha {
    /**
     * Establece el jugador asociado a la ficha.
     * @param jugador El carácter que representa al jugador (ej. 'X' o 'O')
     */
    void  setJugador(char jugador);
    /**
     * Obtiene el tipo de la ficha.
     * @return El carácter que representa el tipo de la ficha.
     */
    char TypeFicha();
    /**
     * Obtiene el jugador asociado a la ficha.
     * @return El carácter que representa al jugador (ej. 'X' o 'O')
     */
    char getJugador();
}
