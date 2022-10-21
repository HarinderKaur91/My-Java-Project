package AssignmentWeek7;

import java.util.Scanner;

public class MainClassCruise {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CruiseDetails scenicCruise = new CruiseDetails("Scenic Cruise", 43.99, 12.99, 3);
		CruiseDetails sunsetCruise = new CruiseDetails("Sunset Cruise", 52.99, 15.99, 1);
		CruiseDetails discoveryCruise = new CruiseDetails("Discovery Cruise", 39.99, 9.99, 4);
		CruiseDetails mysteryCruise = new CruiseDetails("Mystery Cruise", 45.99, 12.99, 2);

		String cruiseName = " ";
		int numberOfCruiseAttempts = 0;
		String doYouWantToContinue = " ";
		String doYouWantToPreBookMeal = " ";
		int numberOfMealAttempts = 0;
		int numberOfAdults = 0;
		int numberOfChildren = 0;
		int numberOfChildrenAbove5 = 0;

		do {
			System.out.println(
					"We offer 4 different packages as displayed below. Please enter the cruise that you want to select.\n"
							+ "Scenic Cruise\n" + "Sunset Cruise\n" + "Discovery Cruise\n" + "Mystery Cruise");

			cruiseName = sc.nextLine();
			while (!(cruiseName.equalsIgnoreCase("Scenic Cruise") || cruiseName.equalsIgnoreCase("Sunset Cruise")
					|| cruiseName.equalsIgnoreCase("Discovery Cruise")
					|| cruiseName.equalsIgnoreCase("Mystery Cruise"))) {// loop to handle invalid inputs

				numberOfCruiseAttempts++;
				if (numberOfCruiseAttempts > 2) {
					System.out.println("Attempts exceeded! Start again");
					System.exit(0);
				}
				System.out.println("You have entered INVALID cruise name. Please choose from valid names");
				cruiseName = sc.nextLine();
			}
			if (cruiseName.equalsIgnoreCase("Scenic Cruise")) {
				scenicCruise.getDaysAndCruisePrice(cruiseName);
			} else if (cruiseName.equalsIgnoreCase("Sunset Cruise")) {
				sunsetCruise.getDaysAndCruisePrice(cruiseName);
			} else if (cruiseName.equalsIgnoreCase("Discovery Cruise")) {
				discoveryCruise.getDaysAndCruisePrice(cruiseName);
			} else if (cruiseName.equalsIgnoreCase("Mystery Cruise")) {
				mysteryCruise.getDaysAndCruisePrice(cruiseName);
			}
			System.out.println(
					"\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
			doYouWantToContinue = sc.nextLine();
		} while (!doYouWantToContinue.equalsIgnoreCase("Y"));

		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();

		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		
		int[] age = new int[numberOfChildren];
		for (int i = 0; i < numberOfChildren; i++) {
			if (numberOfChildren > 0) {
				System.out.println("Enter the age of child " + (i + 1));
				age[i] = sc.nextInt();
				if (age[i] > 5) {
					numberOfChildrenAbove5++;
				}
			}
		}

		System.out.println("\nAll our cruises have food service on board.");
		System.out.println("Do you want to pre-book for dinner buffet meals at 20.99 per day for adults");
		System.out.println("and 4.99 per day for kids above 5?(Yes/No)");

		doYouWantToPreBookMeal = sc.next();
		while (!((doYouWantToPreBookMeal.equalsIgnoreCase("Yes")) || (doYouWantToPreBookMeal.equalsIgnoreCase("No")))) {
			numberOfMealAttempts++;
			if (numberOfMealAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter yes or no");
			doYouWantToPreBookMeal = sc.next();
		}
		
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Yes")) {
			switch (cruiseName) {
			case "Scenic Cruise":
			case "scenic cruise":
				scenicCruise.calculateCruisePriceForAdults(numberOfAdults);
				scenicCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				scenicCruise.calculateBuffetPriceForAdults(numberOfAdults);
				scenicCruise.calculateBuffetPriceForChildrenAbove5(numberOfChildrenAbove5);
				scenicCruise.calculateTotalPriceWithMeal();
				scenicCruise.calcualteHST();
				scenicCruise.calculateFinalPrice();
				scenicCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			case "Sunset Cruise":
			case "sunset cruise":
				sunsetCruise.calculateCruisePriceForAdults(numberOfAdults);
				sunsetCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				sunsetCruise.calculateBuffetPriceForAdults(numberOfAdults);
				sunsetCruise.calculateBuffetPriceForChildrenAbove5(numberOfChildrenAbove5);
				sunsetCruise.calculateTotalPriceWithMeal();
				sunsetCruise.calcualteHST();
				sunsetCruise.calculateFinalPrice();
				sunsetCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			case "Discovery Cruise":
			case "discovery cruise":
				discoveryCruise.calculateCruisePriceForAdults(numberOfAdults);
				discoveryCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				discoveryCruise.calculateBuffetPriceForAdults(numberOfAdults);
				discoveryCruise.calculateBuffetPriceForChildrenAbove5(numberOfChildrenAbove5);
				discoveryCruise.calculateTotalPriceWithMeal();
				discoveryCruise.calcualteHST();
				discoveryCruise.calculateFinalPrice();
				discoveryCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			case "Mystery Cruise":
			case "mystery cruise":
				mysteryCruise.calculateCruisePriceForAdults(numberOfAdults);
				mysteryCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				mysteryCruise.calculateBuffetPriceForAdults(numberOfAdults);
				mysteryCruise.calculateBuffetPriceForChildrenAbove5(numberOfChildrenAbove5);
				mysteryCruise.calculateTotalPriceWithMeal();
				mysteryCruise.calcualteHST();
				mysteryCruise.calculateFinalPrice();
				mysteryCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			default:
				System.out.println("Invalid Cruise Name!");
				break;
			}

		} else if (doYouWantToPreBookMeal.equalsIgnoreCase("No")) {
			switch (cruiseName) {
			case "Scenic Cruise":
			case "scenic cruise":
				scenicCruise.calculateCruisePriceForAdults(numberOfAdults);
				scenicCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				scenicCruise.calculateTotalPriceWithoutMeal();
				scenicCruise.calcualteHST();
				scenicCruise.calculateFinalPrice();
				scenicCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			case "Sunset Cruise":
			case "sunset cruise":
				sunsetCruise.calculateCruisePriceForAdults(numberOfAdults);
				sunsetCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				sunsetCruise.calculateTotalPriceWithoutMeal();
				sunsetCruise.calcualteHST();
				sunsetCruise.calculateFinalPrice();
				sunsetCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			case "Discovery Cruise":
			case "discovery cruise":
				discoveryCruise.calculateCruisePriceForAdults(numberOfAdults);
				discoveryCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				discoveryCruise.calculateTotalPriceWithoutMeal();
				discoveryCruise.calcualteHST();
				discoveryCruise.calculateFinalPrice();
				discoveryCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			case "Mystery Cruise":
			case "mystery cruise":
				mysteryCruise.calculateCruisePriceForAdults(numberOfAdults);
				mysteryCruise.calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				mysteryCruise.calculateTotalPriceWithoutMeal();
				mysteryCruise.calcualteHST();
				mysteryCruise.calculateFinalPrice();
				mysteryCruise.displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5);
				break;
			default:
				System.out.println("Invalid Cruise Name!");
				break;
			}
		}
	}
}
