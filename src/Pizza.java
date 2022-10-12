import java.util.Scanner;

public class Pizza {
	public static void main(String[] args) {
		int billSmall = 0;
		int billMedium = 0;
		int billLarge = 0;
		int totalBill = 0;
		int numberOfSmallPizza = 0;
		int numberOfMediumPizza = 0;
		int numberOfLargePizza = 0;
		Scanner objScanner = new Scanner(System.in);
		String addPepperoni;
		String addExtraCheese;
		System.out.println("How many types of pizzas do you want?\nEnter Number :");
		int typesOfPizzas = objScanner.nextInt();
		while (typesOfPizzas > 3) {
			System.out.println("You can have maximum 3 sizes in pizza. " + "Please enter the number again");
			typesOfPizzas = objScanner.nextInt();
		}
		for (int i = 1; i <= typesOfPizzas; i++) {
			System.out.println("Please enter size of pizza type" + i + " -Small, Medium or Large");
			String pizzaSize = objScanner.next();
			while (!(pizzaSize.equals("Small") || pizzaSize.equals("Medium") || pizzaSize.equals("Large"))) {
				System.out.println("enter valid pizza size");
				pizzaSize = objScanner.next();
			}
			switch (pizzaSize) {
			case "Small":
				System.out.println("How many Small?: ");
				numberOfSmallPizza = objScanner.nextInt();
				if (numberOfSmallPizza > 0) {
					System.out.println("Do you want to add pepperoni ? Choose Y or N");
					addPepperoni = objScanner.next();
					System.out.println("Do you want to add extra cheese ? Choose Y or N");
					addExtraCheese = objScanner.next();
					billSmall += 15;
					if (addPepperoni.equalsIgnoreCase("Y")) {
						billSmall += 2;
					}
					if (addExtraCheese.equalsIgnoreCase("Y")) {
						billSmall += 1;
					}
				}
				System.out.println("Bill for small pizza =$" + numberOfSmallPizza*billSmall);
				break;
			case "Medium":
				System.out.println("How many Medium?: ");
				numberOfMediumPizza = objScanner.nextInt();
				if (numberOfMediumPizza > 0) {
					System.out.println("Do you want to add pepperoni ? Choose Y or N");
					addPepperoni = objScanner.next();
					System.out.println("Do you want to add extra cheese ? Choose Y or N");
					addExtraCheese = objScanner.next();
					billMedium += 20;
					if (addPepperoni.equalsIgnoreCase("Y")) {
						billMedium += 3;
					}
					if (addExtraCheese.equalsIgnoreCase("Y")) {
						billMedium += 1;
					}
				}
				System.out.println("Bill for medium pizza =$" + numberOfMediumPizza*billMedium);

				break;
			case "Large":
				System.out.println("How many Large?: ");
				numberOfLargePizza = objScanner.nextInt();
				if (numberOfLargePizza > 0) {
					System.out.println("Do you want to add pepperoni ? Choose Y or N");
					addPepperoni = objScanner.next();
					System.out.println("Do you want to add extra cheese ? Choose Y or N");
					addExtraCheese = objScanner.next();

					billLarge += 25;
					if (addPepperoni.equalsIgnoreCase("Y")) {
						billLarge += 3;
					}
					if (addExtraCheese.equalsIgnoreCase("Y")) {
						billLarge += 1;
					}
				}
				System.out.println("Bill for large pizza = $" + numberOfLargePizza*billLarge);
				break;
			default:
				System.out.println("Only Small, Medium and Large pizza sizes are avaliable");
				break;
			}
		}
		totalBill = (numberOfSmallPizza * billSmall) + (numberOfMediumPizza * billMedium)
				+ (numberOfLargePizza * billLarge);
		System.out.println("You final bill is $" +  totalBill);
	}
}
