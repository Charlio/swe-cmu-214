package hw02.expression;

import hw02.operator.UnaryOperator;

public class UnaryExpression implements Expression {

	private final Expression operand;
	private final UnaryOperator operator;

	public UnaryExpression(Expression operand, UnaryOperator operator) {
		this.operand = operand;
		this.operator = operator;
	}
	
	@Override
	public double eval() {
		return operator.apply(operand.eval());
	}
	
	@Override
	public String toString() {
		return operator.toString() + "(" + operand.toString() + ")";
	}

}
