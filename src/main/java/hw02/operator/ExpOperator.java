package hw02.operator;

public class ExpOperator implements BinaryOperator {

	@Override
	public double apply(double arg1, double arg2) {
		return Math.pow(arg1, arg2);
	}

	@Override
	public String toString() {
		return "exp";
	}
}
