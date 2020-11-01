package hw02.zerofinder;
import hw02.expression.Expression;
import hw02.expression.VariableExpression;

public class DerivativeExpression implements Expression {
	
	/**
	   * Creates an expression representing the derivative of the specified
	   * function with respect to the specified variable.
	   *
	   * @param fn the function whose derivative this expression represents
	   * @param independentVar the variable with respect to which we’re
	   *   differentiating
	   */
	  public DerivativeExpression(Expression fn, VariableExpression independentVar) {
	  }
	
	@Override
	public double eval() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
