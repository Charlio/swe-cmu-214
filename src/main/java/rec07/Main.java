package rec07;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import rec07.core.GameChangeListener;
import rec07.core.TicTacToe;
import rec07.core.TicTacToeImpl;
import rec07.gui.GamePanel;
import rec07.gui.TicClient;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGameBoard();
        });
    }

    private static void createAndShowGameBoard() {
        // TODO: Start implementing your GUI here.

        // Create a game core and do any necessary setup.

        // Create the game UI and setup. You will need to write
        // your own GUI classes under the "gui" package.

    	JFrame frame = new JFrame("Tic Tac Toe");
    	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel(new TicTacToeImpl());

        frame.add(gamePanel);
    	
    	//display the JFrame
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    	
    }

}
