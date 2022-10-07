
public class MultiplicationTable {

	public static void main(String[] args) {
		
		int number = 7;
		int result;
		
		System.out.println("Multiplication table of " + number + " is");
		
		for (int i = 1; i <= 10; i++) {
			result = number * i;
			System.out.println(number + " * " + i + " = " + result);
		}
	}
}
