package hw02.guicalc;

import hw02.operator.BinaryOperator;
import hw02.operator.UnaryOperator;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * GuiCalculator - creates and runs a new CalculatorController to visualize a desktop calculator.
 */
public class GuiCalculator {
    //CHECKSTYLE:OFF
    private final Set<UnaryOperator> unaryOperators;
    private final Set<BinaryOperator> binaryOperators;

    /**
     * Initialize valid operators in GUI Calculator.
     *
     * @param unaryOperators the unary operators that the calculator supports
     * @param binaryOperators the binary operators that the calculator supports
     */
    public GuiCalculator(Set<UnaryOperator> unaryOperators, Set<BinaryOperator> binaryOperators) {
        this.unaryOperators = new LinkedHashSet<>(Objects.requireNonNull(unaryOperators));
        this.binaryOperators = new LinkedHashSet<>(Objects.requireNonNull(binaryOperators));
        SwingUtilities.invokeLater(this::createAndShowSetupScreen);
    }

    // launch the calculator
    private void createAndShowSetupScreen() {
        CalculatorController controller = new CalculatorController(unaryOperators, binaryOperators);
        controller.launch();
    }

}
