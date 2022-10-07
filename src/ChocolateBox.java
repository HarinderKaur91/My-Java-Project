/* Write a program that will keep adding 5 chocolates to a box
 *  which already has 27 chocolates and add a mechanism 
 *  that number of chocolates should never go above 63
 */

public class ChocolateBox {
	public static void main(String[] args) {
		int counter = 0;
		int chocolateInBox;
		int chocolateCount;
		for (chocolateCount = 27; chocolateCount <= 100; chocolateCount += 5) {
			System.out.println("Chocolates in box : " + chocolateCount);
			++counter;
			chocolateInBox = chocolateCount + 5;
			if (chocolateInBox > 63) {
				System.out.println("Maximum limit reached!You cannot add more chocolates in the box");
				break;
			}
		}
		System.out.println("5 chocolates were added " + counter + " times");
	}
}
