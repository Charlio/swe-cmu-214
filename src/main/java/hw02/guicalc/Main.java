package hw02.guicalc;

import hw02.operator.BinaryOperator;
import hw02.operator.UnaryOperator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Main program that runs the GUI Calculator
 */
public class Main {
	/**
	 * The main method to run the GUI Calculator
	 * @param args : do not take in any arguments from the command line
	 */
    public static void main(String[] args) {
        // TODO: Replace null with your own unary operators. Use a Linked HashSet so operators are displayed in order.
        Set<UnaryOperator> unaryOperators = new LinkedHashSet<>();
        
        // TODO: Replace null with your own binary operators. Use a Linked HashSet so operators are displayed in order
        Set<BinaryOperator> binaryOperators = new LinkedHashSet<>();
        
        new GuiCalculator(unaryOperators, binaryOperators);
    }
}
