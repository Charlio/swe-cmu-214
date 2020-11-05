package hw02.operator;

public class AbsOperator implements UnaryOperator {

	@Override
	public double apply(double arg) {
		return Math.abs(arg);
	}
	@Override
	public String toString() {
		return "abs";
	}
}
