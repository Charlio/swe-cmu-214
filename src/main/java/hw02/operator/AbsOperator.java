package hw02.operator;

public class AbsOperator implements UnaryOperator {

	@Override
	public double apply(double arg) {
<<<<<<< HEAD
		return 0;
	}
	@Override
	public String toString() {
		return "";
=======
		return Math.abs(arg);
	}
	@Override
	public String toString() {
		return "abs";
>>>>>>> starter
	}
}
