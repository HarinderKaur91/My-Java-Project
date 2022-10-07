/* Write a program that will keep adding 5 chocolates to a box
 *  which already has 27 chocolates and add a mechanism 
 *  that number of chocolates should never go above 63
 */
/*public class ChocolateBox {
	public static void main(String[] args) {
		int chocolateCount = 27;
		int counter = 0;
		while (chocolateCount <= 63) {
			System.out.println("Chocolates in box : " + chocolateCount);
			chocolateCount += 5;
			++counter;
		}
		System.out.println("5 chocolates were added " + counter + " times");
	}
}*/
public class ChocolateBox {
	public static void main(String[] args) {
		int counter = 0;
		for (int chocolateCount = 27; chocolateCount <= 63; chocolateCount += 5) {
			System.out.println("Chocolates in box : " + chocolateCount);
			++counter;
		}
		System.out.println("5 chocolates were added " + counter + " times");
	}
}
