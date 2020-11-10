package hw04.control.state;

import hw04.control.MainController;
import hw04.model.Meeple;
import hw04.model.Player;
import hw04.model.grid.CastleAndRoadPattern;
import hw04.model.grid.FieldsPattern;
import hw04.model.grid.GridDirection;
import hw04.model.grid.GridPattern;
import hw04.model.terrain.TerrainType;
import hw04.model.tile.Tile;
import hw04.settings.GameSettings;
import hw04.view.main.MainGUI;
import hw04.view.secondary.PlacementGUI;
import hw04.view.secondary.PreviewGUI;
import hw04.view.util.GameMessage;

/**
 * The specific state when a Meeple can be placed.
 * @author Timur Saglam
 */
public class StateManning extends AbstractControllerState {
    private boolean[] noMeeplesNotification;

    /**
     * Constructor of the state.
     * @param controller sets the controller.
     * @param mainGUI sets the MainGUI
     * @param previewGUI sets the PreviewGUI
     * @param placementGUI sets the PlacementGUI
     */
    public StateManning(MainController controller, MainGUI mainGUI, PreviewGUI previewGUI, PlacementGUI placementGUI) {
        super(controller, mainGUI, previewGUI, placementGUI);
        noMeeplesNotification = new boolean[GameSettings.MAXIMAL_PLAYERS]; // stores whether a player was already notified about a lack of meeples
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#abortGame()
     */
    @Override
    public void abortGame() {
        changeState(StateGameOver.class);
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#isPlaceable()
     */
    @Override
    public boolean isPlaceable(GridDirection position) {
        Tile tile = previewGUI.getSelectedTile();
        TerrainType terrain = tile.getTerrain(position);
        boolean placeable = false;
        if (terrain == TerrainType.OTHER) {
            placeable = false; // you can never place on terrain other
        } else if (terrain == TerrainType.MONASTERY) {
            placeable = true; // you can always place on a monastery
        } else {
            GridPattern pattern;
            if (terrain == TerrainType.FIELDS) {
                pattern = new FieldsPattern(tile.getGridSpot(), position, grid);
            } else { // castle or road:
                pattern = new CastleAndRoadPattern(tile.getGridSpot(), position, terrain, grid);
            }
            if (pattern.isNotOccupied() || pattern.isOccupiedBy(round.getActivePlayer())) {
                placeable = true; // can place meeple
            }
            pattern.removeTileTags();
        }
        return placeable;
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#newRound()
     */
    @Override
    public void newRound(int playerCount) {
        GameMessage.showWarning("Abort the current game before starting a new one.");
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#placeMeeple()
     */
    @Override
    public void placeMeeple(GridDirection position) {
        Tile tile = previewGUI.getSelectedTile();
        Player player = round.getActivePlayer();
        if (player.hasFreeMeeples() && isPlaceable(position)) {
            mainGUI.resetMeeplePreview(tile);
            tile.placeMeeple(player, position);
            mainGUI.setMeeple(tile, position, player);
            updateScores();
            processGridPatterns();
            startNextTurn();
        } else {
            GameMessage.showWarning("You can't place meeple directly on an occupied Castle or Road!");
        }
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#placeTile()
     */
    @Override
    public void placeTile(int x, int y) {
        // do nothing.
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#skip()
     */
    @Override
    public void skip() {
        mainGUI.resetMeeplePreview(previewGUI.getSelectedTile());
        processGridPatterns();
        startNextTurn();
    }

    // gives the players the points they earned.
    private void processGridPatterns() {
        Tile tile = previewGUI.getSelectedTile();
        for (GridPattern pattern : grid.getModifiedPatterns(tile.getGridSpot())) {
            if (pattern.isComplete()) {
                for (Meeple meeple : pattern.getMeepleList()) {
                    mainGUI.removeMeeple(meeple);
                }
                pattern.disburse();
                updateScores();
            }
        }
    }

    // starts the next turn and changes the state to state placing.
    private void startNextTurn() {
        if (round.isOver()) {
            changeState(StateGameOver.class);
        } else {
            round.nextTurn();
            mainGUI.setCurrentPlayer(round.getActivePlayer());
            changeState(StatePlacing.class);
        }
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#entry()
     */
    @Override
    protected void entry() {
        Player player = round.getActivePlayer();
        if (player.hasFreeMeeples()) {
            noMeeplesNotification[player.getNumber()] = false; // resets out of meeple message!
            mainGUI.setMeeplePreview(previewGUI.getSelectedTile(), player);
            placementGUI.setTile(previewGUI.getSelectedTile(), player);
        } else {
            if (!noMeeplesNotification[player.getNumber()]) { // Only warn player once until he regains meeples
                GameMessage.showMessage("You have no Meeples left. Regain Meeples by completing patterns to place Meepeles again.");
                noMeeplesNotification[player.getNumber()] = true;
            }
            processGridPatterns();
            startNextTurn();
        }
    }

    /**
     * @see carcassonne.control.state.AbstractControllerState#exit()
     */
    @Override
    protected void exit() {
        placementGUI.setVisible(false);
    }
}
