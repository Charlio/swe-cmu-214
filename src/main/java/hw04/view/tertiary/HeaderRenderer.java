package hw04.view.tertiary;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Custom renderer that customizes the header of the game statistics table.
 * @author Timur Saglam
 */
public class HeaderRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 7334741847662350544L; // generated UID

    /**
     * Creates the header renderer.
     */
    public HeaderRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER); // Center text in cells.
    }

    /**
     * @see DefaultTableCellRenderer#getTableCellRendererComponent(JTable, Object,
     * boolean, boolean, int, int)
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setBackground(GameStatisticsGUI.HEADER_COLOR);
        Font font = component.getFont();
        if (column == GameStatisticsGUI.SCORE_COLUMN) {
            font = font.deriveFont(Font.BOLD);
        }
        component.setFont(font.deriveFont((float) font.getSize() + 1));
        return component;
    }
}