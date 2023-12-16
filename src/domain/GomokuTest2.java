package domain;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

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
}