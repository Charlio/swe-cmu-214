package hw02.operator;

public class AddOperator implements BinaryOperator {

	@Override
	public double apply(double arg1, double arg2) {
		return arg1 + arg2;
	}
	@Override
	public String toString() {
		return "+";
	}
}
