package hw02.zerofinder;

import hw02.expression.Expression;
import hw02.expression.VariableExpression;

/**
 * Finds zeros of arbitrary functions using Newton's method.
 */
public class ZeroFinder {
	// TODO: Write the zero method

	/**
	 * Returns a zero of the specified function using Newton’s method with
	 * approxZero as the initial estimate.
	 *
	 * @param fn
	 *            the function whose zero is to be found
	 * @param x
	 *            the independent variable of the function
	 * @param approxZero
	 *            initial approximation for the zero of the function
	 * @param tolerance
	 *            how close to zero f(the returned value) has to be
	 * @return a value x for which f(x) is "close to zero" (<= tolerance)
	 */
	public static double zero(Expression fn, VariableExpression x, double approxZero, double tolerance) {
		return 0;
	}
}
