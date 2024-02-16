package org.example.Questions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private Tic_tac game;

    @BeforeEach
    public void setUp() {
        game = new Tic_tac(3); // Creating a 3x3 board for testing
    }

    @Test
    public void testPlaceMark() {
        assertTrue(game.placeMark(0, 0));
        assertEquals('X', game.getCurrentPlayerMark());
    }

    @Test
    public void testInvalidMove() {
        assertTrue(game.placeMark(0, 0));
        assertFalse(game.placeMark(0, 0)); // Cannot place mark in the same position
    }

    @Test
    public void testCheckForWin() {
        game.placeMark(0, 0);
        game.placeMark(1, 0);
        game.placeMark(0, 1);
        game.placeMark(1, 1);
        game.placeMark(0, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testCheckForDraw() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        game.placeMark(1, 1);
        game.placeMark(1, 0);
        game.placeMark(1, 2);
        game.placeMark(2, 1);
        game.placeMark(2, 0);
        game.placeMark(2, 2);
        assertTrue(game.isBoardFull());
        assertFalse(game.checkForWin());
    }

    @Test
    public void testGameContinues() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        game.placeMark(1, 1);
        game.placeMark(1, 0);
        game.placeMark(1, 2);
        game.placeMark(2, 1);
        game.placeMark(2, 0);
        assertFalse(game.checkForWin());
        assertFalse(game.isBoardFull());
    }
}
