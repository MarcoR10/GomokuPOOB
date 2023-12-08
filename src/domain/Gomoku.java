package domain;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Gomoku {
    private Tablero tablero;
    private Jugador j1, j2;
    private boolean JuegoFinalizado, turnoJugador;

    public Gomoku(char Tjugardor1, char Tjugardor2,boolean FichaE,boolean CasillaE) {
        tablero = new Tablero(15, 15,FichaE,CasillaE);
        if (Tjugardor1 == 'M') {
            j1 = new Maquina('X');
        } else {
            j1 = new Humano('X');
        }
        if (Tjugardor2 == 'M') {
            j2 = new Maquina('O');
        } else {
            j2 = new Humano('O');
        }
    }

    public void start() {
        turnoJugador = true;
        JuegoFinalizado = false;
        while (!JuegoFinalizado) {
            if (turnoJugador) {
                // Turno del jugador 1 (Humano o Máquina)
                if (j1 instanceof Maquina) {
                    ((Maquina) j1).Play(tablero, this);
                } else {
                    int x = obtenerCoordenadaX();
                    int y = obtenerCoordenadaY();
                    playgame(x, y);
                }
            } else {
                // Turno del jugador 2 (Humano o Máquina)
                if (j2 instanceof Maquina) {
                    ((Maquina) j2).Play(tablero, this);
                } else {
                    int x = obtenerCoordenadaX();
                    int y = obtenerCoordenadaY();
                    playgame(x, y);
                }
            }
        }
    }

    public void playgame(int x, int y) {
        Jugador jugadorActual = turnoJugador ? j1 : j2;
        Casillas casillaActual = tablero.getCasilla(x, y);
        char fichaActual = casillaActual.getFicha();
        // Verificar si la casilla es especial
        if (casillaActual instanceof Mine) {
            ((Mine) casillaActual).explotar(jugadorActual, tablero.getCasillas());
            // Otras acciones si la casilla es una Mine
        } else if (casillaActual instanceof Teleport) {
            ((Teleport) casillaActual).teletransportar(jugadorActual, jugadorActual.getFicha(), tablero);
            // Otras acciones si la casilla es un Teleport
        } else if (casillaActual instanceof Golden) {
            ((Golden) casillaActual).darPiedraAleatoria(jugadorActual);
            // Otras acciones si la casilla es una Golden
        } else if (casillaActual instanceof Ficha) {
            Ficha fichaEspecial = (Ficha) casillaActual;
            char tipoFicha = fichaEspecial.TypeFicha();
            // Verificar si la casilla contiene una ficha especial como Pesada o Temporal
            if (tipoFicha == 'P') {
                // Hacer algo específico para ficha Pesada
                ((Pesada) fichaEspecial).colocarEnTablero(tablero, x, y, jugadorActual.getFicha());
            } else if (tipoFicha == 'T') {
                // Hacer algo específico para ficha Temporal
                // Por ejemplo, reducir el contador de turnos restantes de la ficha Temporal
                ((Temporal) fichaEspecial).reducirTurno();
            }
        } else {
            // Si no es una casilla especial, colocar la ficha normalmente
            if (fichaActual != ' ') {
                System.out.println("La casilla ya está ocupada. Elija otra posición.");
                return;
            }
            tablero.colocarFicha(x, y, jugadorActual.getFicha());
            tablero.imprimirTablero();
            if (Verificacion(x, y, jugadorActual.getFicha())) {
                JuegoFinalizado = true;
                System.out.println("¡" + (turnoJugador ? "Jugador 1" : "Jugador 2") + " ha ganado!");
                return;
            }
        }
        turnoJugador = !turnoJugador;
    }

    private boolean Verificacion(int x, int y, char ficha) {
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

    public  void cargarArchivo(File archivo) throws IOException, ClassNotFoundException {
        Tablero loadedData = null;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            loadedData = (Tablero) entrada.readObject();
        }
        tablero = loadedData;
    }
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
        Gomoku game = new Gomoku('T', 'T',false,false);
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





