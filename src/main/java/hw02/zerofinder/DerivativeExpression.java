package hw02.zerofinder;

import hw02.expression.Expression;
import hw02.expression.VariableExpression;

public class DerivativeExpression implements Expression {

	private static final double DELTA_X = 1e-9;
	private final Expression fn;
	private final VariableExpression var;

	/**
	 * Creates an expression representing the derivative of the specified
	 * function with respect to the specified variable.
	 *
	 * @param fn the function whose derivative this expression represents
	 * @param independentVar the variable with respect to which we’re
	 *   differentiating
	 */
	public DerivativeExpression(Expression fn, VariableExpression independentVar) {
		this.fn = fn;
		this.var = independentVar;
	}
	
	@Override
	public double eval() {
		double xVar = var.eval();
		var.store(xVar + DELTA_X);
		double left = fn.eval();
		var.store(xVar);
		double right = fn.eval();
		return (left - right) / DELTA_X;
	}
	
	@Override
	public String toString() {
		return "(" + fn.toString() + ")'";
	}
}
