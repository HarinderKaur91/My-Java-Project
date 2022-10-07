
public class CalculatorSwitchCase {

	public static void main(String[] args) {
		
		int num1 = 4;
		int num2 = 5;
		char operator='/';
		
		switch (operator) {
		case '+':
			System.out.println("Addition of num1 and num2 = "+(num1+num2));
			break;
		case '-':
			System.out.println("Subtraction of num1 and num2 = "+ (num1-num2));
			break;
		case '*':
			System.out.println("Multiplication of num1 and num2 = "+(num1*num2));
			break;
		case '/':
			if(num2 == 0) {
				System.out.println("You cannot divide the number by zero");
			}else {
			System.out.println("Division of num1 and num2 = "+ (num1/num2));}
			break;
		case '%' :
			if(num1 !=0 && num2 == 0) {
				System.out.println("You cannot find remainder by dividing the number by zero");
			}else {
			System.out.println("Modulus of num1 and num2 = "+ (num1%num2));}
			break;

		default:
			System.out.println("enter a valid operator");
			break;
		}

	}

}
