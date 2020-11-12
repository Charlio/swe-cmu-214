package hw04;

import hw04.core.Game;
import hw04.core.Player;
import hw04.core.utils.Configuration;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test suite to accept core Carcassonne game implementation without GUI
 */
public class AcceptanceNoGUIGameTest {
    /*
    private Game createGame(String tileFileName, String[] playerNames, String configFileName) {
        String resDir = "src/test/resources/hw04/";
        String tileFilePath = resDir + tileFileName;
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) players.add(new Player(playerName));
        String configFilePath = resDir + configFileName;
        Configuration config = new Configuration(configFilePath);
        return new Game(tileFilePath, players, config);
    }

    private boolean isGameStateValid(Game game, int[] playerScores, String curPlayerName, int[] meeplesDeployed,
                                     int numOfTilesOnBoard, int numOfFeaturesOnBoard) {
        // TODO checkout Board: startTile type and location
        // TODO checkout each Player: score, meeples
        // TODO checkout Tile stack: size
        return false;
    }

    @Test
    public void testSimpleGameEndWithFiveTurns() {
        Game game = createGame("simple-game-1.json", new String[]{"Charlio", "Alice"}, "default.config");
        // Charlio's 1st turn - Turn 1
        assertFalse(game.isOver());
        String curPlayerCharlio = game.startTurn();
        assertTrue(isGameStateValid(game, curPlayerCharlio));
        try {
            Draw draw = game.drawTile();
        } catch (GameOverException e) {
            fail();
        }
        game.placeTile(draw.getValidTile(), new Location(0, 1));
        game.placeMeeple(FeatureType.ROAD);
        game.scoreFeature();
        assertTrue(isGameStateValid(game, curPlayerCharlio));
        game.endTurn();
        // Alice's 1st turn - Turn 2
        assertFalse(game.isOver());
        String curPlayerAlice = game.startTurn();
        assertTrue(isGameStateValid(game, curPlayerAlice));
        try {
            Draw draw = game.drawCard();
        } catch (GameOverException e) {
            fail();
        }
        game.placeTile(draw.getTileToPlace(), new Location(1, 0));
        game.skipPlacingMeeple();
        game.scoreFeature();
        assertTrue(isGameStateValid(game, curPlayerAlice));
        game.endTurn();
        // Charlio's 2nd turn - Turn 3
        // Alice's 2nd turn - Turn 4
        // Charlio's 3rd turn - Turn 5
        assertTrue(game.isOver());
        game.scoreFinal();
        assertTrue(isGameStateValid(game, curPlayerCharlio));
    }

    @Test
    public void testSimpleGameEndWithTenTurns() {
        Game game = createGame("simple-game-2.json", new String[]{"Dipper", "Leelee"}, "default.config");
    }
    */
}
