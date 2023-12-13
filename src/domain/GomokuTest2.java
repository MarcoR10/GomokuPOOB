package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

public class GomokuTest2 {

    @Test
    public  void pruebaCasillas() {
        System.out.println("Pruebas para la clase Casillas:");

        // Crear una instancia de Casillas
        Casillas casilla = new Casillas(1, 2);

        // Obtener y verificar las coordenadas
        int x = casilla.getX();
        int y = casilla.getY();
        System.out.println("Coordenadas: (" + x + ", " + y + ")"); // Debería imprimir (1, 2)

        // Establecer y verificar la ficha
        casilla.setFicha('X');
        char ficha = casilla.getFicha();
        System.out.println("Ficha: " + ficha); // Debería imprimir 'X'

        // Verificar el tipo
        char type = casilla.getType();
        System.out.println("Tipo: " + type); // Debería imprimir 'N'

        System.out.println("Pruebas para Casillas completadas.\n");
    }

    @Test
    public  void pruebaMine() {
        System.out.println("Pruebas para la clase Mine:");

        // Crear una instancia de Mine
        Mine mine = new Mine(3, 4);

        // Verificar el tipo
        char type = mine.getType();
        System.out.println("Tipo: " + type); // Debería imprimir 'M'

        // Crear un tablero simulado para la prueba
        Casillas[][] tablero = crearTableroPrueba();

        // Simular la explosión de la mina
        mine.explotar(null, tablero);

        System.out.println("Pruebas para Mine completadas.\n");
    }

    @Test
    private  void pruebaTeleport() {
        System.out.println("Pruebas para la clase Teleport:");

        // Crear una instancia de Teleport
        Teleport teleport = new Teleport(5, 6);

        // Crear un tablero simulado para la prueba
        int filas = 8;
        int columnas = 8;
        Tablero tablero = new Tablero(filas, columnas, false, false);

        // Simular el teletransporte de un jugador
        teleport.teletransportar(null, 'X', tablero);

        System.out.println("Pruebas para Teleport completadas.\n");
    }

    @Test
    public  Casillas[][] crearTableroPrueba() {
        int filas = 8;
        int columnas = 8;
        Casillas[][] tablero = new Casillas[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casillas(i, j);
            }
        }
        return tablero;
    }

    @Test
    public  void testVerificacionGanadorHorizontal() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false);
        gomoku.playgame(0, 0);
        gomoku.playgame(1, 0);
        gomoku.playgame(0, 1);
        gomoku.playgame(2, 2);
        gomoku.playgame(0, 2);
        gomoku.playgame(12, 11);
        gomoku.playgame(0, 3);
        gomoku.playgame(12, 12);
        gomoku.playgame(0, 4);
        if (gomoku.Verificacion(0, 4, 'O')) { // Cambiado a 'X' en lugar de 'O'
            System.out.println("Prueba de verificación ganador horizontal pasó.");
        } else {
            System.out.println("Prueba de verificación ganador horizontal falló.");
        }
    }

    @Test
    public  void testVerificacionGanadorVertical() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false);
        gomoku.playgame(0, 0);
        gomoku.playgame(0, 1);
        gomoku.playgame(1, 0);
        gomoku.playgame(1, 1);
        gomoku.playgame(2, 0);
        gomoku.playgame(2, 1);
        gomoku.playgame(3, 0);
        gomoku.playgame(3, 1);
        gomoku.playgame(4, 0);
        if (gomoku.Verificacion(4, 0, 'O')) { // Cambiado a 'O' en lugar de '0'
            System.out.println("Prueba de verificación ganador vertical pasó.");
        } else {
            System.out.println("Prueba de verificación ganador vertical falló.");
        }
    }

    @Test
    public  void testVerificacionGanadorDiagonal() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false);
        gomoku.playgame(0, 0);
        gomoku.playgame(0, 1);
        gomoku.playgame(1, 1);
        gomoku.playgame(2, 1);
        gomoku.playgame(2, 2);
        gomoku.playgame(5, 1);
        gomoku.playgame(3, 3);
        gomoku.playgame(3, 1);
        gomoku.playgame(4, 4);
        if (gomoku.Verificacion(4, 4, 'O')) { // Cambiado a 'O' en lugar de '0'
            System.out.println("Prueba de verificación ganador diagonal pasó.");
        } else {
            System.out.println("Prueba de verificación ganador diagonal falló.");
        }
    }

    @Test
    public  void testColocarFicha() {
        Tablero tablero = new Tablero(5, 5, false, false);
        tablero.colocarFicha(2, 2, 'X');
        if (tablero.getCasilla(2, 2).getFicha() == 'X') {
            System.out.println("Prueba de colocar ficha pasó.");
        } else {
            System.out.println("Prueba de colocar ficha falló.");
        }
    }

    @Test
    public  void testGuardarArchivo() {
        try {
            // Crear una instancia de Gomoku
            Gomoku gomoku = new Gomoku('T', 'T', false, false);

            // Guardar el tablero actual en un archivo
            File archivoGuardado = new File("test_tablero.txt");
            gomoku.guardarArchivo(archivoGuardado);
            System.out.println("Archivo guardado exitosamente.");

            // Verificar si el archivo se creó
            if (archivoGuardado.exists()) {
                System.out.println("El archivo existe: " + archivoGuardado.getAbsolutePath());
            } else {
                System.out.println("Error: El archivo no se creó correctamente.");
            }

        } catch (GomokuException e) {
            System.out.println("Error durante la prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testVerificacionGanadorHorizontal2() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false);
        assertFalse(gomoku.Verificacion(0, 0, 'X')); // No debe haber victoria al principio
        // Simular una línea horizontal de fichas 'X'
        for (int i = 0; i < 5; i++) {
            gomoku.playgame(i, 0);
        }
        assertFalse(gomoku.Verificacion(0, 0, 'X')); // Verificar victoria horizontal
    }

    @Test
    public void testVerificacionGanadorVertical2() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false);
        assertFalse(gomoku.Verificacion(0, 0, 'O')); // No debe haber victoria al principio
        // Simular una línea vertical de fichas 'O'
        for (int i = 0; i < 5; i++) {
            gomoku.playgame(0, i);
        }
        assertFalse(gomoku.Verificacion(0, 0, 'O')); // Verificar victoria vertical
    }
    @Test
    public void testVerificacionGanadorDiagonal2() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false);
        assertFalse(gomoku.Verificacion(0, 0, 'X')); // No debe haber victoria al principio
        // Simular una línea diagonal de fichas 'X'
        for (int i = 0; i < 5; i++) {
            gomoku.playgame(i, i);
        }
        assertFalse(gomoku.Verificacion(0, 0, 'X')); // Verificar victoria diagonal
    }
}