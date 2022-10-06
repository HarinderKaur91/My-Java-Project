
public class CheesePizzaBill {

	public static void main(String[] args) {

		int smallPizzaPrice = 15;
		int mediumPizzaPrice = 20;
		int largePizzaPrice = 25;
		int finalBill;

		boolean isPepperoniAdded = true;
		boolean isextraChesseAdded = true;

		int smallPizzaPepperoni = 2;
		int mediumPizzaPepperoni = 3;
		int largePizzaPepperoni = 3;
		int extraCheese = 1;

		String pizzaSize = "small";
		switch (pizzaSize) {
		case "small":
		
			if (isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered small pizza with Pepperoni topping and extra cheese");

				finalBill = smallPizzaPrice + smallPizzaPepperoni + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;
			} else if (isPepperoniAdded && !isextraChesseAdded) {
				System.out.println("You have ordered small pizza with Pepperoni topping");
				finalBill = smallPizzaPrice + smallPizzaPepperoni;
				System.out.println("Your final bill is $" + finalBill);
				break;
			} else if (!isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered small pizza with extra cheese");
				finalBill = smallPizzaPrice + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;

			} else {
				System.out.println("You have ordered small pizza");
				finalBill = smallPizzaPrice;
				System.out.println("Your final bill is $" + finalBill);
				break;
			}
		case "medium":
	
			if (isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered medium pizza with Pepperoni topping and extra cheese");
				finalBill = mediumPizzaPrice + mediumPizzaPepperoni + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;
			}
			else if (isPepperoniAdded && !isextraChesseAdded) {
				System.out.println("You have ordered medium pizza with Pepperoni topping");
				finalBill = mediumPizzaPrice + mediumPizzaPepperoni;
				System.out.println("Your final bill is $" + finalBill);
				break;
			} else if (!isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered medium pizza with extra cheese");
				finalBill = mediumPizzaPrice + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;

			} else {
				System.out.println("You have ordered medium pizza");
				finalBill = mediumPizzaPrice;
				System.out.println("Your final bill is $" + finalBill);
				break;
			}
		case "large":
		
			if (isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered large pizza with Pepperoni topping and extra cheese");
				finalBill = largePizzaPrice + largePizzaPepperoni + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;
			}
			else if (isPepperoniAdded && !isextraChesseAdded) {
				System.out.println("You have ordered large pizza with Pepperoni topping ");

				finalBill = largePizzaPrice + largePizzaPepperoni;
				System.out.println("Your final bill is $" + finalBill);
				break;
			} else if (!isPepperoniAdded && isextraChesseAdded) {
				System.out.println("You have ordered large pizza with extra cheese");

				finalBill = largePizzaPrice + extraCheese;
				System.out.println("Your final bill is $" + finalBill);
				break;

			} else {
				System.out.println("You have ordered large pizza");

				finalBill = largePizzaPrice;
				System.out.println("Your final bill is $" + finalBill);
				break;
			}
		default:
			System.out.println("enter valid pizza size");
			break;
		}

	}

}
