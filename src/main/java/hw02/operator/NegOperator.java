package hw02.operator;

public class NegOperator implements UnaryOperator {

	@Override
	public double apply(double arg) {
		return -arg;
	}

	@Override
	public String toString() {
		return "-";
	}
}
