package rec07;

import static rec07.core.TicTacToe.Player;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import rec07.core.TicTacToe;
import rec07.core.TicTacToeImpl;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToeImpl();
    }

    @Test
    public void testSingleMove() {
        game.startNewGame();
        assertNull(game.getSquare(0, 0));
        game.playMove(0, 0);
        assertEquals(Player.X, game.getSquare(0, 0));
    }

	// TODO: write more tests
}
