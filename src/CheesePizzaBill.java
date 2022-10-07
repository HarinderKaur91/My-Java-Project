/* Write a program to prepare the bill for a pizza shop.
   Assume an order and work out the final bill.
   Take the Cheese Pizza prices as: Small Pizza: $15, Medium Pizza: $20, Large Pizza: $25
	For additional pepperoni topping: Pepperoni for Small Pizza: +$2, Pepperoni for Medium or Large Pizza: +$3
	Extra cheese for any size pizza: + $1
For eg: If the Pizza is medium, pepperoni with extra cheese the program should calculate the final bill as 20+3+1 = $24 and print as
“Your final bill is $24”
*/
public class CheesePizzaBill {
	public static void main(String[] args) {
		int smallPizzaPrice = 15;
		int mediumPizzaPrice = 20;
		int largePizzaPrice = 25;
		int finalBill;
		boolean isPepperoniAdded = false;
		boolean isextraChesseAdded = false;
		int smallPizzaPepperoni = 2;
		int mediumPizzaPepperoni = 3;
		int largePizzaPepperoni = 3;
		int extraCheese = 1;
		String pizzaSize = "medium";
		switch (pizzaSize) {
		case "small":
			if (isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered small pizza with Pepperoni topping and extra cheese");
				finalBill = smallPizzaPrice + smallPizzaPepperoni + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
			} else if (isPepperoniAdded && !isextraChesseAdded) {
				System.out.println("You have ordered small pizza with Pepperoni topping");
				finalBill = smallPizzaPrice + smallPizzaPepperoni;
				System.out.println("Your final bill is $" + finalBill);
			} else if (!isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered small pizza with extra cheese");
				finalBill = smallPizzaPrice + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
			} else {
				System.out.println("You have ordered small pizza");
				finalBill = smallPizzaPrice;
				System.out.println("Your final bill is $" + finalBill);
			}
			break;
		case "medium":
			if (isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered medium pizza with Pepperoni topping and extra cheese");
				finalBill = mediumPizzaPrice + mediumPizzaPepperoni + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
			} else if (isPepperoniAdded && !isextraChesseAdded) {
				System.out.println("You have ordered medium pizza with Pepperoni topping");
				finalBill = mediumPizzaPrice + mediumPizzaPepperoni;
				System.out.println("Your final bill is $" + finalBill);
			} else if (!isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered medium pizza with extra cheese");
				finalBill = mediumPizzaPrice + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
			} else {
				System.out.println("You have ordered medium pizza");
				finalBill = mediumPizzaPrice;
				System.out.println("Your final bill is $" + finalBill);
			}
			break;
		case "large":
			if (isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered large pizza with Pepperoni topping and extra cheese");
				finalBill = largePizzaPrice + largePizzaPepperoni + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;
			} else if (isPepperoniAdded && !isextraChesseAdded) {
				System.out.println("You have ordered large pizza with Pepperoni topping ");
				finalBill = largePizzaPrice + largePizzaPepperoni;
				System.out.println("Your final bill is $" + finalBill);
			} else if (!isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered large pizza with extra cheese");
				finalBill = largePizzaPrice + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
			} else {
				System.out.println("You have ordered large pizza");
				finalBill = largePizzaPrice;
				System.out.println("Your final bill is $" + finalBill);
			}
			break;
		default:
			System.out.println("enter valid pizza size");
			break;
		}

	}

}
