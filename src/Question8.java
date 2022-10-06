
public class Question8 {

	public static void main(String[] args) {
		
		int chocolateCount = 27;
		int counter = 0;
		
		while (chocolateCount <= 63) {
			System.out.println("Chocolates in box : "+ chocolateCount);
			chocolateCount += 5;
			++counter;
		}
		
		System.out.println("5 chocolates were added "+ counter + " times");

	}

}
