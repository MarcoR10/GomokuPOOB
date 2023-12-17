package domain;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

public class GomokuTest2 {
    Gomoku game;
    @Test
    public void testConstructorWithHumanPlayers() {
        game = new Gomoku('H', 'H', false, false, 15, 'N');
        assertNotNull(game);
    }
    @Test
    public void testConstructorWithMachineAndHumanPlayers() {
        game = new Gomoku('H', 'M', false, false, 15, 'N');
        assertNotNull(game);
    }
    @Test
    public void testPlayGameWithValidCoordinatesShouldFinishGameIfWinner() {
        game = new Gomoku('H', 'H', false, false, 15, 'N');
        game.playGame(5, 5);
        game.playGame(6, 5);
        game.playGame(5, 7);
        game.playGame(4, 2);
        game.playGame(5, 4);
        game.playGame(9, 5);
        game.playGame(5, 3);
        game.playGame(4, 5);
        game.playGame(5, 6);
        game.playGame(0, 5);
        assertTrue(game.getJuegoFinalizado());
    }

    @Test
    public void testPlayGameWithOccupiedCoordinatesShouldNotFinishGame() {
        game = new Gomoku('H', 'H', false, false, 15, 'N');
        game.playGame(5, 5);
        game.playGame(5, 4);
        assertFalse(game.getJuegoFinalizado());
    }


    @Test
    public  void pruebaCasillas() {
        System.out.println("Pruebas para la clase Casillas:");
        Casillas casilla = new Casillas(1, 2);
        int x = casilla.getX();
        int y = casilla.getY();
        System.out.println("Coordenadas: (" + x + ", " + y + ")");
        // Establecer y verificar la ficha
        casilla.setFicha('X');
        char ficha = casilla.getFicha();
        System.out.println("Ficha: " + ficha);
        // Verificar el tipo
        char type = casilla.getType();
        System.out.println("Tipo: " + type);
        System.out.println("Pruebas para Casillas completadas.\n");
    }

    @Test
    public void testGuardarYRecuperarArchivo() {
        Gomoku gomoku = new Gomoku('T', 'T', false, true, 15, 'N');
        File archivoPrueba = new File("archivoPrueba.dat");

        try {
            gomoku.guardarArchivo(archivoPrueba);
            Gomoku gomokuCargado = new Gomoku('T', 'T', false, true, 15, 'N');
            gomokuCargado.cargarArchivo(archivoPrueba);
            assertEquals(gomoku.getNumCasilla(), gomokuCargado.getNumCasilla());
            assertEquals(gomoku.getJuegoFinalizado(), gomokuCargado.getJuegoFinalizado());
            archivoPrueba.delete();

        } catch (IOException | ClassNotFoundException e) {
            fail("Excepción inesperada: " + e.getMessage());
        } catch (GomokuException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testCrearHumano() {
        Fichas ficha = new Fichas('X');
        Humano humano = new Humano(ficha, 'H');
        assertEquals('X', humano.getFicha().getJugador());
        assertEquals('H', humano.getTipo());
    }

    @Test
    public void testCrearFichas() {
        Fichas ficha = new Fichas('O');
        assertEquals('N', ficha.TypeFicha());
        assertEquals('O', ficha.getJugador());
    }

    @Test
    public void testSetJugador() {
        Fichas ficha = new Fichas('X');
        ficha.setJugador('O');
        assertEquals('O', ficha.getJugador());
    }

    @Test
    public  void testVerificacionGanadorHorizontal() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false,15,'N');
        gomoku.playGame(0, 0);
        gomoku.playGame(1, 0);
        gomoku.playGame(0, 1);
        gomoku.playGame(2, 2);
        gomoku.playGame(0, 2);
        gomoku.playGame(12, 11);
        gomoku.playGame(0, 3);
        gomoku.playGame(12, 12);
        gomoku.playGame(0, 4);
        if (gomoku.Verificacion(0, 4, 'O')) {
            System.out.println("Prueba de verificación ganador horizontal pasó.");
        } else {
            System.out.println("Prueba de verificación ganador horizontal falló.");
        }
    }

    @Test
    public  void testVerificacionGanadorVertical() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false,15,'N');
        gomoku.playGame(0, 0);
        gomoku.playGame(0, 1);
        gomoku.playGame(1, 0);
        gomoku.playGame(1, 1);
        gomoku.playGame(2, 0);
        gomoku.playGame(2, 1);
        gomoku.playGame(3, 0);
        gomoku.playGame(3, 1);
        gomoku.playGame(4, 0);
        if (gomoku.Verificacion(4, 0, 'O')) {
            System.out.println("Prueba de verificación ganador vertical pasó.");
        } else {
            System.out.println("Prueba de verificación ganador vertical falló.");
        }
    }

    @Test
    public  void testVerificacionGanadorDiagonal() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false,15,'N');
        gomoku.playGame(0, 0);
        gomoku.playGame(0, 1);
        gomoku.playGame(1, 1);
        gomoku.playGame(2, 1);
        gomoku.playGame(2, 2);
        gomoku.playGame(5, 1);
        gomoku.playGame(3, 3);
        gomoku.playGame(3, 1);
        gomoku.playGame(4, 4);
        if (gomoku.Verificacion(4, 4, 'O')) {
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
            Gomoku gomoku = new Gomoku('T', 'T', false, false,15,'N');
            File archivoGuardado = new File("test_tablero.txt");
            gomoku.guardarArchivo(archivoGuardado);
            System.out.println("Archivo guardado exitosamente.");
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
        Gomoku gomoku = new Gomoku('H', 'H', false, false,15,'N');
        assertFalse(gomoku.Verificacion(0, 0, 'X'));
        for (int i = 0; i < 5; i++) {
            gomoku.playGame(i, 0);
        }
        assertFalse(gomoku.Verificacion(0, 0, 'X'));
    }

    @Test
    public void testVerificacionGanadorVertical2() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false,15,'N');
        assertFalse(gomoku.Verificacion(0, 0, 'O'));
        for (int i = 0; i < 5; i++) {
            gomoku.playGame(0, i);
        }
        assertFalse(gomoku.Verificacion(0, 0, 'O'));
    }
    @Test
    public void testVerificacionGanadorDiagonal2() {
        Gomoku gomoku = new Gomoku('H', 'H', false, false,15,'N');
        assertFalse(gomoku.Verificacion(0, 0, 'X'));
        for (int i = 0; i < 5; i++) {
            gomoku.playGame(i, i);
        }
        assertFalse(gomoku.Verificacion(0, 0, 'X'));
    }

    @Test
    public void testColocarEnTablero_CasillasVacias() {
        Tablero tablero = new Tablero(5, 5, false, false);
        Pesada pesada = new Pesada('X');
        pesada.colocarEnTablero(tablero, 2, 2, 'X');
        assertEquals('X', tablero.getCasilla(2, 2).getFicha());
        assertEquals('X', tablero.getCasilla(3, 2).getFicha());
    }

    @Test
    public void testColocarEnTablero_CasillaOcupada() {
        Tablero tablero = new Tablero(5, 5, false, false);
        tablero.colocarFicha(2, 2, 'X');
        tablero.colocarFicha(3, 2, 'O');
        Pesada pesada = new Pesada('X');
        pesada.colocarEnTablero(tablero, 2, 2, 'X');
        assertEquals('X', tablero.getCasilla(2, 2).getFicha());
        assertEquals('O', tablero.getCasilla(3, 2).getFicha());
    }

    @Test
    public void testColocarEnTablero_LimiteTableroExcedido() {
        Tablero tablero = new Tablero(5, 5, false, false);
        Pesada pesada = new Pesada('X');
        pesada.colocarEnTablero(tablero, 4, 4, 'X');
        assertEquals(' ', tablero.getCasilla(4, 4).getFicha());
        assertEquals(' ', tablero.getCasilla(4, 3).getFicha());
    }
    @Test
    public void testColocarEnTablero() {
        Tablero tablero = new Tablero(5, 5, false, false);
        Temporal temporal = new Temporal('X');
        temporal.colocarEnTablero(tablero, 2, 2, 'X');
        assertEquals('X', tablero.getCasilla(2, 2).getFicha());
    }
    @Test
    public void testReducirTurno() {
        Temporal temporal = new Temporal('X');
        temporal.colocarEnTablero(new Tablero(5, 5, false, false), 2, 2, 'X');
        assertEquals(3, temporal.getTurnosRestantes());
        temporal.reducirTurno();
        assertEquals(2, temporal.getTurnosRestantes());
    }

    @Test
    public void testColocarFicha2() {
        Tablero tablero = new Tablero(5, 5, false, false);
        tablero.colocarFicha(2, 3, 'X');
        assertEquals('X', tablero.getCasilla(2, 3).getFicha());
    }

    @Test
    public void testReiniciarTablero() {
        Tablero tablero = new Tablero(5, 5, false, false); // Tablero de 5x5 sin características especiales
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(1, 1, 'O');
        tablero.colocarFicha(2, 2, 'X');
        tablero.reiniciarTablero();
        for (int i = 0; i < tablero.getLongitud(); i++) {
            for (int j = 0; j < tablero.getAltura(); j++) {
                assertEquals(' ', tablero.getCasilla(i, j).getFicha());
            }
        }
    }
    @Test
    public void testGoldenDarPiedraAleatoria() {
        Golden golden = new Golden(1, 1);
        Jugador jugador = new Humano(new Normal('X'),'H');
        golden.darPiedraAleatoria(jugador);
        int piedraAsignada = jugador.setPiedraAleatoria(2); // Método hipotético para obtener la piedra asignada
        assertTrue(piedraAsignada >= 0 && piedraAsignada <= 2); // Verificar si la piedra está en el rango esperado (suponiendo 3 tipos de piedras)
    }

    @Test
    public void testTeleportTeletransportar() {
        Teleport teleport = new Teleport(3, 3);
        Casillas[][] tablero = new Casillas[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = new Casillas(i, j);
            }
        }
        Jugador jugador = new Humano(new Normal('X'), 'H');
        teleport.teletransportar(jugador, 'X', new Tablero(5, 5, false, false)); // Cambiar el tablero por el existente
        char fichaNuevaPosicion = tablero[teleport.getX()][teleport.getY()].getFicha();
        //assertEquals('X', fichaNuevaPosicion);
    }
}