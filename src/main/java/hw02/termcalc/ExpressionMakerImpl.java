package hw02.termcalc;

import hw02.expression.BinaryExpression;
import hw02.expression.Expression;
import hw02.expression.NumExpression;
import hw02.expression.UnaryExpression;
import hw02.operator.*;

public class ExpressionMakerImpl implements ExpressionMaker {

	@Override
	public Expression sumExpression(Expression addend1, Expression addend2) {
		return new BinaryExpression(addend1, addend2, new AddOperator());
	}

	@Override
	public Expression differenceExpression(Expression op1, Expression op2) {
		return new BinaryExpression(op1, op2, new SubOperator());
	}

	@Override
	public Expression productExpression(Expression factor1, Expression factor2) {
		return new BinaryExpression(factor1, factor2, new MulOperator());
	}

	@Override
	public Expression divisionExpression(Expression dividend, Expression divisor) {
		return new BinaryExpression(dividend, divisor, new DivOperator());
	}

	@Override
	public Expression exponentiationExpression(Expression base, Expression exponent) {
		return new BinaryExpression(base, exponent, new ExpOperator());
	}

	@Override
	public Expression negationExpression(Expression operand) {
		return new UnaryExpression(operand, new NegOperator());
	}

	@Override
	public Expression absoluteValueExpression(Expression value) {
		return new UnaryExpression(value, new AbsOperator());
	}

	@Override
	public Expression numberExpression(double value) {
		return new NumExpression(value);
	}
}
