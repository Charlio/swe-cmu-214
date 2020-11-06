package hw02.expression;

public class NumExpression implements Expression {

	private final double val;

	public NumExpression(double val) {
		this.val = val;
	}
	
	@Override
	public double eval() {
		return val;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
