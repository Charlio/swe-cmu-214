package hw04.view.menubar;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

import hw04.model.Player;
import hw04.settings.GameSettings;
import hw04.view.NotifiableUI;
import hw04.view.main.MainGUI;

/**
 * Is the scoreboard class of the game. Manages a score label for each player.
 * @author Timur Saglam
 */
public class Scoreboard implements NotifiableUI {
    private static final String FONT_TYPE = "Helvetica";
    private static final String TOOL_TIP = "Settings for player ";
    private final JLabel[] scoreLabels;
    private final JLabel stackSizeLabel;
    private final List<JLabel> allLabels;
    private final List<ActionListener> settingsListeners;
    private final GameSettings settings;

    /**
     * Standard constructor. Creates score board.
     * @param settings are the {@link GameSettings}.
     * @param mainUI is the main user interface.
     */
    public Scoreboard(GameSettings settings, MainGUI mainUI) { // TODO (MEDIUM) link with players?
        this.settings = settings;
        scoreLabels = new JLabel[GameSettings.MAXIMAL_PLAYERS];
        settingsListeners = new ArrayList<>();
        for (int i = 0; i < scoreLabels.length; i++) {
            scoreLabels[i] = new JLabel();
            scoreLabels[i].setForeground(settings.getPlayerColor(i).textColor());
            MenuSettingsListener listener = new MenuSettingsListener(i, settings, mainUI);
            settingsListeners.add(listener);
            scoreLabels[i].addMouseListener(listener);
        }
        stackSizeLabel = new JLabel();
        allLabels = new ArrayList<>(Arrays.asList(scoreLabels));
        allLabels.add(stackSizeLabel);
        for (JLabel label : allLabels) {
            label.setFont(new Font(FONT_TYPE, Font.BOLD, 12));
        }
    }

    /**
     * Disables all the scoreboard labels.
     */
    public void disable() {
        allLabels.forEach(it -> it.setVisible(false));
        stackSizeLabel.setVisible(false);
    }

    /**
     * Enables all the scoreboard labels.
     */
    public void enable() {
        allLabels.forEach(it -> it.setVisible(true));
    }

    /**
     * Grants access to the labels themselves.
     * @return the array of labels.
     */
    public List<JLabel> getLabels() {
        return allLabels;
    }

    /**
     * Only shows the specified amount of labels.
     * @param playerCount is the amount of players to show labels for.
     */
    public void rebuild(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            scoreLabels[i].setVisible(true);
        }
        stackSizeLabel.setVisible(true);
    }

    /**
     * Updates a specific player label of the scoreboard.
     * @param player is the player whose scoreboard should be updated.
     */
    public void update(Player player) {
        String playerName = player.getName();
        String text = "[" + playerName + ": " + player.getScore() + " points, " + player.getFreeMeeples() + " meeples]    ";
        scoreLabels[player.getNumber()].setText(text);
        scoreLabels[player.getNumber()].setToolTipText(TOOL_TIP + player.getName());
    }

    /**
     * Updates the stack size label.
     * @param stackSize is the updated size of the stack.
     */
    public void updateStackSize(int stackSize) {
        stackSizeLabel.setText("   [Stack Size: " + stackSize + "]");
    }

    /**
     * Grants access to a specific mouse listener of one players settings.
     * @param playerNumber specifies the player.
     * @return the correlating mouse listener.
     */
    public ActionListener getSettingsListener(int playerNumber) {
        return settingsListeners.get(playerNumber);
    }

    @Override
    public void notifyChange() {
        for (int i = 0; i < scoreLabels.length; i++) {
            scoreLabels[i].setForeground(settings.getPlayerColor(i).textColor()); // replace only color and player name:
            scoreLabels[i].setText(scoreLabels[i].getText().replaceFirst("\\[.*?:", "[" + settings.getPlayerName(i) + ":"));
            scoreLabels[i].setToolTipText(TOOL_TIP + settings.getPlayerName(i));
        }
    }
}