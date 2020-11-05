package hw02.guicalc;

<<<<<<< HEAD
import hw02.operator.BinaryOperator;
import hw02.operator.UnaryOperator;
=======
import hw02.operator.*;
>>>>>>> starter

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
<<<<<<< HEAD
        
        // TODO: Replace null with your own binary operators. Use a Linked HashSet so operators are displayed in order
        Set<BinaryOperator> binaryOperators = new LinkedHashSet<>();
=======
        unaryOperators.add(new AbsOperator());
        unaryOperators.add(new NegOperator());
        
        // TODO: Replace null with your own binary operators. Use a Linked HashSet so operators are displayed in order
        Set<BinaryOperator> binaryOperators = new LinkedHashSet<>();
        binaryOperators.add(new AddOperator());
        binaryOperators.add(new SubOperator());
        binaryOperators.add(new MulOperator());
        binaryOperators.add(new DivOperator());
        binaryOperators.add(new ExpOperator());
>>>>>>> starter
        
        new GuiCalculator(unaryOperators, binaryOperators);
    }
}
