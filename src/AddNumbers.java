import java.util.Scanner;

public class AddNumbers {

	public static void main(String[] args) {
		int number1 = 0;
		int number2 = 0;
		int number3 = 0;
		String name = "";
		double interestRate = 0.0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number");
		number1 = sc.nextInt();

		System.out.println("enter second number");
		number2 = sc.nextInt();

		System.out.println("enter third number");
		number3 = sc.nextInt();

		int number4 = number1 + number2 + number3;
		System.out.println("Addition of 3 numbers = " + number4);

		System.out.println("enter your name");
		name = sc.next();
		System.out.println(name);
		
		System.out.println("enter interestRate");
		interestRate = sc.nextDouble();
		System.out.println(interestRate);

	}

}
