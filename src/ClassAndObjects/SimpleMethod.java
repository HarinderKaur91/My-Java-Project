package ClassAndObjects;

public class SimpleMethod {

	int num1 = 20; // variables of SimpleMethod class
	int num2 = 10;

	void addNumbers() { // creating method of SimpleMethod class
		int sum = num1 + num2;
		System.out.println("Addition of 2 numbers = " + sum);
	}

	void subtractNumbers() {
		int subtraction = num1 - num2;
		System.out.println("Subtraction of 2 numbers = " + subtraction);
	}

	void multiplyNumbers() {
		int product = num1 * num2;
		System.out.println("Multiplication of 2 numbers = " + product);
	}
}

