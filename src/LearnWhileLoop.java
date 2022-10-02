
public class LearnWhileLoop {

	public static void main(String[] args) {

		int num = 1;
		int counter = 0;
		System.out.println("Numbers divisible by 3 and 5 both from 1 to 100 are");
		while (num <= 100) {
			if (num % 3 == 0 && num % 5 == 0) {
				System.out.print(num + " ");
				++counter;
				System.out.println(counter);

			}
			num++;
		}
		System.out.println("There are " + counter + " such numbers");

	}
}
