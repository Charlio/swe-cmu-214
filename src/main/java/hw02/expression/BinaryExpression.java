package hw02.expression;

import hw02.operator.BinaryOperator;

public class BinaryExpression implements Expression {

	private final Expression arg1, arg2;
	private final BinaryOperator operator;

	public BinaryExpression(Expression arg1, Expression arg2, BinaryOperator operator) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.operator = operator;
	}

	@Override
	public double eval() {
		return operator.apply(arg1.eval(), arg2.eval());
	}

	@Override
	public String toString() {
		return operator.toString() + "(" + arg1.toString() + ", " + arg2.toString() + ")";
	}
}
