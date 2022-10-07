//	Write a program to check if the number is prime or not.
public class PrimeCheck2 {

	public static void main(String[] args) {

		int number = 13;
		int countFactors = 0;		//it will count factors of the number
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				countFactors += 1;
			}
		}
		if (countFactors == 2) {//if there are only 2 factors i.e. 1 and number itself, then it is prime
			System.out.println(number + " is prime number");
		} else if (countFactors > 2) {
			System.out.println(number + " is composite number");
		} else {
			System.out.println(number + " is neither prime nor composite");
		}

	}

}
