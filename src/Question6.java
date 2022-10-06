
public class Question6 {

	public static void main(String[] args) {
		
		int num1 = 4;
		int num2 = 2;
		String operator="+";
		
		switch (operator) {
		case "+":
			System.out.println("Addition of num1 and num2 = "+(num1+num2));
			break;
		case "-":
			System.out.println("Subtraction of num1 and num2 = "+ (num1-num2));
			break;
		case "*":
			System.out.println("Multiplication of num1 and num2 = "+(num1*num2));
			break;
		case "/":
			System.out.println("Division of num1 and num2 = "+ (num1/num2));
			break;
		case "%" :
			System.out.println("Modulus of num1 and num2 = "+ (num1%num2));
			break;

		default:
			System.out.println("enter a valid operator");
			break;
		}

	}

}
