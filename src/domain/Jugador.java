package domain;

public interface Jugador {
    /**
     * Obtiene la ficha asociada al jugador.
     * @return La ficha asociada al jugador.
     */
    Ficha getFicha();
    /**
     * Realiza la jugada del jugador en el juego.
     * Este método debe ser implementado en las clases que implementen esta interfaz según el tipo de jugador.
     */
    void Play();
    /**
     * Obtiene el tipo de ficha del jugador.
     * @return El tipo de ficha del jugador.
     */
    char getTipo();
    /**
     * Establece el tipo de piedra aleatoria para el jugador.
     * @param tipoPiedra El tipo de piedra aleatoria a establecer.
     * @return El tipo de piedra aleatoria establecida.
     */
    int setPiedraAleatoria(int tipoPiedra);
}
