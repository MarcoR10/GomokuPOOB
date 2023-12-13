package domain;

public class Maquina extends Jugadores{
    public Maquina(char ficha){
        super(ficha);
    }
    public char getFicha(){
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
        // Verificar si la casilla generada es una casilla especial y realizar la acción correspondiente
        Casillas casillaElegida = tablero.getCasilla(x, y);
        if (casillaElegida instanceof Mine) {
            // Realizar la acción de explotar la mina
            ((Mine) casillaElegida).explotar(this,tablero.getCasillas());
        } else if (casillaElegida instanceof Teleport) {
            // Realizar la acción de teletransportar
            ((Teleport) casillaElegida).teletransportar(this,this.getFicha(), tablero);
        } else if (casillaElegida instanceof Golden) {
            // Realizar la acción de obtener una piedra aleatoria
            ((Golden) casillaElegida).darPiedraAleatoria(this);
        } else {
            // Realizar el movimiento normal si no es una casilla especial
            gomoku.playgame(x, y);
        }
    }
    // Generar un movimiento aleatorio dentro de los límites del tablero
    private int generarMovimientoAleatorio(int limite) {
        return (int) (Math.random() * limite);
    }
}
