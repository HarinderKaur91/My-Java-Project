/* Write a program to prepare the bill for a pizza shop.
 Assume an order and work out the final bill.
 Take the Cheese Pizza prices as: Small Pizza: $15, Medium Pizza: $20, Large Pizza: $25
 For additional pepperoni topping: Pepperoni for Small Pizza: +$2, Pepperoni for Medium or Large Pizza: +$3
 Extra cheese for any size pizza: + $1
For eg: If the Pizza is medium, pepperoni with extra cheese the program should calculate the final bill as 20+3+1 = $24 and print as
“Your final bill is $24”
*/
public class PizzaBillUpdated {
	public static void main(String[] args) {
		int smallPizzaPrice = 15;
		int mediumPizzaPrice = 20;
		int largePizzaPrice = 25;
		int totalBill;
		boolean isPepperoniAdded = false;
		boolean isextraChesseAdded = false;
		int smallPizzaPepperoni = 0;
		int mediumPizzaPepperoni = 0;
		int largePizzaPepperoni = 0;
		int extraCheese = 0;
		String pizzaSize = "large";
		switch (pizzaSize) {
		case "small":
			System.out.println("You have ordered small pizza");
			if (isPepperoniAdded) {
				smallPizzaPepperoni=2;
			}
			if (isextraChesseAdded) {
				extraCheese=1;
			}
			totalBill = smallPizzaPrice+smallPizzaPepperoni+extraCheese;
			System.out.println("Total Bill = $" + totalBill);
			break;
		case "medium":
			System.out.println("You have ordered medium pizza");
			if (isPepperoniAdded) {
				mediumPizzaPepperoni=3;
			}
			if (isextraChesseAdded) {
				extraCheese=1;
			}
			totalBill = mediumPizzaPrice+mediumPizzaPepperoni+extraCheese;
			System.out.println("Total Bill = $" + totalBill);
			break;
		case "large":
			System.out.println("You have ordered large pizza");
			if (isPepperoniAdded) {
				largePizzaPepperoni=3;
			}
			if (isextraChesseAdded) {
				extraCheese=1;
			}
			totalBill = largePizzaPrice+largePizzaPepperoni+extraCheese;
			System.out.println("Total Bill = $" + totalBill);
			break;
		default:
			System.out.println("enter valid pizza size");
			break;
		}
	}
}
