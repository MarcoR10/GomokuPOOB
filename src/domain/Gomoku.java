package domain;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Clase Gomoku que representa el juego Gomoku (también conocido como "Cinco en línea").
 * Esta clase gestiona la lógica del juego, los jugadores, el tablero y las acciones del juego.
 */
public class Gomoku implements Serializable {
    private Tablero tablero;
    private Jugador j1, j2;
    private int NumCasill;
    private boolean JuegoFinalizado, turnoJugador;

    /**
     * Constructor de la clase Gomoku.
     * @param Tjugardor1 Tipo de jugador 1 ('M' para máquina, cualquier otro carácter para humano)
     * @param Tjugardor2 Tipo de jugador 2 ('M' para máquina, cualquier otro carácter para humano)
     * @param FichaE Indica si se usan fichas especiales
     * @param CasillaE Indica si se usan casillas especiales
     */
    public Gomoku(char Tjugardor1, char Tjugardor2, boolean FichaE, boolean CasillaE,int NumCasill) {
        tablero = new Tablero(NumCasill, NumCasill, FichaE, CasillaE);
        j1 = crearJugador(Tjugardor1, 'X');
        j2 = crearJugador(Tjugardor2, 'O');
    }

    private Jugador crearJugador(char tipoJugador, char ficha) {
        if (tipoJugador == 'M') {
            return new Maquina(new Normal(ficha),tipoJugador);
        } else {
            return new Humano(new Normal(ficha),tipoJugador);
        }
    }

    /**
     * Inicia el juego de Gomoku.
     * Controla el flujo del juego alternando entre turnos de jugadores hasta que se complete el juego.
     */
    public void start() {
        turnoJugador = true;
        JuegoFinalizado = false;
        while (!JuegoFinalizado) {
            if (turnoJugador) {
                if (j1 instanceof Maquina) {
                    ((Maquina) j1).Play(tablero, this);
                } else {
                    int x = obtenerCoordenadaX();
                    int y = obtenerCoordenadaY();
                    playGame(x, y);
                }
            } else {
                // Turno del jugador 2 (Humano o Máquina)
                if (j2 instanceof Maquina) {
                    ((Maquina) j2).Play(tablero, this);
                } else {
                    int x = obtenerCoordenadaX();
                    int y = obtenerCoordenadaY();
                    playGame(x, y);
                }
            }
        }
    }

    /**
     * Lógica para jugar una partida.
     * @param x Coordenada X seleccionada por el jugador
     * @param y Coordenada Y seleccionada por el jugador
     */
    public void playGame(int x, int y) {
        Jugador jugadorActual = turnoJugador ? j1:j2  ;
        Casillas casillaActual = tablero.getCasilla(x, y);
        char fichaActual = casillaActual.getFicha();
        Ficha fichaJugador = jugadorActual.getFicha();
        char fichajugadoractual = fichaJugador.getJugador();
        // Verificar si la ficha a colocar es de tipo especial y realizar acciones específicas
        // Verificar si la casilla es especial
        if (casillaActual instanceof Mine) {
            ((Mine) casillaActual).explotar(jugadorActual, tablero.getCasillas());
        } else if (casillaActual instanceof Teleport) {
            ((Teleport) casillaActual).teletransportar(jugadorActual, fichajugadoractual, tablero);
        } else if (casillaActual instanceof Golden) {
            ((Golden) casillaActual).darPiedraAleatoria(jugadorActual);
        }if (fichaJugador instanceof Pesada) {
            ((Pesada) fichaJugador).colocarEnTablero(tablero, x, y, fichajugadoractual);
        } else if (fichaJugador instanceof Temporal) {
            ((Temporal) fichaJugador).colocarEnTablero(tablero, x, y, fichajugadoractual);
        } else {
            // Si no es una casilla especial, colocar la ficha normalmente
            if (fichaActual != ' ') {
                System.out.println("La casilla ya está ocupada. Elija otra posición.");
                return;
            }
            tablero.colocarFicha(x, y, fichajugadoractual);
            tablero.imprimirTablero();
            if (Verificacion(x, y, fichajugadoractual)) {
                JuegoFinalizado = true;
                turnoJugador = !turnoJugador;
                System.out.println("¡" + (turnoJugador ? "Jugador 1" : "Jugador 2") + " ha ganado!");
                return;
            }
        }
        turnoJugador = !turnoJugador;
    }

    public void JugarMaquina(int x, int y){
        if (j1 instanceof Maquina) {
            ((Maquina) j1).Play(tablero, this,x,y);
        }
        if (!JuegoFinalizado && j2 instanceof Maquina) {
            ((Maquina) j2).Play(tablero, this,x,y);
        }
    }
    /**
     * Verifica si hay cinco o más fichas del mismo tipo en línea desde la posición (x, y) con una ficha específica.
     * Comprueba horizontalmente, verticalmente y en diagonales.
     * @param x Coordenada X en el tablero
     * @param y Coordenada Y en el tablero
     * @param ficha Tipo de ficha a verificar ('X' o 'O')
     * @return true si hay cinco o más fichas del mismo tipo en línea, false de lo contrario
     */
    public boolean Verificacion(int x, int y, char ficha) {
        // Verificar horizontalmente
        if (verificarLinea(x, y, 0, 1, ficha) || verificarLinea(x, y, 0, -1, ficha)) {
            return true;
        }
        // Verificar verticalmente
        if (verificarLinea(x, y, 1, 0, ficha) || verificarLinea(x, y, -1, 0, ficha)) {
            return true;
        }
        // Verificar diagonales
        if (verificarLinea(x, y, 1, 1, ficha) || verificarLinea(x, y, -1, -1, ficha) || verificarLinea(x, y, 1, -1, ficha) || verificarLinea(x, y, -1, 1, ficha)) {
            return true;
        }
        return false;
    }

    /**
     * Verifica si hay cinco o más fichas del mismo tipo en línea desde la posición (x, y) con una dirección específica.
     * @param x Coordenada X en el tablero
     * @param y Coordenada Y en el tablero
     * @param dirX Dirección X para verificar (0, 1 o -1)
     * @param dirY Dirección Y para verificar (0, 1 o -1)
     * @param ficha Tipo de ficha a verificar ('X' o 'O')
     * @return true si hay cinco o más fichas del mismo tipo en línea, false de lo contrario
     */
    private boolean verificarLinea(int x, int y, int dirX, int dirY, char ficha) {
        int count = 1; // Inicializar contador a 1 para incluir la ficha recién colocada
        int i = x + dirX;
        int j = y + dirY;
        // Verificar hacia adelante en la dirección dada
        while (i >= 0 && i < tablero.getLongitud() && j >= 0 && j < tablero.getAltura() && tablero.getCasilla(i, j).getFicha() == ficha) {
            count++;
            i += dirX;
            j += dirY;
        }
        // Reiniciar las posiciones para verificar en la dirección opuesta
        i = x - dirX;
        j = y - dirY;
        // Verificar hacia atrás en la dirección opuesta
        while (i >= 0 && i < tablero.getLongitud() && j >= 0 && j < tablero.getAltura() && tablero.getCasilla(i, j).getFicha() == ficha) {
            count++;
            i -= dirX;
            j -= dirY;
        }
        // Si hay 5 o más fichas del mismo tipo en línea, el jugador gana
        return count >= 5;
    }

    public char FichaPlayer(){
        Jugador jugadorActual = turnoJugador ? j1 : j2;
        Ficha fichaJugador = jugadorActual.getFicha();
        return fichaJugador.getJugador();
    }

    public char PlayerTipo(){
        Jugador jugadorActual = turnoJugador ? j1 : j2;
        return jugadorActual.getTipo();
    }

    public boolean getJuegoFinalizado() {
        return JuegoFinalizado;
    }

    /**
     * Método para cargar un archivo del juego.
     * @param archivo Archivo a cargar
     * @throws IOException Excepción de E/S
     * @throws ClassNotFoundException Excepción de clase no encontrada
     */
    public  void cargarArchivo(File archivo) throws IOException, ClassNotFoundException {
        Tablero loadedData = null;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            loadedData = (Tablero) entrada.readObject();
        }
        tablero = loadedData;
    }

    /**
     * Método para guardar el estado actual del juego en un archivo.
     * @param archivo Archivo donde se guardará el estado del juego
     * @throws GomokuException Excepción personalizada del juego Gomoku
     */
    public void guardarArchivo(File archivo)  throws GomokuException{
        try (ObjectOutputStream fuera = new ObjectOutputStream(new FileOutputStream(archivo))) {
            fuera.writeObject(tablero);
            fuera.close();
            JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        Gomoku game = new Gomoku('M', 'T',false,false,15);
        game.start();
    }
    // Métodos para obtener las coordenadas del jugador desde la consola (Ejemplo básico)
    private static int obtenerCoordenadaX() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la coordenada X: ");
        return scanner.nextInt();
    }
    private static int obtenerCoordenadaY() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la coordenada Y: ");
        return scanner.nextInt();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------//
}





