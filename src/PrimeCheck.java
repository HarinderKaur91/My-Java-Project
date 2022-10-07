//	Write a program to check if the number is prime or not.
public class PrimeCheck {

	public static void main(String[] args) {
		
		int i, j = 0;
		boolean isPrime = true;
		int number = 4;					
		j = number / 2;
		
		if (number == 0 || number == 1) {
			System.out.println(number + " is not prime number");
		} else {
			for (i = 2; i <= j; i++) {
				if (number % i == 0) {
					System.out.println(number + " is not prime number");
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				System.out.println(number + " is prime number");
			}
		} 
	}
}
