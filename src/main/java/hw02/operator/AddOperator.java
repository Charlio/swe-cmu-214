package hw02.operator;

public class AddOperator implements BinaryOperator {

	@Override
	public double apply(double arg1, double arg2) {
<<<<<<< HEAD
		return 0;
	}
	@Override
	public String toString() {
		return "";
=======
		return arg1 + arg2;
	}
	@Override
	public String toString() {
		return "+";
>>>>>>> starter
	}
}
